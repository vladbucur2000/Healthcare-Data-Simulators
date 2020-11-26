import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    public static void main(String args[]) {

        JFrame frame = new JFrame("Healthcare Data Simulators");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //size of the GUI
        frame.setSize(500, 500);

        //buttons
        JButton button1 = new JButton("Press to generate random numbers");
        frame.getContentPane().add(button1);
        frame.setVisible(true);


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // this makes sure the button you are pressing is the button variable
                if(e.getSource() == button1) {
                    //if pressed execute code:
                    Compute x = new Compute();
                    System.out.println(x.randomInt());

                }
            }
        });



    }
}
