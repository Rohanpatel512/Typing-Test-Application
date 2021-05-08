import java.awt.*;
import javax.swing.*;

/**
 * Represents the layout of the frame
 * @author Rohan
 */
public class Frame extends JFrame {
    
    // Fields 
    private JPanel dataPanel = new JPanel();
    private JPanel textPanel = new JPanel();
    private JPanel inputPanel = new JPanel();
    
    private JLabel speedTitle = new JLabel("Speed: 0 WPM");
    private JLabel accuracyTitle = new JLabel("Accuracy: 100%");
    private JLabel timerTitle = new JLabel("Timer: 60s");
    private JLabel paragraph = new JLabel();
    
    private JTextField inputField = new JTextField();
    
    /**
     * Constructs the frame
     */
    public Frame() {
        this.setTitle("Typing Test");
        this.setSize(650, 400);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());
        
        // Call method(s) within the class 
        addPanels();
        addLabels();
        addTextField();
    }
    
    /**
     * Designs and adds panels the window frame 
     */
    private void addPanels() {
        
        // Set the background of each panel 
        this.dataPanel.setBackground(Color.WHITE);
        this.textPanel.setBackground(Color.WHITE);
        this.inputPanel.setBackground(Color.WHITE);
        
        // Set the dimensions of the text panel 
        this.textPanel.setPreferredSize(new Dimension(650, 200));
        
        // Set the layout of the data panel 
        this.dataPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 10));
        
        // Add all panels 
        this.add(this.dataPanel, BorderLayout.PAGE_START);
        this.add(this.textPanel, BorderLayout.CENTER);
        this.add(this.inputPanel, BorderLayout.PAGE_END);
    }
    
    /**
     * Designs and adds labels to the window frame
     */
    private void addLabels() {
        // Create a font 
        Font textFont = new Font("Sans Serif", Font.PLAIN, 20);
        
        // Set the font 
        this.speedTitle.setFont(textFont);
        this.accuracyTitle.setFont(textFont);
        this.timerTitle.setFont(textFont);
                
        // Add all labels 
        this.dataPanel.add(this.speedTitle);
        this.dataPanel.add(this.accuracyTitle);
        this.dataPanel.add(this.timerTitle);
        this.textPanel.add(this.paragraph);
    }
    
    /**
     * Design and add text field
     */
    private void addTextField() {
        // Set the size and font of the input field 
        this.inputField.setColumns(22);
        this.inputField.setFont(new Font("Sans", Font.PLAIN, 30));
        
        // Add the input field 
        this.inputPanel.add(this.inputField);
        
    }
    
    /**
     * Access to the speed title
     * @return speed title
     */
    public JLabel getSpeedTitle() {
        return this.speedTitle;
    }
    
    /**
     * Access to the accuracy title
     * @return accuracy title
     */
    public JLabel getAccuracyTitle() {
        return this.accuracyTitle;
    }
    
    /**
     * Access to the timer title
     * @return the timer title
     */
    public JLabel getTimerTitle() {
        return this.timerTitle;
    }
    
    /**
     * Access to the paragraph label
     * @return paragraph label
     */
    public JLabel getParagraph() {
        return this.paragraph;
    }
    
    /**
     * Access to the input field
     * @return the input field
     */
    public JTextField getInputField() {
        return this.inputField;
    }
}
