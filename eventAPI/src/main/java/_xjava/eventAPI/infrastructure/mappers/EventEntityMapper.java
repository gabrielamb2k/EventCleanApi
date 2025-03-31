package _xjava.eventAPI.infrastructure.mappers;

import _xjava.eventAPI.core.entities.Event;
import _xjava.eventAPI.infrastructure.persistence.EventEntity;
import org.springframework.stereotype.Component;

@Component
public class EventEntityMapper {

    public EventEntity toEntity(Event event){
       return new EventEntity(
               event.id(),
               event.name(),
               event.description(),
               event.start(),
               event.end(),
               event.identifier(),
               event.organizer(),
               event.place(),
               event.capacity(),
               event.type()
       );
    }

    public Event toDomain(EventEntity eventEntity){
       return new Event(
               eventEntity.getId(),
               eventEntity.getName(),
               eventEntity.getDescription(),
               eventEntity.getStart(),
               eventEntity.getEnd(),
               eventEntity.getIdentifier(),
               eventEntity.getOrganizer(),
               eventEntity.getPlace(),
               eventEntity.getCapacity(),
               eventEntity.getType()
       );
    }
}
