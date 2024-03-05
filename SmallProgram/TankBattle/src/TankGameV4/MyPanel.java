package TankGameV4;

import sun.awt.image.ToolkitImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener, Runnable {
    HeroTank heroTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    int enemySize = 3;

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {

        heroTank = new HeroTank(100, 100);
        heroTank.setSpeed(3);

        for (int i = 0; i < enemySize; i++) {
            EnemyTank enemyTank = new EnemyTank((i + 1) * 100, 300);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);
            enemyTanks.get(i).shotBullet();
        }
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));

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

        for (int i = 0; i < enemyTanks.size(); i++) {
           EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);

                for (int j = 0; j < enemyTank.bullets.size(); j++) {
                    Bullet bullet = enemyTank.bullets.get(j);
                    if (bullet.isLive) {
                        g.drawOval(bullet.getX(), bullet.getY(), 2, 2);
                    } else {
                        enemyTank.bullets.remove(bullet);
                    }
                }
            }
        }
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if(bomb.life>6){
                g.drawImage(image1,bomb.x,bomb.y,30,30,this);
            }else if(bomb.life>3){
                g.drawImage(image2,bomb.x,bomb.y,30,30,this);
            }else if(bomb.life>1){
                g.drawImage(image3,bomb.x,bomb.y,30,30,this);
            }
            bomb.lifeDown();
            if(bomb.life == 0){
                bombs.remove(bomb);
            }
        }
    }
    public void hitTank(Bullet bullet, EnemyTank enemyTank) {
        switch (enemyTank.getDirect()) {
            case 0:
            case 2:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < (enemyTank.getX() + 40) &&
                        bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 60) {
                    bullet.isLive = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);

                }
                break;
            case 1:
            case 3:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < (enemyTank.getX() + 60) &&
                        bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 40) {
                    bullet.isLive = false;
                    enemyTank.isLive = false;
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
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

            if (heroTank.bullet != null && heroTank.bullet.isLive) {
                for (int i = 0; i < enemyTanks.size(); i++) {
                    hitTank(heroTank.bullet, enemyTanks.get(i));
                }
            }
            this.repaint();
        }
    }
}
