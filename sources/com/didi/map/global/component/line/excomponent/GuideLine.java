package com.didi.map.global.component.line.excomponent;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.sdk.component.IBaseComponent;
import java.util.ArrayList;
import java.util.List;

public class GuideLine implements IBaseComponent<GuideLineParam> {

    /* renamed from: a */
    private Context f25827a;

    /* renamed from: b */
    private Map f25828b;

    /* renamed from: c */
    private GuideLineParam f25829c;

    /* renamed from: d */
    private ICompLineContract f25830d;

    /* renamed from: e */
    private boolean f25831e = true;

    /* renamed from: f */
    private LatLng f25832f;

    /* renamed from: g */
    private LatLng f25833g;

    public void onMapVisible(boolean z) {
    }

    public void create(Context context, Map map) {
        this.f25827a = context;
        this.f25828b = map;
        GuideLineParam guideLineParam = this.f25829c;
        if (guideLineParam != null) {
            this.f25832f = guideLineParam.f25838e;
            this.f25833g = this.f25829c.f25839f;
            m18391b();
        }
    }

    public void destroy() {
        m18390a();
        this.f25827a = null;
        this.f25828b = null;
        this.f25829c = null;
        this.f25832f = null;
        this.f25833g = null;
    }

    public void setConfigParam(GuideLineParam guideLineParam) {
        this.f25829c = guideLineParam;
    }

    /* renamed from: a */
    private void m18390a() {
        ICompLineContract iCompLineContract = this.f25830d;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f25830d = null;
        }
    }

    /* renamed from: b */
    private void m18391b() {
        if (this.f25828b != null && this.f25827a != null && this.f25829c != null && LatLngUtils.locateCorrect(this.f25832f) && LatLngUtils.locateCorrect(this.f25833g)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.f25832f);
            arrayList.add(this.f25833g);
            ICompLineContract iCompLineContract = this.f25830d;
            if (iCompLineContract == null) {
                LineParams lineParams = new LineParams(arrayList, this.f25829c.f25834a != 0 ? this.f25829c.f25834a : Color.parseColor("#279CFD"), this.f25829c.f25837d != 0 ? this.f25829c.f25837d : 4);
                lineParams.setDotSpace(this.f25829c.f25836c != 0.0f ? this.f25829c.f25836c : 5.0f);
                lineParams.setDottedIconRes(this.f25829c.f25835b);
                ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, this.f25828b, this.f25827a, lineParams);
                this.f25830d = createLineComponent;
                if (this.f25831e && createLineComponent != null) {
                    createLineComponent.start();
                }
            } else if (this.f25831e && iCompLineContract != null) {
                iCompLineContract.updateLinePoints(arrayList);
            }
        }
    }

    public List<IMapElement> getBestViewElements() {
        ICompLineContract iCompLineContract = this.f25830d;
        if (iCompLineContract != null) {
            return iCompLineContract.getBestViewElements();
        }
        return null;
    }

    public void updateStartPosition(LatLng latLng) {
        if (LatLngUtils.locateCorrect(latLng) && !LatLngUtils.isCompletedSameLatLng(latLng, this.f25832f)) {
            this.f25832f = latLng;
            m18391b();
        }
    }

    public void updateEndPosition(LatLng latLng) {
        if (LatLngUtils.locateCorrect(latLng) && !LatLngUtils.isCompletedSameLatLng(latLng, this.f25833g)) {
            this.f25833g = latLng;
            m18391b();
        }
    }

    public void setVisible(boolean z) {
        this.f25831e = z;
        ICompLineContract iCompLineContract = this.f25830d;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }

    public boolean isVisible() {
        return this.f25831e;
    }
}
