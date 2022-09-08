package quanmx.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import quanmx.customer.CustomerDTO;
import quanmx.customer.CustomerNotFoundException;

/**
 *
 * @author Dell
 */
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    @Qualifier("customerServiceImp")
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDTO> listCustomers() {
        //get customers from DAO
        List<CustomerDTO> customers = customerService.getCustomers();
        //add result to model

        return customers;
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomerById(@PathVariable int id) {
        CustomerDTO customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Cannot find out customer [" + id + "]");
        }
        return customer;
    }

    @PostMapping("/customers")
    public boolean addNewCustomer(@RequestBody CustomerDTO customer) {
//        System.out.println(customer);
        customer.setId(0);
        customerService.addNewCustomer(customer);
        return true;

    }

  

    @PutMapping("/customers")
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customer) {

        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customers/{id}")
    public String deleteCustomer(@PathVariable int id) {
        CustomerDTO customer = customerService.getCustomer(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Cannot find out customer with id-" + id);
        }
        customerService.deleteCustomer(id);
        return "Customer id-" + id + " has been deleted!";
    }

}
