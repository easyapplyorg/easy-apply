package edu.mum.cs.easyapply.model;

public class Application {
    int userId;
    int vacancyId;

    public Application() {
    }

    public Application(int userId, int vacancyId) {
        this.userId = userId;
        this.vacancyId = vacancyId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVacancyId() {
        return vacancyId;
    }

    public void setVacancyId(int vacancyId) {
        this.vacancyId = vacancyId;
    }
}
