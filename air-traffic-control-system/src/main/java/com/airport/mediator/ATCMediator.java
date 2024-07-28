package com.airport.mediator;

import com.airport.airplane.Airplane;

public interface ATCMediator {
    void requestTakeoff(Airplane airplane);
    void requestLanding(Airplane airplane);
    void requestTaxi(Airplane airplane);
}

