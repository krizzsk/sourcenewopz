package com.didi.entrega.customer.foundation.share;

import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.web.model.ShareToolModel;
import java.util.ArrayList;

public final class ShareHelper implements IShareInterface {

    /* renamed from: a */
    private static ShareHelper f20030a;

    /* renamed from: b */
    private static IShareInterface f20031b;

    public static ShareHelper getInstance() {
        if (f20030a == null) {
            f20030a = new ShareHelper();
            f20031b = new ShareDefaultImp();
        }
        return f20030a;
    }

    public void systemShare(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        f20031b.systemShare(context, shareToolModel, iPlatformShareCallback);
    }

    public void shareToPlatform(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        f20031b.shareToPlatform(context, shareToolModel, iPlatformShareCallback);
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IShareCallback iShareCallback) {
        f20031b.showSharePlatform(context, arrayList, iShareCallback);
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        f20031b.showSharePlatform(context, arrayList, iPlatformClickCallback);
    }
}
