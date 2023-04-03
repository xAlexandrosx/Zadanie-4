# Zadanie-3
Programowanie obiektowe PS

Wykorzystując technikę kompozycji stwórz następujące klasy:

Klasa Point reprezentująca punkt na płaszczyźnie ze współrzędnymi x i y. Klasa powinna posiadać 3 konstruktory: bezparametrowy, parametrowy (double x, double y) i kopiujący.

Klasa Section reprezentująca odcinek określony przez 2 punkty. Odcinek powinien posiadać 3 konstruktory: bezparametrowy, parametrowy(Point p1, Point p2) oraz kopiujący (kopia głęboka).

Klasa okręgu Circle składająca się z 1 punktu (środek) i promienia. Klasa powinna posiadać 3 konstruktory: bezparametrowy, parametrowy(Point o, double r) i kopiujący (kopia głęboka).

Klasa Picture zawierająca 3 kolekcje (listy lub tablice) obiektów 1,2,3 oraz metody umożliwiające dodawanie nowych obiektów do kolekcji.
Każda z 4 klas powinna mieć:

Metodę 'move(double dx, double dy)', która przesuwa pozycję obiektu o zadany wektor <dx,dy>; w klasach składających się z obiektów innych klas powinna ona wywoływać metody 'move' swoich obiektów składowych.

Metodę 'String toString()' zwracające tekstową reprezentację danego obiektu, przy czym w klasach składających się z obiektów innych klas powinna ona wywoływać metody 'toString' swoich obiektów składowych.

Metodę 'getArea()', która zwraca pole danego elementu (0 dla Point i Section), w przypadku klasy Picture zwracana wartość to suma pól obiektów w obrazie.

W programie zaimplementuj proste menu, które pozwala na: dodawanie punktów/odcinków/okręgów do obiektu obrazu (Picture), wyswietlanie obiektu Picture (każdy element w postaci tekstowej w osobnej linii), przesuwanie całego obrazu (wszystkich obiektów w obrazie) o zadany wektor dx,dy, wyświetlanie sumy pól wszystkich obiektów w obrazie.
