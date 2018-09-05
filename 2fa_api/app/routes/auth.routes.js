module.exports = (app) => {
    const controller = require('../controllers/auth.controller.js');
    app.post('/rbs2fa/api/auths', controller.authReq);
    app.get('/rbs2fa/api/auths/:mobileId', controller.findAuth);
    app.get('/rbs2fa/api/test', controller.test);
}
