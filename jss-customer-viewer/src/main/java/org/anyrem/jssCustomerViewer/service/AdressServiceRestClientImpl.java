package org.anyrem.jssCustomerViewer.service;

import org.anyrem.jssCustomerViewer.model.Address;
import org.anyrem.jssCustomerViewer.model.Customer;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AdressServiceRestClientImpl implements AddressService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    private RestTemplate restTemplate = restTemplate(new RestTemplateBuilder());

    @Value("${jss.address.rest.url}")
    private String jssRestUrl;

    private RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Override
    public List<Address> getAddresses() {

        ResponseEntity<List<Address>> responseEntity =
                restTemplate.exchange(jssRestUrl,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Address>>() {
                        });

        // get the list of customers from response
        return responseEntity.getBody();
    }

    @Override
    public void saveAddress(Address address) {

    }

    @Override
    public Optional<Address> getAddress(Long theId) {

        Optional<Address> addressOptional = Optional.empty();
//        Address address = null;

        try {
            ResponseEntity<Address> responseEntity =
                    restTemplate.getForEntity(jssRestUrl + "/" + theId,
                            Address.class,
                            new ParameterizedTypeReference<Address>() {
                            });
            addressOptional = Optional.of(responseEntity.getBody());
        } catch (Exception e) {

            logger.info(">>No address with ID :"+theId);
        }

    return addressOptional;
    }


        @Override
        public void deleteAddress (Long theId){

        }
    }

