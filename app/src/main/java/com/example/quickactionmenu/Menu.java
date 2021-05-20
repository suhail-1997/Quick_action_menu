package com.example.quickactionmenu;

import androidx.annotation.NonNull;


/**
 * Designed and Developed by Mohammad suhail ahmed on 19/02/2020
 */
public class Menu {
    public int menuid;

    public int categoryid;

    public int subcategoryid;

    public String name;

    public float price;

    public String type;

    public Menu(int menuid, int categoryid, int subcategoryid, String name, float price, String type)
    {
        this.menuid = menuid;
        this.categoryid =categoryid;
        this.subcategoryid = subcategoryid;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getSubcategoryid() {
        return subcategoryid;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price){
        this.price=price;
    }
    public int getMenuid() {
        return menuid;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
