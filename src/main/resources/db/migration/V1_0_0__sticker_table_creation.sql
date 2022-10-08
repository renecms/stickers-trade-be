create table if not exists sticker
(
    id        SERIAL,
    name      VARCHAR(50) not null,
    number    integer     not null,
    image_url TEXT,
    country   VARCHAR(100),
    constraint sticker_pk
    primary key (id),
    constraint sticker_unique_player
    unique (country, name, number)
);