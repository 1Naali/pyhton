package signup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SignUp extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelGradient panelGradient;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JLabel txtEnterpriseName;
	private JLabel passwordDeco;
	private JLabel userNameDeco;
	private JButton enterButton;
	private JButton minimizeButton;
	private JButton closeButton;

	private int WIDTH = 1600;
	private int HEIGHT = 900;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				SignUp frame = new SignUp();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public SignUp() {
		initializeFrame();
		initializeComponents();
		addComponentsToPanel();
		addListeners();
	}

	private void initializeFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int)((screenSize.getWidth()/2)-(WIDTH/2)), (int)((screenSize.getHeight()/2)-(HEIGHT/2)), WIDTH, HEIGHT);
		
		panelGradient = new PanelGradient();
		panelGradient.addColor(new ModelColor(Color.pink, 0.05f), new ModelColor(Color.cyan, 0.95f));
		panelGradient.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setUndecorated(true);
		setContentPane(panelGradient);
		panelGradient.setLayout(null);
	}
	
	private void initializeComponents() {
		int hOffset = 90;

		txtUserName = new JTextField();
		txtUserName.setCaretColor(new Color(255, 255, 255, 180));
		txtUserName.setHorizontalAlignment(SwingConstants.CENTER);
		txtUserName.setForeground(new Color(255, 255, 255, 180));
		txtUserName.setFont(new Font("Segoe UI", Font.BOLD, 30));
		txtUserName.setText("");
		txtUserName.setOpaque(false);
		txtUserName.setBounds(WIDTH/2-250, HEIGHT/2-200+hOffset, 500, 50);
		txtUserName.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(255, 255, 255, 220)));
		txtUserName.setColumns(10);
		
		userNameDeco = new JLabel("Nome de Usuário");
		userNameDeco.setHorizontalAlignment(SwingConstants.CENTER);
		userNameDeco.setForeground(new Color(255, 255, 255, 180));
		userNameDeco.setFont(new Font("Segoe UI", Font.BOLD, 30));
		userNameDeco.setOpaque(false);
		userNameDeco.setBounds(WIDTH/2-250, HEIGHT/2-200+hOffset, 500, 50);
		userNameDeco.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(255, 255, 255, 220)));
		
		txtPassword = new JPasswordField();
		txtPassword.setCaretColor(new Color(255, 255, 255, 180));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(new Color(255, 255, 255, 180));
		txtPassword.setFont(new Font("Segoe UI", Font.BOLD, 30));
		txtPassword.setText("");
		txtPassword.setOpaque(false);
		txtPassword.setBounds(WIDTH/2-250, HEIGHT/2+hOffset-20, 500, 50);
		txtPassword.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(255, 255, 255, 220)));
		
		passwordDeco = new JLabel("Senha");
		passwordDeco.setHorizontalAlignment(SwingConstants.CENTER);
		passwordDeco.setForeground(new Color(255, 255, 255, 180));
		passwordDeco.setFont(new Font("Segoe UI", Font.BOLD, 30));
		passwordDeco.setOpaque(false);
		passwordDeco.setBounds(WIDTH/2-250, HEIGHT/2+hOffset-20, 500, 50);
		passwordDeco.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(255, 255, 255, 220)));
		
		txtEnterpriseName = new JLabel("Apotheosis Co.");
		txtEnterpriseName.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterpriseName.setForeground(new Color(255, 255, 255));
		txtEnterpriseName.setFont(new Font("Segoe UI", Font.BOLD, 100));
		txtEnterpriseName.setOpaque(false);
		txtEnterpriseName.setBounds(WIDTH/2-600, 50, 1200, 150);
		txtEnterpriseName.setBorder(null);

		closeButton = new JButton("X");
		closeButton.setForeground(Color.white);
		closeButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
		closeButton.setBounds(1540, 10, 50, 50);
		closeButton.setBorder(null);
		closeButton.setContentAreaFilled(false);
		closeButton.setFocusPainted(false);
		
		minimizeButton = new JButton("-");
		minimizeButton.setForeground(Color.white);
		minimizeButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 50));
		minimizeButton.setBounds(1490, 10, 50, 50);
		minimizeButton.setBorder(null);
		minimizeButton.setContentAreaFilled(false);
		minimizeButton.setFocusPainted(false);
		
		enterButton = new JButton("Entrar");
		enterButton.setFont(new Font("Segoe UI", Font.BOLD, 30));
		enterButton.setForeground(new Color(255, 255, 255, 230));
		enterButton.setBounds(WIDTH / 2 - 125, HEIGHT / 2 + 200, 250, 60);
		enterButton.setHorizontalAlignment(SwingConstants.CENTER);
		enterButton.setBorder(null);
		enterButton.setFocusPainted(false);
		enterButton.setContentAreaFilled(false);
	}
	
	private void addComponentsToPanel() {
		panelGradient.add(txtUserName);
		panelGradient.add(userNameDeco);
		panelGradient.add(txtPassword);
		panelGradient.add(passwordDeco);
		panelGradient.add(txtEnterpriseName);
		panelGradient.add(closeButton);
		panelGradient.add(minimizeButton);
		panelGradient.add(enterButton);
	}
	
	private void addListeners() {
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getContentPane().requestFocusInWindow();
			}
		});

		txtUserName.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				userNameDeco.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtUserName.getText().isEmpty()) {
					userNameDeco.setVisible(true);
				}
			}
		});

		txtUserName.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				userNameDeco.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtUserName.getText().isEmpty()) {
                    userNameDeco.setVisible(true);
                }
			}

			@Override
			public void changedUpdate(DocumentEvent e) {}
		});
		
		txtPassword.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordDeco.setVisible(false);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtPassword.getPassword().length == 0) {
					passwordDeco.setVisible(true);
				}
			}
		});

		txtPassword.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				passwordDeco.setVisible(false);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				if (txtPassword.getPassword().length == 0) {
                    passwordDeco.setVisible(true);
                }
			}

			@Override
			public void changedUpdate(DocumentEvent e) {}
		});
		
		closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeButton.setForeground(new Color(230,230,230)); 
			}

			@Override
			public void mouseExited(MouseEvent e) {
				closeButton.setForeground(Color.WHITE); 
			}
		});
		
		closeButton.addActionListener(e -> dispose());
		
		minimizeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				minimizeButton.setForeground(new Color(230,230,230)); 
			}

			@Override
			public void mouseExited(MouseEvent e) {
				minimizeButton.setForeground(Color.WHITE); 
			}
		});
		
		minimizeButton.addActionListener(e -> {
			JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(minimizeButton);
			if (frame != null) {
				frame.setState(JFrame.ICONIFIED);
			}
		});
		
		enterButton.addActionListener(e -> {
			// A cor original do texto é 255, 255, 255, 230
			Color originalColor = new Color(255, 255, 255, 230);
			
			enterButton.setForeground(Color.WHITE);

			Timer timer = new Timer(100, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					enterButton.setForeground(originalColor);
					((Timer) e.getSource()).stop();
				}
			});
			timer.setRepeats(false);
			timer.start();

			System.out.println("Botão Entrar clicado!");
		});
		
		enterButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				enterButton.setForeground(new Color(240,240,240)); 
			}

			@Override
			public void mouseExited(MouseEvent e) {
				enterButton.setForeground(new Color(255, 255, 255, 230)); 
			}
		});
	}
}