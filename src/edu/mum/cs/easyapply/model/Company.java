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

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(String joinedDate) {
        this.joinedDate = joinedDate;
    }
}
