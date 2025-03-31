package _xjava.eventAPI.infrastructure.beans;

import _xjava.eventAPI.core.entities.Event;
import _xjava.eventAPI.core.gateway.EventGateway;
import _xjava.eventAPI.core.usescases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEventUserCase createEvent(EventGateway eventGateway){
        return new CreateEventUserCaseImpl(eventGateway);
    }

    @Bean
    public FindEventUserCase findEvent(EventGateway eventGateway) {
        return new FindEventUserCaseImpl(eventGateway);
    }

    @Bean
    public FilterIdentifierUserCase filterIdentifier(EventGateway eventGateway){
        return new FilterIdentifierUserCaseImpl(eventGateway);
    }

    @Bean
    public RandomIdentifierUserCase randomIdentifierUserCase(EventGateway eventGateway){
        return new RandomIdentifierUserCaseImpl(eventGateway);
    }
}
