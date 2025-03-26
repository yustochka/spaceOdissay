package app;

import app.solver.EulerSolver;
import app.solver.RK4Solver;
import app.util.vector3;
import app.util.DerivativeFunction;
import app.tests.LotkaVolterra;
import java.util.List;

import javafx.application.Application;
import app.gui.IntroScreen;



public class Main {

    public static void main(String[] args) {
        IntroScreen.main(args); // Launch the intro screen (it will handle transitions)
    }
}

//
//        // --- Lotka-Volterra Model ---
//        DerivativeFunction model = LotkaVolterra.getModel();
//        vector3 initialState = LotkaVolterra.getInitialState();
//
//        double t0 = 0;
//        double tf = 20;
//        double dt = 0.1;
//
//        // Solve with Euler
//        EulerSolver euler = new EulerSolver();
//        List<vector3> eulerResult = euler.solve(model, initialState, t0, tf, dt);
//
//        // Solve with RK4
//        RK4Solver rk4 = new RK4Solver();
//        List<vector3> rkResult = rk4.solve(model, initialState, t0, tf, dt);
//
//        // Print results
//        System.out.println("Time\tPrey_Euler\tPred_Euler\tPrey_RK4\tPred_RK4");
//
//        //FOR REPORT: The system shows typical Lotka-Volterra oscillations. Initially, prey are abundant and predators thrive. As prey are eaten, predator numbers increase, but this eventually leads to a food shortage, causing predator decline. Prey then recover, and the cycle repeats.
//        //RK4 preserves this dynamic better over longer times than Euler, which tends to dampen or distort the cycles.
//
//        double time = t0;
//        for (int i = 0; i < eulerResult.size(); i++) {
//            vector3 e = eulerResult.get(i);
//            vector3 r = rkResult.get(i);
//            System.out.printf("%.1f |\t%.4f |\t%.4f |\t%.4f |\t%.4f%n", time, e.getX(), e.getY(), r.getX(), r.getY());
//            time += dt;
//        }
