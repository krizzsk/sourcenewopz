package com.didi.beatles.p099im.views.bottombar.tab;

import com.didi.beatles.p099im.api.entity.IMSessionExtendInfo;
import com.didi.beatles.p099im.views.bottombar.IMBaseBottomBar;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabUtil */
public class IMBtmTabUtil {
    public static IMSessionExtendInfo.BottomTabInfo getTab(IMBaseBottomBar.BottomBarListener bottomBarListener, int i) {
        List<IMSessionExtendInfo.BottomTabInfo> bottomTabList;
        if (bottomBarListener == null || (bottomTabList = bottomBarListener.getBottomTabList()) == null) {
            return null;
        }
        for (IMSessionExtendInfo.BottomTabInfo next : bottomTabList) {
            if (next != null && next.f9129id == i) {
                return next;
            }
        }
        return null;
    }
}
