package com.mm;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HealthBars implements Initializable {
    private double mHP = 1;
    private double eHP = 1;
    Random random = new Random();
    public static int highsc = 0;
    private int potions = Controller.weapon.potions;

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private ProgressBar MyHP;
    @FXML
    private ProgressBar EnemyHP;
    @FXML
    private Button HPP;
    @FXML
    private Text MyHPtext;
    @FXML
    private Text EnemyHPtext;
    @FXML
    private Text enemyMiss;
    @FXML
    private Text myMiss;
    @FXML
    private ImageView imageview;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MyHP.setStyle("-fx-accent: red;");
        EnemyHP.setStyle("-fx-accent: red;");
        HPP.setText("Use HP-Potion (" + Integer.toString(potions) + ")" );
        int randint = random.nextInt(3);
        String url;
        url = switch (randint) {
            case 0 -> "shrek.png";
            case 1 -> "monster.png";
            default -> "plankton.png";
        };

        Image image = new Image(getClass().getResourceAsStream(url));
        imageview.setImage(image);

    }


    public void Heal(ActionEvent e){
        if (mHP <= 0.9) {
            mHP += 0.1;
            MyHP.setProgress(mHP);
            MyHPtext.setText(Integer.toString((int) Math.round(mHP*100)));
            potionUseText();
        } else if (mHP > 0.9 && mHP < 1) {
            mHP = 1;
            MyHP.setProgress(mHP);
            MyHPtext.setText(Integer.toString((int) Math.round(mHP*100)));
            potionUseText();
        }

    }

    public void potionUseText() {
        potions -= 1;
        if (potions > 0) {
            HPP.setText("Use HP-Potion (" + Integer.toString(potions) + ")" );
        } else {
            HPP.setText("0 potions left");
            HPP.setDisable(true);
        }
    }
    
    public void damageMonster(ActionEvent e) throws IOException, InterruptedException {

        if (hitOrMiss(Controller.weapon.acc)) {
            eHP -= Controller.weapon.dmg / 100; 
            EnemyHP.setProgress(eHP);
            EnemyHPtext.setText(Integer.toString((int) Math.round(eHP*100)));
        } else {
            missAni(myMiss);
        }

        if (hitOrMiss(highsc*4)) {
            mHP -= random.nextDouble() * 0.2;
            MyHP.setProgress(mHP);
            MyHPtext.setText(Integer.toString((int) Math.round(mHP*100)));
        } else {
            missAni(enemyMiss);
        }

        if (Math.round(mHP*100) <= 0) {
            root = FXMLLoader.load(getClass().getResource("gameover.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
        
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }

        if (Math.round(eHP*100) <= 0) {
            highsc += 1;
            root = FXMLLoader.load(getClass().getResource("upgrade.fxml"));
            stage = (Stage)((Node)e.getSource()).getScene().getWindow();
            scene = new Scene(root);
        
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }
    public boolean hitOrMiss(double acc) {
        return random.nextDouble() * 20 < acc;
    }

    public void missAni(Text t) {
        FadeTransition fade = new FadeTransition();
        fade.setNode(t);
        fade.setDuration(Duration.millis(1000));
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.setFromValue(1);
        fade.setToValue(0);
        fade.play();
    }
}
