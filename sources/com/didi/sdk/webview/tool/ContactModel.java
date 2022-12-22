package com.didi.sdk.webview.tool;

import com.google.gson.annotations.SerializedName;
import java.util.List;

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
