package com.didi.onekeyshare.presenter;

import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import java.util.List;

public interface ISharePresenter extends IPresenter {
    List<OneKeyShareInfo> getShareInfo();

    void onCancel();

    void onClickPlatform(OneKeyShareInfo oneKeyShareInfo);

    void onShow(List<OneKeyShareInfo> list);

    void setCallback(ICallback iCallback);

    void setShareInfo(List<OneKeyShareInfo> list);
}
