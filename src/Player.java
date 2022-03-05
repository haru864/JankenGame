import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Player implements ActionListener {
    public static int playerPoint;
    public static int computerPoint;
    public static int requiredNumOfWin;
    public static int times;

    public static void createButton(JPanel panel) {
        int buttonWidth = (640 - 20) / 3;
        int fontSize = 24;

        // ボタンを表示
        JButton btnGu = new JButton("グー");
        btnGu = setButton(btnGu, buttonWidth, fontSize);
        panel.add(btnGu, BorderLayout.WEST);

        JButton btnChoki = new JButton("チョキ");
        btnChoki = setButton(btnChoki, buttonWidth, fontSize);
        panel.add(btnChoki, BorderLayout.CENTER);

        JButton btnPa = new JButton("パー");
        btnPa = setButton(btnPa, buttonWidth, fontSize);
        panel.add(btnPa, BorderLayout.EAST);
    }

    // じゃんけんボタン生成メソッド
    public static JButton setButton(JButton button, int buttonWidth, int fontSize) {
        Dimension buttonDimesion = new Dimension(buttonWidth, 50);
        button.setPreferredSize(buttonDimesion);
        Font buttonFont = new Font("ＭＳ ゴシック", Font.PLAIN, fontSize);
        button.setFont(buttonFont);

        Player player = new Player();
        button.addActionListener(player);

        return (button);
    }

    // ボタン押下検知メソッド
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // System.out.println(command);

        int playerHand = 0;
        times++;

        if (command.equals("グー")) {
            playerHand = 1;
        } else if (command.equals("チョキ")) {
            playerHand = 2;
        } else if (command.equals("パー")) {
            playerHand = 3;
        } else if (command.equals("リセット")) {
            playerHand = 0;
            times = 0;
        }

        int computerHand = Computer.decideComputerHand();
        VictoryOrDefeat.decideVictoryOrDefeat(computerHand, playerHand);
    }

    // リセット
    public static void resetPoint() {
        Player.playerPoint = 0;
        Player.computerPoint = 0;
        Player.times = 0;
    }
}
