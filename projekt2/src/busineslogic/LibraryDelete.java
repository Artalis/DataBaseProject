package busineslogic;


import model.BookDao;
import java.util.Scanner;

public class LibraryDelete {


    private Scanner s;
    private LibraryRead libraryRead;

    public LibraryDelete() {
        s = new Scanner(System.in);
        libraryRead = new LibraryRead();
    }


    public void deleteBook(){
        //wyswietlenie ksiązek przed usuwaniem
        System.out.println("Książki w bibliotece:");
        libraryRead.wczytajKsiazki();

        System.out.println("\nPodaj ID ksiązki do usunięcia:");
        int iD = Integer.parseInt(s.nextLine());
        BookDao bookDao = new BookDao();
        bookDao.delete(iD);
        bookDao.close();


    }




}





