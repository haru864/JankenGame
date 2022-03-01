import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel {
    public static JLabel headerLabel;
    public static JLabel contentsLabel;

    public static void createPanel() {
        // パネル表示
        Dimension headerPanelDimension = new Dimension(640, 50);
        JPanel headerPanel = setPanel(Color.BLACK, headerPanelDimension);
        headerLabel = new JLabel("「さあ、じゃんけんで勝負だ！」");
        headerLabel = setFont(Color.WHITE, headerLabel, 24);
        headerPanel.add(headerLabel);
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
    public static void setSituation(String winOrLose, String playerHand, String computerHand) {
        // System.out.printf("%s, %s, %s\n", winOrLose, playerHand, computerHand);

        // プレイヤーの選択結果を表示
        Dimension playerHandDimension = new Dimension(640 / 3, 50);
        JPanel playerHandPanel = setPanel(Color.WHITE, playerHandDimension);
        JLabel playerHandLabel = new JLabel("あなたの手\n" + computerHand);
        playerHandLabel = setFont(Color.BLACK, playerHandLabel, 30);
        playerHandPanel.add(playerHandLabel);
        // GameMain.frame.add(playerHandPanel, BorderLayout.WEST);

        // 勝敗と連勝数を表示
        Panel.contentsLabel = setFont(Color.BLACK, contentsLabel, 30);
        Panel.contentsLabel.setText("<html>" + winOrLose + "<br>" + "連勝数：" + Player.point + "</html>");

        // コンピュータの選択結果を表示
        Dimension cpuHandDimension = new Dimension(640 / 3, 50);
        JPanel cpuHandPanel = setPanel(Color.WHITE, cpuHandDimension);
        JLabel cpuHandLabel = new JLabel("あいての手\n" + computerHand);
        cpuHandLabel = setFont(Color.BLACK, cpuHandLabel, 30);
        cpuHandPanel.add(cpuHandLabel);
        // GameMain.frame.add(cpuHandPanel, BorderLayout.EAST);
    }
}