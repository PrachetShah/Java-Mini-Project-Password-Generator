import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
class Password extends JFrame implements ActionListener {
    Container c;
    JLabel lblUserName, lblPassword;
    JTextField txtUserName;
    JPasswordField txtPassword;
    JButton btnSubmit, btnClear, btnExit;
    String strUserName, strPassword;
 
    Password() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        lblUserName = new JLabel("Welcome to Strong Password Generator");
        lblUserName = new JLabel("Enter Number of characters in password: ");
        txtUserName = new JTextField(10);

        btnSubmit = new JButton("Submit");
        c.add(lblUserName);
        c.add(txtUserName);

        c.add(btnSubmit);

        btnSubmit.addActionListener(this);
    }
 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSubmit) {
            strUserName = txtUserName.getText();
            strPassword = txtPassword.getPassword().toString();
            if (strUserName.equals("prachet") && strPassword.equals("123")) {
                JOptionPane.showMessageDialog(c, "Successful Login");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(c, "Unsuccessful Login");
                txtUserName.setText("");
                txtPassword.setText("");
                txtUserName.requestFocus();
            }
        } else if (ae.getSource() == btnClear) {
            txtUserName.setText("");
            txtPassword.setText("");
            txtUserName.requestFocus();
        } else {
            System.exit(0);
        }
 
    }
 
    public static void main(String z[]) {
        Password frm = new Password();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setBounds(200, 200, 250, 150);
        frm.setVisible(true);
    }
 
}
