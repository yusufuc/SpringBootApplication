package com.example.practice.entities;

import javax.persistence.*;

@Entity
@Table(name="user",schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private Long id;
    private String name;
    private String city;
    private String status;

    public User(Long id,String name,String city,String status)
    {
        super();
        this.name=name;
        this.city=city;
        this.status=status;
    }

    public User()
    {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
