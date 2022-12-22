package com.didi.addressnew.framework.switcher.result;

import android.text.TextUtils;
import android.util.Log;
import com.didi.address.AddressResult;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.util.CommonUtils;
import com.didi.common.map.util.DLog;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.common.RpcCommonPoi;
import java.util.List;

public class AddressResultEnhancer extends AddressResult implements IAddressResult, Cloneable {
    public RpcCommonPoi commonPoi;
    private FragmentFactory.FragmentType mLastPage = FragmentFactory.FragmentType.OTHER;
    private MapSelectOper mapSelectOper = MapSelectOper.Other;
    private OperType operType = OperType.Other;
    private ParentAddress parent;
    public List<RpcCommonPoi> rpcCommonPoiList;

    public enum MapSelectOper {
        Edit,
        Chose,
        FuzzyMatch,
        Other
    }

    public enum OperType {
        Cancel,
        Confirm,
        Other
    }

    public AddressResult getAddressResult() {
        return this;
    }

    public IAddressResult onPageEnter() {
        return clone();
    }

    public void onCancel() {
        this.operType = OperType.Cancel;
    }

    public void onConfirm() {
        this.operType = OperType.Confirm;
    }

    public void setStart(Address address) {
        validateAndSetPoiid(1, address);
        if (CommonUtils.isValidLocation(address)) {
            this.start = address;
        }
    }

    public void setEnd(Address address) {
        validateAndSetPoiid(2, address);
        if (CommonUtils.isValidLocation(address)) {
            this.end = address;
        }
    }

    public void setHome(Address address) {
        validateAndSetPoiid(3, address);
        if (CommonUtils.isValidLocation(address)) {
            this.home = address;
        }
    }

    public void setCompany(Address address) {
        validateAndSetPoiid(4, address);
        if (CommonUtils.isValidLocation(address)) {
            this.company = address;
        }
    }

    public void setCommon(Address address) {
        validateAndSetPoiid(5, address);
        if (CommonUtils.isValidLocation(address)) {
            this.common = address;
        }
    }

    public void updateAllAddress(IAddressResult iAddressResult) {
        if (iAddressResult != null) {
            this.mLastPage = iAddressResult.getLastPageType();
            this.operType = iAddressResult.getLastOperType();
            this.mapSelectOper = iAddressResult.getMapSelectOperType();
            setStart(iAddressResult.getAddressResult().start);
            setEnd(iAddressResult.getAddressResult().end);
            setHome(iAddressResult.getAddressResult().home);
            setCompany(iAddressResult.getAddressResult().company);
            setCommon(iAddressResult.getAddressResult().common);
            setCommonAddress(iAddressResult.getCommonAddress());
            setCommonAddressList(iAddressResult.getCommonAddressList());
            setParent(iAddressResult.getParentAddress());
            this.fromType = iAddressResult.getAddressResult().fromType;
            this.isStartNeedNearRoad = iAddressResult.getAddressResult().isStartNeedNearRoad;
            this.type = iAddressResult.getAddressResult().type;
        }
    }

    public void updateAllAddressAllowNullable(IAddressResult iAddressResult) {
        if (iAddressResult != null) {
            this.mLastPage = iAddressResult.getLastPageType();
            this.operType = iAddressResult.getLastOperType();
            this.mapSelectOper = iAddressResult.getMapSelectOperType();
            this.start = iAddressResult.getAddressResult().start;
            this.end = iAddressResult.getAddressResult().end;
            this.home = iAddressResult.getAddressResult().home;
            this.company = iAddressResult.getAddressResult().company;
            this.common = iAddressResult.getAddressResult().common;
            setCommonAddress(iAddressResult.getCommonAddress());
            setCommonAddressList(iAddressResult.getCommonAddressList());
            setParent(iAddressResult.getParentAddress());
            this.fromType = iAddressResult.getAddressResult().fromType;
            this.isStartNeedNearRoad = iAddressResult.getAddressResult().isStartNeedNearRoad;
            this.type = iAddressResult.getAddressResult().type;
        }
    }

    public void updateExternalAddress(IAddressResult iAddressResult) {
        if (iAddressResult != null) {
            setStart(iAddressResult.getAddressResult().start);
            setEnd(iAddressResult.getAddressResult().end);
        }
    }

    public void updateInternalAddress(IAddressResult iAddressResult) {
        if (iAddressResult != null) {
            setHome(iAddressResult.getAddressResult().home);
            setCompany(iAddressResult.getAddressResult().company);
            setCommon(iAddressResult.getAddressResult().common);
            setCommonAddress(iAddressResult.getCommonAddress());
            setParent(iAddressResult.getParentAddress());
        }
    }

    public void eraseInternalAddress() {
        getAddressResult().home = null;
        getAddressResult().company = null;
        getAddressResult().common = null;
        this.commonPoi = null;
        this.rpcCommonPoiList = null;
        this.parent = null;
    }

