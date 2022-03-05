import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel {
    public static JPanel headerPanel;
    public static JLabel headerLabel;
    public static JLabel contentsLabel;

    public static void createPanel() {
        // パネル表示
        Dimension headerPanelDimension = new Dimension(640, 50);
        headerPanel = setPanel(Color.BLACK, headerPanelDimension);
        headerLabel = new JLabel("「さあ、じゃんけんで勝負だ！」");
        headerLabel.setPreferredSize(new Dimension(640, 50));
        headerLabel = setFont(Color.WHITE, headerLabel, 24);
        headerPanel.add(headerLabel, BorderLayout.CENTER);
        GameMain.frame.add(headerPanel, BorderLayout.NORTH);

        // コンテンツパネル
        Dimension contentsPanelDimension = new Dimension(640, 50);
        JPanel contentsPanel = setPanel(Color.WHITE, contentsPanelDimension);
        contentsLabel = new JLabel("じゃんけん・・・");
        contentsLabel = setFont(Color.BLACK, contentsLabel, 54);
        contentsPanel.add(contentsLabel);
        GameMain.frame.add(contentsPanel, BorderLayout.CENTER);

        // フッタパネル
        Dimension footerPanelDimension = new Dimension(640, 50);
        JPanel footerPanel = setPanel(Color.BLACK, footerPanelDimension);
        Player.createButton(footerPanel);
        GameMain.frame.add(footerPanel, BorderLayout.SOUTH);
    }

    // パネル生成メソッド
    public static JPanel setPanel(Color color, Dimension dimension) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setPreferredSize(dimension);
        panel.setLayout(new BorderLayout());
        return panel;
    }

    // フォント生成メソッド
    public static JLabel setFont(Color color, JLabel label, int size) {
        label.setForeground(color);
        Font labelFont = new Font("ＭＳ ゴシック", Font.PLAIN, size);
        label.setFont(labelFont);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        return (label);
    }

    // 勝敗表示パネル生成メソッド
    public static void setSituation(String winOrLose, String playerHand, String computerHand, ImageIcon playerHandIcon,
            ImageIcon computerHandIcon) {
        // System.out.printf("%s, %s, %s\n", winOrLose, playerHand, computerHand);

        // プレイヤーの選択結果を表示
        Dimension playerHandDimension = new Dimension(640 / 3, 50);
        JPanel playerHandPanel = setPanel(Color.WHITE, playerHandDimension);
        JLabel playerHandLabel = new JLabel("<html><br><br><br>あなたの手<br>" + playerHand + "</html>");
        JLabel playerHandIconLabel = new JLabel(playerHandIcon);
        playerHandLabel = setFont(Color.BLACK, playerHandLabel, 25);
        if (winOrLose.equals("得点をリセットしました。")) {
            playerHandPanel.add(playerHandLabel);
        } else {
            playerHandPanel.add(playerHandLabel, BorderLayout.NORTH);
            playerHandPanel.add(playerHandIconLabel, BorderLayout.SOUTH);
        }
        GameMain.frame.add(playerHandPanel, BorderLayout.WEST);

        // 勝敗と連勝数を表示
        contentsLabel = setFont(Color.BLACK, contentsLabel, 25);
        contentsLabel.setText("<html>" + winOrLose + "<br>" + "あなたの得点：" + Player.playerPoint + "<br>" + "あいての得点："
                + Player.computerPoint + "</html>");

        // コンピュータの選択結果を表示
        Dimension cpuHandDimension = new Dimension(640 / 3, 50);
        JPanel cpuHandPanel = setPanel(Color.WHITE, cpuHandDimension);
        JLabel cpuHandLabel = new JLabel("<html><br><br><br>あいての手<br>" + computerHand + "</html>");
        JLabel cpuHandIconLabel = new JLabel(computerHandIcon);
        cpuHandLabel = setFont(Color.BLACK, cpuHandLabel, 25);
        if (winOrLose.equals("得点をリセットしました。")) {
            cpuHandPanel.add(cpuHandLabel);
        } else {
            cpuHandPanel.add(cpuHandLabel, BorderLayout.NORTH);
            cpuHandPanel.add(cpuHandIconLabel, BorderLayout.SOUTH);
        }
        GameMain.frame.add(cpuHandPanel, BorderLayout.EAST);
    }

    // メニューバー生成メソッド
    public static void setMenu() {
        headerPanel.removeAll();
        headerLabel = new JLabel(Player.times + "回目の勝負です。");
        headerLabel = setFont(Color.WHITE, headerLabel, 24);
        headerLabel.setPreferredSize(new Dimension(450, 50));
        headerPanel.add(headerLabel, BorderLayout.WEST);
        setResetButton();
        setListOfPreemption();
    }

    // リセットボタン生成メソッド
    public static void setResetButton() {
        JButton btnReset = new JButton("リセット");
        btnReset = Player.setButton(btnReset, 100, 15);
        headerPanel.add(btnReset, BorderLayout.EAST);
    }

    // N本先取リスト生成メソッド
    public static void setListOfPreemption() {
        var data = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        var dropList = new JComboBoxOriginal(data);
        dropList.comboBox.setSelectedItem(Player.requiredNumOfWin);
        headerPanel.add(dropList.comboBox, BorderLayout.CENTER);
    }

    // ポップアップ生成メソッド
    public static void popupMessage(String message) {
        JFrame popupFrame = new JFrame();
        JOptionPane.showMessageDialog(popupFrame, message);
    }
}