package com.mm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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

    public void saveFile() {
        FileChooser fileChooser = new FileChooser();

        ExtensionFilter ex = new ExtensionFilter("Text Files", "*.txt");

        fileChooser.getExtensionFilters().add(ex);

        File selectedFile = fileChooser.showSaveDialog(stage);
        PrintWriter fileOut = null;

        try {
            fileOut = new PrintWriter(selectedFile);
            fileOut.print(Controller.weapon.dmg + "\n");
            fileOut.print(Controller.weapon.acc + "\n");
            fileOut.print(Controller.weapon.potions + "\n");
            fileOut.print(HealthBars.highsc);
        } catch (FileNotFoundException | NullPointerException e) {
            e.printStackTrace();
        } finally {
            fileOut.close();
        }

        if (selectedFile != null) {
            System.out.println("Saved File");
            System.out.println(selectedFile.getPath());
        }
    }
}
