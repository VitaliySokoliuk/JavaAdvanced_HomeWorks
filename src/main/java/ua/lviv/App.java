package ua.lviv;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

//        Post post = new Post("First post");
//        Comment comment = new Comment("Vitaliy", post);
//        session.persist(post);
//        session.persist(comment);

        Post findPost = session.find(Post.class, 1);
        Comment com = new Comment("Andriy", findPost);
        session.persist(com);

        transaction.commit();
        session.close();
    }
}
