# Zadanie-4

zmodyfikuj implementację metod: toString, move, oraz getArea w klasie Picture, tak aby wykorzystywały mechanizm polimorfizmu //Olek ???

wśród stworzonych wybierz i zamień wybrana klasę konkretną na klasę abstrakcyjną

korzystając z dziedziczenia stwórz 2 dodatkowe wersje klasy Picture różniące się wymaganiami odnośnie etykiet (label)

W implementacji UniquePicture i StandarizedPicture wykorzystaj  poniższą metodę add odziedziczoną z klasy bazowej - w klasach potomnych nadpisz jedynie metodę 
checkLabel
public boolean add(Figure fig) {if (checkLabel(fig)) {
    addImpl(fig); // dodaje figurę do list lub tablicy
    return true;
    }
    return false;
    }
