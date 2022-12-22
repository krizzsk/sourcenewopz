package com.didi.addressnew.view.commonaddress;

public interface IHomeCompanyUploadRequestReactor extends ICommonAddressReactor {
    void onCompanyUploadFailed();

    void onCompanyUploadSuccess();

    void onHomeUploadFailed();

    void onHomeUploadSuccess();
}
