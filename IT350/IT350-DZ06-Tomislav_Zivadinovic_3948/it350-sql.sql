/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     16.11.2020. 00:14:01                         */
/*==============================================================*/


drop table if exists angazovanje;

drop table if exists katedra;

drop table if exists nastavnik;

drop table if exists predmet;

drop table if exists prijavaispita;

drop table if exists pripada;

drop table if exists relationship_3;

drop table if exists slusa_predmet;

drop table if exists student;

/*==============================================================*/
/* Table: angazovanje                                           */
/*==============================================================*/
create table angazovanje
(
   angazovanje_id       int not null,
   nastavnik_id         int not null,
   predmet_id           int not null,
   primary key (angazovanje_id)
);

/*==============================================================*/
/* Table: katedra                                               */
/*==============================================================*/
create table katedra
(
   katedra_id           int not null,
   primary key (katedra_id)
);

/*==============================================================*/
/* Table: nastavnik                                             */
/*==============================================================*/
create table nastavnik
(
   nastavnik_id         int not null,
   ime                  varchar(16) not null,
   prezime              varchar(16) not null,
   email                varchar(64) not null,
   primary key (nastavnik_id)
);

/*==============================================================*/
/* Table: predmet                                               */
/*==============================================================*/
create table predmet
(
   predmet_id           int not null,
   sifra_predmeta       varchar(6) not null,
   naziv                varchar(64) not null,
   godina_studija       int not null,
   primary key (predmet_id)
);

/*==============================================================*/
/* Table: prijavaispita                                         */
/*==============================================================*/
create table prijavaispita
(
   prijava_ispita_id    int not null,
   predmet_id           int not null,
   termin               datetime not null,
   ucionica             varchar(5) not null,
   primary key (prijava_ispita_id)
);

/*==============================================================*/
/* Table: pripada                                               */
/*==============================================================*/
create table pripada
(
   katedra_id           int not null,
   nastavnik_id         int not null,
   primary key (katedra_id, nastavnik_id)
);

/*==============================================================*/
/* Table: relationship_3                                        */
/*==============================================================*/
create table relationship_3
(
   student_id           int not null,
   prijava_ispita_id    int not null,
   primary key (student_id, prijava_ispita_id)
);

/*==============================================================*/
/* Table: slusa_predmet                                         */
/*==============================================================*/
create table slusa_predmet
(
   predmet_id           int not null,
   student_id           int not null,
   primary key (predmet_id, student_id)
);

/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student
(
   student_id           int not null,
   ime                  varchar(16) not null,
   prezime              varchar(16) not null,
   godina_studiranja    int not null,
   indeks               bigint not null,
   email                varchar(64) not null,
   primary key (student_id)
);

alter table angazovanje add constraint fk_angazovan foreign key (nastavnik_id)
      references nastavnik (nastavnik_id) on delete restrict on update restrict;

alter table angazovanje add constraint fk_predaje foreign key (predmet_id)
      references predmet (predmet_id) on delete restrict on update restrict;

alter table prijavaispita add constraint fk_prijava foreign key (predmet_id)
      references predmet (predmet_id) on delete restrict on update restrict;

alter table pripada add constraint fk_pripada foreign key (katedra_id)
      references katedra (katedra_id) on delete restrict on update restrict;

alter table pripada add constraint fk_pripada2 foreign key (nastavnik_id)
      references nastavnik (nastavnik_id) on delete restrict on update restrict;

alter table relationship_3 add constraint fk_relationship_3 foreign key (student_id)
      references student (student_id) on delete restrict on update restrict;

alter table relationship_3 add constraint fk_relationship_4 foreign key (prijava_ispita_id)
      references prijavaispita (prijava_ispita_id) on delete restrict on update restrict;

alter table slusa_predmet add constraint fk_slusa_predmet foreign key (predmet_id)
      references predmet (predmet_id) on delete restrict on update restrict;

alter table slusa_predmet add constraint fk_slusa_predmet2 foreign key (student_id)
      references student (student_id) on delete restrict on update restrict;

