package com.didi.map.global.component.myLocation;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.map.global.component.myLocation.MyLocationCompParam;
import com.didi.map.global.component.myLocation.view.MyLocationView;
import com.didi.map.global.model.location.NLPRegisterParam;
import java.util.List;

public class MyLocationComponent implements IMyLocationCompContract {

    /* renamed from: a */
    private MyLocationView f26044a;

    /* renamed from: b */
    private MyLocationCompParam f26045b;

    /* renamed from: c */
    private final int f26046c = 1;

    public void setNeedNlpLocation(NLPRegisterParam nLPRegisterParam) {
        MyLocationView myLocationView = this.f26044a;
        if (myLocationView != null) {
            myLocationView.setNeedNlpLocation(nLPRegisterParam);
        }
    }

    public void setZIndex(int i) {
        MyLocationView myLocationView = this.f26044a;
        if (myLocationView != null) {
            myLocationView.setZIndex(i);
        }
    }

    public List<IMapElement> getMyLocationMarkers() {
        MyLocationView myLocationView = this.f26044a;
        if (myLocationView != null) {
            return myLocationView.getBestViewElements();
        }
        return null;
    }

    public void setVisible(boolean z) {
        MyLocationView myLocationView = this.f26044a;
        if (myLocationView == null || !z) {
            MyLocationView myLocationView2 = this.f26044a;
            if (myLocationView2 != null && !z) {
                myLocationView2.hide();
                return;
            }
            return;
        }
        myLocationView.show();
    }

    public boolean isVisible() {
        MyLocationView myLocationView = this.f26044a;
        return myLocationView != null && myLocationView.isVisible();
    }

    public void create(Context context, Map map) {
        if (this.f26044a == null) {
            if (this.f26045b == null) {
                this.f26045b = new MyLocationCompParam.Builder(1).build();
            }
            MyLocationView myLocationView = new MyLocationView(map, Math.min(this.f26045b.getzIndex(), 1), this.f26045b.getArrowIcon(), this.f26045b.getPositionIcon());
            this.f26044a = myLocationView;
            myLocationView.show();
        }
    }

    public void destroy() {
        MyLocationView myLocationView = this.f26044a;
        if (myLocationView != null) {
            myLocationView.destroy();
            this.f26044a = null;
        }
    }

    public void setConfigParam(MyLocationCompParam myLocationCompParam) {
        if (myLocationCompParam != null) {
            this.f26045b = myLocationCompParam;
        }
    }

    public void onMapVisible(boolean z) {
        MyLocationView myLocationView = this.f26044a;
        if (myLocationView != null && !z) {
            myLocationView.hide();
        }
        MyLocationView myLocationView2 = this.f26044a;
        if (myLocationView2 != null && z) {
            myLocationView2.show();
        }
    }
}
