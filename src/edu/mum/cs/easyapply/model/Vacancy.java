package edu.mum.cs.easyapply.model;

import java.util.Date;

public class Vacancy {
    int vacancyId;
    String title;
    String description;
    Company company;
    String datePosted;

    public Vacancy() {
        super();
    }

    public Vacancy(String title, String description, Company company) {
        this.title = title;
        this.description = description;
        this.company = company;
    }

    public Vacancy(int vacancyId, String title, String description, Company company, String datePosted) {
        this.vacancyId = vacancyId;
        this.title = title;
        this.description = description;
        this.company = company;
        this.datePosted = datePosted;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }
}
