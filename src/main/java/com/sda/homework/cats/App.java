package com.sda.homework.cats;

import com.sda.homework.cats.entity.Account;
import com.sda.homework.cats.factory.EmbeddedTomcatFactory;
import com.sda.homework.cats.service.AccountService;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args) throws Exception {
        Tomcat tomcat = create();
        tomcat.start();
        tomcat.getServer().await();

    }

    private static Tomcat create() throws Exception {
        return EmbeddedTomcatFactory.create(8081);
    }
}

