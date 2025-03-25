package app.tests;

import app.solver.EulerSolver;
import app.solver.RK4Solver;
import app.util.DerivativeFunction;
import app.util.vector3;

import java.util.List;

public class experiment {
    public static void main(String[] args) {
        DerivativeFunction decay = (state, t) -> new vector3(0, -0.5 * state.getY(), 0);
        double t0 = 0;
        double tf = 5;
        vector3 initialState = new vector3(0, 100, 0);

        double[] dtValues = {1.0, 0.5, 0.25, 0.1, 0.05, 0.01};

        System.out.println("dt\tEulerError\tRK4Error\tEulerTime(ms)\tRK4Time(ms)");

        for (double dt : dtValues) {
            // Euler
            long startEuler = System.nanoTime();
            List<vector3> eulerResult = new EulerSolver().solve(decay, initialState, t0, tf, dt);
            long endEuler = System.nanoTime();

            // RK4
            long startRK4 = System.nanoTime();
            List<vector3> rk4Result = new RK4Solver().solve(decay, initialState, t0, tf, dt);
            long endRK4 = System.nanoTime();

            // Exact solution
            double exactY = 100 * Math.exp(-0.5 * tf);

            double eulerY = eulerResult.get(eulerResult.size() - 1).getY();
            double rk4Y = rk4Result.get(rk4Result.size() - 1).getY();

            double eulerError = Math.abs(eulerY - exactY);
            double rk4Error = Math.abs(rk4Y - exactY);

            double eulerTime = (endEuler - startEuler) / 1_000_000.0;
            double rk4Time = (endRK4 - startRK4) / 1_000_000.0;

            System.out.printf("%.4f\t%.6f\t%.6f\t%.3f\t\t%.3f%n", dt, eulerError, rk4Error, eulerTime, rk4Time);
        }
    }
}
