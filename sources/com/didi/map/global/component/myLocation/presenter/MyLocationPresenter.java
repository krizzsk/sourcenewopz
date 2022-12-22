package com.didi.map.global.component.myLocation.presenter;

import android.content.Context;
import com.didi.common.sensor.OrientationListener;
import com.didi.common.sensor.OrientationManager;
import com.didi.map.global.component.myLocation.view.MyLocationView;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.global.model.location.LocationHelper2;
import com.didi.map.global.model.location.LocationRegisterParam;
import com.didi.map.global.model.location.NLPRegisterParam;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p173dp.locsdk.DLog;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;

public class MyLocationPresenter implements OrientationListener {

    /* renamed from: a */
    private boolean f26050a = false;

    /* renamed from: b */
    private Context f26051b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MyLocationView f26052c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f26053d = "LocationRegister-->定位蓝点";

    /* renamed from: e */
    private NLPRegisterParam f26054e;

    /* renamed from: f */
    private DIDILocationListener f26055f = new DIDILocationListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            DLog.m32737d(MyLocationPresenter.this.f26053d + "更新蓝点");
            if (MyLocationPresenter.this.f26052c != null) {
                MyLocationPresenter.this.f26052c.refreshLocation(dIDILocation);
            }
        }
    };

    public MyLocationPresenter(Context context, MyLocationView myLocationView) {
        this.f26052c = myLocationView;
        this.f26051b = context;
    }

    public void startLocation() {
        if (this.f26051b != null && !this.f26050a) {
            m18487a();
            Context context = this.f26051b;
            if (context != null) {
                OrientationManager.getInstance(context).addOrientationListener(this);
            }
            this.f26050a = true;
        }
    }

    public void stopLocation() {
        Context context = this.f26051b;
        if (context != null) {
            OrientationManager.getInstance(context).removeOrientationListener(this);
            LocationHelper.unRegisterListener(this.f26051b, this.f26055f);
            LocationHelper2.unRegisterListener(this.f26051b, this.f26055f);
            this.f26050a = false;
        }
    }

    /* renamed from: a */
    private void m18487a() {
        LocationRegisterParam locationRegisterParam;
        if (this.f26054e != null) {
            DLog.m32737d(this.f26053d + "注册NLP");
            locationRegisterParam = new LocationRegisterParam(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, LocationRegisterParam.LocType.NLP);
            locationRegisterParam.setNlpRegisterParam(this.f26054e);
        } else {
            DLog.m32737d(this.f26053d + "注册FLP");
            locationRegisterParam = new LocationRegisterParam(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, LocationRegisterParam.LocType.FLP);
        }
        LocationHelper2.registerListener(this.f26051b, this.f26055f, locationRegisterParam);
    }

    public void onOrientationChanged(float f, float f2, float f3) {
        MyLocationView myLocationView = this.f26052c;
        if (myLocationView != null) {
            myLocationView.updateArrowRotateAngle(f);
        }
    }

    public void setNeedNlpLocation(NLPRegisterParam nLPRegisterParam) {
        this.f26054e = nLPRegisterParam;
        DLog.m32737d(this.f26053d + "数据变化，重新注册");
        LocationHelper2.unRegisterListener(this.f26051b, this.f26055f);
        m18487a();
    }
}
