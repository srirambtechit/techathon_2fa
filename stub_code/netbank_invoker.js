var jsdom = require('jsdom');
const { JSDOM } = jsdom;
const { window } = new JSDOM();
const { document } = (new JSDOM('')).window;
global.document = document;

var $ = jQuery = require('jquery')(window);


// Trying to hit netbanking ajax call
$.ajax({
  url: 'http://localhost:3000/rbs2fa/api/auths/4332',
  method: 'get'
}).done(function(msg) {
  console.log('Status: ' + msg);
});
