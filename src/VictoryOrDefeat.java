import java.util.ArrayList;
import java.util.Arrays;

public class VictoryOrDefeat {
    public static void decideVictoryOrDefeat(int computerHand, int playerHand) {
        // System.out.printf("%d, %d\n", computerHand, playerHand);
        ArrayList<String> list = new ArrayList<>(Arrays.asList("dummy", "グー", "チョキ", "パー"));

        if (playerHand == computerHand) {
            // Panel.contentsLabel.setText("引き分け！");
            // Panel.headerLabel.setText("現在の得点:" + Player.point);
            reflectSituation("引き分け！", list.get(playerHand), list.get(computerHand));
        } else if ((playerHand == 3 && computerHand == 1) || (playerHand + 1 == computerHand)) {
            Player.point++;
            // Panel.contentsLabel.setText("あなたの勝ち！");
            // Panel.headerLabel.setText("現在の得点:" + Player.point);
            reflectSituation("あなたの勝ち！", list.get(playerHand), list.get(computerHand));
        } else {
            Player.point = 0;
            // Panel.contentsLabel.setText("あなたの負け！");
            // Panel.headerLabel.setText("現在の得点:" + Player.point);
            reflectSituation("あなたの負け！", list.get(playerHand), list.get(computerHand));
        }
    }

    // 勝敗、プレイヤーとCPUの手を表示する画面を作成
    public static void reflectSituation(String winOrLose, String playerHand, String computerHand) {
        Panel.setSituation(winOrLose, playerHand, computerHand);
    }
}
