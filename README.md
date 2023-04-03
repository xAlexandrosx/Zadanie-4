# Zadanie-3
Programowanie obiektowe PS

Wykorzystując technikę kompozycji stwórz następujące klasy:

Klasa Picture zawierająca 3 kolekcje (listy lub tablice) obiektów 1,2,3 oraz metody umożliwiające dodawanie nowych obiektów do kolekcji.
Każda z 4 klas powinna mieć:

Metodę 'move(double dx, double dy)', która przesuwa pozycję obiektu o zadany wektor <dx,dy>; w klasach składających się z obiektów innych klas powinna ona wywoływać metody 'move' swoich obiektów składowych.

Metodę 'String toString()' zwracające tekstową reprezentację danego obiektu, przy czym w klasach składających się z obiektów innych klas powinna ona wywoływać metody 'toString' swoich obiektów składowych.

Metodę 'getArea()', która zwraca pole danego elementu (0 dla Point i Section), w przypadku klasy Picture zwracana wartość to suma pól obiektów w obrazie.

W programie zaimplementuj proste menu, które pozwala na: dodawanie punktów/odcinków/okręgów do obiektu obrazu (Picture), wyswietlanie obiektu Picture (każdy element w postaci tekstowej w osobnej linii), przesuwanie całego obrazu (wszystkich obiektów w obrazie) o zadany wektor dx,dy, wyświetlanie sumy pól wszystkich obiektów w obrazie.
