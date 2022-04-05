ALTER TABLE TRANSACTION ADD FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER (ID);


Insert into CUSTOMER values(1,'TJ');
Insert into CUSTOMER values(2,'Edward');
Insert into CUSTOMER values(3,'Wei');
Insert into CUSTOMER values(4,'Coddy');
Insert into CUSTOMER values(5,'Salman');
Insert into CUSTOMER values(6,'Brett');
Insert into CUSTOMER values(7,'Sassy');



Insert into Transaction values(1001,1,50,'2021-12-04');
Insert into Transaction values(1002,1,10,'2022-01-04');
Insert into Transaction values(1003,1,150,'2022-02-04');
Insert into Transaction values(1004,1,150,'2022-03-04');
Insert into Transaction values(1005,1,50,'2022-04-04');

Insert into Transaction values(1006,2,120,'2021-12-04');
Insert into Transaction values(1007,2,110,'2022-01-04');
Insert into Transaction values(1008,2,140,'2022-02-06');
Insert into Transaction values(1009,2,120,'2022-03-05');
Insert into Transaction values(1010,2,120,'2022-04-01');

Insert into Transaction values(1011,3,55,'2022-03-30');

Insert into Transaction values(1012,4,105,'2022-02-28');

Insert into Transaction values(1013,5,35,'2022-03-31');

Insert into Transaction values(1014,6,200,'2018-06-13');

Insert into Transaction values(1015,7,100,'2022-03-25');
