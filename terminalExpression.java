public class terminalExpression implements expression{
    private String data;
    private int note = 1;
    public terminalExpression(String data) {
        data = data;

    }

    public int getNote() {
        return note;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public boolean interpet(String context) {
        boolean returnedValue;
        if (context.contains(data)){
            //Debugging
            System.out.println("Interpet Succeded and returned True");
            returnedValue = true;
        }else{
            //Debugging
            System.out.println("Interpet Succeded and returned False");
            returnedValue = true;
        }
        return returnedValue;
    }
}
