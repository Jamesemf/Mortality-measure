package dm.v1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javafx.embed.swing.JFXPanel;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public abstract class EmailStorage {

    public static ArrayList<String> textItems = new ArrayList();
    public static String fullDir;

     static String getDir() {
        fullDir = System.getProperty("user.dir") + "\\UserEmails.txt"; //directory for text file 
        return fullDir;
    }

    public static void writeFile(String Address) {
        String f1 = getDir();
        try {
            FileWriter writeToFile = new FileWriter(f1, true); //True mean file appends every time. False means file overwrites everytime.
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(Address);
            printToFile.close();
            writeToFile.close(); 

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    // Retrieving the emails from the text file and appending them to an array
    private static ArrayList readFile() {
        ArrayList<String> textItems = new ArrayList();
        String f1 = getDir();
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(f1));
            while ((inputLine = read.readLine()) != null) {
                textItems.add(inputLine);
                if (inputLine.equals("James")) {
                    System.out.println(inputLine);
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        Iterator myIteration = textItems.iterator();
        while (myIteration.hasNext()) {
            System.out.println(myIteration.next());
        }

        return textItems;
    }


//creates a popup GUI which will display the list of 
    public static void displayEmails(JTextField emailField) {
        JFrame Jf = new JFrame();
        Jf.setSize(230, 400);
        Jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Jf.add(displayPanel(Jf,emailField));
        Jf.setLocationByPlatform(true);

        Jf.setVisible(true);

    }
    
    //display panel which is then added to the JFrame
    private static JScrollPane displayPanel(JFrame Jf, JTextField emailField) {
        JPanel OuterPanel = new JPanel(new BorderLayout());
        JPanel innerPanel = new JPanel();
        innerPanel.setBackground(Color.GRAY);
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        OuterPanel.add(innerPanel, BorderLayout.PAGE_START);

        JScrollPane JScroll = new JScrollPane(OuterPanel);
        
        ArrayList<String> arrayToAdd = readFile();                      //Each email is presented as a button which can then be clicked, adding the email to the recipient field 
        for (int i = 0; i < arrayToAdd.size(); i++) {
            JButton button = new JButton(arrayToAdd.get(i));
            button.setBackground(Color.WHITE);
            button.addActionListener(
                    new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                   emailField.setText(button.getText());
                   HaveEmail.OpenStorage = false;
                   Jf.dispose();
                }

            }
            );
            innerPanel.add(button);
        }

        OuterPanel.add(innerPanel);
        return JScroll;

    }
    
    
    public static void createPNG(JFXPanel frame){
    BufferedImage bImg = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
    Graphics2D cg = bImg.createGraphics();
    frame.paintAll(cg);
    try {
            if (ImageIO.write(bImg, "png", new File("./Chart_image.png")))
            {
                System.out.println("-- saved");
            }
    } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
    }
}
    
    
    
    
    

    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
