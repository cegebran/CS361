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
		myGUI.setResizable(false);
		myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	// end of main
	
	public Driver_GUI(){
		Chronotimer chronotimer = new Chronotimer();
		
		final JButton powerBtn = new JButton("Power");
	    powerBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		final JButton functionBtn = new JButton("Function");
		functionBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		
		final JButton leftArrowBtn = new JButton("L");
		leftArrowBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		final JButton rightArrowBtn = new JButton("R");
		rightArrowBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		final JButton downArrowBtn = new JButton("D");
		downArrowBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		final JButton upArrowBtn = new JButton("U");
		upArrowBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		
		final JButton swapBtn = new JButton("Swap");
		swapBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		
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
		printerPwrBtn.setFont(new Font("Serif", Font.PLAIN, 15));
		
		final JButton numPad0Btn = new JButton("0");
		numPad0Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPad1Btn = new JButton("1");
		numPad1Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPad2Btn = new JButton("2");
		numPad2Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPad3Btn = new JButton("3");
		numPad3Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPad4Btn = new JButton("4");
		numPad4Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPad5Btn = new JButton("5");
		numPad5Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPad6Btn = new JButton("6");
		numPad6Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPad7Btn = new JButton("7");
		numPad7Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPad8Btn = new JButton("8");
		numPad8Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPad9Btn = new JButton("9");
		numPad9Btn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPadAstBtn = new JButton("*");
		numPadAstBtn.setFont(new Font("Serif", Font.PLAIN, 20));
		final JButton numPadPoundBtn = new JButton("#");
		numPadPoundBtn.setFont(new Font("Serif", Font.PLAIN, 20));
		
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
		JLabel chronoLabel = new JLabel("       CHRONOTIMER 1009");
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
		
		
		JPanel printerPanel = new JPanel(new BorderLayout());
		JLabel printerBufferLeftLabel = new JLabel("              ");
		JLabel printerBufferRightLabel = new JLabel("              ");
		printerPanel.add(printerBufferLeftLabel, BorderLayout.LINE_START);
		printerPanel.add(printerBufferRightLabel, BorderLayout.LINE_END);
		JPanel printerPowerPanel = new JPanel(new BorderLayout());
		JLabel printerPowerBufferLabel1 = new JLabel("                          ");
		printerPowerBufferLabel1.setFont(new Font("Serif", Font.PLAIN, 21));
		printerPowerPanel.add(printerPowerBufferLabel1, BorderLayout.PAGE_START);
		JLabel printerPowerBufferLabel2 = new JLabel("                                  ");
		printerPowerPanel.add(printerPowerBufferLabel2, BorderLayout.LINE_START);
		JLabel printerPowerBufferLabel3 = new JLabel("                                  ");
		printerPowerPanel.add(printerPowerBufferLabel3, BorderLayout.LINE_END);
		JLabel printerPowerBufferLabel4 = new JLabel("                                  ");
		printerPowerPanel.add(printerPowerBufferLabel4, BorderLayout.PAGE_END);
		printerPowerPanel.add(printerPwrBtn, BorderLayout.CENTER);
		printerPanel.add(printerPowerPanel, BorderLayout.PAGE_START);
		JPanel printerTapePanel = new JPanel(new GridLayout(5,1));
		printerTapePanel.setBackground(Color.WHITE);
		printerTapePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		printerPanel.add(printerTapePanel, BorderLayout.CENTER);
		
		
		JPanel funcSwapPanel = new JPanel(new BorderLayout());
		JLabel bufferLeftFuncLabel = new JLabel("                ");
		JLabel bufferRightFuncLabel = new JLabel("                ");
		JLabel bufferBottomFuncLabel = new JLabel("   ");
		bufferBottomFuncLabel.setFont(new Font("Serif", Font.PLAIN, 25));
		JLabel bufferTopFuncLabel = new JLabel("   ");
		bufferTopFuncLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		funcSwapPanel.add(bufferLeftFuncLabel, BorderLayout.LINE_START);
		funcSwapPanel.add(bufferRightFuncLabel, BorderLayout.LINE_END);
		funcSwapPanel.add(bufferBottomFuncLabel, BorderLayout.PAGE_END);
		funcSwapPanel.add(bufferTopFuncLabel, BorderLayout.PAGE_START);
		JPanel funcSwapCentPanel = new JPanel(new GridLayout(5,1));
		JPanel funcPanel = new JPanel(new FlowLayout());
		funcPanel.add(functionBtn);
		funcSwapCentPanel.add(funcPanel);
		JPanel arrowFuncPanel = new JPanel(new FlowLayout());
		arrowFuncPanel.add(leftArrowBtn);
		arrowFuncPanel.add(rightArrowBtn);
		arrowFuncPanel.add(downArrowBtn);
		arrowFuncPanel.add(upArrowBtn);
		funcSwapCentPanel.add(arrowFuncPanel);
		JLabel bufferCenterSwapLabel = new JLabel(" ");
		funcSwapCentPanel.add(bufferCenterSwapLabel);
		JPanel swapPanel = new JPanel(new FlowLayout());
		swapPanel.add(swapBtn);
		funcSwapCentPanel.add(swapPanel);
		funcSwapPanel.add(funcSwapCentPanel, BorderLayout.CENTER);
		
		JPanel displayPanel = new JPanel(new BorderLayout());
		JLabel displayPanelBufferLabelLeft = new JLabel("          ");
		JLabel displayPanelBufferLabelRight = new JLabel("        ");
		JLabel displayPanelBufferLabelTop = new JLabel(" ");
		displayPanel.add(displayPanelBufferLabelTop, BorderLayout.PAGE_START);
		displayPanel.add(displayPanelBufferLabelLeft, BorderLayout.LINE_START);
		displayPanel.add(displayPanelBufferLabelRight, BorderLayout.LINE_END);
		JPanel displayTextPanel = new JPanel(new BorderLayout());
		JLabel displayTextPanelBufferBottom = new JLabel("   ");
		displayTextPanel.add(displayTextPanelBufferBottom, BorderLayout.PAGE_END);
		JLabel queueTextLabel = new JLabel("                             Queue / Running / Final Time");
		displayTextPanel.add(queueTextLabel, BorderLayout.CENTER);
		displayPanel.add(displayTextPanel, BorderLayout.PAGE_END);
		JPanel displayCenterPanel = new JPanel(new GridLayout(6,1));
		displayCenterPanel.setBackground(Color.WHITE);
		displayCenterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		displayPanel.add(displayCenterPanel, BorderLayout.CENTER);
		
		JPanel numPadPanel = new JPanel(new BorderLayout());
		JLabel bufferRight = new JLabel("                     ");
		numPadPanel.add(bufferRight, BorderLayout.LINE_END);
		JLabel bufferBottom = new JLabel(" ");
		bufferBottom.setFont(new Font("Serif", Font.PLAIN, 32));
		numPadPanel.add(bufferBottom, BorderLayout.PAGE_END);
		JLabel bufferTop = new JLabel(" ");
		bufferTop.setFont(new Font("Serif", Font.PLAIN, 18));
		numPadPanel.add(bufferTop, BorderLayout.PAGE_START);
		JLabel bufferLeft = new JLabel("                      ");
		numPadPanel.add(bufferLeft, BorderLayout.LINE_START);
		numPadPanel.setVisible(true);
		JPanel numPadCenterPanel = new JPanel(new GridLayout(4,3));
		numPadCenterPanel.add(numPad1Btn);
		numPadCenterPanel.add(numPad2Btn);
		numPadCenterPanel.add(numPad3Btn);
		numPadCenterPanel.add(numPad4Btn);
		numPadCenterPanel.add(numPad5Btn);
		numPadCenterPanel.add(numPad6Btn);
		numPadCenterPanel.add(numPad7Btn);
		numPadCenterPanel.add(numPad8Btn);
		numPadCenterPanel.add(numPad9Btn);
		numPadCenterPanel.add(numPadAstBtn);
		numPadCenterPanel.add(numPad0Btn);
		numPadCenterPanel.add(numPadPoundBtn);
		numPadPanel.add(numPadCenterPanel, BorderLayout.CENTER);
		
		
		
		// need the separate panels to be added in this order to be correct
		getContentPane().add(pwrPanel);
		getContentPane().add(startPanel);
		getContentPane().add(printerPanel);
		getContentPane().add(funcSwapPanel);
		getContentPane().add(displayPanel);
		getContentPane().add(numPadPanel);
		
	}
}
