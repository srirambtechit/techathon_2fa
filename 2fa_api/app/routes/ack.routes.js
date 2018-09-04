module.exports = (app) => {
    const contoller = require('../controllers/ack.controller.js');
    app.post('/rbs2fa/api/acks', contoller.ackReq);
}
