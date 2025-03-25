package app.solver;

import app.util.vector3;
import app.util.DerivativeFunction;

import java.util.ArrayList;
import java.util.List;

public class EulerSolver implements ODESolver{
    @Override
    public List<vector3> solve(DerivativeFunction f, vector3 initialState, double t0, double tf, double dt) {
        List<vector3> result = new ArrayList<>();

        double time = t0;
        vector3 current = initialState;

        while (time <= tf) {
            result.add(current);

            // Apply Euler's formula: x(t+h) = x(t) + h * f(x(t), t)
            vector3 dx = f.apply(current, time);  // f(x, t)
            vector3 step = dx.scale(dt);          // h * f(x, t)
            current = current.add(step);          // x(t+h)

            time += dt;
        }

        return result;
    }
}
