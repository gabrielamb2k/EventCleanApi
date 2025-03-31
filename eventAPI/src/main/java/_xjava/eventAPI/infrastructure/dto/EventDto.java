package _xjava.eventAPI.infrastructure.dto;

import _xjava.eventAPI.core.enums.EventType;

import java.time.LocalDateTime;

public record EventDto(
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

)
{}
