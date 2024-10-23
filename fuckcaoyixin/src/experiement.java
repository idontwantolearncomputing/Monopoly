package fuckcaoyixin.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class Experiment extends JFrame {
    private JLabel boardLabel;
    private JLabel playerIcon;
    private int playerPosition = 0;
    private final int[][] positions = new int[40][2];

    public Experiment() {
        setTitle("Monopoly Game");
        setSize(850, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize board positions
        initializePositions();

        // Load player icon
        playerIcon = new JLabel(new ImageIcon("F:\\java\\fuckcaoyixin\\chess2.jpg"));
        playerIcon.setBounds(positions[playerPosition][0], positions[playerPosition][1], 50, 50);
        add(playerIcon);

        // Load board image
        ImageIcon boardImage = new ImageIcon("F:\\java\\fuckcaoyixin\\monopoly.jpg");
        boardLabel = new JLabel(boardImage);
        boardLabel.setBounds(0, 0, boardImage.getIconWidth(), boardImage.getIconHeight());
        add(boardLabel);

        // Button to roll dice
        JButton rollButton = new JButton("Roll Dice");
        rollButton.setBounds(350, 780, 100, 30);
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });
        add(rollButton);
    }

    private void initializePositions() {
        int startX = 630, startY = 650, step = 60;

        // Bottom row (right to left)
        for (int i = 0; i <= 10; i++) {
            if (playerPosition == 10) {
               positions[i][0]= startX - 300;
            }else {
                positions[i][0] = startX - step * i;
                positions[i][1] = startY;
            }
        }
        // Left column (bottom to top)
        for (int i = 11; i < 21; i++) {
            positions[i][0] = startX - 600;
            positions[i][1] = startY - step * (i - 10);
        }
        // Top row (left to right)
        for (int i = 21; i < 31; i++) {
            positions[i][0] = startX - step * 9 + step * (i - 21);
            positions[i][1] = startY - step * 10;
        }
        // Right column (top to bottom)
        for (int i = 31; i < 40; i++) {
            positions[i][0] = startX;
            positions[i][1] = startY - step * 10 + step * (i - 30);
        }
    }

    private void rollDice() {
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1;
        //int roll = 1;

        // Check if the player is on the 10th bottom position
        if (playerPosition == 10) {
            // Customize the behavior here, for example, move only 1 space
            playerPosition = (playerPosition + 1) % positions.length;
        } else {
            playerPosition = (playerPosition + roll) % positions.length;
        }

        playerIcon.setLocation(positions[playerPosition][0], positions[playerPosition][1]);
        System.out.println("Rolled: " + roll);
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Board game = new Board();

            game.setVisible(true);
        });
    }
}