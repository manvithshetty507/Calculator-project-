import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberbutton = new JButton[10];
    JButton[] funbutton = new JButton[9];
    JButton addbutton,subbutton,mulbutton,divbutton,decbutton,delbutton,equbutton,clrbutton,negbutton;
    JPanel panel;

    Font myfont = new Font("Ink Free",Font.BOLD,30);

    double num1 = 0,num2 = 0, res = 0;
    char operator;
    Main(){

        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myfont);
        textfield.setEditable(false);

        addbutton = new JButton("+");
        subbutton = new JButton("-");
        mulbutton = new JButton("*");
        divbutton = new JButton("/");
        delbutton = new JButton("Delete");
        clrbutton = new JButton("Clear");
        decbutton = new JButton(".");
        equbutton = new JButton("=");
        negbutton = new JButton("neg");

        funbutton[0] = addbutton;
        funbutton[1] = subbutton;
        funbutton[2] = mulbutton;
        funbutton[3] = divbutton;
        funbutton[4] = decbutton;
        funbutton[5] = equbutton;
        funbutton[6] = delbutton;
        funbutton[7] = clrbutton;
        funbutton[8] = negbutton;


        for(int i=0;i<9;i++){
            funbutton[i].addActionListener(this);
            funbutton[i].setFont(myfont);
            funbutton[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberbutton[i] = new JButton(String.valueOf(i));
            numberbutton[i].addActionListener(this);
            numberbutton[i].setFont(myfont);
            numberbutton[i].setFocusable(false);
        }

        negbutton.setBounds(50,430,100,50);
        delbutton.setBounds(150,430,100,50);
        clrbutton.setBounds(250,430,100,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));

        panel.add(numberbutton[1]);
        panel.add(numberbutton[2]);
        panel.add(numberbutton[3]);
        panel.add(addbutton);
        panel.add(numberbutton[4]);
        panel.add(numberbutton[5]);
        panel.add(numberbutton[6]);
        panel.add(subbutton);
        panel.add(numberbutton[7]);
        panel.add(numberbutton[8]);
        panel.add(numberbutton[9]);
        panel.add(mulbutton);
        panel.add(decbutton);
        panel.add(numberbutton[0]);
        panel.add(equbutton);
        panel.add(divbutton);

        frame.add(panel);
        frame.add(negbutton);
        frame.add(delbutton);
        frame.add(clrbutton);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {

        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i=0;i<10;i++){
            if(e.getSource() == numberbutton[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decbutton){
            textfield.setText(textfield.getText().concat("."));
        }

        if(e.getSource() == addbutton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if(e.getSource() == subbutton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if(e.getSource() == mulbutton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if(e.getSource() == divbutton){
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }

        if(e.getSource() == equbutton){
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+' -> res = num1 + num2;
                case '-' -> res = num1 - num2;
                case '*' -> res = num1 * num2;
                case '/' -> res = num1 / num2;
            }
            textfield.setText(String.valueOf(res));
        }

        if(e.getSource() == clrbutton){
            textfield.setText("");
        }
        if(e.getSource() == delbutton){
            String s = textfield.getText();
            textfield.setText("");

            for(int i=0;i<s.length()-1;i++){
                textfield.setText(textfield.getText() + s.charAt(i));
            }
        }

        if(e.getSource() == negbutton){
            double temp = Double.parseDouble(textfield.getText());
            temp = temp*-1;
            textfield.setText(String.valueOf(temp));
        }

    }
}
