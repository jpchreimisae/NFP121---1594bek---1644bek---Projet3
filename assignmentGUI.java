import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class assignmentGUI extends JPanel {
    JLabel title, resultTitle, orLabel, addContextLabel,criteriaLabel;
    JFileChooser fileChooser;
    ArrayList <criteria> allCriteria = new ArrayList<criteria>();
    JComboBox selectCriteria;
    JTextArea textArea;
    JScrollPane scrollPane;
    JButton submitButton;
    JPanel topPanel;
    JPanel rightPanel;
    JPanel centerPanel;
    GridBagConstraints gbc = new GridBagConstraints();

    assignmentGUI(){

        topPanel = new JPanel();
        title = new JLabel("Check Assignment");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        topPanel.add(title);

        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.add(Box.createRigidArea(new Dimension(0,5)));
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(Box.createHorizontalGlue());

        addContextLabel = new JLabel("Add your context here");
        addContextLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea = new JTextArea("Enter your text here", 50,50);
        scrollPane = new JScrollPane(textArea);
        orLabel = new JLabel("Or choose a file");
        orLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        fileChooser = new JFileChooser();

        selectCriteria = new JComboBox();
        criteriaLabel = new JLabel("Select Criteria");
        criteriaLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectCriteria.setModel(new DefaultComboBoxModel<String>(allCriteria.toArray(new String[0])));
        submitButton = new JButton("Check Assignment");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        rightPanel.add(criteriaLabel);
        rightPanel.add(selectCriteria);
        rightPanel.add(addContextLabel);
        rightPanel.add(scrollPane);
        rightPanel.add(orLabel);
        rightPanel.add(fileChooser);
        rightPanel.add(submitButton);

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.blue);
        resultTitle = new JLabel("Results");
        centerPanel.add(resultTitle);

        setLayout(new BorderLayout());
        add(rightPanel, BorderLayout.EAST);
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);


    }
}
