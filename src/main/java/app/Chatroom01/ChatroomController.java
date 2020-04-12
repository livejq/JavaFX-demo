package app.Chatroom01;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * @author livejq
 * @since 2020/4/12
 **/
public class ChatroomController {
    /**
     * @info notes
     * 重点1：必须要有一个无参构造方法
     * 重点2：fxml中声明的组件在此引用前必须先用@FXML标记
     * 重点3：需要要实现initialize方法（对象初始化之后会立即执行）
     * 重点4：注意last的使用位置问题，发送消息后如何使滚动面板
     * 跟着往下滚动到可以显示新消息;结论：ScrollPane中实时位置
     * （getVvalue()）更新要慢上一拍，并非实时变化的
     **/

    @FXML
    private FlowPane membersList;

    @FXML
    private TextArea message;

    @FXML
    private FlowPane messagesList;

    @FXML
    private ScrollPane scrollPane;

    public static int myId;
    public static ArrayList<Message> members = new ArrayList<Message>();
    public ArrayList<Message> messages = new ArrayList<Message>();

    private boolean last = true;

    public ChatroomController() {
    }

    @FXML
    public void initialize() {
        membersList.setPadding(new Insets(5));
        VBox.setVgrow(messagesList, Priority.ALWAYS);

        message.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.ENTER) {
                    String text = message.getText();
                    message.setText("");
                    Message theMessage = new Message(myId, text, new Timestamp(new Date().getTime()));
                    messages.add(theMessage);
                    addMessageBox(theMessage);
                    System.out.println("出来后：" + scrollPane.getVvalue());
                    last = false;
                }
            }
        });
        scrollPane.vvalueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                if(!last) {
                    scrollPane.setVvalue(1.0);
                    last = true;
                }
            }
        });
        getPersonalData();
        addMembers();

        for (Message message : messages) {
            addMessageBox(message);
        }
        scrollPane.setVvalue(2);
    }

    private void getPersonalData() {
        myId = 2;
        members.add(new Message(1, "01.jpg", "骆驼", true));
        members.add(new Message(2, "02.jpg", "liveJQ", true));
        members.add(new Message(3, "03.jpg", "不知道起啥名", true));
        members.add(new Message(4, "04.jpg", "我是谁", true));
        members.add(new Message(5, "05.jpg", "小黑", true));

        Message message1 = new Message(1, "那天你消失在人海里", new Timestamp(new Date().getTime()));
        Message message2 = new Message(4, "你的背影沉默得让人恐惧 你说的那些问题 我回答得很坚定", new Timestamp(new Date().getTime()));
        Message message3 = new Message(2, "偏偏那个时候我最想你", new Timestamp(new Date().getTime()));
        Message message4 = new Message(2, "我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，我不曾爱过你", new Timestamp(new Date().getTime()));
        Message message5 = new Message(5, "我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，我不曾爱过你我不曾爱过你，我自己骗自己，", new Timestamp(new Date().getTime()));
        Message message6 = new Message(2, "我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，我不曾爱过你我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，", new Timestamp(new Date().getTime()));
        Message message7 = new Message(4, "我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，我不曾爱过你我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，那天你消失在人海里", new Timestamp(new Date().getTime()));
        Message message8 = new Message(4, "我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，我不曾爱过你我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，那天你消失在人海里那天你消失在人海里", new Timestamp(new Date().getTime()));
        Message message9 = new Message(4, "我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，我不曾爱过你我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，那天你消失在人海里那天你消失在人海里那天你消失在人海里那天你消失在人海里", new Timestamp(new Date().getTime()));
        Message message10 = new Message(4, "我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，我不曾爱过你我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，那天你消失在人海里那天你消失在人海里", new Timestamp(new Date().getTime()));
        Message message11 = new Message(4, "我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，我不曾爱过你我不曾爱过你，我自己骗自己，已经给你写了信，又被我丢进海里，那天你消失在人海里那天你消失在人海里", new Timestamp(new Date().getTime()));

        messages.add(message1);
        messages.add(message2);
//        messages.add(message3);
        messages.add(message4);
        messages.add(message5);
        messages.add(message6);
        messages.add(message7);
        messages.add(message8);
        messages.add(message9);
    }

    private void addMembers() {
        for (Message member : members) {
            Image headImg = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(member.getPicPath())));
            ImageView head = new ImageView();
            head.setImage(headImg);
            head.setFitWidth(40);
            head.setFitHeight(40);

            Label name = new Label(member.getName());
            name.setTextFill(Color.rgb(255, 255, 255));
            Label status = new Label(member.getStatus() ? "在线" : "离线");
            status.setTextFill(Color.rgb(255, 255, 255));
            VBox info = new VBox(8, name, status);
            info.setPadding(new Insets(2, 0, 0, 8));
            membersList.getChildren().add(new HBox(head, info));
        }
    }

    private Message getMemberById(int senderId) {
        for (Message member : members) {
            if (member.getId() == senderId) {
                return member;
            }
        }
        return null;
    }

    private void addMessageBox(Message message) {
        Message sender = getMemberById(message.getId());
        assert sender != null;
        Image headImg = new Image(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(sender.getPicPath())));
        ImageView head = new ImageView();
        head.setImage(headImg);
        head.setFitWidth(40);
        head.setFitHeight(40);

        Label messageBubble = new Label(message.getMsg());
        messageBubble.setWrapText(true);
        messageBubble.setMaxWidth(220);
        messageBubble.setStyle("-fx-background-color: rgb(179,231,244); -fx-background-radius: 8px;");
        messageBubble.setPadding(new Insets(6));
        messageBubble.setFont(new Font(14));
        HBox.setMargin(messageBubble, new Insets(8, 0, 0, 0));

        boolean isMine = message.getId() == myId;
        double[] points;
        if (!isMine) {
            points = new double[]{
                    0.0, 5.0,
                    10.0, 0.0,
                    10.0, 10.0
            };
        } else {
            points = new double[]{
                    0.0, 0.0,
                    0.0, 10.0,
                    10.0, 5.0
            };
        }
        Polygon triangle = new Polygon(points);
        triangle.setFill(Color.rgb(179, 231, 244));
        HBox messageBox = new HBox();
        messageBox.setPrefWidth(366);
        messageBox.setPadding(new Insets(10, 5, 10, 5));
        if (isMine) {
            HBox.setMargin(triangle, new Insets(15, 10, 0, 0));
            messageBox.getChildren().addAll(messageBubble, triangle, head);
            messageBox.setAlignment(Pos.TOP_RIGHT);
        } else {
            HBox.setMargin(triangle, new Insets(15, 0, 0, 10));
            messageBox.getChildren().addAll(head, triangle, messageBubble);
        }

        messagesList.getChildren().add(messageBox);
        System.out.println("出来前：" + scrollPane.getVvalue());
    }
}
