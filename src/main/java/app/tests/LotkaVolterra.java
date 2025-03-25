package app.tests;

import app.util.vector3;
import app.util.DerivativeFunction;


public class LotkaVolterra {
    public static DerivativeFunction getModel() {
        return (state, t) -> {
            double x = state.getX(); // prey
            double y = state.getY(); // predator

            double alpha = 1.1;
            double beta = 0.4;
            double gamma = 0.4;
            double delta = 0.1;

            double dx = alpha * x - beta * x * y;
            double dy = delta * x * y - gamma * y;

            return new vector3(dx, dy, 0);
        };
    }

    public static vector3 getInitialState() {
        return new vector3(10, 5, 0); // 10 prey, 5 predators
    }
}


