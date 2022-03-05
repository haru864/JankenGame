import javax.swing.*;
import java.awt.event.*;

public class JComboBoxOriginal implements ItemListener {
    public JComboBox<Integer> comboBox;

    public JComboBoxOriginal(Integer[] comboData) {
        this.comboBox = new JComboBox<>(comboData);
        comboBox.addItemListener(this);
    }

    public void itemStateChanged(ItemEvent evt) {
        String item = evt.getItem().toString();
        int itemSelected = Integer.parseInt(item);

        if (evt.getStateChange() == ItemEvent.SELECTED && itemSelected != Player.requiredNumOfWin) {
            Player.requiredNumOfWin = Integer.parseInt(item);
            String message = Player.requiredNumOfWin + "本先取であなたの勝ちです。\nこの設定は後から変更できます。";
            VictoryOrDefeat.restartGame(message);
        }
    }
}
