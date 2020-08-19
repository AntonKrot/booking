/*==============================================================*/
/* Table: booking                                                  */
/*==============================================================*/
create table booking
(
    booking_id               bigserial not null,
    user_account_id          bigint    null,
    booking_status_id        smallint  null,
    room_id                  bigint    null,
    start_date_time          timestamp not null,
    end_date_time            timestamp not null,
    manipulation_name        text      not null,
    manipulation_description text      null,
    constraint PK_BOOKING primary key (booking_id)
);

comment on table booking is
    'Аренда';

/*==============================================================*/
/* Table: booking_status                                           */
/*==============================================================*/
create table booking_status
(
    booking_status_id smallint not null,
    name              text     not null,
    constraint PK_BOOKING_STATUS primary key (booking_status_id)
);

comment on table booking_status is
    'Статусы аренды';

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
    role_id smallint not null,
    name    text     not null,
    constraint PK_ROLE primary key (role_id)
);

comment on table role is
    'Роли';

/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room
(
    room_id      bigserial not null,
    room_type_id smallint  null,
    description  text      null,
    constraint PK_ROOM primary key (room_id)
);

comment on table room is
    'Комнаты';

/*==============================================================*/
/* Table: room_type                                             */
/*==============================================================*/
create table room_type
(
    room_type_id smallint not null,
    name         text     not null,
    constraint PK_ROOM_TYPE primary key (room_type_id)
);

comment on table room_type is
    'Тип комнаты';

/*==============================================================*/
/* Table: user_account                                          */
/*==============================================================*/
create table user_account
(
    user_account_id bigserial not null,
    role_id         smallint  not null,
    full_name       text      not null,
    email           text      not null,
    phone           text      not null,
    "login"         text      not null,
    password        text      not null,
    constraint PK_USER_ACCOUNT primary key (user_account_id)
);

comment on table user_account is
    'Пользователи';

alter table booking
    add constraint FK_RENT_REFERENCE_USER_ACC foreign key (user_account_id)
        references user_account (user_account_id)
        on update restrict
        on delete restrict;

alter table booking
    add constraint FK_RENT_REFERENCE_RENT_STA foreign key (booking_status_id)
        references booking_status (booking_status_id)
        on update restrict
        on delete restrict;

alter table booking
    add constraint FK_RENT_REFERENCE_ROOM foreign key (room_id)
        references room (room_id)
        on update restrict
        on delete restrict;

alter table room
    add constraint FK_ROOM_REFERENCE_ROOM_TYP foreign key (room_type_id)
        references room_type (room_type_id)
        on update restrict
        on delete restrict;

alter table user_account
    add constraint FK_USER_ACC_REFERENCE_ROLE foreign key (role_id)
        references role (role_id)
        on update restrict
        on delete restrict;

