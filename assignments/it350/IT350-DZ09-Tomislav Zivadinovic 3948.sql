--IT350-DZ09-Tomislav Zivadinovic 3948

3948 % 30 = 18 + 1
--19. Napisati upit koji kao rezultat daje podatke o svim studentima na fakultetu, od podataka izdvojiti indeks, ime i prezime i mesto i datum rođenja.
SELECT indeks, ime, prezime, grad_rodjenja, datum_rodjenja FROM student;

3967 % 30 = 7 + 1
--8. Napisati upit kojim se prikazuju podaci samo o onim predmetima koji vrede 5, 7 i 9 ESPB-a.
SELECT * FROM predmet WHERE espb='5' OR espb='7' OR espb='9';

3956 % 30 = 26 + 1
--27. Napisati upit kojim se prikazuju podaci o Internet studentima. Prikazati indeks, ime, prezime I datum rođenja za svakog internet studenta.
SELECT indeks, ime, prezime, datum_rodjenja FROM student WHERE tip_studiranja LIKE 'Internet';