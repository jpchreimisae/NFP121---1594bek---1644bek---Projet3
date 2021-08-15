public class terminalExpression implements expression{
    private String data;
    public terminalExpression(String data){
        data = data;
    }

    @Override
    public boolean interpet(String context) {
        if (context.contains(data)){
            //Debugging
            System.out.println("Interpet Succeded and returned True");
            return true;
        }else{
            //Debugging
            System.out.println("Interpet Succeded and returned False");
            return false;
        }
    }
}
