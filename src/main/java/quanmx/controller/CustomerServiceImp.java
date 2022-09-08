package quanmx.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import quanmx.customer.CustomerDAO;
import quanmx.customer.CustomerDTO;
import quanmx.customer.CustomerNotFoundException;

/**
 *
 * @author Dell
 */
@Service("customerServiceImp")
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<CustomerDTO> getCustomers() {
        //get customers from DAO
        List<CustomerDTO> customers = customerDAO.getCustomers();
        return customers;

    }

    @Override
    public void addNewCustomer(CustomerDTO customer) {
        customerDAO.addNewCustomer(customer);
    }

    @Override
    public CustomerDTO getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customer) {
        if (customer.getId() == 0) {
            throw new CustomerNotFoundException("Does not contain any id to update!");
        }
        customerDAO.updateCustomer(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

}
