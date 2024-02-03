ALTER TABLE DEPARTMENT
 DROP PRIMARY KEY CASCADE;

DROP TABLE DEPARTMENT CASCADE CONSTRAINTS;

CREATE TABLE DEPARTMENT
(
  DEP_ID    NUMBER,
  DEP_NAME  VARCHAR2(255 BYTE)                  NOT NULL
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE PROGRAM
 DROP PRIMARY KEY CASCADE;

DROP TABLE PROGRAM CASCADE CONSTRAINTS;

CREATE TABLE PROGRAM
(
  PROG_ID    NUMBER,
  PROG_NAME  VARCHAR2(255 BYTE)                 NOT NULL,
  DEP_ID     NUMBER
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE STUDENT
 DROP PRIMARY KEY CASCADE;

DROP TABLE STUDENT CASCADE CONSTRAINTS;

CREATE TABLE STUDENT
(
  NAT_ID   NUMBER,
  F_NAME   VARCHAR2(255 BYTE)                   NOT NULL,
  L_NAME   VARCHAR2(255 BYTE)                   NOT NULL,
  GENDER   VARCHAR2(10 BYTE)                    NOT NULL,
  PHONE    VARCHAR2(20 BYTE),
  EMAIL    VARCHAR2(255 BYTE),
  CITY     VARCHAR2(255 BYTE),
  STREET   VARCHAR2(255 BYTE),
  PROG_ID  NUMBER
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


CREATE OR REPLACE TRIGGER Update_StudentProgram_Trigger
AFTER Update OF prog_id ON student 
FOR EACH ROW
DECLARE
    v_prog_id  NUMBER;
    v_nat_id   NUMBER;
    v_count    NUMBER;
    v_course_id NUMBER; -- Declare v_course_id

BEGIN
    v_prog_id := :NEW.prog_id;
    v_nat_id := :NEW.nat_id;

    -- Get the count of courses for the given prog_id
    SELECT COUNT(course_id) INTO v_count FROM course WHERE prog_id = v_prog_id;
    Delete from student_course where nat_id = v_nat_id;
    -- Loop through the courses and insert into student_course
    FOR i IN 1..v_count
    LOOP
        -- Retrieve the course_id using row_number
        SELECT course_id INTO v_course_id
        FROM (
            SELECT course_id, ROW_NUMBER() OVER (ORDER BY prog_id) num
            FROM course
            WHERE prog_id = v_prog_id
            ORDER BY prog_id
        )
        WHERE num = i;

        -- Insert into student_course
        INSERT INTO student_course(nat_id, course_id) VALUES (v_nat_id, v_course_id);

    END LOOP;
EXCEPTION
    WHEN OTHERS THEN
        -- Handle exceptions
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END ;
/


CREATE OR REPLACE TRIGGER add_student_trigger
AFTER INSERT ON student
FOR EACH ROW
DECLARE
    v_prog_id  NUMBER;
    v_nat_id   NUMBER;
    v_count    NUMBER;
    v_course_id NUMBER; -- Declare v_course_id

BEGIN
    v_prog_id := :NEW.prog_id;
    v_nat_id := :NEW.nat_id;

    -- Get the count of courses for the given prog_id
    SELECT COUNT(course_id) INTO v_count FROM course WHERE prog_id = v_prog_id;

    -- Loop through the courses and insert into student_course
    FOR i IN 1..v_count
    LOOP
        -- Retrieve the course_id using row_number
        SELECT course_id INTO v_course_id
        FROM (
            SELECT course_id, ROW_NUMBER() OVER (ORDER BY prog_id) num
            FROM course
            WHERE prog_id = v_prog_id
            ORDER BY prog_id
        )
        WHERE num = i;

        -- Insert into student_course
        INSERT INTO student_course(nat_id, course_id) VALUES (v_nat_id, v_course_id);

    END LOOP;
EXCEPTION
    WHEN OTHERS THEN
        -- Handle exceptions
        DBMS_OUTPUT.PUT_LINE('An error occurred: ' || SQLERRM);
END add_student_trigger;
/


ALTER TABLE COURSE
 DROP PRIMARY KEY CASCADE;

DROP TABLE COURSE CASCADE CONSTRAINTS;

CREATE TABLE COURSE
(
  COURSE_ID    NUMBER,
  COURSE_NAME  VARCHAR2(255 BYTE)               NOT NULL,
  PROG_ID      NUMBER
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE STUDENT_COURSE
 DROP PRIMARY KEY CASCADE;

DROP TABLE STUDENT_COURSE CASCADE CONSTRAINTS;

CREATE TABLE STUDENT_COURSE
(
  NAT_ID     NUMBER,
  COURSE_ID  NUMBER,
  YEAR       VARCHAR2(20 BYTE)                  DEFAULT '2023/2024',
  SEMESTER   VARCHAR2(20 BYTE)                  DEFAULT 'First',
  GRADE      NUMBER                             DEFAULT NULL
)
TABLESPACE SYSTEM
PCTUSED    40
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            FREELISTS        1
            FREELIST GROUPS  1
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE DEPARTMENT ADD (
  PRIMARY KEY
 (DEP_ID)
    USING INDEX 
    TABLESPACE SYSTEM
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                FREELISTS        1
                FREELIST GROUPS  1
               ));

ALTER TABLE PROGRAM ADD (
  PRIMARY KEY
 (PROG_ID)
    USING INDEX 
    TABLESPACE SYSTEM
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                FREELISTS        1
                FREELIST GROUPS  1
               ));

ALTER TABLE STUDENT ADD (
  CONSTRAINT STUDENT_PK
 PRIMARY KEY
 (NAT_ID));

ALTER TABLE COURSE ADD (
  PRIMARY KEY
 (COURSE_ID)
    USING INDEX 
    TABLESPACE SYSTEM
    PCTFREE    10
    INITRANS   2
    MAXTRANS   255
    STORAGE    (
                INITIAL          64K
                NEXT             1M
                MINEXTENTS       1
                MAXEXTENTS       UNLIMITED
                PCTINCREASE      0
                FREELISTS        1
                FREELIST GROUPS  1
               ));

ALTER TABLE STUDENT_COURSE ADD (
  CONSTRAINT STUDENT_COURSE_PK
 PRIMARY KEY
 (NAT_ID, COURSE_ID, YEAR, SEMESTER));

ALTER TABLE PROGRAM ADD (
  CONSTRAINT PROGRAM_R01 
 FOREIGN KEY (DEP_ID) 
 REFERENCES DEPARTMENT (DEP_ID)
    ON DELETE CASCADE);

ALTER TABLE STUDENT ADD (
  CONSTRAINT STUDENT_R01 
 FOREIGN KEY (PROG_ID) 
 REFERENCES PROGRAM (PROG_ID)
    ON DELETE SET NULL);

ALTER TABLE COURSE ADD (
  CONSTRAINT COURSE_R01 
 FOREIGN KEY (PROG_ID) 
 REFERENCES PROGRAM (PROG_ID)
    ON DELETE CASCADE);

ALTER TABLE STUDENT_COURSE ADD (
  CONSTRAINT STUDENT_COURSE_R01 
 FOREIGN KEY (NAT_ID) 
 REFERENCES STUDENT (NAT_ID)
    ON DELETE CASCADE,
  CONSTRAINT STUDENT_COURSE_R02 
 FOREIGN KEY (COURSE_ID) 
 REFERENCES COURSE (COURSE_ID)
    ON DELETE CASCADE);
