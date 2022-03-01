import javax.swing.JFrame;

public class GameMain {
    public static JFrame frame;

    public static void main(String[] arg) {
        // ウィンドウ設定
        frame = new JFrame("じゃんけんゲーム");
        frame.setSize(640, 480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Panel.createPanel();

        // ウィンドウ表示
        frame.setVisible(true);
    }
}
