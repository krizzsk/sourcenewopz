package com.didi.soda.customer.foundation.rpc.entity.address;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;

public class ContactEntity implements IEntity, Cloneable {
    private static final long serialVersionUID = -6030085120041893985L;
    public String callingCode;
    @SerializedName("phoneCountryId")
    public int countryId;
    private String firstName;
    public int lastModifyFrom;
    private String lastName;
    public String nameErrorMsg;
    public String phone;

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setName(String str, String str2) {
        this.firstName = str;
        this.lastName = str2;
    }

    public ContactEntity clone() {
        try {
            return (ContactEntity) super.clone();
        } catch (Exception unused) {
            ContactEntity contactEntity = new ContactEntity();
            contactEntity.firstName = this.firstName;
            contactEntity.lastName = this.lastName;
            contactEntity.phone = this.phone;
            contactEntity.callingCode = this.callingCode;
            contactEntity.countryId = this.countryId;
            return contactEntity;
        }
    }
}
