import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons extends JPanel implements ActionListener {
    private static final long serialVersionUID = 1L;
    boolean myTurn = true;
    JButton reset;
    JButton[] button = new JButton[9];

    public Buttons() {

        for (int i = 0; i < button.length; i++) {
            button[i] = new JButton("");
            button[i].addActionListener(this);
            button[i].setBackground(Color.WHITE);
            add(button[i]);

        }
        reset = new JButton("RESET");
        reset.addActionListener(this);
        add(reset);

        setLayout(new GridLayout(4, 3));
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if(source .equals(reset)){
            for (int i = 0; i < button.length; i++){
                button[i].setText("");
                button[i].setEnabled(true);
                button[i].setBackground(Color.WHITE);
            }
        }

        myTurn = !myTurn;

        String symbol = "X";
        if(myTurn){
            symbol = "O";
        }


        for (int i = 0; i < button.length; i++){

            if(source.equals(button[i])){
                button[i].setText(symbol);
                button[i].setEnabled(false);
                
            }
        }

        checkResult();
    }
public void checkResult(){
    String[] s = new String[3];
    for(int i = 0; i < 3; i++){
        s[i] = button[i].getText();


    }
if(s[0].equals(s[1]) && s[0].equals(s[2]) && s[0].equals("")){
    button[0].setBackground(Color.GREEN);
    button[1].setBackground(Color.GREEN);
    button[2].setBackground(Color.GREEN);


}



}
   
  

    
}