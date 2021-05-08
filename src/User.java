import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.Timer;

/**
 * Represents the user
 * @author Rohan
 */
public class User {
    
    // Fields
    private Timer timer;
    
    private String usersSentence;
    private String[] wordArray;
    
    private int wordsTyped;
    private int lettersTyped = 0;
    private int correctTyped;
    private int errors;
    private int time;

    
    /**
     * Represents the user
     * @param the text user will type out 
     */
    public User(String text) {
        this.usersSentence = usersSentence;
        this.wordArray = text.split(" ");
        this.wordsTyped = wordsTyped;
        this.lettersTyped = lettersTyped;
        this.correctTyped = correctTyped;
        this.errors = errors;
        this.time = 60;
    }
    
    /**
     * Counts the timer down 
     */
    private void countDown(JLabel timerTitle) {
        // Decrease the time 
        this.time -= 1;
        
        // When the time is at zero
        if(this.time == 0) {
            // Stop the timer 
            this.timer.stop();
        }
        
        // Display timer to user 
        timerTitle.setText("Timer: " + String.valueOf(this.time) + "s");
    }
    
    /**
     * Starts the timer 
     */
    public void startTimer(JLabel timerTitle) {
        // For every second that passes by 
        this.timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Call method to countdown and display timer to user 
                countDown(timerTitle);
            }
        }); 
        
        // Start the timer 
        this.timer.start();        
    }
    
    /**
     * Checks if user got the correct word
     * @param the word user typed in 
     * @return if the user got the correct word
     */
    public boolean checkIncorrectWord(String word) {
        
        // Trim of the whitespace from the word 
        word = word.trim();
        
        // Store the word inside users sentence variable 
        this.usersSentence += word + " ";
        
        // Check if the word user typed in is incorrect
        if(!word.equals(this.wordArray[wordsTyped - 1])) {
            // Increase the number of errors user has made 
            this.errors += 1;
            // Return true
            return true;
        }
        
        // Increase the number of words user typed correctly 
        this.correctTyped += 1;
        
        // Return false 
        return false;
    }
    
    
    /**
     * Set the number of words user has typed
     */
    public void setWordsTyped() {
        this.wordsTyped += 1;
    }
    
    /**
     * Set the number of characters user has typed
     */
    public void setLettersTyped() {
        this.lettersTyped += 1;
    }
 
    
    /**
     * Calculates the speed 
     * @return typing speed
     */
    public double getSpeed() {
        // Get the time and turn to double 
        double userTime = (double)this.time;
        
        // Divide the users time by a 100 
        userTime = userTime / 100;
        
        // Calculate the interval between 60 seconds and the time 
        userTime = 0.60 - userTime;
        
        // Calculate and return the WPM 
        return ((this.lettersTyped / 5) / userTime) * 0.60;
    }
    
    
    /**
     * Calculates the accuracy
     * @return typing accuracy
     */
    public double getAccuracy() {
        return ((double) this.correctTyped / this.wordsTyped) * 100;
    }
    
    /**
     * Access to the time 
     * @return the time
     */
    public int getTime() {
        return this.time;
    }
    
    /**
     * Access to users sentence 
     * @return users sentence
     */
    public String getUserSentence() {
        return this.usersSentence;
    }
}
