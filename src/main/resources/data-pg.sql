INSERT INTO public.e_claim_type (claim_type) VALUES ('CanAccessProducts');
INSERT INTO public.e_claim_type (claim_type) VALUES ('CanSaveProduct');
INSERT INTO public.e_claim_type (claim_type) VALUES ('CanAccessCategories');
INSERT INTO public.e_claim_type (claim_type) VALUES ('CanSaveCategory');
INSERT INTO public.e_claim_type (claim_type) VALUES ('CanAccessUsers');
INSERT INTO public.e_claim_type (claim_type) VALUES ('CanSaveUser');

--------------------------------------

-- Users
INSERT INTO public.e_user (id, login, password) VALUES (1, 'admin', '$2a$10$Gps3EjjnjqolhVPChvEdeOmTPl4RiHqLwITy9PfeNmj8klG3QuRGO');
INSERT INTO public.e_user (id, login, password) VALUES (2, 'me', '$2a$10$Gps3EjjnjqolhVPChvEdeOmTPl4RiHqLwITy9PfeNmj8klG3QuRGO');

SELECT pg_catalog.setval('public.e_user_id_seq', 2, true);

--------------------------------------

INSERT INTO public.e_user_claim (user_id, claim_type_id) VALUES (1, 'CanAccessProducts');
INSERT INTO public.e_user_claim (user_id, claim_type_id) VALUES (1, 'CanSaveProduct');
INSERT INTO public.e_user_claim (user_id, claim_type_id) VALUES (1, 'CanAccessCategories');
INSERT INTO public.e_user_claim (user_id, claim_type_id) VALUES (1, 'CanSaveCategory');
INSERT INTO public.e_user_claim (user_id, claim_type_id) VALUES (1, 'CanAccessUsers');
INSERT INTO public.e_user_claim (user_id, claim_type_id) VALUES (1, 'CanSaveUser');

INSERT INTO public.e_user_claim (user_id, claim_type_id) VALUES (2, 'CanAccessProducts');
INSERT INTO public.e_user_claim (user_id, claim_type_id) VALUES (2, 'CanAccessCategories');

--------------------------------------

INSERT INTO public.e_category (id, title, description) VALUES (1, 'Bakery', 'The best cupcakes, cookies, cakes, pies, cheesecakes, fresh bread, biscotti, muffins, bagels, fresh coffee and more.');
INSERT INTO public.e_category (id, title, description) VALUES (2, 'Takeaway', 'Its consistently excellent, dishes are superb and healthily cooked with high quality ingredients.');
INSERT INTO public.e_category (id, title, description) VALUES (3, 'Dairy', 'A dairy product is food produced from the milk of mammals, primarily cows, water buffaloes, goats, sheep, yaks, horses.');
INSERT INTO public.e_category (id, title, description) VALUES (4, 'Meat', 'Only superior quality beef, lamb, and pork.');
INSERT INTO public.e_category (id, title, description) VALUES (5, 'Seafood', 'Great place to buy fresh seafood.');
INSERT INTO public.e_category (id, title, description) VALUES (6, 'Fruit & Veg', 'A variety of fresh fruits and vegetables.');

SELECT pg_catalog.setval('e_category_id_seq', 6, true);

--------------------------------------

INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (1,1, 'Baguette/French Bread', 1.5, false, 'Great eaten fresh from oven. Used to make sub sandwiches, etc.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (2,1, 'Croissants', 0.5, true, 'A croissant is a buttery, flaky, viennoiserie-pastry named for its well-known crescent shape.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (3,2, 'Pizza', 1.2, false, 'Pizza is a flatbread generally topped with tomato sauce and cheese and baked in an oven.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (4,3, 'Milk', 1.7, false, 'Milk is a pale liquid produced by the mammary glands of mammals');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (5,3, 'Cream Cheese', 2.35, false, 'Cream cheese is a soft, mild-tasting fresh cheese with a high fat content.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (6,4, 'Pork Tenderloin', 5.60, false, 'The pork tenderloin, in some countries called pork fillet, is a cut of pork.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (7,4, 'Ribs, Baby Back', 4.85, false, 'Pork ribs are a cut of pork popular in North American and Asian cuisines.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (8,4, 'Ground Beef', 9.20, false, 'Ground beef, beef mince, minced beef, minced meat is a ground meat made of beef that has been finely chopped with a large knife or a meat grinder.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (9,5, 'Tuna', 3.45, false, 'A tuna is a saltwater finfish that belongs to the tribe Thunnini, a sub-grouping of the mackerel family – which together with the tunas, also includes the bonitos, ackerels, and Spanish mackerels.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (10,5, 'Salmon', 4.55, false, 'Salmon is the common name for several species of ray-finned fish in the family Salmonidae.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (11,5, 'Oysters', 7.80, false, 'The word oyster is used as a common name for a number of different families of saltwater clams, bivalve molluscs that live in marine or brackish habitats.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (12,5, 'Scalops', 2.70, false, 'Scallop is a common name that is primarily applied to any one of numerous species of saltwater clams or marine bivalve mollusks in the taxonomic family Pectinidae, the scallops.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (13,6, 'Banana', 1.55, false, 'The banana is an edible fruit, botanically a berry, produced by several kinds of large herbaceous flowering plants in the genus Musa.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (14,6, 'Cucumber', 1.05, false, 'Cucumber is a widely cultivated plant in the urd family, Cucurbitaceae.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (15,6, 'Apple', 0.80, false, 'The apple tree is a deciduous tree in the rose family best known for its sweet, pomaceous fruit, the apple.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (16,6, 'Lemon', 3.20, false, 'The lemon is a species of small evergreen tree native to Asia.');
INSERT INTO public.e_product (id, category_id, title, price, special, description) VALUES (17,6, 'Pear', 4.25, false, 'The pear is any of several tree and shrub species of genus Pyrus, in the family Rosaceae.');

SELECT pg_catalog.setval('e_product_id_seq', 17, true);