const mongoose = require('mongoose');

const AckSchema = mongoose.Schema({
  customerId: { type: String, required: true, unique: true },
  mobileId: { type: Number, max: 9999, required: true, unique: true },
  transaction: {
    id: { type: String },
    acknowledged: { type: Boolean }
  }
});
module.exports = mongoose.model('acks', AckSchema);
