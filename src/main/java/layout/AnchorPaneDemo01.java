package layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * @author livejq
 * @since 2020/4/11
 **/
public class AnchorPaneDemo01 extends Application {
    /**
     * @info notes
     * 1.从里到外(由子到父)， 宽高设置的优先级递增;
     * 2.在布局管理中，父只能管理子，不能跨界管理孙；且被父容器管理后，控件自身无法对其直接设置位置；
     * 3.anchorPane1.getWidth()/2（表示当前宽高，可随着改变） 、anchorPane1.getPrefWidth()/2（表示起始/初始宽高，不可变）
     * 和newValue（窗口最最外层算起）;
     * 4.当上右下坐同时使用setXxxAnchor(N)方法时，其中的子组件如果没有自身固定的大小，
     * 则会被拉扯至距离AnchorPane N 个位置;
     **/
    @Override
    public void start(Stage primaryStage) {

        AnchorPane anchorPane1 = new AnchorPane();
        anchorPane1.setPrefSize(600, 500);
        anchorPane1.setStyle("-fx-background-color: #EE1289");

        AnchorPane anchorPane2 = new AnchorPane();
        AnchorPane.setLeftAnchor(anchorPane2, 0.0);
        AnchorPane.setTopAnchor(anchorPane2, 0.0);
        anchorPane2.setStyle("-fx-background-color: #9370DB");

        System.out.println("原始宽：getWidth=" + anchorPane1.getWidth()/2 + "; getPrefWidth=" + anchorPane1.getPrefWidth()/2);
        System.out.println("原始高：getHeight=" + anchorPane1.getHeight()/2 + "; getPrefHeight=" + anchorPane1.getPrefHeight()/2);

        anchorPane1.widthProperty().addListener((observable, oldValue, newValue) -> {
            AnchorPane.setRightAnchor(anchorPane2, anchorPane1.getWidth()/2);
            System.out.println("宽：getWidth=" + anchorPane1.getWidth()/2 + "; getPrefWidth=" + anchorPane1.getPrefWidth()/2);

        });

        anchorPane1.heightProperty().addListener((observable, oldValue, newValue) -> {
            AnchorPane.setBottomAnchor(anchorPane2, anchorPane1.getHeight()/2);
            System.out.println("高：getHeight=" + anchorPane1.getHeight()/2 + "; getPrefHeight=" + anchorPane1.getPrefHeight()/2);
        });

        anchorPane1.getChildren().add(anchorPane2);
        Scene scene = new Scene(anchorPane1);
//        primaryStage.setWidth(800);
//        primaryStage.setHeight(900);
        primaryStage.setTitle("AnchorPane布局");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("/favicon.png"));
        primaryStage.show();
    }
}
