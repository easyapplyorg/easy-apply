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

    public Vacancy setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Vacancy setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Vacancy setDescription(String description) {
        this.description = description;
        return this;
    }

    public Company getCompany() {
        return company;
    }

    public Vacancy setCompany(Company company) {
        this.company = company;
        return this;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public Vacancy setDatePosted(String datePosted) {
        this.datePosted = datePosted;
        return this;
    }
}
