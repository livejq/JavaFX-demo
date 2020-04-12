package control.text;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * @author livejq
 * @since 2020/4/12
 **/
public class EffectDemo extends Application {
    /**
     * @info notes
     * Gif动画墙程序（StackPane中的控件类似图层的形式，前者可覆盖后者）
     **/
    ArrayList<Node> arrayNode = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        AnchorPane outSidePane = new AnchorPane();
        outSidePane.setPrefSize(500, 400);

        StackPane stackPane = new StackPane();
        ArrayList<BorderPane> effectList = getEffectList();
        stackPane.getChildren().addAll(effectList);

        Button previous = new Button("previous");
        Button next = new Button("Next");

        AnchorPane.setTopAnchor(stackPane, 0.0);
        AnchorPane.setLeftAnchor(stackPane, 0.0);
        AnchorPane.setRightAnchor(stackPane, 0.0);
        AnchorPane.setBottomAnchor(stackPane, 0.0);

        AnchorPane.setBottomAnchor(previous, 30.0);
        AnchorPane.setLeftAnchor(previous, 40.0);
        AnchorPane.setBottomAnchor(next, 30.0);
        AnchorPane.setRightAnchor(next, 40.0);

        previous.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (arrayNode.size() != 0) {
                    Node node = arrayNode.get(arrayNode.size() - 1);
                    stackPane.getChildren().add(node);
                    arrayNode.remove(arrayNode.size() - 1);
                    System.out.println("还剩 " + arrayNode.size() + " 个Node!");
                }
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (stackPane.getChildren().size() != 1) {
                    Node node = stackPane.getChildren().remove(stackPane.getChildren().size() - 1);
                    arrayNode.add(node);
                }
            }
        });

        outSidePane.getChildren().addAll(stackPane, previous, next);
        Scene scene = new Scene(outSidePane);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Text Effect效果展示");
        primaryStage.show();
    }

    private static ArrayList<BorderPane> getEffectList() {
        ArrayList<BorderPane> list = new ArrayList<>();
        list.add(getPerspective());
        list.add(getGaussianBlur());
        list.add(getDropShadow());
        list.add(getInnerShadow());
        list.add(getReflection());

        return list;
    }


    private static BorderPane getPerspective() {
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");

        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #43CD80");

        PerspectiveTransform pt = new PerspectiveTransform();
        // 左右上两个角
        pt.setUlx(60.0f);
        pt.setUly(20.0f);
        pt.setUrx(450.0f);
        pt.setUry(100.0f);

        // 左右下两个角
        pt.setLlx(60.0f);
        pt.setLly(240.0f);
        pt.setLrx(450.0f);
        pt.setLry(160.0f);

        anchorPane.setEffect(pt);
        anchorPane.setCache(true);

        Text t = new Text();
        t.setX(20.0f);
        t.setY(230.0f);
        t.setText("Perspective");
        t.setFill(Color.YELLOW);
        t.setFont(Font.font(null, FontWeight.BOLD, 80));

        anchorPane.getChildren().add(t);
        borderPane.setCenter(anchorPane);

        return borderPane;
    }

    private static BorderPane getGaussianBlur() {
        AnchorPane anchorPane = new AnchorPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #43CD80");

        Text t2 = new Text();

        t2.setCache(true);
        t2.setText("Example Text");
        t2.setFill(Color.RED);
        t2.setFont(Font.font(null, FontWeight.BOLD, 40));
        t2.setEffect(new GaussianBlur());

        AnchorPane.setTopAnchor(t2, 100.0);
        AnchorPane.setLeftAnchor(t2, 125.0);
        anchorPane.getChildren().add(t2);
        borderPane.setCenter(anchorPane);

        return borderPane;
    }

    private static BorderPane getDropShadow() {
        AnchorPane anchorPane = new AnchorPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #43CD80");

        DropShadow ds = new DropShadow();
        ds.setOffsetY(3.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.4f));

        Text t = new Text();
        t.setEffect(ds);
        t.setCache(true);
        t.setFill(Color.RED);
        t.setText("Example Text");
        t.setFont(Font.font(null, FontWeight.BOLD, 40));


        AnchorPane.setTopAnchor(t, 100.0);
        AnchorPane.setLeftAnchor(t, 125.0);
        anchorPane.getChildren().add(t);
        borderPane.setCenter(anchorPane);

        return borderPane;
    }

private static BorderPane getInnerShadow() {
    AnchorPane anchorPane = new AnchorPane();
    BorderPane borderPane = new BorderPane();
    borderPane.setStyle("-fx-background-color: #43CD80");

    InnerShadow is = new InnerShadow();
    is.setOffsetX(4.0f);
    is.setOffsetY(4.0f);

    Text t = new Text();
    t.setEffect(is);

    t.setText("Example Text");
    t.setFill(Color.YELLOW);
    t.setFont(Font.font(null, FontWeight.BOLD, 40));

    AnchorPane.setTopAnchor(t, 100.0);
    AnchorPane.setLeftAnchor(t, 125.0);
    anchorPane.getChildren().add(t);
    borderPane.setCenter(anchorPane);

    return borderPane;
}

    private static BorderPane getReflection() {
        AnchorPane anchorPane = new AnchorPane();
        BorderPane borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #43CD80");

        Reflection r = new Reflection();
        r.setFraction(0.7f);

        Text t = new Text();
        t.setCache(true);
        t.setText("Example Text");
        t.setFill(Color.RED);
        t.setFont(Font.font(null, FontWeight.BOLD, 40));

        t.setEffect(r);

        AnchorPane.setTopAnchor(t, 100.0);
        AnchorPane.setLeftAnchor(t, 125.0);
        anchorPane.getChildren().add(t);
        borderPane.setCenter(anchorPane);

        return borderPane;
    }
}