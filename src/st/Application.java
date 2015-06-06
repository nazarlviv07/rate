package st;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import st.type.Result;

public class Application extends Applet implements Runnable {
	String[] kontoraStrings = { "betcity", "favbet", "fonbet" };

	public static final long serialVersionUID = 42L;
	public boolean isRunning = true;
	public boolean isWaiting = false;
	public boolean forkHaveBeenFoundInPreviousAttempt = false;
	private Object event = new Object();

	public JLabel labelVersionOfProgram = new JLabel(
			"Версія Програми #: 1      Дата оновлення програми: 06-06-2015 ");
	public JLabel labelEmpty_1 = new JLabel(" ");
	public JLabel labelEmpty_2 = new JLabel(" ");
	public JLabel labelEmpty_3 = new JLabel(" ");
	public String kontora1Number = new String();
	public String kontora2Number = new String();
	public String percentageNumber = new String("1");
	public JLabel labelPercentage = new JLabel("Процент виграшу % ");

	public JLabel labelFork = new JLabel("Вилка");
	public JLabel labelNameOfFork = new JLabel(" Назва коефіцієнта");
	public JLabel labelKoefForFork = new JLabel(" Коефіцієнт");
	public JLabel labelStavka = new JLabel(" Ставка");
	public JLabel labelVugraw = new JLabel(" Виграш");
	public JLabel label4ustuyVugraw = new JLabel(" Чистий виграш");
	public JLabel labelResultFork = new JLabel("------");
	public JLabel labelResultNameOfKoefKontora1 = new JLabel("------");
	public JLabel labelResultNameOfKoefKontora2 = new JLabel("------");
	public JLabel labelKoefKontora1 = new JLabel("------");
	public JLabel labelKoefKontora2 = new JLabel("------");
	public JLabel labelNameOfKontora1_1 = new JLabel("-----");
	public JLabel labelNameOfKontora1_2 = new JLabel("-----");
	public JLabel labelNameOfKontora1_3 = new JLabel("-----");
	public JLabel labelNameOfKontora1_4 = new JLabel("-----");
	public JLabel labelNameOfKontora2_1 = new JLabel("-----");
	public JLabel labelNameOfKontora2_2 = new JLabel("-----");
	public JLabel labelNameOfKontora2_3 = new JLabel("-----");
	public JLabel labelNameOfKontora2_4 = new JLabel("-----");
	public JLabel labelStavkaKontora1 = new JLabel("------");
	public JLabel labelStavkaKontora2 = new JLabel("------");
	public JLabel labelVugrawKontora1 = new JLabel("------");
	public JLabel labelVugrawKontora2 = new JLabel("------");
	public JLabel label4ustuyVugrawKontora1 = new JLabel("------");
	public JLabel label4ustuyVugrawKontora2 = new JLabel("------");
	public JLabel labelProgres = new JLabel(
			"Прогрес --> Програма стартувала успішно");

	public JButton startButton = new JButton("Start");
	public JButton stopButton = new JButton("Stop");
	public JButton testButton = new JButton("Test");
	public JFrame frame = new JFrame("Stavki");

	public Result result = new Result();

	public JTextField kontora1TextField = new JTextField();
	public JTextField kontora2TextField = new JTextField();
	public JTextField percentageTextField = new JTextField("0.1");

