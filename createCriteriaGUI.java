import javax.naming.Binding;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class createCriteriaGUI extends JPanel {

    JPanel gridPanel, topPanel, centerPanel,bottomPanel;
    JLabel title;
    //Titles for the header
    JLabel expressionNumberLabel, firstExpressionLabel,noteForFirstExpressionLabel,andOrLabel, secondExpressionLabel  ,noteForSecondExpressionLabel;
    //For the first expression
    JLabel expressionNumberLabel1;
    JTextField  andOrTextField1, firstExpressionTextField1, secondExpressionTextField1, noteForFirstExpressionTextField1, noteForSecondExpressionTextField1;
    //For the second expression
    JLabel expressionNumberLabel2;
    JTextField  andOrTextField2, firstExpressionTextField2, secondExpressionTextField2, noteForFirstExpressionTextField2, noteForSecondExpressionTextField2;
    //TODO: Add 3 more expressions
    JTextField criteriaNameTextField;
    JButton createCriteriaButton;


    createCriteriaGUI(){
        //Initializing the Panels
        setLayout(new BorderLayout());
        topPanel = new JPanel();
        gridPanel = new JPanel(new GridLayout(3,7));
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        bottomPanel = new JPanel();

        title = new JLabel("Create Criteria");

        expressionNumberLabel = new JLabel("Expression Number");
        firstExpressionLabel = new JLabel("First Expression");
        noteForFirstExpressionLabel = new JLabel("Note for Exp1");
        andOrLabel = new JLabel("And/Or");
        secondExpressionLabel = new JLabel("Second Expression");
        noteForSecondExpressionLabel = new JLabel("Note for Exp2");

        //For the first expression
        expressionNumberLabel1 = new JLabel("Expression Number 1 :");
        firstExpressionTextField1 = new JTextField();
        noteForFirstExpressionTextField1 = new JTextField(2);
        andOrTextField1 = new JTextField();
        secondExpressionTextField1 = new JTextField();
        noteForSecondExpressionTextField1 = new JTextField(2);

        //For the second expression
        expressionNumberLabel2 = new JLabel("Expression Number 2 :");
        firstExpressionTextField2 = new JTextField();
        noteForFirstExpressionTextField2 = new JTextField(2);
        andOrTextField2 = new JTextField();
        secondExpressionTextField2 = new JTextField();
        noteForSecondExpressionTextField2 = new JTextField(2);


        //For the bottom panel
        criteriaNameTextField = new JTextField(10);
        createCriteriaButton = new JButton("Create Criteria");
        createCriteriaButton.addActionListener(new generateListener());

        topPanel.add(title);

        gridPanel.add(expressionNumberLabel);
        gridPanel.add(firstExpressionLabel);
        gridPanel.add(noteForFirstExpressionLabel);
        gridPanel.add(andOrLabel);
        gridPanel.add(secondExpressionLabel);
        gridPanel.add(noteForSecondExpressionLabel);

        gridPanel.add(expressionNumberLabel1);
        gridPanel.add(firstExpressionTextField1);
        gridPanel.add(noteForFirstExpressionTextField1);
        gridPanel.add(andOrTextField1);
        gridPanel.add(secondExpressionTextField1);
        gridPanel.add(noteForSecondExpressionTextField1);

        gridPanel.add(expressionNumberLabel2);
        gridPanel.add(firstExpressionTextField2);
        gridPanel.add(noteForFirstExpressionTextField2);
        gridPanel.add(andOrTextField2);
        gridPanel.add(secondExpressionTextField2);
        gridPanel.add(noteForSecondExpressionTextField2);

        centerPanel.add(gridPanel);

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

            //Expression1
            //Name of the expression
            //First Expression
            String finalExpression1 = firstExpressionTextField1.getText();
            //Second Expression
            String finalExpression2 = secondExpressionTextField1.getText();
            //Or or And
            String finalOrAnd = andOrTextField1.getText();
            //Note

            //we should check the name
            if (finalCriteriaName.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please add a name for the criteria");
                System.out.println("Didn't create any new criteria as there's no specified name to it");
            }else //name exists{
                newCriteria = new criteria(finalCriteriaName);
            //if we got one expression
                if (finalExpression2.isEmpty() && !finalExpression1.isEmpty() && finalOrAnd.isEmpty()) {
                    terminalExpression finalTerminalExpression = new terminalExpression(finalExpression1);
                    System.out.println("New Terminal Expression from first field");
                    //If there's a given note, by default it's one
                    /**
                    if (noteForFirstExpressionTextField1.equals(null) == false){
                       finalTerminalExpression.setNote(Integer.parseInt(noteForFirstExpressionTextField1.getText()));
                    }
                     **/
                    //Add the expression to the criteria
                    newCriteria.addExpression(finalTerminalExpression);
                    System.out.println("Added to criteria");
                    //Also if there's one expression
                }else if(finalExpression1.isEmpty() && !finalExpression2.isEmpty() && finalOrAnd.isEmpty()){
                    terminalExpression finalTerminalExpression = new terminalExpression(finalExpression2);
                  /**  if (noteForFirstExpressionTextField1.equals(null) == false){
                        finalTerminalExpression.setNote(Integer.parseInt(noteForFirstExpressionTextField2.getText()));
                    }
                   **/
                    newCriteria.addExpression(finalTerminalExpression);
                    //If there's 2 expressions but not a logical statement
                } else if(finalOrAnd.isEmpty() || !finalOrAnd.equalsIgnoreCase("or") || !finalOrAnd.equalsIgnoreCase("and") && !finalExpression1.isEmpty() && !finalExpression2.isEmpty()){
                    System.out.println("Non Valid Logical Statement");
                    JOptionPane.showMessageDialog(null, "Non Valid Logical Statement in expression 1");
                }else if(finalOrAnd.equalsIgnoreCase("or")){
                    newCriteria.addExpression(new orExpression(
                            new terminalExpression(finalExpression1), new terminalExpression(finalExpression2)));
                    System.out.println("Created a new OR Expression");
                }else if(finalOrAnd.equalsIgnoreCase("and")){
                    newCriteria.addExpression(new andExpression(
                            new terminalExpression(finalExpression1), new terminalExpression(finalExpression2)));
                    System.out.println("Created a new AND Expression");
                }




        }
    }
}
