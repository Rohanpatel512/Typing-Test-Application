import java.io.File;
import java.util.*;

/**
 * Represents the text displayed to user 
 * @author Rohan
 */
public class Text {
    
    // Fields 
    private Scanner fileInput;
    private File textFiles;
    
    private String[] files = {"Text1", "Text2", "Text3"};
    private String choosenFile;
    
    /**
     * Constructs the text
     */
    public Text() {
        // Initialize all fields 
        this.fileInput = fileInput;
        this.textFiles = textFiles;
        this.files = files;
        this.choosenFile = choosenFile;
        
        // Call methods inside the class
        chooseFile();
    }
    
    /**
     * Pick a random file 
     */
    private void chooseFile() {
        
        // Pick a random number between 0 and 3 
        int random = (int)(Math.random() * 3);
        
        // Get the name of the file 
        this.choosenFile = files[random];
        
        // Get the file 
        getFile();
    }
    
    /**
     * Gets the file that was randomly chosen
     */
    private void getFile() {
        
        // Try 
        try {  
            // Get the location of the file  
            String path = "C:\\Users\\Rohan\\Documents\\NetBeansProjects\\Typing Test";
            
            // Get the file 
            this.textFiles = new File(path + "\\" + this.choosenFile + ".txt");
          
          // Catch the error
        } catch(Exception e) {
            // Print any errors 
            e.printStackTrace();
        }
    }
    
    /**
     * Reads the context in the file 
     * @return the text inside file that will be displayed to user 
     */
    public String getDisplayedText() {
       
        // Method variables 
       String displayedText = "";
        
       // Try 
       try {
           // Read from the file 
           this.fileInput = new Scanner(this.textFiles);
         // Catch any exceptions
       } catch(Exception e) {
           // Print out the error
           e.printStackTrace();
       }
              
       // While there is a next word 
       while(this.fileInput.hasNextLine()) {
           // Store each line inside string
           displayedText +=  "<html>" + "<br>" + this.fileInput.nextLine() + "</br>";
       } 
                     
       // Return the text 
       return displayedText;
    }
    
    /**
     * Reads the unedited context in the file (no broken lines)
     * @return the unedited text in the file that won't be displayed to user
     */
    public String getText() {
       
       // Method variables
       String choosenText = "";
        
       // Try 
       try {
           // Read from the file 
           this.fileInput = new Scanner(this.textFiles);
         // Catch any exceptions
       } catch(Exception e) {
           // Print out the error
           e.printStackTrace();
       }
              
       // While there is a next word 
       while(this.fileInput.hasNextLine()) {
           // Store each line inside string
           choosenText += this.fileInput.nextLine();
       }  
       
       // Return the choosen text
       return choosenText;
    }
    
}
