package quanmx.hibernate;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import quanmx.customer.CustomerDTO;

/**
 *
 * @author Dell
 */
public class HibernateSessionFactory {

    private static final SessionFactory sessionFactory;

    static {
        File file = new File("E:\\SpringFrameWork\\spring-rest-crm-temp\\src\\main\\webapp\\hibernate.cfg.xml");
        sessionFactory = new Configuration()
                .configure(file)
                .addAnnotatedClass(CustomerDTO.class)
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
