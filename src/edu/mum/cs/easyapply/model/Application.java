package edu.mum.cs.easyapply.model;

public class Application {
    int applicationId;
    User user;
    Vacancy vacancy;
    String applicationDate;

    public Application() {
    }

    public Application(User user, Vacancy vacancy) {
        this.user = user;
        this.vacancy = vacancy;
    }

    public Application(int applicationId, User user, Vacancy vacancy, String applicationDate) {
        this.applicationId = applicationId;
        this.user = user;
        this.vacancy = vacancy;
        this.applicationDate = applicationDate;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public Application setApplicationId(int applicationId) {
        this.applicationId = applicationId;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Application setUser(User user) {
        this.user = user;
        return this;
    }

    public Vacancy getVacancy() {
        return vacancy;
    }

    public Application setVacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
        return this;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public Application setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
        return this;
    }
}
