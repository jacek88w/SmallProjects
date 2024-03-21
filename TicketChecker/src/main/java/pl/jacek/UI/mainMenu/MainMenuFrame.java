package pl.jacek.UI.mainMenu;

import pl.jacek.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame {

    private JComboBox<String> priorityComboBox;
    private JComboBox<String> informationComboBox;
    private IntegerTextField durationInputField;
    private IntegerTextField delayInputField;
    private int buttonClickCount = 0;

    public MainMenuFrame() {
        setTitle("CCE destroyer");
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        // Progress Bar
        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(75, 25, 450, 40);
        add(progressBar);

        // Priority ComboBox
        JLabel priorityLabel = new JLabel("Priority");
        priorityLabel.setBounds(50, 75, 100, 30);
        add(priorityLabel);

        priorityComboBox = new JComboBox<>(new String[]{"Low", "Medium", "High"});
        priorityComboBox.setBounds(50, 100, 100, 25);
        add(priorityComboBox);

        // Duration
        JLabel durationLabel = new JLabel("Duration");
        durationLabel.setBounds(50, 155, 100, 30);
        add(durationLabel);

        durationInputField = new IntegerTextField();
        durationInputField.setBounds(50, 180, 100, 25);
        add(durationInputField);

        // Delay
        JLabel delayLabel = new JLabel("Delay");
        delayLabel.setBounds(50, 235, 100, 30);
        add(delayLabel);

        delayInputField = new IntegerTextField();
        delayInputField.setBounds(50, 260, 100, 25);
        add(delayInputField);

        // Informing
        JLabel informationLabel = new JLabel("How to inform?");
        informationLabel.setBounds(450, 115, 100, 30);
        add(informationLabel);

        informationComboBox = new JComboBox<>(new String[]{"Sound"});
        informationComboBox.setBounds(450, 140, 100, 25);
        add(informationComboBox);

        // Button
        JButton button = new JButton("Start");
        button.setBounds(200, 350, 200, 50);
        button.setBackground(Color.green);
        button.setFont(new Font("MV Boli", Font.BOLD, 20));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonClickCount++;
                if (buttonClickCount % 2 == 0) {
                    button.setBackground(Color.GREEN);
                    button.setText("Start");
                } else {
                    button.setBackground(Color.RED);
                    button.setText("Stop");
                    Utils.checkIfClassExists(
                            priorityComboBox.getSelectedItem().toString(),
                            (int)durationInputField.getValue(),
                            (int)delayInputField.getValue()

                    );
                }
            }
        });
        add(button);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // Menu - Settings
        JMenu settingsMenu = new JMenu("Settings");
        JMenuItem settingsItem = new JMenuItem("Settings Option");
        settingsMenu.add(settingsItem);

        // Menu - Help
        JMenu helpMenu = new JMenu("Help");
        JMenuItem helpItem = new JMenuItem("Help Option");
        helpMenu.add(helpItem);

        // Menu - View
        JMenu viewMenu = new JMenu("View");
        JMenuItem viewItem = new JMenuItem("View Option");
        viewMenu.add(viewItem);

        menuBar.add(settingsMenu);
        menuBar.add(helpMenu);
        menuBar.add(viewMenu);

        setJMenuBar(menuBar);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainMenuFrame();
    }
}
