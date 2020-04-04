package ua.lviv;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

public class HibernateApp {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration();
        configuration.configure();

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        HashSet<Cart> cartHashSet = new HashSet<>();
        HashSet<Item> itemHashSet = new HashSet<>();

        Item item = new Item(10);
        Cart cart = new Cart(33, "fbfbdf");

        itemHashSet.add(item);
        cartHashSet.add(cart);

        cart.setItems(itemHashSet);
        item.setCarts(cartHashSet);

        session.persist(item);
        session.persist(cart);


        transaction.commit();
        session.close();
    }
}
