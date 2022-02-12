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

    public static void createPanel(JFrame frame) {
        // パネル表示
        Dimension headerPanelDimension = new Dimension(640, 50);
        JPanel headerPanel = setPanel(Color.BLACK, headerPanelDimension);
        headerLabel = new JLabel("「さあ、じゃんけんで勝負だ！」");
        headerLabel = setFont(Color.WHITE, headerLabel, 24);
        headerPanel.add(headerLabel);
        frame.add(headerPanel, BorderLayout.NORTH);

        // コンテンツパネル
        Dimension contentsPanelDimension = new Dimension(640, 50);
        JPanel contentsPanel = setPanel(Color.WHITE, contentsPanelDimension);
        contentsLabel = new JLabel("じゃんけん・・・");
        contentsLabel = setFont(Color.BLACK, contentsLabel, 54);
        contentsPanel.add(contentsLabel);
        frame.add(contentsPanel, BorderLayout.CENTER);

        // フッタパネル
        Dimension footerPanelDimension = new Dimension(640, 50);
        JPanel footerPanel = setPanel(Color.BLACK, footerPanelDimension);
        Player.createButton(footerPanel);
        frame.add(footerPanel, BorderLayout.SOUTH);
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
}