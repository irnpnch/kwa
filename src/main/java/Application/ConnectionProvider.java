package Application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnectionProvider {

    public static Session getSession() {

        if(session==null){
            init();
        }
        return session;
    }

    static Session session;

    private static void init(){

        Configuration conf = new Configuration();
        SessionFactory sessionFactory = conf.configure().buildSessionFactory();
        session = sessionFactory.openSession();
        //session.beginTransaction();
    }

    public void close(){

        if(session!=null){
            session.close();
        }

    }

}
