package com.GQT.JavaBasics.projects;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SwingQuizApplication {
	
	static String questions[] = {"1.Which of the following is not a Java feature? ",
			"2.What is the size of float and double in Java? ",
			"3.When an array is passed to a method, what does the method receive? ",
			"4.Which keyword is used to explicitly call a superclass constructor? ",
			"5.What is the default value of a boolean variable in Java?  ",
			"6.What is the output of System.out.println(5 + 3 * 2);?",
			"7.Which component is used to compile, debug and execute the java programs?",
			"8.Who invented Java Programming?",
			"9.Which of these cannot be used for a variable name in Java?",
			"10.What is the extension of java code files?"
	};
	static String options[][] = {
		    {"A. Object-oriented", "B. Use of pointers", "C. Portable", "D. Dynamic and Extensible"},
		    {"A. 32 and 64", "B. 64 and 32", "C. 32 and 32", "D. 64 and 63"},
		    {"A. The reference of the array", "B.  A copy of the array", "C. Length of the array", "D. Copy of the first element"},
		    {"A. super", "B. this ", "C. extend", "D. parent"},
		    {"A. true", "B. false", "C. null", "D. 0"},
		    {"A. 16", "B. 10", "C. 11", "D. 13"},
		    {"A. JRE","B. JIT","C. JDK","D. JVM"},
		    {"A. Guido van Rossum","B. James Gosling","C. Dennis Ritchie","D.Bjarne Stroustrup"},
		    {"A. identifier & keyword","B. identifier","C. keyword","D. none of the mentioned"},
		    {"A. .js","B. .txt","C. .class","D. .java"}
		    };
static String correct_ans[]= {"B","A","A","A","B","C","C","B","C","D"};
static int safe_zone[]= {400,700,1000};
static int current = 0;
static int reward=0;
JFrame f;
static JLabel q;
static JRadioButton op1;
static JRadioButton op2;
static JRadioButton op3;
static JRadioButton op4;
static ButtonGroup g;
static JButton submit;
static JButton LifeLine;
static JButton quit;

	SwingQuizApplication(){
		f = new JFrame("Quiz Application");
		q = new JLabel();
	    op1 = new JRadioButton();
		op2 = new JRadioButton();
		op3 = new JRadioButton();
		op4 = new JRadioButton();
		submit = new JButton("Submit");
		LifeLine = new JButton("LifeLine");
		quit = new JButton("Quit");
		//submit.setBounds(400, 400, 200, 60);
		g = new ButtonGroup();//you select only one option
		g.add(op1);
		g.add(op2);
		g.add(op3);
		g.add(op4);
		
		loadQues();
		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String user = "";
				if(op1.isSelected()) {
					
					user = "A";
					
				}
				else if(op2.isSelected()) {
					user="B";
					
				}
				else if(op3.isSelected()) {
					user="C";
				}
				else if(op4.isSelected()) {
					user="D";
				}
				
				
				if(user.equals(correct_ans[current])) {
					reward += 100;
                    JOptionPane.showMessageDialog(f, "Correct! Reward = Rs." + reward);
                    current++;
                    loadQues();
                    if(current==9) {
                    	JOptionPane.showMessageDialog(f, "You won the Game");
    					System.exit(0);
    				}
                    
				}
				else {
					JOptionPane.showMessageDialog(f, "Wrong answer. Your game is over.");
					if(current<4) {
						JOptionPane.showMessageDialog(f, "you received 0 reward");
					}
					else if(current>=4 && current <7) {
						JOptionPane.showMessageDialog(f, "you received reward of RS."+safe_zone[0]);
						
					}
					else if(current>=7 && current<=9) {
						JOptionPane.showMessageDialog(f, "you received reward RS."+safe_zone[1]);
					}
					else {
						JOptionPane.showMessageDialog(f, "you received reward RS."+safe_zone[2]);
					}
					System.exit(0);
					
				}
	
			}
			
		});
		
		JRadioButton c1 = new JRadioButton("Phone Call");
		JRadioButton c2 = new JRadioButton("Skip");
		JRadioButton c3 = new JRadioButton("Audiance Poll");
		
		ButtonGroup g1 = new ButtonGroup();
		g1.add(c1);
		g1.add(c2);
		g1.add(c3);

 	JPanel p = new JPanel();
	p.add(c1);
	p.add(c2);
	p.add(c3);
		
		LifeLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice = JOptionPane.showConfirmDialog(f, p,
		                "Choose Lifeline", JOptionPane.OK_CANCEL_OPTION);
				    
				    
				    if(choice == JOptionPane.OK_OPTION) {
				    	if(c1.isSelected()) {
				    	JOptionPane.showMessageDialog(f, "PhoneCall Activated");
				    	JOptionPane.showMessageDialog(f, "Continue to answer");
				    	c1.setEnabled(false);
				    }
				    	else if(c2.isSelected()) {
				    		JOptionPane.showMessageDialog(f, "Skip Activated");
				    		JOptionPane.showMessageDialog(f, "Your current question skipped");
				    		reward+=100;
				    		current++;
				    		loadQues();
				    		c2.setEnabled(false);
				    	}
				    	else {
				    		JOptionPane.showMessageDialog(f, "Audiance Poll Activated");
				    		JOptionPane.showMessageDialog(f, "Continue to answer");
				    		c3.setEnabled(false);
				    	}
				    }
				   
				    g1.clearSelection();
				    if(c1.isEnabled()==false && c2.isEnabled()==false && c3.isEnabled()==false) {
				    	JOptionPane.showMessageDialog(f, "All lifelines used");
				    	LifeLine.setEnabled(false);
				    }
			}	
			});
		
		
		
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f,"Thanks for playing.");
				if(current<4) {
					JOptionPane.showMessageDialog(f, "you received 0 reward");
				}
				else if(current>=4 && current <7) {
					JOptionPane.showMessageDialog(f, "you received reward of RS."+safe_zone[0]);
					
				}
				else if(current>=7 && current<=9) {
					JOptionPane.showMessageDialog(f, "you received reward RS."+safe_zone[1]);
				}
				else {
					JOptionPane.showMessageDialog(f, "you received reward RS."+safe_zone[2]);
				}

				System.exit(0);
			}
		});
		
		f.add(q); f.add(op1); f.add(op2); f.add(op3); f.add(op4);
		f.add(submit); f.add(LifeLine); f.add(quit);
		f.setVisible(true);
		f.setSize(600,600);
		f.setLayout(new GridLayout(8,1));
			
	}
	public static void loadQues() {
		q.setText(questions[current]);
		q.setFont(new Font("TimesNewRoman",Font.BOLD,18));
		op1.setText(options[current][0]);
		//op1.setFont(new Font("TimesNewRoman",Font.BOLD,12));
		op2.setText(options[current][1]);
		op3.setText(options[current][2]);
		op4.setText(options[current][3]);
		
		g.clearSelection();

	}
	public static void main(String[] args) {
		
		new SwingQuizApplication();
	}
}
