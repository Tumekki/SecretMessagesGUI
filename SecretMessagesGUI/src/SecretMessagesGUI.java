import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SecretMessagesGUI extends JFrame {
	private JTextField textKey;
	private JTextArea textIn;
	private JTextArea textOut;
    private JSlider slider;
	
	public String encode(String message, int keyVal) {
		String output = "";
		char key = (char) keyVal;
		for ( int x = 0; x < message.length(); x++ ) {
            char input = message.charAt(x);
            if (input >= 'A' && input <= 'Z')
            {
                input += key;
                if (input > 'Z')
                    input -= 26;
                if (input < 'A')
                    input += 26;
            }
            else if (input >= 'a' && input <= 'z')
            {
                input += key;
                if (input > 'z')
                    input -= 26;
                if (input < 'a')
                    input += 26;
            }
            else if (input >= '0' && input <= '9')
            {
                input += (keyVal % 10);
                if (input > '9')
                    input -= 10;
                if (input < '0')
                    input += 10;
}
            output += input;
        }
        return output;
    }
	
	public SecretMessagesGUI() {
		getContentPane().setBackground(new Color(0, 255, 127));
		setTitle("Tuukka's Secret Messages App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textIn = new JTextArea();
		textIn.setWrapStyleWord(true);
		textIn.setLineWrap(true);
		textIn.setFont(new Font("Superclarendon", Font.PLAIN, 18));
		textIn.setBounds(17, 17, 566, 137);
		getContentPane().add(textIn);
		
		textOut = new JTextArea();
		textOut.setWrapStyleWord(true);
		textOut.setLineWrap(true);
		textOut.setFont(new Font("Superclarendon", Font.PLAIN, 18));
		textOut.setBounds(17, 223, 566, 137);
		getContentPane().add(textOut);
		
		textKey = new JTextField();
		textKey.setText("5");
		textKey.setHorizontalAlignment(SwingConstants.CENTER);
		textKey.setBounds(241, 173, 38, 26);
		getContentPane().add(textKey);
		textKey.setColumns(10);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(182, 178, 61, 16);
		getContentPane().add(lblKey);
		
		JButton btnEncodedecode = new JButton("Encode/Decode");
		btnEncodedecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
                String message = textIn.getText();
                int key = Integer.parseInt( textKey.getText() );
                String output = encode(message, key);
                textOut.setText(output);
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null, "Please enter a whole number value for the encryption key.");
				textKey.requestFocus();
				textKey.selectAll();
			}
			}
		});
		btnEncodedecode.setBounds(277, 173, 131, 29);
		getContentPane().add(btnEncodedecode);
		
		slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
                textKey.setText( "" + slider.getValue() );
                String message = textIn.getText();
                int key = slider.getValue();
                String output = encode(message, key);
                textOut.setText(output);
                
			}
		});
		slider.setValue(5);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(13);
		slider.setMinorTickSpacing(1);
		slider.setMinimum(-26);
		slider.setMaximum(26);
		slider.setPaintLabels(true);
		slider.setForeground(new Color(0, 0, 0));
		slider.setBounds(17, 166, 190, 45);
		getContentPane().add(slider);
	}

	public static void main(String[] args) {
		SecretMessagesGUI theApp = new SecretMessagesGUI();
		theApp.setSize(new java.awt.Dimension(600,400));
		theApp.setVisible(true);
	}
}
