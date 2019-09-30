package util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBHelper {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = createSessionFactory();
        }
        return sessionFactory;
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", PropertiesReader.getInstance().getDialect());
        configuration.setProperty("hibernate.connection.driver_class", PropertiesReader.getInstance().getDriver());
        configuration.setProperty("hibernate.connection.url", PropertiesReader.getInstance().getUrl());
        configuration.setProperty("hibernate.connection.username", PropertiesReader.getInstance().getUsername());
        configuration.setProperty("hibernate.connection.password", PropertiesReader.getInstance().getPassword());
        configuration.setProperty("hibernate.show_sql", PropertiesReader.getInstance().getShowSql());
        configuration.setProperty("hibernate.hbm2ddl.auto", PropertiesReader.getInstance().getHbm2ddl());
        return configuration;
    }

    private static SessionFactory createSessionFactory() {
        Configuration configuration = getMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
