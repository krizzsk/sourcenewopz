package com.didi.soda.customer.foundation.share;

import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.customer.downgrade.CustomerDowngradeHelper;
import com.didi.soda.customer.foundation.rpc.entity.ShareCouponInfoEntity;
import com.didi.soda.web.model.ShareToolModel;
import java.util.ArrayList;
import java.util.List;

public final class ShareHelper implements IShareInterface {

    /* renamed from: a */
    private static ShareHelper f41067a;

    /* renamed from: b */
    private static IShareInterface f41068b;

    public static ShareHelper getInstance() {
        if (f41067a == null) {
            f41067a = new ShareHelper();
            if (CustomerDowngradeHelper.isDowngradeShare()) {
                f41068b = new ShareDowngradeImp();
            } else {
                f41068b = new ShareDefaultImp();
            }
        }
        return f41067a;
    }

    public void systemShare(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        f41068b.systemShare(context, shareToolModel, iPlatformShareCallback);
    }

    public void shareToPlatform(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        f41068b.shareToPlatform(context, shareToolModel, iPlatformShareCallback);
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IShareCallback iShareCallback) {
        f41068b.showSharePlatform(context, arrayList, iShareCallback);
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        f41068b.showSharePlatform(context, arrayList, iPlatformClickCallback);
    }

    public ArrayList<ShareToolModel> convertShareToolModel(List<ShareCouponInfoEntity> list) {
        return f41068b.convertShareToolModel(list);
    }
}
