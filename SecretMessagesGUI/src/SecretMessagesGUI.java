import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SecretMessagesGUI extends JFrame {
	private JTextField textKey;
	private JTextArea textIn;
	private JTextArea textOut;
	
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
		setTitle("Tuukka's Secret Messages App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		textIn = new JTextArea();
		textIn.setBounds(17, 17, 566, 137);
		getContentPane().add(textIn);
		
		textOut = new JTextArea();
		textOut.setBounds(17, 223, 566, 137);
		getContentPane().add(textOut);
		
		textKey = new JTextField();
		textKey.setBounds(219, 173, 61, 26);
		getContentPane().add(textKey);
		textKey.setColumns(10);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(158, 178, 61, 16);
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
			}
			}
		});
		btnEncodedecode.setBounds(292, 173, 131, 29);
		getContentPane().add(btnEncodedecode);
	}

	public static void main(String[] args) {
		SecretMessagesGUI theApp = new SecretMessagesGUI();
		theApp.setSize(new java.awt.Dimension(600,400));
		theApp.setVisible(true);
	}
}
