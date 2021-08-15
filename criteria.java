import java.util.ArrayList;

public class criteria {
    private String criteriaName;
    private ArrayList<terminalExpression> allExpression;
    criteria(String criteriaName){
        criteriaName = criteriaName;
    }

    public String getCriteriaName() {
        return criteriaName;
    }
    public ArrayList<terminalExpression> getAllExpression() {
        return allExpression;
    }

    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }

    public void setAllExpression(ArrayList<terminalExpression> allExpression) {
        this.allExpression = allExpression;
    }

    @Override
    public String toString() {
        return "criteria{" +
                "criteriaName='" + criteriaName + '\'' +
                ", allExpression=" + allExpression +
                '}';
    }
    public boolean addExpression(terminalExpression newTerminalExpression) {
        //Check if expression already exists
        if (allExpression.contains(newTerminalExpression)) {
            //Add to interface
            System.out.println("Item already exists in this criteria");
            return false;
        } else {
            //Add to interface
            allExpression.add(newTerminalExpression);
            return true;
        }
    }
    public boolean removeExpression(terminalExpression oldTerminalExpression){
        //Check if expression exists
        if (allExpression.contains(oldTerminalExpression) == false){
            //Add interface
            System.out.println("Can't delete an expression that doesn't exists in this criteria");
            return false;
        }else{
            allExpression.remove(oldTerminalExpression);
            System.out.println("Expression successfully removed from this criteria");
            return true;
        }
    }
}
