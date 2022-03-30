package com.example.android.vocalforlocal.Model;

public class Users {
    private String name, phone, password, image, address;

    public Users(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getImage() {
        return image;
    }

    public String getAddress() {
        return address;
    }
}
