package com.didi.map.global.component.line.component;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.utils.LineUtils;
import com.didi.sdk.util.ToastUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DotArcLineComponent implements ICompLineContract {
    public static final String TAG = "Arc_line_component";

    /* renamed from: a */
    private Map f25658a;

    /* renamed from: b */
    private Context f25659b;

    /* renamed from: c */
    private LineParams f25660c;

    /* renamed from: d */
    private List<LatLng> f25661d;

    /* renamed from: e */
    private OnLineDrawStatusListener f25662e;

    /* renamed from: f */
    private LatLng f25663f;

    /* renamed from: g */
    private LatLng f25664g;

    /* renamed from: h */
    private ICompLineContract f25665h;

    public void stop() {
    }

    public /* synthetic */ void updateLinePoints(List<LatLng> list) {
        ICompLineContract.CC.$default$updateLinePoints(this, list);
    }

    public void create(Context context, Map map) {
        this.f25658a = map;
        this.f25659b = context;
    }

    public void setConfigParam(LineParams lineParams) {
        if (lineParams != null && !CollectionUtil.isEmpty((Collection<?>) lineParams.getLinePoints())) {
            if (lineParams.getLinePoints().size() != 2) {
                try {
                    throw new Exception("弧线绘制点集必须为两个");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            this.f25660c = lineParams;
            if (lineParams.getLineColorWithArgb() == 0) {
                this.f25660c.setLineColorWithArgb(Color.parseColor("#262B2E"));
            }
            if (this.f25660c.getLineWidth() == 0) {
                this.f25660c.setLineWidth(6);
            }
            this.f25663f = lineParams.getLinePoints().get(0);
            this.f25664g = lineParams.getLinePoints().get(1);
            this.f25661d = LineUtils.INSTANCE.getCornerLineDots(this.f25663f, this.f25664g);
        }
    }

    public void start() {
        m18327a();
    }

    public List<LatLng> getAllLinePoints() {
        return this.f25661d;
    }

    public void destroy() {
        ICompLineContract iCompLineContract = this.f25665h;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f25665h = null;
        }
        List<LatLng> list = this.f25661d;
        if (list != null) {
            list.clear();
            this.f25661d = null;
        }
        this.f25660c = null;
        this.f25659b = null;
        this.f25658a = null;
    }

    public void onMapVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f25665h;
        if (iCompLineContract != null) {
            iCompLineContract.onMapVisible(z);
        }
    }

    public void setListener(OnLineDrawStatusListener onLineDrawStatusListener) {
        this.f25662e = onLineDrawStatusListener;
    }

    public void setLineClickListener(OnLineClickListener onLineClickListener) {
        ICompLineContract iCompLineContract;
        if (this.f25658a != null && onLineClickListener != null && (iCompLineContract = this.f25665h) != null) {
            iCompLineContract.setLineClickListener(onLineClickListener);
        }
    }

    public void setLineVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f25665h;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }

    public List<IMapElement> getBestViewElements() {
        ICompLineContract iCompLineContract = this.f25665h;
        if (iCompLineContract != null) {
            return iCompLineContract.getBestViewElements();
        }
        return new ArrayList();
    }

    /* renamed from: a */
    private void m18327a() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f25661d)) {
            if (this.f25660c == null) {
                ToastUtil.show(this.f25659b, (CharSequence) "请先添加参数");
                return;
            }
            ICompLineContract iCompLineContract = this.f25665h;
            if (iCompLineContract != null) {
                iCompLineContract.destroy();
                this.f25665h = null;
            }
            this.f25660c.setLinePoints(this.f25661d);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, this.f25658a, this.f25659b, this.f25660c);
            this.f25665h = createLineComponent;
            if (createLineComponent != null) {
                createLineComponent.start();
            }
            OnLineDrawStatusListener onLineDrawStatusListener = this.f25662e;
            if (onLineDrawStatusListener != null) {
                onLineDrawStatusListener.onLineDrawFinished();
            }
        }
    }

    public LatLng getArcLineCenter() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f25661d)) {
            return null;
        }
        if (this.f25661d.size() > 2) {
            List<LatLng> list = this.f25661d;
            return list.get(list.size() / 2);
        } else if (!LatLngUtils.locateCorrect(this.f25663f) || !LatLngUtils.locateCorrect(this.f25664g)) {
            return null;
        } else {
            double computeDistanceBetween = DDSphericalUtil.computeDistanceBetween(this.f25663f, this.f25664g);
            return DDSphericalUtil.computeOffset(this.f25664g, computeDistanceBetween * 0.5d, DDSphericalUtil.computeHeading(this.f25663f, this.f25664g));
        }
    }

    public void updateLineColor(int i, int i2) {
        ICompLineContract iCompLineContract = this.f25665h;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
            this.f25665h = null;
            LineParams lineParams = this.f25660c;
            if (lineParams != null) {
                if (i != 0) {
                    lineParams.setLineColorWithArgb(i);
                }
                if (i2 != this.f25660c.getDottedIconRes()) {
                    this.f25660c.setDottedIconRes(i2);
                }
                m18327a();
            }
        }
    }
}
