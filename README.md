# Zadanie-3
Programowanie obiektowe PS

Wykorzystując technikę kompozycji stwórz następujące klasy:

Makulewski > Klasa Picture zawierająca 3 kolekcje (listy lub tablice) obiektów 1,2,3 oraz metody umożliwiające dodawanie nowych obiektów do kolekcji.

Każda z 4 klas powinna mieć:

Kozłowski > Metodę 'move(double dx, double dy)', która przesuwa pozycję obiektu o zadany wektor <dx,dy>; w klasach składających się z obiektów innych klas powinna ona wywoływać metody 'move' swoich obiektów składowych.

Metodę 'String toString()' zwracające tekstową reprezentację danego obiektu, przy czym w klasach składających się z obiektów innych klas powinna ona wywoływać metody 'toString' swoich obiektów składowych.

Metodę 'getArea()', która zwraca pole danego elementu (0 dla Point i Section), w przypadku klasy Picture zwracana wartość to suma pól obiektów w obrazie.
