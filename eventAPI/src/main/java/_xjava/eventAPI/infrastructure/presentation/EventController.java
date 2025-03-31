package _xjava.eventAPI.infrastructure.presentation;

import _xjava.eventAPI.core.entities.Event;
import _xjava.eventAPI.core.usescases.CreateEventUserCase;
import _xjava.eventAPI.core.usescases.FilterIdentifierUserCase;
import _xjava.eventAPI.core.usescases.FindEventUserCase;
import _xjava.eventAPI.core.usescases.RandomIdentifierUserCase;
import _xjava.eventAPI.infrastructure.dto.EventDto;
import _xjava.eventAPI.infrastructure.mappers.EventDtoMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/")
public class EventController {

    private final CreateEventUserCase createEventUserCase;
    private final FindEventUserCase findEventUserCase;
    private final FilterIdentifierUserCase filterIdentifierUserCase;
    private final EventDtoMapper eventDtoMapper;
    private final RandomIdentifierUserCase randomIdentifierUserCase;

    public EventController(CreateEventUserCase createEventUserCase, FindEventUserCase findEventUserCase, FilterIdentifierUserCase filterIdentifierUserCase, EventDtoMapper eventDtoMapper, RandomIdentifierUserCase randomIdentifierUserCase) {
        this.createEventUserCase = createEventUserCase;
        this.findEventUserCase = findEventUserCase;
        this.filterIdentifierUserCase = filterIdentifierUserCase;
        this.eventDtoMapper = eventDtoMapper;
        this.randomIdentifierUserCase = randomIdentifierUserCase;
    }

    @PostMapping("criarevento")
    public ResponseEntity<Map<String, Object>> createEvent(@RequestBody EventDto eventDto){

        String identifier = randomIdentifierUserCase.execute();

        Event newEvent = createEventUserCase.execute(eventDtoMapper.toDomain(eventDto, identifier));

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Evento cadastrado com sucesso no nosso banco de dados");
        response.put("evento", eventDtoMapper.toDto(newEvent));

        return ResponseEntity.ok(response);
    }

    @GetMapping("listareventos")
    public List<EventDto> findEvents(){
        return findEventUserCase.execute().stream()
                .map(eventDtoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/identificador/{identifier}")
    public ResponseEntity<EventDto> filterIdentifier(@PathVariable String identifier){
        Event event = filterIdentifierUserCase.execute(identifier);
        return ResponseEntity.ok(eventDtoMapper.toDto(event));
    }
}
