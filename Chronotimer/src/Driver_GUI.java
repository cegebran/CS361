// imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Driver_GUI extends JFrame{
	
	public static void main(String[] args){
		Driver_GUI myGUI = new Driver_GUI();
		myGUI.setVisible(true);
		myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	// end of main
	
	public Driver_GUI(){
		Chronotimer chronotimer = new Chronotimer();
		
		final JButton powerBtn = new JButton("Power");
		final JButton functionBtn = new JButton("Function");
		
		final JButton leftArrowBtn = new JButton("");
		final JButton rightArrowBtn = new JButton("");
		final JButton downArrowBtn = new JButton("");
		final JButton upArrowBtn = new JButton("");
		
		final JButton start1Btn = new JButton(" ");
		final JButton finish2Btn = new JButton(" ");
		final JButton start3Btn = new JButton(" ");
		final JButton finish4Btn = new JButton(" ");
		final JButton start5Btn = new JButton(" ");
		final JButton finish6Btn = new JButton(" ");
		final JButton start7Btn = new JButton(" ");
		final JButton finish8Btn = new JButton(" ");
		
		final JButton enaDis1Btn = new JButton(" ");
		final JButton enaDis2Btn = new JButton(" ");
		final JButton enaDis3Btn = new JButton(" ");
		final JButton enaDis4Btn = new JButton(" ");
		final JButton enaDis5Btn = new JButton(" ");
		final JButton enaDis6Btn = new JButton(" ");
		final JButton enaDis7Btn = new JButton(" ");
		final JButton enaDis8Btn = new JButton(" ");
		
		final JButton printerPwrBtn = new JButton("Printer Pwr");
		
		final JButton numPad0Btn = new JButton("0");
		final JButton numPad1Btn = new JButton("1");
		final JButton numPad2Btn = new JButton("2");
		final JButton numPad3Btn = new JButton("3");
		final JButton numPad4Btn = new JButton("4");
		final JButton numPad5Btn = new JButton("5");
		final JButton numPad6Btn = new JButton("6");
		final JButton numPad7Btn = new JButton("7");
		final JButton numPad8Btn = new JButton("8");
		final JButton numPad9Btn = new JButton("9");
		final JButton numPadAstBtn = new JButton("*");
		final JButton numPadPoundBtn = new JButton("#");
		
		setTitle("ChronoTimer 1009");
		setSize(950, 550);
		
		setLayout(new GridLayout(2, 3));
		
		JPanel pwrPanel = new JPanel();
		pwrPanel.setLayout(new BorderLayout());
		JPanel pwrPanelCenter = new JPanel(new FlowLayout());
		JLabel bufferLabel = new JLabel("  ");
		pwrPanel.add(bufferLabel, BorderLayout.PAGE_START);
		pwrPanel.add(pwrPanelCenter, BorderLayout.CENTER);
		pwrPanelCenter.add(powerBtn);

		
		JPanel startPanel = new JPanel(new GridLayout(7,1));
		JLabel chronoLabel = new JLabel("          CHRONOTIMER 1009");
		chronoLabel.setFont(new Font("Serif", Font.BOLD, 23));
		startPanel.add(chronoLabel);
		JLabel label1357 = new JLabel("                                      1        3       5       7");
		label1357.setFont(new Font("Serif", Font.PLAIN, 17));
		startPanel.add(label1357);
		JPanel startButtonOddPanel = new JPanel(new FlowLayout());
		JLabel startLabelodd = new JLabel("                  Start");
		startLabelodd.setFont(new Font("Serif", Font.PLAIN, 17));
		startButtonOddPanel.add(startLabelodd);
		startButtonOddPanel.add(start1Btn);
		startButtonOddPanel.add(start3Btn);
		startButtonOddPanel.add(start5Btn);
		startButtonOddPanel.add(start7Btn);
		startPanel.add(startButtonOddPanel);
		JPanel enaDisOddPanel = new JPanel(new FlowLayout());
		JLabel enaDisLabelodd = new JLabel("Enable/Disable");
		enaDisLabelodd.setFont(new Font("Serif", Font.PLAIN, 17));
		enaDisOddPanel.add(enaDisLabelodd);
		enaDisOddPanel.add(enaDis1Btn);
		enaDisOddPanel.add(enaDis3Btn);
		enaDisOddPanel.add(enaDis5Btn);
		enaDisOddPanel.add(enaDis7Btn);
		startPanel.add(enaDisOddPanel);
		JLabel label2468 = new JLabel("                                    2        4        6        8");
		label2468.setFont(new Font("Serif", Font.PLAIN, 17)); 
		startPanel.add(label2468);
		JPanel finishButtonEvenPanel = new JPanel(new FlowLayout());
		JLabel finishLabelEven = new JLabel("               Finish");
		finishLabelEven.setFont(new Font("Serif", Font.PLAIN, 17));
		finishButtonEvenPanel.add(finishLabelEven);
		finishButtonEvenPanel.add(finish2Btn);
		finishButtonEvenPanel.add(finish4Btn);
		finishButtonEvenPanel.add(finish6Btn);
		finishButtonEvenPanel.add(finish8Btn);
		startPanel.add(finishButtonEvenPanel);
		JPanel enaDisEvenPanel = new JPanel(new FlowLayout());
		JLabel enaDisLabelEven = new JLabel("Enable/Disable");
		enaDisLabelEven.setFont(new Font("Serif", Font.PLAIN, 17));
		enaDisEvenPanel.add(enaDisLabelEven);
		enaDisEvenPanel.add(enaDis2Btn);
		enaDisEvenPanel.add(enaDis4Btn);
		enaDisEvenPanel.add(enaDis6Btn);
		enaDisEvenPanel.add(enaDis8Btn);
		startPanel.add(enaDisEvenPanel);
		
		
		JPanel printerPanel = new JPanel();
		printerPanel.setVisible(true);
		
		JPanel funcSwapPanel = new JPanel();
		funcSwapPanel.setVisible(true);
		
		JPanel displayPanel = new JPanel();
		displayPanel.setVisible(true);
		
		JPanel numPadPanel = new JPanel();
		numPadPanel.setVisible(true);
		
		// need the separate panels to be added in this order to be correct
		getContentPane().add(pwrPanel);
		getContentPane().add(startPanel);
		getContentPane().add(printerPanel);
		getContentPane().add(funcSwapPanel);
		getContentPane().add(displayPanel);
		getContentPane().add(numPadPanel);
		
	}
}
