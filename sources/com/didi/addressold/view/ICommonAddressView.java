package com.didi.addressold.view;

import com.didi.addressold.fastframe.IView;
import com.sdk.poibase.model.common.RpcCommonPoi;
import java.util.ArrayList;

public interface ICommonAddressView extends IView {
    void updateCommonAddress(ArrayList<RpcCommonPoi> arrayList);
}
