import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class act3_WindowEventDemo extends Frame implements ActionListener, WindowListener{

	private TextField tfCount;
	private Button btnCount;
	private int count = 0;
	
	public act3_WindowEventDemo() {
		setLayout(new FlowLayout());
		add(new Label("Counter"));
	
		tfCount = new TextField("0",10);
		tfCount.setEditable(false);
		add(tfCount);
		
		btnCount = new Button("Count");
		add(btnCount);
		
		btnCount.addActionListener(this);
		addWindowListener(this);
		
		setTitle("WindowEvent Demo");
		setSize(250,100);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new act3_WindowEventDemo();
	}
	
	/* ActionEvent handler */
	@Override
	public void actionPerformed(ActionEvent evt) { 
		++count; 
		tfCount.setText(count + ""); 
	} 
	
	/* WindowEvent handlers */ 
	// Called back upon clicking close-window button 
	@Override 
	public void windowClosing(WindowEvent evt) { 
		System.exit(0); // Terminate the program 
	} 
	
	// Not Used, BUT need to provide an empty body to compile. 
	@Override public void windowOpened(WindowEvent evt) { }
	
	@Override public void windowClosed(WindowEvent evt) { }
	// For Debugging
	@Override public void windowIconified(WindowEvent evt) { 
		System.out.println("WindowIconified"); 
	}
	@Override public void windowDeiconified(WindowEvent evt) { 
		System.out.println("WindowDeiconified"); 
	}
	@Override public void windowActivated(WindowEvent evt) { 
		System.out.println("WindowActivated"); }
	@Override public void windowDeactivated(WindowEvent evt) { 
		System.out.println("WindowDeactivated"); 
	}
}



