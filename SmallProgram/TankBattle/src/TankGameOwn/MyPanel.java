package TankGameOwn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    HeroTank heroTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemySize = 3;

    public MyPanel() {

        heroTank = new HeroTank(100, 100);
        heroTank.setSpeed(3);

        for (int i = 0; i < enemySize; i++) {
            EnemyTank enemyTank = new EnemyTank((i + 1) * 100, 300);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
            enemyTanks.get(i).shotBullet();
        }

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        // Draw User Tank
        drawTank(heroTank.getX(), heroTank.getY(), g, heroTank.getDirect(), 0);
        // Draw bullet
        if (heroTank.bullet != null && heroTank.bullet.isLive != false) {
            g.drawOval(heroTank.bullet.getX(), heroTank.bullet.getY(), 2, 2);
        }

        for (int i = 0; i< enemyTanks.size();i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
            if (enemyTank.bullets != null && enemyTank.bullet.isLive != false) {
                g.drawOval(enemyTank.bullet.getX(), enemyTank.bullet.getY(),2,2);
            } else  {
                enemyTank.bullets.remove(enemyTank.bullet);
            }
        }
    }

    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direct) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.drawOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.drawOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            heroTank.setDirect(0);
            heroTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            heroTank.setDirect(1);
            heroTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            heroTank.setDirect(2);
            heroTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            heroTank.setDirect(3);
            heroTank.moveLeft();
        }
        if (e.getKeyCode() == KeyEvent.VK_J) {
            heroTank.shotBullet();
        }
        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.repaint();
        }
    }
}
