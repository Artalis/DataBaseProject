package busineslogic;

import model.Book;
import model.BookDao;

import java.util.Scanner;

public class LibraryUpdate {

    private Scanner s;
    private  BookDao bookDao;

    public LibraryUpdate() {
        s = new Scanner(System.in);
        bookDao = new BookDao();
    }

    public void  updateBook(){

        System.out.println("Podaj ID:");
        int id = Integer.parseInt(s.nextLine());
        System.out.println("Podaj nowy tytuł:");
        String tytul = s.nextLine();
        System.out.println("Podaj nowego autora:");
        String autor = s.nextLine();
        System.out.println("Podaj nowy rok wydania:");
        int year = Integer.parseInt(s.nextLine());
        System.out.println("Podaj nowy numer ISBN:");
        String iSBNS = s.nextLine();
        int iSBN = Integer.valueOf(iSBNS);

        Book book = new Book(id,tytul,autor,year,iSBN);

        bookDao.update(book);
        bookDao.close();

    }
}
