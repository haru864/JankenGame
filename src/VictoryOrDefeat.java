import java.util.ArrayList;
import java.util.Arrays;

public class VictoryOrDefeat {
    public static void decideVictoryOrDefeat(int computerHand, int playerHand) {
        // System.out.printf("%d, %d\n", computerHand, playerHand);
        ArrayList<String> list = new ArrayList<>(Arrays.asList("dummy", "グー", "チョキ", "パー"));

        if (playerHand == computerHand) {
            reflectSituation("引き分け！", list.get(playerHand), list.get(computerHand));
        } else if ((playerHand == 3 && computerHand == 1) || (playerHand + 1 == computerHand)) {
            Player.point++;
            reflectSituation("あなたの勝ち！", list.get(playerHand), list.get(computerHand));
        } else {
            Player.point = 0;
            reflectSituation("あなたの負け！", list.get(playerHand), list.get(computerHand));
        }

        setHeaderButton();
    }

    // 勝敗、プレイヤーとCPUの手を表示する画面を作成
    public static void reflectSituation(String winOrLose, String playerHand, String computerHand) {
        Panel.setSituation(winOrLose, playerHand, computerHand);
    }

    // ヘッダにリセットボタン、終了ボタン、N本先取リストを表示する
    public static void setHeaderButton() {
        Panel.setResetButton();
        // Panel.setListOfPreemption();
        Panel.setQuitButton();
    }
}
