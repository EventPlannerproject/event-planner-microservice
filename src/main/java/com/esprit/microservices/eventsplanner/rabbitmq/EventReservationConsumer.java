package com.esprit.microservices.eventsplanner.rabbitmq;


import com.esprit.microservices.eventsplanner.interfaces.IEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EventReservationConsumer {

    private final IEventService eventService;

    @RabbitListener(queues = "reservationQueue")
    public void consumeMessage(ReservationResponseMessage reservationResponseMessage){
        System.out.println("reservation"+reservationResponseMessage);
        eventService.updateAvailableCapacityEvent(reservationResponseMessage.getEventId(),reservationResponseMessage.getGuestNumbers());


    }

}
