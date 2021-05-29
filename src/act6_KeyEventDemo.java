import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent; 

// An AWT GUI program inherits from the top-level container java.awt.Frame 
public class act6_KeyEventDemo extends Frame implements KeyListener { 
	// This class acts as KeyEvent Listener
	
	private TextField tfInput; // Single-line TextField to receive tfInput key 
	private TextArea taDisplay; // Multi-line TextArea to taDisplay result 
	
	// Constructor to setup the GUI components and event handlers 
	public act6_KeyEventDemo() { 
		setLayout(new FlowLayout()); // "super" frame sets to FlowLayout 
		
		add(new Label("Enter Text: ")); 
		tfInput = new TextField(10); 
		add(tfInput); 
		taDisplay = new TextArea(5, 40); // 5 rows, 40 columns 
		add(taDisplay); 
		
		tfInput.addKeyListener(this); 
		// tfInput TextField (source) fires KeyEvent. 
		// tfInput adds "this" object as a KeyEvent listener. 
		setTitle("KeyEvent Demo"); // "super" Frame sets title 
		setSize(400, 200); // "super" Frame sets initial size 
		setVisible(true); // "super" Frame shows 
	
		// To close manually the window
		   addWindowListener(new WindowAdapter(){  
	            public void windowClosing(WindowEvent e) {  
	                dispose();  
	            }  
	        }); 
	} 
		
	// The entry main() method 
	public static void main(String[] args) { 
		new act6_KeyEventDemo(); // Let the constructor do the job 
	} 
	
	/** KeyEvent handlers */ 
	// Called back when a key has been typed (pressed and released) 
	@Override public void keyTyped(KeyEvent evt) { 
		taDisplay.append("You have typed " + evt.getKeyChar() + "\n"); 
	} 
	
	// Not Used, but need to provide an empty body for compilation 
	@Override public void keyPressed(KeyEvent evt) { } 
	@Override public void keyReleased(KeyEvent evt) { } 		
	
}
