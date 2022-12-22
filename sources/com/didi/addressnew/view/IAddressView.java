package com.didi.addressnew.view;

import com.didi.addressnew.fastframe.IView;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import java.util.ArrayList;

public interface IAddressView extends IView {
    public static final int TYPE_ADDRESS = 0;
    public static final int TYPE_COMPANY = 5;
    public static final int TYPE_FAVORITE = 6;
    public static final int TYPE_HOME = 4;
    public static final int TYPE_MOVE = 1;
    public static final int TYPE_REC = 2;
    public static final int TYPE_SUG = 3;

    int getCurrentDataAddressType();

    String getStartAddressText();

    String getStringSafe(int i);

    boolean isIntendSugRequest(AddressParam addressParam);

    boolean isSugFragmentRemoved();

    void setResultBack(int i, Address address);

    void setStartPoiInfo(AddressParam addressParam);

    void setSugTips(String str);

    void showCommonAddressView(boolean z);

    void showContentView();

    void showErrorView(String str);

    void showHasCommonAddressButError();

    void showNoSearchView();

    void showProgressView();

    void showWaittingList();

    boolean storeStartAddress(AddressParam addressParam);

    void toLogin();

    void updateCompanyAddress(RpcCommonPoi rpcCommonPoi);

    void updateContentView(AddressParam addressParam, RpcRecSug.TrackParameterForChild trackParameterForChild, ArrayList<RpcPoi> arrayList, int i);

    void updateHomeAddress(RpcCommonPoi rpcCommonPoi);

    void updateLogoFooters(boolean z, String str, int i, int i2);

    void updateMapConfirmHeaderView(RpcRecSug.TipsInfo tipsInfo, int i);

    void updateSelectPoiFooters(boolean z);

    void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo);
}
