package busineslogic;

import model.Book;
import model.BookDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryRead {

    private List<Book> books;
    private BookDao bookDao;
    private Scanner s;

    public LibraryRead() {
        books = new ArrayList<>();
        bookDao = new BookDao();
        s = new Scanner(System.in);
    }

    public void wczytajKsiazki(){
        books=bookDao.readAll();
        bookDao.close();
        for(Book b:books){
            System.out.println(b.toString());
        }
    }
    public void findAythor(){
        System.out.println("Podaj autora:");
        String author = s.nextLine();

        books=bookDao.read(author);
        bookDao.close();
        for(Book b:books){
            System.out.println(b.toString());
        }
    }
}
