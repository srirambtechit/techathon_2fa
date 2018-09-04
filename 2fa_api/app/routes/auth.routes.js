module.exports = (app) => {
    const contoller = require('../controllers/auth.controller.js');
    app.post('/rbs2fa/api/auths', contoller.authReq);
}
