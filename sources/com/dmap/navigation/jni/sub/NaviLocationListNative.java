package com.dmap.navigation.jni.sub;

import com.dmap.navigation.base.location.INaviLocation;
import com.dmap.navigation.jni.swig.NaviLocationList;
import java.util.List;

public class NaviLocationListNative extends NaviLocationList {
    public NaviLocationListNative(List<INaviLocation> list) {
        for (INaviLocation naviLocationNative : list) {
            add(new NaviLocationNative(naviLocationNative));
        }
    }
}
