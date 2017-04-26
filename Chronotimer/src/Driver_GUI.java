// imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Driver_GUI extends JFrame{
	
	public static void main(String[] args){
		Driver_GUI myGUI = new Driver_GUI();
		myGUI.setLocationRelativeTo(null);
		myGUI.setVisible(true);
		myGUI.setResizable(false);
		myGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}	// end of main
	
	final JLabel displayLine1Label = new JLabel(" ");
	final JLabel displayLine2Label = new JLabel(" ");
	final JLabel displayLine3Label = new JLabel(" ");
	final JLabel displayLine4Label = new JLabel(" ");
	final JLabel displayLine5Label = new JLabel(" ");
	final JLabel displayLine6Label = new JLabel(" ");
	final JLabel displayLine7Label = new JLabel(" ");
	final JLabel displayLine8Label = new JLabel(" ");
	
	final JLabel printerLine1Label = new JLabel(" ");
	final JLabel printerLine2Label = new JLabel(" ");
	final JLabel printerLine3Label = new JLabel(" ");
	final JLabel printerLine4Label = new JLabel(" ");
	final JLabel printerLine5Label = new JLabel(" ");
	final JLabel printerLine6Label = new JLabel(" ");
	final JLabel printerLine7Label = new JLabel(" ");
	final JLabel printerLine8Label = new JLabel(" ");
	final JLabel printerLine9Label = new JLabel(" ");
	final JLabel printerLine10Label = new JLabel(" ");
	
	public void printerAddLine(String lineToPrint){
		lineToPrint = lineToPrint.toUpperCase();
		System.out.println(lineToPrint);
		String[] lineArray = new String[10];
		lineArray[0] = printerLine1Label.getText();
		lineArray[1] = printerLine2Label.getText();
		lineArray[2] = printerLine3Label.getText();
		lineArray[3] = printerLine4Label.getText();
		lineArray[4] = printerLine5Label.getText();
		lineArray[5] = printerLine6Label.getText();
		lineArray[6] = printerLine7Label.getText();
		lineArray[7] = printerLine8Label.getText();
		lineArray[8] = printerLine9Label.getText();
		lineArray[9] = printerLine10Label.getText();
		
		for(int j = 1; j < 10; j++){
			lineArray[j-1] = lineArray[j];
		}
		
		lineArray[9] = lineToPrint;
		
		printerLine1Label.setText(lineArray[0]);
		printerLine2Label.setText(lineArray[1]);
		printerLine3Label.setText(lineArray[2]);
		printerLine4Label.setText(lineArray[3]);
		printerLine5Label.setText(lineArray[4]);
		printerLine6Label.setText(lineArray[5]);
		printerLine7Label.setText(lineArray[6]);
		printerLine8Label.setText(lineArray[7]);
		printerLine9Label.setText(lineArray[8]);
		printerLine10Label.setText(lineArray[9]);
	}
	boolean displayFunction = false;
	int functionNum = 0;
	int selectedFunction = 0;
	String currentNumPad = "";
	boolean enterNum = false;
	boolean finishedEnteringNum = false;
	boolean functionIsSelected = false;
	boolean displayHours = false;
	boolean displayMinutes = false;
	boolean displaySeconds = false;
	String enteredTime = "";
	int selectedEvent = 0;
	
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
		
		final JButton channel1Button = new JButton(" ");
		channel1Button.setBackground(Color.RED);
		final JButton channel2Button = new JButton(" ");
		channel2Button.setBackground(Color.RED);
		final JButton channel3Button = new JButton(" ");
		channel3Button.setBackground(Color.RED);
		final JButton channel4Button = new JButton(" ");
		channel4Button.setBackground(Color.RED);
		final JButton channel5Button = new JButton(" ");
		channel5Button.setBackground(Color.RED);
		final JButton channel6Button = new JButton(" ");
		channel6Button.setBackground(Color.RED);
		final JButton channel7Button = new JButton(" ");
		channel7Button.setBackground(Color.RED);
		final JButton channel8Button = new JButton(" ");
		channel8Button.setBackground(Color.RED);
		
		final JPopupMenu channelInputMenu = new JPopupMenu("Menu");
		channelInputMenu.add("Eye");
		channelInputMenu.add("Gate");
		channelInputMenu.add("Pad");
		
		setTitle("ChronoTimer 1009");
		setSize(950, 750);
		
		setLayout(new GridLayout(3, 3));
		
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
		JLabel printerBufferLeftLabel = new JLabel("      ");
		JLabel printerBufferRightLabel = new JLabel("      ");
		printerPanel.add(printerBufferLeftLabel, BorderLayout.LINE_START);
		printerPanel.add(printerBufferRightLabel, BorderLayout.LINE_END);
		JPanel printerPowerPanel = new JPanel(new BorderLayout());
		JLabel printerPowerBufferLabel1 = new JLabel("                          ");
		printerPowerBufferLabel1.setFont(new Font("Serif", Font.PLAIN, 21));
		printerPowerPanel.add(printerPowerBufferLabel1, BorderLayout.PAGE_START);
		JLabel printerPowerBufferLabel2 = new JLabel("                                ");
		printerPowerPanel.add(printerPowerBufferLabel2, BorderLayout.LINE_START);
		JLabel printerPowerBufferLabel3 = new JLabel("                                ");
		printerPowerPanel.add(printerPowerBufferLabel3, BorderLayout.LINE_END);
		JLabel printerPowerBufferLabel4 = new JLabel("                                  ");
		printerPowerPanel.add(printerPowerBufferLabel4, BorderLayout.PAGE_END);
		printerPowerPanel.add(printerPwrBtn, BorderLayout.CENTER);
		printerPanel.add(printerPowerPanel, BorderLayout.PAGE_START);
		JPanel printerTapePanel = new JPanel(new GridLayout(10,1));
		printerTapePanel.setBackground(Color.WHITE);
		printerTapePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		printerTapePanel.add(printerLine1Label);
		printerTapePanel.add(printerLine2Label);
		printerTapePanel.add(printerLine3Label);
		printerTapePanel.add(printerLine4Label);
		printerTapePanel.add(printerLine5Label);
		printerTapePanel.add(printerLine6Label);
		printerTapePanel.add(printerLine7Label);
		printerTapePanel.add(printerLine8Label);
		printerTapePanel.add(printerLine9Label);
		printerTapePanel.add(printerLine10Label);
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
		JLabel displayPanelBufferLabelLeft = new JLabel(" ");
		JLabel displayPanelBufferLabelRight = new JLabel(" ");
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
		JPanel displayCenterPanel = new JPanel(new GridLayout(8,1));
		displayCenterPanel.setBackground(Color.DARK_GRAY);
		displayCenterPanel.setBorder(BorderFactory.createStrokeBorder(new BasicStroke(5.0f)));
		displayCenterPanel.add(displayLine1Label);
		displayCenterPanel.add(displayLine2Label);
		displayCenterPanel.add(displayLine3Label);
		displayCenterPanel.add(displayLine4Label);
		displayCenterPanel.add(displayLine5Label);
		displayCenterPanel.add(displayLine6Label);
		displayCenterPanel.add(displayLine7Label);
		displayCenterPanel.add(displayLine8Label);
		
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
		
		JPanel channelPanel = new JPanel(new BorderLayout());
		channelPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		JLabel channelBufferTop = new JLabel(" ");
		JLabel channelBufferBottom = new JLabel(" ");
		JLabel chanLabel = new JLabel("CHAN");
		chanLabel.setFont(new Font("Serif", Font.PLAIN, 17));
		channelPanel.add(channelBufferTop, BorderLayout.PAGE_START);
		channelPanel.add(channelBufferBottom, BorderLayout.PAGE_END);
		JPanel chanLabelPanel = new JPanel(new FlowLayout());
		chanLabelPanel.add(chanLabel);
		channelPanel.add(chanLabelPanel, BorderLayout.LINE_START);
		JPanel channelButtonPanel = new JPanel(new GridLayout(5,1));
		JLabel channel1357Label = new JLabel("                1        3        5        7");
		channel1357Label.setFont(new Font("Serif", Font.PLAIN, 17));
		channelButtonPanel.add(channel1357Label);
		JPanel channel1357ButtonPanel = new JPanel(new FlowLayout());
		channel1357ButtonPanel.add(channel1Button);
		channel1357ButtonPanel.add(channel3Button);
		channel1357ButtonPanel.add(channel5Button);
		channel1357ButtonPanel.add(channel7Button);
		channelButtonPanel.add(channel1357ButtonPanel);
		JLabel channel2468Label = new JLabel("                2        4        6        8");
		channel2468Label.setFont(new Font("Serif", Font.PLAIN, 17));
		channelButtonPanel.add(channel2468Label);
		JPanel channel2468ButtonPanel = new JPanel(new FlowLayout());
		channel2468ButtonPanel.add(channel2Button);
		channel2468ButtonPanel.add(channel4Button);
		channel2468ButtonPanel.add(channel6Button);
		channel2468ButtonPanel.add(channel8Button);
		channelButtonPanel.add(channel2468ButtonPanel);
		channelPanel.add(channelButtonPanel, BorderLayout.CENTER);
		
		JPanel usbPanel = new JPanel();
		usbPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		JLabel usbText = new JLabel("USB PORT");
		JPanel usbCenterPanel = new JPanel(new FlowLayout());
		usbPanel.setLayout(new GridLayout(7,1));
		JLabel buffer1 = new JLabel(" ");
		JLabel buffer2 = new JLabel(" ");
		JLabel buffer3 = new JLabel(" ");
		JLabel buffer4 = new JLabel(" ");
		JLabel buffer5 = new JLabel(" ");
		JLabel buffer6 = new JLabel(" ");
		JButton usbPortBtn = new JButton();
		usbPortBtn.setEnabled(false);
		usbCenterPanel.add(usbPortBtn);
		usbCenterPanel.add(usbText);
		usbPanel.add(buffer1);
		usbPanel.add(buffer2);
		usbPanel.add(buffer3);
		usbPanel.add(usbCenterPanel);
		usbPanel.add(buffer4);
		usbPanel.add(buffer5);
		usbPanel.add(buffer6);
		
		JPanel blankPanel = new JPanel();
		blankPanel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.BLACK));
		
		// need the separate panels to be added in this order to be correct
		getContentPane().add(pwrPanel);
		getContentPane().add(startPanel);
		getContentPane().add(printerPanel);
		getContentPane().add(funcSwapPanel);
		getContentPane().add(displayPanel);
		getContentPane().add(numPadPanel);
		getContentPane().add(channelPanel);
		getContentPane().add(usbPanel);
		getContentPane().add(blankPanel);
		
		Timer timer = new Timer(1000/60,new ActionListener() {
		    public void actionPerformed(ActionEvent event) 
		    {
		      updateModel();
		    }
		    
		    public void pairIndCurrentRacer(){
		    	// Current Racers Running
		    	Stats currentStats = chronotimer.getCurrentRun().getStats();	
    			LinkedList<Racer> racerStartQueue = chronotimer.getCurrentRun().getBeginQueue();
    			LinkedList<Racer> racerEndQueue = chronotimer.getCurrentRun().getEndQueue();
		    	
    			LinkedList<Racer> queue12 = chronotimer.getCurrentRun().getPendingQueue12();
    			LinkedList<Racer> queue34 = chronotimer.getCurrentRun().getPendingQueue34();
    			LinkedList<Racer> queue56 = chronotimer.getCurrentRun().getPendingQueue56();
    			LinkedList<Racer> queue78 = chronotimer.getCurrentRun().getPendingQueue78();
		    	
	    		if((queue12.size() > 0) && (queue34.isEmpty() == true) && (queue56.isEmpty() == true) && (queue78.isEmpty() == true)){
	    			int result = chronotimer.getCurrentRun().getOtherLane(0);
	    			if(result == -1){
	    				displayLine2Label.setText("Lane 1/2                                        Lane N/A");
	    			}else if(result == 1){
	    				displayLine2Label.setText("Lane 1/2                                        Lane 3/4");
	    			}else if(result == 2){
	    				displayLine2Label.setText("Lane 1/2                                        Lane 5/6");
	    			}else if(result == 3){
	    				displayLine2Label.setText("Lane 1/2                                        Lane 7/8");
	    			}
	    			if(queue12.size() < 6){
	   					if(queue12.size() == 0){
	   						displayLine3Label.setText("No Current Racer                   No Current Racer :R");
	    					displayLine4Label.setText("");
	    					displayLine5Label.setText("");
		    				displayLine6Label.setText("");
		    				displayLine7Label.setText("");
	    				}else if(queue12.size() == 1){
	    					displayLine3Label.setText(queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0))) + "                   No Current Racer :R");
		    				displayLine4Label.setText("");
		    				displayLine5Label.setText("");
		    				displayLine6Label.setText("");
		    				displayLine7Label.setText("");
	    				}else if(queue12.size() == 2){
	    					displayLine3Label.setText(queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0))) + "                   No Current Racer :R");
		    				displayLine4Label.setText(queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1))) + "                   No Current Racer :R");
		    				displayLine5Label.setText("");
		    				displayLine6Label.setText("");
		    				displayLine7Label.setText("");
	    				}else if(queue12.size() == 3){
	    					displayLine3Label.setText(queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0))) + "                   No Current Racer :R");
		    				displayLine4Label.setText(queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1))) + "                   No Current Racer :R");
		    				displayLine5Label.setText(queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2))) + "                   No Current Racer :R");
		    				displayLine6Label.setText("");
		    				displayLine7Label.setText("");
	    				}else if(queue12.size() == 4){
	    					displayLine3Label.setText(queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0))) + "                   No Current Racer :R");
		    				displayLine4Label.setText(queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1))) + "                   No Current Racer :R");
		    				displayLine5Label.setText(queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2))) + "                   No Current Racer :R");
		    				displayLine6Label.setText(queue12.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(3))) + "                   No Current Racer :R");
		    				displayLine7Label.setText("");
	    				}else if(queue12.size() == 5){
	    					displayLine3Label.setText(queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0))) + "                   No Current Racer :R");
		    				displayLine4Label.setText(queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1))) + "                   No Current Racer :R");
		    				displayLine5Label.setText(queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2))) + "                   No Current Racer :R");
		    				displayLine6Label.setText(queue12.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(3))) + "                   No Current Racer :R");
		    				displayLine7Label.setText(queue12.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(4))) + "                   No Current Racer :R");
	    				}
	    			}else{
	    				int sizeTot = queue12.size();
	    				displayLine3Label.setText(queue12.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-1))) + "                   No Current Racer :R");
	    				displayLine4Label.setText(queue12.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-2))) + "                   No Current Racer :R");
	    				displayLine5Label.setText(queue12.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-3))) + "                   No Current Racer :R");
	    				displayLine6Label.setText(queue12.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-4))) + "                   No Current Racer :R");
	    				displayLine7Label.setText(queue12.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-5))) + "                   No Current Racer :R");
	   				}
	   			}else if((queue12.size() > 0) && (queue34.size() > 0) && (queue56.isEmpty() == true) && (queue78.isEmpty() == true)){
	    			displayLine2Label.setText("Lane 1/2                                        Lane 3/4");
	   				String line3 = "";
	   				String line4 = "";
	   				String line5 = "";
	   				String line6 = "";
	   				String line7 = "";
	   				if(queue12.size() < 6){
	    				if(queue12.size() == 0){
	    					line3 += "No Current Racer     ";
	    				}else if(queue12.size() == 1){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += "                                                 ";
	   						line5 += "                                                 ";
	   						line6 += "                                                 ";
	   						line7 += "                                                 ";
	    				}else if(queue12.size() == 2){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	    					line5 += "                                                 ";
	    					line6 += "                                                 ";
	    					line7 += "                                                 ";
	    				}else if(queue12.size() == 3){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	   						line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	   						line5 += (queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2)))+ "                   ");
	   						line6 += "                                                 ";
	   						line7 += "                                                 ";
    					}else if(queue12.size() == 4){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	    					line5 += (queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2)))+ "                   ");
	    					line6 += (queue12.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(3)))+ "                   ");
	   						line7 += "                                                 ";
	   					}else if(queue12.size() == 5){
	   						line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	   						line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
    						line5 += (queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2)))+ "                   ");
	   						line6 += (queue12.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(3)))+ "                   ");
	   						line7 += (queue12.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(4)))+ "                   ");
	   					}
    				}else{
    					int sizeTot = queue12.size();
	    				line3 += (queue12.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-1)))+ "                   ");
	    				line4 += (queue12.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-2)))+ "                   ");
	    				line5 += (queue12.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-3)))+ "                   ");
	    				line6 += (queue12.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-4)))+ "                   ");
	   					line7 += (queue12.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-5)))+ "                   ");
	    			}
	    				
	    			if(queue34.size() < 6){
	    				if(queue34.size() == 0){
	    					line3 += "No Current Racer :R";
	    				}else if(queue34.size() == 1){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    				}else if(queue34.size() == 2){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    					line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + " :R");
	    				}else if(queue34.size() == 3){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    					line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + " :R");
	    					line5 += (queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2))) + " :R");
	    				}else if(queue34.size() == 4){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    					line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + " :R");
	    					line5 += (queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2))) + " :R");
	    					line6 += (queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3))) + " :R");
	    				}else if(queue34.size() == 5){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    					line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + " :R");
	    					line5 += (queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2))) + " :R");
	    					line6 += (queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3))) + " :R");
	    					line7 += (queue34.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(4))) + " :R");
	    				}
	    			}else{
	    				int sizeTot = queue34.size();
	    				line3 += (queue34.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-1))) + " :R");
	    				line4 += (queue34.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-2))) + " :R");
	    				line5 += (queue34.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-3))) + " :R");
	    				line6 += (queue34.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-4))) + " :R");
	    				line7 += (queue34.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-5))) + " :R");
	    			}
	    				
	    			displayLine2Label.setText("Lane 1/2                                        Lane 3/4");
		    		displayLine3Label.setText(line3);
			   		displayLine4Label.setText(line4);
			   		displayLine5Label.setText(line5);
			    	displayLine6Label.setText(line6);
			    	displayLine7Label.setText(line7);
	    		}else if((queue12.size() > 0) && (queue34.isEmpty() == true) && (queue56.size() > 0) && (queue78.isEmpty() == true)){
	    			displayLine2Label.setText("Lane 1/2                                        Lane 5/6");
	    			String line3 = "";
	    			String line4 = "";
	   				String line5 = "";
	   				String line6 = "";
	   				String line7 = "";
	   				if(queue12.size() < 6){
	   					if(queue12.size() == 0){
	   						line3 += "No Current Racer     ";
	   					}else if(queue12.size() == 1){
    						line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += "                                                 ";
	    					line5 += "                                                 ";
	    					line6 += "                                                 ";
	    					line7 += "                                                 ";
	    				}else if(queue12.size() == 2){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	    					line5 += "                                                 ";
	   						line6 += "                                                 ";
	   						line7 += "                                                 ";
	   					}else if(queue12.size() == 3){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	    					line5 += (queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2)))+ "                   ");
	    					line6 += "                                                 ";
	    					line7 += "                                                 ";
	    				}else if(queue12.size() == 4){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	    					line5 += (queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2)))+ "                   ");
	    					line6 += (queue12.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(3)))+ "                   ");
	    					line7 += "                                                 ";
	    				}else if(queue12.size() == 5){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	    					line5 += (queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2)))+ "                   ");
	    					line6 += (queue12.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(3)))+ "                   ");
	    					line7 += (queue12.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(4)))+ "                   ");
	    				}
	    			}else{
	    				int sizeTot = queue12.size();
	    				line3 += (queue12.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-1)))+ "                   ");
	    				line4 += (queue12.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-2)))+ "                   ");
	    				line5 += (queue12.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-3)))+ "                   ");
	    				line6 += (queue12.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-4)))+ "                   ");
	    				line7 += (queue12.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-5)))+ "                   ");
	    			}
	    				
	    			if(queue56.size() < 6){
	    				if(queue56.size() == 0){
	    					line3 += "No Current Racer :R";
	    				}else if(queue56.size() == 1){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    				}else if(queue56.size() == 2){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    				}else if(queue56.size() == 3){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    					line5 += (queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + " :R");
	    				}else if(queue56.size() == 4){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    					line5 += (queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + " :R");
	    					line6 += (queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3))) + " :R");
	    				}else if(queue56.size() == 5){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    					line5 += (queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + " :R");
	    					line6 += (queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3))) + " :R");
	    					line7 += (queue56.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(4))) + " :R");
	    				}
	    			}else{
	    				int sizeTot = queue56.size();
	    				line3 += (queue56.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-1))) + " :R");
	    				line4 += (queue56.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-2))) + " :R");
	    				line5 += (queue56.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-3))) + " :R");
	    				line6 += (queue56.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-4))) + " :R");
	    				line7 += (queue56.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-5))) + " :R");
	    			}
	    				
	    			displayLine2Label.setText("Lane 1/2                                        Lane 5/6");
		    		displayLine3Label.setText(line3);
			    	displayLine4Label.setText(line4);
			    	displayLine5Label.setText(line5);
			    	displayLine6Label.setText(line6);
			    	displayLine7Label.setText(line7);
	    		}else if((queue12.size() > 0) && (queue34.isEmpty() == true) && (queue56.isEmpty() == true) && (queue78.size() > 0)){
	    			displayLine2Label.setText("Lane 1/2                                        Lane 7/8");
	    			String line3 = "";
	    			String line4 = "";
	    			String line5 = "";
	   				String line6 = "";
	   				String line7 = "";
	   				if(queue12.size() < 6){
	   					if(queue12.size() == 0){
	    					line3 += "No Current Racer                       ";
	    				}else if(queue12.size() == 1){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                  ");
	    					line4 += "                                                 ";
	   						line5 += "                                                 ";
	   						line6 += "                                                 ";
	   						line7 += "                                                 ";
	   					}else if(queue12.size() == 2){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
		    				line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
		    				line5 += "                                                 ";
	    					line6 += "                                                 ";
	    					line7 += "                                                 ";
	    				}else if(queue12.size() == 3){
	   						line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	   						line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	   						line5 += (queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2)))+ "                   ");
	   						line6 += "                                                 ";
    						line7 += "                                                 ";
	    				}else if(queue12.size() == 4){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	    					line5 += (queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2)))+ "                   ");
	    					line6 += (queue12.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(3)))+ "                   ");
	   						line7 += "                                                 ";
	   					}else if(queue12.size() == 5){
	    					line3 += (queue12.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(0)))+ "                   ");
	    					line4 += (queue12.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(1)))+ "                   ");
	    					line5 += (queue12.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(2)))+ "                   ");
	    					line6 += (queue12.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(3)))+ "                   ");
	    					line7 += (queue12.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(4)))+ "                   ");
	    				}
	    			}else{
	    				int sizeTot = queue12.size();
	    				line3 += (queue12.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-1)))+ "                   ");
	    				line4 += (queue12.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-2)))+ "                   ");
	    				line5 += (queue12.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-3)))+ "                   ");
	    				line6 += (queue12.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-4)))+ "                   ");
	    				line7 += (queue12.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue12.get(sizeTot-5)))+ "                   ");
	    			}
	    				
	    			if(queue78.size() < 6){
	    				if(queue78.size() == 0){
	    					line3 += "No Current Racer :R";
	    				}else if(queue78.size() == 1){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    				}else if(queue78.size() == 2){
	   						line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	   						line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	   					}else if(queue78.size() == 3){
	   						line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
    						line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    					line5 += (queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    				}else if(queue78.size() == 4){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    					line5 += (queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    					line6 += (queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + " :R");
	    				}else if(queue78.size() == 5){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    					line5 += (queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    					line6 += (queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + " :R");
	    					line7 += (queue78.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(4))) + " :R");
	    				}
	    			}else{
	    				int sizeTot = queue78.size();
	    				line3 += (queue78.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-1))) + " :R");
	    				line4 += (queue78.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-2))) + " :R");
	    				line5 += (queue78.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-3))) + " :R");
	    				line6 += (queue78.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-4))) + " :R");
	    				line7 += (queue78.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-5))) + " :R");
	    			}
	    				
	    			displayLine2Label.setText("Lane 1/2                                        Lane 7/8");
		    		displayLine3Label.setText(line3);
			    	displayLine4Label.setText(line4);
			    	displayLine5Label.setText(line5);
			    	displayLine6Label.setText(line6);
			    	displayLine7Label.setText(line7);
	    		}else if((queue12.isEmpty() == true) && (queue34.size() > 0) && (queue56.size() > 0) && (queue78.isEmpty() == true)){
	    			displayLine2Label.setText("Lane 3/4                                        Lane 5/6");
	    			String line3 = "";
	    			String line4 = "";
	    			String line5 = "";
	    			String line6 = "";
	    			String line7 = "";
	    			if(queue34.size() < 6){
	    				if(queue34.size() == 0){
	    					line3 += "No Current Racer     ";
	    				}else if(queue34.size() == 1){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
	    					line4 += "                                                 ";
	    					line5 += "                                                 ";
	    					line6 += "                                                 ";
	    					line7 += "                                                 ";
	    				}else if(queue34.size() == 2){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
		    				line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1)))+ "                   ");
		    				line5 += "                                                 ";
	    					line6 += "                                                 ";
	    					line7 += "                                                 ";
	    				}else if(queue34.size() == 3){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
	    					line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1)))+ "                   ");
	    					line5 += (queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2)))+ "                   ");
	    					line6 += "                                                 ";
	    					line7 += "                                                 ";
	    				}else if(queue34.size() == 4){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
	    					line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1)))+ "                   ");
	    					line5 += (queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2)))+ "                   ");
	    					line6 += (queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3)))+ "                   ");
	    					line7 += "                                                 ";
	   					}else if(queue34.size() == 5){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
	    					line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1)))+ "                   ");
	    					line5 += (queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2)))+ "                   ");
	    					line6 += (queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3)))+ "                   ");
	    					line7 += (queue34.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(4)))+ "                   ");
	    				}
	    			}else{
	    				int sizeTot = queue34.size();
	    				line3 += (queue34.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-1)))+ "                   ");
	    				line4 += (queue34.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-2)))+ "                   ");
	    				line5 += (queue34.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-3)))+ "                   ");
	   					line6 += (queue34.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-4)))+ "                   ");
	   					line7 += (queue34.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-5)))+ "                   ");
	   				}
	    				
	    			if(queue56.size() < 6){
	    				if(queue56.size() == 0){
	    					line3 += "No Current Racer :R";
	   					}else if(queue56.size() == 1){
	   						line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	   					}else if(queue56.size() == 2){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    				}else if(queue56.size() == 3){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    					line5 += (queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + " :R");
	   					}else if(queue56.size() == 4){
	   						line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	   						line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	   						line5 += (queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + " :R");
    						line6 += (queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3))) + " :R");
	    				}else if(queue56.size() == 5){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    					line5 += (queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + " :R");
	    					line6 += (queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3))) + " :R");
	    					line7 += (queue56.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(4))) + " :R");
	    				}
	    			}else{
	    				int sizeTot = queue56.size();
	    				line3 += (queue56.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-1))) + " :R");
	    				line4 += (queue56.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-2))) + " :R");
	    				line5 += (queue56.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-3))) + " :R");
	    				line6 += (queue56.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-4))) + " :R");
	    				line7 += (queue56.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-5))) + " :R");
	    			}
	    				
	    			displayLine2Label.setText("Lane 3/4                                        Lane 5/6");
		    		displayLine3Label.setText(line3);
			    	displayLine4Label.setText(line4);
			    	displayLine5Label.setText(line5);
			    	displayLine6Label.setText(line6);
			    	displayLine7Label.setText(line7);
	    		}else if((queue12.isEmpty() == true) && (queue34.size() > 0) && (queue56.isEmpty() == true) && (queue78.size() > 0)){
	    			displayLine2Label.setText("Lane 3/4                                        Lane 7/8");
	    			String line3 = "";
	    			String line4 = "";
	    			String line5 = "";
	    			String line6 = "";
	    			String line7 = "";
	    			if(queue34.size() < 6){
	    				if(queue34.size() == 0){
	    					line3 += "No Current Racer     ";
	    				}else if(queue34.size() == 1){     
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
	    					line4 += "                                                 ";
	    					line5 += "                                                 ";
	    					line6 += "                                                 ";
	    					line7 += "                                                 ";
	    				}else if(queue34.size() == 2){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
		    				line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1)))+ "                   ");
		    				line5 += "                                                 ";
	    					line6 += "                                                 ";
	    					line7 += "                                                 ";
	    				}else if(queue34.size() == 3){
	   						line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
	   						line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1)))+ "                   ");
	   						line5 += (queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2)))+ "                   ");
	   						line6 += "                                                 ";
    						line7 += "                                                 ";
	    				}else if(queue34.size() == 4){
	    					line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
	    					line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1)))+ "                   ");
	    					line5 += (queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2)))+ "                   ");
	    					line6 += (queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3)))+ "                   ");
	   						line7 += "                                  ";
	   					}else if(queue34.size() == 5){
	   						line3 += (queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0)))+ "                   ");
	   						line4 += (queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1)))+ "                   ");
    						line5 += (queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2)))+ "                   ");
	    					line6 += (queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3)))+ "                   ");
	    					line7 += (queue34.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(4)))+ "                   ");
	    				}
	    			}else{
	    				int sizeTot = queue34.size();
	    				line3 += (queue34.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-1)))+ "                   ");
	    				line4 += (queue34.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-2)))+ "                   ");
	    				line5 += (queue34.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-3)))+ "                   ");
	    				line6 += (queue34.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-4)))+ "                   ");
	    				line7 += (queue34.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-5)))+ "                   ");
	    			}
	    				
	    			if(queue78.size() < 6){
	    				if(queue78.size() == 0){
	    					line3 += "No Current Racer :R";
	    				}else if(queue78.size() == 1){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    				}else if(queue78.size() == 2){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    				}else if(queue78.size() == 3){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    					line5 += (queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    				}else if(queue78.size() == 4){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    					line5 += (queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    					line6 += (queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + " :R");
	    				}else if(queue78.size() == 5){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    					line5 += (queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    					line6 += (queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + " :R");
	    					line7 += (queue78.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(4))) + " :R");
	    				}
	    			}else{
	    				int sizeTot = queue78.size();
	    				line3 += (queue78.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-1))) + " :R");
	    				line4 += (queue78.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-2))) + " :R");
	    				line5 += (queue78.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-3))) + " :R");
	    				line6 += (queue78.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-4))) + " :R");
	   					line7 += (queue78.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-5))) + " :R");
	   				}
	    				
	    			displayLine2Label.setText("Lane 3/4                                        Lane 7/8");
		    		displayLine3Label.setText(line3);
			   		displayLine4Label.setText(line4);
			   		displayLine5Label.setText(line5);
			   		displayLine6Label.setText(line6);
			   		displayLine7Label.setText(line7);
	    		}else if((queue12.isEmpty() == true) && (queue34.size() > 0) && (queue56.isEmpty() == true) && (queue78.isEmpty() == true)){
	    			int result = chronotimer.getCurrentRun().getOtherLane(1);
	    			if(result == -1 || result == 2 || result == 3){
	    				if(result == 2){
	    					displayLine2Label.setText("Lane 3/4                                        Lane 5/6");
	    				}else if(result == 3){
	    					displayLine2Label.setText("Lane 3/4                                        Lane 7/8");
	    				}else{
	    					displayLine2Label.setText("Lane 3/4                                        Lane N/A");
	    				}
	    				
	    				if(queue34.size() < 6){
	    					if(queue34.size() == 0){
	    						displayLine3Label.setText("No Current Racer                   No Current Racer :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 1){
	    						displayLine3Label.setText(queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 2){
	    						displayLine3Label.setText(queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 3){
	    						displayLine3Label.setText(queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText(queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2))) + "                   No Current Racer :R");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 4){
	    						displayLine3Label.setText(queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText(queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2))) + "                   No Current Racer :R");
	    						displayLine6Label.setText(queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3))) + "                   No Current Racer :R");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 5){
	    						displayLine3Label.setText(queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText(queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2))) + "                   No Current Racer :R");
	    						displayLine6Label.setText(queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3))) + "                   No Current Racer :R");
	    						displayLine7Label.setText(queue34.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(4))) + "                   No Current Racer :R");
	    					}
	    				}else{
	    					int sizeTot = queue34.size();
	    					displayLine3Label.setText(queue34.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-1))) + "                   No Current Racer :R");
	    					displayLine4Label.setText(queue34.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-2))) + "                   No Current Racer :R");
	    					displayLine5Label.setText(queue34.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-3))) + "                   No Current Racer :R");
	    					displayLine6Label.setText(queue34.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-4))) + "                   No Current Racer :R");
	    					displayLine7Label.setText(queue34.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-5))) + "                   No Current Racer :R");
	    				}
	    			}else{
	    				displayLine2Label.setText("Lane 1/2                                        Lane 3/4");
	    				if(queue34.size() < 6){
	    					if(queue34.size() == 0){
	    						displayLine3Label.setText("No Current Racer                   No Current Racer :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 1){
	    						displayLine3Label.setText("No Current Racer                   " + queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 2){
	    						displayLine3Label.setText("No Current Racer                   " + queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + " :R");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 3){
	    						displayLine3Label.setText("No Current Racer                   " + queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + " :R");
	    						displayLine5Label.setText("No Current Racer                   " + queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2))) + " :R");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 4){
	    						displayLine3Label.setText("No Current Racer                   " + queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + " :R");
	    						displayLine5Label.setText("No Current Racer                   " + queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2))) + " :R");
	    						displayLine6Label.setText("No Current Racer                   " + queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3))) + " :R");
	    						displayLine7Label.setText("");
	    					}else if(queue34.size() == 5){
	    						displayLine3Label.setText("No Current Racer                   " + queue34.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue34.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(1))) + " :R");
	    						displayLine5Label.setText("No Current Racer                   " + queue34.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(2))) + " :R");
	    						displayLine6Label.setText("No Current Racer                   " + queue34.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(3))) + " :R");
	    						displayLine7Label.setText("No Current Racer                   " + queue34.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(4))) + " :R");
	    					}
	    				}else{
	    					int sizeTot = queue34.size();
	    					displayLine3Label.setText("No Current Racer                   " + queue34.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-1))) + " :R");
	    					displayLine4Label.setText("No Current Racer                   " + queue34.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-2))) + " :R");
	    					displayLine5Label.setText("No Current Racer                   " + queue34.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-3))) + " :R");
	    					displayLine6Label.setText("No Current Racer                   " + queue34.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-4))) + " :R");
	    					displayLine7Label.setText("No Current Racer                   " + queue34.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue34.get(sizeTot-5))) + " :R");
	    				}
	    			}
	    		}else if((queue12.isEmpty() == true) && (queue34.isEmpty() == true) && (queue56.size() > 0) && (queue78.isEmpty() == true)){
	    			int result = chronotimer.getCurrentRun().getOtherLane(2);
	    			if(result == -1 || result == 3){
	    				if(result == 3){
	    					displayLine2Label.setText("Lane 5/6                                        Lane 7/8");
	    				}else{
	    					displayLine2Label.setText("Lane 5/6                                        Lane N/A");
	    				}
	    				if(queue56.size() < 6){
	    					if(queue56.size() == 0){
	    						displayLine3Label.setText("No Current Racer                   No Current Racer :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue56.size() == 1){
	    						displayLine3Label.setText(queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
		    					displayLine6Label.setText("");
		    					displayLine7Label.setText("");
	    					}else if(queue56.size() == 2){
	    						displayLine3Label.setText(queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue56.size() == 3){
	    						displayLine3Label.setText(queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText(queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + "                   No Current Racer :R");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue56.size() == 4){
	    						displayLine3Label.setText(queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText(queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + "                   No Current Racer :R");
	    						displayLine6Label.setText(queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3))) + "                   No Current Racer :R");
	    						displayLine7Label.setText("");
	    					}else if(queue56.size() == 5){
	    						displayLine3Label.setText(queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText(queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + "                   No Current Racer :R");
	    						displayLine6Label.setText(queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3))) + "                   No Current Racer :R");
	    						displayLine7Label.setText(queue56.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(4))) + "                   No Current Racer :R");
	    					}
	    				}else{
	    					int sizeTot = queue56.size();
	    					displayLine3Label.setText(queue56.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-1))) + "                   No Current Racer :R");
	    					displayLine4Label.setText(queue56.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-2))) + "                   No Current Racer :R");
	    					displayLine5Label.setText(queue56.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-3))) + "                   No Current Racer :R");
	    					displayLine6Label.setText(queue56.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-4))) + "                   No Current Racer :R");
	    					displayLine7Label.setText(queue56.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-5))) + "                   No Current Racer :R");
	    				}
	    			}else{
	    				if(result == 0){
	    					displayLine2Label.setText("Lane 1/2                                        Lane 5/6");
	    				}else{
	    					displayLine2Label.setText("Lane 3/4                                        Lane 5/6");
	    				}
	    				if(queue56.size() < 6){
	    					if(queue56.size() == 0){
	    						displayLine3Label.setText("No Current Racer                   No Current Racer :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue56.size() == 1){
	    						displayLine3Label.setText("No Current Racer                   " + queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
		    					displayLine6Label.setText("");
		    					displayLine7Label.setText("");
	    					}else if(queue56.size() == 2){
	    						displayLine3Label.setText("No Current Racer                   " + queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue56.size() == 3){
	    						displayLine3Label.setText("No Current Racer                   " + queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    						displayLine5Label.setText("No Current Racer                   " + queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + " :R");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue56.size() == 4){
	    						displayLine3Label.setText("No Current Racer                   " + queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    						displayLine5Label.setText("No Current Racer                   " + queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + " :R");
	    						displayLine6Label.setText("No Current Racer                   " + queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3))) + " :R");
	    						displayLine7Label.setText("");
	    					}else if(queue56.size() == 5){
	    						displayLine3Label.setText("No Current Racer                   " + queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1))) + " :R");
	    						displayLine5Label.setText("No Current Racer                   " + queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2))) + " :R");
	    						displayLine6Label.setText("No Current Racer                   " + queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3))) + " :R");
	    						displayLine7Label.setText("No Current Racer                   " + queue56.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(4))) + " :R");
	    					}
	    				}else{
	    					int sizeTot = queue56.size();
	    					displayLine3Label.setText("No Current Racer                   " + queue56.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-1))) + " :R");
	    					displayLine4Label.setText("No Current Racer                   " + queue56.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-2))) + " :R");
	    					displayLine5Label.setText("No Current Racer                   " + queue56.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-3))) + " :R");
	    					displayLine6Label.setText("No Current Racer                   " + queue56.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-4))) + " :R");
	    					displayLine7Label.setText("No Current Racer                   " + queue56.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-5))) + " :R");
	    				}
	    			}
	    		}else if((queue12.isEmpty() == true) && (queue34.isEmpty() == true) && (queue56.size() > 0) && (queue78.size() > 0)){
	    			displayLine2Label.setText("Lane 5/6                                        Lane 7/8");
	    			String line3 = "";
	    			String line4 = "";
	    			String line5 = "";
	    			String line6 = "";
	   				String line7 = "";
	   				if(queue56.size() < 6){
	    				if(queue56.size() == 0){
	    					line3 += "No Current Racer     ";
	    				}else if(queue56.size() == 1){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0)))+ "                   ");
	   						line4 += "                                                 ";
	   						line5 += "                                                 ";
	   						line6 += "                                                 ";
	   						line7 += "                                                 ";
	    				}else if(queue56.size() == 2){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0)))+ "                   ");
		    				line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1)))+ "                   ");
		    				line5 += "                                                 ";
	    					line6 += "                                                 ";
	   						line7 += "                                                 ";
	    				}else if(queue56.size() == 3){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0)))+ "                   ");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1)))+ "                   ");
	    					line5 += (queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2)))+ "                  ");
	    					line6 += "                                                 ";
	   						line7 += "                                                 ";
	    				}else if(queue56.size() == 4){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0)))+ "                   ");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1)))+ "                   ");
	    					line5 += (queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2)))+ "                   ");
	    					line6 += (queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3)))+ "                   ");
	   						line7 += "                                                 ";
	   					}else if(queue56.size() == 5){
	    					line3 += (queue56.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(0)))+ "                   ");
	    					line4 += (queue56.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(1)))+ "                   ");
	    					line5 += (queue56.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(2)))+ "                   ");
	    					line6 += (queue56.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(3)))+ "                   ");
	    					line7 += (queue56.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(4)))+ "                   ");
	   					}
	    			}else{
	    				int sizeTot = queue56.size();
	    				line3 += (queue56.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-1)))+ "                   ");
	    				line4 += (queue56.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-2)))+ "                   ");
	    				line5 += (queue56.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-3)))+ "                   ");
	   					line6 += (queue56.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-4)))+ "                   ");
	   					line7 += (queue56.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue56.get(sizeTot-5)))+ "                   ");
	   				}
	    				
	    			if(queue78.size() < 6){
	    				if(queue78.size() == 0){
	    					line3 += "No Current Racer :R";
	    				}else if(queue78.size() == 1){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    				}else if(queue78.size() == 2){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    				}else if(queue78.size() == 3){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    					line5 += (queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    				}else if(queue78.size() == 4){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    					line5 += (queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    					line6 += (queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + " :R");
	    				}else if(queue78.size() == 5){
	    					line3 += (queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    					line4 += (queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    					line5 += (queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    					line6 += (queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + " :R");
	    					line7 += (queue78.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(4))) + " :R");
	    				}
	    			}else{
	    				int sizeTot = queue78.size();
	    				line3 += (queue78.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-1))) + " :R");
	    				line4 += (queue78.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-2))) + " :R");
	    				line5 += (queue78.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-3))) + " :R");
	    				line6 += (queue78.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-4))) + " :R");
	   					line7 += (queue78.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-5))) + " :R");
	   				}
	    				
	    			displayLine2Label.setText("Lane 5/6                                        Lane 7/8");
		    		displayLine3Label.setText(line3);
		    		displayLine4Label.setText(line4);
		    		displayLine5Label.setText(line5);
		    		displayLine6Label.setText(line6);
		    		displayLine7Label.setText(line7);
	    		}else if((queue12.isEmpty() == true) && (queue34.isEmpty() == true) && (queue56.isEmpty() == true) && (queue78.size() > 0)){
	    			int result = chronotimer.getCurrentRun().getOtherLane(3);
	    			if(result == -1){
	    				displayLine2Label.setText("Lane 7/8                                        Lane N/A");
	    				if(queue78.size() < 6){
	    					if(queue78.size() == 0){
	    						displayLine3Label.setText("No Current Racer                   No Current Racer :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue78.size() == 1){
	    						displayLine3Label.setText(queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue78.size() == 2){
	    						displayLine3Label.setText(queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue78.size() == 3){
	    						displayLine3Label.setText(queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText(queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + "                   No Current Racer :R");
	    						displayLine6Label.setText("");
		    					displayLine7Label.setText("");
	    					}else if(queue78.size() == 4){
	    						displayLine3Label.setText(queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + "                   No Current Racer :R");
		    					displayLine5Label.setText(queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + "                   No Current Racer :R");
		    					displayLine6Label.setText(queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + "                   No Current Racer :R");
		    					displayLine7Label.setText("");
	    					}else if(queue78.size() == 5){
	    						displayLine3Label.setText(queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + "                   No Current Racer :R");
	    						displayLine4Label.setText(queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + "                   No Current Racer :R");
	    						displayLine5Label.setText(queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + "                   No Current Racer :R");
	    						displayLine6Label.setText(queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + "                   No Current Racer :R");
	    						displayLine7Label.setText(queue78.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(4))) + "                   No Current Racer :R");
	    					}
	    				}else{
	    					int sizeTot = queue78.size();
	    					displayLine3Label.setText(queue78.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-1))) + "                   No Current Racer :R");
	    					displayLine4Label.setText(queue78.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-2))) + "                   No Current Racer :R");
	    					displayLine5Label.setText(queue78.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-3))) + "                   No Current Racer :R");
	    					displayLine6Label.setText(queue78.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-4))) + "                   No Current Racer :R");
	    					displayLine7Label.setText(queue78.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-5))) + "                   No Current Racer :R");
	    				}
	    			}else{
	    				if(result == 0){
	    					displayLine2Label.setText("Lane 1/2                                        Lane 7/8");
	    				}else if(result == 1){
	    					displayLine2Label.setText("Lane 3/4                                        Lane 7/8");
	    				}else{
	    					displayLine2Label.setText("Lane 5/6                                        Lane 7/8");
	    				}
	    				if(queue78.size() < 6){
	    					if(queue78.size() == 0){
	    						displayLine3Label.setText("No Current Racer                   No Current Racer :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue78.size() == 1){
	    						displayLine3Label.setText("No Current Racer                   " + queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    						displayLine4Label.setText("");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue78.size() == 2){
	    						displayLine3Label.setText("No Current Racer                   " + queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    						displayLine5Label.setText("");
	    						displayLine6Label.setText("");
	    						displayLine7Label.setText("");
	    					}else if(queue78.size() == 3){
	    						displayLine3Label.setText("No Current Racer                   " + queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    						displayLine5Label.setText("No Current Racer                   " + queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    						displayLine6Label.setText("");
		    					displayLine7Label.setText("");
	    					}else if(queue78.size() == 4){
	    						displayLine3Label.setText("No Current Racer                   " + queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
		    					displayLine5Label.setText("No Current Racer                   " + queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
		    					displayLine6Label.setText("No Current Racer                   " + queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + " :R");
		    					displayLine7Label.setText("");
	    					}else if(queue78.size() == 5){
	    						displayLine3Label.setText("No Current Racer                   " + queue78.get(0).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(0))) + " :R");
	    						displayLine4Label.setText("No Current Racer                   " + queue78.get(1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(1))) + " :R");
	    						displayLine5Label.setText("No Current Racer                   " + queue78.get(2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(2))) + " :R");
	    						displayLine6Label.setText("No Current Racer                   " + queue78.get(3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(3))) + " :R");
	    						displayLine7Label.setText("No Current Racer                   " + queue78.get(4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(4))) + " :R");
	    					}
	    				}else{
	    					int sizeTot = queue78.size();
	    					displayLine3Label.setText("No Current Racer                   " + queue78.get(sizeTot-1).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-1))) + " :R");
	    					displayLine4Label.setText("No Current Racer                   " + queue78.get(sizeTot-2).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-2))) + " :R");
	    					displayLine5Label.setText("No Current Racer                   " + queue78.get(sizeTot-3).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-3))) + " :R");
	    					displayLine6Label.setText("No Current Racer                   " + queue78.get(sizeTot-4).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-4))) + " :R");
	    					displayLine7Label.setText("No Current Racer                   " + queue78.get(sizeTot-5).getBib() + " " + chronotimer.getTimer().convertTime(chronotimer.getTimer().getCurrentTime() - currentStats.getStart(queue78.get(sizeTot-5))) + " :R");
	    				}
	    			}
	    		}else if((queue12.isEmpty() == true) && (queue34.isEmpty() == true) && (queue56.isEmpty() == true) && (queue78.isEmpty() == true)){
	    			String value = chronotimer.getCurrentRun().getOtherLaneNoCurrentRacers();
	    			String[] valueSplit = value.split(":");
	    			if(valueSplit[0].equals("9")){
	    				displayLine2Label.setText("Lane N/A                                        Lane N/A");
	    			}else if(valueSplit[0].equals("0") && valueSplit[1].equals("9")){
	    				displayLine2Label.setText("Lane 1/2                                        Lane N/A");
	    			}else if(valueSplit[0].equals("1") && valueSplit[1].equals("9")){
	    				displayLine2Label.setText("Lane 3/4                                        Lane N/A");
	    			}else if(valueSplit[0].equals("2") && valueSplit[1].equals("9")){
	    				displayLine2Label.setText("Lane 5/6                                        Lane N/A");
	    			}else if(valueSplit[0].equals("3") && valueSplit[1].equals("9")){
	    				displayLine2Label.setText("Lane 7/8                                        Lane N/A");
	    			}else if(valueSplit[0].equals("0") && valueSplit[1].equals("1")){
	    				displayLine2Label.setText("Lane 1/2                                        Lane 3/4");
	    			}else if(valueSplit[0].equals("0") && valueSplit[1].equals("2")){
	    				displayLine2Label.setText("Lane 1/2                                        Lane 5/6");
	    			}else if(valueSplit[0].equals("0") && valueSplit[1].equals("3")){
	    				displayLine2Label.setText("Lane 1/2                                        Lane 7/8");
	    			}else if(valueSplit[0].equals("1") && valueSplit[1].equals("2")){
	    				displayLine2Label.setText("Lane 3/4                                        Lane 5/6");
	    			}else if(valueSplit[0].equals("1") && valueSplit[1].equals("3")){
	    				displayLine2Label.setText("Lane 3/4                                        Lane 7/8");
	    			}else if(valueSplit[0].equals("2") && valueSplit[1].equals("3")){
	    				displayLine2Label.setText("Lane 5/6                                        Lane 7/8");
	    			}
	    			
	    	    	displayLine3Label.setText("No Current Racer                   No Current Racer :R");
	    		    displayLine4Label.setText("");
	    		    displayLine5Label.setText("");
	    		    displayLine6Label.setText("");
	    		    displayLine7Label.setText("");
	    		}
		    }
		    
		    // display last finishing pair on line 8 of PARIND display screen
		    public void parIndFinishPair(){
		    	// Current Racers Running
		    	Stats currentStats = chronotimer.getCurrentRun().getStats();	
    			LinkedList<Racer> racerStartQueue = chronotimer.getCurrentRun().getBeginQueue();
    			LinkedList<Racer> racerEndQueue = chronotimer.getCurrentRun().getEndQueue();
		    	
    			LinkedList<Racer> queue12 = chronotimer.getCurrentRun().getPendingQueue12();
    			LinkedList<Racer> queue34 = chronotimer.getCurrentRun().getPendingQueue34();
    			LinkedList<Racer> queue56 = chronotimer.getCurrentRun().getPendingQueue56();
    			LinkedList<Racer> queue78 = chronotimer.getCurrentRun().getPendingQueue78();
		    	
    			String result = chronotimer.getCurrentRun().getOtherLaneNoCurrentRacers();
    			String[] resultSplit = result.split(":");
    			if(resultSplit[0].equals("9") && resultSplit[1].equals("9")){
    				displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    			}else if(resultSplit[0].equals("0") && resultSplit[1].equals("9")){
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue12Finish();
    				if(firstLaneRacer != null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else{
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}
    			}else if(resultSplit[0].equals("1") && resultSplit[1].equals("9")){
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue34Finish();
    				if(firstLaneRacer != null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else{
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}
    			}else if(resultSplit[0].equals("2") && resultSplit[1].equals("9")){
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue56Finish();
    				if(firstLaneRacer != null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else{
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}
    			}else if(resultSplit[0].equals("3") && resultSplit[1].equals("9")){
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue78Finish();
    				if(firstLaneRacer != null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else{
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}
    			}else if(resultSplit[0].equals("0") && resultSplit[1].equals("1")){
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue12Finish();
    				Racer secondLaneRacer = chronotimer.getCurrentRun().getQueue34Finish();
    				if(firstLaneRacer == null && secondLaneRacer == null){
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}else if(firstLaneRacer != null && secondLaneRacer == null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else if(firstLaneRacer == null && secondLaneRacer != null){
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText("No Finished Racer                          " + secondBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}else{	// both non-null
    					int firstBib = firstLaneRacer.getBib();
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          " + secondBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}
    			}else if(resultSplit[0].equals("0") && resultSplit[1].equals("2")){
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue12Finish();
    				Racer secondLaneRacer = chronotimer.getCurrentRun().getQueue56Finish();
    				if(firstLaneRacer == null && secondLaneRacer == null){
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}else if(firstLaneRacer != null && secondLaneRacer == null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else if(firstLaneRacer == null && secondLaneRacer != null){
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText("No Finished Racer                          " + secondBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}else{	// both non-null
    					int firstBib = firstLaneRacer.getBib();
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          " + secondBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}
    			}else if(resultSplit[0].equals("0") && resultSplit[1].equals("3")){
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue12Finish();
    				Racer secondLaneRacer = chronotimer.getCurrentRun().getQueue78Finish();
    				if(firstLaneRacer == null && secondLaneRacer == null){
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}else if(firstLaneRacer != null && secondLaneRacer == null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else if(firstLaneRacer == null && secondLaneRacer != null){
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText("No Finished Racer                          " + secondBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}else{	// both non-null
    					int firstBib = firstLaneRacer.getBib();
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          " + secondBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}
    			}else if(resultSplit[0].equals("1") && resultSplit[1].equals("2")){
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue34Finish();
    				Racer secondLaneRacer = chronotimer.getCurrentRun().getQueue56Finish();
    				if(firstLaneRacer == null && secondLaneRacer == null){
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}else if(firstLaneRacer != null && secondLaneRacer == null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else if(firstLaneRacer == null && secondLaneRacer != null){
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText("No Finished Racer                          " + secondBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}else{	// both non-null
    					int firstBib = firstLaneRacer.getBib();
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          " + secondBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}
    			}else if(resultSplit[0].equals("1") && resultSplit[1].equals("3")){
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue34Finish();
    				Racer secondLaneRacer = chronotimer.getCurrentRun().getQueue78Finish();
    				if(firstLaneRacer == null && secondLaneRacer == null){
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}else if(firstLaneRacer != null && secondLaneRacer == null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else if(firstLaneRacer == null && secondLaneRacer != null){
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText("No Finished Racer                          " + secondBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}else{	// both non-null
    					int firstBib = firstLaneRacer.getBib();
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + "  " +chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          " + secondBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}
    			}else{
    				Racer firstLaneRacer = chronotimer.getCurrentRun().getQueue56Finish();
    				Racer secondLaneRacer = chronotimer.getCurrentRun().getQueue78Finish();
    				if(firstLaneRacer == null && secondLaneRacer == null){
    					displayLine8Label.setText("No Finished Racer                      No Finished Racer :F");
    				}else if(firstLaneRacer != null && secondLaneRacer == null){
    					int firstBib = firstLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          No Finished Racer :F");
    				}else if(firstLaneRacer == null && secondLaneRacer != null){
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText("No Finished Racer                          " + secondBib + " " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}else{	// both non-null
    					int firstBib = firstLaneRacer.getBib();
    					int secondBib = secondLaneRacer.getBib();
    					displayLine8Label.setText(firstBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(firstLaneRacer)) + "                          " + secondBib + "  " + chronotimer.getTimer().convertTime(currentStats.getRaceTime(secondLaneRacer)) + " :F");
    				}
    			}
		    }
		    
		    public void updateModel(){
		    	if(chronotimer.getPower() == false){
		    		displayCenterPanel.setBackground(Color.DARK_GRAY);
		    		displayLine1Label.setText("");
		    		displayLine2Label.setText("");
		    		displayLine3Label.setText("");
		    		displayLine4Label.setText("");
		    		displayLine5Label.setText("");
		    		displayLine6Label.setText("");
		    		displayLine7Label.setText("");
		    		displayLine8Label.setText("");
				}
		    	else if(displayFunction){
		    		String[] functions = new String[10];
		    		functions[0] = "RESET";
		    		functions[1] = "TIME";
		    		functions[2] = "EVENT";
		    		functions[3] = "NEWRUN";
		    		functions[4] = "ENDRUN";
		    		functions[5] = "PRINT";
		    		functions[6] = "EXPORT";
		    		functions[7] = "NUM";
		    		functions[8] = "CANCEL";
		    		functions[9] = "DNF";
		    		displayCenterPanel.setBackground(Color.WHITE);
		    		displayLine1Label.setText(functions[functionNum]);
		    		displayLine2Label.setText(functions[functionNum+1]);
		    		displayLine3Label.setText(functions[functionNum+2]);
		    		displayLine4Label.setText(functions[functionNum+3]);
		    		displayLine5Label.setText(functions[functionNum+4]);
		    		displayLine6Label.setText(functions[functionNum+5]);
		    		displayLine7Label.setText(functions[functionNum+6]);
		    		displayLine8Label.setText(functions[functionNum+7]);
		    		if(displayLine1Label.getText().equals(functions[selectedFunction])){
		    			displayLine1Label.setText(displayLine1Label.getText() + "  <--Selected");
		    		}
		    		if(displayLine2Label.getText().equals(functions[selectedFunction])){
		    			displayLine2Label.setText(displayLine2Label.getText() + "  <--Selected");
		    		}
		    		if(displayLine3Label.getText().equals(functions[selectedFunction])){
		    			displayLine3Label.setText(displayLine3Label.getText() + "  <--Selected");
		    		}
		    		if(displayLine4Label.getText().equals(functions[selectedFunction])){
		    			displayLine4Label.setText(displayLine4Label.getText() + "  <--Selected");
		    		}
		    		if(displayLine5Label.getText().equals(functions[selectedFunction])){
		    			displayLine5Label.setText(displayLine5Label.getText() + "  <--Selected");
		    		}
		    		if(displayLine6Label.getText().equals(functions[selectedFunction])){
		    			displayLine6Label.setText(displayLine6Label.getText() + "  <--Selected");
		    		}
		    		if(displayLine7Label.getText().equals(functions[selectedFunction])){
		    			displayLine7Label.setText(displayLine7Label.getText() + "  <--Selected");
		    		}
		    		if(displayLine8Label.getText().equals(functions[selectedFunction])){
		    			displayLine8Label.setText(displayLine8Label.getText() + "  <--Selected");
		    		}
		    	}
		    	else if(functionIsSelected && selectedFunction == 0){
		    		enterNum = false;
		    		finishedEnteringNum = false;
		    		functionIsSelected = false;
		    		currentNumPad = "";
		    		chronotimer.reset();
		    		boolean printerPower = chronotimer.getPrinterPower();
        			if(printerPower == true){
    		    		printerAddLine("Chronotimer has been reset");
        			}
		    	}
		    	else if(functionIsSelected && selectedFunction == 1){
		    		if(displayHours){
			    		displayLine1Label.setText(("Enter hour: "));
			    		displayLine2Label.setText(currentNumPad);
			    		displayLine3Label.setText("");
			    		displayLine4Label.setText("");
			    		displayLine5Label.setText("");
			    		displayLine6Label.setText("");
			    		displayLine7Label.setText("");
			    		displayLine8Label.setText("");
		    		}
		    		else if(displayMinutes){
		    			displayLine1Label.setText("Enter minute: ");
		    			displayLine2Label.setText(currentNumPad);
		    		}
		    		else if(displaySeconds){
		    			displayLine1Label.setText("Enter seconds: ");
		    			displayLine2Label.setText(currentNumPad);
		    		}		    		
		    	}
		    	else if(functionIsSelected && selectedFunction == 2){
		    		if(selectedEvent == 0){
		    			displayLine1Label.setText("IND  <--Selected");
		    		}
		    		else{
			    		displayLine1Label.setText("IND");
		    		}
		    		if(selectedEvent == 1){
		    			displayLine2Label.setText("PARIND  <--Selected");
		    		}
		    		else{
			    		displayLine2Label.setText("PARIND");
		    		}
		    		if(selectedEvent == 2){
		    			displayLine3Label.setText("GRP  <--Selected");
		    		}
		    		else{
			    		displayLine3Label.setText("GRP");
		    		}
		    		if(selectedEvent == 3){
		    			displayLine4Label.setText("PARGRP  <--Selected");
		    		}
		    		else{
			    		displayLine4Label.setText("PARGRP");
		    		}
		    		displayLine5Label.setText("");
		    		displayLine6Label.setText("");
		    		displayLine7Label.setText("");
		    		displayLine8Label.setText("");
		    	}
		    	else if(functionIsSelected && selectedFunction == 3){
		    		enterNum = false;
		    		finishedEnteringNum = false;
		    		functionIsSelected = false;
		    		currentNumPad = "";
		    		int result = chronotimer.newRun();
		    		boolean printerPower = chronotimer.getPrinterPower();
        			if(printerPower == true){
        				if(result == 0){
        					printerAddLine("New Run Has Not Been Added");
        				}else if(result == 1){
        					printerAddLine("New IND Run Added");
        				}else if(result == 2){
        					printerAddLine("New PARIND Run Added");
        				}else if(result == 3){
        					printerAddLine("New GRP Run Added");
        				}else if(result == 4){
        					printerAddLine("New PARGRP Run Added");
        				}else{
        					printerAddLine("New Run Has Not Been Added");
        				}
        			}
		    	}
		    	else if(functionIsSelected && selectedFunction == 4){
		    		enterNum = false;
		    		finishedEnteringNum = false;
		    		functionIsSelected = false;
		    		currentNumPad = "";
		    		boolean result = chronotimer.endRun(false);
		    		boolean printerPower = chronotimer.getPrinterPower();
        			if(printerPower == true){
        				if(result == true){
        					printerAddLine("Current Run Has Ended");
        				}else{
        					printerAddLine("A Current Run Has Not Been Ended");
        				}
        			}
		    	}
		    	else if(functionIsSelected && selectedFunction == 5){
		    		enterNum = false;
		    		finishedEnteringNum = false;
		    		functionIsSelected = false;
		    		currentNumPad = "";
		    		String returnString = chronotimer.print();
		    		boolean printerPower = chronotimer.getPrinterPower();
        			if(printerPower == true){
        				// Print the results on the printer paper (max of 10 lines)
        				String[] returnStringSplit = returnString.split("/");
        				int length = returnStringSplit.length;
        				int i = 0;
        				while(i < length){
        					printerAddLine(returnStringSplit[i]);
        					i++;
        				}
        			}
		    	}
		    	else if(functionIsSelected && selectedFunction == 6){
		    		enterNum = false;
		    		finishedEnteringNum = false;
		    		functionIsSelected = false;
		    		currentNumPad = "";
		    		boolean result = chronotimer.export("results.txt");
		    		boolean printerPower = chronotimer.getPrinterPower();
        			if(printerPower == true){
        				if(result == true){
        					printerAddLine("Results Have Been Exported To results.txt");
        				}else{
        					printerAddLine("The Results Have Not Been Exported");
        				}
        			}
		    	}
		    	else if(functionIsSelected && selectedFunction == 7){
		    		displayLine1Label.setText("Enter BIB Number:");
		    		displayLine2Label.setText(currentNumPad);
		    		displayLine3Label.setText("");
		    		displayLine4Label.setText("");
		    		displayLine5Label.setText("");
		    		displayLine6Label.setText("");
		    		displayLine7Label.setText("");
		    		displayLine8Label.setText("");
		    	}
		    	else if(functionIsSelected && selectedFunction == 8){
		    		enterNum = false;
		    		finishedEnteringNum = false;
		    		functionIsSelected = false;
		    		currentNumPad = "";
		    		int resultBibNumber = chronotimer.cancel();
		    		boolean printerPower = chronotimer.getPrinterPower();
        			if(printerPower == true){
        				if(resultBibNumber > 0){
        					printerAddLine("Canceled Racer: # " + resultBibNumber);
        				}else if(resultBibNumber == -3){
        					printerAddLine("Cancel Only Works in IND");
        				}else if(resultBibNumber == -1){
        					printerAddLine("No Racer Running To Cancel");
        				}else if(resultBibNumber == 0){
        					printerAddLine("No Current Run To Cancel From");
        				}
        			}
		    	}
		    	else if(functionIsSelected && selectedFunction == 9){
		    		enterNum = false;
		    		finishedEnteringNum = false;
		    		functionIsSelected = false;
		    		currentNumPad = "";
		    		int result = chronotimer.dnf();
		    		boolean printerPower = chronotimer.getPrinterPower();
        			if(printerPower == true){
        				if(result == -3){
        					printerAddLine("DNF Only Works in IND and PARIND");
        				}else if(result == -2){
        					printerAddLine("No Current Run In Progress");
        				}else if(result == 0){
        					printerAddLine("No Current Racer In Progress");
        				}else if(result > 0){
        					printerAddLine("Racer #"+ result + " Marked as DNF");
        				}
        			}
		    	}
		    	else{
					displayCenterPanel.setBackground(Color.WHITE);
					displayLine1Label.setText("");
		    		displayLine2Label.setText("");
		    		displayLine3Label.setText("");
		    		displayLine4Label.setText("");
		    		displayLine5Label.setText("");
		    		displayLine6Label.setText("");
		    		displayLine7Label.setText("");
		    		displayLine8Label.setText("");
		    		
		    		//TODO Figure out what to check for to prevent null reference exception.
		    		//if(chronotimer.getCurrentRun() != null && (!chronotimer.getCurrentRun().getStats().getRacers().isEmpty())){
		    		if(chronotimer.getCurrentRun() != null){
		    			Stats currentStats = chronotimer.getCurrentRun().getStats();	
		    			LinkedList<Racer> racerStartQueue = chronotimer.getCurrentRun().getBeginQueue();
		    			LinkedList<Racer> racerEndQueue = chronotimer.getCurrentRun().getEndQueue();
		    			ArrayList<Racer> racerQueue = chronotimer.getCurrentRun().getStats().getRacers();
		    			
		    			LinkedList<Racer> queue12 = chronotimer.getCurrentRun().getPendingQueue12();
		    			LinkedList<Racer> queue34 = chronotimer.getCurrentRun().getPendingQueue34();
		    			LinkedList<Racer> queue56 = chronotimer.getCurrentRun().getPendingQueue56();
		    			LinkedList<Racer> queue78 = chronotimer.getCurrentRun().getPendingQueue78();

		    			Long currentTime = 0L;
		    			Long currentTime2 = 0L;
		    			Long currentTime3 = 0L;
		    			Long currentTime4 = 0L;
		    			
			    		if(selectedEvent == 0){
			    			//IND //TODO May have to add logic for extra "current racers"
			    			//Show the next three to start, and current running racers, and the last racer to finish
			    			
			    			//No Racers to start and no current racers
			    			if(racerStartQueue.size() == 0 && racerEndQueue.size() == 0){
			    				displayLine1Label.setText("No Racer Queued");
					    		displayLine2Label.setText("No Racer Queued");
					    		displayLine3Label.setText("No Racer Queued :>");
					    		displayLine5Label.setText("No Current Racer :R");
					    		
					    		String lastRetValue = chronotimer.getLastToFinish();
					    		if(lastRetValue == null){
					    			displayLine8Label.setText("No Racers Have Finished");
					    		}else{
					    			displayLine8Label.setText(lastRetValue);
					    		}
			    			}
			    			//No racers to start
			    			else if(racerStartQueue.size() == 0){
					    		displayLine1Label.setText("No Racer Queued");
					    		displayLine2Label.setText("No Racer Queued");
					    		displayLine3Label.setText("No Racer Queued :>");
					    		if(chronotimer.getCurrentRun().getEndQueue().size() > 0){
					    			if(chronotimer.getCurrentRun().getEndQueue().size() == 1){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 2){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 3){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 4){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
						    			
						    			Racer currentRacer4 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+3);
						    			if(currentStats.getStart(currentRacer4) != -1){
						    				currentTime4 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer4);
						    			}
						    			displayLine7Label.setText(Integer.toString(currentRacer4.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime4) + " :R");
					    			}else{
					    				Racer currentRacer = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-4);
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-3);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
						    			
						    			Racer currentRacer4 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-1);
						    			if(currentStats.getStart(currentRacer4) != -1){
						    				currentTime4 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer4);
						    			}
						    			displayLine7Label.setText(Integer.toString(currentRacer4.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime4) + " :R");
					    			}
					    		}else{
					    			displayLine5Label.setText("No Current Racer :R");
					    		}
					    		
					    		String lastRetValue = chronotimer.getLastToFinish();
					    		if(lastRetValue == null){
					    			displayLine8Label.setText("No Racers Have Finished");
					    		}else{
					    			displayLine8Label.setText(lastRetValue);
					    		}
			    			}
			    			//1 racer to start 
			    			else if(racerStartQueue.size() == 1){
					    		displayLine1Label.setText("No Racer Queued");
					    		displayLine2Label.setText("No Racer Queued");
					    		displayLine3Label.setText(Integer.toString(racerStartQueue.get(0).getBib()) + " :>");
					    		
					    		if(chronotimer.getCurrentRun().getEndQueue().size() > 0){
					    			if(chronotimer.getCurrentRun().getEndQueue().size() == 1){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 2){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 3){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 4){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
						    			
						    			Racer currentRacer4 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+3);
						    			if(currentStats.getStart(currentRacer4) != -1){
						    				currentTime4 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer4);
						    			}
						    			displayLine7Label.setText(Integer.toString(currentRacer4.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime4) + " :R");
					    			}else{
					    				Racer currentRacer = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-4);
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-3);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
						    			
						    			Racer currentRacer4 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-1);
						    			if(currentStats.getStart(currentRacer4) != -1){
						    				currentTime4 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer4);
						    			}
						    			displayLine7Label.setText(Integer.toString(currentRacer4.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime4) + " :R");
					    			}
					    		}else{
					    			displayLine5Label.setText("No Current Racer :R");
					    		}
					    		
					    		String lastRetValue = chronotimer.getLastToFinish();
					    		if(lastRetValue == null){
					    			displayLine8Label.setText("No Racers Have Finished");
					    		}else{
					    			displayLine8Label.setText(lastRetValue);
					    		}
					    	}
			    			//2 racers to start
			    			else if(racerStartQueue.size() == 2){
					    		displayLine1Label.setText("No Racer Queued");
					    		displayLine2Label.setText(Integer.toString(racerStartQueue.get(1).getBib()));
					    		displayLine3Label.setText(Integer.toString(racerStartQueue.get(0).getBib()) + " :>");
					    		
					    		if(chronotimer.getCurrentRun().getEndQueue().size() > 0){
					    			if(chronotimer.getCurrentRun().getEndQueue().size() == 1){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 2){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 3){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 4){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
						    			
						    			Racer currentRacer4 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+3);
						    			if(currentStats.getStart(currentRacer4) != -1){
						    				currentTime4 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer4);
						    			}
						    			displayLine7Label.setText(Integer.toString(currentRacer4.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime4) + " :R");
					    			}else{
					    				Racer currentRacer = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-4);
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-3);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
						    			
						    			Racer currentRacer4 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-1);
						    			if(currentStats.getStart(currentRacer4) != -1){
						    				currentTime4 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer4);
						    			}
						    			displayLine7Label.setText(Integer.toString(currentRacer4.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime4) + " :R");
					    			}
					    		}else{
					    			displayLine5Label.setText("No Current Racer :R");
					    		}
					    		
					    		String lastRetValue = chronotimer.getLastToFinish();
					    		if(lastRetValue == null){
					    			displayLine8Label.setText("No Racers Have Finished");
					    		}else{
					    			displayLine8Label.setText(lastRetValue);
					    		}
					    	}
			    			//3 or more racers to start
			    			else{
					    		displayLine1Label.setText(Integer.toString(racerStartQueue.get(2).getBib()));
					    		displayLine2Label.setText(Integer.toString(racerStartQueue.get(1).getBib()));
					    		displayLine3Label.setText(Integer.toString(racerStartQueue.get(0).getBib()) + " :>");
					    		
					    		if(chronotimer.getCurrentRun().getEndQueue().size() > 0){
					    			if(chronotimer.getCurrentRun().getEndQueue().size() == 1){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 2){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 3){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
					    			}else if(chronotimer.getCurrentRun().getEndQueue().size() == 4){
					    				Racer currentRacer = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size());
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+1);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
						    			
						    			Racer currentRacer4 = racerQueue.get(racerQueue.size() - chronotimer.getCurrentRun().getEndQueue().size()+3);
						    			if(currentStats.getStart(currentRacer4) != -1){
						    				currentTime4 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer4);
						    			}
						    			displayLine7Label.setText(Integer.toString(currentRacer4.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime4) + " :R");
					    			}else{
					    				Racer currentRacer = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-4);
						    			if(currentStats.getStart(currentRacer) != -1){
						    				currentTime = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer);
						    			}
						    			displayLine4Label.setText(Integer.toString(currentRacer.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime) + " :R");
						    			
						    			Racer currentRacer2 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-3);
						    			if(currentStats.getStart(currentRacer2) != -1){
						    				currentTime2 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer2);
						    			}
						    			displayLine5Label.setText(Integer.toString(currentRacer2.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime2) + " :R");
						    			
						    			Racer currentRacer3 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-2);
						    			if(currentStats.getStart(currentRacer3) != -1){
						    				currentTime3 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer3);
						    			}
						    			displayLine6Label.setText(Integer.toString(currentRacer3.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime3) + " :R");
						    			
						    			Racer currentRacer4 = racerQueue.get(chronotimer.getCurrentRun().getEndQueue().size()-1);
						    			if(currentStats.getStart(currentRacer4) != -1){
						    				currentTime4 = chronotimer.getTimer().getCurrentTime() - currentStats.getStart(currentRacer4);
						    			}
						    			displayLine7Label.setText(Integer.toString(currentRacer4.getBib()) + " " + chronotimer.getTimer().convertTime(currentTime4) + " :R");
					    			}
					    		}else{
					    			displayLine5Label.setText("No Current Racer :R");
					    		}
					    		
					    		String lastRetValue = chronotimer.getLastToFinish();
					    		if(lastRetValue == null){
					    			displayLine8Label.setText("No Racers Have Finished");
					    		}else{
					    			displayLine8Label.setText(lastRetValue);
					    		}
					    	}
			    		}
			    		else if(selectedEvent == 1){
			    			//PARIND //TODO Finish PARIND
			    			//Show the next pair to run, running time of the racers, and finish times of the last pair to finish
					    	
			    			if(racerStartQueue.size() == 0){
					    		displayLine1Label.setText("No Queued Racer  /  No Queued Racer :>");
					    		
					    		// Print the current racers to the screen in the correct format
					    		pairIndCurrentRacer();
					    		
					    		// last pair of racers to finish in each lane
					    		parIndFinishPair();
			    			}
			    			//Pair of racers to start and current racer pair
			    			else{
			    				if(racerStartQueue.isEmpty()){
			    					displayLine1Label.setText("No Queued Racer  /  No Queued Racer :>");
			    				}else if(racerStartQueue.size() == 1){
			    					displayLine1Label.setText(racerStartQueue.get(0).getBib() + "  /  No Queued Racer :>");
			    				}else if(racerStartQueue.size() > 1){
			    					displayLine1Label.setText(racerStartQueue.get(0).getBib() + "  /  " + racerStartQueue.get(1).getBib() + " :>");
			    				}
			    				
			    				// Print the current racers to the screen in the correct format, lines 2-8
			    				pairIndCurrentRacer();
					    		
					    		// last pair of racers to finish in each lane, lines 2-8
			    				parIndFinishPair();
			    			}
			    		}
			    		else if(selectedEvent == 2){
			    			//PARGRP For Next Sprint
			    			if(chronotimer.getCurrentRun().getGroupStartTime() == -1){
			    				displayLine1Label.setText("Group Start Time:");
			    				displayLine2Label.setText("N/A");
			    				displayLine4Label.setText("Current Running Time:");
			    				displayLine5Label.setText("N/A");
			    				displayLine7Label.setText("Last Finish:");
			    				displayLine8Label.setText("N/A");
			    			}
			    			else{
			    				displayLine1Label.setText("Group Start Time:");
			    				displayLine2Label.setText(Time.convertTime(chronotimer.getCurrentRun().getGroupStartTime()));
			    				displayLine4Label.setText("Current Running Time:");
			    				displayLine5Label.setText(Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()));
			    				displayLine7Label.setText("Last Finish:");
			    				if(chronotimer.getCurrentRun().getLastGroupFinish() == -1){
			    					displayLine8Label.setText("N/A");
			    				}
			    				else{
			    					displayLine8Label.setText(Time.convertTime(chronotimer.getCurrentRun().getLastGroupFinish()));
			    				}
			    			}
			    		}
						else if(selectedEvent == 3){
							if(chronotimer.getCurrentRun().getGroupStartTime() == -1){
								if(racerStartQueue.size() == 0){
									displayLine1Label.setText("L1: No Current Racer :R");
									displayLine2Label.setText("L2: No Current Racer :R");
									displayLine3Label.setText("L3: No Current Racer :R");
									displayLine4Label.setText("L4: No Current Racer :R");
									displayLine5Label.setText("L5: No Current Racer :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 1){
									displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + " :R");
									displayLine2Label.setText("L2: No Current Racer :R");
									displayLine3Label.setText("L3: No Current Racer :R");
									displayLine4Label.setText("L4: No Current Racer :R");
									displayLine5Label.setText("L5: No Current Racer :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 2){
									displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + " :R");
									displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + " :R");
									displayLine3Label.setText("L3: No Current Racer :R");
									displayLine4Label.setText("L4: No Current Racer :R");
									displayLine5Label.setText("L5: No Current Racer :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 3){
									displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + " :R");
									displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + " :R");
									displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + " :R");
									displayLine4Label.setText("L4: No Current Racer :R");
									displayLine5Label.setText("L5: No Current Racer :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 4){
									displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + " :R");
									displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + " :R");
									displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + " :R");
									displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + " :R");
									displayLine5Label.setText("L5: No Current Racer :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 5){
									displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + " :R");
									displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + " :R");
									displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + " :R");
									displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + " :R");
									displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + " :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 6){
									displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + " :R");
									displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + " :R");
									displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + " :R");
									displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + " :R");
									displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + " :R");
									displayLine6Label.setText("L6: " + racerStartQueue.get(5).getBib() + " :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 7){
									displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + " :R");
									displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + " :R");
									displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + " :R");
									displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + " :R");
									displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + " :R");
									displayLine6Label.setText("L6: " + racerStartQueue.get(5).getBib() + " :R");
									displayLine7Label.setText("L7: " + racerStartQueue.get(6).getBib() + " :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else{
									displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + " :R");
									displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + " :R");
									displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + " :R");
									displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + " :R");
									displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + " :R");
									displayLine6Label.setText("L6: " + racerStartQueue.get(5).getBib() + " :R");
									displayLine7Label.setText("L7: " + racerStartQueue.get(6).getBib() + " :R");
									displayLine8Label.setText("L8: " + racerStartQueue.get(7).getBib() + " :R");
								}
							}else{
								if(racerStartQueue.size() == 1){
									if(currentStats.getEnd(racerStartQueue.get(0)) == -1){
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(0)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									displayLine2Label.setText("L2: No Current Racer :R");
									displayLine3Label.setText("L3: No Current Racer :R");
									displayLine4Label.setText("L4: No Current Racer :R");
									displayLine5Label.setText("L5: No Current Racer :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 2){
									if(currentStats.getEnd(racerStartQueue.get(0)) == -1){
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(0)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(1)) == -1){
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(1)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									displayLine3Label.setText("L3: No Current Racer :R");
									displayLine4Label.setText("L4: No Current Racer :R");
									displayLine5Label.setText("L5: No Current Racer :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 3){
									if(currentStats.getEnd(racerStartQueue.get(0)) == -1){
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(0)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(1)) == -1){
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(1)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(2)) == -1){
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(2)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									displayLine4Label.setText("L4: No Current Racer :R");
									displayLine5Label.setText("L5: No Current Racer :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 4){
									if(currentStats.getEnd(racerStartQueue.get(0)) == -1){
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(0)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(1)) == -1){
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(1)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(2)) == -1){
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(2)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(3)) == -1){
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(3)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									displayLine5Label.setText("L5: No Current Racer :R");
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 5){
									if(currentStats.getEnd(racerStartQueue.get(0)) == -1){
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(0)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(1)) == -1){
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(1)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(2)) == -1){
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(2)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(3)) == -1){
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(3)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(4)) == -1){
										displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(4)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									displayLine6Label.setText("L6: No Current Racer :R");
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 6){
									if(currentStats.getEnd(racerStartQueue.get(0)) == -1){
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(0)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(1)) == -1){
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(1)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(2)) == -1){
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(2)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(3)) == -1){
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(3)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(4)) == -1){
										displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(4)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(5)) == -1){
										displayLine6Label.setText("L6: " + racerStartQueue.get(5).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine6Label.setText("L6: " + racerStartQueue.get(5).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(5)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									displayLine7Label.setText("L7: No Current Racer :R");
									displayLine8Label.setText("L8: No Current Racer :R");
								}else if(racerStartQueue.size() == 7){
									if(currentStats.getEnd(racerStartQueue.get(0)) == -1){
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(0)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(1)) == -1){
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(1)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(2)) == -1){
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(2)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(3)) == -1){
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(3)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(4)) == -1){
										displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(4)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(5)) == -1){
										displayLine6Label.setText("L6: " + racerStartQueue.get(5).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine6Label.setText("L6: " + racerStartQueue.get(5).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(5)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(6)) == -1){
										displayLine7Label.setText("L7: " + racerStartQueue.get(6).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine7Label.setText("L7: " + racerStartQueue.get(6).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(6)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									displayLine8Label.setText("L8: No Current Racer :R");
								}else{
									if(currentStats.getEnd(racerStartQueue.get(0)) == -1){
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine1Label.setText("L1: " + racerStartQueue.get(0).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(0)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(1)) == -1){
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine2Label.setText("L2: " + racerStartQueue.get(1).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(1)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(2)) == -1){
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine3Label.setText("L3: " + racerStartQueue.get(2).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(2)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(3)) == -1){
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine4Label.setText("L4: " + racerStartQueue.get(3).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(3)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(4)) == -1){
										displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine5Label.setText("L5: " + racerStartQueue.get(4).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(4)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(5)) == -1){
										displayLine6Label.setText("L6: " + racerStartQueue.get(5).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine6Label.setText("L6: " + racerStartQueue.get(5).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(5)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(6)) == -1){
										displayLine7Label.setText("L7: " + racerStartQueue.get(6).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine7Label.setText("L7: " + racerStartQueue.get(6).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(6)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									if(currentStats.getEnd(racerStartQueue.get(7)) == -1){
										displayLine8Label.setText("L8: " + racerStartQueue.get(7).getBib() + Time.convertTime(chronotimer.getTimer().getCurrentTime() - chronotimer.getCurrentRun().getGroupStartTime()) + " :R");
									}else{
										displayLine8Label.setText("L8: " + racerStartQueue.get(7).getBib() + Time.convertTime(currentStats.getEnd(racerStartQueue.get(7)) - chronotimer.getCurrentRun().getGroupStartTime()) + " :F");
									}
									
								}
							}
						}
		    		}
				}
			}
		});
		
		timer.setRepeats(true);
		timer.start();
		
		// Action Listeners
		powerBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(!chronotimer.getPower()){
	        		System.out.println("CHRONOTIMER POWERED ON");
	        	}
	        	else{
	        		System.out.println("CHRONOTIMER POWERED OFF");
	        	}
	        	chronotimer.power();
	        	displayFunction = false;
	        	selectedEvent = 0;
	        	selectedFunction = 0;
	        }
	    });
		swapBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(chronotimer.getPrinterPower() == true){
	        		if(chronotimer.swap()){
						printerAddLine("First Two Racers Have Been Swapped");
	        		}
	        		else{
						printerAddLine("Unable To Swap");
	        		}
				}
	        }
	    });
		functionBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean pwr = chronotimer.getPower();
				if(pwr == true){
					functionIsSelected = false;
					if(!displayFunction){
						functionNum = 0;
						selectedFunction = 0;
					}
					displayFunction = !displayFunction;
				}
			}
		});
		
		upArrowBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(functionIsSelected && (selectedFunction == 2 || selectedFunction == 3) && selectedEvent == 0){
					return;
				}
				if(functionIsSelected && (selectedFunction == 2 || selectedFunction == 3) && selectedEvent != 0){
					selectedEvent--;
					return;
				}
				if(functionNum != 0){
					functionNum--;
				}
				if(selectedFunction != 0){
					selectedFunction--;
				}
			}
		});
		
		downArrowBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(functionIsSelected && (selectedFunction == 2 || selectedFunction == 3) && selectedEvent == 3){
					return;
				}
				if(functionIsSelected && (selectedFunction == 2 || selectedFunction == 3) && selectedEvent != 3){
					selectedEvent++;
					return;
				}
				if(functionNum < 2){
					functionNum++;
				}
				if(selectedFunction < 9){
					selectedFunction++;
				}
			}
		});
		
		printerPwrBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean printerTurnedOn = chronotimer.printerPower();
	        		if(printerTurnedOn == true){
	        			printerAddLine("Printer Turned On");
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		enaDis1Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean channelState = chronotimer.toggleChannel("1");
	        		if(channelState == true){
	        			Channel channel1 = chronotimer.getChannelOne();
	        			if(channel1.getOn() == true){
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 1 Toggled On");
	        				}
	        			}else{
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 1 Toggled Off");
	        				}
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		enaDis2Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean channelState = chronotimer.toggleChannel("2");
	        		if(channelState == true){
	        			Channel channel2 = chronotimer.getChannelTwo();
	        			if(channel2.getOn() == true){
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 2 Toggled On");
	        				}
	        			}else{
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 2 Toggled Off");
	        				}
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		enaDis3Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean channelState = chronotimer.toggleChannel("3");
	        		if(channelState == true){
	        			Channel channel3 = chronotimer.getChannelThree();
	        			if(channel3.getOn() == true){
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 3 Toggled On");
	        				}
	        			}else{
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 3 Toggled Off");
	        				}
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		enaDis4Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean channelState = chronotimer.toggleChannel("4");
	        		if(channelState == true){
	        			Channel channel4 = chronotimer.getChannelFour();
	        			if(channel4.getOn() == true){
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 4 Toggled On");
	        				}
	        			}else{
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 4 Toggled Off");
	        				}
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		enaDis5Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean channelState = chronotimer.toggleChannel("5");
	        		if(channelState == true){
	        			Channel channel5 = chronotimer.getChannelFive();
	        			if(channel5.getOn() == true){
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 5 Toggled On");
	        				}
	        			}else{
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 5 Toggled Off");
	        				}
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		enaDis6Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean channelState = chronotimer.toggleChannel("6");
	        		if(channelState == true){
	        			Channel channel6 = chronotimer.getChannelSix();
	        			if(channel6.getOn() == true){
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 6 Toggled On");
	        				}
	        			}else{
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 6 Toggled Off");
	        				}
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		enaDis7Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean channelState = chronotimer.toggleChannel("7");
	        		if(channelState == true){
	        			Channel channel7 = chronotimer.getChannelSeven();
	        			if(channel7.getOn() == true){
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 7 Toggled On");
	        				}
	        			}else{
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 7 Toggled Off");
	        				}
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		enaDis8Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean channelState = chronotimer.toggleChannel("8");
	        		if(channelState == true){
	        			Channel channel8 = chronotimer.getChannelEight();
	        			if(channel8.getOn() == true){
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 8 Toggled On");
	        				}
	        			}else{
	        				if(chronotimer.getPrinterPower() == true){
	        					printerAddLine("Channel 8 Toggled Off");
	        				}
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		channel1Button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean sensorConnected = chronotimer.getChannelOne().getConnectedSensor();
	        		if(sensorConnected == false){
	        			chronotimer.connectChannelSensor("1");
	        			channelInputMenu.show(channel1Button, channel1Button.getWidth()/2, channel1Button.getHeight()/2);
	        			channel1Button.setBackground(Color.GREEN);
	        		}else{
	        			chronotimer.connectChannelSensor("1");
	        			channel1Button.setBackground(Color.RED);
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		channel2Button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean sensorConnected = chronotimer.getChannelTwo().getConnectedSensor();
	        		if(sensorConnected == false){
	        			chronotimer.connectChannelSensor("2");
	        			channelInputMenu.show(channel2Button, channel2Button.getWidth()/2, channel2Button.getHeight()/2);
	        			channel2Button.setBackground(Color.GREEN);
	        		}else{
	        			chronotimer.connectChannelSensor("2");
	        			channel2Button.setBackground(Color.RED);
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		channel3Button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean sensorConnected = chronotimer.getChannelThree().getConnectedSensor();
	        		if(sensorConnected == false){
	        			chronotimer.connectChannelSensor("3");
	        			channelInputMenu.show(channel3Button, channel3Button.getWidth()/2, channel3Button.getHeight()/2);
	        			channel3Button.setBackground(Color.GREEN);
	        		}else{
	        			chronotimer.connectChannelSensor("3");
	        			channel3Button.setBackground(Color.RED);
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		channel4Button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean sensorConnected = chronotimer.getChannelFour().getConnectedSensor();
	        		if(sensorConnected == false){
	        			chronotimer.connectChannelSensor("4");
	        			channelInputMenu.show(channel4Button, channel4Button.getWidth()/2, channel4Button.getHeight()/2);
	        			channel4Button.setBackground(Color.GREEN);
	        		}else{
	        			chronotimer.connectChannelSensor("4");
	        			channel4Button.setBackground(Color.RED);
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		channel5Button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean sensorConnected = chronotimer.getChannelFive().getConnectedSensor();
	        		if(sensorConnected == false){
	        			chronotimer.connectChannelSensor("5");
	        			channelInputMenu.show(channel5Button, channel5Button.getWidth()/2, channel5Button.getHeight()/2);
	        			channel5Button.setBackground(Color.GREEN);
	        		}else{
	        			chronotimer.connectChannelSensor("5");
	        			channel5Button.setBackground(Color.RED);
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		channel6Button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean sensorConnected = chronotimer.getChannelSix().getConnectedSensor();
	        		if(sensorConnected == false){
	        			chronotimer.connectChannelSensor("6");
	        			channelInputMenu.show(channel6Button, channel6Button.getWidth()/2, channel6Button.getHeight()/2);
	        			channel6Button.setBackground(Color.GREEN);
	        		}else{
	        			chronotimer.connectChannelSensor("6");
	        			channel6Button.setBackground(Color.RED);
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		channel7Button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean sensorConnected = chronotimer.getChannelSeven().getConnectedSensor();
	        		if(sensorConnected == false){
	        			chronotimer.connectChannelSensor("7");
	        			channelInputMenu.show(channel7Button, channel7Button.getWidth()/2, channel7Button.getHeight()/2);
	        			channel7Button.setBackground(Color.GREEN);
	        		}else{
	        			chronotimer.connectChannelSensor("7");
	        			channel7Button.setBackground(Color.RED);
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		channel8Button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean sensorConnected = chronotimer.getChannelEight().getConnectedSensor();
	        		if(sensorConnected == false){
	        			chronotimer.connectChannelSensor("8");
	        			channelInputMenu.show(channel8Button, channel8Button.getWidth()/2, channel8Button.getHeight()/2);
	        			channel8Button.setBackground(Color.GREEN);
	        		}else{
	        			chronotimer.connectChannelSensor("8");
	        			channel8Button.setBackground(Color.RED);
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad0Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "0";
	        	}
	        }
	    });
		
		numPad1Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "1";
	        	}
	        }
	    });
		
		numPad2Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "2";
	        	}
	        }
	    });
		
		numPad3Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "3";
	        	}
	        }
	    });
		
		numPad4Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "4";
	        	}
	        }
	    });
		
		numPad5Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "5";
	        	}
	        }
	    });
		
		numPad6Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "6";
	        	}
	        }
	    });
		
		numPad7Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "7";
	        	}
	        }
	    });
		
		numPad8Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "8";
	        	}
	        }
	    });
		
		numPad9Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad += "9";
	        	}
	        }
	    });
		
		numPadAstBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	if(enterNum){
	        		currentNumPad = "";
	        	}
	        }
	    });
		
		numPadPoundBtn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	if(displayFunction){
		        		functionIsSelected = true;
		        		displayFunction = false;
		        		if(functionIsSelected && selectedFunction == 1){
		        			displayHours = true;
		        			enterNum = true;
		        		}
		        		if(functionIsSelected && selectedFunction == 7){
		        			enterNum = true;
		        		}
		        	}
		        	else if(functionIsSelected && selectedFunction == 1){
		        		if(displayHours){
		        			if(!(currentNumPad.equals(""))){
		        				int hours = Integer.parseInt(currentNumPad);
		        				if(hours > 24){
		        					displayHours = true;
		        					displayMinutes = false;
		        					displaySeconds = false;
		        				}else{
		        					if(hours < 10){
		        						if(currentNumPad.length() == 1){
		        							String tmp = currentNumPad;
		        							currentNumPad = "0" + tmp;
		        						}
		        					}
		        					displayMinutes = true;
		        					displayHours = false;
		        					displaySeconds = false;
		        					enteredTime = currentNumPad;
		        				}
		        				currentNumPad = "";
		        			}
		        		}
		        		else if(displayMinutes){
		        			if(!(currentNumPad.equals(""))){
		        				int minutes = Integer.parseInt(currentNumPad);
		        				if(minutes > 60){
		        					displayMinutes = true;
		        					displayHours = false;
		        					displaySeconds = false;
		        				}else{
		        					if(minutes< 10){
		        						if(currentNumPad.length() == 1){
		        							String tmp = currentNumPad;
		        							currentNumPad = "0" + tmp;
		        						}
		        					}
		        					displaySeconds = true;
		        					displayMinutes = false;
		        					displayHours = false;
		        					enteredTime += ":" + currentNumPad;
		        				}
		        				currentNumPad = "";
		        			}
		        		}
		        		else if(displaySeconds){
		        			if(!(currentNumPad.equalsIgnoreCase(""))){
		        				int seconds = Integer.parseInt(currentNumPad);
		        				if(seconds > 60){
		        					displaySeconds = true;
		        					displayMinutes = false;
		        					displayHours = false;
		        				}else{
		        					if(seconds< 10){
		        						if(currentNumPad.length() == 1){
		        							String tmp = currentNumPad;
		        							currentNumPad = "0" + tmp;
		        						}
		        					}
		        					functionIsSelected = false;
		        					enteredTime += ":" + currentNumPad;
		        					boolean printerPower = chronotimer.getPrinterPower();
		        					
		        					if(printerPower == true && chronotimer.setTime(enteredTime)){
		        						printerAddLine("Entered time: " + enteredTime);
		        					}
		        					else{
		        						printerAddLine("Cannot enter time while there is a current run");
		        					}
		        					enteredTime = "";
		        					enterNum = false;
		        				}
		        				currentNumPad = "";
		        			}
		        		}	        		
		        	}
		        	else if(functionIsSelected && selectedFunction == 2){
		        		if(selectedEvent == 0){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true && chronotimer.setEvent("IND")){
		        				printerAddLine("Event set to IND");		        			
		        			}
		        			else{
		        				if(chronotimer.getPrinterPower() == true){
		        					printerAddLine("Only Set Event Before Starting a Run");
		        				}
		        			}
		        		}
		        		else if(selectedEvent == 1){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true && chronotimer.setEvent("PARIND")){
		        				printerAddLine("Event set to PARIND");	        			
		        			}
			        		else{
			        			if(chronotimer.getPrinterPower() == true){
		        					printerAddLine("Only Set Event Before Starting a Run");
		        				}        			
			        		}
		        		}
		        		else if(selectedEvent == 2){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true && chronotimer.setEvent("GRP")){
		        				printerAddLine("Event set to GRP");	        			
		        			}
			        		else{
		        				if(chronotimer.getPrinterPower() == true){
		        					printerAddLine("Only Set Event Before Starting a Run");
		        				}	        			
			        		}
		        		}
		        		else if(selectedEvent == 3){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true && chronotimer.setEvent("PARGRP")){
		        				printerAddLine("Event set to PARGRP");	        			
		        			}
			        		else{
			        			if(chronotimer.getPrinterPower() == true){
		        					printerAddLine("Only Set Event Before Starting a Run");
		        				}	        			
			        		}
		        		}
		        		functionIsSelected = false;
		        	}
		        	else if(functionIsSelected && selectedFunction == 7){
		        		int result = chronotimer.num(currentNumPad);
		        		boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				if(result == 1){
	        					printerAddLine("BIB #" + currentNumPad + " Has Been Entered");
	        				}else if(result == 0){
	        					printerAddLine("Racer With BIB #"+ currentNumPad+ " Not Added");
	        				}else if(result == -2){
	        					printerAddLine("No Current Run To Add The Racer To");
	        				}else if(result == -3){
	        					printerAddLine("A Racer Already Has BIB #" + currentNumPad);
	        				}else if(result == -4){
	        					printerAddLine("No BIB Number Entered");
	        				}
	        			}
		        		currentNumPad = "";
		        		functionIsSelected = false;
		        	}
		        }
		});
		
		start1Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNum = chronotimer.trigger("1");
		        		if(bibNum == 0){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Could Not Trigger Channel 1");
		        			}
		        		}else if(bibNum == 11111){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Group has started");
		        			}
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = "BIB# " + bibNum + " start";
				        		printerAddLine(toPrint);
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
		
		start3Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNum = chronotimer.trigger("3");
		        		if(bibNum == 0){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Could Not Trigger Channel 3");
		        			}
		        		}else if(bibNum == 11111){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Group has started");
		        			}
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = "BIB# " + bibNum + " start";
				        		printerAddLine(toPrint);
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
		
		start5Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNum = chronotimer.trigger("5");
		        		if(bibNum == 0){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Could Not Trigger Channel 5");
		        			}
		        		}else if(bibNum == 11111){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Group has started");
		        			}
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = "BIB# " + bibNum + " start";
				        		printerAddLine(toPrint);
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
		
		start7Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNum = chronotimer.trigger("7");
		        		if(bibNum == 0){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Could Not Trigger Channel 7");
		        			}
		        		}else if(bibNum == 11111){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Group has started");
		        			}
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = "BIB# " + bibNum + " start";
				        		printerAddLine(toPrint);
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
		
		finish2Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNum = chronotimer.trigger("2");
		        		if(bibNum == 0){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Could Not Trigger Channel 2");
		        			}
		        		}else if(bibNum == 11111){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Group racer has finished");
		        			}
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = "BIB# " + bibNum + " finish";
		        				printerAddLine(toPrint);
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
		
		finish4Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNum = chronotimer.trigger("4");
		        		if(bibNum == 0){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Could Not Trigger Channel 4");
		        			}
		        		}else if(bibNum == 11111){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Group racer has finished");
		        			}
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = "BIB# " + bibNum + " finish";
		        				printerAddLine(toPrint);
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
		
		finish6Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNum = chronotimer.trigger("6");
		        		if(bibNum == 0){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Could Not Trigger Channel 6");
		        			}
		        		}else if(bibNum == 11111){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Group racer has finished");
		        			}
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = "BIB# " + bibNum + " finish";
		        				printerAddLine(toPrint);
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
		
		finish8Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNum = chronotimer.trigger("8");
		        		if(bibNum == 0){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Could Not Trigger Channel 8");
		        			}
		        		}else if(bibNum == 11111){
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
				        		printerAddLine("Group racer has finished");
		        			}
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = "BIB# " + bibNum + " finish";
		        				printerAddLine(toPrint);
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
	}
}