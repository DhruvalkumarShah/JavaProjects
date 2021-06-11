package XMLProg2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.logging.*;
/** 
 * @author DJS
 * @version 1.0
 * This class is used to create a JFrame application and then making a log sheet about it.
 */
public class BuiltinLogintoXML {
	protected static final Logger logger=Logger.getLogger(BuiltinLogintoXML.class.getName());
	/**
	 * log function is used to make log file in XML format.
	 * @param ex object of exception class
	 * @param level explains the level of severity of the exception
	 * @param msg message given by the programmer
	 */
	public static void log(Exception ex,String level,String msg) {
		FileHandler fh=null;
		try {
			fh=new FileHandler("mylog.xml",true);
			logger.addHandler(fh);
			switch(level) {
			case "severe":
				logger.log(Level.SEVERE,msg,ex);
				if(!msg.equals("")) {
					JOptionPane.showMessageDialog(null,msg,"Error",JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "warning":
				logger.log(Level.WARNING,msg,ex);
				if(!msg.equals("")) {
					JOptionPane.showMessageDialog(null, msg,"Warning",JOptionPane.ERROR_MESSAGE);
				}
				break;
			case "info":
				logger.log(Level.INFO,msg,ex);
				if(!msg.equals("")) {
					JOptionPane.showMessageDialog(null, msg,"Info",JOptionPane.INFORMATION_MESSAGE);
				}
				break;
			case "null":
				logger.log(Level.FINE,msg,ex);
				if(!msg.equals("")) {
					JOptionPane.showMessageDialog(null,msg,"No Exception",JOptionPane.ERROR_MESSAGE);
				}
				break;
				default:
					logger.log(Level.CONFIG, msg,ex);
					break;
			}
		}catch(IOException | SecurityException ex1) {
			logger.log(Level.SEVERE, null, ex1);
		}finally {
			if(fh!=null)fh.close();
		}
	}
	/**
	 * makes frame and panel,adds 4 button and their respective action listeners
	 * each of then giving a call to log function. 
	 * @param args does nothing
	 */
	public static void main(String args[]) {
		/*
		 * Create simple frame for the example.
		 */
		JFrame myFrame=new JFrame();
		myFrame.setTitle("Logging by Dhruval Shah");
		myFrame.setSize(600, 200);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		JPanel pnlMsg=new JPanel();
		/*
		 * Creating a button for no error exception and adding them to the panel.
		 */
		JButton noError=new JButton("--click no error--");
		pnlMsg.add(noError);
		/*
		 * Adding action listener to the no error button.
		 */
		noError.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				log(null,"null","No error");
			}
		});
		/*
		 * Creating a button for severe exception and adding them to the panel.
		 */
		JButton severe=new JButton("-----severe-----");
		pnlMsg.add(severe);
		/*
		 * Adding action listener to the severe button.
		 */
		severe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				/*
				 * Treating ArithmeticException as a severe exception.
				 */
				int intHrs=80;
				int intWeeks=0;
				try {
					System.out.println(intHrs/intWeeks);
				}catch(ArithmeticException ae1) {
					log(ae1,"severe","Divide by zero error. Cannot have "+intWeeks+" weeks.");
				}
			}
		});
		/*
		 * Creating a button for warning exception and adding them to the panel.
		 */
		JButton warning=new JButton("-----warning-----");
		pnlMsg.add(warning);
		/*
		 * Adding action listener to the warning button.
		 */
		warning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				/*
				 * Treating ArrayIndexOutOfBoundsException as a warning exception.
				 */
				try {
					int arr[]= {1,2,3,4};
					System.out.println(arr[10]);
				}catch(ArrayIndexOutOfBoundsException ae1) {
					log(ae1,"warning","Trying to access an element which does not exist.");
				}
			}
		});
		/*
		 * Creating an info button and adding to the panel.
		 */
		JButton info=new JButton("-----info-----");
		pnlMsg.add(info);
		/*
		 * Adding action listener to the button.
		 */
		info.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				/*
				 * We are going to treat a normal exception object as info.
				 */
				log(new Exception(),"info","Dhruval Shah :) ");
			}
		});
		/*
		 * Add the JPanel to the JFrame and set the JFrame visible
		 */
		myFrame.setContentPane(pnlMsg);
		myFrame.setVisible(true);
	}
}
