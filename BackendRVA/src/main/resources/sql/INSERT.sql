

INSERT INTO "smjer"("id", "naziv", "oznaka")
VALUES(nextval('smjer_seq'), 'Inženjerstvo informacionih sistema', 'IT');
INSERT INTO "smjer"("id", "naziv", "oznaka")
VALUES(nextval('smjer_seq'), 'Inženjerski menadžment', 'IM');
INSERT INTO "smjer"("id", "naziv", "oznaka")
VALUES(nextval('smjer_seq'), 'Računarstvo i automatika', 'RA');
INSERT INTO "smjer"("id", "naziv", "oznaka")
VALUES(nextval('smjer_seq'), 'Energetika, elektronika i telekomunikacije', 'EE');
INSERT INTO "smjer"("id", "naziv", "oznaka")
VALUES(nextval('smjer_seq'), 'Biomedicinsko inženjerstvo', 'BI');

INSERT INTO "smjer"("id", "naziv", "oznaka")
VALUES(-100, 'Test', 'TE');

INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 1', 1);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 2', 1);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 3', 1);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 4', 1);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 5', 1);


INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 6', 2);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 7', 2);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 8', 2);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 9', 2);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 10', 2);

INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 11', 3);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 12', 3);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 13', 3);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 14', 3);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 15', 3);

INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 16', 4);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 17', 4);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 18', 4);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 19', 4);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 20', 4);


INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 21', 5);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 22', 5);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 23', 5);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 24', 5);
INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(nextval('grupa_seq'), 'Grupa 25', 5);

INSERT INTO "grupa"("id", "oznaka", "smjer")
VALUES(-100, 'Grupa 55', 5);

INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES (nextval('projekat_seq'), 'Paint', 'PT', 'Projekat iz dizajnerskih obrazaca. U projektu se koristi Java programski jezik.');
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES (nextval('projekat_seq'), 'JustGo', 'JustGo', 'Projekat iz veb orijentisanih tehnologija. U projektu se koristi MEAN stack.');
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES (nextval('projekat_seq'), 'Advokatska kancelarija', 'AK', 'Projekat iz predmeta Projektovanje baza podataka.');
INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES (nextval('projekat_seq'), 'Volonterska organizacija', 'VO', 'Projekat iz predmeta Mobilne informacione tehnoligije');

INSERT INTO "projekat"("id", "naziv", "oznaka", "opis")
VALUES (-100, 'Test', 'TE', 'Opis test');

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Aleksandra',  'Prpić',  'IT58/2015', 5, 1);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Jelena',  'Mačkić',  'EE57/2015', 15, 2);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Aleksandar',  'Babić',  'RA53/2015', 15, 3);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Jelena',  'Medarević',  'IT50/2015', 5, 4);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Danica',  'Barać',  'BI61/2015', 4, 1);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Nataša',  'Vuković',  'IT39/2015', 13, 2);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Nikola',  'Savić',  'RA49/2015', 14, 3);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Aleksandar',  'Stojić',  'IM54/2015', 12, 4);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Tamara',  'Kuburić',  'IM62/2015', 3, 1);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Dragana',  'Miladić',  'IT63/2015', 1, 2);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Anja',  'Jurišić',  'EE64/2015', 7, 3);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Luka',  'Srdić',  'BI24/2015', 9, 4);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Bojana',  'Račić',  'RA3/2015', 7, 1);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Ljubiša',  'Vukmir',  'IT15/2015', 9, 2);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Nemanja',  'Mirčeta',  'IM25/2015', 20, 3);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Vanja',  'Ćerketa',  'BI44/2015', 21, 4);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Nikola',  'Medarević',  'EE33/2015', 22, 1);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Jovana',  'Savić',  'IT17/2015', 17, 2);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Luka',  'Ilić',  'BI27/2015', 18, 3);
INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (nextval('student_seq'), 'Nastasja',  'Brković',  'IM1/2015', 24, 4);

INSERT INTO "student"("id", "ime", "prezime", "broj_indeksa", "grupa", "projekat")
VALUES (-100, 'Test',  'TestP',  'IM55/2015', 15, 4);




