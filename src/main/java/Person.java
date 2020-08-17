import com.github.javafaker.Faker;

public class Person {

    private String name;
    private String phone;
    private String country;
    private String zipCode;
    private String city;
    private String streetName;
    private String buildingNumber;

    public Person(Faker faker) {
        this.name = faker.name().name();
        this.phone = faker.phoneNumber().phoneNumber();
        this.country = faker.address().country();
        this.zipCode = faker.address().zipCode();
        this.city = faker.address().city();
        this.streetName = faker.address().streetName();
        this.buildingNumber = faker.address().buildingNumber();
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    @Override
    public String toString() {
        return name + "; " + zipCode + ", " + country + ", " +
                city + ", " + streetName + ", " + buildingNumber + "; " + phone;
    }
}
