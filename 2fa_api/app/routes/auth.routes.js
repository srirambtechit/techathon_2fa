module.exports = (app) => {
    const contoller = require('../controllers/auth.controller.js');
    app.post('/rbs2fa/api/auths', contoller.authReq);
    app.get('/rbs2fa/api/test', contoller.test);
}
