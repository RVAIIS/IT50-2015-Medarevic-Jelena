DROP TABLE IF EXISTS smjer CASCADE;
DROP TABLE IF EXISTS grupa CASCADE;
DROP TABLE IF EXISTS student CASCADE;
DROP TABLE IF EXISTS projekat CASCADE;

DROP SEQUENCE IF EXISTS smjer_seq;
DROP SEQUENCE IF EXISTS grupa_seq;
DROP SEQUENCE IF EXISTS student_seq;
DROP SEQUENCE IF EXISTS projekat_seq;

CREATE TABLE smjer(
	id integer NOT NULL,
    naziv varchar(100) NOT NULL,
    oznaka varchar(50)
);

CREATE TABLE grupa(
	id integer NOT NULL,
    oznaka VARCHAR(10) NOT NULL,
    smjer integer NOT NULL
);

CREATE TABLE student(
	id integer NOT NULL,
    ime VARCHAR(50) NOT NULL,
    prezime VARCHAR(50) NOT NULL,
    broj_indeksa VARCHAR(20) NOT NULL,
    grupa integer NOT NULL,
    projekat integer NOT NULL
);

CREATE TABLE projekat(
	id integer NOT NULL,
    naziv VARCHAR(100) NOT NULL,
    oznaka VARCHAR(10) NOT NULL,
    opis VARCHAR(500) NOT NULL
);

ALTER TABLE smjer ADD CONSTRAINT PK_Smjer
	PRIMARY KEY(id);
ALTER TABLE grupa ADD CONSTRAINT PK_Grupa
	PRIMARY KEY(id);
ALTER TABLE student ADD CONSTRAINT PK_Student
	PRIMARY KEY(id);
ALTER TABLE projekat ADD CONSTRAINT PK_Projekat
	PRIMARY KEY(id);

ALTER TABLE grupa ADD CONSTRAINT FK_Grupa_Smjer
	FOREIGN KEY (smjer) REFERENCES smjer (id);
ALTER TABLE student ADD CONSTRAINT FK_Student_Grupa
	FOREIGN KEY (grupa) REFERENCES grupa (id);
ALTER TABLE student ADD CONSTRAINT FK_Student_Projekat
	FOREIGN KEY (projekat) REFERENCES projekat (id);

CREATE INDEX IDXFK_Student_Grupa
	ON student (grupa);
CREATE INDEX IDXFK_Student_Projekat
	ON student (projekat);
CREATE INDEX IDXFK_Grupa_Smjer
	ON grupa (smjer);
	
CREATE SEQUENCE smjer_seq
INCREMENT 1;
CREATE SEQUENCE grupa_seq
INCREMENT 1;
CREATE SEQUENCE student_seq
INCREMENT 1;
CREATE SEQUENCE projekat_seq
INCREMENT 1;