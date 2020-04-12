package control.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author livejq
 * @since 2020/4/12
 **/
public class Decorations extends Application {

    @Override
    public void start(Stage stage) {
        // Create the first Text Node
        Text t1 = new Text("A stroked and filled Text Node");
        t1.setStroke(Color.RED);
        t1.setFill(Color.WHITE);
        t1.setFont(new Font(20));

        // Create the second Text Node
        Text t2 = new Text("A Text Node with an Underline");
        t2.setUnderline(true);

        // Create the third Text Node
        Text t3 = new Text("A Text Node with a Strikethrough");
        t3.setStrikethrough(true);

        // Create the VBox
        VBox root = new VBox();
        // Add the Text Nodes to the VBox
        root.getChildren().addAll(t1, t2, t3);
        // Set the Spacing to 20 px
        root.setSpacing(20);

        // Set the Styles of the VBox
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        // Create the Scene
        Scene scene = new Scene(root);
        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("Using Decorations for Text Nodes");
        // Display the Stage
        stage.show();
    }
}
