package app.solver;

import app.util.vector3;
import app.util.DerivativeFunction;

import java.util.ArrayList;
import java.util.List;

public class RK4Solver implements ODESolver {
    @Override
    public List<vector3> solve(DerivativeFunction f, vector3 initialState, double t0, double tf, double dt) {
        List<vector3> result = new ArrayList<>();

        double time = t0;
        vector3 current = initialState;

        while (time <= tf) {
            result.add(current);

            vector3 k1 = f.apply(current, time);
            vector3 k2 = f.apply(current.add(k1.scale(dt / 2)), time + dt / 2);
            vector3 k3 = f.apply(current.add(k2.scale(dt / 2)), time + dt / 2);
            vector3 k4 = f.apply(current.add(k3.scale(dt)), time + dt);

            // increment = (h/6) * (k1 + 2k2 + 2k3 + k4)
            vector3 increment = k1
                    .add(k2.scale(2))
                    .add(k3.scale(2))
                    .add(k4)
                    .scale(dt / 6.0);

            current = current.add(increment);
            time += dt;
        }

        return result;
    }
}
