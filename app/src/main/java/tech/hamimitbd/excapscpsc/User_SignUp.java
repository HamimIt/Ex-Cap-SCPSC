package tech.hamimitbd.excapscpsc;


public class User_SignUp {

    public String name;
    public String mobile;
    public String email;
    public String pass;

    public User_SignUp(){

    }

    public User_SignUp(String name, String mobile, String email, String pass ){

        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.pass = pass;

    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }
}
