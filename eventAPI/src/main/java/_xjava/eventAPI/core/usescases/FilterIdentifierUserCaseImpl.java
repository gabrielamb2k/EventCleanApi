package _xjava.eventAPI.core.usescases;

import _xjava.eventAPI.core.entities.Event;
import _xjava.eventAPI.core.gateway.EventGateway;
import _xjava.eventAPI.infrastructure.exceptions.IdentifierNotExistException;

public class FilterIdentifierUserCaseImpl implements FilterIdentifierUserCase{

    private final EventGateway eventGateway;

    public FilterIdentifierUserCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }


    @Override
    public Event execute(String identifier) {
        return eventGateway.findIdentifier(identifier).orElseThrow(() ->
                new IdentifierNotExistException("Event with identifier " + identifier + "not found"));
    }
}
