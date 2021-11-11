package com.timeacc.model.dao;

import com.timeacc.model.entity.ActivCategory;
import com.timeacc.model.entity.Activity;
import com.timeacc.model.entity.ActivityState;

import java.sql.Timestamp;

public class DemoDAO {
    public static void main(String... args){
        ActivityDAO activityDAO = new ActivityDAO();
        System.out.println("activityDAO.getPlainActivityById(1): " + activityDAO.getPlainActivityById(1));
        System.out.println("Before insert: " + activityDAO.getAllActivities());
        Activity activity = new Activity();
        activity.setActivityNameUa("активО");
        activity.setActivityNameEn("activO");
        activity.setInitDate(Timestamp.valueOf("2021-11-11 16:00:00"));
        activity.setEndDate(Timestamp.valueOf("2021-11-11 17:00:00"));
        ActivCategory activCategory = new ActivCategory();
        activCategory.setId(1);
        activity.setActivCategory(activCategory);
        activity.setActivityState(ActivityState.PROCESS);
        activityDAO.insertActivity(activity);
        System.out.println("After insert: " + activityDAO.getAllActivities());
    }
}
