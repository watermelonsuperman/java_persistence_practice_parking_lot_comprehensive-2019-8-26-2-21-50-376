CREATE TABLE employee (
  id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL,
   
);
create TABLE parkingLot(
	parkingLotId INTEGER PRIMARY KEY,
	capacity integer not null,
	availablePositionCount integer not null,
	id INTEGER
);
