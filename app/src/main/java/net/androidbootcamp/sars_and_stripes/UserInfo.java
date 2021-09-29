package net.androidbootcamp.sars_and_stripes;

public class UserInfo {
    private int userId;
    private String userName;
    private String passWord;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    Profile profile =  new Profile();

    //constructors
    public UserInfo(int userId, String userName, String passWord, String email, String firstName, String lastName,
                    String phoneNumber, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.userId = userId;


    }
    public UserInfo() {}

    // toString function to convert over to text for output to our app
    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" +firstName + '\'' +
                ", lastName='" +lastName + '\'' +
                ", phoneNumber='" +phoneNumber + '\'' +
                ", address='" +address + '\'' +

                '}';
    }

    //getters and setters
    public void setUserId (int userId){
        this.userId = userId;
    }
    public int getUserId(){
        return this.userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;

    }
    public String getUserName() {

        profile.getProfileUsername(userName);
        return this.userName;
    }

    public void setPassWord (String passWord){
        this.passWord = passWord;
    }
    public String getPassWord(){
        return this.passWord;
    }

    public void setEmail (String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }

    public void setFirstName (String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName (String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return this.lastName;
    }

    public void setPhoneNumber (String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setAddress (String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }


}
