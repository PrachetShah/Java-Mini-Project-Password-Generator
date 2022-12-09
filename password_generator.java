import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
 
class Password extends JFrame implements ActionListener {
    Container c;
    JLabel title, LcharNum, UcharNum, symNum, numNum;
    JTextField LcharInput, UcharInput, symInput, numInput;

    JButton btnSubmit;
    Integer Lcharacters,Ucharacters, sym, num;
 
    Password() {
        c = getContentPane();
        c.setLayout(new FlowLayout());
        title = new JLabel("Welcome to Strong Password Generator");
        
        LcharNum = new JLabel("Enter Number of characters in password: ");
        LcharInput = new JTextField(10);

        UcharNum = new JLabel("Enter Number of characters in password: ");
        UcharInput = new JTextField(10);

        symNum = new JLabel("Enter Number of symbols in password: ");
        symInput = new JTextField(10);

        numNum = new JLabel("Enter Number of symbols in password: ");
        numInput = new JTextField(10);

        btnSubmit = new JButton("Submit");
        c.add(title);
        c.add(LcharNum);
        c.add(LcharInput);
        c.add(UcharNum);
        c.add(UcharInput);
        c.add(symNum);
        c.add(symInput);
        c.add(numNum);
        c.add(numInput);

        c.add(btnSubmit);

        btnSubmit.addActionListener(this);
    }

    public String generateLC(int len){
        String LC = "";
        for(int i=0; i<=len; i++){
            double d = (Math.random()*(122-97))+97; //ASCII Values between 97-122
            int num = (int)d;
            String s = Character.toString((char)num);
            LC += s;
        }
        return LC;
    }

    public String generateUC(int len){
        String UC = "";
        for(int i=0; i<=len; i++){
            double d = (Math.random()*(91-65))+65; //ASCII Values between 65-91
            int num = (int)d;
            String s = Character.toString((char)num);
            UC += s;
        }
        return UC;
    }

    public String generateNum(int len){
        String string = "";
        for(int i=0; i<=len; i++){
            double d = (Math.random()*(57-48))+48; //ASCII Values between 65-91
            int num = (int)d;
            String s = Character.toString((char)num);
            string += s;
        }
        return string;
    }
 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSubmit) {
            Lcharacters = Integer.parseInt(LcharInput.getText());
            Ucharacters = Integer.parseInt(UcharInput.getText());
            sym = Integer.parseInt(symInput.getText());
            num = Integer.parseInt(numInput.getText());
            // System.out.println(strUserName);
            String password = "";
            JOptionPane.showMessageDialog(c, Lcharacters);
        } else {
            System.exit(0);
        }
 
    }
 
    public static void main(String z[]) {
        Password frm = new Password();
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setBounds(200, 200, 400, 400);
        frm.setVisible(true);
    }
 
}
