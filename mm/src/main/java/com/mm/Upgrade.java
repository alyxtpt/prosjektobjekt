package com.mm;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Upgrade {
    private Parent root;
    private Stage stage;
    private Scene scene;

    public void upgradeAcc(ActionEvent event) throws IOException {
        Controller.weapon.acc += 1;
        go(event);

    }

    public void upgradeDmg(ActionEvent event) throws IOException {
        Controller.weapon.dmg += 1;
        go(event);
    }
    
    public void upgradePotions(ActionEvent event) throws IOException {
        Controller.weapon.potions += 1;
        go(event);
    }

    public void go(ActionEvent e) throws IOException {
        root = FXMLLoader.load(getClass().getResource("fight.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
}
