/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.TranslateTransitionBuilder;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Ajith Kp [ajithkp560] http://www.terminalcoders.blogspot.com
 * http://fb.com/ajithkp560
 *
 */
public class SnowFallingEffect extends Application {

    Random random = new Random();
    AnchorPane root = new AnchorPane();

    @Override
    public void start(Stage primaryStage) {
        Circle c[] = new Circle[2000];
        ImageView background = new ImageView(new Image(getClass().getResource("Backgroundx.png").toString()));
        root.getChildren().add(background);

        for (int i = 0; i < 2000; i++) {
            c[i] = new Circle(1, 1, 1);
            c[i].setRadius(random.nextDouble() * 3);
            Color color = Color.rgb(255, 255, 255, random.nextDouble());
            c[i].setFill(color);
            root.getChildren().add(c[i]);
            Raining(c[i]);
        }
        Scene scene = new Scene(root, 950, 534);
        primaryStage.setTitle("SnowFalling Animation : Ajith Kp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void Raining(Circle c) {
        c.setCenterX(random.nextInt(950));//Window width = 950
        int time = 10 + random.nextInt(50);
        Animation walk = TranslateTransitionBuilder.create()
                .node(c)
                .fromY(-200)
                .toY(534+200) //WIndow height = 534
                .toX(random.nextDouble() * c.getCenterX())
                .duration(Duration.seconds(time))
                .onFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        Raining(c);
                    }
                }).build();
        walk.play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
