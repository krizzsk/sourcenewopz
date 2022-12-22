package com.didi.addressnew.framework.switcher.result;

import com.didi.address.AddressResult;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.common.RpcCommonPoi;
import java.util.List;

public interface IAddressResult {
    IAddressResult clone();

    void eraseAllAddress();

    void eraseInternalAddress();

    AddressResult getAddressResult();

    RpcCommonPoi getCommonAddress();

    List<RpcCommonPoi> getCommonAddressList();

    AddressResultEnhancer.OperType getLastOperType();

    FragmentFactory.FragmentType getLastPageType();

    AddressResultEnhancer.MapSelectOper getMapSelectOperType();

    ParentAddress getParentAddress();

    Address getResult(int i);

    void onCancel();

    void onConfirm();

    IAddressResult onPageEnter();

    void setCommon(Address address);

    void setCommonAddress(RpcCommonPoi rpcCommonPoi);

    void setCommonAddressList(List<RpcCommonPoi> list);

    void setCompany(Address address);

    void setEnd(Address address);

    void setHome(Address address);

    void setLastPageType(FragmentFactory.FragmentType fragmentType);

    void setMapSelectOperType(AddressResultEnhancer.MapSelectOper mapSelectOper);

    void setParent(ParentAddress parentAddress);

    void setResult(int i, Address address);

    void setResultAllowNull(int i, Address address);

    void setStart(Address address);

    void updateAllAddress(IAddressResult iAddressResult);

    void updateAllAddressAllowNullable(IAddressResult iAddressResult);

    void updateExternalAddress(IAddressResult iAddressResult);

    void updateInternalAddress(IAddressResult iAddressResult);
}
