package com.moyses.api_system_car.infraestructure.integration;

import com.moyses.api_system_car.application.dto.serviceOrder.ServiceAutomotiveOrderResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class AutomotiveServiceClient {

    private final RestTemplate template;

    public AutomotiveServiceClient(RestTemplate template) {
        this.template = template;
    }

    public List<ServiceAutomotiveOrderResponse> getAvailableServices(){
        String url = "http://automotive-mock-service:3000/services";
        ServiceAutomotiveOrderResponse[] response = template.getForObject(url, ServiceAutomotiveOrderResponse[].class);
        return Arrays.stream(response).toList();
    }
}
