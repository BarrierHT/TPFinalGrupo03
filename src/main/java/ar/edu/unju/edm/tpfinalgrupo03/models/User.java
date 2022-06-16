package ar.edu.unju.edm.tpfinalgrupo03.models;

import org.springframework.stereotype.Component;

@Component

public class User {

    private Integer id;
    private Integer idCard;
    private String password;
    private String roleType;
    private String name;
    private String surname;
    private Boolean status = true;

    public User() {
    }

    public User(Integer id, Integer idCard, String password, String roleType, String name, String surname, Boolean status) {
        this.id = id;
        this.idCard = idCard;
        this.password = password;
        this.roleType = roleType;
        this.name = name;
        this.surname = surname;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}