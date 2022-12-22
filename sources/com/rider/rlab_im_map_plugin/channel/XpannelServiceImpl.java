package com.rider.rlab_im_map_plugin.channel;

import com.didi.rlab.uni_im_map.map.IMXpannelService;
import com.rider.rlab_im_map_plugin.xpanel.XPanelLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XpannelServiceImpl implements IMXpannelService {
    public void setHitFrames(List<Map<Object, Object>> list) {
        XPanelLayout xPanelLayout = NavIMServiceImpl.iNavigationProvider.getXPanelLayout();
        if (xPanelLayout != null && list != null) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(list.get(i));
            }
            xPanelLayout.setHitFrames(arrayList);
        }
    }
}
