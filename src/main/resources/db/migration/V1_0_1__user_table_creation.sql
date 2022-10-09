create table if not exists stickers."user"
(
    id            SERIAL,
    name          VARCHAR(50) not null,
    email         VARCHAR(50) not null,
    creation_date TIME default now(),
    constraint user_pk
        primary key (id),
    constraint user_unique_email
        unique (email)
);