const Auth = require('../models/auth.model.js');
const Ack = require('../models/ack.model.js');
const threshold = 6;
const delay = 10000; // 10 seconds

exports.authReq = (req, res) => {

    var authObject = { request: req, response: res, counter: 0 };

    if(!req.body) {
        return res.status(400).send({
            message: "Auth content can not be empty"
        });
    }

    const auth = new Auth(req.body);
    auth.save()
    .then(data => {
      console.log('finding ack...');
      authObject.timer = setInterval(findAck, delay, authObject);
      console.log('Timer : ' + authObject.timer);
    }).catch(err => {
        res.status(500).send({
            message: err.message || "Some error occurred while creating the Auth"
        });
    });
};

function findAck(args) {
  Ack.findOne({mobileId: args.request.body.mobileId})
  .then(ack => {
      args.counter++;
      console.log('counter : ' + args.counter);
      console.log(JSON.stringify(ack));
      if(ack != null || args.counter == threshold ) {
          clearTimeout(args.timer);
          args.ack = ack;
          removeAuth(args);
      }
  }).catch(err => {
      console.log(err.message || 'Error occurred during Ack finding');
      return {};
  });
}

function removeAuth(args) {
  Auth.deleteOne({mobileId: args.request.body.mobileId})
  .then(auth => {
    Ack.deleteOne({mobileId: args.request.body.mobileId})
    .then(ack => {
      return args.response.status(200).send(args.ack == null ? {} : args.ack);
    }).catch(err => {
      console.log(err.message || 'Error occurred during Ack deletion');
      return {};
    });
  }).catch(err => {
    console.log(err.message || 'Error occurred during Auth deletion');
    return {};
  });
}

exports.test = (req, res) => {
  return res.status(200).send({message: "Testing"});
}
