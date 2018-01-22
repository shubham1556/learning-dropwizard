package com.dwbook.phonebook;


import com.dwbook.phonebook.resources.ContactResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 */
public class App extends Application<PhonebookConfiguration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    //implementing the abstract method of Service Class: initialise() and run()

    @Override
    public void run(PhonebookConfiguration c, Environment e) throws Exception {  // called 2nd
        LOGGER.info("Method App#run() called");
        System.out.println("Hello World, By Dropwizard");

        //e.jersey().register(new ContactResource());

        for (int i = 0; i < c.getMessageRepetitions(); i++) {
            System.out.println(c.getMessage());
        }

        //Create a DBI factory and build a JDBI instance

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(e, c.getDatabaseSourceFactory(), "mysql");

        e.jersey().register(new ContactResource(jdbi));
    }


    public void initialise(Bootstrap<PhonebookConfiguration> b) {   // called 1 ON THE instantiation of App Object
    }
}