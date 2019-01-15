package com.sda.homework.cats.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sf =
            new Configuration()
            .configure()
            .buildSessionFactory();

    private static Session session;

    public synchronized static Session getSession(){
        System.out.println("Otwieram sesje");
        session = sf.openSession();
        return session;
    }

    public static SessionFactory getSessionFactory(){
        if(sf == null){
            sf = (SessionFactory) new HibernateUtils();
        }
        return sf;
    }

    public static void closeConnection(){
        System.out.println("Zamykam polaczenie");
        session.close();
        sf.close();
        System.out.println(sf);
        session = null;
        sf = null;
    }

}
