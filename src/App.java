import java.awt.event.*;
import javax.swing.*;

/**
 * Represents the application
 * @author Rohan
 */
public class App implements KeyListener {
    
    // Fields 
    private Frame layout;
    private Text typedText;
    private User player;
    
    private Thread thread;
    private Timer timer;
    private int keysPressed;
    private int time;
    
    /**
     * Constructs the application
     */
    public App() {
        // Initialize all instance variables 
        this.layout = new Frame();
        this.typedText = new Text();
        this.player = new User(this.typedText.getText());
        this.keysPressed = keysPressed;
        this.time = 60;

        
        // Call methods from the window 
        addListeners();
        displayText();
    }
    
    /**
     * Adds listener to the input field 
     */
    private void addListeners() {
        // Get the input field 
        JTextField inputField = this.layout.getInputField();
        
        // Set an action listener to the input field 
        inputField.addKeyListener(this);
    }
    
    /**
     * Displays the text to user 
     */
    private void displayText() {
        // Get the paragraph label
        JLabel paragraph = this.layout.getParagraph();
        
        // Get choosen text to be typed
        String text = this.typedText.getDisplayedText();
        
        // Display the text
        paragraph.setText(text);
    }
    
    
    /**
     * Displays users current accuracy
     */
    private void displayAccuracy() {
        // Get the current accuracy of user 
        double accuracy = this.player.getAccuracy();
        
        // Round the accuracy 
        int rounded = (int) Math.round(accuracy);
        
        // Get the label that displays the accuracy
        JLabel accuracyTitle = this.layout.getAccuracyTitle();
        
        // Display the accuracy to user 
        accuracyTitle.setText("Accuracy: " + String.valueOf(rounded) + "%");
    }
    
    /**
     * Displays the users typing speed
     */
    private void displaySpeed() {
        // Get the users speed 
        double typingSpeed = this.player.getSpeed();
                
        // Round the typing speed 
        int roundedSpeed = (int) Math.round(typingSpeed);
        
        // Get the JLabel to display the speed 
        JLabel speedText = this.layout.getSpeedTitle();
        
        // Display the speed 
        speedText.setText("Speed: " + String.valueOf(roundedSpeed) + " WPM");
    }
    
    /**
     * Displays the results to user 
     */
    public void displayResults() {
        
        // Get the speed and accuracy
        double speed = this.player.getSpeed();
        double accuracy = this.player.getAccuracy();
        
        // Round the accuracy 
        accuracy = Math.round(accuracy);
        
        // Create the text that will be displayed to user
        String text = "Speed: " + speed + " WPM" + "\n" + "Accuracy: " + accuracy;
        
        // Display the message dialog 
        JOptionPane.showMessageDialog(layout, text);
        
        // Get the input field 
        JTextField inputField = this.layout.getInputField();
        
        // Make sure user is unable to write on textfield 
        inputField.setEditable(false);
        
    }
    
    /**
     * Sets and displays user/players progress as they type
     */
    private void setPlayerProgress() {
        // Get the input field 
        JTextField inputField = this.layout.getInputField();
        
        // Get user input and store in variable 
        String userInput = inputField.getText(); 
        
        // Set the number of words user typed
        this.player.setWordsTyped();
        
        // Check if user typed in the correct word 
        boolean isIncorrect = this.player.checkIncorrectWord(userInput);
        
        // Check if user has typed in the incorrect word
        if(isIncorrect) {
            // Display users accuracy
            this.displayAccuracy();
        }
            
        // Empty the input field 
        inputField.setText("");
        
    }
    
    /**
     * Checks if user finished writing paragraph before time is up 
     */
    private void checkFinished() {
        // Get the users sentence and split into array 
        String[] userSentence = this.player.getUserSentence().split(" ");
        
        // Get the paragraph that is being displayed to user and split into array 
        String[] paragraph = this.typedText.getText().split(" ");
        
        // Check if both lengths are equal 
        if(paragraph.length == userSentence.length) {
            // Display the results to user 
            displayResults();
        }
    }
 
  
    /**
     * Method called when key is released
     * @param e 
     */
    public void keyReleased(KeyEvent e) {
        // Increase value of keys pressed by one
        this.keysPressed += 1;
        
        // Set the number of letters user typed 
        this.player.setLettersTyped();
        
        // Get the time left 
        int timeLeft = this.player.getTime();
        
        // Check if time is at zero 
        if(timeLeft == 0) {
            // Call method to display results (speed and accuracy)
            displayResults();
        }
            
        // Check if only key was pressed once 
        if(this.keysPressed == 1) {
            // Start the timer 
            this.player.startTimer(this.layout.getTimerTitle());
        } 
        
        // Check if space is pressed 
        if(e.getKeyCode() == 32) {
            // Call method to set and display all of players progress while typing
            setPlayerProgress();
            displaySpeed();
            checkFinished();
        } 
    }

    public void keyTyped(KeyEvent e) {}

    public void keyPressed(KeyEvent e) {}
 
    
}
