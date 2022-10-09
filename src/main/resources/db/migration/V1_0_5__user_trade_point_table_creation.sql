create table stickers.user_trade_point
(
    id             serial  not null
        constraint user_trade_point_pk
            primary key,
    user_id        integer not null
        constraint user_trade_point_user_fk
            references stickers."user" (id)
            on delete cascade,
    trade_point_id integer
        constraint user_trade_point_trade_point_fk
            references stickers.trade_point (id)
            on delete cascade
);
