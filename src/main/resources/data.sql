-- FOOD
INSERT INTO food (name, calorie) VALUES ('제육볶음', '520');
INSERT INTO food (name, calorie) VALUES ('김치', '30');
INSERT INTO food (name, calorie) VALUES ('밥', '300');
INSERT INTO food (name, calorie) VALUES ('돈까스', '670');
INSERT INTO food (name, calorie) VALUES ('샐러드', '80');

-- MENU
INSERT INTO menu (name) VALUES ('김치제육볶음 정식');
INSERT INTO menu (name) VALUES ('돈까스 정식');

-- MENU_FOOD
INSERT INTO menufood (menu_id, food_id, orderNo, amount, registerDate)
VALUES (1, 1, 1, 200, CURRENT_DATE);
INSERT INTO menufood (menu_id, food_id, orderNo, amount, registerDate)
VALUES (1, 2, 2, 50, CURRENT_DATE);
INSERT INTO menufood (menu_id, food_id, orderNo, amount, registerDate)
VALUES (1, 3, 3, 210, CURRENT_DATE);

INSERT INTO menufood (menu_id, food_id, orderNo, amount, registerDate)
VALUES (2, 4, 1, 250, CURRENT_DATE);
INSERT INTO menufood (menu_id, food_id, orderNo, amount, registerDate)
VALUES (2, 5, 2, 70, CURRENT_DATE);
INSERT INTO menufood (menu_id, food_id, orderNo, amount, registerDate)
VALUES (2, 3, 3, 210, CURRENT_DATE);
