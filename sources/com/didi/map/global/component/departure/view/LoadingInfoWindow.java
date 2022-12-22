package com.didi.map.global.component.departure.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.MapView;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.strategy3.IDMarkerContractV3;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.OnMarkerCompClickListener;
import com.didi.map.global.component.markers.view.ILabelView;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;
import java.util.List;

public class LoadingInfoWindow {

    /* renamed from: a */
    ICollideStrategy f25333a = CollideStrategyFactory.getCollideStrategyV3(new IDMarkerContractV3() {
        public /* synthetic */ int getDefaultLabelPosition() {
            return IDMarkerContractV3.CC.$default$getDefaultLabelPosition(this);
        }

        public /* synthetic */ int getEnableLabelPosition() {
            return IDMarkerContractV3.CC.$default$getEnableLabelPosition(this);
        }

        public boolean isCanWork() {
            return true;
        }

        public Map getMap() {
            if (LoadingInfoWindow.this.f25337e == null) {
                return null;
            }
            return LoadingInfoWindow.this.f25337e.getMap();
        }

        public void setLabelDirect(String str, int i) {
            Marker labelMarkerById;
            if (LoadingInfoWindow.this.f25344l != null && (labelMarkerById = LoadingInfoWindow.this.f25344l.getLabelMarkerById(str)) != null && labelMarkerById.isVisible()) {
                LoadingInfoWindow.this.f25344l.updateMarkerLabelDirect(str, i);
            }
        }

        public List<Rect> getCollideAvoidRect() {
            if (LoadingInfoWindow.this.f25348p != null) {
                return LoadingInfoWindow.this.f25348p.getCollideAvoidRect();
            }
            return null;
        }

        public Padding getPadding() {
            return LoadingInfoWindow.this.f25347o == null ? new Padding() : LoadingInfoWindow.this.f25347o;
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f25334b;

    /* renamed from: c */
    private TextView f25335c;

    /* renamed from: d */
    private LottieAnimationView f25336d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public MapView f25337e;

    /* renamed from: f */
    private Context f25338f;

    /* renamed from: g */
    private SpannableString f25339g;

    /* renamed from: h */
    private ValueAnimator f25340h;

    /* renamed from: i */
    private long f25341i;

    /* renamed from: j */
    private String f25342j = "lottie_departure_loading.json";

    /* renamed from: k */
    private int f25343k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IMarkersCompContract f25344l;

    /* renamed from: m */
    private String f25345m;

    /* renamed from: n */
    private boolean f25346n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Padding f25347o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public CollideRectCallback f25348p;

    /* renamed from: q */
    private ILabelView f25349q = new ILabelView() {
        public /* synthetic */ View getView(Context context, String str, int i) {
            return ILabelView.CC.$default$getView(this, context, str, i);
        }

        public /* synthetic */ View getView(Context context, String str, int i, boolean z) {
            return ILabelView.CC.$default$getView(this, context, str, i, z);
        }

        public View getView(Context context, String str) {
            return LoadingInfoWindow.this.f25334b;
        }
    };

    public interface CollideRectCallback {
        List<Rect> getCollideAvoidRect();
    }

    public void setCollideRectCallback(CollideRectCallback collideRectCallback) {
        this.f25348p = collideRectCallback;
    }

    public LoadingInfoWindow(Context context, IMarkersCompContract iMarkersCompContract, String str, MapView mapView) {
        this.f25338f = context;
        this.f25344l = iMarkersCompContract;
        this.f25345m = str;
        this.f25337e = mapView;
        m18130a();
    }

    /* renamed from: a */
    private void m18130a() {
        Context context = this.f25338f;
        if (context != null && this.f25337e != null && this.f25344l != null && this.f25345m != null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.loading_info_window, (ViewGroup) null);
            this.f25334b = inflate;
            this.f25335c = (TextView) inflate.findViewById(R.id.tv_content);
            this.f25336d = (LottieAnimationView) this.f25334b.findViewById(R.id.loading_lottie);
            DIDIFontUtils.Companion.setTypeface(this.f25338f, this.f25335c);
            this.f25341i = System.currentTimeMillis();
            LottieAnimationView lottieAnimationView = this.f25336d;
            if (lottieAnimationView != null) {
                lottieAnimationView.setAnimation(this.f25342j);
                this.f25336d.setRepeatCount(-1);
            }
        }
    }

    /* renamed from: b */
    private void m18133b() {
        MapView mapView = this.f25337e;
        if (mapView == null || mapView.getMapVendor() != MapVendor.HUAWEI || System.currentTimeMillis() - this.f25341i >= 300) {
            this.f25341i = System.currentTimeMillis();
            IMarkersCompContract iMarkersCompContract = this.f25344l;
            if (iMarkersCompContract == null) {
                return;
            }
            if (this.f25346n) {
                MarkerModel markerModel = new MarkerModel();
                markerModel.setAddressName("breath");
                markerModel.setLabelZIndex(this.f25343k);
                markerModel.setLabelView(this.f25349q);
                markerModel.setLabelDirection(64);
                markerModel.setLabelSelected(false);
                markerModel.setLabelAnchorPadding((Padding) null);
                markerModel.setStrategy(this.f25333a);
                this.f25344l.addMarkerLabel(this.f25345m, markerModel);
                this.f25346n = false;
                return;
            }
            iMarkersCompContract.updateLabelView(this.f25345m, this.f25349q);
        }
    }

    /* renamed from: c */
    private void m18135c() {
        hideLoadingView();
        TextView textView = this.f25335c;
        if (textView != null) {
            textView.setText(this.f25339g);
            this.f25335c.setVisibility(0);
            LottieAnimationView lottieAnimationView = this.f25336d;
            if (lottieAnimationView != null) {
                lottieAnimationView.setVisibility(8);
            }
            this.f25335c.bringToFront();
        }
        m18133b();
    }

    /* renamed from: d */
    private void m18137d() {
        if (this.f25340h == null) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f25340h = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LoadingInfoWindow.this.m18131a(valueAnimator);
                }
            });
            this.f25340h.setDuration(1000);
            this.f25340h.setRepeatCount(-1);
            this.f25340h.setRepeatMode(1);
        }
        if (!this.f25340h.isRunning()) {
            this.f25340h.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m18131a(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        LottieAnimationView lottieAnimationView = this.f25336d;
        if (lottieAnimationView != null) {
            lottieAnimationView.setProgress(floatValue);
        }
        m18133b();
    }

    /* renamed from: e */
    private void m18139e() {
        ValueAnimator valueAnimator = this.f25340h;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f25340h.cancel();
        }
    }

    public void setInfoWindowClickListener(OnMarkerCompClickListener onMarkerCompClickListener) {
        IMarkersCompContract iMarkersCompContract = this.f25344l;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setOnClickListener(onMarkerCompClickListener);
        }
    }

    public void showLoadingView() {
        if (this.f25336d != null) {
            TextView textView = this.f25335c;
            if (textView != null) {
                textView.setVisibility(8);
            }
            this.f25336d.setVisibility(0);
            m18137d();
        }
    }

    public void hideLoadingView() {
        LottieAnimationView lottieAnimationView = this.f25336d;
        if (lottieAnimationView != null) {
            lottieAnimationView.setVisibility(8);
        }
        m18139e();
    }

    public void showText(String str) {
        this.f25339g = new SpannableString(str);
        m18135c();
    }

    public void showText(SpannableString spannableString) {
        this.f25339g = spannableString;
        m18135c();
    }

    public void releaseView() {
        LottieAnimationView lottieAnimationView = this.f25336d;
        if (lottieAnimationView != null && lottieAnimationView.isAnimating()) {
            this.f25336d.cancelAnimation();
        }
        ICollideStrategy iCollideStrategy = this.f25333a;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
        }
        m18139e();
        this.f25334b = null;
        this.f25340h = null;
    }

    public void hideInfoWindow() {
        hideLoadingView();
        IMarkersCompContract iMarkersCompContract = this.f25344l;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setLabelVisible(this.f25345m, false);
        }
    }

    public void showInfoWindow() {
        IMarkersCompContract iMarkersCompContract = this.f25344l;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.setLabelVisible(this.f25345m, true);
        }
    }

    public void setInfoWindowZIndex(int i) {
        this.f25343k = i;
        this.f25344l.updateLabelZindex(this.f25345m, i);
    }

    public void setPadding(Padding padding) {
        this.f25347o = padding;
    }
}
