package _xjava.eventAPI.infrastructure.gateway;

import _xjava.eventAPI.core.entities.Event;
import _xjava.eventAPI.core.gateway.EventGateway;
import _xjava.eventAPI.infrastructure.mappers.EventEntityMapper;
import _xjava.eventAPI.infrastructure.persistence.EventEntity;
import _xjava.eventAPI.infrastructure.persistence.EventRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class EventRepositoryGateway implements EventGateway {

   private final EventRepository eventRepository;
   private final EventEntityMapper eventEntityMapper;

    public EventRepositoryGateway(EventRepository eventRepository, EventEntityMapper eventEntityMapper) {
        this.eventRepository = eventRepository;
        this.eventEntityMapper = eventEntityMapper;
    }

    @Override
    public Event createEvent(Event event) {
        EventEntity newEvent = eventRepository.save(eventEntityMapper.toEntity(event));
        return eventEntityMapper.toDomain(newEvent);
    }

    @Override
    public List<Event> findEvent() {
        List<EventEntity> allEvents = eventRepository.findAll();
        return allEvents.stream()
                .map(eventEntityMapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByIdentifier(String identifier) {
        return eventRepository.findAll().stream()
                .anyMatch(event -> event.getIdentifier().equals(identifier));
    }

    @Override
    public Optional<Event> findIdentifier(String identifier) {
        return eventRepository.findByIdentifier(identifier);

    }

    @Override
    public String randomIdentifier() {
        while(true){
            Random gerador = new Random();
            String identifier = "";
            for(int i =0; i < 3; i++){
                char base = (char) ('a' + gerador.nextInt(26));
                identifier += base;
            }

            identifier = identifier + (100 + gerador.nextInt(1000));

            if(!existsByIdentifier(identifier)){
                return identifier.toUpperCase();
            }
        }
    }


}
