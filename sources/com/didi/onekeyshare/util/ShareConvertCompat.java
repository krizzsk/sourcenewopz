package com.didi.onekeyshare.util;

import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.sharesdk.OneKeyShareModel;
import java.util.ArrayList;
import java.util.List;

public class ShareConvertCompat {
    public static List<OneKeyShareInfo> convert(ShareInfo shareInfo) {
        ArrayList arrayList = new ArrayList();
        if (!(shareInfo == null || shareInfo.platforms == null || shareInfo.platforms.isEmpty())) {
            for (SharePlatform next : shareInfo.platforms) {
                if (!(next == null || next == SharePlatform.UNKNOWN)) {
                    OneKeyShareInfo oneKeyShareInfo = new OneKeyShareInfo();
                    oneKeyShareInfo.platform = next;
                    oneKeyShareInfo.title = shareInfo.title;
                    oneKeyShareInfo.content = shareInfo.content;
                    oneKeyShareInfo.url = shareInfo.url;
                    oneKeyShareInfo.imageUrl = shareInfo.imageUrl;
                    oneKeyShareInfo.imagePath = shareInfo.imagePath;
                    oneKeyShareInfo.imageData = shareInfo.imageData;
                    oneKeyShareInfo.phone = shareInfo.phone;
                    oneKeyShareInfo.smsMessage = shareInfo.smsMessage;
                    oneKeyShareInfo.customName = shareInfo.customName;
                    oneKeyShareInfo.extra = shareInfo.extra;
                    oneKeyShareInfo.type = shareInfo.type;
                    oneKeyShareInfo.recipients = shareInfo.recipients;
                    arrayList.add(oneKeyShareInfo);
                }
            }
        }
        return arrayList;
    }

    public static OneKeyShareModel convert(OneKeyShareInfo oneKeyShareInfo) {
        if (oneKeyShareInfo == null) {
            return null;
        }
        OneKeyShareModel oneKeyShareModel = new OneKeyShareModel(oneKeyShareInfo.platform.platformName());
        oneKeyShareModel.title = oneKeyShareInfo.title;
        oneKeyShareModel.content = oneKeyShareInfo.content;
        oneKeyShareModel.url = oneKeyShareInfo.url;
        oneKeyShareModel.imgUrl = oneKeyShareInfo.imageUrl;
        oneKeyShareModel.imgPath = oneKeyShareInfo.imagePath;
        oneKeyShareModel.bitmap = oneKeyShareInfo.imageData;
        oneKeyShareModel.phone = oneKeyShareInfo.phone;
        oneKeyShareModel.smsMessage = oneKeyShareInfo.smsMessage;
        oneKeyShareModel.type = oneKeyShareInfo.type;
        oneKeyShareModel.extra = oneKeyShareInfo.extra;
        oneKeyShareModel.recipients = oneKeyShareInfo.recipients;
        return oneKeyShareModel;
    }

    public static OneKeyShareInfo convert(OneKeyShareModel oneKeyShareModel) {
        if (oneKeyShareModel == null) {
            return null;
        }
        OneKeyShareInfo oneKeyShareInfo = new OneKeyShareInfo();
        oneKeyShareInfo.title = oneKeyShareModel.title;
        oneKeyShareInfo.content = oneKeyShareModel.content;
        oneKeyShareInfo.url = oneKeyShareModel.url;
        oneKeyShareInfo.imageUrl = oneKeyShareModel.imgUrl;
        oneKeyShareInfo.imagePath = oneKeyShareModel.imgPath;
        oneKeyShareInfo.imageData = oneKeyShareModel.bitmap;
        oneKeyShareInfo.platform = SharePlatform.valueName(oneKeyShareModel.getPlatform());
        oneKeyShareInfo.phone = oneKeyShareModel.phone;
        oneKeyShareInfo.smsMessage = oneKeyShareModel.smsMessage;
        oneKeyShareInfo.type = oneKeyShareModel.type;
        oneKeyShareInfo.extra = oneKeyShareModel.extra;
        oneKeyShareInfo.recipients = oneKeyShareModel.recipients;
        return oneKeyShareInfo;
    }
}
