package com.api.ramengo.entity;

public class OrderRequest {
    private String broth;
    private String protein;

    public String getBroth() {
        return broth;
    }

    public void setBroth(String broth) {
        this.broth = broth;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }
}
