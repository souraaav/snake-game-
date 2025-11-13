import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class SnakeGame extends JFrame {
    public SnakeGame() {
        this.add(new GamePanel());
        this.setTitle("Snake Game - Diwali Snack Edition");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SnakeGame::new);
    }

    static class GamePanel extends JPanel implements ActionListener, KeyListener {
        static final int SCREEN_WIDTH = 600;
        static final int SCREEN_HEIGHT = 600;
        static final int UNIT_SIZE = 25;
        static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
        static final int DELAY = 100;

        final int[] x = new int[GAME_UNITS];
        final int[] y = new int[GAME_UNITS];
        int bodyParts = 6;
        int applesEaten = 0;
        int appleX;
        int appleY;
        char direction = 'R'; // U, D, L, R
        boolean running = false;
        Timer timer;
        Random random;

        GamePanel() {
            random = new Random();
            this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
            this.setBackground(Color.BLACK);
            this.setFocusable(true);
            SwingUtilities.invokeLater(() -> this.addKeyListener(this));
            this.requestFocusInWindow(); // ensure key events are received
            startGame();
        }

        private void startGame() {
            // initialize starting snake position (centered) and body segments
            x[0] = SCREEN_WIDTH / 2;
            y[0] = SCREEN_HEIGHT / 2;
            for (int i = 1; i < bodyParts; i++) {
                x[i] = x[0] - i * UNIT_SIZE;
                y[i] = y[0];
            }

            newApple();
            running = true;
            timer = new Timer(DELAY, this);
            timer.start();
        }

        void newApple() {
            appleX = random.nextInt(SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
            appleY = random.nextInt(SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        void draw(Graphics g) {
            if (running) {
                // optional grid
                g.setColor(new Color(40, 40, 40));
                for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                    g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                    g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
                }

                // apple
                g.setColor(Color.RED);
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

                // snake
                for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        g.setColor(new Color(0, 180, 0));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    } else {
                        g.setColor(new Color(34, 139, 34));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }

                // score
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 18));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("Score: " + applesEaten, 10, metrics.getHeight());
            } else {
                gameOver(g);
            }
        }

        void move() {
            for (int i = bodyParts; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            // use enhanced rule switch for compatibility
            switch (direction) {
                case 'U' -> y[0] -= UNIT_SIZE;
                case 'D' -> y[0] += UNIT_SIZE;
                case 'L' -> x[0] -= UNIT_SIZE;
                case 'R' -> x[0] += UNIT_SIZE;
            }
        }

        void checkApple() {
            if (x[0] == appleX && y[0] == appleY) {
                bodyParts++;
                applesEaten++;
                newApple();
            }
        }

        void checkCollisions() {
            // check body collision
            for (int i = bodyParts; i > 0; i--) {
                if (x[0] == x[i] && y[0] == y[i]) {
                    running = false;
                }
            }

            // check walls
            if (x[0] < 0) running = false;
            if (x[0] >= SCREEN_WIDTH) running = false;
            if (y[0] < 0) running = false;
            if (y[0] >= SCREEN_HEIGHT) running = false;

            if (!running) timer.stop();
        }

        void gameOver(Graphics g) {
            // score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            FontMetrics metrics1 = getFontMetrics(g.getFont());
            g.drawString("Score: " + applesEaten,
                    (SCREEN_WIDTH - metrics1.stringWidth("Score: " + applesEaten)) / 2,
                    SCREEN_HEIGHT / 2 - 30);

            // game over text
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 48));
            FontMetrics metrics2 = getFontMetrics(g.getFont());
            g.drawString("Game Over",
                    (SCREEN_WIDTH - metrics2.stringWidth("Game Over")) / 2,
                    SCREEN_HEIGHT / 2 + 10);

            // restart hint
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            FontMetrics metrics3 = getFontMetrics(g.getFont());
            String hint = "Press SPACE to restart";
            g.drawString(hint, (SCREEN_WIDTH - metrics3.stringWidth(hint)) / 2, SCREEN_HEIGHT / 2 + 50);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (running) {
                move();
                checkApple();
                checkCollisions();
            }
            repaint();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                if (direction != 'R') direction = 'L';
            } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                if (direction != 'L') direction = 'R';
            } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                if (direction != 'D') direction = 'U';
            } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                if (direction != 'U') direction = 'D';
            } else if (key == KeyEvent.VK_SPACE && !running) {
                // restart - reset head and body positions
                bodyParts = 6;
                applesEaten = 0;
                direction = 'R';
                x[0] = SCREEN_WIDTH / 2;
                y[0] = SCREEN_HEIGHT / 2;
                for (int i = 1; i < bodyParts; i++) {
                    x[i] = x[0] - i * UNIT_SIZE;
                    y[i] = y[0];
                }
                startGame();
            }
        }

        @Override public void keyReleased(KeyEvent e) {}
        @Override public void keyTyped(KeyEvent e) {}
    }
}