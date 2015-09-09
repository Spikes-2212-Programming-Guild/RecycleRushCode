package macro;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class JoystickButtonForRecord extends JoystickButton {

	public JoystickButtonForRecord(GenericHID joystick, int buttonNumber) {
		super(joystick, buttonNumber);
		num = buttonNumber;
	}

	int num;

	public int getNum() {
		return num;
	}
}
