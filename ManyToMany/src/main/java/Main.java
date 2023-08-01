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

        author.setName("Fenton");
        author.setNic("188652356445");
        List<Book> b1=new ArrayList<>();
        b1.add(book);
        b1.add(book1);
        author.setBook(b1);

        author1.setName("Liz");
        author1.setNic("195879652345");
        List<Book> b2=new ArrayList<>();
        b2.add(book);
        b2.add(book1);
        author1.setBook(b2);

        book.setIsbn("1202");
        book.setTitle("Forever Hold You Peace");
        List<Author> a1=new ArrayList<>();
        a1.add(author);
        a1.add(author1);
        book.setAuthors(a1);

        book1.setIsbn("1547");
        book1.setTitle("The Year We Turned Forty");
        List<Author> a2=new ArrayList<>();
        a2.add(author);
        a2.add(author1);
        book1.setAuthors(a2);

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.persist(book);
        session.persist(book1);

        session.persist(author);
        session.persist(author1);

        transaction.commit();
        session.close();
    }
}
