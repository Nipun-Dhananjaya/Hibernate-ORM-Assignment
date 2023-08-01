import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Author author=new Author();
        Author author1=new Author();

        Book book=new Book();
        Book book1=new Book();
        Book book2=new Book();
        Book book3=new Book();

        author.setName("Martin Wickramasingha");
        author.setNic("188652356445");
        List<Book> b1=new ArrayList<>();
        b1.add(book);
        b1.add(book2);
        author.setBook(b1);

        author1.setName("Kumarathunga Munidasa");
        author1.setNic("187456952514");
        List<Book> b2=new ArrayList<>();
        b2.add(book1);
        b2.add(book3);
        author1.setBook(b2);

        book.setIsbn("1202");
        book.setTitle("Madol Duwa");
        book.setAuthor(author);

        book1.setIsbn("1754");
        book1.setTitle("Hath Pana");
        book1.setAuthor(author1);

        book2.setIsbn("7845");
        book2.setTitle("Meena");
        book2.setAuthor(author);

        book3.setIsbn("8965");
        book3.setTitle("Magul Kaema");
        book3.setAuthor(author1);

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.persist(book);
        session.persist(book1);
        session.persist(book2);
        session.persist(book3);

        session.persist(author);
        session.persist(author1);

        transaction.commit();
        session.close();
    }
}
