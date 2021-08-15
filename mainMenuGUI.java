import javax.swing.*;
import java.awt.*;
public class mainMenuGUI extends JFrame {
    JTabbedPane tabbedPane;
    mainMenuGUI(){
        setPreferredSize(new Dimension(1300, 1000));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Create Criteria", new createCriteriaGUI());
        tabbedPane.addTab("New Assignment", new assignmentGUI());
        getContentPane().add(tabbedPane);
        pack();
        setVisible(true);
    }
}