    public void eraseAllAddress() {
        getAddressResult().start = null;
        getAddressResult().end = null;
        getAddressResult().company = null;
        getAddressResult().common = null;
        getAddressResult().home = null;
        this.commonPoi = null;
        this.rpcCommonPoiList = null;
        this.parent = null;
    }

    public void applyFromOutter(IAddressResult iAddressResult) {
        this.start = iAddressResult.getAddressResult().start;
        this.end = iAddressResult.getAddressResult().end;
        this.home = iAddressResult.getAddressResult().home;
        this.company = iAddressResult.getAddressResult().company;
        this.common = iAddressResult.getAddressResult().common;
        this.fromType = iAddressResult.getAddressResult().fromType;
        this.isStartNeedNearRoad = iAddressResult.getAddressResult().isStartNeedNearRoad;
        this.type = iAddressResult.getAddressResult().type;
    }

    public IAddressResult clone() {
        AddressResultEnhancer addressResultEnhancer = new AddressResultEnhancer();
        addressResultEnhancer.setStart(this.start != null ? this.start.clone() : this.start);
        addressResultEnhancer.setEnd(this.end != null ? this.end.clone() : this.end);
        addressResultEnhancer.setHome(this.home != null ? this.home.clone() : this.home);
        addressResultEnhancer.setCompany(this.company != null ? this.company.clone() : this.company);
        addressResultEnhancer.setCommon(this.common != null ? this.common.clone() : this.common);
        addressResultEnhancer.setCommonAddress(this.commonPoi);
        addressResultEnhancer.setCommonAddressList(this.rpcCommonPoiList);
        ParentAddress parentAddress = this.parent;
        if (parentAddress != null) {
            parentAddress = parentAddress.clone();
        }
        addressResultEnhancer.setParent(parentAddress);
        addressResultEnhancer.fromType = this.fromType;
        addressResultEnhancer.isStartNeedNearRoad = this.isStartNeedNearRoad;
        addressResultEnhancer.type = this.type;
        addressResultEnhancer.mLastPage = this.mLastPage;
        addressResultEnhancer.mapSelectOper = this.mapSelectOper;
        addressResultEnhancer.operType = this.operType;
        return addressResultEnhancer;
    }

    public Address getResult(int i) {
        if (i == 1) {
            return this.start;
        }
        if (i == 2) {
            return this.end;
        }
        if (i == 3) {
            return this.home;
        }
        if (i == 4) {
            return this.company;
        }
        if (i == 5 || i == 101 || i == 102) {
            return this.common;
        }
        return null;
    }

    public void setResult(int i, Address address) {
        validateAndSetPoiid(i, address);
        if (i == 1) {
            setStart(address);
        } else if (i == 2) {
            setEnd(address);
        } else if (i == 3) {
            setHome(address);
        } else if (i == 4) {
            setCompany(address);
        } else if (i == 5 || i == 101 || i == 102) {
            setCommon(address);
        }
    }

    public RpcCommonPoi getCommonAddress() {
        return this.commonPoi;
    }

    public void setCommonAddress(RpcCommonPoi rpcCommonPoi) {
        this.commonPoi = rpcCommonPoi;
    }

    public List<RpcCommonPoi> getCommonAddressList() {
        return this.rpcCommonPoiList;
    }

    public void setCommonAddressList(List<RpcCommonPoi> list) {
        this.rpcCommonPoiList = list;
    }

    public void setParent(ParentAddress parentAddress) {
        if (parentAddress != null) {
            validateAndSetPoiid(parentAddress.addressType, parentAddress.address);
            if (CommonUtils.isValidLocation(parentAddress.address)) {
                this.parent = parentAddress;
            }
        }
    }

    public ParentAddress getParentAddress() {
        return this.parent;
    }

    public void setLastPageType(FragmentFactory.FragmentType fragmentType) {
        this.mLastPage = fragmentType;
    }

    public FragmentFactory.FragmentType getLastPageType() {
        return this.mLastPage;
    }

    public OperType getLastOperType() {
        return this.operType;
    }

    public MapSelectOper getMapSelectOperType() {
        return this.mapSelectOper;
    }

    public void setMapSelectOperType(MapSelectOper mapSelectOper2) {
        this.mapSelectOper = mapSelectOper2;
    }

    public void setResultAllowNull(int i, Address address) {
        validateAndSetPoiid(i, address);
        if (i == 1) {
            this.start = address;
        } else if (i == 2) {
            this.end = address;
        } else if (i == 3) {
            this.home = address;
        } else if (i == 4) {
            this.company = address;
        } else if (i == 5 || i == 101 || i == 102) {
            this.common = address;
        }
    }

    private void validateAndSetPoiid(int i, Address address) {
        if (address != null && TextUtils.isEmpty(address.poiId)) {
            DLog.m7384d("SugErr", "Poiid npe :addressType = " + i + ",Address = " + address + ",堆栈:" + Log.getStackTraceString(new Throwable()), new Object[0]);
            CommonUtils.checkOrCorrectPoiid(address);
        }
    }
}
