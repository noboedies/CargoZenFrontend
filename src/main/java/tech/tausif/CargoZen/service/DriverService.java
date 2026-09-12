package tech.tausif.CargoZen.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tech.tausif.CargoZen.beans.Driver;

@Service
public class DriverService {

    @Value("${API_URL}")
    private String url;

    private RestTemplate restTemplate = new RestTemplate();


    public boolean register(Driver driver) {
        String api="/driver/register";
        HttpEntity<Driver> requestEntity=new HttpEntity<Driver>(driver);
        ResponseEntity<Boolean> result=restTemplate.exchange(url+api, HttpMethod.POST,requestEntity,Boolean.class);
        return result.getBody();
    }
}
