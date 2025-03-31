package _xjava.eventAPI.core.usescases;

import _xjava.eventAPI.core.gateway.EventGateway;


public class RandomIdentifierUserCaseImpl implements RandomIdentifierUserCase{

    private final EventGateway eventGateway;

    public RandomIdentifierUserCaseImpl(EventGateway eventGateway) {
        this.eventGateway = eventGateway;
    }

    @Override
    public String execute(){
        return eventGateway.randomIdentifier();
    }
}
