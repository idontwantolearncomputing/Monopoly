package fuckcaoyixin.src;

import javax.swing.*;
import java.util.Random;

class PlayerIcon {
    private JLabel playerIcon;
    private int playerPosition = 0;
    private final int[][] positions;

    public PlayerIcon(int[][] positions) {
        this.positions = positions;
        playerIcon = new JLabel(new ImageIcon("F:\\java\\fuckcaoyixin\\chess2.jpg"));
        playerIcon.setBounds(positions[playerPosition][0], positions[playerPosition][1], 50, 50);
    }

    public JLabel getIcon() {
        return playerIcon;
    }

    public void rollDice() {
        Random rand = new Random();
        int roll = rand.nextInt(6) + 1;
        System.out.println("Rolled: " + roll);
        IconMovement(roll);
    }
    public void IconMovement(int roll){
        playerPosition = (playerPosition + roll) % positions.length;
        playerIcon.setLocation(positions[playerPosition][0], positions[playerPosition][1]);
    }
}