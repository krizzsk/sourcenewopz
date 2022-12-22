package com.didi.addressnew.presenter;

import com.didi.addressnew.view.commonaddress.IHomeCompanyDeleteRequestReactor;
import com.didi.addressnew.view.commonaddress.IHomeCompanyUploadRequestReactor;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;

public interface ISimpleCompanyHomePresenter {
    void deleteCommonAddress(AddressParam addressParam, IHomeCompanyDeleteRequestReactor iHomeCompanyDeleteRequestReactor);

    void setHomeCompany(AddressParam addressParam, RpcPoi rpcPoi, IHomeCompanyUploadRequestReactor iHomeCompanyUploadRequestReactor);
}
