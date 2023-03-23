/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.util.function.Function;

/**
 *
 * @author NightmareGaurav
 */
public class DancingPointerWithClick {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException {
        Function<Robot, Void> moveMouse = (r) -> {
            r.mouseMove((int) (Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().width+1)), (int) (Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().height+1)));
            return null;
        };

        while(true){
            var robot = new Robot();
            moveMouse.apply(robot);

            var buttonToClick = switch (Math.random() < 0.33 ? 0 : Math.random() < 0.66 ? 1 : 2) {
                case 0 -> InputEvent.BUTTON1_DOWN_MASK;
                case 1 -> InputEvent.BUTTON2_DOWN_MASK;
                default -> InputEvent.BUTTON3_DOWN_MASK;
            };
            var drag = Math.random() < 0.5;

            robot.mousePress(buttonToClick);
            if(drag) moveMouse.apply(robot);
            robot.mouseRelease(buttonToClick);
        }
    }
}

// convert to jar using this command
// javac -cp . DancingPointerWithClick.java && jar cvfe DancingPointerWithClick.jar DancingPointerWithClick DancingPointerWithClick.class