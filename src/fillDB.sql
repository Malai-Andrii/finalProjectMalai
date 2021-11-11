INSERT INTO admins VALUES (1,'aaa@gmail.com');
INSERT INTO admins VALUES (2,'bbb@gmail.com');

INSERT INTO users VALUES (1,'userA@gmail.com', 'userA', 'pass1');
INSERT INTO users VALUES (2,'userB@gmail.com', 'userB', 'pass2');
INSERT INTO users VALUES (3,'userC@gmail.com', 'userC', 'pass3');

INSERT INTO activ_categories VALUES (1,'категоріяА', 'categoryA');
INSERT INTO activ_categories VALUES (2,'категоріяБ', 'categoryB');

INSERT INTO activities VALUES (1, 'активністьА', 'activityA', '2021-11-11 10:00:00', '2021-11-11 15:00:00', 'PROCESS', 1);
INSERT INTO activities VALUES (2, 'активністьБ', 'activityB', '2021-11-11 11:00:00', '2021-11-11 16:00:00', 'PROCESS', 1);
INSERT INTO activities VALUES (3, 'активністьЦ', 'activityC', '2021-11-11 12:00:00', '2021-11-11 17:00:00', 'PROCESS', 2);

INSERT INTO users_activities VALUES (1, 1);
INSERT INTO users_activities VALUES (1, 2);
INSERT INTO users_activities VALUES (2, 2);
INSERT INTO users_activities VALUES (3, 1);
INSERT INTO users_activities VALUES (3, 2);
INSERT INTO users_activities VALUES (3, 3);

