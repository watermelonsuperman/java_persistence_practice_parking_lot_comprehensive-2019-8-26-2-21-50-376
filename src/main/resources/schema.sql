CREATE TABLE employee (
  id INTEGER PRIMARY KEY,
  name VARCHAR(64) NOT NULL,
  age   int(4) NOT NULL
);
create TABLE parkingLot(
	parkingLotId integer primary key,
	capacity integer not null,
	availablePositionCount integer not null
);
