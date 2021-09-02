INSERT INTO location(location_id, latitude, longitude)
VALUES (1,  49.842490, 23.976991),
       (2,  49.831511, 24.006433),
       (3,  49.845970, 24.021740),
       (4,  49.850527, 24.046552),
       (5,  49.798713, 24.023125),
       (6,  49.823378, 24.149547),
       (7,  49.809595, 24.133256),
       (8,  49.814672, 24.043049),
       (9,  49.825557, 23.955552),
       (10, 49.867140, 23.954876),
       (11, 49.834424, 23.997100),
       (12, 49.799992, 24.051552),
       (13, 49.845835, 24.040900),

       (14, 49.799992, 24.051552),
       (15, 49.799992, 24.051552),
       (16, 49.799992, 24.051552),
       (17, 49.799992, 24.051552),
       (18, 49.799992, 24.051552),
       (19, 49.799992, 24.051552),
       (20, 49.799992, 24.051552),

       (1001, 49.8382600, 24.0232400),
       (1002, 39.9075000, 116.3972300),
       (1003, 46.4774700, 30.7326200);

INSERT INTO city (city_id, city_name, city_center_location)
VALUES (1, 'Lviv',   1001),
       (2, 'Kyiv',   1002),
       (3, 'Odessa', 1003);

INSERT INTO accommodation(accommodation_id, accommodation_class, accommodation_condition, accommodation_type, built_in,
                          price, currency, city_id, location_id, description)
