CREATE TABLE IF NOT EXISTS accommodation
(
    accommodation_id        SERIAL PRIMARY KEY NOT NULL,
    price                   NUMERIC(16),
    built_in                DATE,
    square_meter_price      NUMERIC(6, 2),
    distance_to_city_center NUMERIC(6, 2),
    location_id             NUMERIC(16),
    accommodation_class     VARCHAR,
    accommodation_condition VARCHAR,
    accommodation_type      VARCHAR,
    room_id                 NUMERIC(16)
    );

CREATE TABLE IF NOT EXISTS location
(
    location_id SERIAL PRIMARY KEY NOT NULL,
    longitude   VARCHAR,
    latitude    VARCHAR
);

CREATE TABLE IF NOT EXISTS room
(
    room_id SERIAL PRIMARY KEY NOT NULL,
    square  NUMERIC(9),
    floor   NUMERIC(2)
    );

CREATE TABLE IF NOT EXISTS city
(
    city_id            SERIAL PRIMARY KEY NOT NULL,
    city_name          VARCHAR,
    center_location_id NUMERIC(16)
    );