package control.text;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author livejq
 * @since 2020/4/12
 **/
public class FontStyle extends Application {

    @Override
    public void start(Stage stage) {
        // Create the first Text Node with default Font and Size
        Text text1 = new Text();
        text1.setText(text1.getFont().toString());

        // Create the first Text Node with Arial Font and Size 12
        Text text2 = new Text();
        text2.setFont(Font.font("Arial", 12));
        text2.setText(text2.getFont().toString());

        // Create the first Text Node with Arial Bold Font and Size 14
        Text text3 = new Text();
        text3.setFont(Font.font("Arial", FontWeight.BLACK, 14));
        text3.setText(text3.getFont().toString());

        // Create the fourth Text Node with Arial Italic Font and Size 16
        Text text4 = new Text();
        text4.setFont(Font.font("Arial", FontWeight.THIN, FontPosture.ITALIC, 16));
        text4.setText(text4.getFont().toString());

        // Create the VBox
        VBox root = new VBox();
        // Add the Text Nodes to the VBox
        root.getChildren().addAll(text1, text2, text3, text4);
        // Set the Spacing to 10 px
        root.setSpacing(10);

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
        stage.setTitle("Setting Fonts for Text Nodes");
        // Display the Stage
        stage.show();
    }
}

