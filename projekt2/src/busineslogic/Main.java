package busineslogic;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        boolean czyDalej=true;
        while(czyDalej) {


            LibrarySave librarySave = new LibrarySave();
            LibraryDelete libraryDelete = new LibraryDelete();
            LibraryRead libraryRead = new LibraryRead();
            LibraryUpdate libraryUpdate = new LibraryUpdate();

            System.out.println("Wybierz opcję:");
            System.out.println("1 - dodaj nowy rekord");
            System.out.println("2 - Wyświetl wszystkie ksiązki");
            System.out.println("3 - Usuwanie");
            System.out.println("4 - Aktualizacja");
            System.out.println("5 - Szukaj ksiązki po autorze");
            switch (Integer.valueOf(s.nextLine())) {
                case 1:
                    librarySave.PodajDane();
                    break;
                case 2:
                   libraryRead.wczytajKsiazki();
                    break;
                case 3:
                    libraryDelete.deleteBook();
                    break;
                case 4:
                   libraryUpdate.updateBook();
                    break;
                case 5:
                    libraryRead.findAythor();
                    break;
                default:
                    System.out.println("Niepoprawny wybór");
            }
            System.out.println("Czy chcesz wyłączyć aplikację? Odpowiedz(T,N)");
            if(s.nextLine().equals("T")){
                czyDalej=false;
            }
        }

    }
}
