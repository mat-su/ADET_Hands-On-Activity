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
public class act9_AWTCounter3Buttons extends Frame {
   private TextField tfCount;
   private Button btnCountUp, btnCountDown, btnReset;
   private int count = 0;
 
   // Constructor to setup the GUI components and event handlers
   public act9_AWTCounter3Buttons () {
      setLayout(new FlowLayout());
      add(new Label("Counter"));   // an anonymous instance of Label
      tfCount = new TextField("0", 10);
      tfCount.setEditable(false);  // read-only
      add(tfCount);                // "super" Frame adds tfCount
 
      btnCountUp = new Button("Count Up");
      add(btnCountUp);
      // Construct an anonymous instance of an anonymous inner class.
      // The source Button adds the anonymous instance as ActionEvent listener
      btnCountUp.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            ++count;
            tfCount.setText(count + "");
         }
      });
 
      btnCountDown = new Button("Count Down");
      add(btnCountDown);
      btnCountDown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            count--;
            tfCount.setText(count + "");
         }
      });
 
      btnReset = new Button("Reset");
      add(btnReset);
      btnReset.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            count = 0;
            tfCount.setText("0");
         }
      });
 
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
      new act9_AWTCounter3Buttons();  // Let the constructor do the job
   }
}
