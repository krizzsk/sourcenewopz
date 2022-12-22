package com.didi.map.global.flow.scene.order.serving.components;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.common.map.MapView;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.flow.utils.ZIndexUtil;
import com.taxis99.R;

public class LabelMarker {
    public static final BitmapDescriptor DEFAULT_ANCHOR_ICON;
    public static final int DEFAULT_COLOR = R.color.label_marker_text;
    public static final ILabelRule DEFAULT_LABEL_RULE = new DefaultLabelRule();
    public static final int LABEL_DIRECTION_LEFT = 1;
    public static final int LABEL_DIRECTION_RIGHT = 2;

    /* renamed from: a */
    private static final Bitmap f26759a;

    /* renamed from: b */
    private MapView f26760b;

    /* renamed from: c */
    private Marker f26761c;

    /* renamed from: d */
    private LatLng f26762d;

    /* renamed from: e */
    private String f26763e;

    /* renamed from: f */
    private int f26764f;

    /* renamed from: g */
    private int f26765g;

    /* renamed from: h */
    private BitmapDescriptor f26766h;

    /* renamed from: i */
    private ILabelRule f26767i = DEFAULT_LABEL_RULE;

    /* renamed from: j */
    private int f26768j = ZIndexUtil.getZIndex(6);

    public interface ILabelRule {
        String applyLabelRule(TextView textView, String str);
    }

    static {
        Bitmap createBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
        f26759a = createBitmap;
        DEFAULT_ANCHOR_ICON = BitmapDescriptorFactory.fromBitmap(createBitmap);
    }

    public LabelMarker(MapView mapView) {
        this.f26760b = mapView;
        this.f26763e = "";
        this.f26764f = DEFAULT_COLOR;
        this.f26765g = 2;
        this.f26766h = DEFAULT_ANCHOR_ICON;
    }

    public LabelMarker position(LatLng latLng) {
        setPosition(latLng);
        return this;
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.f26762d = latLng;
        }
    }

    public LabelMarker label(String str) {
        setLabel(str);
        return this;
    }

    public void setLabel(String str) {
        this.f26763e = str;
    }

    public LabelMarker labelColor(int i) {
        setLabelColor(i);
        return this;
    }

    public void setLabelColor(int i) {
        this.f26764f = i;
    }

    public LabelMarker labelDirection(int i) {
        setLabelDirection(i);
        return this;
    }

    public void setLabelDirection(int i) {
        if (i == 1 || i == 2) {
            this.f26765g = i;
        }
    }

    public LabelMarker anchorIcon(BitmapDescriptor bitmapDescriptor) {
        setAnchorIcon(bitmapDescriptor);
        return this;
    }

    public void setAnchorIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null && bitmapDescriptor.getBitmap() != null) {
            this.f26766h = bitmapDescriptor;
        }
    }

    public LabelMarker labelRule(ILabelRule iLabelRule) {
        setLabelRule(iLabelRule);
        return this;
    }

    public void setLabelRule(ILabelRule iLabelRule) {
        if (iLabelRule != null) {
            this.f26767i = iLabelRule;
        }
    }

    public LabelMarker zIndex(int i) {
        setZIndex(i);
        return this;
    }

    public void setZIndex(int i) {
        this.f26768j = i;
    }

    public Marker getMarker() {
        return this.f26761c;
    }

    public LabelMarker create() {
        m18913b();
        return this;
    }

    public void destroy() {
        m18914c();
    }

    public void update() {
        destroy();
        create();
    }

    /* renamed from: a */
    private boolean m18912a() {
        return this.f26765g == 1;
    }

    /* renamed from: b */
    private void m18913b() {
        MapView mapView = this.f26760b;
        if (mapView != null && mapView.getMap() != null && this.f26760b.getContext() != null) {
            View inflate = LayoutInflater.from(this.f26760b.getContext()).inflate(m18912a() ? R.layout.label_marker_left : R.layout.label_marker_right, (ViewGroup) null);
            MapStrokeTextView mapStrokeTextView = (MapStrokeTextView) inflate.findViewById(R.id.label_marker_text);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.label_marker_anchor);
            if (!TextUtils.isEmpty(this.f26763e)) {
                mapStrokeTextView.setText(this.f26767i.applyLabelRule(mapStrokeTextView, this.f26763e));
            }
            if (this.f26764f != 0) {
                mapStrokeTextView.setTextColor(this.f26760b.getContext().getResources().getColor(this.f26764f));
            }
            BitmapDescriptor bitmapDescriptor = this.f26766h;
            if (bitmapDescriptor != null) {
                Bitmap bitmap = bitmapDescriptor.getBitmap();
                imageView.setImageBitmap(bitmap);
                float width = ((float) bitmap.getWidth()) / 2.0f;
                float height = ((float) bitmap.getHeight()) / 2.0f;
                int textSize = (int) (((mapStrokeTextView.getTextSize() + mapStrokeTextView.getStrokeWidth()) / 2.0f) - height);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, textSize, marginLayoutParams.rightMargin, 0);
                imageView.setLayoutParams(marginLayoutParams);
                Bitmap a = m18911a(inflate);
                if (a != null) {
                    float width2 = (width * 1.0f) / ((float) a.getWidth());
                    float dp2px = (((height + ((float) textSize)) + ((float) DisplayUtils.dp2px(this.f26760b.getContext(), 1.0f))) * 1.0f) / ((float) a.getHeight());
                    if (m18912a()) {
                        width2 = 1.0f - width2;
                    }
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(this.f26762d).icon(BitmapDescriptorFactory.fromBitmap(a));
                    markerOptions.anchor(width2, dp2px);
                    markerOptions.zIndex(this.f26768j);
                    markerOptions.clickable(true);
                    Marker addMarker = this.f26760b.getMap().addMarker(markerOptions);
                    this.f26761c = addMarker;
                    if (addMarker != null) {
                        addMarker.hideInfoWindow();
                    }
                }
            }
        }
    }

    /* renamed from: c */
    private void m18914c() {
        if (this.f26761c != null) {
            this.f26760b.getMap().remove(this.f26761c);
            this.f26761c = null;
        }
    }

    private static class DefaultLabelRule implements ILabelRule {
        private DefaultLabelRule() {
        }

        public String applyLabelRule(TextView textView, String str) {
            int[] iArr = {0};
            textView.setGravity(iArr[0] > 1 ? 3 : 17);
            return LabelMarkerTextRules.rule(str, iArr);
        }
    }

    /* renamed from: a */
    private static Bitmap m18911a(View view) {
        if (view == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        return view.getDrawingCache();
    }
}
