package app.gui;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class IntroScreen extends Application{
    @Override
    public void start(Stage primaryStage) {
        // Set dimensions
        int width = 1280;
        int height = 800;

        // Load background image
        ImageView background = new ImageView(new Image("src/main/resources/images/introBackground.png"));
        background.setFitWidth(width);
        background.setFitHeight(height);
        background.setPreserveRatio(false);

        // Overlay text
        Text title = new Text("TITANIC SPACE ODYSSEY");
        title.setFont(Font.font("Arial", 48));
        title.setStyle("-fx-fill: white;");

        Text group = new Text("GROUP 5");
        group.setFont(Font.font("Arial", 24));
        group.setStyle("-fx-fill: white;");

        StackPane root = new StackPane(background, title);
        StackPane.setAlignment(title, javafx.geometry.Pos.CENTER);
        StackPane.setAlignment(group, javafx.geometry.Pos.BOTTOM_CENTER);
        root.getChildren().add(group);

        Scene scene = new Scene(root, width, height);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Intro");
        primaryStage.show();

        // Auto-transition to next screen after 2 seconds (placeholder action)
        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(e -> {
            // Replace with real screen switch later
            System.out.println("Intro finished. Transition to input screen here.");
        });
        pause.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
