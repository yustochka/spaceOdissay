package app.tests;

import app.util.vector3;
import app.util.DerivativeFunction;
import app.solver.EulerSolver;
import app.solver.RK4Solver;

import java.util.List;

public class UnitTestQuiz {

    public static void main(String[] args) {
        // Question 1
        simulateEulerMethod();

        // Question 2
        simulateRK4Method();
    }

    private static void simulateEulerMethod() {
        DerivativeFunction model = (state, t) -> {
            double x = state.getX();
            double y = state.getY();
            double z = state.getZ();

            double sigma = 10.0;
            double rho = 28.0;
            double beta = 2.7;

            double dx = sigma * (y - x);
            double dy = x * (rho - z) - y;
            double dz = x * y - beta * z;

            return new vector3(dx, dy, dz);
        };

        vector3 initialState = new vector3(-0.1, 0.5, 0.2);
        double t0 = 0;
        double tf = 10;
        double dt = 0.001;

        List<vector3> result = new EulerSolver().solve(model, initialState, t0, tf, dt);
        vector3 finalState = result.get(result.size() - 1);
        System.out.printf("Euler method at t = 10: x = %.5f, y = %.5f, z = %.5f%n", finalState.getX(), finalState.getY(), finalState.getZ());
    }

    private static void simulateRK4Method() {
        DerivativeFunction model = (state, t) -> {
            double x = state.getX();
            double y = state.getY();
            double z = state.getZ();

            double sigma = 9.0;
            double rho = 28.0;
            double beta = 3.0;

            double dx = sigma * (y - x);
            double dy = x * (rho - z) - y;
            double dz = x * y - beta * z;

            return new vector3(dx, dy, dz);
        };

        vector3 initialState = new vector3(0.1, -0.5, -0.2);
        double t0 = 0;
        double tf = 30;
        double dt = 0.001;

        List<vector3> result = new RK4Solver().solve(model, initialState, t0, tf, dt);
        vector3 finalState = result.get(result.size() - 1);
        System.out.printf("RK4 method at t = 30: x = %.5f, y = %.5f, z = %.5f%n", finalState.getX(), finalState.getY(), finalState.getZ());
    }
}