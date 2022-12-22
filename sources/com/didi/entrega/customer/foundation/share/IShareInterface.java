package com.didi.entrega.customer.foundation.share;

import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.web.model.ShareToolModel;
import java.util.ArrayList;

public interface IShareInterface {
    void shareToPlatform(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback);

    void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IPlatformClickCallback iPlatformClickCallback);

    void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IShareCallback iShareCallback);

    void systemShare(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback);
}
