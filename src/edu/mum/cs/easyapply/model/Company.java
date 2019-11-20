package edu.mum.cs.easyapply.model;

public class Company {
    int companyId;
    String name;
    String location;
    String industry;
    String website;
    String joinedDate;

    public Company() {
    }

    public Company(int companyId, String name, String location, String industry, String website, String joinedDate) {
        this.companyId = companyId;
        this.name = name;
        this.location = location;
        this.industry = industry;
        this.website = website;
        this.joinedDate = joinedDate;
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
}
