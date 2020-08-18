create table user_account (
   user_account_id       bigserial             not null,
   name                 text                 not null,
   constraint PK_USER_ACCOUNT primary key (user_account_id)
);