package com.didi.component.splitfare.contactmanage;

import java.util.List;

public interface GlobalContactsCallback {
    void onFailed(String str);

    void onSucceed(List<GlobalContactsModel> list);
}
