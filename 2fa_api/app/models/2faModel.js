const mongoose = require('mongoose');

const AuthSchema = mongoose.Schema({
  userId: { type: String, required: true },
  mobileId: { type: Number, max: 4, required: true },
  transaction: {
    id: { type: String },
    toAccount: { type: Number },
    amount: { type: Number }
  }
}, {
  timestamps: true
});
module.exports = mongoose.model('auths', AuthSchema);

const AckSchema = mongoose.Schema({
  userId: { type: String, required: true },
  mobileId: { type: Number, max: 4, required: true },
  transaction: {
    id: { type: String },
    acknowledged: { type: Boolean }
  }
});
module.exports = mongoose.model('acks', AckSchema);
