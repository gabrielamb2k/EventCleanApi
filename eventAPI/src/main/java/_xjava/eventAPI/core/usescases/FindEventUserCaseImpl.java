package _xjava.eventAPI.core.usescases;

import _xjava.eventAPI.core.entities.Event;
import _xjava.eventAPI.core.gateway.EventGateway;

import java.util.List;

public class FindEventUserCaseImpl implements FindEventUserCase {

    private final EventGateway eventGateway;

    public FindEventUserCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public List<Event> execute() {
        return eventGateway.findEvent();
    }
}
