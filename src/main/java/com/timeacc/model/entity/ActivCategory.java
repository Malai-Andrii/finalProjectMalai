package com.timeacc.model.entity;

import java.util.List;

public class ActivCategory {
    private int id;
    private String activCategoryNameUa;
    private String activCategoryNameEn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivCategoryNameUa() {
        return activCategoryNameUa;
    }

    public void setActivCategoryNameUa(String activCategoryNameUa) {
        this.activCategoryNameUa = activCategoryNameUa;
    }

    public String getActivCategoryNameEn() {
        return activCategoryNameEn;
    }

    public void setActivCategoryNameEn(String activCategoryNameEn) {
        this.activCategoryNameEn = activCategoryNameEn;
    }

    @Override
    public String toString() {
        return "ActivCategory{" +
                "id=" + id +
                ", activCategoryNameUa='" + activCategoryNameUa + '\'' +
                ", activCategoryNameEn='" + activCategoryNameEn + '\'' +
                '}';
    }
}
