package com.didi.component.splitfare.contactmanage;

import android.text.TextUtils;
import com.didi.safetoolkit.business.share.util.SfCharMapUtil;

public class GlobalContactsDataBaseModel extends GlobalContactsModel implements Comparable<GlobalContactsDataBaseModel> {

    /* renamed from: id */
    public long f15923id;

    public int compareTo(GlobalContactsDataBaseModel globalContactsDataBaseModel) {
        if (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(globalContactsDataBaseModel.name)) {
            return -1;
        }
        return compareTo(globalContactsDataBaseModel, 0);
    }

    public int compareTo(GlobalContactsDataBaseModel globalContactsDataBaseModel, int i) {
        if (i < this.name.length() || i < globalContactsDataBaseModel.name.length()) {
            if (i >= this.name.length()) {
                return -1;
            }
            if (i >= globalContactsDataBaseModel.name.length()) {
                return 1;
            }
            char charAt = globalContactsDataBaseModel.name.charAt(i);
            char charAt2 = this.name.charAt(i);
            if (i == 0) {
                charAt = SfCharMapUtil.getGroupCharForSort(charAt);
                charAt2 = SfCharMapUtil.getGroupCharForSort(charAt2);
            }
            if (charAt2 > charAt) {
                return 1;
            }
            if (charAt2 < charAt) {
                return -1;
            }
            return compareTo(globalContactsDataBaseModel, i + 1);
        } else if (this.f15923id > globalContactsDataBaseModel.f15923id) {
            return 1;
        } else {
            return -1;
        }
    }
}
