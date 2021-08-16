INSERT INTO location(location_id, longitude, latitude)
VALUES (1,  49.833539, 23.981344),
       (2,  49.815794, 24.034479),
       (3,  49.846283, 24.023344),
       (4,  49.847574, 24.010073),
       (5,  49.839109, 24.059302),
       (6,  49.831146, 24.024529),
       (7,  49.809595, 24.133256),
       (8,  49.801908, 24.029471),
       (9,  49.854518, 24.047553),
       (10, 49.815721, 24.052720),
       (11, 49.835500, 24.028163),
       (12, 49.837866, 24.055181),

       (1001, 49.8382600, 24.0232400),
       (1002, 39.9075000, 116.3972300),
       (1003, 46.4774700, 30.7326200);

INSERT INTO city (city_id, city_name, city_center_location)
VALUES (1, 'Lviv',   1001),
       (2, 'Kyiv',   1002),
       (3, 'Odessa', 1003);

INSERT INTO accommodation(accommodation_id, accommodation_class, accommodation_condition, accommodation_type, built_in,
                          description, distance_to_city_center, price, currency, total_area, square_meter_price,
                          city_id, location_id)
VALUES (1, 'ECONOMIC', 'UNSATISFACTORY', 'APARTMENT', CURRENT_TIMESTAMP, 'Affordable apartment',                 4.7, 15000,  'USD', 40,    375, 1, 1),
       (2, 'ECONOMIC', 'UNSATISFACTORY', 'HOUSE',     CURRENT_TIMESTAMP, 'Affordable apartment',                 5.3, 16000,  'USD', 44.5,  360, 1, 2),
       (3, 'ECONOMIC', 'SATISFACTORY',   'APARTMENT', CURRENT_TIMESTAMP, 'Affordable apartment',                 3.3, 19000,  'USD', 47.9,  397, 1, 3),
       (4, 'COMFORT',  'SATISFACTORY',   'APARTMENT', CURRENT_TIMESTAMP, 'Comfortable apartment',                4.9, 24000,  'USD', 58.5,  410, 1, 4),
       (5, 'COMFORT',  'SATISFACTORY',   'HOUSE',     CURRENT_TIMESTAMP, 'Lovely family house...',               6.1, 45000,  'USD', 112.5, 400, 1, 5),
       (6, 'COMFORT',  'GOOD',           'APARTMENT', CURRENT_TIMESTAMP, 'Comfortable apartment',                2.1, 40000,  'USD', 88.9,  450, 1, 6),
       (7, 'BUSINESS', 'GOOD',           'OFFICE',    CURRENT_TIMESTAMP, '"Decent office for your business..."', 3.4, 110000, 'USD', 275,   400, 1, 7),
       (8, 'BUSINESS', 'GOOD',           'OFFICE',    CURRENT_TIMESTAMP, '"Decent office for your business..."', 4.2, 120000, 'USD', 279,   430, 1, 8),
       (9, 'BUSINESS', 'PERFECT',        'OFFICE',    CURRENT_TIMESTAMP, '"Decent office for your business..."', 1.2, 150000, 'USD', 333.3, 450, 1, 9),
       (10, 'ELITE',   'PERFECT',        'HOUSE',     CURRENT_TIMESTAMP, 'Lovely family house...',               5.9, 180000, 'USD', 300,   600, 1, 10),
       (11, 'ELITE',   'PERFECT',        'HOUSE',     CURRENT_TIMESTAMP, 'Luxurious house...',                   7.4, 300000, 'USD', 400,   750, 1, 11),
       (12, 'ELITE',   'PERFECT',        'APARTMENT', CURRENT_TIMESTAMP, 'Luxurious apartment...',               0.4, 160000, 'USD', 250,   640, 1, 12);

INSERT INTO room (room_id, square, floor, accommodation_id)
VALUES (1,  20, 5, 1),   (2,  15, 5, 1),
       (3,  25, 1, 2),   (4,  20, 2, 2),
       (5,  23, 6, 3),   (6,  24, 5, 3),
       (7,  30, 4, 4),   (8,  24, 5, 4),
       (9,  27, 1, 5),   (10, 29, 1, 5),   (11, 31, 2, 5),
       (12, 35, 8, 6),   (13, 26, 5, 6),   (14, 28, 5, 6),
       (15, 29, 7, 7),   (16, 24, 5, 7),   (17, 26, 5, 7),
       (18, 35, 1, 8),   (19, 40, 5, 8),   (20, 50, 5, 8),
       (21, 47, 2, 9),   (22, 53, 5, 9),   (23, 55, 5, 9),
       (24, 57, 1, 10),  (25, 49, 1, 10),  (26, 54, 2, 10),
       (27, 55, 1, 11),  (28, 59, 1, 11),  (29, 46, 1, 11),
       (30, 47, 11, 12), (31, 41, 11, 12), (32, 53, 11, 12),  (33, 47, 11, 12);