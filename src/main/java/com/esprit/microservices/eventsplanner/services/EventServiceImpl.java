package com.esprit.microservices.eventsplanner.services;

import com.esprit.microservices.eventsplanner.entities.Event;
import com.esprit.microservices.eventsplanner.interfaces.IEventService;
import com.esprit.microservices.eventsplanner.repositories.EventRepository;
import jakarta.ws.rs.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements IEventService {

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


    /**
     * after a reservation is created this function is To update numbers of participant
     * */
    @Override
    public void updateAvailableCapacityEvent(Integer eventId, Integer guestNumbers) {
        Event event =eventRepository.findById(eventId).orElse(null);
        if (event==null){
            throw new BadRequestException();
        }
        event.setNumbersOfParticipants(event.getNumbersOfParticipants()+guestNumbers);
        eventRepository.save(event);
    }


}
