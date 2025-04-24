package C04;

import javax.swing.*;
import java.awt.*;

public class StudentRegistrationForm extends JFrame {

    private JTextField nameField, emailField;
    private JRadioButton maleRadio, femaleRadio, otherRadio;
    private JComboBox<String> courseComboBox;
    private JCheckBox readingCheckBox, travelingCheckBox, gamingCheckBox;
    private JButton submitButton, resetButton;

    public StudentRegistrationForm() {
        setTitle("Student Registration Form");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Title at top, center aligned
        JLabel titleLabel = new JLabel("Student Registration Form");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Form content panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 20, 8, 20); // vertical & horizontal padding
        gbc.anchor = GridBagConstraints.WEST; // left align everything

        // Row 0: Name
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Name:"), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(20);
        formPanel.add(nameField, gbc);

        // Row 1: Email
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Email:"), gbc);

        gbc.gridx = 1;
        emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        // Row 2: Gender
        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Gender:"), gbc);

        gbc.gridx = 1;
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        otherRadio = new JRadioButton("Other");

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        genderPanel.add(otherRadio);
        formPanel.add(genderPanel, gbc);

        // Row 3: Course
        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Course:"), gbc);

        gbc.gridx = 1;
        courseComboBox = new JComboBox<>(new String[]{
                "-- Select Course --", "B.Tech", "B.Sc", "MCA", "B.A", "M.Tech", "M.Sc"
        });
        formPanel.add(courseComboBox, gbc);

        // Row 4: Hobbies
        gbc.gridx = 0;
        gbc.gridy = 4;
        formPanel.add(new JLabel("Hobbies:"), gbc);

        gbc.gridx = 1;
        readingCheckBox = new JCheckBox("Reading");
        travelingCheckBox = new JCheckBox("Traveling");
        gamingCheckBox = new JCheckBox("Gaming");

        JPanel hobbiesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        hobbiesPanel.add(readingCheckBox);
        hobbiesPanel.add(travelingCheckBox);
        hobbiesPanel.add(gamingCheckBox);
        formPanel.add(hobbiesPanel, gbc);

        // Row 5: Buttons
        gbc.gridx = 1;
        gbc.gridy = 5;
        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        buttonPanel.add(submitButton);
        buttonPanel.add(resetButton);
        formPanel.add(buttonPanel, gbc);

        // Action events
        submitButton.addActionListener(e -> submitForm());
        resetButton.addActionListener(e -> resetForm());

        mainPanel.add(formPanel, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }

    private void submitForm() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String gender = maleRadio.isSelected() ? "Male" :
                femaleRadio.isSelected() ? "Female" :
                        otherRadio.isSelected() ? "Other" : "Not selected";
        String course = (String) courseComboBox.getSelectedItem();

        StringBuilder hobbies = new StringBuilder();
        if (readingCheckBox.isSelected()) hobbies.append("Reading, ");
        if (travelingCheckBox.isSelected()) hobbies.append("Traveling, ");
        if (gamingCheckBox.isSelected()) hobbies.append("Gaming, ");
        if (hobbies.length() > 0) hobbies.setLength(hobbies.length() - 2);

        if (name.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name and Email cannot be empty.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (course.equals("-- Select Course --")) {
            JOptionPane.showMessageDialog(this, "Please select a valid course.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String info = "Name: " + name + "\n"
                + "Email: " + email + "\n"
                + "Gender: " + gender + "\n"
                + "Course: " + course + "\n"
                + "Hobbies: " + (hobbies.length() > 0 ? hobbies.toString() : "None");

        JOptionPane.showMessageDialog(this, info, "Submitted Data", JOptionPane.INFORMATION_MESSAGE);
    }

    private void resetForm() {
        nameField.setText("");
        emailField.setText("");
        maleRadio.setSelected(false);
        femaleRadio.setSelected(false);
        otherRadio.setSelected(false);
        courseComboBox.setSelectedIndex(0);
        readingCheckBox.setSelected(false);
        travelingCheckBox.setSelected(false);
        gamingCheckBox.setSelected(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentRegistrationForm::new);
    }
}
