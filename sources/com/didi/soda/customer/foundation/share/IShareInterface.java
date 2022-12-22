package com.didi.soda.customer.foundation.share;

import android.content.Context;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.soda.customer.foundation.rpc.entity.ShareCouponInfoEntity;
import com.didi.soda.web.model.ShareToolModel;
import java.util.ArrayList;
import java.util.List;

public interface IShareInterface {
    ArrayList<ShareToolModel> convertShareToolModel(List<ShareCouponInfoEntity> list);

    void shareToPlatform(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback);

    void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IPlatformClickCallback iPlatformClickCallback);

    void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IShareCallback iShareCallback);

    void systemShare(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback);
}
