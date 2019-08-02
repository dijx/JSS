package org.anyrem.jssCustomerViewer.service;

import org.anyrem.jssCustomerViewer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@Service
class CustomerServiceRestClientImpl implements CustomerService {


    private RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());

    @Value("${jss.customers.rest.url}")
    private String crmRestUrl;

    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

//    private Logger logger = Logger.getLogger(getClass().getName());
    /*@Autowired
    public CustomerServiceRestClientImpl(@Value("${jss.customers.rest.url}") String theUrl) {
        this.crmRestUrl = theUrl;

    };
*/
    @Override
    public List<Customer> getCustomers() {

        ResponseEntity<List<Customer>> responseEntity =
                restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Customer>>() {
                        });

        // get the list of customers from response
        List<Customer> customers = responseEntity.getBody();

        return customers;

    }

    @Override
    public void saveCustomer(Customer theCustomer) {

    }

    @Override
    public Customer getCustomer(int theId) {
        return null;
    }

    @Override
    public void deleteCustomer(int theId) {

    }
}
