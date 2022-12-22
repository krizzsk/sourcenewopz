package com.didi.beatles.p099im.views.bottombar;

import java.util.Map;

/* renamed from: com.didi.beatles.im.views.bottombar.IIMSkin */
public interface IIMSkin {
    void setShowImage(boolean z);

    void setSkinMap(Map<String, IMSkinElement> map);

    void showCancelSkin();

    void showCommonSkin();

    void showCustomSkin(String str);

    void showDisableSkin();
}
