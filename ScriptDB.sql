INSERT INTO stores(id, name, phone, type, cashbox_count, delivery)
VALUES (DEFAULT, 'ATB', '+380577365112', 'grocery', 10, true)
    INSERT
INTO stores(id, name, phone, type, cashbox_count, delivery)
VALUES (DEFAULT, 'Silpo', '+380574351134', 'grocery', 6, false)

INSERT INTO stores(id, name, phone, type, cashbox_count, delivery)
VALUES (DEFAULT, 'Klass', '+380677834512', 'grocery', 25, true)

INSERT INTO stores(id, name, phone, type, cashbox_count, delivery)
VALUES (DEFAULT, 'Epicentr', '+380954563287', 'building', 22, true)

INSERT INTO stores(id, name, phone, type, cashbox_count, delivery)
VALUES (DEFAULT, 'Zloy', '+380503264315', 'everyday', 2, false)


INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'bread', 15.5, 'Kulinichi', '2021-02-22 21:52:00.000000', 1)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'milk', 31.1, 'Prostokvasheno', '2021-02-21 21:53:14.000000', 1)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'milk', 26.5, 'Pherma', '2021-02-19 21:54:51.000000', 1)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'eggs', 32, 'Nahsa Ryaba', '2021-02-17 21:55:58.000000', 1)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'cheese', 48.65, 'Komo', '2021-02-22 21:57:02.000000', 1)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'sausage', 137.25, 'Denver', '2021-02-19 21:59:00.000000', 1)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'bread', 12.75, 'Saltovskiy', '2021-02-22 21:59:55.000000', 2)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'bread', 16, 'Kulinichi', '2021-02-22 22:00:27.000000', 2)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'milk', 26.5, 'Pherma', '2021-02-19 22:01:10.000000', 2)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'sausage', 89.4, 'XMK', '2021-02-11 22:02:09.000000', 2)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'bread', 15, 'Kulinichi', '2021-02-22 21:52:00.000000', 3)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'bread', 17.5, 'Klass', '2021-02-22 22:03:39.000000', 3)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'bread', 13, 'Saltovskiy', '2021-02-21 22:04:23.000000', 3)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'milk', 32.75, 'Prostokvasheno', '2021-02-22 22:05:04.000000', 3)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'milk', 27.15, 'Pherma', '2021-02-22 22:05:39.000000', 3)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'milk', 30.45, 'Parmalat', '2021-02-19 22:06:24.000000', 3)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'cheese', 47, 'Komo', '2021-02-20 22:06:58.000000', 3)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'cheese', 54.4, 'Club four cheese', '2021-02-20 22:08:07.000000', 3)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'cement', 230.4, 'Ceresit', '2021-02-06 22:10:26.000000', 4)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'saw', 178.5, 'Intertool', '2021-01-02 22:11:06.000000', 4)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'nails', 40.6, 'Dneprometiz', '2021-02-22 22:12:06.000000', 4)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'bread', 20.3, 'Kulinichi', '2021-02-22 22:12:42.000000', 5)

INSERT INTO goods (id, name, cost, manufacturer, date, store_id)
VALUES (DEFAULT, 'milk', 35.1, 'Prostokvasheno', '2021-02-16 22:13:08.000000', 5)


update stores
set name = 'New name'
where id = 5;

delete
from goods
where id = 2;

select name, phone
from stores
where delivery = true;