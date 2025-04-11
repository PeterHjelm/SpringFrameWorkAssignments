package se.yrgo.client;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import se.yrgo.domain.Customer;
import se.yrgo.services.customers.CustomerManagementService;

import java.util.List;

public class SimpleClient {

    public static void main(String[] args) {

     ClassPathXmlApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
        CustomerManagementService service = container.getBean(CustomerManagementService.class);

        List<Customer> customers = service.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);

            container.close();
        }
    }
}