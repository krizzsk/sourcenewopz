package com.didi.addressnew.presenter;

import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.common.RpcCommonPoi;

public interface ICommonAddressPresenter {
    void deletFavoritePlace(AddressParam addressParam, String str);

    void deleteCommonAddress(AddressParam addressParam);

    void getCommonAddress(AddressParam addressParam);

    void getCommonAddressCache(AddressParam addressParam);

    void updateFavoritePlace(AddressParam addressParam, RpcCommonPoi rpcCommonPoi, boolean z);
}
