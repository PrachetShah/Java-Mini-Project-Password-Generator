import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
 
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
        
        LcharNum = new JLabel("Enter Number of Lowercase Characters: ");
        LcharInput = new JTextField(10);

        UcharNum = new JLabel("Enter Number of Upercase Characters: ");
        UcharInput = new JTextField(10);

        symNum = new JLabel("Enter Number of Symbol Characters: ");
        symInput = new JTextField(10);

        numNum = new JLabel("Enter Number of Number Characters: ");
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

    public String generateSymbols(int len){
        String symbletters="";
        for(int i=1;i<=len;i++){
            double choice = (Math.random()*(5-1))+1;      // Random numbers between 1 to 4
            int choicenum = (int)choice;
            double d=0;
            switch(choicenum){
                case 1:
                    d = (Math.random()*(47-33))+33;       // ASCII values between 33 to 47
                    break;
                case 2:
                    d = (Math.random()*(64-58))+58;       // ASCII values between 58 to 64
                    break;
                case 3:
                    d = (Math.random()*(95-91))+91;       // ASCII values between 91 to 95
                    break;
                case 4:
                    d = (Math.random()*(126-123))+123;    // ASCII values between 123 to 126
                    break;
                default:
                    break;
            }
            int num = (int)d;
            String s = Character.toString((char)num);
            symbletters += s;
        }
        return symbletters;
    }

    public String shuffle(String input){
        ArrayList<Character> chars = new ArrayList<Character>();

        for(char c:input.toCharArray()){
            chars.add(c);
        }

        StringBuilder output = new StringBuilder(input.length());

        while(chars.size()!=0){
            double rand = (Math.random()*chars.size());
            int ans = (int)rand;
            output.append(chars.remove(ans));
        }
        return output.toString();
    }
 
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSubmit) {
            Lcharacters = Integer.parseInt(LcharInput.getText());
            Ucharacters = Integer.parseInt(UcharInput.getText());
            sym = Integer.parseInt(symInput.getText());
            num = Integer.parseInt(numInput.getText());
            // System.out.println(strUserName);
            // int password = Lcharacters+Ucharacters+sym+num;

            String password = generateLC(Lcharacters)+generateUC(Ucharacters)+generateNum(num)+generateSymbols(sym);
            String shuffledPassword = shuffle(password);
            JLabel PASSWORD = new JLabel("Genereted Password: ");
            
            JTextField pass = new JTextField(shuffledPassword.toString());
            pass.setEditable(false);
            pass.setSize(20, 20);
            pass.setBackground(null);
            pass.setBorder(null);
            Font font = new Font("Verdana", Font.BOLD, 25);
            pass.setFont(font);

            c.add(PASSWORD);
            c.add(pass);
            validate();
            repaint();
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
