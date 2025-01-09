package com.example.BookManagementSystem.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "library")
public class LibraryMember {

    private String id;
    private String name;
    private String email;
    private String membershipType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }
}
