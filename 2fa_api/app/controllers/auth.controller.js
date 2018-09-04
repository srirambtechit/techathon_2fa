const Auth = require('../models/auth.model.js');
const Ack = require('../models/ack.model.js');

exports.authReq = (req, res) => {

    if(!req.body) {
        return res.status(400).send({
            message: "Auth content can not be empty"
        });
    }

    console.log(JSON.stringify(req.body));

    const auth = new Auth(req.body);
    auth.save()
    .then(data => {
      console.log('finding ack...');
      console.log('req.body.mobileId : ' + req.body.mobileId);





    }).catch(err => {
        res.status(500).send({
            message: err.message || "Some error occurred while creating the Auth"
        });
    });

    // finding the acknowledgement for the particular transaction
    console.log('mobileId : ' + req.body.mobileId);

};

function findAck(mobileId) {
  Ack.findOne({mobileId: mobileId})
  .then(ack => {
      console.log('Ack then block');
      if(!ack) {
          return res.status(404).send({
              message: "Auth not found with id " + req.body.mobileId
          });
      }
      res.send(ack);
  }).catch(err => {
      console.log('Ack catch block');
      if(err.kind === 'ObjectId') {
          return res.status(404).send({
              message: "Auth not found with id " + req.body.mobileId
          });
      }
      return res.status(500).send({
          message: "Error retrieving auth with id " + req.body.mobileId
      });
  });
}