VALUES (1,  'ECONOMIC', 'UNSATISFACTORY', 'APARTMENT', '1973-11-01',  19500,  'USD', 1, 1,  'Продаю 1к квартиру 24 кв. м, Олесницького вулиця в районі Левандівка в Львові');
       (2,  'ECONOMIC', 'UNSATISFACTORY', 'APARTMENT', '1950-07-01',  35000,  'USD', 1, 2,  'Гарна простора квартира поблизу Львівської політехніки, житловий стан, парковка авто, надійне капіталовкладення, як під бізнес так і під житло.');
       (3,  'ECONOMIC', 'UNSATISFACTORY', 'APARTMENT', '1969-03-01',  34000,  'USD', 1, 3,  'Продається квартира в центрі міста з окремим входом у дворі по вул. Ляймберга С. Потребує ремонту. До квартири ще належить підвал з окремим входом 16кв.м. Закритий двір. Підійде як для житла так і для бізнесу. Офіс, нотаріальна контора, Ломбард і т.д. Деталі за тел.');
       (4,  'ECONOMIC', 'SATISFACTORY',   'APARTMENT', '1975-08-20',  34000,  'USD', 1, 4,  'Продаж 1 кім квартири по вул. Кордуби 2\2ц. Площа 33\17\10м, гарний житловий стан, з\б перекриття, колонка на воду, МПВікна, санвузол суміщений, пічка, паркет, лічильники, великий гараж на вн. подвірї площею 40м. Ціна 34000 у.о торг при огляді.');
       (5,  'ECONOMIC', 'SATISFACTORY',   'APARTMENT', '1976-05-01',  32000,  'USD', 1, 5,  'Квартира з ремонтом, МПВ, балкон зашклений з кімнати з МПВ, правильне планування, хрущівка, залізобетонне перекриття, центральне опалення, вмонтовані меблі, зелений гарний двір, поряд садочок, школа, зупинка маршруток, продуктовий ринок, Скай парк, Стрийський парк');
       (6,  'ECONOMIC', 'UNSATISFACTORY', 'APARTMENT', '1983-11-01',  22000,  'USD', 1, 6,  'Продається однокімнатна квартира в цегляному будинку по вул. Кільцева м. Винники . Житловий стан , меблі . Без балкону . Поруч магазини , школа .');
       (7,  'ECONOMIC', 'UNSATISFACTORY', 'APARTMENT', '1983-11-01',  22000,  'USD', 1, 7,  'Продаж 1-кім квартири в колишньому гуртожитку по вул. Таджицька. Власний вхід в квартиру, житловий стан, в кімнаті виведені комунікації - душ, туалет. Електрика та сантехніка замінена. Є можливість добудови. Гарне, затишне місцерозташування, паркова зона, поруч є все необхідне - магазин, аптека, зупинка, дит садочок, школа. Чудова пропозиція під здачу в довготривалу оренду. Торг! Телефонуйте в будь який зручний для вас час!!!');
       (8,  'ECONOMIC', 'SATISFACTORY',   'APARTMENT', '1975-10-07',  24000,  'USD', 1, 8,  'Продаж 1-кім квартири по вул Героїв Крут. Площа квартири 35. 2м2 і через стінку 30м2 підвалу поверх цокольний. Індивідуальне опалення. Будинок в гарному стані. Чудове місце розташування та транспортна інфраструктура');
       (9,  'ECONOMIC', 'SATISFACTORY',   'APARTMENT', '1972-10-07',  26000,  'USD', 1, 9,  'Продаж 1 кімнатної квартири! Вулиця Ряшівська! БЕЗ КОМІСІЇ! 21м.кВ , 9/9 поверх Житловий стан Поруч все для комфортного життя, зручне розташування. Ціна :26000$');
       (10, 'ECONOMIC', 'SATISFACTORY',   'APARTMENT', '1980-06-12',  26000,  'USD', 1, 10, 'Код объекта: 195471. АН "Атланта" Продається однокімнатна квартира загальною площею 29 кв.м по вулиці Шевченка Рясне 1 на 3-му поверсі у малосімейці, район Сільпо Меблі залишаються поміняні вікна і вхідні двері косметичний ремонт . До 1 листопада проживають квартиранти');
       (11, 'ECONOMIC', 'SATISFACTORY',   'APARTMENT', '1968-06-12',  40000,  'USD', 1, 11, 'Продається світла, комфортна квартира по вулиці Городоцькій з фасадними вікнами та підвалом. Квартира знаходиться в чудовій локації, 5-10 хв. від центра Львова, навпроти Приміського вокзалу, чудовий варіант як для власного, так і комерційного використання. Біля будинку розвинена інфраструктура: магазини, ТЦ, аптеки, вокзал, ресторани, ... Телефонуйте в зручний для Вас час, відповім на всі запитання та організуємо огляд даного об''єкта.');
       (12, 'COMFORT',  'GOOD',           'APARTMENT', '1986-06-12',  40000,  'USD', 1, 12, 'ТЕРМІНОВО! Продаж ЕКСКЛЮЗИВНОЇ 1-но кімнатної квартири цегла, ВЕРХНІЙ ШУВАР! Неймовірна пропозиція за доступною ціною! Квартира суха, чиста, зроблений євроремонт, нові металопластикові вікна, новий зашклений балкон, в квартирі 2 комірчини+ підвал, додатково з преспективою на майбутнє є сухий , високий тех поверх, який може стати 2-во рівневою квартирою! ЛІФТ їзде справно і включно до 9-го поверху! Замінена проводка, сантехніка, поставлені всі лічильники, які значно економлять КП! Підїзд ідеальний ОСББ, у цій квартирі дуже економні КП послуги, район розвинутий, усі транспортні розв"язки, інфраструктура на вищому рівні! Усе залишаться окрім дивану! ЗАЇЖАЙ І ЖИВИ!');
       (13, 'COMFORT',  'GOOD',           'APARTMENT', '1960-06-12',  41000,  'USD', 1, 13, 'ПРОДАЖ 1 к-на кв-ра в. Кривоноса ( Високий Замок), 1/2ц, 3 (XXX) XXX-XX-XX хід з під‘їзду, квартира з ремонтом, МПВ, інд. опалення діюча пічка( газ), та ел. панелі, ел. бойлер, санвузол разом( туалет, ванна, ел. сушка), продається разом з меблями та побутовою технікою, для житла або здачі в оренду, 41000$,');

       (14, 'COMFORT',  'GOOD',           'APARTMENT', CURRENT_TIMESTAMP,  32000,  'USD', 1, 5, 'Comfortable apartment');
       (15, 'COMFORT',  'GOOD',           'APARTMENT', CURRENT_TIMESTAMP,  34000,  'USD', 1, 5, 'Comfortable apartment');
       (16, 'COMFORT',  'SATISFACTORY',   'HOUSE',     CURRENT_TIMESTAMP,  30000,  'USD', 1, 5, 'Lovely family house...');
       (17, 'COMFORT',  'SATISFACTORY',   'HOUSE',     CURRENT_TIMESTAMP,  31000,  'USD', 1, 5, 'Lovely family house...');
       (18, 'COMFORT',  'SATISFACTORY',   'HOUSE',     CURRENT_TIMESTAMP,  31500,  'USD', 1, 5, 'Lovely family house...');
       (19, 'COMFORT',  'GOOD',           'HOUSE',     CURRENT_TIMESTAMP,  45000,  'USD', 1, 5, 'Lovely family house...');
       (20, 'COMFORT',  'GOOD',           'HOUSE',     CURRENT_TIMESTAMP,  48000,  'USD', 1, 5, 'Lovely family house...');
       (21, 'BUSINESS', 'GOOD',           'OFFICE',    CURRENT_TIMESTAMP,  110000, 'USD', 1, 7, 'Decent office for your business...');
       (22, 'BUSINESS', 'GOOD',           'OFFICE',    CURRENT_TIMESTAMP,  120000, 'USD', 1, 8, 'Decent office for your business...');
       (23, 'BUSINESS', 'GOOD',           'OFFICE',    CURRENT_TIMESTAMP,  150000, 'USD', 1, 9, 'Decent office for your business...');
       (24, 'BUSINESS', 'GOOD',           'OFFICE',    CURRENT_TIMESTAMP,  150000, 'USD', 1, 9, 'Decent office for your business...');
       (25, 'BUSINESS', 'GOOD',           'OFFICE',    CURRENT_TIMESTAMP,  150000, 'USD', 1, 9, 'Decent office for your business...');
       (26, 'BUSINESS', 'GOOD',           'OFFICE',    CURRENT_TIMESTAMP,  150000, 'USD', 1, 9, 'Decent office for your business...');
       (27, 'BUSINESS', 'PERFECT',        'OFFICE',    CURRENT_TIMESTAMP,  150000, 'USD', 1, 9, 'Decent office for your business...');
       (28, 'BUSINESS', 'PERFECT',        'OFFICE',    CURRENT_TIMESTAMP,  150000, 'USD', 1, 9, 'Decent office for your business...');
       (29, 'BUSINESS', 'PERFECT',        'OFFICE',    CURRENT_TIMESTAMP,  150000, 'USD', 1, 9, 'Decent office for your business...');
       (30, 'BUSINESS', 'PERFECT',        'OFFICE',    CURRENT_TIMESTAMP,  150000, 'USD', 1, 9, 'Decent office for your business...');
       (31, 'ELITE',    'PERFECT',        'APARTMENT', CURRENT_TIMESTAMP,  180000, 'USD', 1, 10, 'Lovely apartment...');
       (32, 'ELITE',    'PERFECT',        'APARTMENT', CURRENT_TIMESTAMP,  300000, 'USD', 1, 11, 'Luxurious apartment...');
       (33, 'ELITE',    'PERFECT',        'APARTMENT', CURRENT_TIMESTAMP,  300000, 'USD', 1, 11, 'Luxurious apartment...');
       (34, 'ELITE',    'PERFECT',        'HOUSE',     CURRENT_TIMESTAMP,  300000, 'USD', 1, 11, 'Luxurious house...');
       (35, 'ELITE',    'PERFECT',        'HOUSE',     CURRENT_TIMESTAMP,  300000, 'USD', 1, 11, 'Luxurious house...');
       (36, 'ELITE',    'PERFECT',        'HOUSE',     CURRENT_TIMESTAMP,  300000, 'USD', 1, 11, 'Luxurious house...');
       (37, 'ELITE',    'PERFECT',        'HOUSE',     CURRENT_TIMESTAMP,  300000, 'USD', 1, 11, 'Luxurious house...');
       (38, 'ELITE',    'PERFECT',        'HOUSE',     CURRENT_TIMESTAMP,  300000, 'USD', 1, 11, 'Luxurious house...');
       (39, 'ELITE',    'PERFECT',        'HOUSE',     CURRENT_TIMESTAMP,  160000, 'USD', 1, 12, 'Luxurious house...');

