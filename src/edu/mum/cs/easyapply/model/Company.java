package edu.mum.cs.easyapply.model;

public class Company {
    int companyId;
    String name;
    String location;
    String industry;
    String email;
    String website;
    String joinedDate;
    String password;

    public Company() {
    }

    public Company(String name, String location, String industry, String email, String website, String joinedDate, String password) {
        this.name = name;
        this.location = location;
        this.industry = industry;
        this.email = email;
        this.website = website;
        this.joinedDate = joinedDate;
        this.password = password;
    }

    public int getCompanyId() {
        return companyId;
    }

    public Company setCompanyId(int companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public Company setLocation(String location) {
        this.location = location;
        return this;
    }

    public String getIndustry() {
        return industry;
    }

    public Company setIndustry(String industry) {
        this.industry = industry;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Company setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getWebsite() {
        return website;
    }

    public Company setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public Company setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Company setPassword(String password) {
        this.password = password;
        return this;
    }
}
