drop table if exists shipment;
drop table if exists voyage;
drop table if exists port;
drop table if exists vessel;

create table vessel(name text primary key,
   capacity integer);
   
create table port(name text primary key);

create table voyage(
    id integer primary key autoincrement,
    depdate integer, 
    arrdate integer,
    vessel Text references vessel(name),
    depport text references port(name),
    arrport text references port(name) 
  );

create table shipment(
      id integer primary key autoincrement,
      voyageid references voyage(id),
      volume integer,
      customer text );


insert into vessel values('MAERSK MONGLA',3500);
insert into vessel values('CELSIUS BRICKELL',3500);
insert into vessel values('MERATUS TOMINI',3500);
insert into vessel values('MAERSK SONGKHLA',3500);
insert into vessel values('MAERSK VLADIVOSTOK',3500);
insert into vessel values('MAERSK JAKARTA',3500);
insert into vessel values('YM CAPACITY',3500);

insert into port values('Ningbo');
insert into port values('Surabaya');
insert into port values('Qingdao');
insert into port values('Singapore');
insert into port values('Ningbo ');
insert into port values('Hong Kong');
insert into port values('Nansha New Port');
insert into port values('Kobe');
insert into port values('Mombasa');
insert into port values('Yantian');
insert into port values('Haiphong');
insert into port values('Jakarta');
insert into port values('Hakata');
insert into port values('Nagoya');
insert into port values('Dalian');
insert into port values('Kaohsiung');
insert into port values('Xingang');
insert into port values('Dar es Salaam');
insert into port values('Tokyo');
insert into port values('Yokohama');
insert into port values('Chittagong');
insert into port values('Laem Chabang');
insert into port values('Tanjung Pelepas');
insert into port values('Bangkok');
insert into port values('Keelung');
insert into port values('Shanghai');

insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230424,230428,'MERATUS TOMINI','Laem Chabang','Bangkok');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230425,230426,'MERATUS TOMINI','Laem Chabang','Bangkok');

insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230423,230424,'MERATUS TOMINI','Laem Chabang','Bangkok');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230424,230425,'MERATUS TOMINI','Bangkok','Laem Chabang');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230425,230430,'MERATUS TOMINI','Laem Chabang','Hong Kong');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230430,230501,'MERATUS TOMINI','Hong Kong','Nansha New Port');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230501,230506,'MERATUS TOMINI','Nansha New Port','Tokyo');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230506,230507,'MERATUS TOMINI','Tokyo','Yokohama');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230507,230508,'MERATUS TOMINI','Yokohama','Nagoya');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230508,230509,'MERATUS TOMINI','Nagoya','Kobe');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230509,230511,'MERATUS TOMINI','Kobe','Hakata');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230401,230402,'MAERSK MONGLA','Kaohsiung','Keelung');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230402,230404,'MAERSK MONGLA','Keelung','Nansha New Port');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230404,230405,'MAERSK MONGLA','Nansha New Port','Yantian');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230405,230406,'MAERSK MONGLA','Yantian','Hong Kong');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230406,230415,'MAERSK MONGLA','Hong Kong','Chittagong');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230407,230408,'YM CAPACITY','Tokyo','Yokohama');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230408,230409,'YM CAPACITY','Yokohama','Nagoya');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230409,230410,'YM CAPACITY','Nagoya','Kobe');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230410,230412,'YM CAPACITY','Kobe','Hakata');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230412,230416,'YM CAPACITY','Hakata','Yantian');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230416,230417,'YM CAPACITY','Yantian','Hong Kong');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230417,230422,'YM CAPACITY','Hong Kong','Laem Chabang');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230422,230423,'YM CAPACITY','Laem Chabang','Bangkok');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230423,230424,'YM CAPACITY','Bangkok','Laem Chabang');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230403,230407,'MAERSK VLADIVOSTOK','Shanghai','Dalian');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230407,230409,'MAERSK VLADIVOSTOK','Dalian','Xingang');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230409,230412,'MAERSK VLADIVOSTOK','Xingang','Qingdao');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230412,230415,'MAERSK VLADIVOSTOK','Qingdao','Keelung');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230415,230421,'MAERSK VLADIVOSTOK','Keelung','Singapore');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230421,230421,'MAERSK VLADIVOSTOK','Singapore','Tanjung Pelepas');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230421,230424,'MAERSK VLADIVOSTOK','Tanjung Pelepas','Jakarta');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230424,230426,'MAERSK VLADIVOSTOK','Jakarta','Surabaya');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230403,230411,'MAERSK SONGKHLA','Chittagong','Tanjung Pelepas');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230411,230413,'MAERSK SONGKHLA','Tanjung Pelepas','Singapore');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230413,230417,'MAERSK SONGKHLA','Singapore','Laem Chabang');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230417,230425,'MAERSK SONGKHLA','Laem Chabang','Ningbo');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230425,230425,'MAERSK SONGKHLA','Ningbo','Shanghai');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230402,230410,'MAERSK JAKARTA','Chittagong','Singapore');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230410,230411,'MAERSK JAKARTA','Singapore','Tanjung Pelepas');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230411,230418,'MAERSK JAKARTA','Tanjung Pelepas','Keelung');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230418,230420,'MAERSK JAKARTA','Keelung','Kaohsiung');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230420,230422,'MAERSK JAKARTA','Kaohsiung','Hong Kong');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230422,230425,'MAERSK JAKARTA','Hong Kong','Haiphong');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230425,230428,'MAERSK JAKARTA','Haiphong','Hong Kong');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230428,230430,'MAERSK JAKARTA','Hong Kong','Kaohsiung');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230430,230501,'MAERSK JAKARTA','Kaohsiung','Keelung');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230408,230412,'CELSIUS BRICKELL','Ningbo ','Nansha New Port');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230412,230416,'CELSIUS BRICKELL','Nansha New Port','Tanjung Pelepas');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230416,230429,'CELSIUS BRICKELL','Tanjung Pelepas','Mombasa');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230429,230504,'CELSIUS BRICKELL','Mombasa','Dar es Salaam');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230504,230517,'CELSIUS BRICKELL','Dar es Salaam','Tanjung Pelepas');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230517,230520,'CELSIUS BRICKELL','Tanjung Pelepas','Laem Chabang');
insert into voyage (depdate,arrdate,vessel,depport,arrport) values (230520,230520,'CELSIUS BRICKELL','Laem Chabang','Ningbo');

INSERT INTO SHIPMENT (voyageid, volume, customer) 
VALUES (1, 3000, "Nicolai");

INSERT INTO SHIPMENT (voyageid, volume, customer) 
VALUES (1, 3000, "Nicolai");

INSERT INTO SHIPMENT (voyageid, volume, customer) 
VALUES (2, 3000, "Nicolai");

INSERT INTO SHIPMENT (voyageid, volume, customer) 
VALUES (3, 3000, "Nicolai");

SELECT * FROM shipment;

SELECT vessel.capacity, vessel.name, voyage.depdate, voyage.arrdate, voyage.vessel
From vessel
INNER JOIN Voyage on vessel.name = voyage.vessel;

SELECT shipment.voyageid, shipment.volume, voyage.vessel, voyage.id
FROM shipment
JOIN voyage on shipment.voyageid = voyage.id;

SELECT *
FROM voyage;

INSERT INTO SHIPMENT (voyageid, volume, customer) 
VALUES (10, 3000, "TEST");

SELECT shipment.voyageid, shipment.volume, voyage.vessel, voyage.id, vessel.capacity, voyage.depport, voyage.arrport, voyage.depdate, voyage.arrdate,
SUM(CASE WHEN shipment.voyageid = voyage.id THEN shipment.volume ELSE 0 END) total_volume
FROM shipment
JOIN voyage on shipment.voyageid = voyage.id
JOIN Vessel on voyage.vessel = vessel.name
GROUP BY shipment.voyageid;
-- HAVING total_volume > vessel.capacity;




INSERT INTO SHIPMENT (voyageid, volume, customer) 
VALUES (10, 3000, "TEST");


SELECT *
FROM voyage;

SELECT * FROM VESSEL;

