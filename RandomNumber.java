import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class RandomNumber implements ActionListener 
{
    TextField t;
    Label l1,l2,l3;
    Button b1,b2;
    Frame f;
    int r1,i=0;
    public void rand()
    {
        Random r=new Random();
        r1=r.nextInt(100);
    }
    RandomNumber()
    {
        f=new Frame("Random Number Guess. ");
        f.setBackground(Color.BLACK);
        l1=new Label("Guess the Number between 1 and 100: ");
        l1.setBounds(60,40,250,20);
        l1.setForeground(Color.white);

        t=new TextField();
        t.setBounds(100,70,150,20);
        

        b1=new Button("Submit");
        b1.setBounds(80,100,70,20);
        b1.setBackground(Color.yellow);
        b1.addActionListener(this);
        b2=new Button("New Number");
        b2.setBounds(180,100,100,20);
        b2.setBackground(Color.yellow);
        b2.addActionListener(new ActionListener()
        {
            public void actionPerformed (ActionEvent e)
            {
                rand();
            }
        });

        l2=new Label();
        l2.setBounds(100,170,180,20);
        l3=new Label("Guess(High, Low, Correct).");
        l3.setBounds(100,130,160,20);
        l3.setForeground(Color.WHITE);

        f.add(l1);f.add(l2);f.add(l3);
        f.add(t);
        f.add(b1);f.add(b2);
        f.setLayout(null);
        f.setSize(400,400);
        f.setVisible(true);
    }
    public void actionPerformed (ActionEvent e)
    {
        int n;
            if(e.getSource()==b1)
            {
                n= Integer.parseInt(t.getText());
                if(n==r1)
                {
                    l2.setText("You guessed the correct number :"+r1);
                    l2.setForeground(Color.GREEN);
                    l2.setBackground(Color.BLACK);
                }
                else if(n<r1)
                {
                    l2.setText("You guessed too low.");
                    l2.setForeground(Color.PINK);
                    l2.setBackground(Color.BLACK);
                }
                else if(n>r1)
                {
                    l2.setText("You guessed too high.");
                    l2.setForeground(Color.RED);
                    l2.setBackground(Color.BLACK);
                }
                if(i==10)
                {
                    l2.setText("Out of turns the number is: "+r1);
                    l2.setForeground(Color.RED);
                    l2.setBackground(Color.BLACK);
                    i=0;
                }
                i++;
        }
            
        
            
    }
    public static void main(String[] args) 
    {
        RandomNumber r=new RandomNumber();
    }
}