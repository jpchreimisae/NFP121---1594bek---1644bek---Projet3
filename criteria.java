import java.util.ArrayList;

public class criteria {
    private String criteriaName;
    private ArrayList<expression> allExpression;
    criteria(String criteriaName){
        criteriaName = criteriaName;
        allExpression = new ArrayList<>();
    }

    public String getCriteriaName() {
        return criteriaName;
    }
    public ArrayList<expression> getAllExpression() {
        return allExpression;
    }
    public void setCriteriaName(String criteriaName) {
        this.criteriaName = criteriaName;
    }
    public void setAllExpression(ArrayList<expression> allExpression) {
        this.allExpression = allExpression;
    }

    @Override
    public String toString() {
        return "criteria{" +
                "criteriaName='" + criteriaName + '\'' +
                ", allExpression=" + allExpression +
                '}';
    }
    public void addExpression(expression newTerminalExpression) {
        //Check if expression already exists
        if (allExpression != null && allExpression.contains(newTerminalExpression)) {
            //Add to interface
            System.out.println("Item already exists in this criteria");
        } else {
            //Add to interface
            allExpression.add(newTerminalExpression);
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
