package app.tests;

import app.util.vector3;
import app.util.DerivativeFunction;

public class SimpleTestODEs {

    // Gravity: constant acceleration
    public static DerivativeFunction gravity() {
        return (state, t) -> new vector3(0, -9.81, 0);
    }

    // Decay: dy/dt = -0.5 * y
    public static DerivativeFunction decay() {
        return (state, t) -> new vector3(0, -0.5 * state.getY(), 0);
    }

    // Exact solution for decay
    public static double exactDecay(double t) {
        return 100 * Math.exp(-0.5 * t);
    }

    // Exact solution for gravity (used before)
    public static double exactGravity(double t) {
        return 100 + 0 * t + 0.5 * (-9.81) * t * t;
    }
}
