import java.awt.*;
import javax.swing.*;

public class StudentGradeCalculatorGUI extends JFrame {
    private JTextField numSubjectsField;
    private JPanel marksPanel;
    private JButton calculateButton;
    private JButton resetButton;
    private JTextArea resultArea;
    private JTextField[] marksFields;

    public StudentGradeCalculatorGUI() {
        setTitle("Student Grade Calculator");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Number of Subjects: "));
        numSubjectsField = new JTextField(5);
        topPanel.add(numSubjectsField);

        JButton generateFieldsButton = new JButton("Generate Fields");
        topPanel.add(generateFieldsButton);

        add(topPanel, BorderLayout.NORTH);

        marksPanel = new JPanel();
        marksPanel.setLayout(new GridLayout(0, 2, 10, 10));
        add(marksPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));

        JPanel buttonPanel = new JPanel(new FlowLayout());
        calculateButton = new JButton("Calculate");
        resetButton = new JButton("Reset");
        calculateButton.setEnabled(false);
        buttonPanel.add(calculateButton);
        buttonPanel.add(resetButton);

        bottomPanel.add(buttonPanel, BorderLayout.NORTH);

        resultArea = new JTextArea(6, 30);
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Arial", Font.PLAIN, 14));
        resultArea.setBorder(BorderFactory.createTitledBorder("Result"));
        bottomPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        add(bottomPanel, BorderLayout.SOUTH);
        generateFieldsButton.addActionListener(e -> generateFields());
        calculateButton.addActionListener(e -> calculateGrades());
        resetButton.addActionListener(e -> resetCalculator());
    }

    private void generateFields() {
        String input = numSubjectsField.getText().trim();

        try {
            int numSubjects = Integer.parseInt(input);

            if (numSubjects <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Number of subjects must be greater than 0!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            marksPanel.removeAll();
            marksFields = new JTextField[numSubjects];

            for (int i = 0; i < numSubjects; i++) {
                marksPanel.add(new JLabel("Subject " + (i + 1) + " Marks: "));
                marksFields[i] = new JTextField();
                marksPanel.add(marksFields[i]);
            }

            marksPanel.revalidate();
            marksPanel.repaint();
            calculateButton.setEnabled(true);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter a valid number of subjects!",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateGrades() {
        int totalMarks = 0;
        int numSubjects = marksFields.length;

        for (int i = 0; i < numSubjects; i++) {
            try {
                int mark = Integer.parseInt(marksFields[i].getText().trim());

                if (mark < 0 || mark > 100) {
                    JOptionPane.showMessageDialog(this,
                            "Marks for subject " + (i + 1) + " must be between 0 and 100!",
                            "Invalid Marks",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                totalMarks += mark;

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid marks for subject " + (i + 1) + "!",
                        "Invalid Input",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        double averagePercentage = (double) totalMarks / numSubjects;
        String grade = getGrade(averagePercentage);

        resultArea.setText("Total Marks: " + totalMarks + " / " + (numSubjects * 100) +
                "\nAverage Percentage: " + String.format("%.2f", averagePercentage) + "%" +
                "\nGrade: " + grade +
                "\nFeedback: " + getFeedback(grade));
    }

    private void resetCalculator() {
        numSubjectsField.setText("");
        marksPanel.removeAll();
        marksPanel.revalidate();
        marksPanel.repaint();
        resultArea.setText("");
        calculateButton.setEnabled(false);
    }

    private String getGrade(double percentage) {
        if (percentage >= 90) return "A+";
        else if (percentage >= 80) return "A";
        else if (percentage >= 70) return "B";
        else if (percentage >= 60) return "C";
        else if (percentage >= 50) return "D";
        else return "F";
    }

    private String getFeedback(String grade) {
        return switch (grade) {
            case "A+", "A" -> "🌟 Excellent performance!";
            case "B" -> "👍 Good job, keep improving.";
            case "C" -> "🙂 Fair effort, but work harder.";
            case "D" -> "⚠️ Needs improvement.";
            default -> "❌ Failed, better luck next time.";
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentGradeCalculatorGUI gui = new StudentGradeCalculatorGUI();
            gui.setVisible(true);
        });
    }
}
