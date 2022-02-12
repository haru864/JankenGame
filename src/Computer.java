import java.util.Random;

public class Computer {
    public static int decideComputerHand() {
        Random random = new Random();
        int computerHand = random.nextInt(3) + 1;
        if (computerHand == 1)
            Panel.contentsLabel.setText("グー");
        else if (computerHand == 2)
            Panel.contentsLabel.setText("チョキ");
        else if (computerHand == 3)
            Panel.contentsLabel.setText("パー");
        return computerHand;
    }
}
