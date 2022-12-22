package com.didi.onekeyshare.callback;

import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;

public interface ICallback {

    public interface IH5ShareCallback extends IPlatformShareCallback {
        void onRefresh();
    }

    public interface IPlatformCallback extends ICallback {
        void onClickPlatform(SharePlatform sharePlatform);
    }

    public interface IPlatformClickCallback extends ICallback {
        void onClickPlatform(OneKeyShareInfo oneKeyShareInfo);
    }

    public interface IPlatformShareCallback extends ICallback {
        void onCancel(SharePlatform sharePlatform);

        void onComplete(SharePlatform sharePlatform);

        @Deprecated
        void onError(SharePlatform sharePlatform);
    }

    public interface IPlatformShareCallback2 extends IPlatformShareCallback {
        void onError(SharePlatform sharePlatform, int i);
    }

    public interface IShareCallback extends IPlatformShareCallback {
        void onCancel();
    }
}
