public class teacher {
    private String firstName;
    private String password;

    public teacher(String firstName, String password){
        firstName = firstName;
        password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
