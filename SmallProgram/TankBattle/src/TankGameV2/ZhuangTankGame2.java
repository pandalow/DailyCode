package TankGameV2;

import javax.swing.*;

public class ZhuangTankGame2 extends JFrame {
    MyPanel mp = null;

    public static void main(String[] args) {
        new ZhuangTankGame2();

    }

    public ZhuangTankGame2(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
