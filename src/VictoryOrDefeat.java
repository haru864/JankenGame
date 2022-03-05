import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;

public class VictoryOrDefeat {
    static ImageIcon iconPa;
    static ImageIcon iconChoki;
    static ImageIcon iconGu;
    static ArrayList<ImageIcon> imgList;

    public static void initStatic() {
        iconPa = Rendering.renderingImageIcon(new ImageIcon("../pic/Paper.jpg"));
        iconChoki = Rendering.renderingImageIcon(new ImageIcon("../pic/Scissors.jpg"));
        iconGu = Rendering.renderingImageIcon(new ImageIcon("../pic/Rock.jpg"));
        imgList = new ArrayList<>();
    }

    public static void decideVictoryOrDefeat(int computerHand, int playerHand) {
        // System.out.printf("%d, %d\n", computerHand, playerHand);
        ArrayList<String> list = new ArrayList<>(Arrays.asList("未選択", "グー", "チョキ", "パー"));

        initStatic();
        imgList.add(iconGu);
        imgList.add(iconChoki);
        imgList.add(iconPa);

        if (playerHand == 0) {
            Player.resetPoint();
            reflectSituation("得点をリセットしました。", "-", "-", imgList.get(0), imgList.get(0));
        } else if (playerHand == computerHand) {
            reflectSituation("引き分け！", list.get(playerHand), list.get(computerHand), imgList.get(playerHand - 1),
                    imgList.get(computerHand - 1));
        } else if ((playerHand == 3 && computerHand == 1) || (playerHand + 1 == computerHand)) {
            Player.playerPoint++;
            reflectSituation("あなたの勝ち！", list.get(playerHand), list.get(computerHand), imgList.get(playerHand - 1),
                    imgList.get(computerHand - 1));
        } else {
            Player.computerPoint++;
            reflectSituation("あなたの負け！", list.get(playerHand), list.get(computerHand), imgList.get(playerHand - 1),
                    imgList.get(computerHand - 1));
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
    public static void reflectSituation(String winOrLose, String playerHand, String computerHand,
            ImageIcon playerHandIcon,
            ImageIcon computerHandIcon) {
        Panel.setSituation(winOrLose, playerHand, computerHand, playerHandIcon, computerHandIcon);
    }

    // ヘッダにリセットボタン、終了ボタン、N本先取リストを表示する
    public static void setHeaderButton() {
        Panel.setMenu();
    }

    public static void restartGame(String message) {
        Panel.popupMessage(message);
        Player.resetPoint();
        reflectSituation("得点をリセットしました。", "-", "-", imgList.get(0), imgList.get(0));
        setHeaderButton();
    }
}
