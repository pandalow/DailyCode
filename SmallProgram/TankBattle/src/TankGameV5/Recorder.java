package TankGameV5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Recorder {
    private static int allEnemyNums = 0;
    private static BufferedWriter bw = null;
    private static File recordFile = new File("./myRecord.dat");
    public static Vector<EnemyTank> enemyTanks = null;

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static void keepRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyNums + "\r\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isLive){
                    String record = enemyTank.getX() + " " + enemyTank.getY() +" " + enemyTank.getDirect();
                    bw.write(record);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int getAllEnemyNums() {
        return allEnemyNums;
    }

    public static void setAllEnemyNums(int allEnemyNums) {
        Recorder.allEnemyNums = allEnemyNums;
    }

    public static void addAllEnemyNums() {
        allEnemyNums++;
    }
}
