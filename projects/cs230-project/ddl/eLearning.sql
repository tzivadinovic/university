drop table if exists question;

drop table if exists question_test;

drop table if exists role;

drop table if exists test;

drop table if exists user;

drop table if exists user_role;

drop table if exists user_test;


create table question(
   question_id          int auto_increment primary key,
   text                 text,
   points               decimal
);


create table test(
   test_id              int auto_increment primary key,
   title                varchar(64),
   date_time            datetime,
   max_points           decimal
);


create table question_test(
    question_test_id    int auto_increment primary key,
    question_id          int not null,
    test_id              int not null,
   constraint fk_question_test foreign key (question_id)
      references question (question_id) on delete restrict on update restrict,
   constraint fk_question_test2 foreign key (test_id)
      references test (test_id) on delete restrict on update restrict
);


create table role(
   role_id              int auto_increment primary key,
   role                 varchar(32)
);


create table user(
   user_id              int auto_increment primary key,
   first_name           varchar(64),
   last_name            varchar(64),
   username             varchar(128),
   password             varchar(128),
   email                varchar(128)
);


create table user_role(
    user_role_id        int auto_increment primary key,
    user_id              int not null,
    role_id              int not null,
   constraint fk_user_role foreign key (user_id)
      references user (user_id) on delete restrict on update restrict,
   constraint fk_user_role2 foreign key (role_id)
      references role (role_id) on delete restrict on update restrict
);


create table user_test(
    user_test_id        int auto_increment primary key,
    test_id              int not null,
    user_id              int not null,
   constraint fk_user_test foreign key (test_id)
      references test (test_id) on delete restrict on update restrict,
   constraint fk_user_test2 foreign key (user_id)
      references user (user_id) on delete restrict on update restrict
);

