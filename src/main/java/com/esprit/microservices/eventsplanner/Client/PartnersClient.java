package com.esprit.microservices.eventsplanner.Client;

import com.esprit.microservices.eventsplanner.Partners;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="partners-service" , url = "${application.config.partners-url}")
public interface PartnersClient {

    @GetMapping("/event/{event-id}")
    List<Partners>findAllPartnersByEvent(@PathVariable("event-id") Integer eventId);
}
