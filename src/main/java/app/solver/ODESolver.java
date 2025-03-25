package app.solver;

import app.util.vector3;
import app.util.DerivativeFunction;

import java.util.List;

public interface ODESolver {
    List<vector3> solve(DerivativeFunction f, vector3 initialState, double t0, double tf, double dt);
    // f = derivative function
    // initialState = initial state
    // t0 = initial time
    // tf = final time
    // dt = time step size
}