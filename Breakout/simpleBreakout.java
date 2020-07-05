package Breakout;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class simpleBreakout extends JPanel implements Runnable, KeyListener {
    // Initialize Ball
    int ballx = (int) (Math.random() * 41) + 300;
    int bally = (int) (Math.random() * 41) + 420;
    Rectangle Ball = new Rectangle(ballx, bally, 10, 10);
    // Initialize Bat
    int batx = 320;
    int baty = 490;
    Rectangle Bat = new Rectangle(batx, baty, 80, 10);
    // Initialize Bricks
    int brickx = 140;
    int bricky = 100;
    Rectangle[] Brick = new Rectangle[18];
    // Establish Boolean for Key Press
    static boolean right = false;
    static boolean left = false;
    // Determine if game is over or not
    boolean gameOver = false;
    // Counters
    int count = 0;
    int deflections = 0;
    long lastTickTime = System.currentTimeMillis();

    public simpleBreakout() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        simpleBreakout game = new simpleBreakout();
        JButton button = new JButton("restart");
        frame.setSize(700, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        game.addKeyListener(game);
        game.setFocusable(true);
        Thread t = new Thread(game);
        t.start();
    }

    public void paint(Graphics g) {
        // Panel
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 700, 900);
        // Ball
        g.setColor(Color.red);
        g.fillOval(Ball.x, Ball.y, Ball.width, Ball.height);
        // Bat
        g.setColor(Color.green);
        g.fill3DRect(Bat.x, Bat.y, Bat.width, Bat.height, true);
        // Panel Below Bat
        g.setColor(Color.GRAY);
        g.fillRect(0, 502, 900, 400);
        // Panel Border
        g.setColor(Color.red);
        g.drawRect(2, 2, 682, 500);

        g.setColor(Color.white);
        Font escape = new Font("Arial", Font.BOLD, 10);
        g.setFont(escape);
        g.drawString("Press ESCAPE KEY", 580, 20);
        g.drawString("to close window", 595, 30);

        for (int i = 0; i < Brick.length; i++) {
            if (Brick[i] != null) {
                g.setColor(Color.red);
                g.fill3DRect(Brick[i].x, Brick[i].y, Brick[i].width, Brick[i].height, true);
            }
        }

        if (ballFallDown == true || bricksOver == true) {
            g.setColor(Color.red);
            Font f = new Font("Arial", Font.BOLD, 40);
            g.setFont(f);
            g.drawString(status, 140, 240);
            ballFallDown = false;
        }
    }

    double movex = -3;
    double movey = -3;
    boolean ballFallDown = false;
    boolean bricksOver = false;
    String status;

    public void run() {
        // Display Bricks
        int firstX = brickx;
        for (int i = 0; i < Brick.length; i++) {
            Brick[i] = new Rectangle(brickx, bricky, 60, 20);
            if (i == 5) {
                brickx = firstX - 62;
                bricky = 124;
            }
            if (i == 11) {
                brickx = firstX - 62;
                bricky = 148;
            }
            brickx += 62;
        }

        while (!gameOver) {
            // Brick Removed When Ball Hits
            for (int i = 0; i < Brick.length; i++) {
                if (Brick[i] != null) {
                    if (Brick[i].intersects(Ball)) {
                        Brick[i] = null;
                        movey = -movey;
                        count++;
                    }
                }
            }

            // When get rid of all bricks, then end game
            if (count == Brick.length) {
                bricksOver = true;
                status = "YOU WON THE GAME";
                gameOver = true;
            }

            // Ball is Now "Moving"
            repaint();
            Ball.x += movex;
            Ball.y += movey;

            // Keep Ball Within Boundary
            if (Ball.x <= 0 || Ball.x + Ball.height >= 682) {
                movex = -movex;
            }
            if (Ball.y <= 0) {
                movey = -movey;
            }

            // You Lose Message
            if (Ball.y >= 500) {
                ballFallDown = true;
                status = "YOU LOST THE GAME";
                // repaint();
            }

            // Bat is Now "Moving"
            if (left == true) {
                Bat.x -= 5;
                right = false;
            }
            if (right == true) {
                Bat.x += 5;
                left = false;
            }

            // Keep Bat Within Boundary
            if (Bat.x < 4) {
                Bat.x = 4;
            } else if (Bat.x >= 600) {
                Bat.x = 600;
            }

            // Bat Deflects Ball
            if (Ball.intersects(Bat)) {
                movey = -movey * (Math.random() * 0.4 + 0.8);
                deflections++;
            }

            // Execute Every 10 Milliseconds
            try {
                Thread.sleep(10);
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            left = true;
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            right = true;
        }

        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            left = false;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            right = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
    }
}