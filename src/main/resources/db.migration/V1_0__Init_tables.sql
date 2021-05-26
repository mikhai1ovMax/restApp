create table account
(
    id             serial not null
        constraint account_pkey
            primary key,
    account_status integer,
    codeword       varchar(255),
    email          varchar(255),
    user_id        integer
);

alter table account
    owner to postgres;

create table "user"
(
    id         serial not null
        constraint user_pkey
            primary key,
    first_name varchar(255),
    last_name  varchar(255),
    account_id integer
        constraint fkc3b4xfbq6rbkkrddsdum8t5f0
            references account
);

alter table "user"
    owner to postgres;

alter table account
    add constraint fk7m8ru44m93ukyb61dfxw0apf6
        foreign key (user_id) references "user";

create table event
(
    id          serial not null
        constraint event_pkey
            primary key,
    description varchar(255),
    name        varchar(255),
    user_id     integer
        constraint fki8bsvlthqr8lngsyshiqsodak
            references "user"
);

alter table event
    owner to postgres;

create table file
(
    id          serial not null
        constraint file_pkey
            primary key,
    created     timestamp,
    file_status integer,
    text        varchar(255),
    user_id     integer
        constraint fkinph5hu8ryc97hbs75ym9sm7t
            references "user",
    format      varchar(255)
);

alter table file
    owner to postgres;

