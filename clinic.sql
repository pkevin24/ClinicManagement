CREATE DATABASE CLINIC TEMPLATE template0;
CREATE USER admin WITH ENCRYPTED PASSWORD '123';
GRANT ALL PRIVILEGES ON DATABASE CLINIC TO admin;


create table clinic(
ID INT,
CLINIC_NAME VARCHAR(25),
primary key(ID)
);

CREATE TABLE SCHEDULE(
    ID INT,
    CLINIC_ID INT,
    DOCTOR_ID INT,
    FEES INT,
    FOREIGN KEY(Doctor_ID) REFERENCES DOCTOR(ID),
    FOREIGN KEY(CLINIC_ID) REFERENCES CLINIC(ID),
    PRIMARY KEY (ID)
);

create table DOCTOR(
ID INT,
DOCTOR_NAME VARCHAR(25),
SPECIALITY VARCHAR(25),
primary key(ID)
);

create table USERS(
ID INT,
NAME VARCHAR(25),
USER_NAME VARCHAR(25),
password VARCHAR(25),
primary key(ID)
);

create table APPOINTMENT(
ID INT,
USER_ID INT,
Doctor_ID INT,
CLINIC_ID INT,
FOREIGN KEY(USER_ID) REFERENCES USERS(ID),
FOREIGN KEY(Doctor_ID) REFERENCES DOCTOR(ID),
FOREIGN KEY(CLINIC_ID) REFERENCES CLINIC(ID),
primary key(ID)
);

insert into CLINIC values
(1,'CLINIC1',400),
(2,'CLINIC2',500),
(3,'CLINIC3',600),
(4,'CLINIC4',500),
(5,'CLINIC5',400);

insert into DOCTOR values
(1,'DR1','PED'),
(2,'DR2','ENT'),
(3,'DR3','PHYSIO'),
(4,'DR4','GENERAL'),
(5,'DR5','ORTHO');


