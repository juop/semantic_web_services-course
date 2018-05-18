var w = require('../utility/write');
var utils = require('../utility/utils');
var rooms = require('../rooms.json');

module.exports = function() {
  var bookings = [];
  var pmts = ['paypal', 'credit', 'debit', 'cash']

  for (var id = 0; id < 1000; id++) {
    var booking_date = utils.getDate();
    var arrival_date = utils.getDate(booking_date);

    bookings.push({
      id: id,
      date: booking_date,
      arrival_date: arrival_date,
      departure_date: utils.getDate(arrival_date),
      payment_method: pmts[Math.floor(Math.random() * pmts.length)],
      amount: parseFloat((Math.random() * 500 + 20).toFixed(2)),
      user: utils.config.api + '/users/' + Math.floor(Math.random() * 1000),
      rooms: utils.fillArray(1, 5, rooms.length, 'rooms'),
    });
  }

  w("./bookings.json", JSON.stringify(bookings));
}