package com.DevCorner.DevCorner.models;

import org.bson.types.ObjectId;

public class Account {

    public ObjectId id;
    public String email;
    public String name;
    public String locale;
    public String familyName;
    public String givenName;
    public Boolean isAdmin;

    public Account(String email, String name, String locale, String familyName, String givenName, Boolean isAdmin)
    {
        this.id = new ObjectId();
        this.email = email;
        this.name = name;
        this.locale = locale;
        this.familyName = familyName;
        this.givenName = givenName;
        this.isAdmin = isAdmin;
    }


    public boolean equals(Object obj){
        if (obj.getClass() == this.getClass()) {
            if(
                    this.email.equals(((Account) obj).email) &&
                    this.name.equals(((Account)obj).name) &&
                    this.isAdmin == ((Account)obj).isAdmin
            ) {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }

    }
}