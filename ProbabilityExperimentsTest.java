import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProbabilityExperimentsTest {
    private static final int TRIALS = 10000; // Increased trial number for more accuracy in statistical tests

    @Test
    void testCoinTosses() {
        var results = ProbabilityExperiments.simulateCoinTosses(100);
        // Asserting that the heads and tails counts are close to expected 50/50 split
        assertTrue(Math.abs(results[0] - results[1]) < 20, "Heads and Tails should be about equal");
    }

    @Test
    void testDiceRolls() {
        var frequencies = ProbabilityExperiments.simulateDiceRolls(600);
        // Check if each side of the die gets about an equal share of outcomes
        int average = 600 / 6;
        for (int freq : frequencies) {
            assertTrue(Math.abs(freq - average) < 50, "Each die side frequency should be close to 1/6 of total rolls");
        }
    }

    @Test
    void testCardDraws() {
        var results = ProbabilityExperiments.simulateCardDraws(1000);
        // Asserting a roughly equal distribution of red and black cards
        assertTrue(Math.abs(results[0] - results[1]) < 50, "Red and Black cards should be about equally frequent");
    }

    @Test
    void testTwoCoinFlipsBothHeads() {
        var results = ProbabilityExperiments.simulateTwoCoinFlips(100);
        // Assert both heads occur about 25% of the time in two coin flips
        assertEquals(25, results[0], 10, "Both heads should occur around 25% of the time");
    }

    @Test
    void testAtLeastOneHead() {
        var results = ProbabilityExperiments.simulateTwoCoinFlips(100);
        // Assert at least one head occurs about 75% of the time
        assertEquals(75, results[1], 10, "At least one head should occur around 75% of the time");
    }

    @Test
    void testRandomness() {
        // This test checks the uniformity of the random number generator across a large number of trials
        var dieFrequencies = ProbabilityExperiments.simulateDiceRolls(60000);
        int average = 60000 / 6;
        for (int freq : dieFrequencies) {
            assertTrue(Math.abs(freq - average) < 500, "Random number generation should be uniform across large samples");
        }
    }
}
