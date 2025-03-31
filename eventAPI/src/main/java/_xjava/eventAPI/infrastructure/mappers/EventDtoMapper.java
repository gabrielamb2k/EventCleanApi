package _xjava.eventAPI.infrastructure.mappers;

import _xjava.eventAPI.core.entities.Event;
import _xjava.eventAPI.infrastructure.dto.EventDto;
import org.springframework.stereotype.Component;

@Component
public class EventDtoMapper {

    public EventDto toDto(Event event){
        return new EventDto(
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

    public Event toDomain(EventDto eventDto, String identifier){

        return new Event(
                eventDto.id(),
                eventDto.name(),
                eventDto.description(),
                eventDto.start(),
                eventDto.end(),
                identifier,
                eventDto.organizer(),
                eventDto.place(),
                eventDto.capacity(),
                eventDto.type()
        );
    }
}
