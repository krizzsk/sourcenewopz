package com.didi.component.splitfare.contactmanage;

public interface IGlobalContactsStore {
    void clearData();

    void getMatchList(String str, GlobalContactsCallback globalContactsCallback);

    void getSystemContacts(GlobalContactsCallback globalContactsCallback);
}
