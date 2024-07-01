package Book;

import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame {
    public MyFrame() {
        this.addWindowListener(new WindowAdapter() {
           public void windowClosing(WindowEvent e) {
               System.exit(0);
           }
        });

        this.setLayout(new BorderLayout());
        this.setResizable(false);

        MyPanel panel = new MyPanel();
        this.add(panel, BorderLayout.CENTER);

        Panel p1 = new Panel(new FlowLayout());
        this.add(p1, BorderLayout.SOUTH);

        TextField t1 = new TextField(3);
        TextField t2 = new TextField(3);
        TextField t3 = new TextField(3);
        TextField t4 = new TextField(3);

        Label l1 = new Label("y=");
        Label l2 = new Label("x^3 + ");
        Label l3 = new Label("x^2 + ");
        Label l4 = new Label("x +");

        Button b1 = new Button("Set");

        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);
        p1.add(l3);
        p1.add(t3);
        p1.add(l4);
        p1.add(t4);
        p1.add(b1);

        ActionListener setA = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(t1.getText());
                double b = Double.parseDouble(t2.getText());
                double c = Double.parseDouble(t3.getText());
                double d = Double.parseDouble(t4.getText());
                panel.setGraph(new MyGraph(a, b, c, d));
                panel.repaint();
            }
        };
        b1.addActionListener(setA);
    }
}
