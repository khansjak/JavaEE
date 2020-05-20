create table Customer (
    id bigint not null,
    created_on timestamp,
    firstName varchar(255),
    lastName varchar(255),
    primary key (id)
)

create table Customer_AUD (
   id bigint not null,
    REV integer not null,
    REVTYPE tinyint,
    REVEND integer,
    created_on timestamp,
    firstName varchar(255),
    lastName varchar(255),
    primary key (id, REV)
)

create table REVINFO (
    REV integer generated by default as identity,
    REVTSTMP bigint,
    primary key (REV)
)

alter table Customer_AUD
    add constraint FK5ecvi1a0ykunrriib7j28vpdj
    foreign key (REV)
    references REVINFO

alter table Customer_AUD
    add constraint FKqd4fy7ww1yy95wi4wtaonre3f
    foreign key (REVEND)
    references REVINFO