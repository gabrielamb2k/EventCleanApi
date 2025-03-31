package _xjava.eventAPI.core.usescases;

import _xjava.eventAPI.core.entities.Event;
import _xjava.eventAPI.core.gateway.EventGateway;
import _xjava.eventAPI.infrastructure.exceptions.DuplicateIdentifierException;

public class CreateEventUserCaseImpl implements CreateEventUserCase {

    private final EventGateway eventGateway;

    public CreateEventUserCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public Event execute(Event event) {
        if(eventGateway.existsByIdentifier(event.identifier())){
            throw new DuplicateIdentifierException("O identificador numero: " + event.identifier()
            + " já esta em uso para outro evento");
        }
        return eventGateway.createEvent(event);
    }
}
