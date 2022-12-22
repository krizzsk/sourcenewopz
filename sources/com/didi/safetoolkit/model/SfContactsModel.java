package com.didi.safetoolkit.model;

import java.io.Serializable;

public class SfContactsModel implements ISfBaseObject, Serializable {
    public static final int GROUP_HEADER_TYPE = 3;
    public static final int SOS_TYPE = 2;
    public static final int SYSTEM_CONTACTS_TYPE = 1;
    public boolean checked = false;
    public String name;
    public boolean need_areacode;
    public String origin_phone;
    public String phone;
    public String phone_encode;
    public String phone_mask;
    public int type = 1;

    public boolean equals(Object obj) {
        if (obj instanceof SfContactsModel) {
            if (this.type == 3) {
                SfContactsModel sfContactsModel = (SfContactsModel) obj;
                if (sfContactsModel.type == 3 && this.name.equals(sfContactsModel.name)) {
                    return true;
                }
            }
            SfContactsModel sfContactsModel2 = (SfContactsModel) obj;
            if (this.name.equals(sfContactsModel2.name) && this.phone.equals(sfContactsModel2.phone)) {
                return true;
            }
        }
        return super.equals(obj);
    }
}
