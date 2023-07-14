import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Main implements ActionListener 
{
    String height,weight;
    JRadioButton h1,h2;
    TextField t,t1,t2,finaloutput;
    String output;
    Frame f;
    Main()
    {
        f = new Frame();
        Label Height = new Label("Height:");
        Label Weight = new Label("Weight");
        ButtonGroup bg = new ButtonGroup();
        t = new TextField();
        t1 = new TextField();
        t2 = new TextField();
        finaloutput = new TextField();
        h1 = new JRadioButton();
        h2 = new JRadioButton();
        h1.setText("inch");
        h2.setText("feet");
        


        Button b = new Button("Submit");

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing (WindowEvent e){
                f.dispose();
            }
        });


        Height.setBounds(20, 80, 80, 30); 
        Weight.setBounds(20, 120, 80, 30); 
        h1.setBounds(200, 80, 50, 20);
        h2.setBounds(250, 80, 50, 20);
        t.setBounds(100, 80, 80, 30);
        t1.setBounds(100, 120, 80, 30);  
        t2.setBounds(100, 160, 80, 30); 
        finaloutput.setBounds(90, 200, 110, 30); 
        b.setBounds(100, 240, 80, 30);
        
        t2.setEditable(false);
        finaloutput.setEditable(false);
        
        f.add(Height);
        f.add(Weight);    
        f.add(t);  
        f.add(t1); 
        f.add(t2);
        f.add(finaloutput);
        f.add(b);
        f.add(h1);
        f.add(h2);
        bg.add(h1);
        bg.add(h2);



        f.setSize(800, 800);
        f.setTitle("BMI Calculator");
        f.setLayout(null);
        f.setVisible(true);

        b.addActionListener(this);
        
    }

    public void actionPerformed(ActionEvent e) {    
        height = t.getText();    
        weight = t1.getText();    
        double a = Double.parseDouble(height);
        double b = Double.parseDouble(weight);   
        double c =0.0;
        if(h1.isSelected())
        {
            a=a/12;
            c= b/(a*a*0.304*0.304); 
            c=Math.round(c*100.0)/100.0;
            if (c<18.5)
            output ="Under Weight";
            if (c>=18.5 && c <=24.9 )
            output = "Normal Weight";
            if (c>=25 && c<=29.9)
            output = "Over Weight";
            if (c>=30 && c<=34.9)
            output = "Obese";
            if (c>=35)
            output = "Extremely Obese";
        } 
        if(h2.isSelected()) 
        {
            c= b/(a*a*0.304*0.304);  
            c=Math.round(c*100.0)/100.0;
            if (c<18.5)
                output = "Under Weight";
            if (c>=18.5 && c <=24.9 )
                output = "Normal Weight";
            if (c>=25 && c<=29.9)
                output = "Over Weight";
            if (c>=30 && c<=34.9)
                output = "Obese";
            if (c>=35)
                output = "Extremely Obese";
        }
        String result = String.valueOf(c);    
        t2.setText(result);
        finaloutput.setText(output);    
    }   
    public static void main(String [] args)
    {    
        Main m = new Main();
    }
}
