package com.mandeep.officialcode.Utils;

/**
 * Created by MANDEEP on 17-12-2017.
 */

public class User {
    public String name;
    public String DatsmeId;
    public String email;
    public String age;
    public String password;
    public double lattitude;
    public double longitude;

    public User() {
    }

    public User(String name, String DatsmeId, String email, String age, String password, double lattitude, double longitude) {
        this.name = name;
        this.DatsmeId = DatsmeId;
        this.email = email;
        this.age=age;
        this.password = password;
        this.lattitude = lattitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDatsmeId() {
        return DatsmeId;
    }

    public void setDatsmeId(String datsmeId) {
        DatsmeId = datsmeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", DatsmeId='" + DatsmeId + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", password='" + password + '\'' +
                ", lattitude=" + lattitude +
                ", longitude=" + longitude +
                '}';
    }
}
