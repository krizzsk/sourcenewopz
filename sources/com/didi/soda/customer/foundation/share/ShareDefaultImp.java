package com.didi.soda.customer.foundation.share;

import android.content.Context;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.callback.intercept.IShareDialogIntercept;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.soda.customer.foundation.rpc.entity.ShareCouponInfoEntity;
import com.didi.soda.web.config.WebConstant;
import com.didi.soda.web.model.ShareToolModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareDefaultImp implements IShareInterface {
    public void systemShare(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.title = shareToolModel.title;
        shareInfo.imageUrl = shareToolModel.imageUrl;
        shareInfo.imagePath = shareToolModel.imagePath;
        shareInfo.imageData = shareToolModel.imageData;
        shareInfo.content = shareToolModel.content;
        shareInfo.url = shareToolModel.url;
        shareInfo.type = IShareDialogIntercept.SYSTEM_SHARE_DIALOG;
        ArrayList arrayList = new ArrayList();
        arrayList.add(SharePlatform.SYSTEM_MESSAGE);
        shareInfo.platforms = arrayList;
        shareInfo.extra = shareToolModel.extra;
        shareInfo.customName = shareToolModel.customName;
        shareInfo.smsMessage = shareToolModel.smsMessage;
        shareInfo.recipients = shareToolModel.recipients;
        ShareBuilder.buildShare((FragmentActivity) context, shareInfo, iPlatformShareCallback);
    }

    public void shareToPlatform(Context context, ShareToolModel shareToolModel, ICallback.IPlatformShareCallback iPlatformShareCallback) {
        ShareBuilder.shareToPlatform(context, m29142a(shareToolModel), iPlatformShareCallback);
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IShareCallback iShareCallback) {
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ShareToolModel> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(m29142a(it.next()));
            }
            ShareBuilder.buildShare((FragmentActivity) context, (ArrayList<OneKeyShareInfo>) arrayList2, (ICallback.IPlatformShareCallback) iShareCallback);
        }
    }

    public void showSharePlatform(Context context, ArrayList<ShareToolModel> arrayList, ICallback.IPlatformClickCallback iPlatformClickCallback) {
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<ShareToolModel> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(m29142a(it.next()));
            }
            ShareBuilder.buildShare((FragmentActivity) context, (ArrayList<OneKeyShareInfo>) arrayList2, (ICallback.IPlatformShareCallback) null, iPlatformClickCallback);
        }
    }

    public ArrayList<ShareToolModel> convertShareToolModel(List<ShareCouponInfoEntity> list) {
        ArrayList<ShareToolModel> arrayList = new ArrayList<>();
        for (ShareCouponInfoEntity next : list) {
            ShareToolModel shareToolModel = new ShareToolModel();
            shareToolModel.type = next.type;
            shareToolModel.platformStr = shareToolModel.getPlatFrom();
            shareToolModel.imageUrl = next.data.image;
            shareToolModel.url = next.data.url;
            shareToolModel.title = next.data.title;
            shareToolModel.content = next.data.content;
            shareToolModel.smsMessage = m29143b(shareToolModel);
            arrayList.add(shareToolModel);
        }
        return arrayList;
    }

    /* renamed from: a */
    private static OneKeyShareInfo m29142a(ShareToolModel shareToolModel) {
        OneKeyShareInfo oneKeyShareInfo = new OneKeyShareInfo();
        oneKeyShareInfo.title = shareToolModel.title;
        oneKeyShareInfo.imageUrl = shareToolModel.imageUrl;
        oneKeyShareInfo.content = shareToolModel.content;
        oneKeyShareInfo.url = shareToolModel.url;
        oneKeyShareInfo.platform = SharePlatform.valueName(shareToolModel.platformStr);
        oneKeyShareInfo.extra = shareToolModel.extra;
        oneKeyShareInfo.customName = shareToolModel.customName;
        oneKeyShareInfo.smsMessage = m29143b(shareToolModel);
        return oneKeyShareInfo;
    }

    /* renamed from: b */
    private static String m29143b(ShareToolModel shareToolModel) {
        if (!WebConstant.COPY_LINK_PLATFORM.equals(shareToolModel.platformStr)) {
            return shareToolModel.smsMessage;
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(shareToolModel.title)) {
            sb.append(shareToolModel.title);
        }
        if (!TextUtils.isEmpty(shareToolModel.content)) {
            if (sb.length() > 0) {
                sb.append(",");
                sb.append(shareToolModel.content);
            } else {
                sb.append(shareToolModel.content);
            }
        }
        if (!TextUtils.isEmpty(shareToolModel.url)) {
            if (sb.length() > 0) {
                sb.append(" ");
                sb.append(shareToolModel.url);
            } else {
                sb.append(shareToolModel.url);
            }
        }
        return sb.toString();
    }
}
