package applet;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class test extends Applet implements ActionListener,ItemListener

{
    int a;

    Label iaLbl = new Label("Items Available:");
    Checkbox friesBox = new Checkbox("Fries",false);
    Checkbox spagBox = new Checkbox("Spaghetti",false);
    Checkbox burgerBox = new Checkbox("Burger",false);
    Checkbox drinksBox = new Checkbox("Drinks",false);

    Label qtyLbl = new Label("Quantity");
    TextField qty1Txt = new TextField(10);
    TextField qty2Txt = new TextField(10);
    TextField qty3Txt = new TextField(10);
    TextField qty4Txt = new TextField(10);

    Label sizeLbl = new Label("Size");
    Choice fchoice = new Choice();
    Choice schoice = new Choice();
    Choice bchoice = new Choice();
    Choice dchoice = new Choice();

    Label tpLbl = new Label("Total Price:");
    TextField tp1Txt = new TextField(10);
    TextField tp2Txt = new TextField(10);
    TextField tp3Txt = new TextField(10);
    TextField tp4Txt = new TextField(10);

    Label tocLbl = new Label("Type of Customer:");
    CheckboxGroup optGroup = new CheckboxGroup();
    Checkbox member = new Checkbox("Member(10% Discount)",false,optGroup);
    Checkbox student = new Checkbox("Student(5% Discount)",false,optGroup);
    Checkbox senior = new Checkbox("Senior Citizen(20% Discount)",false,optGroup);
    Checkbox others = new Checkbox("Others",false,optGroup);

    Label tiLbl = new Label("Total Items:");
    TextField tiTxt = new TextField(10);

    Label taLbl = new Label("Total Amount:");
    TextField taTxt = new TextField(10);

    Label disLbl = new Label("Discount:");
    TextField disTxt = new TextField(10);

    Label atpLbl = new Label("Amount to Pay:");
    TextField atpTxt = new TextField(10);

    Label arLbl = new Label("Amount Received:");
    TextField arTxt = new TextField(10);

    Label changeLbl = new Label("Change:");
    TextField changeTxt = new TextField(10);

    Button compButton = new Button("COMPUTE");

    Button resetButton = new Button("RESET");

    Button payButton = new Button("PAY");

    int ti,ta,qty1,qty2,qty3,qty4,tp1=0,tp2=0,tp3=0,tp4=0,s1=40,f1=0,f2=0,b1=0,b2=0,d1=0,d2=0,d3=0;

    double dis=0,atp=0,change=0,ar=0;

    public void init()

    {
        setLayout(new GridLayout(8,7));

        add(iaLbl);
        add(friesBox);
        friesBox.addItemListener(this);
        add(spagBox);
        spagBox.addItemListener(this);
        add(burgerBox);
        burgerBox.addItemListener(this);
        add(drinksBox);
        drinksBox.addItemListener(this);

        add(qtyLbl);
        add(qty1Txt);
        add(qty2Txt);
        add(qty3Txt);
        add(qty4Txt);

        add(sizeLbl);
        add(fchoice);
        fchoice.addItem("Regular P 30");
        fchoice.addItem("Large P 40");

        add(schoice);
        schoice.addItem("P 40");

        add(bchoice);
        bchoice.addItem("Regular P 30");
        bchoice.addItem("With Cheese P 35");

        add(dchoice);
        dchoice.addItem("Regular P 15");
        dchoice.addItem("Medium P 20");
        dchoice.addItem("Large P 25");

        add(tpLbl);
        add(tp1Txt);
        add(tp2Txt);
        add(tp3Txt);
        add(tp4Txt);

        add(tocLbl);
        add(member);
        member.addItemListener(this);
        add(student);
        student.addItemListener(this);
        add(senior);
        senior.addItemListener(this);
        add(others);
        others.addItemListener(this);

        add(tiLbl);
        add(tiTxt);

        add(taLbl);
        add(taTxt);

        add(disLbl);
        add(disTxt);

        add(atpLbl);
        add(atpTxt);

        add(arLbl);
        add(arTxt);

        add(changeLbl);
        add(changeTxt);

        add(compButton);
        compButton.addActionListener(this);
        add(resetButton);
        resetButton.addActionListener(this);
        add(payButton);
        payButton.addActionListener(this);

    }

    public void itemStateChanged(ItemEvent e)

    {

        if(member.getState())
            a=1;

        else if(student.getState())
            a=2;

        else if(senior.getState())
            a=3;

        else if(others.getState())
            a=4;
    }



    public void actionPerformed(ActionEvent e)

    {
        String arg;



        arg=e.getActionCommand();

        if(e.getSource()==compButton)
        {


            if(friesBox.getState())
            {
                qty1=Integer.parseInt(qty1Txt.getText());
                f1=30;
                tp1=qty1*f1;
                tp1Txt.setText("" +tp1);
            }

            else
            {
                qty1=Integer.parseInt(qty1Txt.getText());
                f2=40;
                tp1=qty1*f2;
                tp1Txt.setText("" +tp1);
            }

            if(spagBox.getState())
            {
                qty2=Integer.parseInt(qty2Txt.getText());
                tp2=qty2*s1;
                tp2Txt.setText("" +tp2);
            }

            else
            {
                qty2=Integer.parseInt(qty2Txt.getText());
                s1=0;
                tp2=qty2*s1;
                tp2Txt.setText("" +tp2);
            }

            if(burgerBox.getState())
            {
                qty3=Integer.parseInt(qty3Txt.getText());
                b1=30;
                tp3=qty3*b1;
                tp3Txt.setText("" +tp3);
            }

            else
            {
                qty3=Integer.parseInt(qty3Txt.getText());
                b2=35;
                tp3=qty3*b2;
                tp3Txt.setText("" +tp1);
            }

            if(drinksBox.getState())
            {
                qty4=Integer.parseInt(qty4Txt.getText());
                d1=15;
                tp4=qty3*d1;
                tp4Txt.setText("" +tp4);
            }

            else if(drinksBox.getState())
            {
                qty4=Integer.parseInt(qty4Txt.getText());
                d2=20;
                tp4=qty4*d2;
                tp4Txt.setText("" +tp4);
            }

            else if(drinksBox.getState())
            {
                qty4=Integer.parseInt(qty4Txt.getText());
                d3=25;
                tp4=qty4*d3;
                tp4Txt.setText("" +tp4);
            }


            if(a==1)
            {
                ti=(qty1) + (qty2) + (qty3) + (qty4);
                tiTxt.setText(""+ti);


                ta=(tp1) + (tp2) + (tp3) + (tp4);
                taTxt.setText(""+ta);

                dis=ta * 0.1;
                disTxt.setText(""+dis);

                atp=ta;
                atpTxt.setText(""+atp);
            }


            else if(a==2)
            {
                ti=(qty1) + (qty2) + (qty3) + (qty4);
                tiTxt.setText(""+ti);


                ta=(tp1) + (tp2) + (tp3) + (tp4);
                taTxt.setText(""+ta);

                dis=ta * 0.05;
                disTxt.setText(""+dis);

                atp=ta;
                atpTxt.setText(""+atp);
            }

            else if(a==3)
            {
                ti=(qty1) + (qty2) + (qty3) + (qty4);
                tiTxt.setText(""+ti);


                ta=(tp1) + (tp2) + (tp3) + (tp4);
                taTxt.setText(""+ta);

                dis=ta * 0.2;
                disTxt.setText(""+dis);

                atp=ta;
                atpTxt.setText(""+atp);
            }

            else if(a==4)
            {
                ti=(qty1) + (qty2) + (qty3) + (qty4);
                tiTxt.setText(""+ti);


                ta=(tp1) + (tp2) + (tp3) + (tp4);
                taTxt.setText(""+ta);

                disTxt.setText("" +dis);

                atp=ta;
                atpTxt.setText(""+atp);
            }
            repaint();
        }

        else if(e.getSource()==resetButton)
        {
            friesBox.setState(false);
            spagBox.setState(false);
            burgerBox.setState(false);
            drinksBox.setState(false);
            qty1Txt.setText("");
            qty2Txt.setText("");
            qty3Txt.setText("");
            qty4Txt.setText("");
            fchoice.select(0);
            bchoice.select(0);
            dchoice.select(0);
            tp1Txt.setText("");
            tp2Txt.setText("");
            tp3Txt.setText("");
            tp4Txt.setText("");
            member.setState(false);
            student.setState(false);
            senior.setState(false);
            others.setState(false);
            tiTxt.setText("");
            taTxt.setText("");
            disTxt.setText("");
            atpTxt.setText("");
            arTxt.setText("");
            changeTxt.setText("");
            a=1;
            ti=0;
            ta=0;
            dis=0;
            qty1=0;
            qty2=0;
            qty3=0;
            qty4=0;
            tp1=0;
            tp2=0;
            tp3=0;
            tp4=0;
            repaint();
        }

        else if(e.getSource()==payButton)
        {
            ar=Integer.parseInt(arTxt.getText());
            change=ar-atp;
            changeTxt.setText("" +change);
        }
        repaint();
    }
}
