package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.jni.swig.NaviPoiList;
import java.util.List;

public class NaviPoiListNative extends NaviPoiList {
    public NaviPoiListNative(List<INaviPoi> list) {
        if (list != null) {
            for (INaviPoi naviPoiNative : list) {
                add(new NaviPoiNative(naviPoiNative));
            }
        }
    }
}
