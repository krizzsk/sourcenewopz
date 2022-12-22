package com.didi.dimina.container.service;

import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.mina.DMMinaNavigatorDelegate;
import com.didi.dimina.container.page.IPageHost;
import com.didi.dimina.container.util.NavigateUtil;
import java.util.List;

public interface CapsuleButtonService {
    void onCloseClick(DMMina dMMina);

    public static class DefaultCapsuleButtonServiceImpl implements CapsuleButtonService {
        public void onCloseClick(DMMina dMMina) {
            DMMinaNavigatorDelegate curNavigator = NavigateUtil.getCurNavigator(dMMina);
            List<IPageHost> curPageHosts = NavigateUtil.getCurPageHosts(dMMina);
            if (curNavigator != null && curPageHosts != null) {
                int size = curPageHosts.size();
                curNavigator.navigateBack(dMMina.getMinaIndex(), curNavigator.getIndex(), size);
            }
        }
    }
}
