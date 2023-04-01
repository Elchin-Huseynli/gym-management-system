create table gym (
    id serial primary key,
    name varchar,
    surname varchar,
    fin varchar,
    serial_number varchar,
    number_of_departures int,
    register_date date,
    update_date date,
    membership_expiration_date date,
    amount int
);

insert into gym (name, surname, fin, serial_number, number_of_departures, register_date, update_date, membership_expiration_date, amount)
values ('Elchin','Huseynli','7BFQPUS','AA1411747',12,now(),now(),'2023-05-01',80);

update gym set number_of_departures = number_of_departures - 1 where fin=? and number_of_departures>0;
update gym set number_of_departures = number_of_departures + ?, update_date=now() where fin=?;