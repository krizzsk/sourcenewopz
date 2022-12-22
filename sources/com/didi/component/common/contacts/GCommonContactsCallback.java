package com.didi.component.common.contacts;

import java.util.List;

public interface GCommonContactsCallback {
    void onFailed(String str);

    void onSucceed(List<GCommonContactsModel> list);
}