	// Koefizientu
	public JLabel label_kontora1 = new JLabel("---");
	public JLabel label_kontora2 = new JLabel("---");
	public JLabel label_name_of_command_1 = new JLabel("Команда1");
	public JLabel label_name_of_command_1_kontora1 = new JLabel("---");
	public JLabel label_name_of_command_1_kontora2 = new JLabel("---");
	public JLabel label_name_of_command_2 = new JLabel("Команда2");
	public JLabel label_name_of_command_2_kontora1 = new JLabel("---");
	public JLabel label_name_of_command_2_kontora2 = new JLabel("---");
	public JLabel label_1 = new JLabel("1");
	public JLabel label_1_kontora1 = new JLabel("---");
	public JLabel label_1_kontora2 = new JLabel("---");
	public JLabel label_X = new JLabel("X");
	public JLabel label_X_kontora1 = new JLabel("---");
	public JLabel label_X_kontora2 = new JLabel("---");
	public JLabel label_2 = new JLabel("2");
	public JLabel label_2_kontora1 = new JLabel("---");
	public JLabel label_2_kontora2 = new JLabel("---");
	public JLabel label_1X = new JLabel("1X");
	public JLabel label_1X_kontora1 = new JLabel("---");
	public JLabel label_1X_kontora2 = new JLabel("---");
	public JLabel label_12 = new JLabel("12");
	public JLabel label_12_kontora1 = new JLabel("---");
	public JLabel label_12_kontora2 = new JLabel("---");
	public JLabel label_X2 = new JLabel("X2");
	public JLabel label_X2_kontora1 = new JLabel("---");
	public JLabel label_X2_kontora2 = new JLabel("---");
	public JLabel label_Total_1 = new JLabel("Тотал");
	public JLabel label_Total_2 = new JLabel("Тотал");
	public JLabel label_Total_1_kontora1 = new JLabel("---");
	public JLabel label_Total_2_kontora1 = new JLabel("---");
	public JLabel label_Total_1_kontora2 = new JLabel("---");
	public JLabel label_Total_2_kontora2 = new JLabel("---");
	public JLabel label_Total_Menwe_1 = new JLabel("Менше");
	public JLabel label_Total_Menwe_2 = new JLabel("Менше");
	public JLabel label_Total_Menwe_1_kontora1 = new JLabel("---");
	public JLabel label_Total_Menwe_2_kontora1 = new JLabel("---");
	public JLabel label_Total_Menwe_1_kontora2 = new JLabel("---");
	public JLabel label_Total_Menwe_2_kontora2 = new JLabel("---");
	public JLabel label_Total_Bilwe_1 = new JLabel("Більше");
	public JLabel label_Total_Bilwe_2 = new JLabel("Більше");
	public JLabel label_Total_Bilwe_1_kontora1 = new JLabel("---");
	public JLabel label_Total_Bilwe_2_kontora1 = new JLabel("---");
	public JLabel label_Total_Bilwe_1_kontora2 = new JLabel("---");
	public JLabel label_Total_Bilwe_2_kontora2 = new JLabel("---");
	public JLabel label_Fora1_1 = new JLabel("Фора1");
	public JLabel label_Fora1_2 = new JLabel("Фора1");
	public JLabel label_Fora1_1_kontora1 = new JLabel("---");
	public JLabel label_Fora1_2_kontora1 = new JLabel("---");
	public JLabel label_Fora1_1_kontora2 = new JLabel("---");
	public JLabel label_Fora1_2_kontora2 = new JLabel("---");
	public JLabel label_Koef_For_Fora1_1 = new JLabel("Коеф");
	public JLabel label_Koef_For_Fora1_2 = new JLabel("Коеф");
	public JLabel label_Koef_For_Fora1_1_kontora1 = new JLabel("---");
	public JLabel label_Koef_For_Fora1_2_kontora1 = new JLabel("---");
	public JLabel label_Koef_For_Fora1_1_kontora2 = new JLabel("---");
	public JLabel label_Koef_For_Fora1_2_kontora2 = new JLabel("---");
	public JLabel label_Fora2_1 = new JLabel("Фора2");
	public JLabel label_Fora2_2 = new JLabel("Фора2");
	public JLabel label_Fora2_1_kontora1 = new JLabel("---");
	public JLabel label_Fora2_2_kontora1 = new JLabel("---");
	public JLabel label_Fora2_1_kontora2 = new JLabel("---");
	public JLabel label_Fora2_2_kontora2 = new JLabel("---");
	public JLabel label_Koef_For_Fora2_1 = new JLabel("Коеф");
	public JLabel label_Koef_For_Fora2_2 = new JLabel("Коеф");
	public JLabel label_Koef_For_Fora2_1_kontora1 = new JLabel("---");
	public JLabel label_Koef_For_Fora2_2_kontora1 = new JLabel("---");
	public JLabel label_Koef_For_Fora2_1_kontora2 = new JLabel("---");
	public JLabel label_Koef_For_Fora2_2_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_1_command1 = new JLabel("Інд тот ком1");
	public JLabel label_Ind_Total_1_command1_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_1_command1_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_1_command1_Menwe = new JLabel("Менше");
	public JLabel label_Ind_Total_1_command1_Menwe_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_1_command1_Menwe_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_1_command1_Bilwe = new JLabel("Більше");
	public JLabel label_Ind_Total_1_command1_Bilwe_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_1_command1_Bilwe_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_1_command2 = new JLabel("Інд тот ком2");
	public JLabel label_Ind_Total_1_command2_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_1_command2_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_1_command2_Menwe = new JLabel("Менше");
	public JLabel label_Ind_Total_1_command2_Menwe_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_1_command2_Menwe_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_1_command2_Bilwe = new JLabel("Більше");
	public JLabel label_Ind_Total_1_command2_Bilwe_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_1_command2_Bilwe_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_2_command1 = new JLabel("Інд тот ком1");
	public JLabel label_Ind_Total_2_command1_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_2_command1_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_2_command1_Menwe = new JLabel("Менше");
	public JLabel label_Ind_Total_2_command1_Menwe_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_2_command1_Menwe_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_2_command1_Bilwe = new JLabel("Більше");
	public JLabel label_Ind_Total_2_command1_Bilwe_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_2_command1_Bilwe_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_2_command2 = new JLabel("Інд тот ком2");
	public JLabel label_Ind_Total_2_command2_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_2_command2_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_2_command2_Menwe = new JLabel("Менше");
	public JLabel label_Ind_Total_2_command2_Menwe_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_2_command2_Menwe_kontora2 = new JLabel("---");
	public JLabel label_Ind_Total_2_command2_Bilwe = new JLabel("Більше");
	public JLabel label_Ind_Total_2_command2_Bilwe_kontora1 = new JLabel("---");
	public JLabel label_Ind_Total_2_command2_Bilwe_kontora2 = new JLabel("---");

	JComboBox kontora1List = new JComboBox(kontoraStrings);
	JComboBox kontora2List = new JComboBox(kontoraStrings);

	Koef koef_kontora1 = new FavbetKoef();
	Koef koef_kontora2 = new FonbetKoef();
	DocumentListener documentListener;
	public Thread thread = new Thread(this);

	public void interrupt() {
		isRunning = false;
	}

	public void changeStateToWaiting() {
		isWaiting = true;
	}

	public void changeStateToRunnable(Object event) {
		synchronized (event) {
			isWaiting = false;
			event.notifyAll();
		}
	}

