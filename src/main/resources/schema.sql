create table task(id bigint identity, name varchar(255), startTime date, stopTime date, duration int, progress int, priority int, resourceId bigint);
insert into task values(null, 'BTHM-1378', '2018-03-14', '2018-04-16', 10, 30, 1, 1);
insert into task values(null, 'BTHM-400', '2018-04-03', '2018-04-17', 14, 70, 2, 2);
insert into task values(null, 'BTHM-365', '2018-04-07', '2018-04-11', 4, 0, 2, 3);
create table resource(id bigint identity, name varchar(255));
insert into resource values(null, 'CBK');
insert into resource values(null, 'LY');
insert into resource values(null, 'GYM');
