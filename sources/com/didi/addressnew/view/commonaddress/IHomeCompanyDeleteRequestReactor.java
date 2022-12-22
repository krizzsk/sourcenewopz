package com.didi.addressnew.view.commonaddress;

public interface IHomeCompanyDeleteRequestReactor extends ICommonAddressReactor {
    void onCompanyDelFailed();

    void onCompanyDelSuccess();

    void onHomeDelFailed();

    void onHomeDelSuccess();
}
