package com.didi.component.common.contacts;

import android.text.TextUtils;
import com.didi.safetoolkit.business.share.util.SfCharMapUtil;

public class GCommonContactsDataBaseModel extends GCommonContactsModel implements Comparable<GCommonContactsDataBaseModel> {

    /* renamed from: id */
    public long f11494id;

    public int compareTo(GCommonContactsDataBaseModel gCommonContactsDataBaseModel) {
        if (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(gCommonContactsDataBaseModel.name)) {
            return -1;
        }
        return compareTo(gCommonContactsDataBaseModel, 0);
    }

    public int compareTo(GCommonContactsDataBaseModel gCommonContactsDataBaseModel, int i) {
        if (i < this.name.length() || i < gCommonContactsDataBaseModel.name.length()) {
            if (i >= this.name.length()) {
                return -1;
            }
            if (i >= gCommonContactsDataBaseModel.name.length()) {
                return 1;
            }
            char charAt = gCommonContactsDataBaseModel.name.charAt(i);
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
            return compareTo(gCommonContactsDataBaseModel, i + 1);
        } else if (this.f11494id > gCommonContactsDataBaseModel.f11494id) {
            return 1;
        } else {
            return -1;
        }
    }
}
