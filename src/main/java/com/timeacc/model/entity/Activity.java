package com.timeacc.model.entity;

import java.sql.Timestamp;
import java.util.List;

public class Activity {
    private int id;
    private String activityNameUa;
    private String activityNameEn;
    private Timestamp initDate;
    private Timestamp endDate;
    private ActivCategory activCategory;
    private List<User> users;
    private ActivityState activityState;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityNameUa() {
        return activityNameUa;
    }

    public void setActivityNameUa(String activityNameUa) {
        this.activityNameUa = activityNameUa;
    }

    public String getActivityNameEn() {
        return activityNameEn;
    }

    public void setActivityNameEn(String activityNameEn) {
        this.activityNameEn = activityNameEn;
    }

    public Timestamp getInitDate() {
        return initDate;
    }

    public void setInitDate(Timestamp initDate) {
        this.initDate = initDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public ActivCategory getActivCategory() {
        return activCategory;
    }

    public void setActivCategory(ActivCategory activCategory) {
        this.activCategory = activCategory;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public ActivityState getActivityState() {
        return activityState;
    }

    public void setActivityState(ActivityState activityState) {
        this.activityState = activityState;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", activityNameUa='" + activityNameUa + '\'' +
                ", activityNameEn='" + activityNameEn + '\'' +
                ", initDate=" + initDate +
                ", endDate=" + endDate +
                ", activCategory=" + activCategory +
                ", users=" + users +
                ", activityState=" + activityState +
                '}';
    }
}
