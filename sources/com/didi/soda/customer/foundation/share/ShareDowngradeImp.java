package com.didi.soda.customer.foundation.share;

import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ShareCouponInfoEntity;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.web.model.ShareToolModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class ShareDowngradeImp implements IShareInterface {

    /* renamed from: a */
    private static final String f41066a = "ShareDowngradeImp";

    public void systemShare(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        m29144a("systemShare");
    }

    public void shareToPlatform(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        m29144a("shareToPlatform");
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IShareCallback iShareCallback) {
        m29144a("showSharePlatform 1");
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        m29144a("showSharePlatform 2");
    }

    public ArrayList<ShareToolModel> convertShareToolModel(List<ShareCouponInfoEntity> list) {
        m29144a("convertShareToolModel");
        return null;
    }

    /* renamed from: a */
    private void m29144a(String str) {
        ToastUtil.makeText(ResourceHelper.getString(R.string.FoodC_downgrade_tip_share));
        LogUtil.m29104i(f41066a, "share down grade = " + str);
    }
}
