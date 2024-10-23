package fuckcaoyixin.src;

public class PlayerIcon {
    private int playerPosition = 0;
    private final int[][] positions = new int[40][2];
    private void initializePositions() {
        int startX = 630, startY = 650, step = 60;

        for (int i = 0; i <= 10; i++) {
            positions[i][0] = (i == 10) ? startX - 300 : startX - step * i;
            positions[i][1] = startY;
        }
        for (int i = 11; i < 21; i++) {
            positions[i][0] = startX - 600;
            positions[i][1] = startY - step * (i - 10);
        }
        for (int i = 21; i < 31; i++) {
            positions[i][0] = startX - step * 9 + step * (i - 21);
            positions[i][1] = startY - step * 10;
        }
        for (int i = 31; i < 40; i++) {
            positions[i][0] = startX;
            positions[i][1] = startY - step * 10 + step * (i - 30);
        }
    }
}
