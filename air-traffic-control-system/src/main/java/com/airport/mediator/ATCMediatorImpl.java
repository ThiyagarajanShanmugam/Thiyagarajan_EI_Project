package com.airport.mediator;

import com.airport.airplane.Airplane;
import com.airport.utils.Logger;

public class ATCMediatorImpl implements ATCMediator {
    private Runway runway;

    public ATCMediatorImpl() {
        this.runway = new Runway();
    }

    @Override
    public void requestTakeoff(Airplane airplane) {
        if (runway.isAvailable()) {
            runway.setAvailable(false);
            airplane.takeoff();
            runway.setAvailable(true);
        } else {
            Logger.log(airplane.getId() + " takeoff delayed, runway is busy.");
        }
    }

    @Override
    public void requestLanding(Airplane airplane) {
        if (runway.isAvailable()) {
            runway.setAvailable(false);
            airplane.land();
            runway.setAvailable(true);
        } else {
            Logger.log(airplane.getId() + " landing delayed, runway is busy.");
        }
    }

    @Override
    public void requestTaxi(Airplane airplane) {
        Logger.log(airplane.getId() + " taxi request acknowledged.");
        airplane.taxi();
    }
}

