import javax.swing.*;
import java.awt.*;

public class Board {
    public static void Board_Display(){
        JFrame frame = new JFrame("Image Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.setLayout(new

        BorderLayout());

        // Load the image
        ImageIcon imageIcon = new ImageIcon("F:\\java\\fuckcaoyixin\\monopoly.jpg");

        // Create a JLabel to hold the image
        JLabel label = new JLabel(imageIcon);

        // Add the label to the frame
        frame.add(label,BorderLayout.CENTER);

        // Set the frame visibility
        frame.setVisible(true);
    }
}
