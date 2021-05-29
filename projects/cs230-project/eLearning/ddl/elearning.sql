create table question
(
    question_id int auto_increment
        primary key,
    text text null,
    points decimal null
);

create table answer
(
    answer_id int auto_increment
        primary key,
    question_id int not null,
    correct tinyint null,
    text text null,
    constraint fk_question_answer
        foreign key (question_id) references question (question_id)
            on update cascade on delete cascade
);

create table role
(
    role_id int auto_increment
        primary key,
    role varchar(32) null
);

create table test
(
    test_id int auto_increment
        primary key,
    title varchar(64) null,
    date_time varchar(128) null,
    max_points decimal null
);

create table question_test
(
    question_test_id int auto_increment
        primary key,
    question_id int not null,
    test_id int not null,
    constraint fk_question_test
        foreign key (question_id) references question (question_id),
    constraint fk_question_test2
        foreign key (test_id) references test (test_id)
);

create table user
(
    user_id int auto_increment
        primary key,
    first_name varchar(64) null,
    last_name varchar(64) null,
    username varchar(128) null,
    password varchar(128) null,
    email varchar(128) null
);

create table user_role
(
    user_role_id int auto_increment
        primary key,
    user_id int not null,
    role_id int not null,
    constraint fk_user_role
        foreign key (user_id) references user (user_id),
    constraint fk_user_role2
        foreign key (role_id) references role (role_id)
);

create table user_test
(
    user_test_id int auto_increment
        primary key,
    test_id int not null,
    user_id int not null,
    constraint fk_user_test
        foreign key (test_id) references test (test_id),
    constraint fk_user_test2
        foreign key (user_id) references user (user_id)
);

