create
database stores;

create table stores
(
    id            bigserial
        constraint stores_pk
            primary key,
    name          varchar,
    phone         varchar,
    type          varchar,
    cashbox_count smallint,
    delivery      boolean
);

create table goods
(
    id           bigserial not null
        constraint goods_pk
            primary key,
    name         varchar,
    cost         numeric,
    manufacturer varchar,
    date         timestamp,
    store_id     bigint    not null
        constraint goods_stores_id_fk
            references stores
);