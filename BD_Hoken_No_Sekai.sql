/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  14/08/2021 11:46:49                      */
/*==============================================================*/


drop table if exists ADMINISTRATEUR;

drop table if exists APPORTEUR_AFFAIRES;

drop table if exists CAISSE;

drop table if exists CLIENT;

drop table if exists COMPAGNIE;

drop table if exists SUPERVISEUR;

drop table if exists TALON;

drop table if exists VEHICULE;

/*==============================================================*/
/* Table : ADMINISTRATEUR                                       */
/*==============================================================*/
create table ADMINISTRATEUR
(
   IDADMIN              int not null,
   IDSUP                int not null,
   NOMAD                varchar(20),
   PRENOMAD             varchar(20),
   LOGIN                varchar(20),
   PASSWORD             varchar(20),
   EMAIL                varchar(30),
   primary key (IDADMIN)
);

/*==============================================================*/
/* Table : APPORTEUR_AFFAIRES                                   */
/*==============================================================*/
create table APPORTEUR_AFFAIRES
(
   NINEA                int not null,
   NOM                  varchar(20),
   PRENOM               varchar(20),
   LOGIN                varchar(20),
   PASSWORD             varchar(20),
   EMAIL                varchar(30),
   ADRESSEAPP           varchar(30),
   primary key (NINEA)
);

/*==============================================================*/
/* Table : CAISSE                                               */
/*==============================================================*/
create table CAISSE
(
   NUMCAISEE            int not null,
   NINEA                int,
   SOMMEFACT            float,
   SOMMEENC             float,
   COMMISSION           float,
   primary key (NUMCAISEE)
);

/*==============================================================*/
/* Table : CLIENT                                               */
/*==============================================================*/
create table CLIENT
(
   IDCLIENT             int not null,
   NINEA                int not null,
   ASSURE               varchar(40),
   TEL                  numeric(9,0),
   CONTACT              varchar(20),
   DATERAPPEL           date,
   CLIENTADRESSE        varchar(30),
   primary key (IDCLIENT)
);

/*==============================================================*/
/* Table : COMPAGNIE                                            */
/*==============================================================*/
create table COMPAGNIE
(
   NOM                  varchar(20) not null,
   IDSUP                int,
   CLIENTADRESSE        varchar(30),
   EMAIL                varchar(30),
   primary key (NOM)
);

/*==============================================================*/
/* Table : SUPERVISEUR                                          */
/*==============================================================*/
create table SUPERVISEUR
(
   IDSUP                int not null,
   NINEA                int,
   NOMSUP               varchar(20),
   PRENOMSUP            varchar(20),
   LOGIN                varchar(20),
   PASSWORD             varchar(20),
   EMAIL                varchar(30),
   primary key (IDSUP)
);

/*==============================================================*/
/* Table : TALON                                                */
/*==============================================================*/
create table TALON
(
   IDTALON              int not null,
   IMMAT                varchar(20) not null,
   NINEA                int,
   ATTESTATION          int,
   POLICE               int,
   EFFET                date,
   ECHANCE              date,
   HEURE                time,
   NBRMOIS              smallint,
   primary key (IDTALON)
);

/*==============================================================*/
/* Table : VEHICULE                                             */
/*==============================================================*/
create table VEHICULE
(
   IDVEHICULE           int not null,
   ENERGIE              varchar(20),
   MARQUE               varchar(20),
   CATEGORIE            varchar(30),
   TONNAGE              varchar(20),
   NBRPLACES            int,
   GENRE                varchar(20),
   VISITETECH           date,
   IMMAT                varchar(20) not null,
   primary key (IMMAT)
);

alter table ADMINISTRATEUR add constraint FK_GERER foreign key (IDSUP)
      references SUPERVISEUR (IDSUP) on delete restrict on update restrict;

alter table CAISSE add constraint FK_FAIRE foreign key (NINEA)
      references APPORTEUR_AFFAIRES (NINEA) on delete restrict on update restrict;

alter table CLIENT add constraint FK_INSCRIRE foreign key (NINEA)
      references APPORTEUR_AFFAIRES (NINEA) on delete restrict on update restrict;

alter table COMPAGNIE add constraint FK_REMONTER_CONTRAT foreign key (IDSUP)
      references SUPERVISEUR (IDSUP) on delete restrict on update restrict;

alter table SUPERVISEUR add constraint FK_ETABLIR_CONTRAT foreign key (NINEA)
      references APPORTEUR_AFFAIRES (NINEA) on delete restrict on update restrict;

alter table TALON add constraint FK_AVOIR foreign key (IMMAT)
      references VEHICULE (IMMAT) on delete restrict on update restrict;

alter table TALON add constraint FK_DELIVRER foreign key (NINEA)
      references APPORTEUR_AFFAIRES (NINEA) on delete restrict on update restrict;

