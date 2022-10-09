create table if not exists stickers."trade_point"
(
    id            SERIAL,
    name          VARCHAR(50)  not null,
    address       VARCHAR(200) not null,
    creation_date timestamp default now(),
    constraint trade_point_pk
        primary key (id),
    constraint trade_point_unique_name
        unique (name)
);