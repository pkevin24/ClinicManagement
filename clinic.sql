CREATE DATABASE CLINIC TEMPLATE template0;
CREATE USER admin WITH ENCRYPTED PASSWORD '123';
GRANT ALL PRIVILEGES ON DATABASE CLINIC TO admin;


create table clinic(
C_ID INT,
CLINIC_NAME VARCHAR(25),
FEES INT,
primary key(C_ID)
);

create table DOCTOR(
D_ID INT,
DOCTOR_NAME VARCHAR(25),
SPECIALITY VARCHAR(25),
primary key(D_ID)
);

create table USERS(
USER_ID INT,
NAME VARCHAR(25),
USER_NAME VARCHAR(25),
password VARCHAR(25),
primary key(USER_ID)
);

create table APPOINTMENT(
A_ID INT,
USER_ID INT,
D_ID INT,
C_ID INT,
FOREIGN KEY(USER_ID) REFERENCES USERS(USER_ID),
FOREIGN KEY(D_ID) REFERENCES DOCTOR(D_ID),
FOREIGN KEY(C_ID) REFERENCES CLINIC(C_ID),
primary key(A_ID)
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


