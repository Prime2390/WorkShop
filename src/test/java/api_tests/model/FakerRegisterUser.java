package api_tests.model;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class FakerRegisterUser {
private String firstName = Faker.instance().name().firstName();
private String lastName = Faker.instance().name().lastName();
private String dateOfBirth = Faker.instance().number().numberBetween(1970, 2000) + "-05-29";
private String street = Faker.instance().address().streetAddress();
private String postalCode = Faker.instance().address().zipCode();
private String city = Faker.instance().address().city();
private String state = Faker.instance().address().state();
private int phoneNumber = Faker.instance().number().numberBetween(100000000,999999999);
private String country = "PL";

public String getFirstName() {
    return firstName;
}
public String getLastName() {
    return lastName;
}
public String getDateOfBirth() {
    return dateOfBirth;
}
public String getStreet() {
    return street;
}
public String getPostalCode() {
    return postalCode;
}
public String getCity() {
    return city;
}
public String getState() {
    return state;
}
public String getPhoneNumber() {
    String number = phoneNumber+"";
    return number;
}
public String getPassword(){
    String password = firstName.substring(0, 3) + lastName.substring(0,3)+ "2025!";
   return password;
}
public String getEmail(){
    String email = firstName.substring(0,3) + lastName.substring(0,3)+ "@gmail.com";
    return email ;
}
public String getCountry(){
    return country;
}

    public Map<String, Object> user() {
        Map<String, Object> address = new HashMap<>();
        address.put("street", street);
        address.put("city", city);
        address.put("state", state);
        address.put("country", country);
        address.put("postal_code", postalCode);

        Map<String, Object> user = new HashMap<>();
        user.put("first_name", firstName);
        user.put("last_name", lastName);
        user.put("address", address);
        user.put("phone", String.valueOf(phoneNumber));
        user.put("dob", dateOfBirth);
        user.put("password", getPassword());
        user.put("email", getEmail());
        return user;
    }
}
