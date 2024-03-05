package TankGameV4;

import java.util.Vector;

public class EnemyTank extends Tank{
    Vector<Bullet> bullets = new Vector<>();
    Bullet bullet  = null;
    public EnemyTank(int x, int y){
        super(x,y);
    }
    boolean isLive = true;
    public void shotBullet(){
//        while(true){
        bullet = new Bullet(getX()+20,getY()+60,2);
        bullets.add(bullet);
        Thread thread = new Thread(bullet);
        thread.start();
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    }
}
