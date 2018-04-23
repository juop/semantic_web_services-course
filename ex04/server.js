var express = require('express'),
    app = express(),
    port = process.env.PORT || 3000,
    bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

// Register routes.
app.use('/users', require('./app/routes/users'));
app.use('/hotels', require('./app/routes/hotels'));
app.use('/bookings', require('./app/routes/bookings'));

app.listen(port, () => {
    console.log('RESTful Web Server started on *:' + port);
});