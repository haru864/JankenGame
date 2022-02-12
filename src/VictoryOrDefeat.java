public class VictoryOrDefeat {
    public static void decideVictoryOrDefeat(int computerHand, int playerHand) {
        if (playerHand == computerHand) {
            Panel.contentsLabel.setText("引き分け！");
            Panel.headerLabel.setText("現在の得点:" + Player.point);
        } else if ((playerHand == 3 && computerHand == 1) || (playerHand + 1 == computerHand)) {
            Player.point++;
            Panel.contentsLabel.setText("あなたの勝ち！");
            Panel.headerLabel.setText("現在の得点:" + Player.point);
        } else {
            Player.point = 0;
            Panel.contentsLabel.setText("あなたの負け！");
            Panel.headerLabel.setText("現在の得点:" + Player.point);
        }
    }
}
