import javax.naming.Binding;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createCriteriaGUI extends JPanel {
    JLabel title;
    JLabel criteriaNameLabel;
    JPanel girdPanel;
    JLabel expressionNumberLabel, expressionNameLabel, andOrLabel, firstExpressionLabel, secondExpressionLabel;
    JLabel expressionNumberLabel1;
    JTextField expressionNameTextField1, andOrTextField1, firstExpressionTextField1, secondExpressionTextField1;
    JLabel expressionNumberLabel2;
    JTextField expressionNameTextField2, andOrTextField2, firstExpressionTextField2, secondExpressionTextField2;
    JTextField criteriaNameTextField;
    JPanel topPanel, centerPanel,bottomPanel;
    JButton createCriteriaButton;
    createCriteriaGUI(){
        setLayout(new BorderLayout());
        topPanel = new JPanel();
        centerPanel = new JPanel();
        title = new JLabel("Create Criteria");
        topPanel.add(title);

        girdPanel = new JPanel(new GridLayout(3,5));
        expressionNumberLabel = new JLabel("Expression Number");
        expressionNameLabel = new JLabel("Expression Name");
        andOrLabel = new JLabel("And/Or");
        firstExpressionLabel = new JLabel("First Expression");
        secondExpressionLabel = new JLabel("Second Expression");

        expressionNumberLabel1 = new JLabel("Expression Number 1 :");
        expressionNameTextField1 =  new JTextField("Enter expression name here");
        andOrTextField1 = new JTextField("Select And or OR");
        firstExpressionTextField1 = new JTextField("First Expression");
        secondExpressionTextField1 = new JTextField("Second Expression");

        expressionNumberLabel2 = new JLabel("Expression Number 2 :");
        expressionNameTextField2 =  new JTextField("Enter expression name here");
        andOrTextField2 = new JTextField("Select And or OR");
        firstExpressionTextField2 = new JTextField("First Expression");
        secondExpressionTextField2 = new JTextField("Second Expression");


        girdPanel.add(expressionNumberLabel);
        girdPanel.add(expressionNameLabel);
        girdPanel.add(firstExpressionLabel);
        girdPanel.add(andOrLabel);
        girdPanel.add(secondExpressionLabel);

        girdPanel.add(expressionNumberLabel1);
        girdPanel.add(expressionNameTextField1);
        girdPanel.add(firstExpressionTextField1);
        girdPanel.add(andOrTextField1);
        girdPanel.add(secondExpressionTextField1);

        girdPanel.add(expressionNumberLabel2);
        girdPanel.add(expressionNameTextField2);
        girdPanel.add(firstExpressionTextField2);
        girdPanel.add(andOrTextField2);
        girdPanel.add(secondExpressionTextField2);


        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.add(girdPanel);

        bottomPanel = new JPanel();
        criteriaNameTextField = new JTextField("Enter your criteria name");
        createCriteriaButton = new JButton("Create Criteria");
        createCriteriaButton.addActionListener(new generateListener());
        bottomPanel.add(criteriaNameTextField);
        bottomPanel.add(createCriteriaButton);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
    public class generateListener implements ActionListener{
        public  void actionPerformed (ActionEvent event){
            //Creating a criteria
            criteria newCriteria = null;
            terminalExpression finalFirstTerminalExpression = null;
            terminalExpression finalSecondTerminalExpression = null;
            String finalCriteriaName = criteriaNameTextField.getText();

            //String finalExpressionName1 = expressionNameTextField1.getText();
            String finalExpression1 = firstExpressionTextField1.getText();
            String finalExpression2 = secondExpressionTextField1.getText();
            String finalOrAnd = andOrTextField1.getText();

            if(finalCriteriaName.equals("Enter your criteria name") || finalCriteriaName.equals("")){
                JOptionPane.showMessageDialog(null, "Please add a name for the criteria");
            }else if (finalExpression1 == "First Expression" || finalExpression1.isEmpty()){
                JOptionPane.showMessageDialog(null, "You need to add at least one criteria for each expression");
            }else if (!finalExpression1.isEmpty() && !finalExpression2.isEmpty() && finalOrAnd.isEmpty() ){
                JOptionPane.showMessageDialog(null, "You need to add a logical field");
            }else {
                newCriteria = new criteria(finalCriteriaName);
                //Add here the creation of expressions
            }

            if (finalExpression2.isEmpty()){
                terminalExpression finalTerminalExpression = new terminalExpression(finalExpression1);
            }else{

                 finalFirstTerminalExpression = new terminalExpression(finalExpression1);
                 finalSecondTerminalExpression = new terminalExpression(finalExpression2);
                if (finalOrAnd.equalsIgnoreCase("or")){
                //orExpression newOrExpression = new orExpression(finalFirstTerminalExpression,finalSecondTerminalExpression);
                }
            }

        }
    }
}
