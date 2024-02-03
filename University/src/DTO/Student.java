package DTO;

public class Student {

    private Long NationalID;
    private String FirstName;
    private String LastName;
    private String Gender;
    private String Phone;
    private String Email;
    private String City;
    private String Street;
    private Long ProgramID;
    private float GPA;

    public Student(Long NationalID, String FirstName, String LastName, String Gender, String Phone, String Email, String City, String Street, Long ProgramID, float GPA) {
        this.NationalID = NationalID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.Phone = Phone;
        this.Email = Email;
        this.City = City;
        this.Street = Street;
        this.ProgramID = ProgramID;
        this.GPA = GPA;
    }
    public Student(Long NationalID, String FirstName, String LastName, String Gender, String Phone, String Email, String City, String Street, Long ProgramID) {
        this.NationalID = NationalID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Gender = Gender;
        this.Phone = Phone;
        this.Email = Email;
        this.City = City;
        this.Street = Street;
        this.ProgramID = ProgramID;
        
    }

    public Long getNationalID() {
        return NationalID;
    }

    public void setNationalID(Long NationalID) {
        this.NationalID = NationalID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public Long getProgramID() {
        return ProgramID;
    }

    public void setProgramID(Long ProgramID) {
        this.ProgramID = ProgramID;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }
}
