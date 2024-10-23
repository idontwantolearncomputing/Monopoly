package fuckcaoyixin.src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Board extends JFrame {
    private JLabel boardLabel;
    private PlayerIcon playerIcon;
    private final int[][] positions = new int[40][2];

    public Board() {
        setTitle("Monopoly Game");
        setSize(850, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Initialize board positions
        initializePositions();

        // Create and add player icon
        playerIcon = new PlayerIcon(positions);
        add(playerIcon.getIcon());

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
                playerIcon.rollDice();
            }
        });
        add(rollButton);
    }

    private void initializePositions() {
        int startX = 630, startY = 650, step = 60;

        // Bottom row (right to left)
        for (int i = 0; i <= 10; i++) {
            positions[i][0] = (i == 10) ? startX - 300 : startX - step * i;
            positions[i][1] = startY;
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Board game = new Board();
            game.setVisible(true);
        });
    }
}