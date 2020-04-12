package control.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * @author livejq
 * @since 2020/4/12
 **/
public class Multiline extends Application {

    @Override
    public void start(Stage stage) {

        String text =
                "'Doubt thou the stars are fire; \n" +
                        "Doubt that the sun doth move; \n" +
                        "Doubt truth to be a liar; \n" +
                        "But never doubt I love.' \n" +
                        " - William Shakespeare";

        // Create a default Text Node
        Text text1 = new Text(text);

        // Create a Text node with an alignment
        Text text2 = new Text(text);
        text2.setTextAlignment(TextAlignment.RIGHT);

        // Create a Text Node with a specific width
        Text text3 = new Text(text);
        text3.setWrappingWidth(100);

        // Create the HBox
        HBox root = new HBox();
        // Add the Text Nodes to the HBox
        root.getChildren().addAll(text1, text2, text3);
        // Set the Spacing to 10 px
        root.setSpacing(20);

        // Set the Styles of the HBox
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
        stage.setTitle("Using Multiline Text Nodes");
        // Display the Stage
        stage.show();
    }

}
