package form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.NumberFormat;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

public class JobApplicationForm extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField addressField;
    private JTextField jobTitleField;
    private JFormattedTextField experienceField;
    private JTextArea cvField;

    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;
    private static NumberFormatter longFormatter;
    private static NumberFormatter intFormatter;

    private final int X_START_INPUT = 420;
    private final int X_START_LABEL = 550;
    private final int HEIGHT_INPUT = 30;
    private final Font FONT_IN_FORM = new Font("Tahoma", Font.PLAIN, 20);

    //Pattern matching to valid Email
    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //Pattern matching to valid Email
    private static final String PHONE_PATTERN = "[0-9]+";

    /**Launch the application.*/
    public static void main(String[] args) {
        NumberFormat longFormat = NumberFormat.getIntegerInstance();
        longFormatter = new NumberFormatter(longFormat);
        longFormatter.setValueClass(Long.class);
        longFormatter.setAllowsInvalid(true);
        longFormatter.setMinimum(0l);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JobApplicationForm frame = new JobApplicationForm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /** Create the frame.*/
    public JobApplicationForm() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        try {
            //Load image into Pane
            BufferedImage myPicture = ImageIO.read(new File("image.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            picLabel.setBounds(0, 0, 365, 550);
            contentPane.add(picLabel);
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel lblNewLabel = new JLabel("Job Application");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(X_START_LABEL, 5, 500, 93);
        contentPane.add(lblNewLabel);

        //Row for name input
        JLabel lblName = new JLabel("Name");
        lblName.setBackground(Color.BLACK);
        lblName.setForeground(Color.BLACK);
        lblName.setFont(FONT_IN_FORM);
        lblName.setBounds(X_START_INPUT, 100, 150, 52);
        contentPane.add(lblName);

        nameField = new JTextField();
        nameField.setFont(FONT_IN_FORM);
        nameField.setBounds(X_START_LABEL, 105, 400, HEIGHT_INPUT);
        contentPane.add(nameField);
        nameField.setColumns(10);

        //Row for Age input
        JLabel lblAge = new JLabel("Age");
        lblAge.setForeground(Color.BLACK);
        lblAge.setBackground(Color.CYAN);
        lblAge.setFont(FONT_IN_FORM);
        lblAge.setBounds(X_START_INPUT, 140, 150, 52);
        contentPane.add(lblAge);

        ageField = new JFormattedTextField(longFormatter);
        ageField.setFont(FONT_IN_FORM);
        ageField.setBounds(X_START_LABEL, 145, 400, HEIGHT_INPUT);
        //Fix bug Clearing contents of JFormattedTextField
        ageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (ageField.getText().length() == 1 && ke.getKeyCode() == KeyEvent.VK_DELETE || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    ageField.setText(null);
                }
            }

        });
        contentPane.add(ageField);

        //Row for Email input
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setBackground(Color.CYAN);
        lblEmail.setFont(FONT_IN_FORM);
        lblEmail.setBounds(X_START_INPUT, 180, 150, 52);
        contentPane.add(lblEmail);

        emailField = new JTextField();
        emailField.setFont(FONT_IN_FORM);
        emailField.setBounds(X_START_LABEL, 185, 400, HEIGHT_INPUT);
        contentPane.add(emailField);

        //Row for Phone input
        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setForeground(Color.BLACK);
        lblPhone.setBackground(Color.CYAN);
        lblPhone.setFont(FONT_IN_FORM);
        lblPhone.setBounds(X_START_INPUT, 220, 150, 52);
        contentPane.add(lblPhone);

        phoneField = new JTextField();
        phoneField.setFont(FONT_IN_FORM);
        phoneField.setBounds(X_START_LABEL, 225, 400, HEIGHT_INPUT);
        contentPane.add(phoneField);

        JLabel lblAddress = new JLabel("Address");
        lblAddress.setForeground(Color.BLACK);
        lblAddress.setBackground(Color.CYAN);
        lblAddress.setFont(FONT_IN_FORM);
        lblAddress.setBounds(X_START_INPUT, 260, 150, 52);
        contentPane.add(lblAddress);

        addressField = new JTextField();
        addressField.setFont(FONT_IN_FORM);
        addressField.setBounds(X_START_LABEL, 265, 400, HEIGHT_INPUT);
        contentPane.add(addressField);

        //Row for Job Title input
        JLabel lblJobTitle = new JLabel("Job Title");
        lblJobTitle.setForeground(Color.BLACK);
        lblJobTitle.setBackground(Color.CYAN);
        lblJobTitle.setFont(FONT_IN_FORM);
        lblJobTitle.setBounds(X_START_INPUT, 300, 150, 52);
        contentPane.add(lblJobTitle);

        jobTitleField = new JTextField();
        jobTitleField.setFont(FONT_IN_FORM);
        jobTitleField.setBounds(X_START_LABEL, 305, 400, HEIGHT_INPUT);
        contentPane.add(jobTitleField);

        //Row for Job Experience input
        JLabel lblExperience = new JLabel("Experience");
        lblExperience.setForeground(Color.BLACK);
        lblExperience.setBackground(Color.CYAN);
        lblExperience.setFont(FONT_IN_FORM);
        lblExperience.setBounds(X_START_INPUT, 340, 150, 52);

        //Fix bug Clearing contents of JFormattedTextField
        lblExperience.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent ke) {
                if (lblExperience.getText().length() == 1 && ke.getKeyCode() == KeyEvent.VK_DELETE || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    lblExperience.setText(null);
                }
            }

        });
        contentPane.add(lblExperience);

        experienceField = new JFormattedTextField(longFormatter);
        experienceField.setFont(FONT_IN_FORM);
        experienceField.setBounds(X_START_LABEL, 345, 400, HEIGHT_INPUT);
        contentPane.add(experienceField);

        //Row for Job CV input
        JLabel lblCV = new JLabel("CV");
        lblCV.setForeground(Color.BLACK);
        lblCV.setBackground(Color.CYAN);
        lblCV.setFont(FONT_IN_FORM);
        lblCV.setBounds(X_START_INPUT, 420, 150, 52);
        contentPane.add(lblCV);

        cvField = new JTextArea();
        cvField.setFont(FONT_IN_FORM);
        cvField.setBounds(X_START_LABEL, 385, 400, 120);
        cvField.setLineWrap(true);
        cvField.setWrapStyleWord(true);
        contentPane.add(cvField);

        btnNewButton = new JButton("Submit");
        btnNewButton.setFont(FONT_IN_FORM);
        btnNewButton.setBounds(X_START_INPUT, 520, 550, HEIGHT_INPUT);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Optional<String> opCheckValidForm = checkValidForm();
                StringBuilder sb = new StringBuilder();

                if (opCheckValidForm.isPresent()) {
                    sb.append(opCheckValidForm.get());
                } else {
                    sb.append("Register success!!!").append("\n")
                            .append("Name:")
                            .append(nameField.getText()).append("\n")
                            .append("Age:")
                            .append(ageField.getText()).append("\n")
                            .append("Email:")
                            .append(emailField.getText()).append("\n")
                            .append("Phone:")
                            .append(phoneField.getText()).append("\n")
                            .append("Address:")
                            .append(addressField.getText()).append("\n")
                            .append("Job title:")
                            .append(jobTitleField.getText()).append("\n")
                            .append("Experience:")
                            .append(experienceField.getValue()).append("\n")
                            .append("CV:")
                            .append(cvField.getText()).append("\n");;

                }
                JOptionPane.showMessageDialog(null, sb.toString());
            }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(420, 0, 1008, 562);
        contentPane.add(label);
    }

    /**@return Optional.empty if every thing in form valid. Else return error message*/
    public Optional<String> checkValidForm() {
        if (nameField.getText().isEmpty()) {
            return Optional.of("You forgot to fill name text field, Please fill it");
        }
        if (ageField.getText().isEmpty()) {
            return Optional.of("You enter proper input for age!");
        }
        String email = emailField.getText();
        if (email.isEmpty()) {
            return Optional.of("You enter proper input for email!");
        }
        if (!email.matches(EMAIL_PATTERN)) {
            return Optional.of("You can check proper email input by checking the existence of '@' in the email");
        }
        if (emailField.getText().isEmpty()) {
            return Optional.of("You forgot to fill name text field, Please fill it");
        }
        if (phoneField.getText().isEmpty()) {
            return Optional.of("You enter proper input for phone!");
        }
        String phone = phoneField.getText();
        if (!phone.matches(PHONE_PATTERN)) {
            return Optional.of("You enter proper input for phone");
        }
        if (addressField.getText().isEmpty()) {
            return Optional.of("You enter proper input for address!");
        }
        if (jobTitleField.getText().isEmpty()) {
            return Optional.of("You enter proper input for job title!");
        }
        if (experienceField.getText().isEmpty()) {
            return Optional.of("You enter proper input for experience!");
        }
        String cv = cvField.getText();

        if (cv.length() < 20) {
            return Optional.of("Please add more infomation about yourself in your CV");
        }

        return Optional.empty();
    }

}
