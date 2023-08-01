package com.db.grad.javaapi.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dogs")
public class Dog {

    @Id
    private long id;
    private String name;
    private long age;

    @Column( name = "dog_id", nullable = false)
    public long getId() {
        return id;
    }
    @Column( name = "name", nullable = false)
    public String getName() {
        return name;
    }
    @Column( name = "age", nullable = false)
    public long getAge() {
        return age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(long age) {
        this.age = age;
    }
}
