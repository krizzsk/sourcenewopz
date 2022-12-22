package com.didi.addressnew.framework.utils;

import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiExtendInfo;
import com.sdk.poibase.model.common.RpcCommonPoi;

public class AddressConverter {
    public static Address rpc2Address(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public static RpcPoi address2Rpc(Address address) {
        RpcPoi convertToRpcPoi = ModelConverter.convertToRpcPoi(address);
        if (convertToRpcPoi.extend_info == null) {
            convertToRpcPoi.extend_info = new RpcPoiExtendInfo();
        }
        return convertToRpcPoi;
    }

    public static Address commonRpc2Address(RpcCommonPoi rpcCommonPoi) {
        return rpc2Address(AddressConvertUtil.commonToRecSug(rpcCommonPoi));
    }
}
