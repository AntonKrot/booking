insert into room_type
values (1, 'operating room');
insert into room_type
values (2, 'ward');

insert into room
values (1, 1, null);
insert into room
values (2, 2, 'ward №1');

insert into booking_status
values (1, 'new');
insert into booking_status
values (2, 'in_process');
insert into booking_status
values (3, 'finished');
insert into booking_status
values (4, 'canceled');

insert into role
values (1, 'ROLE_ADMIN');
insert into role
values (2, 'ROLE_SURGEON');

insert into user_account
values (1, 1, 'Krot Anton Ruslanovich', 'testmail1@mail.ru', '80291112233', 'admin', 'password');
insert into user_account
values (2, 2, 'Korzh Maksim Anatolievich', 'testmail2@mail.ru', '80294445566', 'user', 'password');