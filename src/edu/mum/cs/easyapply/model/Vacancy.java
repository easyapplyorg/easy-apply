package edu.mum.cs.easyapply.model;

public class Vacancy {
    int vacancyId;
    String title;
    String description;
    int companyId;

    public Vacancy() {
        super();
    }

    public Vacancy(String title, String description, int companyId) {
        this.title = title;
        this.description = description;
        this.companyId = companyId;
    }

    public Vacancy(int vacancyId, String title, String description, int companyId) {
        this.vacancyId = vacancyId;
        this.title = title;
        this.description = description;
        this.companyId = companyId;
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

    public String getDecription() {
        return description;
    }

    public void setDecription(String description) {
        this.description = description;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }
}
