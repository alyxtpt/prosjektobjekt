package com.mm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileTest {
    private File tempFile;
    private Upgrade upgrade;

    @BeforeEach
    void setUp() throws IOException {
        tempFile = File.createTempFile("test_save", ".txt");

        Controller.weapon = new Weapons("bow");
        Controller.weapon.dmg = 10.0;
        Controller.weapon.acc = 5.0;
        Controller.weapon.potions = 3.0;
        HealthBars.highsc = 40.0;

        upgrade = new Upgrade();
    }

    @Test
    @DisplayName("Test file is saved")
    void testFileSaved() {
        upgrade.saveToFile(tempFile);
        assertTrue(tempFile.exists());
    }

    @Test
    @DisplayName("Test file content is correct")
    void testFileInfoCorrect() throws IOException {
        upgrade.saveToFile(tempFile);

        BufferedReader reader = new BufferedReader(new FileReader(tempFile));
        assertEquals("10.0", reader.readLine());
        assertEquals("5.0",  reader.readLine());
        assertEquals("3.0",  reader.readLine());
        assertEquals("40.0", reader.readLine());
        reader.close();
    }

    @Test
    @DisplayName("Save file is not empty")
    void testFileNotEmpty() {
        upgrade.saveToFile(tempFile);
        assertTrue(tempFile.length() > 0);
    }

    @AfterEach
    void tearDown() {
        tempFile.delete();
    }
}