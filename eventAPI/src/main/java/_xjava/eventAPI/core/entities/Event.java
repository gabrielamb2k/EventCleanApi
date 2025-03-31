package _xjava.eventAPI.core.entities;
import _xjava.eventAPI.core.enums.EventType;

import java.time.LocalDateTime;

public record Event(
        Long id,

        String name,

        String description,

        LocalDateTime start,

        LocalDateTime end,

        String identifier,

        String organizer,

        String place,

        Integer capacity,

        EventType type

) {
}
