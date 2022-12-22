package com.didi.soda.customer.p165h5.hybird.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.didi.soda.customer.h5.hybird.model.ContactModel */
public class ContactModel {
    @SerializedName("first_name")
    public String firstName;
    @SerializedName("last_name")
    public String lastName;
    @SerializedName("middle_name")
    public String middleName;
    @SerializedName("name")
    public String name;
    @SerializedName("phone")
    public List<String> phoneNum;
}
