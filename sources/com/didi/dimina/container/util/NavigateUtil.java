package com.didi.dimina.container.util;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.page.DMPage;
import com.didi.dimina.container.page.IPageHost;
import java.util.List;

public class NavigateUtil {
    public static DMMinaNavigatorDelegate getCurNavigator(DMMina dMMina) {
        if (dMMina == null) {
            return null;
        }
        return dMMina.getCurNavigator();
    }

    public static DMPage getCurPage(DMMina dMMina) {
        DMMinaNavigatorDelegate curNavigator;
        IPageHost currentPage;
        if (dMMina == null || (curNavigator = dMMina.getCurNavigator()) == null || (currentPage = curNavigator.getCurrentPage()) == null) {
            return null;
        }
        return currentPage.getPage();
    }

    public static IPageHost getCurPageHost(DMMina dMMina) {
        DMMinaNavigatorDelegate curNavigator;
        if (dMMina == null || (curNavigator = dMMina.getCurNavigator()) == null) {
            return null;
        }
        return curNavigator.getCurrentPage();
    }

    public static List<IPageHost> getCurPageHosts(DMMina dMMina) {
        DMMinaNavigatorDelegate curNavigator;
        if (dMMina == null || (curNavigator = dMMina.getCurNavigator()) == null) {
            return null;
        }
        return curNavigator.getCurrentPages();
    }
}
