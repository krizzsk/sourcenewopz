package com.didi.app.router;

import com.didi.app.router.sidebar.BaseSideBarDRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.events.OpenSideBarPageEvent;
import com.didi.sdk.sidebar.data.DataContainer;
import com.didi.sdk.sidebar.model.SidebarItem;
import com.didi.sdk.sidebar.model.SidebarPage;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import java.util.Collection;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class SettingsRouterHandler extends BaseSideBarDRouterHandler {
    public void callRealHandle(Request request, Result result) {
        SidebarPage pageData = DataContainer.getInstance().getPageData("level0", "root");
        if (pageData != null || SaApolloUtil.INSTANCE.getSaUserTabShow()) {
            List<List<SidebarItem>> groupList = pageData.getGroupList();
            if (!CollectionUtil.isEmpty((Collection<?>) groupList)) {
                SidebarItem sidebarItem = null;
                String subLevel = pageData.getSubLevel();
                for (int i = 0; i < groupList.size(); i++) {
                    List list = groupList.get(i);
                    if (list != null) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= list.size()) {
                                break;
                            }
                            SidebarItem sidebarItem2 = (SidebarItem) list.get(i2);
                            String url = sidebarItem2.getUrl();
                            if (!TextUtil.isEmpty(url) && url.endsWith("one/settings")) {
                                sidebarItem = sidebarItem2;
                                break;
                            }
                            i2++;
                        }
                    }
                }
                if (sidebarItem != null && !TextUtil.isEmpty(subLevel)) {
                    OpenSideBarPageEvent openSideBarPageEvent = new OpenSideBarPageEvent();
                    openSideBarPageEvent.item = sidebarItem;
                    openSideBarPageEvent.subLevel = subLevel;
                    EventBus.getDefault().post(openSideBarPageEvent);
                }
            }
        }
    }
}
