package macro;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author thinkredstone
 */
public class JoystickButtonForRecord extends JoystickButton {

    /**
     *
     * @param joystick - the joystick ID
     * @param buttonNumber - the number for the button. usually 1-12
     */
    public JoystickButtonForRecord(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
		num = buttonNumber;
	}

	int num;

    /**
     *
     * @return the button number 
     */
    public int getNum() {
		return num;
	}
}
