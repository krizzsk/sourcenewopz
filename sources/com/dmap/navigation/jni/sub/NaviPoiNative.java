package com.dmap.navigation.jni.sub;

import android.text.TextUtils;
import com.dmap.navigation.base.location.INaviPoi;
import com.dmap.navigation.jni.swig.NaviPoi;

public class NaviPoiNative extends NaviPoi {
    public NaviPoiNative(INaviPoi iNaviPoi) {
        setLatLng(new NaviLatLngNative(iNaviPoi.getLatLng().latitude, iNaviPoi.getLatLng().longitude));
        if (!TextUtils.isEmpty(iNaviPoi.getName())) {
            setName(iNaviPoi.getName());
        }
        if (!TextUtils.isEmpty(iNaviPoi.getUid())) {
            setUid(iNaviPoi.getUid());
        }
        if (!TextUtils.isEmpty(iNaviPoi.getChooseFlag())) {
            setChooseFlag(iNaviPoi.getChooseFlag());
        }
    }
}