	public Application() throws IOException {

		kontora1List.setSelectedIndex(1);
		kontora2List.setSelectedIndex(2);

		labelProgres.setForeground(Color.blue);
		labelFork.setForeground(Color.red);
		labelResultFork.setForeground(Color.red);

		readFromFile();

		documentListener = new DocumentListener() {
			public void changedUpdate(DocumentEvent documentEvent) {
				kontora1Number = kontora1TextField.getSelectedText();
				kontora2Number = kontora2TextField.getSelectedText();
				percentageNumber = percentageTextField.getSelectedText();
				writeNumOfEventForFonbet();
			}

			public void insertUpdate(DocumentEvent documentEvent) {
				kontora1Number = kontora1TextField.getText();
				kontora2Number = kontora2TextField.getText();
				percentageNumber = percentageTextField.getText();

				writeNumOfEventForFonbet();

				try {
					writeToFile();
				} catch (IOException e) {

					e.printStackTrace();
				}
			}

			public void removeUpdate(DocumentEvent documentEvent) {
				/*
				 * kontora1Number = kontora1TextField.getSelectedText();
				 * kontora2Number = kontora2TextField.getSelectedText();
				 * percentageNumber = percentageTextField.getSelectedText();
				 * writeNumOfEventForFonbet();
				 */
			}
		};

		kontora1TextField.getDocument().addDocumentListener(documentListener);
		kontora2TextField.getDocument().addDocumentListener(documentListener);
		percentageTextField.getDocument().addDocumentListener(documentListener);
	}

	public void createFrame() throws IOException {

		frame.setPreferredSize(new Dimension(1350, 470));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Where the GUI is created:
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);

