package com.mm;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Weapons {
    public double dmg;
    public double acc;
    public int potions;

    private Parent root;
    private Stage stage;
    private Scene scene;

    public Weapons(String weapon){
        if (weapon.matches("bow")) {
            dmg = 10;
            acc = 9;
            potions = 2;
        } else if (weapon.matches("sword")){
            dmg = 12;
            acc = 7;
            potions = 2;
        } else if (weapon.matches("mace")) {
            dmg = 15;
            acc = 4;
            potions = 2;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "dmg: " + dmg + "\nacc: " + acc;
    }
}
