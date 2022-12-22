package com.didi.map.global.flow.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.map.global.flow.scene.order.serving.components.MapStrokeTextView;
import com.didi.map.global.flow.utils.ZIndexUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import org.osgi.framework.VersionRange;

public class AddressNameMarkerWrapper {

    /* renamed from: a */
    private static final char[] f27298a = {VersionRange.LEFT_OPEN, VersionRange.LEFT_CLOSED, 65288};

    /* renamed from: b */
    private static final char[] f27299b = {VersionRange.RIGHT_OPEN, VersionRange.RIGHT_CLOSED, 65289};

    /* renamed from: c */
    private Context f27300c;

    /* renamed from: d */
    private LatLng f27301d;

    /* renamed from: e */
    private String f27302e;

    /* renamed from: f */
    private Marker f27303f;

    /* renamed from: g */
    private Marker f27304g;

    public AddressNameMarkerWrapper(Context context, LatLng latLng, String str) {
        this.f27300c = context;
        this.f27301d = latLng;
        this.f27302e = str;
    }

    public List<IMapElement> getMapElements() {
        ArrayList arrayList = new ArrayList();
        Marker marker = this.f27303f;
        if (marker != null) {
            arrayList.add(marker);
        }
        Marker marker2 = this.f27304g;
        if (marker2 != null) {
            arrayList.add(marker2);
        }
        return arrayList;
    }

    public void addToMap(Map map) {
        this.f27304g = m19291b(map);
    }

    public void removeFromMap(Map map) {
        if (map != null) {
            Marker marker = this.f27303f;
            if (marker != null) {
                map.remove(marker);
                this.f27303f = null;
            }
            Marker marker2 = this.f27304g;
            if (marker2 != null) {
                map.remove(marker2);
                this.f27304g = null;
            }
        }
    }

    /* renamed from: a */
    private Marker m19286a(Map map) {
        MarkerOptions markerOptions = new MarkerOptions();
        Bitmap a = m19285a(LayoutInflater.from(this.f27300c).inflate(R.layout.mfv_address_name_dot, (ViewGroup) null));
        if (a == null) {
            return null;
        }
        markerOptions.position(this.f27301d).anchor(0.5f, 0.5f).icon(BitmapDescriptorFactory.fromBitmap(a)).draggable(false).dodgeAnnotation(true).zIndex(ZIndexUtil.getZIndex(9));
        return map.addMarker(markerOptions);
    }

    /* renamed from: b */
    private Marker m19291b(Map map) {
        if (TextUtils.isEmpty(this.f27302e)) {
            return null;
        }
        String str = this.f27302e;
        MarkerOptions markerOptions = new MarkerOptions();
        View inflate = LayoutInflater.from(this.f27300c).inflate(R.layout.mfv_address_name_text, (ViewGroup) null);
        MapStrokeTextView mapStrokeTextView = (MapStrokeTextView) inflate.findViewById(R.id.tv_address_name);
        mapStrokeTextView.setText(str);
        mapStrokeTextView.getPaint().setFakeBoldText(true);
        Bitmap a = m19285a(inflate);
        if (a == null) {
            return null;
        }
        markerOptions.position(this.f27301d).anchor(0.0f, 0.0f).icon(BitmapDescriptorFactory.fromBitmap(a)).draggable(false).dodgeAnnotation(true).zIndex(ZIndexUtil.getZIndex(9));
        return map.addMarker(markerOptions);
    }

    /* renamed from: a */
    private String m19287a(String str) {
        int length = str.length();
        if (length > 14) {
            String substring = str.substring(0, 6);
            String substring2 = str.substring(length - 6, length);
            return substring + "..." + "\n" + "..." + substring2;
        } else if (length < 8) {
            return str;
        } else {
            if (length > 10) {
                if (m19289a(str.charAt(6))) {
                    return m19288a(str, 6);
                }
                if (m19292b(str.charAt(7))) {
                    return m19288a(str, 8);
                }
                return m19288a(str, 7);
            } else if (m19289a(str.charAt(5))) {
                if (!m19292b(str.charAt(7))) {
                    return m19288a(str, 7);
                }
                if (length == 8) {
                    return str;
                }
                return m19288a(str, 8);
            } else if (m19292b(str.charAt(6))) {
                return m19288a(str, 7);
            } else {
                return m19288a(str, 6);
            }
        }
    }

    /* renamed from: a */
    private boolean m19289a(char c) {
        return m19290a(f27298a, c);
    }

    /* renamed from: b */
    private boolean m19292b(char c) {
        return m19290a(f27299b, c);
    }

    /* renamed from: a */
    private boolean m19290a(char[] cArr, char c) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private String m19288a(String str, int i) {
        String substring = str.substring(0, i);
        String substring2 = str.substring(i, str.length());
        return substring + "\n" + substring2;
    }

    /* renamed from: a */
    private Bitmap m19285a(View view) {
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            view.buildDrawingCache();
            return view.getDrawingCache();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getTextWidth() {
        return this.f27304g.getMarkerSize().width;
    }

    public Marker getMarker() {
        return this.f27304g;
    }
}
