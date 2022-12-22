package com.didi.map.global.component.markers.view;

import android.graphics.Bitmap;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.model.BitmapDescriptor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.MapUtils;

public class LabelMarker {

    /* renamed from: a */
    private final Map f25992a;

    /* renamed from: b */
    private Marker f25993b;

    /* renamed from: c */
    private LatLng f25994c;

    /* renamed from: d */
    private String f25995d = "";

    /* renamed from: e */
    private int f25996e = 1;

    /* renamed from: f */
    private boolean f25997f;

    /* renamed from: g */
    private BitmapDescriptor f25998g;

    /* renamed from: h */
    private float f25999h;

    /* renamed from: i */
    private float f26000i;

    /* renamed from: j */
    private Padding f26001j = new Padding(0, 0, 0, 0);

    /* renamed from: k */
    private Padding f26002k = new Padding(0, 0, 0, 0);

    /* renamed from: l */
    private ILabelView f26003l;

    /* renamed from: m */
    private int f26004m = 100;

    /* renamed from: n */
    private boolean f26005n;

    public LabelMarker(Map map) {
        this.f25992a = map;
    }

    public LabelMarker create() {
        m18475a();
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m18475a() {
        /*
            r15 = this;
            com.didi.common.map.Map r0 = r15.f25992a
            if (r0 == 0) goto L_0x0196
            com.didi.map.global.component.markers.view.ILabelView r1 = r15.f26003l
            if (r1 == 0) goto L_0x0196
            com.didi.common.map.model.BitmapDescriptor r2 = r15.f25998g
            if (r2 != 0) goto L_0x000e
            goto L_0x0196
        L_0x000e:
            android.content.Context r0 = r0.getContext()
            java.lang.String r2 = r15.f25995d
            int r3 = r15.f25996e
            boolean r4 = r15.f25997f
            android.view.View r0 = r1.getView(r0, r2, r3, r4)
            if (r0 != 0) goto L_0x001f
            return
        L_0x001f:
            android.graphics.Bitmap r0 = com.didi.common.map.util.MapUtils.getViewBitmap(r0)
            if (r0 != 0) goto L_0x0026
            return
        L_0x0026:
            com.didi.common.map.model.BitmapDescriptor r1 = r15.f25998g
            android.graphics.Bitmap r1 = r1.getBitmap()
            int r2 = r1.getWidth()
            float r2 = (float) r2
            int r1 = r1.getHeight()
            float r1 = (float) r1
            int r3 = r0.getWidth()
            float r3 = (float) r3
            int r4 = r0.getHeight()
            float r4 = (float) r4
            int r5 = r15.f25996e
            r6 = 1
            r7 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            r9 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            if (r5 == r6) goto L_0x0148
            r6 = 2
            if (r5 == r6) goto L_0x0122
            r6 = 4
            if (r5 == r6) goto L_0x0108
            r6 = 8
            if (r5 == r6) goto L_0x00e8
            r6 = 16
            if (r5 == r6) goto L_0x00cd
            r6 = 32
            if (r5 == r6) goto L_0x00a6
            r6 = 64
            if (r5 == r6) goto L_0x0089
            r6 = 128(0x80, float:1.794E-43)
            if (r5 == r6) goto L_0x0067
            r1 = 0
            goto L_0x0167
        L_0x0067:
            com.didi.common.map.model.Padding r5 = r15.f26001j
            int r5 = r5.right
            com.didi.common.map.model.Padding r6 = r15.f26002k
            int r6 = r6.left
            int r5 = r5 + r6
            float r5 = (float) r5
            float r6 = r15.f25999h
            float r8 = r8 - r6
            float r2 = r2 * r8
            float r5 = r5 - r2
            float r7 = r5 / r3
            float r2 = r15.f26000i
            float r1 = r1 * r2
            float r1 = r1 + r4
            com.didi.common.map.model.Padding r2 = r15.f26001j
            int r2 = r2.top
            float r2 = (float) r2
            float r1 = r1 - r2
            com.didi.common.map.model.Padding r2 = r15.f26002k
            int r2 = r2.bottom
            goto L_0x00c8
        L_0x0089:
            double r5 = (double) r3
            double r7 = r5 * r9
            float r3 = r15.f25999h
            double r11 = (double) r3
            double r9 = r9 - r11
            double r2 = (double) r2
            double r9 = r9 * r2
            double r7 = r7 - r9
            double r7 = r7 / r5
            float r7 = (float) r7
            float r2 = r15.f26000i
            float r1 = r1 * r2
            float r1 = r1 + r4
            com.didi.common.map.model.Padding r2 = r15.f26001j
            int r2 = r2.top
            float r2 = (float) r2
            float r1 = r1 - r2
            com.didi.common.map.model.Padding r2 = r15.f26002k
            int r2 = r2.bottom
            goto L_0x00c8
        L_0x00a6:
            float r5 = r15.f25999h
            float r2 = r2 * r5
            com.didi.common.map.model.Padding r5 = r15.f26001j
            int r5 = r5.left
            float r5 = (float) r5
            float r2 = r2 - r5
            com.didi.common.map.model.Padding r5 = r15.f26002k
            int r5 = r5.right
            float r5 = (float) r5
            float r2 = r2 - r5
            float r2 = r2 + r3
            float r7 = r2 / r3
            float r2 = r15.f26000i
            float r1 = r1 * r2
            float r1 = r1 + r4
            com.didi.common.map.model.Padding r2 = r15.f26001j
            int r2 = r2.top
            float r2 = (float) r2
            float r1 = r1 - r2
            com.didi.common.map.model.Padding r2 = r15.f26002k
            int r2 = r2.bottom
        L_0x00c8:
            float r2 = (float) r2
            float r1 = r1 - r2
            float r1 = r1 / r4
            goto L_0x0167
        L_0x00cd:
            float r5 = r15.f25999h
            float r2 = r2 * r5
            com.didi.common.map.model.Padding r5 = r15.f26001j
            int r5 = r5.left
            float r5 = (float) r5
            float r2 = r2 - r5
            float r2 = r2 + r3
            com.didi.common.map.model.Padding r5 = r15.f26002k
            int r5 = r5.right
            float r5 = (float) r5
            float r2 = r2 - r5
            float r7 = r2 / r3
            double r2 = (double) r4
            double r4 = r2 * r9
            double r11 = (double) r1
            float r1 = r15.f26000i
            goto L_0x0160
        L_0x00e8:
            float r5 = r15.f25999h
            float r2 = r2 * r5
            com.didi.common.map.model.Padding r5 = r15.f26001j
            int r5 = r5.left
            float r5 = (float) r5
            float r2 = r2 - r5
            com.didi.common.map.model.Padding r5 = r15.f26002k
            int r5 = r5.right
            float r5 = (float) r5
            float r2 = r2 - r5
            float r2 = r2 + r3
            float r7 = r2 / r3
            com.didi.common.map.model.Padding r2 = r15.f26001j
            int r2 = r2.bottom
            com.didi.common.map.model.Padding r3 = r15.f26002k
            int r3 = r3.top
            int r2 = r2 + r3
            float r2 = (float) r2
            float r3 = r15.f26000i
            goto L_0x0141
        L_0x0108:
            double r5 = (double) r3
            double r11 = r5 * r9
            float r3 = r15.f25999h
            double r13 = (double) r3
            double r9 = r9 - r13
            double r2 = (double) r2
            double r9 = r9 * r2
            double r11 = r11 - r9
            double r11 = r11 / r5
            float r7 = (float) r11
            com.didi.common.map.model.Padding r2 = r15.f26001j
            int r2 = r2.bottom
            com.didi.common.map.model.Padding r3 = r15.f26002k
            int r3 = r3.top
            int r2 = r2 + r3
            float r2 = (float) r2
            float r3 = r15.f26000i
            goto L_0x0141
        L_0x0122:
            com.didi.common.map.model.Padding r5 = r15.f26001j
            int r5 = r5.right
            com.didi.common.map.model.Padding r6 = r15.f26002k
            int r6 = r6.left
            int r5 = r5 + r6
            float r5 = (float) r5
            float r6 = r15.f25999h
            float r6 = r8 - r6
            float r2 = r2 * r6
            float r5 = r5 - r2
            float r7 = r5 / r3
            com.didi.common.map.model.Padding r2 = r15.f26001j
            int r2 = r2.bottom
            com.didi.common.map.model.Padding r3 = r15.f26002k
            int r3 = r3.top
            int r2 = r2 + r3
            float r2 = (float) r2
            float r3 = r15.f26000i
        L_0x0141:
            float r8 = r8 - r3
            float r1 = r1 * r8
            float r2 = r2 - r1
            float r1 = r2 / r4
            goto L_0x0167
        L_0x0148:
            com.didi.common.map.model.Padding r5 = r15.f26001j
            int r5 = r5.right
            com.didi.common.map.model.Padding r6 = r15.f26002k
            int r6 = r6.left
            int r5 = r5 + r6
            float r5 = (float) r5
            float r6 = r15.f25999h
            float r8 = r8 - r6
            float r2 = r2 * r8
            float r5 = r5 - r2
            float r7 = r5 / r3
            double r2 = (double) r4
            double r4 = r2 * r9
            double r11 = (double) r1
            float r1 = r15.f26000i
        L_0x0160:
            double r13 = (double) r1
            double r13 = r13 - r9
            double r11 = r11 * r13
            double r4 = r4 + r11
            double r4 = r4 / r2
            float r1 = (float) r4
        L_0x0167:
            com.didi.common.map.model.MarkerOptions r2 = new com.didi.common.map.model.MarkerOptions
            r2.<init>()
            com.didi.common.map.model.LatLng r3 = r15.f25994c
            com.didi.common.map.model.MarkerOptions r3 = r2.position(r3)
            com.didi.common.map.model.BitmapDescriptor r0 = com.didi.common.map.model.BitmapDescriptorFactory.fromBitmap(r0)
            com.didi.common.map.model.MarkerOptions r0 = r3.icon(r0)
            com.didi.common.map.model.MarkerOptions r0 = r0.anchor(r7, r1)
            int r1 = r15.f26004m
            com.didi.common.map.internal.IMapElementOptions r0 = r0.zIndex(r1)
            boolean r1 = r15.f26005n
            r0.clickable(r1)
            com.didi.common.map.Map r0 = r15.f25992a
            com.didi.common.map.model.Marker r0 = r0.addMarker(r2)
            r15.f25993b = r0
            if (r0 == 0) goto L_0x0196
            r0.hideInfoWindow()
        L_0x0196:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.markers.view.LabelMarker.m18475a():void");
    }

    public void updateLabelView(ILabelView iLabelView) {
        ILabelView iLabelView2;
        View view;
        Bitmap viewBitmap;
        float f;
        double d;
        double d2;
        double d3;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i;
        float f7;
        if (this.f25993b != null && (iLabelView2 = this.f26003l) != null && (view = iLabelView2.getView(this.f25992a.getContext(), this.f25995d, this.f25996e, this.f25997f)) != null && (viewBitmap = MapUtils.getViewBitmap(view)) != null) {
            Bitmap bitmap = this.f25998g.getBitmap();
            float width = (float) bitmap.getWidth();
            float height = (float) bitmap.getHeight();
            float width2 = (float) viewBitmap.getWidth();
            float height2 = (float) viewBitmap.getHeight();
            int i2 = this.f25996e;
            float f8 = 0.0f;
            if (i2 != 1) {
                if (i2 == 2) {
                    f6 = (((float) (this.f26001j.right + this.f26002k.left)) - (width * (1.0f - this.f25999h))) / width2;
                    f5 = (float) (this.f26001j.bottom + this.f26002k.top);
                    f4 = this.f26000i;
                } else if (i2 == 4) {
                    double d4 = (double) width2;
                    f6 = (float) (((d4 * 0.5d) - ((0.5d - ((double) this.f25999h)) * ((double) width))) / d4);
                    f5 = (float) (this.f26001j.bottom + this.f26002k.top);
                    f4 = this.f26000i;
                } else if (i2 == 8) {
                    f6 = ((((width * this.f25999h) - ((float) this.f26001j.left)) - ((float) this.f26002k.right)) + width2) / width2;
                    f5 = (float) (this.f26001j.bottom + this.f26002k.top);
                    f4 = this.f26000i;
                } else if (i2 != 16) {
                    if (i2 == 32) {
                        f8 = ((((width * this.f25999h) - ((float) this.f26001j.left)) - ((float) this.f26002k.right)) + width2) / width2;
                        f7 = ((height * this.f26000i) + height2) - ((float) this.f26001j.top);
                        i = this.f26002k.bottom;
                    } else if (i2 == 64) {
                        double d5 = (double) width2;
                        f8 = (float) (((d5 * 0.5d) - ((0.5d - ((double) this.f25999h)) * ((double) width))) / d5);
                        f7 = ((height * this.f26000i) + height2) - ((float) this.f26001j.top);
                        i = this.f26002k.bottom;
                    } else if (i2 != 128) {
                        f = 0.0f;
                        this.f25993b.setAnchor(f8, f);
                        this.f25993b.setIcon(this.f25992a.getContext(), BitmapDescriptorFactory.fromBitmap(viewBitmap));
                    } else {
                        f8 = (((float) (this.f26001j.right + this.f26002k.left)) - (width * (1.0f - this.f25999h))) / width2;
                        f7 = ((height * this.f26000i) + height2) - ((float) this.f26001j.top);
                        i = this.f26002k.bottom;
                    }
                    f = (f7 - ((float) i)) / height2;
                    this.f25993b.setAnchor(f8, f);
                    this.f25993b.setIcon(this.f25992a.getContext(), BitmapDescriptorFactory.fromBitmap(viewBitmap));
                } else {
                    f3 = ((((width * this.f25999h) - ((float) this.f26001j.left)) + width2) - ((float) this.f26002k.right)) / width2;
                    d3 = (double) height2;
                    d2 = d3 * 0.5d;
                    d = (double) height;
                    f2 = this.f26000i;
                }
                f = (f5 - (height * (1.0f - f4))) / height2;
                this.f25993b.setAnchor(f8, f);
                this.f25993b.setIcon(this.f25992a.getContext(), BitmapDescriptorFactory.fromBitmap(viewBitmap));
            }
            f3 = (((float) (this.f26001j.right + this.f26002k.left)) - (width * (1.0f - this.f25999h))) / width2;
            d3 = (double) height2;
            d2 = d3 * 0.5d;
            d = (double) height;
            f2 = this.f26000i;
            f = (float) ((d2 + (d * (((double) f2) - 0.5d))) / d3);
            this.f25993b.setAnchor(f8, f);
            this.f25993b.setIcon(this.f25992a.getContext(), BitmapDescriptorFactory.fromBitmap(viewBitmap));
        }
    }

    public LabelMarker position(LatLng latLng) {
        setPosition(latLng);
        return this;
    }

    public LabelMarker label(String str) {
        this.f25995d = str;
        return this;
    }

    public LabelMarker labelDirection(int i) {
        this.f25996e = i;
        return this;
    }

    public LabelMarker isSelected(boolean z) {
        this.f25997f = z;
        return this;
    }

    public LabelMarker rootMarkerAnchor(BitmapDescriptor bitmapDescriptor, float f, float f2, Padding padding) {
        if (!(bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null)) {
            this.f25998g = bitmapDescriptor;
            this.f25999h = f;
            this.f26000i = f2;
            if (padding != null) {
                this.f26001j = padding;
            }
        }
        return this;
    }

    public LabelMarker labelAnchorPadding(Padding padding) {
        if (padding != null) {
            this.f26002k = padding;
        }
        return this;
    }

    public LabelMarker labelView(ILabelView iLabelView) {
        if (iLabelView != null) {
            this.f26003l = iLabelView;
        }
        return this;
    }

    public LabelMarker zIndex(int i) {
        this.f26004m = i;
        return this;
    }

    public LabelMarker clickable(boolean z) {
        this.f26005n = z;
        return this;
    }

    public Marker getMarker() {
        return this.f25993b;
    }

    public void destroy() {
        Map map;
        Marker marker = this.f25993b;
        if (marker != null && (map = this.f25992a) != null) {
            map.remove(marker);
            this.f25993b = null;
        }
    }

    public int getLabelDirection() {
        return this.f25996e;
    }

    public boolean getLabelSelected() {
        return this.f25997f;
    }

    public void setPosition(LatLng latLng) {
        if (latLng != null) {
            this.f25994c = latLng;
        }
        Marker marker = this.f25993b;
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    public float getAlpha() {
        Marker marker = this.f25993b;
        if (marker != null) {
            return marker.getAlpha();
        }
        return 0.0f;
    }

    public void setAlpha(float f) {
        Marker marker = this.f25993b;
        if (marker != null) {
            marker.setAlpha(f);
        }
    }

    /* renamed from: a */
    private static Bitmap m18474a(View view) {
        if (view == null) {
            return null;
        }
        return MapUtils.getViewBitmap(view);
    }

    public void setVisible(boolean z) {
        Marker marker = this.f25993b;
        if (marker != null) {
            marker.setVisible(z);
        }
    }
}
