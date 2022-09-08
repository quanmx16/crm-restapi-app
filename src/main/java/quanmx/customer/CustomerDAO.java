package quanmx.customer;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import quanmx.hibernate.HibernateSessionFactory;

/**
 *
 * @author Dell
 */
@Repository
public class CustomerDAO implements Serializable {

    private final SessionFactory sessionFactory;

    public CustomerDAO() {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
        System.out.println("CustomerDAO has been created...");
        
    }

    public List<CustomerDTO> getCustomers() {
        Session session = null;
        List<CustomerDTO> result = null;
        //1. get session
        session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            //2. create query
            Query<CustomerDTO> query = session.createQuery("From CustomerDTO", CustomerDTO.class);
            //3. execute
            result = query.getResultList();
            session.getTransaction().commit();
            //4. return
        } finally {
            session.close();
        }
        return result;

    }

    public void addNewCustomer(CustomerDTO customer) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }

    public CustomerDTO getCustomer(int id) {
        Session session = sessionFactory.openSession();
        CustomerDTO customer = null;
        try {
            session.getTransaction().begin();
            customer = session.get(CustomerDTO.class, id);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
        return customer;
    }

    public void updateCustomer(CustomerDTO customer) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    public void deleteCustomer(int id) {
        Session session = sessionFactory.openSession();
        try {

            session.beginTransaction();
            CustomerDTO deletedCustomer = session.get(CustomerDTO.class, id);
            session.delete(deletedCustomer);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

}
