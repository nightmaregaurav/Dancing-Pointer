/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
/**
 *
 * @author NightmareGaurav
 */
public class DancingPointer {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws AWTException {
        while(true) new Robot().mouseMove((int) (Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().width+1)), (int) (Math.random() * (Toolkit.getDefaultToolkit().getScreenSize().height+1)));
    }
}

// convert to jar using this command
// javac -cp . DancingPointer.java && jar cvfe DancingPointer.jar DancingPointer DancingPointer.class