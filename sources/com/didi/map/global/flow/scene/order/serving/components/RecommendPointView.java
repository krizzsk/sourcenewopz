package com.didi.map.global.flow.scene.order.serving.components;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.didi.common.map.Map;
import com.didi.common.map.Projection;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.taxis99.R;
import java.util.List;
import org.json.JSONObject;

public class RecommendPointView {

    /* renamed from: a */
    private Context f26806a;

    /* renamed from: b */
    private Map f26807b;

    /* renamed from: c */
    private MarkerManager f26808c;

    /* renamed from: d */
    private boolean f26809d;

    public RecommendPointView(Context context, Map map, MarkerManager markerManager) {
        this.f26806a = context;
        this.f26807b = map;
        this.f26808c = markerManager;
    }

    public void showMarkerView(MapElementId mapElementId, String str) {
        if (!TextUtils.isEmpty(str)) {
            View inflate = LayoutInflater.from(this.f26806a).inflate(R.layout.lable_recommend_pickup_point, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.label_text);
            if (m18936a(str)) {
                LEGORichInfo lEGORichInfo = new LEGORichInfo();
                lEGORichInfo.setInfo(str);
                textView.setText(lEGORichInfo.parseRichInfo(this.f26806a));
            } else {
                textView.setTextColor(Color.parseColor(ColorUtils.DIDI_GREEN_MOUTON));
                textView.setText(str);
            }
            InfoWindow.Position a = m18935a();
            textView.setBackground(m18934a(a));
            if (mapElementId == MapElementId.ID_MARKER_START) {
                this.f26809d = true;
            }
            this.f26808c.updateMarkerBubble(mapElementId, inflate, a, false, true);
        }
    }

    public void hideIconMarkerBubble() {
        if (this.f26809d) {
            this.f26808c.hideIconMarkerBubble(MapElementId.ID_MARKER_START);
            this.f26809d = false;
        }
    }

    public Marker getRecommendStartIconMarker() {
        return this.f26808c.getIconMarker(MapElementId.ID_MARKER_RECOMMEND);
    }

    public List<IMapElement> getRecommendMakerElements() {
        List<IMapElement> makerMapElements = this.f26808c.getMakerMapElements(MapElementId.ID_MARKER_RECOMMEND);
        Marker iconMarker = this.f26808c.getIconMarker(MapElementId.ID_MARKER_RECOMMEND);
        if (!(iconMarker == null || iconMarker.getInfoWindow() == null || iconMarker.getInfoWindow().getInfoWindowMarker() == null)) {
            makerMapElements.add(iconMarker.getInfoWindow().getInfoWindowMarker());
        }
        return makerMapElements;
    }

    /* renamed from: a */
    private Drawable m18934a(InfoWindow.Position position) {
        Drawable drawable;
        try {
            if (position == InfoWindow.Position.LEFT_TOP) {
                drawable = ResourcesCompat.getDrawable(this.f26806a.getResources(), R.drawable.bubble_left_top, (Resources.Theme) null);
            } else if (position == InfoWindow.Position.RIGHT_TOP) {
                drawable = ResourcesCompat.getDrawable(this.f26806a.getResources(), R.drawable.bubble_right_top, (Resources.Theme) null);
            } else {
                drawable = ResourcesCompat.getDrawable(this.f26806a.getResources(), R.drawable.bubble_right_top, (Resources.Theme) null);
            }
            return drawable;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private InfoWindow.Position m18935a() {
        try {
            Marker iconMarker = this.f26808c.getIconMarker(MapElementId.ID_MARKER_START);
            Marker iconMarker2 = this.f26808c.getIconMarker(MapElementId.ID_MARKER_RECOMMEND);
            if (!(iconMarker == null || iconMarker2 == null)) {
                LatLng position = iconMarker.getPosition();
                LatLng position2 = iconMarker2.getPosition();
                Projection projection = this.f26807b.getProjection();
                if (projection.toScreenLocation(position2).x > projection.toScreenLocation(position).x) {
                    return InfoWindow.Position.RIGHT_TOP;
                }
                return InfoWindow.Position.LEFT_TOP;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return InfoWindow.Position.RIGHT_TOP;
    }

    /* renamed from: a */
    private static boolean m18936a(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
