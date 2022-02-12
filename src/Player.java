import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Player implements ActionListener {
    public static int point;

    public static void createButton(JPanel panel) {
        // ボタンを表示
        JButton btnGu = new JButton("グー");
        btnGu = setButton(btnGu);
        panel.add(btnGu, BorderLayout.WEST);

        JButton btnChoki = new JButton("チョキ");
        btnChoki = setButton(btnChoki);
        panel.add(btnChoki, BorderLayout.CENTER);

        JButton btnPa = new JButton("パー");
        btnPa = setButton(btnPa);
        panel.add(btnPa, BorderLayout.EAST);
    }

    // ボタン生成メソッド
    public static JButton setButton(JButton button) {
        int buttonSize = (640 - 20) / 3;
        Dimension buttonDimesion = new Dimension(buttonSize, 50);
        button.setPreferredSize(buttonDimesion);
        Font buttonFont = new Font("ＭＳ ゴシック", Font.PLAIN, 24);
        button.setFont(buttonFont);

        Player player = new Player();
        button.addActionListener(player);

        return (button);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        int playerHand = 0;
        if (command.equals("グー"))
            playerHand = 1;
        else if (command.equals("チョキ"))
            playerHand = 2;
        else if (command.equals("パー"))
            playerHand = 3;

        int computerHand = Computer.decideComputerHand();
        VictoryOrDefeat.decideVictoryOrDefeat(computerHand, playerHand);
    }
}
