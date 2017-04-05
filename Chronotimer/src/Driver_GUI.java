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

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Driver_GUI extends JFrame{
	
	public static void main(String[] args){
		Driver_GUI myGUI = new Driver_GUI();
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
		
		
		// Action Listeners
		powerBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		chronotimer.power();
					if(chronotimer.getPower() == true){
						displayCenterPanel.setBackground(Color.WHITE);
						displayLine1Label.setText(" ");
						displayLine2Label.setText(" ");
						displayLine3Label.setText(" ");
						displayLine4Label.setText(" ");
						displayLine5Label.setText(" ");
						displayLine6Label.setText(" ");
						displayLine7Label.setText(" ");
						displayLine8Label.setText(" ");
					}else{
						displayCenterPanel.setBackground(Color.DARK_GRAY);
						displayLine1Label.setText(" ");
						displayLine2Label.setText(" ");
						displayLine3Label.setText(" ");
						displayLine4Label.setText(" ");
						displayLine5Label.setText(" ");
						displayLine6Label.setText(" ");
						displayLine7Label.setText(" ");
						displayLine8Label.setText(" ");
					}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
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
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("0");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("0 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad1Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("1");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("1 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad2Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("2");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("2 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad3Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("3");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("3 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad4Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("4");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("4 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad5Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("5");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("5 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad6Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("6");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("6 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad7Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("7");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("7 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad8Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("8");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("8 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPad9Btn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean bibNumEnter = chronotimer.addToBibNumberString("9");
	        		if(bibNumEnter == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("9 added to Bib Number to Queue");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPadAstBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e){
	        	try {
	        		boolean clearedString = chronotimer.clearBibNumberString();
	        		if(clearedString == true){
	        			boolean printerPower = chronotimer.getPrinterPower();
	        			if(printerPower == true){
	        				printerAddLine("Bib # to Queue Cleared");
	        			}
	        		}
	    		} catch (Exception e2) {
	    			e2.printStackTrace();
	    		}
	        }
	    });
		
		numPadPoundBtn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNumbAdded = chronotimer.numFromKeypad();
		        		if(bibNumbAdded != 0){
		        			String toPrintString = "Bib Num: " + bibNumbAdded + " Added to Run";
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				printerAddLine(toPrintString);
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
		
		start1Btn.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e){
		        	try {
		        		int bibNum = chronotimer.trigger("1");
		        		if(bibNum == 0){
		        			// Not valid start
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = bibNum + " start";
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
		        			// Not valid start
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = bibNum + " start";
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
		        			// Not valid start
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = bibNum + " start";
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
		        			// Not valid start
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = bibNum + " start";
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
		        			// Not valid start
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = bibNum + " finish";
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
		        			// Not valid start
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = bibNum + " finish";
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
		        			// Not valid start
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = bibNum + " finish";
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
		        			// Not valid start
		        		}else{
		        			boolean printerPower = chronotimer.getPrinterPower();
		        			if(printerPower == true){
		        				String toPrint = bibNum + " finish";
		        			}
		        		}
		    		} catch (Exception e2) {
		    			e2.printStackTrace();
		    		}
		        }
		});
	}
}
