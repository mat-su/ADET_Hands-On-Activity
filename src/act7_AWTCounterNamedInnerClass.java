
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
// An AWT GUI program inherits from the top-level container java.awt.Frame
public class act7_AWTCounterNamedInnerClass extends Frame {
   // This class is NOT a ActionListener, hence, it does not implement ActionListener interface
 
   // The event-handler actionPerformed() needs to access these "private" variables
   private TextField tfCount;
   private Button btnCount;
   private int count = 0;
 
   // Constructor to setup the GUI components and event handlers
   public act7_AWTCounterNamedInnerClass () {
      setLayout(new FlowLayout());  // "super" Frame sets to FlowLayout
      add(new Label("Counter"));    // An anonymous instance of Label
      tfCount = new TextField("0", 10);
      tfCount.setEditable(false);   // read-only
      add(tfCount);                 // "super" Frame adds tfCount
 
      btnCount = new Button("Count");
      add(btnCount);                // "super" Frame adds btnCount
 
      // Construct an anonymous instance of BtnCountListener (a named inner class).
      // btnCount adds this instance as a ActionListener.
      btnCount.addActionListener(new BtnCountListener());
 
      setTitle("AWT Counter");
      setSize(250, 100);
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
      new act7_AWTCounterNamedInnerClass(); // Let the constructor do the job
   }
 
   /**
    * BtnCountListener is a "named inner class" used as ActionListener.
    * This inner class can access private variables of the outer class.
    */
   private class BtnCountListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         ++count;
         tfCount.setText(count + "");
      }
   }
}

