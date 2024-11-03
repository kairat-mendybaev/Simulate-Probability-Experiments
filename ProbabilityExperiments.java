import java.util.Random;

public class ProbabilityExperiments {

    private static final Random random = new Random();

    // Task 1: Simulating Coin Tosses
    public static int[] simulateCoinTosses(int tosses) {
        int heads = 0;
        int tails = 0;
        for (int i = 0; i < tosses; i++) {
            if (random.nextBoolean()) { // true represents heads, false represents tails
                heads++;
            } else {
                tails++;
            }
        }
        return new int[]{heads, tails};
    }

    // Task 2: Rolling a Die
    public static int[] simulateDiceRolls(int rolls) {
        int[] outcomes = new int[6]; // Array to store frequency of each side (1-6)
        for (int i = 0; i < rolls; i++) {
            int result = random.nextInt(6) + 1; // Generate a random number from 1 to 6
            outcomes[result - 1]++;
        }
        return outcomes;
    }

    // Task 3: Drawing Cards
    public static int[] simulateCardDraws(int draws) {
        int redCards = 0;
        int blackCards = 0;
        for (int i = 0; i < draws; i++) {
            if (random.nextBoolean()) { // Assume true for red, false for black
                redCards++;
            } else {
                blackCards++;
            }
        }
        return new int[]{redCards, blackCards};
    }

    // Task 4: Probability of Compound Events
    public static int[] simulateTwoCoinFlips(int flips) {
        int bothHeads = 0;
        int atLeastOneHead = 0;
        for (int i = 0; i < flips; i++) {
            boolean firstFlip = random.nextBoolean();
            boolean secondFlip = random.nextBoolean();
            if (firstFlip && secondFlip) {
                bothHeads++;
            }
            if (firstFlip || secondFlip) {
                atLeastOneHead++;
            }
        }
        return new int[]{bothHeads, atLeastOneHead};
    }

    public static void main(String[] args) {
        int[] coinTossResults = simulateCoinTosses(100);
        System.out.println("Coin Tosses: Heads = " + coinTossResults[0] + ", Tails = " + coinTossResults[1]);

        int[] diceRollResults = simulateDiceRolls(60);
        System.out.print("\nDice Rolls: ");
        for (int i = 0; i < diceRollResults.length; i++) {
            System.out.print((i + 1) + ":" + diceRollResults[i] + " ");
        }

        int[] cardDrawResults = simulateCardDraws(20);
        System.out.println("\nCard Draws: Red Cards = " + cardDrawResults[0] + ", Black Cards = " + cardDrawResults[1]);

        int[] twoCoinFlipResults = simulateTwoCoinFlips(50);
        System.out.println("Two Coin Flips: Both Heads = " + twoCoinFlipResults[0] + ", At Least One Head = " + twoCoinFlipResults[1]);
    }
}
