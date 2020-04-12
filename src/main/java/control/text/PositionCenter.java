package control.text;

import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PositionCenter extends Application {

    @Override
    public void start(Stage stage) {
        // Create the Text Node
        Text text = new Text("An Example of a Centered Text Node");

        // We have to set the textOrigin to VPos.TOP to center the text node vertically within the scene
//        text.setTextOrigin(VPos.TOP);

        // Create the Group
        Group root = new Group();
        // Add the Text Node to the Group
        root.getChildren().add(text);

        // Create the Scene
        Scene scene = new Scene(root, 300, 200);

        // Set the Position of the Text
        text.layoutXProperty().bind(scene.widthProperty().subtract(text.layoutBoundsProperty().get().getWidth()).divide(2));
        text.layoutYProperty().bind(scene.heightProperty().subtract(text.layoutBoundsProperty().get().getHeight()).divide(2));

        // Add the scene to the Stage
        stage.setScene(scene);
        // Set the title of the Stage
        stage.setTitle("An Example of Centering a Text Node in a Scene");
        // Set the width and height of this Window to match the size of the content of the Scene.
        stage.sizeToScene();
        // Display the Stage
        stage.show();
    }

}
