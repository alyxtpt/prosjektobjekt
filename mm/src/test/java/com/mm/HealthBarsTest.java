package com.mm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HealthBarsTest {

    @BeforeEach
    void setUp() {
        Controller.weapon = new Weapons("bow");
        HealthBars.highsc = 0;
    }

    @Test
    @DisplayName("highsc starts at 0")
    void testHighscoreStart() {
        assertEquals(0, HealthBars.highsc);
    }

    @Test
    @DisplayName("hitOrMiss is always true when acc is 20")
    void testHitOrMissAlwaysHits() {
        HealthBars hb = new HealthBars();
        for (int i = 0; i < 100; i++) {
            assertTrue(hb.hitOrMiss(20));
        }
    }

    @Test
    @DisplayName("hitOrMiss is always false when acc is 0")
    void testHitOrMissAlwaysMisses() {
        HealthBars hb = new HealthBars();
        for (int i = 0; i < 100; i++) {
            assertFalse(hb.hitOrMiss(0));
        }
    }

    @Test
    @DisplayName("highsc increases with 10 per win")
    void testIncreaseHighscore() {
        HealthBars.highsc += 10;
        assertEquals(10, HealthBars.highsc);
    }
}