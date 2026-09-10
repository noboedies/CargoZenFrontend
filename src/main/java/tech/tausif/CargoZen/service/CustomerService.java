package tech.tausif.CargoZen.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    @Value("${cargozen_backend_url}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();

}
