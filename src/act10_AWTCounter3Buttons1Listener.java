import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
// An AWT GUI program inherits the top-level container java.awt.Frame
public class act10_AWTCounter3Buttons1Listener extends Frame {
   private TextField tfCount;
   private Button btnCountUp, btnCountDown, btnReset;
   private int count = 0;
 
   // Constructor to setup the GUI components and event handlers
   public act10_AWTCounter3Buttons1Listener () {
      setLayout(new FlowLayout());
      add(new Label("Counter"));
      tfCount = new TextField("0", 10);
      tfCount.setEditable(false);
      add(tfCount);
 
      // Construct Buttons
      btnCountUp = new Button("Count Up");
      add(btnCountUp);
      btnCountDown = new Button("Count Down");
      add(btnCountDown);
      btnReset = new Button("Reset");
      add(btnReset);
 
      // Allocate an instance of the "named" inner class BtnListener.
      BtnListener listener = new BtnListener();
      // Use the same listener instance for all the 3 Buttons.
      btnCountUp.addActionListener(listener);
      btnCountDown.addActionListener(listener);
      btnReset.addActionListener(listener);
 
      setTitle("AWT Counter");
      setSize(400, 100);
      setVisible(true);
      
      
      // To close manually the window
	   addWindowListener(new WindowAdapter(){  
        public void windowClosing(WindowEvent e) {  
            dispose();  
        }  
    }); 
	   
   }
 
   // The entry main method
   public static void main(String[] args) {
      new act10_AWTCounter3Buttons1Listener();  // Let the constructor do the job
   }
 
   /**
    * BtnListener is a named inner class used as ActionEvent listener for all the Buttons.
    */
   private class BtnListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         // Need to determine which button fired the event.
         // the getActionCommand() returns the Button's label
         String btnLabel = evt.getActionCommand();
         if (btnLabel.equals("Count Up")) {
            ++count;
         } else if (btnLabel.equals("Count Down")) {
            --count;
         } else {
            count = 0;
         }
         tfCount.setText(count + "");
      }
   }
}
