package app;

import app.solver.EulerSolver;
import app.solver.RK4Solver;
import app.util.vector3;
import app.util.DerivativeFunction;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        // GRAVITY
//        DerivativeFunction gravity = (state, t) -> new vector3(0, -9.81, 0);
        // DECAY
        DerivativeFunction decay = (state, t) -> new vector3(0, -0.5 * state.getY(), 0);


        // Initial state: starting at height 100
        vector3 initialState = new vector3(0, 100, 0);

        double t0 = 0; // initial time
        double tf = 2; // final time
        double dt = 0.1; // time step size

        // Solve with Euler
        EulerSolver euler = new EulerSolver();
        List<vector3> eulerResult = euler.solve(decay, initialState, t0, tf, dt);

        // Solve with RK4
        RK4Solver rk4 = new RK4Solver();
        List<vector3> rkResult = rk4.solve(decay, initialState, t0, tf, dt);

        // Print header
        System.out.println("Time\tEuler Y\t\tRK4 Y\t\tExact Y");

        double time = t0;
        for (int i = 0; i < eulerResult.size(); i++) {
//            double exactY = 100 + 0 * time + 0.5 * (-9.81) * time * time; // for gravity
            double exactY = 100 * Math.exp(-0.5 * time); // for decay
            double eulerY = eulerResult.get(i).getY();
            double rk4Y = rkResult.get(i).getY();

            System.out.printf("%.1f\t%.5f\t%.5f\t%.5f%n", time, eulerY, rk4Y, exactY);
            time += dt;
        }
    }
}