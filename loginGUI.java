import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class loginGUI extends JFrame {
    public JTextField userNameTextField;
    public JLabel userNameLabel;
    public JTextField passwordTextField;
    public JLabel passwordLabel;
    public JButton loginButton;
    public JPanel  mainPanel,firstPanel, secondPanel,thirdPanel;

    private String username;
    private String password;
    public loginGUI(){
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,1));

        firstPanel = new JPanel();
        userNameLabel = new JLabel("Username");
        userNameTextField = new JTextField(15);
        firstPanel.add(userNameLabel);
        firstPanel.add(userNameTextField);

        secondPanel = new JPanel();
        passwordLabel = new JLabel("Password");
        passwordTextField = new JTextField(15);
        secondPanel.add(passwordLabel);
        secondPanel.add(passwordTextField);

        thirdPanel = new JPanel();
        loginButton = new JButton("LOGIN");
        loginButton.addActionListener(new loginListener());
        thirdPanel.add(loginButton);

        mainPanel.add(firstPanel);
        mainPanel.add(secondPanel);
        mainPanel.add(thirdPanel);

        Container cp = getContentPane();
        cp.add(mainPanel);
        pack();
        setVisible(true);

    }
    public class loginListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if (userNameTextField.getText().equals("JP") && passwordTextField.getText().equals("123456")){
                userNameTextField.setText("");
                passwordTextField.setText("");
                new mainMenuGUI();
            }else {
                userNameTextField.setText("");
                passwordTextField.setText("");
                JOptionPane.showMessageDialog(null, "Wrong username or password, please try again");
            }
        }
    }
}
