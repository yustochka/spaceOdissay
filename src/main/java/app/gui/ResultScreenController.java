package app.gui;

import app.solver.EulerSolver;
import app.solver.RK4Solver;
import app.util.DerivativeFunction;
import app.util.vector3;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ResultScreenController implements Initializable {

    @FXML
    private VBox resultsBox;

    @FXML
    private LineChart<Number, Number> lineChart;

    public static void show(String model, String solver, double x, double y, double z, double t0, double tf, double dt) {
        try {
            FXMLLoader loader = new FXMLLoader(ResultScreenController.class.getResource("/fxml/ResultScreen.fxml"));
            Parent root = loader.load();

            ResultScreenController controller = loader.getController();
            controller.displayParams(model, solver, x, y, z, t0, tf, dt);
            controller.plotSolutions(model, x, y, z, t0, tf, dt);

            Stage stage = new Stage();
            stage.setScene(new Scene(root, 1280, 800));
            stage.setTitle("Simulation Results");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayParams(String model, String solver, double x, double y, double z, double t0, double tf, double dt) {
        resultsBox.getChildren().add(new Label("Model: " + model));
        resultsBox.getChildren().add(new Label("Solver: " + solver));
        resultsBox.getChildren().add(new Label("Initial State: X=" + x + ", Y=" + y + ", Z=" + z));
        resultsBox.getChildren().add(new Label("t₀ = " + t0));
        resultsBox.getChildren().add(new Label("t𝒇 = " + tf));
        resultsBox.getChildren().add(new Label("dt = " + dt));
    }

    public void plotSolutions(String model, double x, double y, double z, double t0, double tf, double dt) {
        DerivativeFunction f;

        // For now, only decay model
        if (model.equals("Decay")) {
            f = (state, t) -> new vector3(0, -0.5 * state.getY(), 0);
        } else {
            return; // Handle other models later
        }

        vector3 initialState = new vector3(x, y, z);
        List<vector3> eulerResult = new EulerSolver().solve(f, initialState, t0, tf, dt);
        List<vector3> rk4Result = new RK4Solver().solve(f, initialState, t0, tf, dt);

        XYChart.Series<Number, Number> eulerSeries = new XYChart.Series<>();
        eulerSeries.setName("Euler");

        XYChart.Series<Number, Number> rk4Series = new XYChart.Series<>();
        rk4Series.setName("RK4");

        double time = t0;
        for (int i = 0; i < eulerResult.size(); i++) {
            eulerSeries.getData().add(new XYChart.Data<>(time, eulerResult.get(i).getY()));
            rk4Series.getData().add(new XYChart.Data<>(time, rk4Result.get(i).getY()));
            time += dt;
        }

        lineChart.getData().addAll(eulerSeries, rk4Series);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Optional init
    }
}
