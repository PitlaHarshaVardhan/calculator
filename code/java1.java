import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;
public class java1 implements ActionListener
{
    JFrame f;
    JTextField txt;
    JPanel j;
    JButton zero,one,two,three,four,five,six,seven,eight,nine,add,sub,mul,divi,can,eql;
    String s1,s2,s3;
    java1()
    {
        f=new JFrame("calculator");
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);
        txt =new JTextField();
        txt.setBounds(10,10,300,100);
        f.add(txt);
        j=new JPanel();
        j.setLayout(new GridLayout(4,4));
        j.setBounds(10,120,300,200);
        j.setVisible(true);
        
        zero=new JButton("0");
        zero.setBounds(10,10,200,200);
        zero.addActionListener(this);
        j.add(zero);
        one=new JButton("1");
        one.setBounds(20,10,200,200);
        one.addActionListener(this);
        j.add(one);
        two=new JButton("2");
        two.setBounds(30,10,200,200);
        two.addActionListener(this);
        j.add(two);
        three=new JButton("3");
        three.setBounds(40,10,200,200);
        three.addActionListener(this);
        j.add(three);
        four=new JButton("4");
        four.setBounds(10,20,200,200);
        four.addActionListener(this);
        j.add(four);
        five=new JButton("5");
        five.setBounds(20,20,200,200);
        five.addActionListener(this);
        j.add(five);
        six=new JButton("6");
        six.setBounds(30,20,200,200);
        six.addActionListener(this);
        j.add(six);
        seven=new JButton("7");
        seven.setBounds(40,20,200,200);
        seven.addActionListener(this);
        j.add(seven);
        eight=new JButton("8");
        eight.setBounds(10,30,200,200);
        eight.addActionListener(this);
        j.add(eight);
        nine=new JButton("9");
        nine.setBounds(20,30,200,200);
        nine.addActionListener(this);
        j.add(nine);
        add=new JButton("+");
        add.setBounds(30,30,200,200);
        add.addActionListener(this);
        j.add(add);
        sub=new JButton("-");
        sub.setBounds(40,30,200,200);
        sub.addActionListener(this);
        j.add(sub);
        mul=new JButton("*");
        mul.setBounds(10,40,200,200);
        mul.addActionListener(this);
        j.add(mul);
        divi=new JButton("/");
        divi.setBounds(20,40,200,200);
        divi.addActionListener(this);
        j.add(divi);
        eql=new JButton("=");
        eql.setBounds(30,40,200,200);
        eql.addActionListener(this);
        j.add(eql);
        can=new JButton("c");
        can.setBounds(40,40,200,200);
        can.addActionListener(this);
        j.add(can);
        f.add(j);

    }


    public static String evaluate(String expression) {
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                values.push(num);
                i--; 
            }
            
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                ops.push(ch);
            }
        }
        
        
        while (!ops.isEmpty()) {
            char op = ops.remove(0);
            int a = values.remove(0);
            int b = values.remove(0);
            int result = applyOperation(op, a, b);
            values.add(0, result); 
        }
        
        
        return String.valueOf(values.pop());
    }

    
    public static int applyOperation(char op, int a, int b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': 
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==zero)
        {
            s1=txt.getText();
            s2=s1+"0";
            txt.setText(s2);
        }
        else if(e.getSource()==one)
        {s1=txt.getText();
            s2=s1+"1";
            txt.setText(s2);
        }
        else if(e.getSource()==two)
        {
            s1=txt.getText();
            s2=s1+"2";
            txt.setText(s2);
        }
        else if(e.getSource()==three)
        {
            s1=txt.getText();
            s2=s1+"3";
            txt.setText(s2);
        }
        else if(e.getSource()==four)
        {s1=txt.getText();
            s2=s1+"4";
            txt.setText(s2);
        }
        else if(e.getSource()==five)
        {s1=txt.getText();
            s2=s1+"5";
            txt.setText(s2);
        }
        else if(e.getSource()==six)
        {s1=txt.getText();
            s2=s1+"6";
            txt.setText(s2);
        }
        else if(e.getSource()==seven)
        {s1=txt.getText();
            s2=s1+"7";
            txt.setText(s2);
        }
        else if(e.getSource()==eight)
        {s1=txt.getText();
            s2=s1+"8";
            txt.setText(s2);
        }
        else if(e.getSource()==nine)
        {s1=txt.getText();
            s2=s1+"9";
            txt.setText(s2);
        }
        else if(e.getSource()==add)
        {s1=txt.getText();
            s2=s1+"+";
            txt.setText(s2);
        }
        else if(e.getSource()==sub)
        {s1=txt.getText();
            s2=s1+"-";
            txt.setText(s2);
        }
        else if(e.getSource()==mul)
        {s1=txt.getText();
            s2=s1+"*";
            txt.setText(s2);
        }
        else if(e.getSource()==divi)
        {s1=txt.getText();
            s2=s1+"/";
            txt.setText(s2);
        }
        else if(e.getSource()==eql)
        {
            s1=txt.getText();
            s2=evaluate(s1);
            txt.setText(s2);
        }
        else if(e.getSource()==can)
        {
            s2="";
            txt.setText(s2);
        }
    }
    public static void main(String args[])
    {
        
        java1 t=new java1();
    }
}