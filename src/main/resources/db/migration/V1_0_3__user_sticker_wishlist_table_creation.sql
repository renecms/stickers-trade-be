create table stickers.user_sticker_wishlist
(
    id         serial  not null
        constraint user_sticker_wishlist_pk
            primary key,
    user_id    integer not null
        constraint user_sticker_wishlist_user_fk
            references stickers."user" (id)
            on delete cascade,
    sticker_id integer
        constraint user_sticker_wishlist_sticker_fk
            references stickers.sticker (id)
            on delete cascade
);
