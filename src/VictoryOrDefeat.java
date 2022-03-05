import java.util.ArrayList;
import java.util.Arrays;

public class VictoryOrDefeat {
    public static void decideVictoryOrDefeat(int computerHand, int playerHand) {
        // System.out.printf("%d, %d\n", computerHand, playerHand);
        ArrayList<String> list = new ArrayList<>(Arrays.asList("未選択", "グー", "チョキ", "パー"));

        if (playerHand == 0) {
            Player.resetPoint();
            reflectSituation("得点をリセットしました。", "-", "-");
        } else if (playerHand == computerHand) {
            reflectSituation("引き分け！", list.get(playerHand), list.get(computerHand));
        } else if ((playerHand == 3 && computerHand == 1) || (playerHand + 1 == computerHand)) {
            Player.playerPoint++;
            reflectSituation("あなたの勝ち！", list.get(playerHand), list.get(computerHand));
        } else {
            Player.computerPoint++;
            reflectSituation("あなたの負け！", list.get(playerHand), list.get(computerHand));
        }

        setHeaderButton();

        if (Player.playerPoint == Player.requiredNumOfWin) {
            String message = Player.requiredNumOfWin + "本先取しました。\nあなたの勝ちです。";
            restartGame(message);
        } else if (Player.computerPoint == Player.requiredNumOfWin) {
            String message = Player.requiredNumOfWin + "本先取されました。\nあなたの負けです。";
            restartGame(message);
        }
    }

    // 勝敗、プレイヤーとCPUの手を表示する画面を作成
    public static void reflectSituation(String winOrLose, String playerHand, String computerHand) {
        Panel.setSituation(winOrLose, playerHand, computerHand);
    }

    // ヘッダにリセットボタン、終了ボタン、N本先取リストを表示する
    public static void setHeaderButton() {
        Panel.setMenu();
    }

    public static void restartGame(String message) {
        Panel.popupMessage(message);
        Player.resetPoint();
        reflectSituation("得点をリセットしました。", "-", "-");
        setHeaderButton();
    }
}
