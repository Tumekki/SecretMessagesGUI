import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class SecretMessagesGUI extends JFrame {
	private JTextField textKey;
	private JTextArea textIn;
	private JTextArea textOut;
	
	public String encode(String message, int keyVal) {
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
		btnEncodedecode.setBounds(292, 173, 131, 29);
		getContentPane().add(btnEncodedecode);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
