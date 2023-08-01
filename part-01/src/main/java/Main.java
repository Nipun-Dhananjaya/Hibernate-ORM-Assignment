import entity.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        Book book=new Book();
        book.setIsbn("1202");
        book.setTitle("Madol Duwa");
        Book book1=new Book();
        book1.setIsbn("1754");
        book1.setTitle("Hath Pana");
        Book book2=new Book();
        book2.setIsbn("4567");
        book2.setTitle("Senkottan");
        Book book3=new Book();
        book3.setIsbn("7854");
        book3.setTitle("Maanikkawatha");
        Book book4=new Book();
        book4.setIsbn("4547");
        book4.setTitle("Pethsama");
        Book book5=new Book();
        book5.setIsbn("6391");
        book5.setTitle("Malagiya Aththo");

        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();

        //Save
        System.out.println("");
        System.out.println("----------------------------Save----------------------------");
        session.persist(book);
        session.persist(book1);
        session.persist(book2);
        session.persist(book3);
        session.persist(book4);
        session.persist(book5);
        System.out.println(book);
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);
        System.out.println(book4);
        System.out.println(book5);

        //Retrieve
        System.out.println("");
        System.out.println("--------------------------Retrieve--------------------------");
        Book b1=session.get(Book.class,"7854");
        Book b2=session.get(Book.class,"4547");
        System.out.println(b1);
        System.out.println(b2);

        //Update
        System.out.println("");
        System.out.println("---------------------------Update---------------------------");
        book.setTitle("Rajapaksha Walawwa");
        book1.setTitle("Mozad");
        session.update(book);
        session.update(book1);
        System.out.println(book);
        System.out.println(book1);

        //Delete
        System.out.println("");
        System.out.println("---------------------------Delete---------------------------");
        session.remove(book3);
        session.remove(book);

        transaction.commit();
        session.close();
    }
}
