const Ack = require('../models/ack.model.js');

exports.ackReq = (req, res) => {

    if(!req.body) {
        return res.status(400).send({
            message: "Ack content can not be empty"
        });
    }

    const ack = new Ack(req.body);
    ack.save()
    .then(data => {
        res.send(data);
    }).catch(err => {
        res.status(500).send({
            message: err.message || "Some error occurred while creating Ack"
        });
    });
};
