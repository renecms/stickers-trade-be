create table stickers.user_sticker_owned
(
    id         serial  not null
        constraint user_sticker_owned_pk
            primary key,
    user_id    integer not null
        constraint user_sticker_owned_user_fk
            references stickers."user" (id)
            on delete cascade,
    sticker_id integer
        constraint user_sticker_owned_sticker_fk
            references stickers.sticker (id)
            on delete cascade
);
