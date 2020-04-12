package control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author livejq
 * @since 2020/4/12
 **/
public class NeonSign extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Text Effects: Neon Sign");
        Pane root = new Pane();
        Scene scene = new Scene(root, 600, 300);

        Text text = new Text();
        text.setCache(true);
        text.setFont(Font.font(null, FontWeight.BOLD, 110));
        text.setX(20);
        text.setY(150);

        Blend blend = new Blend();
        blend.setMode(BlendMode.MULTIPLY);

        DropShadow ds = new DropShadow();
        ds.setColor(Color.rgb(220, 80, 220, 0.5));
        ds.setOffsetX(5);
        ds.setOffsetY(5);
        ds.setRadius(5);
        ds.setSpread(0.2);

        blend.setBottomInput(ds);

        DropShadow ds1 = new DropShadow();
        ds1.setColor(Color.web("#f13a00"));
        ds1.setRadius(20);
        ds1.setSpread(0.2);

        Blend blend2 = new Blend();
        blend2.setMode(BlendMode.MULTIPLY);

        InnerShadow is = new InnerShadow();
        is.setColor(Color.web("#f11b42"));
        is.setRadius(9);
        is.setChoke(0.8);
        blend2.setBottomInput(is);

        InnerShadow is1 = new InnerShadow();
        is1.setColor(Color.web("#113a00"));
        is1.setRadius(5);
        is1.setChoke(0.4);
        blend2.setTopInput(is1);

        Blend blend1 = new Blend();
        blend1.setMode(BlendMode.MULTIPLY);
        blend1.setBottomInput(ds1);
        blend1.setTopInput(blend2);

        blend.setTopInput(blend1);

        Stop[] stops = new Stop[]{new Stop(0, Color.LIGHTSTEELBLUE), new Stop(1, Color.PALEGREEN)};
        LinearGradient lg = new LinearGradient(0, 0, 0.25, 0.25, true, CycleMethod.REFLECT, stops);
        text.setFill(lg);
//        text.setEffect(blend);

        TextField textField = new TextField();
        textField.setText("liveJQ");
        text.textProperty().bind(textField.textProperty());
        textField.setPrefColumnCount(40);
        textField.setLayoutX(50);
        textField.setLayoutY(260);

        root.setStyle("-fx-background-image: url('/600x300-example.jpg');" +
                "-fx-background-repeat: no-repeat;" +
                "-fx-background-size: cover;");
        root.getChildren().addAll(text, textField);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
//        scene.getStylesheets().add(NeonSign.class.getResource("brickStyle.css").toExternalForm());
        primaryStage.show();
    }
}	