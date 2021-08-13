DROP TABLE IF EXISTS employee ;



CREATE TABLE employee
(
    employee_Id   SERIAL PRIMARY KEY ,
    first_Name    VARCHAR(12) NULL,
    last_Name     VARCHAR(50) NULL,
    department_Id BIGINT null,
    job_Title     VARCHAR(255) NULL,
    gender       VARCHAR(255) NULL,
    data_Of_Birth  DATE NULL

);

INSERT INTO employee (first_Name,last_Name,department_Id,job_Title,gender,data_Of_Birth)
VALUES ('Сигара', 'Потухшая',3,'SUPERADMIN' ,'FEMALE','2010-10-12')
     , ('Никрашш', 'НайтВульф',7, 'ADMIN' ,'MALE','2010-10-12')
     , ('Эззэссэль', 'шипящая',5, 'ADMIN' ,'FEMALE','2010-10-12')
     , ('Бэлан', 'Тсе Раа',25, 'ADMIN' ,'MALE','2010-10-12')
     , ('Элеонора', 'Бабушка',916, 'ADMIN' ,'FEMALE','2010-10-12')
     , ('Эман', 'Ухастый Летун',10, 'ADMIN' ,'MALE','2010-10-12')
     , ('Талант', 'Рожденный в Бронксе',27, 'ADMIN' ,'MALE','2010-10-12');
