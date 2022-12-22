package com.didi.component.common.contacts;

public interface IGCommonContactsStore {
    void clearData();

    void getMatchList(String str, GCommonContactsCallback gCommonContactsCallback);

    void getSystemContacts(GCommonContactsCallback gCommonContactsCallback);
}
