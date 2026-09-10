package tech.tausif.CargoZen.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.tausif.CargoZen.beans.Customer;

@Service
public class CustomerService {

    @Value("${cargozen_backend_url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

    public boolean register(Customer customer) {
        String api ="/register";
        HttpEntity<Customer> requestEntity = new HttpEntity<Customer>(customer);
        ResponseEntity<Boolean> result = restTemplate.exchange(url+api, HttpMethod.POST, requestEntity, Boolean.class);
        return result.getBody();
    }
}
