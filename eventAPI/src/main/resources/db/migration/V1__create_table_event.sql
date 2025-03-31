CREATE TABLE Events (
    id serial PRIMARY KEY,
    name varchar(255) NOT NULL,
    description TEXT,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    identifier varchar(255) NOT NULL UNIQUE,
    organizer varchar(255) NOT NULL,
    place varchar(255) NOT NULL,
    capacity INTEGER NOT NULL,
    type varchar(50) NOT NULL
 );