		// a group of JMenuItems
		menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem);

		menuItem = new JMenuItem("Both text and icon", new ImageIcon(
				"images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);

		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);

		// a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

		// Build second menu in the menu bar. menu = new JMenu("Another Menu");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
				"This menu does nothing");
		menuBar.add(menu);

		frame.setJMenuBar(menuBar);

		Application ex1 = new Application();

		ex1.initTestButton();
		ex1.initStartButton();
		ex1.initStopButton();
		ex1.initComboBox1();
		ex1.initComboBox2();
		ex1.init();

		frame.add("Center", ex1);
		frame.pack();
		// Show it.
		frame.setVisible(true);
	}

	public void initStartButton() {
		startButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// labelProgres.setText("Progress --> Start Button1");

				changeStateToRunnable(event);
				if (!thread.isAlive()) {
					thread.start();
				}

				try {
					writeToFile();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}

	public void initStopButton() {

		stopButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				labelProgres.setText("Прогрес --> Програму зупинено");
				changeStateToWaiting();
				clearLabel();
				playMusic();
			}
		});

	}

	public void initComboBox1() {

		kontora1List.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();

				if (cb.getSelectedItem() == "betcity") {
					kontora1List.setSelectedIndex(0);
					koef_kontora1 = new BetcityKoef();
				} else if (cb.getSelectedItem() == "favbet") {
					kontora1List.setSelectedIndex(1);
					koef_kontora1 = new FavbetKoef();
				} else if (cb.getSelectedItem() == "fonbet") {
					kontora1List.setSelectedIndex(2);
					koef_kontora1 = new FonbetKoef();
					((FonbetKoef) koef_kontora1).id = Integer
							.parseInt(kontora1Number);
				}

			}
		});

	}

	public void initComboBox2() {

		kontora2List.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox) e.getSource();

				if (cb.getSelectedItem() == "betcity") {
					kontora2List.setSelectedIndex(0);
					koef_kontora2 = new BetcityKoef();

				} else if (cb.getSelectedItem() == "favbet") {
					kontora2List.setSelectedIndex(1);
					koef_kontora2 = new FavbetKoef();

				} else if (cb.getSelectedItem() == "fonbet") {
					kontora2List.setSelectedIndex(2);
					koef_kontora2 = new FonbetKoef();
					((FonbetKoef) koef_kontora2).id = Integer
							.parseInt(kontora2Number);

				}

			}
		});

	}

	public void initTestButton() {
		testButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				labelProgres.setText("Прогрес --> Тест розпочато");

				analyze();
				analyze();
				// ====================================================================
				labelProgres.setText("Прогрес --> Тест закінчено успішно");
			}
		});
	}

	public void init() {
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		setFont(new Font("SansSerif", Font.PLAIN, 14));
		setLayout(gridbag);

		c.fill = GridBagConstraints.HORIZONTAL;
		// c.weightx = 1.0;
		c.ipadx = 0;
		c.ipady = 0;
		c.weightx = 0.5;
		c.weighty = 0.0;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 0);
		c.gridx = 0;
		c.gridy = 0;
		// c.gridwidth = GridBagConstraints.REMAINDER; // end row
		gridbag.setConstraints(labelVersionOfProgram, c);
		add(labelVersionOfProgram);

		c.gridy = c.gridy + 1;

		gridbag.setConstraints(kontora1List, c);
		add(kontora1List);

		c.gridx = 1;

		gridbag.setConstraints(kontora1TextField, c);
		add(kontora1TextField);

		c.gridx = 0;
		c.gridy = c.gridy + 1;
		gridbag.setConstraints(kontora2List, c);
		add(kontora2List);

		c.gridx = 1;
		gridbag.setConstraints(kontora2TextField, c);
		add(kontora2TextField);

		c.gridx = 0;
		c.gridy = c.gridy + 1;
		gridbag.setConstraints(labelPercentage, c);
		add(labelPercentage);

		c.gridx = 1;
		gridbag.setConstraints(percentageTextField, c);
		add(percentageTextField);

		c.gridx = 0;
		c.gridy = c.gridy + 1;
		gridbag.setConstraints(startButton, c);
		add(startButton);

		c.gridx = 1;
		gridbag.setConstraints(stopButton, c);
		add(stopButton);

		c.gridx = 2;
		gridbag.setConstraints(testButton, c);
		add(testButton);

		c.gridx = 0;
		c.gridy = c.gridy + 1;
		gridbag.setConstraints(labelFork, c);
		add(labelFork);

		c.gridx = 1;
		gridbag.setConstraints(labelResultFork, c);
		add(labelResultFork);

		c.gridx = 0;
		c.gridy = c.gridy + 1;
		gridbag.setConstraints(labelProgres, c);
		add(labelProgres);

		c.gridx += 1;
		c.gridy += 1;
		// c.weightx = 40;
		gridbag.setConstraints(labelNameOfKontora1_1, c);
		add(labelNameOfKontora1_1);

		c.gridx += 1;
		gridbag.setConstraints(labelNameOfKontora2_1, c);
		add(labelNameOfKontora2_1);

		c.gridx = 0;
		c.gridy = c.gridy + 1;
		gridbag.setConstraints(labelNameOfFork, c);
		add(labelNameOfFork);

		c.gridx = 1;
		gridbag.setConstraints(labelResultNameOfKoefKontora1, c);
		add(labelResultNameOfKoefKontora1);

		c.gridx = 2;
		gridbag.setConstraints(labelResultNameOfKoefKontora2, c);
		add(labelResultNameOfKoefKontora2);

		c.gridx = 0;
		c.gridy = c.gridy + 1;
		gridbag.setConstraints(labelKoefForFork, c);
		add(labelKoefForFork);

		c.gridx = 1;
		gridbag.setConstraints(labelKoefKontora1, c);
		add(labelKoefKontora1);

		c.gridx = 2;
		gridbag.setConstraints(labelKoefKontora2, c);
		add(labelKoefKontora2);

		c.gridx = 0;
		c.gridy = c.gridy + 1;
		gridbag.setConstraints(labelStavka, c);
		add(labelStavka);

		c.gridx += 1;
		gridbag.setConstraints(labelStavkaKontora1, c);
		add(labelStavkaKontora1);

		c.gridx += 1;
		gridbag.setConstraints(labelStavkaKontora2, c);
		add(labelStavkaKontora2);

		c.gridx = 0;
		c.gridy += 1;
		gridbag.setConstraints(labelVugraw, c);
		add(labelVugraw);

		c.gridx = 1;
		gridbag.setConstraints(labelVugrawKontora1, c);
		add(labelVugrawKontora1);

		c.gridx = 2;
		gridbag.setConstraints(labelVugrawKontora2, c);
		add(labelVugrawKontora2);

		c.gridx = 0;
		c.gridy += 1;
		gridbag.setConstraints(label4ustuyVugraw, c);
		add(label4ustuyVugraw);

		c.gridx = 1;
		gridbag.setConstraints(label4ustuyVugrawKontora1, c);
		add(label4ustuyVugrawKontora1);

		c.gridx = 2;
		gridbag.setConstraints(label4ustuyVugrawKontora2, c);
		add(label4ustuyVugrawKontora2);

		c.gridy += 1;
		c.gridx = 1;
		gridbag.setConstraints(label_name_of_command_1, c);
		add(label_name_of_command_1);

		c.gridx += 1;
		gridbag.setConstraints(label_name_of_command_2, c);
		add(label_name_of_command_2);

		c.gridx += 1;
		gridbag.setConstraints(label_1, c);
		add(label_1);

		c.gridx += 1;
		gridbag.setConstraints(label_X, c);
		add(label_X);

		c.gridx += 1;
		gridbag.setConstraints(label_2, c);
		add(label_2);

		c.gridx += 1;
		gridbag.setConstraints(label_1X, c);
		add(label_1X);

		c.gridx += 1;
		gridbag.setConstraints(label_12, c);
		add(label_12);

		c.gridx += 1;
		gridbag.setConstraints(label_X2, c);
		add(label_X2);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_1, c);
		add(label_Total_1);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Menwe_1, c);
		add(label_Total_Menwe_1);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Bilwe_1, c);
		add(label_Total_Bilwe_1);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_2, c);
		add(label_Total_2);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Menwe_2, c);
		add(label_Total_Menwe_2);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Bilwe_2, c);
		add(label_Total_Bilwe_2);

		c.gridx = 0;
		c.gridy += 1;
		gridbag.setConstraints(label_kontora1, c);
		add(label_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_name_of_command_1_kontora1, c);
		add(label_name_of_command_1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_name_of_command_2_kontora1, c);
		add(label_name_of_command_2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_1_kontora1, c);
		add(label_1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_X_kontora1, c);
		add(label_X_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_2_kontora1, c);
		add(label_2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_1X_kontora1, c);
		add(label_1X_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_12_kontora1, c);
		add(label_12_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_X2_kontora1, c);
		add(label_X2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_1_kontora1, c);
		add(label_Total_1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Menwe_1_kontora1, c);
		add(label_Total_Menwe_1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Bilwe_1_kontora1, c);
		add(label_Total_Bilwe_1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_2_kontora1, c);
		add(label_Total_2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Menwe_2_kontora1, c);
		add(label_Total_Menwe_2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Bilwe_2_kontora1, c);
		add(label_Total_Bilwe_2_kontora1);

		c.gridx = 0;
		c.gridy += 1;
		gridbag.setConstraints(label_kontora2, c);
		add(label_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_name_of_command_1_kontora2, c);
		add(label_name_of_command_1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_name_of_command_2_kontora2, c);
		add(label_name_of_command_2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_1_kontora2, c);
		add(label_1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_X_kontora2, c);
		add(label_X_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_2_kontora2, c);
		add(label_2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_1X_kontora2, c);
		add(label_1X_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_12_kontora2, c);
		add(label_12_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_X2_kontora2, c);
		add(label_X2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_1_kontora2, c);
		add(label_Total_1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Menwe_1_kontora2, c);
		add(label_Total_Menwe_1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Bilwe_1_kontora2, c);
		add(label_Total_Bilwe_1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_2_kontora2, c);
		add(label_Total_2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Menwe_2_kontora2, c);
		add(label_Total_Menwe_2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Total_Bilwe_2_kontora2, c);
		add(label_Total_Bilwe_2_kontora2);

		// =========================================

		c.gridy += 1;
		gridbag.setConstraints(labelEmpty_1, c);
		add(labelEmpty_1);

		c.gridx = 1;
		c.gridy += 1;
		gridbag.setConstraints(label_Fora1_1, c);
		add(label_Fora1_1);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora1_1, c);
		add(label_Koef_For_Fora1_1);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora2_1, c);
		add(label_Fora2_1);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora2_1, c);
		add(label_Koef_For_Fora2_1);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora1_2, c);
		add(label_Fora1_2);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora1_2, c);
		add(label_Koef_For_Fora1_2);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora2_2, c);
		add(label_Fora2_2);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora2_2, c);
		add(label_Koef_For_Fora2_2);

		// =============================================================
		c.gridx = 0;
		c.gridy += 1;
		gridbag.setConstraints(labelNameOfKontora1_2, c);
		add(labelNameOfKontora1_2);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora1_1_kontora1, c);
		add(label_Fora1_1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora1_1_kontora1, c);
		add(label_Koef_For_Fora1_1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora2_1_kontora1, c);
		add(label_Fora2_1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora2_1_kontora1, c);
		add(label_Koef_For_Fora2_1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora1_2_kontora1, c);
		add(label_Fora1_2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora1_2_kontora1, c);
		add(label_Koef_For_Fora1_2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora2_2_kontora1, c);
		add(label_Fora2_2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora2_2_kontora1, c);
		add(label_Koef_For_Fora2_2_kontora1);

		c.gridx = 0;
		c.gridy += 1;
		gridbag.setConstraints(labelNameOfKontora2_2, c);
		add(labelNameOfKontora2_2);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora1_1_kontora2, c);
		add(label_Fora1_1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora1_1_kontora2, c);
		add(label_Koef_For_Fora1_1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora2_1_kontora2, c);
		add(label_Fora2_1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora2_1_kontora2, c);
		add(label_Koef_For_Fora2_1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora1_2_kontora2, c);
		add(label_Fora1_2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora1_2_kontora2, c);
		add(label_Koef_For_Fora1_2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Fora2_2_kontora2, c);
		add(label_Fora2_2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Koef_For_Fora2_2_kontora2, c);
		add(label_Koef_For_Fora2_2_kontora2);

		// ============================================
		c.gridy += 1;
		gridbag.setConstraints(labelEmpty_2, c);
		add(labelEmpty_2);

		c.gridx = 1;
		c.gridy += 1;
		gridbag.setConstraints(label_Ind_Total_1_command1, c);
		add(label_Ind_Total_1_command1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command1_Menwe, c);
		add(label_Ind_Total_1_command1_Menwe);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command1_Bilwe, c);
		add(label_Ind_Total_1_command1_Bilwe);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command2, c);
		add(label_Ind_Total_1_command2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command2_Menwe, c);
		add(label_Ind_Total_1_command2_Menwe);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command2_Bilwe, c);
		add(label_Ind_Total_1_command2_Bilwe);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command1, c);
		add(label_Ind_Total_2_command1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command1_Menwe, c);
		add(label_Ind_Total_2_command1_Menwe);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command1_Bilwe, c);
		add(label_Ind_Total_2_command1_Bilwe);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command2, c);
		add(label_Ind_Total_2_command2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command2_Menwe, c);
		add(label_Ind_Total_2_command2_Menwe);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command2_Bilwe, c);
		add(label_Ind_Total_2_command2_Bilwe);

		// ======================================
		c.gridx = 0;
		c.gridy += 1;
		gridbag.setConstraints(labelNameOfKontora1_3, c);
		add(labelNameOfKontora1_3);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command1_kontora1, c);
		add(label_Ind_Total_1_command1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command1_Menwe_kontora1, c);
		add(label_Ind_Total_1_command1_Menwe_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command1_Bilwe_kontora1, c);
		add(label_Ind_Total_1_command1_Bilwe_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command2_kontora1, c);
		add(label_Ind_Total_1_command2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command2_Menwe_kontora1, c);
		add(label_Ind_Total_1_command2_Menwe_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command2_Bilwe_kontora1, c);
		add(label_Ind_Total_1_command2_Bilwe_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command1_kontora1, c);
		add(label_Ind_Total_2_command1_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command1_Menwe_kontora1, c);
		add(label_Ind_Total_2_command1_Menwe_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command1_Bilwe_kontora1, c);
		add(label_Ind_Total_2_command1_Bilwe_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command2_kontora1, c);
		add(label_Ind_Total_2_command2_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command2_Menwe_kontora1, c);
		add(label_Ind_Total_2_command2_Menwe_kontora1);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command2_Bilwe_kontora1, c);
		add(label_Ind_Total_2_command2_Bilwe_kontora1);

		// ======================================
		c.gridx = 0;
		c.gridy += 1;
		gridbag.setConstraints(labelNameOfKontora2_3, c);
		add(labelNameOfKontora2_3);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command1_kontora2, c);
		add(label_Ind_Total_1_command1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command1_Menwe_kontora2, c);
		add(label_Ind_Total_1_command1_Menwe_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command1_Bilwe_kontora2, c);
		add(label_Ind_Total_1_command1_Bilwe_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command2_kontora2, c);
		add(label_Ind_Total_1_command2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command2_Menwe_kontora2, c);
		add(label_Ind_Total_1_command2_Menwe_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_1_command2_Bilwe_kontora2, c);
		add(label_Ind_Total_1_command2_Bilwe_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command1_kontora2, c);
		add(label_Ind_Total_2_command1_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command1_Menwe_kontora2, c);
		add(label_Ind_Total_2_command1_Menwe_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command1_Bilwe_kontora2, c);
		add(label_Ind_Total_2_command1_Bilwe_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command2_kontora2, c);
		add(label_Ind_Total_2_command2_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command2_Menwe_kontora2, c);
		add(label_Ind_Total_2_command2_Menwe_kontora2);

		c.gridx += 1;
		gridbag.setConstraints(label_Ind_Total_2_command2_Bilwe_kontora2, c);
		add(label_Ind_Total_2_command2_Bilwe_kontora2);

	}

	public void writeToFile() throws IOException {
		File file = new File("link.txt");
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(kontora1Number);
		bw.newLine();
		bw.append(kontora2Number);
		bw.newLine();
		bw.append(percentageNumber);
		// System.out.println("Writer percentageNumber: " + percentageNumber);
		bw.close();
	}

	public void readFromFile() throws IOException {

		File file = new File("link.txt");
		if (file.exists()) {
			FileReader fr = new FileReader(file.getAbsoluteFile());
			BufferedReader br = new BufferedReader(fr);

			kontora1Number = br.readLine();
			kontora2Number = br.readLine();
			percentageNumber = br.readLine();

			br.close();

			kontora1TextField.setText(kontora1Number);
			kontora2TextField.setText(kontora2Number);
			percentageTextField.setText(percentageNumber);
		}
	}

	public void writeNumOfEventForFonbet() {
		if (koef_kontora1.name_of_kontora == "fonbet") {
			((FonbetKoef) koef_kontora1).num_of_event = Integer
					.parseInt(kontora1Number);
		}
		if (koef_kontora2.name_of_kontora == "fonbet") {
			((FonbetKoef) koef_kontora2).num_of_event = Integer
					.parseInt(kontora2Number);
		}
	}

	public void setKoefToApplication() {
		labelNameOfKontora1_1.setText(koef_kontora1.name_of_kontora);
		labelNameOfKontora1_2.setText(koef_kontora1.name_of_kontora);
		labelNameOfKontora1_3.setText(koef_kontora1.name_of_kontora);
		labelNameOfKontora1_4.setText(koef_kontora1.name_of_kontora);
		labelNameOfKontora2_1.setText(koef_kontora2.name_of_kontora);
		labelNameOfKontora2_2.setText(koef_kontora2.name_of_kontora);
		labelNameOfKontora2_3.setText(koef_kontora2.name_of_kontora);
		labelNameOfKontora2_4.setText(koef_kontora2.name_of_kontora);
		label_kontora1.setText(koef_kontora1.name_of_kontora);
		label_kontora2.setText(koef_kontora2.name_of_kontora);
		label_name_of_command_1_kontora1
				.setText(koef_kontora1.name_of_command1);
		label_name_of_command_1_kontora2
				.setText(koef_kontora2.name_of_command1);
		label_name_of_command_2_kontora1
				.setText(koef_kontora1.name_of_command2);
		label_name_of_command_2_kontora2
				.setText(koef_kontora2.name_of_command2);
		label_1_kontora1.setText(Float.toString(koef_kontora1.name_1));
		label_1_kontora2.setText(Float.toString(koef_kontora2.name_1));
		label_X_kontora1.setText(Float.toString(koef_kontora1.name_X));
		label_X_kontora2.setText(Float.toString(koef_kontora2.name_X));
		label_2_kontora1.setText(Float.toString(koef_kontora1.name_2));
		label_2_kontora2.setText(Float.toString(koef_kontora2.name_2));
		label_1X_kontora1.setText(Float.toString(koef_kontora1.name_1X));
		label_1X_kontora2.setText(Float.toString(koef_kontora2.name_1X));
		label_12_kontora1.setText(Float.toString(koef_kontora1.name_12));
		label_12_kontora2.setText(Float.toString(koef_kontora2.name_12));
		label_X2_kontora1.setText(Float.toString(koef_kontora1.name_X2));
		label_X2_kontora2.setText(Float.toString(koef_kontora2.name_X2));
		label_Total_1_kontora1.setText(Float
				.toString(koef_kontora1.name_TOTAL[0]));
		label_Total_1_kontora2.setText(Float
				.toString(koef_kontora2.name_TOTAL[0]));
		label_Total_Menwe_1_kontora1.setText(Float
				.toString(koef_kontora1.name_TOTAL_menwe[0]));
		label_Total_Menwe_1_kontora2.setText(Float
				.toString(koef_kontora2.name_TOTAL_menwe[0]));
		label_Total_Bilwe_1_kontora1.setText(Float
				.toString(koef_kontora1.name_TOTAL_bilwe[0]));
		label_Total_Bilwe_1_kontora2.setText(Float
				.toString(koef_kontora2.name_TOTAL_bilwe[0]));
		label_Total_2_kontora1.setText(Float
				.toString(koef_kontora1.name_TOTAL[1]));
		label_Total_2_kontora2.setText(Float
				.toString(koef_kontora2.name_TOTAL[1]));
		label_Total_Menwe_2_kontora1.setText(Float
				.toString(koef_kontora1.name_TOTAL_menwe[1]));
		label_Total_Menwe_2_kontora2.setText(Float
				.toString(koef_kontora2.name_TOTAL_menwe[1]));
		label_Total_Bilwe_2_kontora1.setText(Float
				.toString(koef_kontora1.name_TOTAL_bilwe[1]));
		label_Total_Bilwe_2_kontora2.setText(Float
				.toString(koef_kontora2.name_TOTAL_bilwe[1]));
		label_Fora1_1_kontora1.setText(Float
				.toString(koef_kontora1.name_FORA1[0]));
		label_Fora1_1_kontora2.setText(Float
				.toString(koef_kontora2.name_FORA1[0]));
		label_Koef_For_Fora1_1_kontora1.setText(Float
				.toString(koef_kontora1.name_koef_for_FORA1[0]));
		label_Koef_For_Fora1_1_kontora2.setText(Float
				.toString(koef_kontora2.name_koef_for_FORA1[0]));
		label_Fora2_1_kontora1.setText(Float
				.toString(koef_kontora1.name_FORA2[0]));
		label_Fora2_1_kontora2.setText(Float
				.toString(koef_kontora2.name_FORA2[0]));
		label_Koef_For_Fora2_1_kontora1.setText(Float
				.toString(koef_kontora1.name_koef_for_FORA2[0]));
		label_Koef_For_Fora2_1_kontora2.setText(Float
				.toString(koef_kontora2.name_koef_for_FORA2[0]));
		label_Fora1_2_kontora1.setText(Float
				.toString(koef_kontora1.name_FORA1[1]));
		label_Fora1_2_kontora2.setText(Float
				.toString(koef_kontora2.name_FORA1[1]));
		label_Koef_For_Fora1_2_kontora1.setText(Float
				.toString(koef_kontora1.name_koef_for_FORA1[1]));
		label_Koef_For_Fora1_2_kontora2.setText(Float
				.toString(koef_kontora2.name_koef_for_FORA1[1]));
		label_Fora2_2_kontora1.setText(Float
				.toString(koef_kontora1.name_FORA2[1]));
		label_Fora2_2_kontora2.setText(Float
				.toString(koef_kontora2.name_FORA2[1]));
		label_Koef_For_Fora2_2_kontora1.setText(Float
				.toString(koef_kontora1.name_koef_for_FORA2[1]));
		label_Koef_For_Fora2_2_kontora2.setText(Float
				.toString(koef_kontora2.name_koef_for_FORA2[1]));
		label_Ind_Total_1_command1_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalOfCommand1[0]));
		label_Ind_Total_1_command1_Menwe_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalMenweOfCommand1[0]));
		label_Ind_Total_1_command1_Bilwe_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalBilweOfCommand1[0]));
		label_Ind_Total_1_command2_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalOfCommand2[0]));
		label_Ind_Total_1_command2_Menwe_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalMenweOfCommand2[0]));
		label_Ind_Total_1_command2_Bilwe_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalBilweOfCommand2[0]));
		label_Ind_Total_2_command1_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalOfCommand1[1]));
		label_Ind_Total_2_command1_Menwe_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalMenweOfCommand1[1]));
		label_Ind_Total_2_command1_Bilwe_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalBilweOfCommand1[1]));
		label_Ind_Total_2_command2_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalOfCommand2[1]));
		label_Ind_Total_2_command2_Menwe_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalMenweOfCommand2[1]));
		label_Ind_Total_2_command2_Bilwe_kontora1.setText(Float
				.toString(koef_kontora1.name_IndTotalBilweOfCommand2[1]));
		label_Ind_Total_1_command1_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalOfCommand1[0]));
		label_Ind_Total_1_command1_Menwe_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalMenweOfCommand1[0]));
		label_Ind_Total_1_command1_Bilwe_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalBilweOfCommand1[0]));
		label_Ind_Total_1_command2_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalOfCommand2[0]));
		label_Ind_Total_1_command2_Menwe_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalMenweOfCommand2[0]));
		label_Ind_Total_1_command2_Bilwe_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalBilweOfCommand2[0]));
		label_Ind_Total_2_command1_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalOfCommand1[1]));
		label_Ind_Total_2_command1_Menwe_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalMenweOfCommand1[1]));
		label_Ind_Total_2_command1_Bilwe_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalBilweOfCommand1[1]));
		label_Ind_Total_2_command2_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalOfCommand2[1]));
		label_Ind_Total_2_command2_Menwe_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalMenweOfCommand2[1]));
		label_Ind_Total_2_command2_Bilwe_kontora2.setText(Float
				.toString(koef_kontora2.name_IndTotalBilweOfCommand2[1]));
	}

	public void forkIsNotValid() {
		labelResultFork.setText("Nema");
		labelResultNameOfKoefKontora1.setText("-----");
		labelResultNameOfKoefKontora2.setText("-----");
		labelKoefKontora1.setText("-----");
		labelKoefKontora2.setText("-----");
	}

	public void forkIsValid() {

		float vugraw1;
		float vugraw2;
		float chust_vugraw1;
		float chust_vugraw2;
		Float stavka_bilwuy_koef;

		if (result.KoefKontora1 < result.KoefKontora2) {
			labelStavkaKontora1.setText("1000");
			// Stavka2 = Stavka1 * Koef1 /Koef2
			stavka_bilwuy_koef = 1000 * result.KoefKontora1
					/ result.KoefKontora2;

			labelStavkaKontora2.setText(Integer.toString(Math
					.round(stavka_bilwuy_koef)));

			// Vugraw
			vugraw1 = 1000 * result.KoefKontora1;
			vugraw2 = stavka_bilwuy_koef * result.KoefKontora2;

			// 4ustuy Vugraw
			chust_vugraw1 = vugraw1 - stavka_bilwuy_koef - 1000;
			chust_vugraw2 = vugraw2 - stavka_bilwuy_koef - 1000;
		} else {
			labelStavkaKontora2.setText("1000");
			// Stavka2 = Stavka1 * Koef1 /Koef2
			stavka_bilwuy_koef = 1000 * result.KoefKontora2
					/ result.KoefKontora1;

			labelStavkaKontora1.setText(Integer.toString(Math
					.round(stavka_bilwuy_koef)));

			// Vugraw
			vugraw2 = 1000 * result.KoefKontora2;
			vugraw1 = stavka_bilwuy_koef * result.KoefKontora1;

			// 4ustuy Vugraw
			chust_vugraw1 = vugraw1 - stavka_bilwuy_koef - 1000;
			chust_vugraw2 = vugraw2 - stavka_bilwuy_koef - 1000;
		}

		if ((stavka_bilwuy_koef + 1000) * 0.01
				* Float.parseFloat(percentageNumber) <= chust_vugraw1) {
			labelResultFork.setText("Je");
			labelResultNameOfKoefKontora1.setText(result.nameOfKoefKontora1);
			labelResultNameOfKoefKontora2.setText(result.nameOfKoefKontora2);
			labelKoefKontora1.setText(Float.toString(result.KoefKontora1));
			labelKoefKontora2.setText(Float.toString(result.KoefKontora2));

			labelVugrawKontora1.setText(Integer.toString(Math.round(vugraw1)));
			labelVugrawKontora2.setText(Integer.toString(Math.round(vugraw2)));
			label4ustuyVugrawKontora1.setText(Integer.toString(Math
					.round(chust_vugraw1)));
			label4ustuyVugrawKontora2.setText(Integer.toString(Math
					.round(chust_vugraw2)));
			playMusic();
		}

		changeStateToWaiting();
	}

	public void analyze() {
		writeNumOfEventForFonbet();
		String temp_str = new String();
		temp_str = koef_kontora1.getKoef();
		if (temp_str != "") {
			labelProgres.setText("Прогрес --> " + koef_kontora1.name_of_kontora
					+ " Помилка - " + temp_str);
			try {

				TimeUnit.MILLISECONDS.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		labelProgres.setText("Прогрес --> З " + koef_kontora1.name_of_kontora
				+ " Коефіцієнти отримані");

		temp_str = koef_kontora2.getKoef();
		if (temp_str != "") {
			labelProgres.setText("Прогрес --> " + koef_kontora2.name_of_kontora
					+ " Помилка - " + temp_str);

			try {
				TimeUnit.MILLISECONDS.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			labelProgres.setText("Progress --> З "
					+ koef_kontora2.name_of_kontora + " Коефіцієнти отримані");

			Calc calculation = new Calc();

			result = calculation.checkFork(koef_kontora1, koef_kontora2);

			setKoefToApplication();
			if (result.fork) {
				if (forkHaveBeenFoundInPreviousAttempt) {
					forkIsValid();
				} else
					forkHaveBeenFoundInPreviousAttempt = true;

			} else {
				forkHaveBeenFoundInPreviousAttempt = false;
				forkIsNotValid();
			}
		}
	}

	public void run() {
		labelProgres.setText("Прогрес --> Розпочато пошук вилок");

		Files files = new Files();

		try {
			if (files.downloadFile("license",
					"http://www.slawsk.com.ua/stavki_1.html") != true) {
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		int p = 1;

		synchronized (event) {
			while (isRunning) {
				if (!isWaiting) {
					labelProgres.setText("Прогрес --> Виконано " + p
							+ " спроб пошуку вилок");

					try {
						TimeUnit.MILLISECONDS.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// download info for kontora1
					try {
						if (files.downloadFile(koef_kontora1.name_of_kontora,
								koef_kontora1.link_to_download_file
										+ kontora1Number) == true) {
							// download info for kontora2
							if (files.downloadFile(
									koef_kontora2.name_of_kontora,
									koef_kontora2.link_to_download_file
											+ kontora2Number + "/") == true) {

								analyze();

								p += 1;
							}
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					try {
						event.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	void playMusic() {
		
			Clip clip;
			try {
				clip = AudioSystem.getClip();
				try {
					clip.open(AudioSystem.getAudioInputStream(
						    new BufferedInputStream(getClass().getResourceAsStream("/st/sound.wav"))));
				} catch (IOException | UnsupportedAudioFileException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clip.start( );
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	};
	void clearLabel() {
		label_name_of_command_1_kontora1.setText("---");
		label_name_of_command_1_kontora2.setText("---");
		label_name_of_command_2_kontora1.setText("---");
		label_name_of_command_2_kontora2.setText("---");
	}
}
