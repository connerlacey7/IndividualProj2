import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

// Word class to encapsulate the word information
class Word {
    private String originalWord;
    private String scrambledWord;

    // Constructor
    public Word(String originalWord) {
        this.originalWord = originalWord;
        this.scrambledWord = scrambleWord(originalWord);
    }

    // Function to scramble the word
    private String scrambleWord(String word) {
        ArrayList<Character> letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(c);
        }
        Collections.shuffle(letters);
        
        StringBuilder scrambled = new StringBuilder();
        for (char c : letters) {
            scrambled.append(c);
        }
        return scrambled.toString();
    }

    // Getter for original word
    public String getOriginalWord() {
        return originalWord;
    }

    // Getter for scrambled word
    public String getScrambledWord() {
        return scrambledWord;
    }
}

public class WordScrambleGame {
    private ArrayList<Word> wordList = new ArrayList<>(); // ArrayList from Java Collection Framework
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    // Main function to start the game
    public static void main(String[] args) {
        WordScrambleGame game = new WordScrambleGame();
        game.initializeWords();  // Function call to initialize the words
        game.run();  // Function call to start the game loop
    }

    // Function to initialize the word list
    private void initializeWords() {
        wordList.add(new Word("computer"));
        wordList.add(new Word("java"));
        wordList.add(new Word("scramble"));
        wordList.add(new Word("programming"));
        wordList.add(new Word("developer"));
        wordList.add(new Word("keyboard"));
        wordList.add(new Word("game"));
    }

    // Function to run the game
    public void run() {
        boolean keepPlaying = true;  // Control loop variable

        // Loop: Keeps the game running until the player chooses to quit
        while (keepPlaying) {
            Word wordToGuess = getRandomWord();  // Get a random word

            // Display scrambled word and prompt for guess
            System.out.println("Unscramble the word: " + wordToGuess.getScrambledWord());
            boolean guessedCorrectly = false;

            // Loop: Continue until the player guesses the correct word
            while (!guessedCorrectly) {
                System.out.print("Your guess: ");
                String userGuess = scanner.nextLine();

                // Conditional: Check if the guess is correct
                if (userGuess.equalsIgnoreCase(wordToGuess.getOriginalWord())) {
                    System.out.println("Correct! The word was: " + wordToGuess.getOriginalWord());
                    guessedCorrectly = true;
                } else {
                    System.out.println("Incorrect. Try again.");
                }
            }

            // Ask if the player wants to continue
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.nextLine();
            keepPlaying = playAgain.equalsIgnoreCase("yes");  // Conditional: Check if they want to keep playing
        }
        System.out.println("Thanks for playing!");
    }

    // Function to get a random word from the word list
    private Word getRandomWord() {
        int index = random.nextInt(wordList.size());
        return wordList.get(index);
    }
}