SELECT v1.vessel, v1.depdate, v1.arrdate, v1.id,
v2.vessel, v2.depdate, v2.arrdate, v2.id
from voyage v1 inner join voyage v2
WHERE v1.vessel = v2.vessel AND v1.depdate <=  v2.depdate 
AND v1.arrdate > v2.depdate AND v1.id <> v2.id AND v1.depdate < v2.arrdate;

SELECT name from port;



SELECT shipment.voyageid, shipment.volume, voyage.vessel, voyage.id, vessel.capacity, voyage.depport, voyage.arrport, voyage.depdate, voyage.arrdate,
SUM(CASE WHEN shipment.voyageid = voyage.id THEN shipment.volume ELSE 0 END) total_volume
FROM shipment
JOIN voyage on shipment.voyageid = voyage.id
JOIN Vessel on voyage.vessel = vessel.name
GROUP BY shipment.voyageid;
-- HAVING total_volume > vessel.capacity;


SELECT voyage.id, voyage.depdate, voyage.arrdate, voyage.vessel, 
voyage.depport, voyage.arrport, vessel.capacity,
COALESCE(SUM(shipment.volume),0) as current_volume
FROM voyage
INNER JOIN vessel ON voyage.vessel = vessel.name
LEFT JOIN shipment ON voyage.id = shipment.voyageid -- display all records from voyage, but also display if matching records from shipment

GROUP BY voyage.id;

-- COALESCE(SUM(shipment.volume), 0) as current_volume
 -- allows us to count the current capacity of all shipments, but group the capacity by voyage.id;

-- we want to show all vessels even if current_volume is not entered

SELECT * 
FROM shipment;

SELECT voyage.id, voyage.depdate, voyage.arrdate, voyage.vessel, 
voyage.depport, voyage.arrport, vessel.capacity,
COALESCE(SUM(shipment.volume),0) as current_volume
FROM voyage
INNER JOIN vessel ON voyage.vessel = vessel.name
LEFT JOIN shipment ON voyage.id = shipment.voyageid
WHERE depdate >= 230422 AND depport = "Laem Chabang" AND arrport = "Bangkok"
GROUP BY voyage.id
HAVING current_volume + 0 <= capacity;



SELECT voyage.id, voyage.depdate, voyage.arrdate, voyage.vessel, 
voyage.depport, voyage.arrport, vessel.capacity,
COALESCE(SUM(shipment.volume),0) as current_volume
FROM voyage
INNER JOIN vessel ON voyage.vessel = vessel.name
LEFT JOIN shipment ON voyage.id = shipment.voyageid
GROUP BY voyage.id;

SELECT * FROM voyage
INNER JOIN vessel on voyage.vessel = vessel.name
Where ID = 1;

INSERT INTO SHIPMENT (voyageid, volume, customer) VALUES(1, 30, "TEST");

SELECT * FROM shipment;

-- WHERE depdate = 230424 AND depport = Laem Chabang AND arrport = Bangkok AND total_volume <= capacity AND total_volume <= userinputvolume+total_volume



SELECT voyage.id,
COALESCE(SUM(shipment.volume),0) as current_volume
FROM voyage
LEFT JOIN shipment ON voyage.id = shipment.voyageid
GROUP BY voyage.id;


SELECT voyage.id, voyage.depdate, voyage.arrdate, voyage.vessel,
voyage.depport, voyage.arrport, vessel.capacity,
COALESCE(SUM(shipment.volume),0) as current_volume
FROM voyage
LEFT JOIN vessel ON voyage.vessel = vessel.name
LEFT JOIN shipment ON voyage.id = shipment.voyageid -- display all records from voyage, but also display if matching records from shipment

GROUP BY voyage.id;

SELECT v1.vessel, v1.depdate, v1.arrdate, v1.id,
v2.vessel, v2.depdate, v2.arrdate, v2.id
from voyage v1 inner join voyage v2
WHERE v1.vessel = v2.vessel AND v1.depdate <=  v2.depdate
AND v1.arrdate > v2.depdate AND v1.id <> v2.id AND v1.depdate < v2.arrdate;

SELECT * from shipment;
SELECT * from shipment;

INSERT INTO SHIPMENT (voyageid, volume, customer) 
VALUES (1, 3000, "TESTss");

SELECT * from shipment;