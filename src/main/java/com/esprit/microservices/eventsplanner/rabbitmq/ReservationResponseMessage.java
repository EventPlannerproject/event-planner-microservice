package com.esprit.microservices.eventsplanner.rabbitmq;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ReservationResponseMessage {

    private  Integer eventId;
    private  Integer guestNumbers;
}
