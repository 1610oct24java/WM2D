--------------------------------------------------------
--  File created - Friday-December-09-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table IMAGE_TABLE
--------------------------------------------------------

  CREATE TABLE "WM2D"."IMAGE_TABLE" 
   (	"IMAGE_ID" NUMBER, 
	"FILE_TYPE" VARCHAR2(10 BYTE), 
	"FILE_DATA" BLOB
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("FILE_DATA") STORE AS SECUREFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192
  NOCACHE LOGGING  NOCOMPRESS  KEEP_DUPLICATES 
  STORAGE(INITIAL 106496 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table ITEM_TABLE
--------------------------------------------------------

  CREATE TABLE "WM2D"."ITEM_TABLE" 
   (	"ITEM_ID" NUMBER, 
	"ITEM_NAME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RECIPE_ITEM_TABLE
--------------------------------------------------------

  CREATE TABLE "WM2D"."RECIPE_ITEM_TABLE" 
   (	"RECIPE_ID" NUMBER, 
	"ITEM_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table RECIPE_TABLE
--------------------------------------------------------

  CREATE TABLE "WM2D"."RECIPE_TABLE" 
   (	"RECIPE_ID" NUMBER, 
	"RECIPE_NAME" VARCHAR2(255 BYTE), 
	"RECIPE_DESCRIPTION" VARCHAR2(510 BYTE), 
	"RECIPE_URL" VARCHAR2(255 BYTE), 
	"IMAGE_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USER_ITEM_TABLE
--------------------------------------------------------

  CREATE TABLE "WM2D"."USER_ITEM_TABLE" 
   (	"USER_ID" NUMBER, 
	"ITEM_ID" NUMBER, 
	"MEASURE_TYPE" VARCHAR2(20 BYTE), 
	"MEASURE_AMOUNT" NUMBER, 
	"EXPIRATION_DATE" VARCHAR2(30 BYTE), 
	"ITEM_STATUS" NUMBER DEFAULT 1, 
	"ITEM_DETAILS" VARCHAR2(30 BYTE), 
	"USER_ITEM_ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table USER_TABLE
--------------------------------------------------------

  CREATE TABLE "WM2D"."USER_TABLE" 
   (	"USER_ID" NUMBER, 
	"USER_NAME" VARCHAR2(20 BYTE), 
	"PASS_WORD" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Sequence NEW_IMAGE_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "WM2D"."NEW_IMAGE_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 51 CACHE 50 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence NEW_ITEM_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "WM2D"."NEW_ITEM_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 251 CACHE 50 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence NEW_RECIPE_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "WM2D"."NEW_RECIPE_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 151 CACHE 50 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence NEW_USER_SEQUENCE
--------------------------------------------------------

   CREATE SEQUENCE  "WM2D"."NEW_USER_SEQUENCE"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 301 CACHE 50 NOORDER  NOCYCLE  NOPARTITION ;
--------------------------------------------------------
--  DDL for Sequence SEQ_TDAI_USER_ITEM_TABLE4
--------------------------------------------------------

   CREATE SEQUENCE  "WM2D"."SEQ_TDAI_USER_ITEM_TABLE4"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 101 CACHE 20 NOORDER  NOCYCLE  NOPARTITION ;
REM INSERTING into WM2D.IMAGE_TABLE
SET DEFINE OFF;
Insert into WM2D.IMAGE_TABLE (IMAGE_ID,FILE_TYPE) values (0,'DUMMY');
REM INSERTING into WM2D.ITEM_TABLE
SET DEFINE OFF;
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (52,'Cheese');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (2,'Chicken');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (156,'Children');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (109,'Eggs');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (108,'Flour');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (104,'Garlic');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (152,'Giraffe');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (101,'Lettuce');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (51,'Noodles');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (103,'Onion');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (102,'Pepper');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (106,'Pork');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (159,'Silly little monkey toes');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (160,'Thangs');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (107,'Tomato');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (158,'Turkey');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (151,'Turtle');
Insert into WM2D.ITEM_TABLE (ITEM_ID,ITEM_NAME) values (161,'Turtles');
REM INSERTING into WM2D.RECIPE_ITEM_TABLE
SET DEFINE OFF;
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (4,2);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (5,51);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (5,52);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (101,51);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (101,107);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (101,52);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (101,103);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (101,104);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (101,102);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (104,106);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (104,103);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (104,104);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (105,2);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (105,51);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (105,52);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (105,102);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (105,103);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (105,104);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (105,107);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (106,108);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (107,101);
Insert into WM2D.RECIPE_ITEM_TABLE (RECIPE_ID,ITEM_ID) values (107,107);
REM INSERTING into WM2D.RECIPE_TABLE
SET DEFINE OFF;
Insert into WM2D.RECIPE_TABLE (RECIPE_ID,RECIPE_NAME,RECIPE_DESCRIPTION,RECIPE_URL,IMAGE_ID) values (4,'chicken','just eat the chicken','http://troutslap.tk',0);
Insert into WM2D.RECIPE_TABLE (RECIPE_ID,RECIPE_NAME,RECIPE_DESCRIPTION,RECIPE_URL,IMAGE_ID) values (5,'Mac and Cheese','Mac... and... uh.... cheese',null,0);
Insert into WM2D.RECIPE_TABLE (RECIPE_ID,RECIPE_NAME,RECIPE_DESCRIPTION,RECIPE_URL,IMAGE_ID) values (51,'Scrambled Eggs','eggs that are scrambled',null,0);
Insert into WM2D.RECIPE_TABLE (RECIPE_ID,RECIPE_NAME,RECIPE_DESCRIPTION,RECIPE_URL,IMAGE_ID) values (101,'Itsa spaghetti','Itsa easy',null,0);
Insert into WM2D.RECIPE_TABLE (RECIPE_ID,RECIPE_NAME,RECIPE_DESCRIPTION,RECIPE_URL,IMAGE_ID) values (104,'Pork Medalions',null,null,0);
Insert into WM2D.RECIPE_TABLE (RECIPE_ID,RECIPE_NAME,RECIPE_DESCRIPTION,RECIPE_URL,IMAGE_ID) values (105,'Parmesian Chicken','Its going to be complex','http://www.google.com',0);
Insert into WM2D.RECIPE_TABLE (RECIPE_ID,RECIPE_NAME,RECIPE_DESCRIPTION,RECIPE_URL,IMAGE_ID) values (106,'Pancakes','Not all ingredients listed',null,0);
Insert into WM2D.RECIPE_TABLE (RECIPE_ID,RECIPE_NAME,RECIPE_DESCRIPTION,RECIPE_URL,IMAGE_ID) values (107,'Salad','This had to happen',null,0);
REM INSERTING into WM2D.USER_ITEM_TABLE
SET DEFINE OFF;
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,152,'Meats',56,'1234-12-31T05:00:00.000Z',-1,'Tasty',92);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (151,51,'boxes',2,'12/20/2011',1,'Usin the Noodle',41);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,152,'shells',123,'5678-12-31T05:00:00.000Z',1,'Toitles',96);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,161,'shells',123,'5678-12-31T05:00:00.000Z',-1,null,95);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,151,'shells',123,'5678-12-31T05:00:00.000Z',1,null,97);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (101,2,'pounds',1,'12/12/2012',1,'Da Chicken',1);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (101,52,'ounces',23,'01/01/2018',1,null,21);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (151,52,'ounces',12,'02/30/3004',1,null,42);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (151,109,'cartons',5,'05/03/1000',1,'Green Eggs',43);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (151,107,'plants',17,'00/00/0000',1,null,44);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (151,102,'pots',3,'11/11/1111',1,'Pipin hot!',45);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,109,'chickens',7,'01/04/2016',-1,null,46);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,101,'pray',666,'06/06/2006',-1,'Maybe?',47);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,106,'shanks',4,'07/03/1234',-1,null,48);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,52,'pounds',33,'09/07/7896',-1,'How many noodles is that?',49);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,108,'bags',1,'05/4/3456',-1,null,50);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (201,106,'chunks',6,'04/03/6789',0,'Suckling',51);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (201,51,'strips',7,'04/03/0212',1,null,52);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (201,104,'cloves',30,'23/11/3122',2,'For the vampires',53);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (201,103,'funion',78,'05/09/2016',1,null,54);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (201,2,'breasts',0,'03/26/2041',1,'Heh... breasts',55);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (251,109,'yolks',3,'05/31/2015',1,null,56);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (251,102,'chili',1.5,'04/03/3014',1,'Chillin with mah peppas',57);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (251,51,'strings',23.1,'06/08/2010',1,null,58);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (251,52,'sticks',88,'06/02/1992',1,'Stringy',59);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (251,102,'count',2,'06/19/1994',1,null,60);
Insert into WM2D.USER_ITEM_TABLE (USER_ID,ITEM_ID,MEASURE_TYPE,MEASURE_AMOUNT,EXPIRATION_DATE,ITEM_STATUS,ITEM_DETAILS,USER_ITEM_ID) values (154,151,'Shells',123,'5678-12-31T05:00:00.000Z',-1,'Toitles',91);
REM INSERTING into WM2D.USER_TABLE
SET DEFINE OFF;
Insert into WM2D.USER_TABLE (USER_ID,USER_NAME,PASS_WORD) values (151,'mike','mike');
Insert into WM2D.USER_TABLE (USER_ID,USER_NAME,PASS_WORD) values (201,'employee','password');
Insert into WM2D.USER_TABLE (USER_ID,USER_NAME,PASS_WORD) values (251,'ShmkrD','pwd');
Insert into WM2D.USER_TABLE (USER_ID,USER_NAME,PASS_WORD) values (101,'Alpha','Alpha');
Insert into WM2D.USER_TABLE (USER_ID,USER_NAME,PASS_WORD) values (154,'Willie','ASD');
--------------------------------------------------------
--  DDL for Index IID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WM2D"."IID_PK" ON "WM2D"."ITEM_TABLE" ("ITEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index IMID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WM2D"."IMID_PK" ON "WM2D"."IMAGE_TABLE" ("IMAGE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index RID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WM2D"."RID_PK" ON "WM2D"."RECIPE_TABLE" ("RECIPE_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005333
--------------------------------------------------------

  CREATE UNIQUE INDEX "WM2D"."SYS_C005333" ON "WM2D"."USER_TABLE" ("USER_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005336
--------------------------------------------------------

  CREATE UNIQUE INDEX "WM2D"."SYS_C005336" ON "WM2D"."ITEM_TABLE" ("ITEM_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005340
--------------------------------------------------------

  CREATE UNIQUE INDEX "WM2D"."SYS_C005340" ON "WM2D"."RECIPE_TABLE" ("RECIPE_NAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C005363
--------------------------------------------------------

  CREATE UNIQUE INDEX "WM2D"."SYS_C005363" ON "WM2D"."USER_ITEM_TABLE" ("USER_ITEM_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_IL0000020801C00003$$
--------------------------------------------------------

  CREATE UNIQUE INDEX "WM2D"."SYS_IL0000020801C00003$$" ON "WM2D"."IMAGE_TABLE" (
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
  PARALLEL (DEGREE 0 INSTANCES 0) ;
--------------------------------------------------------
--  DDL for Index UID_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "WM2D"."UID_PK" ON "WM2D"."USER_TABLE" ("USER_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger IMAGE_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "WM2D"."IMAGE_TRIGGER" 
BEFORE INSERT ON IMAGE_TABLE FOR EACH ROW
  BEGIN
    SELECT NEW_IMAGE_SEQUENCE.NEXTVAL
    INTO   :NEW.IMAGE_ID
    FROM   DUAL;
  END;
/
ALTER TRIGGER "WM2D"."IMAGE_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger ITEM_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "WM2D"."ITEM_TRIGGER" 
BEFORE INSERT ON ITEM_TABLE FOR EACH ROW
  BEGIN
    SELECT NEW_ITEM_SEQUENCE.NEXTVAL
    INTO   :NEW.ITEM_ID
    FROM   DUAL;
  END;
/
ALTER TRIGGER "WM2D"."ITEM_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RECIPE_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "WM2D"."RECIPE_TRIGGER" 
BEFORE INSERT ON RECIPE_TABLE FOR EACH ROW
  BEGIN
    SELECT NEW_RECIPE_SEQUENCE.NEXTVAL
    INTO   :NEW.RECIPE_ID
    FROM   DUAL;
  END;
/
ALTER TRIGGER "WM2D"."RECIPE_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TR_TDAI_USER_ITEM_TABLE4
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "WM2D"."TR_TDAI_USER_ITEM_TABLE4" 
   BEFORE INSERT
   ON WM2D.USER_ITEM_TABLE
   REFERENCING NEW AS new OLD AS old
   FOR EACH ROW
BEGIN
   SELECT WM2D.SEQ_TDAI_USER_ITEM_TABLE4.NEXTVAL
     INTO :new.USER_ITEM_ID
     FROM DUAL;
END;
/
ALTER TRIGGER "WM2D"."TR_TDAI_USER_ITEM_TABLE4" ENABLE;
--------------------------------------------------------
--  DDL for Trigger USER_TRIGGER
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE TRIGGER "WM2D"."USER_TRIGGER" 
BEFORE INSERT ON USER_TABLE FOR EACH ROW
  BEGIN
    SELECT NEW_USER_SEQUENCE.NEXTVAL
    INTO   :NEW.USER_ID
    FROM   DUAL;
  END;
/
ALTER TRIGGER "WM2D"."USER_TRIGGER" ENABLE;
--------------------------------------------------------
--  DDL for Function CHECK_USER_EXISTANCE
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "WM2D"."CHECK_USER_EXISTANCE" (USERIN IN VARCHAR) 
  RETURN NUMBER IS EXISTANCE NUMBER;
  BEGIN
    SELECT COUNT(*)
    INTO EXISTANCE
    FROM USER_TABLE
    WHERE USER_NAME = USERIN;
    RETURN EXISTANCE;
  END;

/
--------------------------------------------------------
--  DDL for Function VALIDATE_PASSWORD
--------------------------------------------------------

  CREATE OR REPLACE EDITIONABLE FUNCTION "WM2D"."VALIDATE_PASSWORD" (USERIN IN VARCHAR,PASSIN IN VARCHAR) 
  RETURN NUMBER IS EXISTANCE NUMBER;
  BEGIN
    SELECT COUNT(*)
    INTO EXISTANCE
    FROM USER_TABLE
    WHERE USER_NAME = USERIN 
      AND PASS_WORD = PASSIN;
    RETURN EXISTANCE;
  END;

/
--------------------------------------------------------
--  Constraints for Table IMAGE_TABLE
--------------------------------------------------------

  ALTER TABLE "WM2D"."IMAGE_TABLE" ADD CONSTRAINT "IMID_PK" PRIMARY KEY ("IMAGE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ITEM_TABLE
--------------------------------------------------------

  ALTER TABLE "WM2D"."ITEM_TABLE" ADD UNIQUE ("ITEM_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "WM2D"."ITEM_TABLE" ADD CONSTRAINT "IID_PK" PRIMARY KEY ("ITEM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "WM2D"."ITEM_TABLE" MODIFY ("ITEM_NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RECIPE_TABLE
--------------------------------------------------------

  ALTER TABLE "WM2D"."RECIPE_TABLE" ADD UNIQUE ("RECIPE_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "WM2D"."RECIPE_TABLE" ADD CONSTRAINT "RID_PK" PRIMARY KEY ("RECIPE_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "WM2D"."RECIPE_TABLE" MODIFY ("RECIPE_NAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_ITEM_TABLE
--------------------------------------------------------

  ALTER TABLE "WM2D"."USER_ITEM_TABLE" ADD PRIMARY KEY ("USER_ITEM_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "WM2D"."USER_ITEM_TABLE" MODIFY ("USER_ITEM_ID" NOT NULL ENABLE);
  ALTER TABLE "WM2D"."USER_ITEM_TABLE" ADD CONSTRAINT "RESTRICT_STATUS" CHECK (ITEM_STATUS IN (-1,0,1,2)) ENABLE;
  ALTER TABLE "WM2D"."USER_ITEM_TABLE" MODIFY ("ITEM_STATUS" NOT NULL ENABLE);
  ALTER TABLE "WM2D"."USER_ITEM_TABLE" MODIFY ("EXPIRATION_DATE" NOT NULL ENABLE);
  ALTER TABLE "WM2D"."USER_ITEM_TABLE" MODIFY ("MEASURE_AMOUNT" NOT NULL ENABLE);
  ALTER TABLE "WM2D"."USER_ITEM_TABLE" MODIFY ("MEASURE_TYPE" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table USER_TABLE
--------------------------------------------------------

  ALTER TABLE "WM2D"."USER_TABLE" ADD UNIQUE ("USER_NAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "WM2D"."USER_TABLE" ADD CONSTRAINT "UID_PK" PRIMARY KEY ("USER_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "WM2D"."USER_TABLE" MODIFY ("PASS_WORD" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table RECIPE_ITEM_TABLE
--------------------------------------------------------

  ALTER TABLE "WM2D"."RECIPE_ITEM_TABLE" ADD CONSTRAINT "IID_R_FK" FOREIGN KEY ("ITEM_ID")
	  REFERENCES "WM2D"."ITEM_TABLE" ("ITEM_ID") ENABLE;
  ALTER TABLE "WM2D"."RECIPE_ITEM_TABLE" ADD CONSTRAINT "RID_R_FK" FOREIGN KEY ("RECIPE_ID")
	  REFERENCES "WM2D"."RECIPE_TABLE" ("RECIPE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RECIPE_TABLE
--------------------------------------------------------

  ALTER TABLE "WM2D"."RECIPE_TABLE" ADD CONSTRAINT "IMID_FK" FOREIGN KEY ("IMAGE_ID")
	  REFERENCES "WM2D"."IMAGE_TABLE" ("IMAGE_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table USER_ITEM_TABLE
--------------------------------------------------------

  ALTER TABLE "WM2D"."USER_ITEM_TABLE" ADD CONSTRAINT "IID_I_FK" FOREIGN KEY ("ITEM_ID")
	  REFERENCES "WM2D"."ITEM_TABLE" ("ITEM_ID") ENABLE;
  ALTER TABLE "WM2D"."USER_ITEM_TABLE" ADD CONSTRAINT "UID_I_FK" FOREIGN KEY ("USER_ID")
	  REFERENCES "WM2D"."USER_TABLE" ("USER_ID") ENABLE;