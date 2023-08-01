
import entity.Author;
import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        Book book=new Book();
        book.setIsbn("1202");
        book.setTitle("Madol Duwa");

        Author author=new Author();
        author.setName("Martin Wickramasingha");
        author.setNic("188652356445");
        author.setBook(book);

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        session.persist(book);
        session.persist(author);

        transaction.commit();
        session.close();
    }
}