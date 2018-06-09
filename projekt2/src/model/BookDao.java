package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static final String URL ="jdbc:mysql://localhost/Library";
    private static final String USER ="root";
    private static String PASS ="Artalis13";
    private Connection connection;

    public BookDao() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }

    }

    public void save(Book book){
        final String sql = "insert into books(title,author,year,isbn) values (?,?,?,?);";
        try{
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(2,book.getAuthor());
            prepStmt.setString(1,book.getTitle());
            prepStmt.setInt(3,book.getYear());
            prepStmt.setInt(4,book.getIsbn());
            prepStmt.executeUpdate();
            System.out.println("Book saved");
        }catch (SQLException e){
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public List<Book> read(String author) {
        List<Book> books=new ArrayList<>();
        final String sql = "select id,title,author,year,isbn from books where author = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, author);
            ResultSet result = prepStmt.executeQuery();
            return prepareList(result);

        } catch (SQLException e) {
            System.out.println("Could not get books");
        }
        return null;
    }

    public List<Book> readAll() {
        List<Book> books=new ArrayList<>();
        final String sql = "select id,title,author,year,isbn from books";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            ResultSet result = prepStmt.executeQuery();
            return prepareList(result);
        } catch (SQLException e) {
            System.out.println("Could not get books");
        }
        return null;
    }

    private List<Book> prepareList( ResultSet result) throws SQLException {
        List<Book> books=new ArrayList<>();
        while (result.next()) {
            Book book = new Book();
            book.setId(result.getInt("ID"));
            book.setAuthor(result.getString("author"));
            book.setTitle(result.getString("title"));
            book.setYear(result.getInt("year"));
            book.setIsbn(result.getInt("isbn"));
            books.add(book);
        }
        return books;
    }

    public void update(Book book) {
        final String sql = "update books set title=?, author=?,year=?, isbn=? where ID = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, book.getTitle());
            prepStmt.setString(2, book.getAuthor());
            prepStmt.setInt(3, book.getYear());
            prepStmt.setInt(4, book.getIsbn());
            prepStmt.setInt(5, book.getId());
            prepStmt.executeUpdate();
            System.out.println("Book updated");
        } catch (SQLException e) {
            System.out.println("Could not update record");
        }
    }

    public void delete(int id) {
        final String sql = "delete from books where ID = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setLong(1, id);
            prepStmt.executeUpdate();
            System.out.println("Book deleted");
        } catch (SQLException e) {
            System.out.println("Could not delete book");
        }
    }

    public void close(){
        try{
            connection.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
