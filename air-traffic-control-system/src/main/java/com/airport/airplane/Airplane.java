package com.airport.airplane;

import com.airport.mediator.ATCMediator;
import com.airport.utils.Logger;

public class Airplane {
    private String id;
    private ATCMediator mediator;
    private AirplaneState state;

    public Airplane(String id, ATCMediator mediator) {
        this.id = id;
        this.mediator = mediator;
        this.state = AirplaneState.ON_GROUND;
    }

    public String getId() {
        return id;
    }

    public void requestTakeoff() {
        Logger.log(id + " requesting takeoff.");
        mediator.requestTakeoff(this);
    }

    public void requestLanding() {
        Logger.log(id + " requesting landing.");
        mediator.requestLanding(this);
    }

    public void requestTaxi() {
        Logger.log(id + " requesting taxi.");
        mediator.requestTaxi(this);
    }

    public void takeoff() {
        Logger.log(id + " is taking off.");
        state = AirplaneState.IN_AIR;
    }

    public void land() {
        Logger.log(id + " is landing.");
        state = AirplaneState.ON_GROUND;
    }

    public void taxi() {
        Logger.log(id + " is taxiing.");
        state = AirplaneState.TAXIING;
    }

    public AirplaneState getState() {
        return state;
    }
}

