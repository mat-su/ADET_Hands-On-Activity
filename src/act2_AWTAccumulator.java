import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class act2_AWTAccumulator extends Frame implements ActionListener {
	   private Label lblInput;     // Declare input Label
	   private Label lblOutput;    // Declare output Label
	   private TextField tfInput;  // Declare input TextField
	   private TextField tfOutput; // Declare output TextField
	   private int sum = 0;        // Accumulated sum, init to 0
	 
	   // Constructor to setup the GUI components and event handlers
	   public act2_AWTAccumulator() {
		   
		   // To close manually the window
		   addWindowListener(new WindowAdapter(){  
	            public void windowClosing(WindowEvent e) {  
	                dispose();  
	            }  
	        });  
		   
		   
	      setLayout(new FlowLayout());
	         // "super" Frame (container) sets layout to FlowLayout, which arranges
	         // the components from left-to-right, and flow to next row from top-to-bottom.
	 
	      lblInput = new Label("Enter an Integer: "); // Construct Label
	      add(lblInput);               // "super" Frame container adds Label component
	 
	      tfInput = new TextField(10); // Construct TextField
	      add(tfInput);                // "super" Frame adds TextField
	 
	      tfInput.addActionListener(this);
	         // "tfInput" is the source object that fires an ActionEvent upon entered.
	         // The source add "this" instance as an ActionEvent listener, which provides
	         //  an ActionEvent handler called actionPerformed().
	         // Hitting "enter" on tfInput invokes actionPerformed().
	 
	      lblOutput = new Label("The Accumulated Sum is: ");  // allocate Label
	      add(lblOutput);               // "super" Frame adds Label
	 
	      tfOutput = new TextField(10); // allocate TextField
	      tfOutput.setEditable(false);  // read-only
	      add(tfOutput);                // "super" Frame adds TextField
	 
	      setTitle("AWT Accumulator");  // "super" Frame sets title
	      setSize(350, 120);  // "super" Frame sets initial window size
	      setVisible(true);   // "super" Frame shows
	   }
	 
	   // The entry main() method
	   public static void main(String[] args) {
	      // Invoke the constructor to setup the GUI, by allocating an anonymous instance
	      new act2_AWTAccumulator();
	   }
	 
	   // ActionEvent handler - Called back upon hitting "enter" key on TextField
	   @Override
	   public void actionPerformed(ActionEvent evt) {
	      // Get the String entered into the TextField tfInput, convert to int
	      int numberIn = Integer.parseInt(tfInput.getText());
	      sum += numberIn;      // Accumulate numbers entered into sum
	      tfInput.setText("");  // Clear input TextField
	      tfOutput.setText(sum + ""); // Display sum on the output TextField
	                                  // convert int to String
	   }
}