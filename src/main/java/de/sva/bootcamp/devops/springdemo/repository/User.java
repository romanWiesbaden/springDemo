package de.sva.bootcamp.devops.springdemo.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table("users")
public class User implements Persistable<Integer> {

    @Id
    private int userId;

    private String firstName;

    private String lastName;

    @Transient
    private boolean isNew;

    public User() {}

    public User(int userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }


    @Override
    public Integer getId() {
        return userId;
    }

    @Override
    public boolean isNew() {
        return this.isNew;
    }
}
