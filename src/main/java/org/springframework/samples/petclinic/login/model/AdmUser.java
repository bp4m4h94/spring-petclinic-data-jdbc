package org.springframework.samples.petclinic.login.model;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;

public class AdmUser {
    @Id
    private Integer user_id;

    private String userName;

//    @NotBlank(message = "Email 不可為空")
    private String email;

    @NotBlank(message = "密碼不可為空")
    private String password;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdmUser{" +
            "userName=" + userName +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
