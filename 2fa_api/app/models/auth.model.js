const mongoose = require('mongoose');

const AuthSchema = mongoose.Schema({
  customerId: { type: String, required: true, unique: true },
  mobileId: { type: Number, max: 9999, required: true, unique: true },
  transaction: {
    id: { type: String },
    toAccount: { type: Number },
    amount: { type: Number }
  }
}, {
  timestamps: true
});
module.exports = mongoose.model('auths', AuthSchema);
