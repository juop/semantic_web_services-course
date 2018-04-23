# REST API

## Table of Contents
- [Users](#users)
- [Hotels](#hotels)
- [Rooms](#rooms)
- [Bookings](#bookings)
- [Payments](#payments)
- [Reviews](#reviews)
- [Facilities](#facilities)
- [Facility Categories](#facility-categories)
- [Location](#location)
- [Media (Photos)](#media-photos)

## Users
| URI                 | HTTP   | Body  | Description                |
| :------------------ | :----: | :---: | :------------------------- |
| /users              | GET    | -     | Get a list of all users    |
| /users/:id          | GET    | -     | Get details of a user      |
| /users              | POST   | JSON  | Add a new user             |
| /users              | PUT    | JSON  | Update a user              |
| /users/:id          | DELETE | -     | Delete a user              |
| /users/:id/bookings | GET    | -     | Get all bookings of a user |
| /users/:id/payments | GET    | -     | Get all payments of a user |
| /users/:id/reviews  | GET    | -     | Get all reviews of a user  |

## Hotels
| URI                    | HTTP   | Body  | Description                                      |
| :--------------------- | :----: | :---: | :----------------------------------------------- |
| /hotels                | GET    | -     | Get a list of all hotels                         |
| /hotels/:id            | GET    | -     | Get details of a hotel                           |
| /hotels                | POST   | JSON  | Add a new hotel                                  |
| /hotels                | PUT    | JSON  | Update a hotel                                   |
| /hotels/:id            | DELETE | -     | Delete a hotel                                   |
| /hotels/:id/users      | GET    | -     | Get a list of all users staying in a hotel       |
| /hotels/:id/rooms      | GET    | -     | Get a list of all rooms of a hotel               |
| /hotels/:id/bookings   | GET    | -     | Get a list of all current bookings of a hotel    |
| /hotels/:id/payments   | GET    | -     | Get a list of all completed payments of a hotel  |
| /hotels/:id/reviews    | GET    | -     | Get a list of all user reviews of a hotel        |
| /hotels/:id/facilities | GET    | -     | Get a list of all facilities provided by a hotel |
| /hotels/:id/media      | GET    | -     | Get a list of all media (photos) of a hotel      |

## Rooms
| URI        | HTTP   | Body  | Description                   |
| :--------- | :----: | :---: | :---------------------------- |
| /rooms     | GET    | -     | Get a list of all hotel rooms |
| /rooms/:id | GET    | -     | Get details of a hotel room   |
| /rooms     | POST   | JSON  | Add a new hotel room          |
| /rooms     | PUT    | JSON  | Update a hotel room           |
| /rooms/:id | DELETE | -     | Delete a hotel room           |

## Bookings
| URI           | HTTP   | Body  | Description                |
| :------------ | :----: | :---: | :------------------------- |
| /bookings     | GET    | -     | Get a list of all bookings |
| /bookings/:id | GET    | -     | Get details of a booking   |
| /bookings     | POST   | JSON  | Add a new booking          |
| /bookings     | PUT    | JSON  | Update a booking           |
| /bookings/:id | DELETE | -     | Delete a booking           |

## Payments
| URI           | HTTP   | Body  | Description                |
| :------------ | :----: | :---: | :------------------------- |
| /payments     | GET    | -     | Get a list of all payments |
| /payments/:id | GET    | -     | Get details of a payment   |
| /payments     | POST   | JSON  | Add a new payment          |
| /payments     | PUT    | JSON  | Update a payment           |
| /payments/:id | DELETE | -     | Delete a payment           |

## Reviews
| URI          | HTTP   | Body  | Description                     |
| :----------- | :----: | :---: | :------------------------------ |
| /reviews     | GET    | -     | Get a list of all hotel reviews |
| /reviews/:id | GET    | -     | Get details of a hotel review   |
| /reviews     | POST   | JSON  | Add a new hotel review          |
| /reviews     | PUT    | JSON  | Update a hotel review           |
| /reviews/:id | DELETE | -     | Delete a hotel review           |

## Facilities
| URI             | HTTP   | Body  | Description                        |
| :-------------- | :----: | :---: | :--------------------------------- |
| /facilities     | GET    | -     | Get a list of all hotel facilities |
| /facilities/:id | GET    | -     | Get details of a hotel facility    |
| /facilities     | POST   | JSON  | Add a new hotel facility           |
| /facilities     | PUT    | JSON  | Update a hotel facility            |
| /facilities/:id | DELETE | -     | Delete a hotel facility            |

## Facility Categories
| URI             | HTTP   | Body  | Description                           |
| :-------------- | :----: | :---: | :------------------------------------ |
| /categories     | GET    | -     | Get a list of all facility categories |
| /categories/:id | GET    | -     | Get details of a facility category    |
| /categories     | POST   | JSON  | Add a new facility category           |
| /categories     | PUT    | JSON  | Update a facility category            |
| /categories/:id | DELETE | -     | Delete a facility category            |

## Location
| URI            | HTTP   | Body  | Description                       |
| :------------- | :----: | :---: | :-------------------------------- |
| /locations     | GET    | -     | Get a list of all hotel locations |
| /locations/:id | GET    | -     | Get details of a hotel location   |
| /locations     | POST   | JSON  | Add a new hotel location          |
| /locations     | PUT    | JSON  | Update a hotel location           |
| /locations/:id | DELETE | -     | Delete a hotel location           |

## Media (Photos)
| URI        | HTTP   | Body  | Description                   |
| :--------- | :----: | :---: | :---------------------------- |
| /media     | GET    | -     | Get a list of all hotel media |
| /media/:id | GET    | -     | Get details of a hotel media  |
| /media     | POST   | JSON  | Add a new hotel media         |
| /media     | PUT    | JSON  | Update a hotel media          |
| /media/:id | DELETE | -     | Delete a hotel media          |