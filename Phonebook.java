package TH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phonebook{
    private static String phoneNumber="\\d{1,3}$";
    private String contactGroup,name,gender,address;
    private static String email="^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private Pattern pattern;

    public Phonebook(String phoneNumber, String contactGroup, String name, String gender, String address, String email) {
        this.phoneNumber = phoneNumber;
        this.contactGroup = contactGroup;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;

    }
    public boolean validateSDT(String regex){
        Pattern pattern = Pattern.compile(phoneNumber);
        Matcher matcher= pattern.matcher(regex);
        return matcher.matches();
    }
    public boolean validateEmail(String regex){
        Matcher matcher = pattern.matcher(regex);
        return  matcher.matches();
    }

    public Phonebook() {
    }

    public static String getPhoneNumber() {
        return phoneNumber;
    }

    public static void setPhoneNumber(String phoneNumber) {
        Phonebook.phoneNumber = phoneNumber;
    }

    public String getContactGroup() {
        return contactGroup;
    }

    public void setContactGroup(String contactGroup) {
        this.contactGroup = contactGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Phonebook.email = email;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    @Override
    public String toString() {
        return phoneNumber +","+contactGroup+","+name+","+gender+","+gender+","+address+","+email;
    }
}
