import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class TaskProgressBar extends JFrame{

	static boolean TaskDone = false;
	JProgressBar bar;
	int i=0;
	JFrame frameOne;
	
	public TaskProgressBar() {
		this.setLayout(new FlowLayout());
		this.setSize(400,70);
		this.setResizable(false);
		this.setTitle("Progress Bar Generator!");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b1 = new JButton("Start");
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				b1.setEnabled(false);
				frameOne = new JFrame();
				frameOne.setLayout(new FlowLayout());
				frameOne.setTitle("Progress!!");
				frameOne.setSize(400,70);
				frameOne.setLocationRelativeTo(null);
				bar=new JProgressBar(0,2000);    
				bar.setBounds(40,40,160,30);            
				bar.setStringPainted(true);
				bar.setString("Updating please wait!"); 
				frameOne.setResizable(false);
				frameOne.add(bar);
				frameOne.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				frameOne.setVisible(true);
				Thread t1 = new Thread(new BabisTask());
				t1.start();
				iterate();
				b1.setEnabled(true);
			}
		});
		this.add(b1);		
		this.setVisible(true);
	}	
  
	public static void main(String[] args) {
		new TaskProgressBar();
	}	
  
	public void iterate(){
		while(!TaskDone) {
			System.out.println(TaskDone);
		while(i<=2000){    
		  bar.setValue(i);
		  bar.paintImmediately(0, 0, 200,25);
		  i=i+20; 
		  try{Thread.sleep(150);}catch(Exception e){}    
		}   
		i=0;
		}
		frameOne.dispose();
		TaskDone=false;
		i=0;		
	}	
}
