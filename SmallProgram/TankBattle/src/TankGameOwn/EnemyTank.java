//package TankGameOwn;
//
//import java.util.Vector;
//
//public class EnemyTank extends Tank implements Runnable {
//    Vector<Bullet> bullets = new Vector<>();
//
//    Bullet bullet = null;
//    boolean isLive = true;
//    public EnemyTank(int x, int y) {
//        super(x, y);
//    }
//
//    public void shotBullet() {
//        bullet = new Bullet(getX() + 20, getY() + 60, 2);
//        bullets.add(bullet);
//        Thread thread = new Thread(bullet);
//        thread.start();
//    }
//
//    public void run() {
//        while (true) {
//            int randomDirect = (int) (Math.random() * 3);
//            setDirect(randomDirect);
//            for (int i = 0; i <= 10; i++) {
//                if (randomDirect == 0) {
//                    moveUp();
//                } else if (randomDirect == 1) {
//                    moveRight();
//                } else if (randomDirect == 2) {
//                    moveDown();
//                } else if (randomDirect == 3) {
//                    moveLeft();
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                shotBullet();
//            }
//        }
//    }
//}
