package com.didi.component.splitfare.contactmanage;

import com.didi.travel.psnger.common.net.base.BaseObject;

public class GlobalContactsModel extends BaseObject {
    public static final int GROUP_HEADER_TYPE = 3;
    public static final int SOS_TYPE = 2;
    public static final int SYSTEM_CONTACTS_TYPE = 1;
    public boolean canSelected = true;
    public boolean checked = false;
    public String name = "";
    public String originPhone = "";
    public String phone = "";
    public int type = 1;

    public boolean equals(Object obj) {
        if (obj instanceof GlobalContactsModel) {
            String str = this.name;
            if (str == null) {
                return false;
            }
            if (this.type == 3) {
                GlobalContactsModel globalContactsModel = (GlobalContactsModel) obj;
                if (globalContactsModel.type == 3 && str.equals(globalContactsModel.name)) {
                    return true;
                }
            }
            if (this.phone == null) {
                return false;
            }
            GlobalContactsModel globalContactsModel2 = (GlobalContactsModel) obj;
            if (this.name.equals(globalContactsModel2.name) && this.phone.equals(globalContactsModel2.phone)) {
                return true;
            }
        }
        return super.equals(obj);
    }
}