INSERT INTO room (room_id, square, floor, accommodation_id)
VALUES (1,  24,    1, 1),
       (2,  26.94, 5, 2),
       (3,  25,    1, 3),
       (4,  33,    1, 4),
       (5,  25,    3, 5),
       (6,  29,    1, 6),
       (7,  25,    1, 7),
       (8,  35,    4, 8),
       (9,  21,    9, 9),
       (10, 29,    3, 10),
       (11, 24.5,  1, 11),   (12, 8.8, 1, 11),
       (13, 37,    9, 12),
       (14, 31, 5, 13),

       (15, 29, 7, 7),   (16, 24, 5, 7),   (17, 26, 5, 7),
       (18, 35, 1, 8),   (19, 40, 5, 8),   (20, 50, 5, 8),
       (21, 47, 2, 9),   (22, 53, 5, 9),   (23, 55, 5, 9),
       (24, 57, 1, 10),  (25, 49, 1, 10),  (26, 54, 2, 10),
       (27, 55, 1, 11),  (28, 59, 1, 11),  (29, 46, 1, 11),
       (30, 47, 11, 12), (31, 41, 11, 12), (32, 53, 11, 12),  (33, 47, 11, 12);

INSERT INTO media (media_id, url, accommodation_id)
VALUES (1, 'https://www.shu.ac.uk/-/media/home/study-here/accommodation/accommodation/images/hallspromoimg.jpg?iar=0&hash=0409116FD4587A98E19193CAE27758CC', 1),
       (2, 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/258884793.jpg?k=ace520a44e8ee4fdaa85934074ffc6f9e9f4391672b6be2a6189cef15211d613&o=&hp=1', 1),
       (3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJKfbqc33pHnBkJ9nA7vcqTf1sJCLsEpaxzA&usqp=CAU', 1),
       (4, 'https://media-cdn.tripadvisor.com/media/photo-s/13/1c/90/04/gundagai-tourist-accommodation.jpg', 2),
       (5, 'https://media-cdn.tripadvisor.com/media/photo-s/0d/3a/75/3c/accommodation-london.jpg', 2),
       (6, 'https://www.aston.ac.uk/sites/default/files/2020-11/accommodation-new-students-card.jpg', 2),
       (7, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7TlRPv7JjTsElby3XBFGKwBvCyDlJkOX6Vq8lb4Ul4stN2bJYTiQhplgAehmngKA5wZs&usqp=CAU', 3),
       (8, 'https://www.canterbury.ac.nz/life/accommodation/temporary/Sonoda-Temp-accom_127832166035890251.jpg', 3),
       (9, 'https://vntu.edu.ua/sites/default/files/images/1_0.jpg', 3),
       (10, 'https://vntu.edu.ua/sites/default/files/images/1_0.jpg', 4),
       (11, 'https://vntu.edu.ua/sites/default/files/images/1_0.jpg', 4),
       (12, 'https://vntu.edu.ua/sites/default/files/images/1_0.jpg', 4),
       (13, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6x_5NnFoo8OMVOV0KDVXWmETLm20ef4I5NLpWDtAC_F_u4L3W0TffTgA3JwoG210bfzE&usqp=CAU', 5),
       (14, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkKhPQleB20mreoD290m6a4ata8miE0q6m6HYfNIhma7MuxfeLTEYFx2jnijLBeaVdBw4&usqp=CAU', 5),
       (15, 'https://www.collegiate-ac.com/propeller/uploads/sites/2/2019/09/the-neighbourhood-exeter-student-accommodation-5-1075x788.jpg', 5),
       (16, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJAautftpdLgWVbtXaI8aTEn1Qx-JRa0ON-g&usqp=CAU', 6),
       (17, 'https://i.pinimg.com/originals/f9/a9/72/f9a972c5fc136f5e2c5b3789b9738915.jpg', 6),
       (18, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcPLW9tK6_FHpAi5yQ0vpd1dkKXQO5WGFPZw&usqp=CAU', 6),
       (19, 'https://exp.cdn-hotels.com/hotels/13000000/12070000/12064600/12064590/aa1651f7_z.jpg?impolicy=fcrop&w=500&h=333&q=medium', 7),
       (20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdZ2yxJCD2fIxNtDzp35OoqTGDuLOkIhDe9g&usqp=CAU', 7),
       (21, 'https://www.collegiate-ac.com/propeller/uploads/sites/2/2019/09/roman-house-derby-student-accommodation-1-1075x788.jpg', 7),
       (22, 'https://www.studentletsuk.com/wp-content/uploads/2020/08/roman_house_.jpg', 8),
       (23, 'https://collegiate-portal.s3.eu-west-2.amazonaws.com/collegiate-derby-romanhouse-twodio.jpg', 8),
       (24, 'http://cdn.shopify.com/s/files/1/0004/4630/0222/articles/top-10-modern-interior-designers_7aa91b70-0ecf-441f-845b-067c09148d05_1024x1024.jpg?v=1582196808', 8),
       (25, 'https://q-xx.bstatic.com/xdata/images/hotel/840x460/95024620.jpg?k=df17293ee20498e7a4bd952c3df0d527eb111fc6ca10a78c5601229eb60752be&o=', 9),
       (26, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSUvcWw3DJEry8qgFJyxyZdILc8l8iunKpl_A&usqp=CAU', 9),
       (27, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSdZ2yxJCD2fIxNtDzp35OoqTGDuLOkIhDe9g&usqp=CAU', 9),
       (28, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSkBIRg1nvlkOBctXvKDkqKJoL2OiVn49FooA&usqp=CAU', 10),
       (29, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQY0NGZFQZDiM4NNxRJq4SwdGOy3hOEgqfn45uzdJQAd0gzWWG9i36f6dT-mp1CBy1McFo&usqp=CAU', 10),
       (30, 'https://www.taylorstracks.com/wp-content/uploads/2020/12/Rydges-Wellington-New-Zealand.jpg', 10),
       (31, 'https://nzpocketguide.com/wp-content/uploads/2019/10/Wellington-best-hotels-Credit-Rydges-Wellington.jpg', 11),
       (32, 'https://3dwarehouse.sketchup.com/warehouse/v1.0/publiccontent/54aa2c88-fbab-4584-b22f-2b6b636b0d3f', 11),
       (33, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSXG8NzKwYHNwAgJy5XNpYMhBsn692aqUimd1lM18Kd0CmreKx5YON6bbUeMzOm6yUSWg0&usqp=CAU', 11),
       (34, 'https://cf.bstatic.com/xdata/images/hotel/max1024x768/298463552.jpg?k=8d24491d01c2170c659a46da2441a6f3174de150abf11aff25afe3bf131a3df0&o=&hp=1', 12),
       (35, 'https://q-xx.bstatic.com/images/hotel/max1024x768/950/95030981.jpg', 12),
       (36, 'https://q-xx.bstatic.com/xdata/images/hotel/840x460/95024620.jpg?k=df17293ee20498e7a4bd952c3df0d527eb111fc6ca10a78c5601229eb60752be&o=', 12);