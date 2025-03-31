package _xjava.eventAPI.core.gateway;

import _xjava.eventAPI.core.entities.Event;

import java.util.List;
import java.util.Optional;

public interface EventGateway {

    Event createEvent(Event event);

    List<Event> findEvent();

    boolean existsByIdentifier(String identifier);

    Optional<Event> findIdentifier(String identifier);

    String randomIdentifier();
}
