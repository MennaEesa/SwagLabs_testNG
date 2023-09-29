package utility;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class NumberGenerator {
    private Set<Integer> generatedNumbers;
    private Random random;

    public NumberGenerator() {
        generatedNumbers = new HashSet<>();
        random = new Random();
    }

    public int generateUniqueRandomNumber(int maxValue) {
//        Set<Integer> localGeneratedNumbers = new HashSet<>();
        int randomNumber;
        do {
            randomNumber = random.nextInt(maxValue);
        } while (generatedNumbers.contains(randomNumber));

        generatedNumbers.add(randomNumber);
        return randomNumber;
    }

    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();

        // Generate 10 unique random numbers between 1 and 100
        for (int i = 0; i < 3; i++) {
            int uniqueRandomNumber = generator.generateUniqueRandomNumber(6);
            System.out.println("Generated unique random number: " + uniqueRandomNumber);
        }

    }
}