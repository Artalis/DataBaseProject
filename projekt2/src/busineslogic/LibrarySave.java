package busineslogic;

import model.Book;
import model.BookDao;
import java.util.Scanner;

public class LibrarySave {

    private Scanner s;

    public LibrarySave() {
        s = new Scanner(System.in);
    }


    public void PodajDane() {

        System.out.println("Podaj Tytuł:");
        String tytul = s.nextLine();
        System.out.println("Podaj Autora:");
        String autor = s.nextLine();
        System.out.println("Podaj rok wydania:");
        int year = Integer.parseInt(s.nextLine());
        System.out.println("Podaj ISBN:");
        String iSBNS = s.nextLine();
        int iSBN = Integer.valueOf(iSBNS);

        Book book = new Book(tytul,autor,year,iSBN);
        BookDao bookDao = new BookDao();
        bookDao.save(book);
        bookDao.close();
    }
}