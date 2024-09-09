import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class MyProgram {


public static class guessinggame {
    private JFrame frame;
    private JTextField guessField;
    private JLabel resultLabel;
    private int numberToGuess;
    private int numberOfGuesses;
    private JLabel guessesLeftLabel;

    public guessinggame() {
        // Create a new JFrame (window)
        frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel to hold the game components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Create a label and text field for the user to enter their guess
        JLabel guessLabel = new JLabel("Enter your guess (between 1 and 100):");
        guessField = new JTextField(10);

        // Create a label to display the number of guesses
        numberOfGuesses = 5;
        JLabel guessesLeftLabel = new JLabel(" Guesses left: " + numberOfGuesses);

        // Create a button to submit the guess
        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());

        // Create a label to display the result of the guess
        resultLabel = new JLabel("");

        // Add the components to the panel
        panel.add(guessLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(resultLabel);
        panel.add(guessesLeftLabel);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Set the size of the frame
        frame.setSize(300, 200);

        // Make the frame visible
        frame.setVisible(true);

        //center the frame
        frame.setLocationRelativeTo(null);

        // Generate a random number for the user to guess
        numberToGuess = new Random().nextInt(100) + 1;
        numberOfGuesses = 5;
       
    }

    private class GuessButtonListener implements ActionListener {

        private JButton guessButton;

        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the user's guess from the text field
            int guess = Integer.parseInt(guessField.getText());

            // Check if the guess is correct
            if (guess == numberToGuess) {
                resultLabel.setText("Congratulations! You guessed the correct number.");
            } else if (guess < numberToGuess) {
                resultLabel.setText("Too low! Try again.");
            } else {
                resultLabel.setText("Too high! Try again.");
            }

            System.out.println("guesses left: " + numberOfGuesses);

            // Decrement the number of guesses
            numberOfGuesses--;
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    guessesLeftLabel.setText("Guesses left: " + numberOfGuesses);
                }
            });
           
            
            // Check if the user has run out of guesses
            if (numberOfGuesses == 0) {
                resultLabel.setText("Game over! You ran out of guesses.");
                guessButton.setEnabled(false);
            }

            
        };
    }

    }

    public static void main(String[] args) {
        new guessinggame();
    }
    }    
