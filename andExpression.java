public class andExpression implements  expression{
    private terminalExpression first_terminalExpression;
    private terminalExpression second_termTerminalExpression;
    private int note;

    public andExpression(terminalExpression first_terminalExpression,terminalExpression second_termTerminalExpression){
        first_terminalExpression = first_terminalExpression;
        second_termTerminalExpression = second_termTerminalExpression;
        note = first_terminalExpression.getNote() + second_termTerminalExpression.getNote();
    }
    @Override
    public boolean interpet(String context) {
        return first_terminalExpression.interpet(context) && second_termTerminalExpression.interpet(context);
    }
}
