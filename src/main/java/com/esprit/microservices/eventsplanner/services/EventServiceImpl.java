package com.esprit.microservices.eventsplanner.services;

import com.esprit.microservices.eventsplanner.Client.PartnersClient;
import com.esprit.microservices.eventsplanner.FullEventResponse;
import com.esprit.microservices.eventsplanner.entities.Event;
import com.esprit.microservices.eventsplanner.interfaces.IEventService;
import com.esprit.microservices.eventsplanner.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements IEventService {
    @Autowired
    private  PartnersClient client;

    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> retrieveAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<Event> retrieveEvent(Integer idEvent) {
        return eventRepository.findById(idEvent);
    }

    @Override
    public void removeEvent(Integer idEvent) {
        eventRepository.deleteById(idEvent);
    }

    @Override
    public List<Event> retrieveEventsByTitle(String title) {
        return eventRepository.findByTitle(title);
    }

    @Override
    public List<Event> retrieveEventsByStatus(String status) {
        return eventRepository.findByStatus(status);
    }

    @Override
    public List<Event> retrieveEventsByDate(LocalDate date) {
        return eventRepository.findByStartDate(date);
    }

    @Override
    public List<Event> retrieveEventsByType(String type) {
        return eventRepository.findByType(type);
    }

    @Override
    public List<Event> retrieveEventsByLocation(String location) {
        return eventRepository.findByLocation(location);
    }

    @Override
    public List<Event> retrieveEventsBetweenTwoDates(LocalDate startDate, LocalDate endDate) {
        return eventRepository.getEventBetweenTwoDates(startDate, endDate);
    }

    @Override
    public List<Event> retrieveEventsByNumberOfAttendees(Integer numberOfAttendeesCount) {
        return eventRepository.findByNumberOfAttendees(numberOfAttendeesCount);
    }

    @Override
    public FullEventResponse findEventWithPartners(Integer eventId) {
        var event = eventRepository.findById(eventId)
                .orElse(
                        Event.builder()
                                .title("NOT_FOUND")
                                .description("NOT_FOUND")
                                .build()
                );
        var partner = client.findAllPartnersByEvent(eventId);
        return FullEventResponse.builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .partner(partner)
                .build();
    }
}
