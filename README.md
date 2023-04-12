# Zadanie-4
Programowanie obiektowe PS

Zmodyfikuj zadanie z poprzednich zajęć:

korzystając z techniki dziedziczenia dodaj do klas reprezentujących obiekty graficzne (punkty, linie, ....) pole String label, które pozwala na przypisanie etykiety tekstowej (stwórz osobną klasę Figure),

zmodyfikuj implementację metod: toString, move, oraz getArea w klasie Picture, tak aby wykorzystywały mechanizm polimorfizmu

wśród stworzonych wybierz i zamień wybrana klasę konkretną na klasę abstrakcyjną

korzystając z dziedziczenia stwórz 2 dodatkowe wersje klasy Picture różniące się wymaganiami odnośnie etykiet (label)

UniquePicture - pozwala na dodanie obiektów graficznych z unikalnymi etykietami, zwraca true jeśli udało się dodać

StandarizedPicture - pozwala na dodanie obiektów graficznych z etykietami składającymi się wyłączeni z dużych liter i cyfr i rozpoczynających się od litery, użyj java.util.regex.Pattern, zwraca true jeśli udało się dodać;

W implementacji UniquePicture i StandarizedPicture wykorzystaj  poniższą metodę add odziedziczoną z klasy bazowej - w klasach potomnych nadpisz jedynie metodę 
checkLabel
public boolean add(Figure fig) {if (checkLabel(fig)) {
    addImpl(fig); // dodaje figurę do list lub tablicy
    return true;
    }
    return false;
    }
