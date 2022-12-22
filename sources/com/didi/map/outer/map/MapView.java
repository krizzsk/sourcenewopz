package com.didi.map.outer.map;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.didi.hawaii.basic.HWContextProvider;
import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.log.LoggerInit;
import com.didi.hawaii.net.NetUtil;
import com.didi.hawaii.utils.AsyncNetUtils;
import com.didi.hawaii.utils.StorageUtils;
import com.didi.map.MapApolloHawaii;
import com.didi.map.alpha.adapt.MapUtil;
import com.didi.map.common.ApolloHawaii;
import com.didi.map.common.accessibility.AccessibilityUtils;
import com.didi.map.common.lib.MapLibaryLoader;
import com.didi.map.common.utils.NetSeqUtils;
import com.didi.support.device.DeviceUtils;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class MapView extends FrameLayout {

    /* renamed from: c */
    private static final String f27864c = "com.didi.hawaii.mapsdkv2.HWMapView";

    /* renamed from: d */
    private static final String f27865d = "com.didi.hawaii.mapsdkv2.VKMapView";

    /* renamed from: e */
    private static final String f27866e = "com.didi.hawaii.mapsdkv2.HWTextureMapView";

    /* renamed from: f */
    private static final String f27867f = (ApolloHawaii.USE_VULKAN_MAP ? f27865d : f27864c);

    /* renamed from: h */
    private static final String f27868h = "com.didi.map.intent.DUMP_INSPECT_INFO";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public DidiMap f27869a;

    /* renamed from: b */
    private ImageView f27870b;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MapDebugView f27871g;

    /* renamed from: i */
    private boolean f27872i;

    /* renamed from: j */
    private final BroadcastReceiver f27873j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public MapOpenGL f27874k;

    /* renamed from: l */
    private HawaiiTouchHelper f27875l;

    public MapView(Context context) {
        super(context);
        this.f27869a = null;
        this.f27872i = false;
        this.f27873j = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (MapView.this.f27874k != null) {
                    MapView.this.f27874k.dumpInspectInfo();
                }
            }
        };
        m19930a(context, MapOptions.createDefaultOptions());
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27869a = null;
        this.f27872i = false;
        this.f27873j = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (MapView.this.f27874k != null) {
                    MapView.this.f27874k.dumpInspectInfo();
                }
            }
        };
        m19930a(context, MapOptions.createDefaultOptions());
    }

    public MapView(Context context, int i, MapOptions mapOptions) {
        this(context, mapOptions);
    }

    public MapView(Context context, MapOptions mapOptions) {
        super(context);
        this.f27869a = null;
        this.f27872i = false;
        this.f27873j = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (MapView.this.f27874k != null) {
                    MapView.this.f27874k.dumpInspectInfo();
                }
            }
        };
        m19930a(context, mapOptions);
    }

    /* renamed from: a */
    private void m19930a(Context context, MapOptions mapOptions) {
        m19929a(context);
        setClickable(true);
        if (!isInEditMode()) {
            if (mapOptions == null) {
                mapOptions = MapOptions.createDefaultOptions();
            }
            m19933b(context, mapOptions);
        }
    }

    /* renamed from: a */
    private void m19929a(Context context) {
        HWContextProvider.setContextIfNecessary(context);
        AsyncNetUtils.init(context);
        NetUtil.initNet(context, MapUtil.getUserAgent());
        DeviceUtils.init(context);
        StorageUtils.init(context);
        MapLibaryLoader.init(context);
        LoggerInit.initAll(context, false);
        NetSeqUtils.init();
    }

    /* renamed from: b */
    private void m19933b(final Context context, MapOptions mapOptions) {
        setEnabled(true);
        try {
            String str = f27867f;
            if ((mapOptions != null && mapOptions.isUseTextureMapView()) || ApolloHawaii.IS_USE_TEXTUREVIEW) {
                str = f27866e;
            }
            HWLog.m16761i("hawaii-map", "use map view:" + str + ",version:" + "5766");
            Object newInstance = Class.forName(str).getConstructor(new Class[]{Context.class, MapOptions.class}).newInstance(new Object[]{context, mapOptions});
            if (!(newInstance instanceof View) || !(newInstance instanceof MapOpenGL)) {
                throw new IllegalStateException("com.didi.hawaii.mapsdkv2.HWMapView is not a view nor a MapOpenGL!");
            }
            addView((View) newInstance, new FrameLayout.LayoutParams(-1, -1));
            this.f27874k = (MapOpenGL) newInstance;
            if (m19931a()) {
                try {
                    getContext().registerReceiver(this.f27873j, new IntentFilter(f27868h));
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
                this.f27872i = true;
                this.f27874k.setOnMapReadyCallback(new OnMapReadyCallback() {
                    public void onMapReady(DidiMap didiMap) {
                        DidiMap unused = MapView.this.f27869a = didiMap;
                        MapDebugView unused2 = MapView.this.f27871g = new MapDebugView(context);
                        MapView.this.f27871g.init(didiMap, MapView.this);
                    }
                });
            }
            setAccessibilityDelegate(context);
        } catch (ClassNotFoundException e2) {
            throw new IllegalStateException(e2);
        } catch (NoSuchMethodException e3) {
            throw new IllegalStateException(e3);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException(e4);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        } catch (InvocationTargetException e6) {
            throw new IllegalStateException(e6);
        }
    }

    public void getMapAsync(final OnMapReadyCallback onMapReadyCallback) {
        MapOpenGL mapOpenGL = this.f27874k;
        if (mapOpenGL != null) {
            mapOpenGL.setOnMapReadyCallback(new OnMapReadyCallback() {
                public void onMapReady(DidiMap didiMap) {
                    DidiMap unused = MapView.this.f27869a = didiMap;
                    onMapReadyCallback.onMapReady(didiMap);
                }
            });
        }
    }

    private void setAccessibilityDelegate(Context context) {
        if (MapApolloHawaii.isTalkbackOpen() && AccessibilityUtils.isAccessibilityTackbackEnable(context) && this.f27875l == null) {
            HawaiiTouchHelper hawaiiTouchHelper = new HawaiiTouchHelper(this);
            this.f27875l = hawaiiTouchHelper;
            ViewCompat.setAccessibilityDelegate(this, hawaiiTouchHelper);
        }
    }

    public final DidiMap getMap() {
        return this.f27869a;
    }

    public void onStart() {
        DidiMap didiMap = this.f27869a;
        if (didiMap != null) {
            didiMap.onStart();
        }
    }

    public void onStop() {
        DidiMap didiMap = this.f27869a;
        if (didiMap != null) {
            didiMap.onStop();
        }
        MapDebugView mapDebugView = this.f27871g;
        if (mapDebugView != null) {
            mapDebugView.onStop();
        }
    }

    public void onDestroy() {
        MapOpenGL mapOpenGL = this.f27874k;
        if (mapOpenGL != null) {
            mapOpenGL.onDestroy();
            this.f27874k = null;
        }
        HWLog.m16761i("hawaii-map", "MapView onDestroy");
        MapDebugView mapDebugView = this.f27871g;
        if (mapDebugView != null) {
            mapDebugView.onDestroy();
        }
        if (this.f27872i) {
            try {
                getContext().unregisterReceiver(this.f27873j);
            } catch (Exception e) {
                Log.d("Context", "unregisterReceiver", e);
            }
            this.f27872i = false;
        }
    }

    public void onResume() {
        MapOpenGL mapOpenGL = this.f27874k;
        if (mapOpenGL != null) {
            mapOpenGL.onResume();
        }
        MapDebugView mapDebugView = this.f27871g;
        if (mapDebugView != null) {
            mapDebugView.onResume();
        }
    }

    public void onPause() {
        MapOpenGL mapOpenGL = this.f27874k;
        if (mapOpenGL != null) {
            mapOpenGL.onPause();
        }
    }

    public void onRestart() {
        DidiMap didiMap = this.f27869a;
        if (didiMap != null) {
            didiMap.onRestart();
        }
    }

    public void setOnTop(boolean z) {
        DidiMap didiMap = this.f27869a;
        if (didiMap != null) {
            didiMap.setOnTop(z);
        }
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.f27874k != null) {
            HWLog.m16761i("hawaii-map", "MapView setVisibility:" + i);
            this.f27874k.setVisibility(i);
            if (i == 8 || i == 4) {
                this.f27874k.onPause();
            } else {
                this.f27874k.onResume();
            }
        }
    }

    public void setMapPadding(int i, int i2, int i3, int i4) {
        setPadding(i, i2, i3, i4);
    }

    public int[] getMapPadding() {
        return new int[]{getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom()};
    }

    public void showLogoForInternationalWms(int i) {
        Bitmap bitmap;
        Context context = getContext();
        if (i == -1) {
            ImageView imageView = this.f27870b;
            if (imageView != null) {
                removeView(imageView);
                this.f27870b = null;
                return;
            }
            return;
        }
        if (this.f27870b == null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 80;
            layoutParams.bottomMargin = 15;
            layoutParams.leftMargin = 15;
            ImageView imageView2 = new ImageView(context);
            this.f27870b = imageView2;
            imageView2.setBackgroundColor(0);
            addView(this.f27870b, layoutParams);
        }
        if (i == 0) {
            bitmap = MapUtil.getBitmapFromAsset(context, "hawaii_wms_google.png");
        } else {
            bitmap = MapUtil.getBitmapFromAsset(context, "hawaii_wms_bing.png");
        }
        this.f27870b.setImageBitmap(bitmap);
    }

    public class HawaiiTouchHelper extends ExploreByTouchHelper {
        /* access modifiers changed from: protected */
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            return false;
        }

        public HawaiiTouchHelper(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public synchronized int getVirtualViewAt(float f, float f2) {
            if (MapView.this.f27869a == null || MapView.this.f27869a.getAccessManager() == null) {
                return Integer.MIN_VALUE;
            }
            return MapView.this.f27869a.getAccessManager().getVirtualViewAt(f, f2);
        }

        /* access modifiers changed from: protected */
        public synchronized void getVisibleVirtualViews(List<Integer> list) {
            if (!(MapView.this.f27869a == null || MapView.this.f27869a.getAccessManager() == null)) {
                MapView.this.f27869a.getAccessManager().getVisibleVirtualViews(list);
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (!(MapView.this.f27869a == null || MapView.this.f27869a.getAccessManager() == null)) {
                MapView.this.f27869a.getAccessManager().onPopulateNodeForVirtualView(i, accessibilityNodeInfoCompat);
            }
        }

        /* access modifiers changed from: protected */
        public synchronized void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
            if (!(MapView.this.f27869a == null || MapView.this.f27869a.getAccessManager() == null)) {
                MapView.this.f27869a.getAccessManager().onPopulateEventForVirtualView(i, accessibilityEvent);
            }
        }
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        HawaiiTouchHelper hawaiiTouchHelper;
        if (motionEvent.getAction() == 9 && (hawaiiTouchHelper = this.f27875l) != null) {
            int virtualViewAt = hawaiiTouchHelper.getVirtualViewAt(motionEvent.getX(), motionEvent.getY());
            if (virtualViewAt != Integer.MIN_VALUE) {
                this.f27875l.getAccessibilityNodeProvider(this).performAction(this.f27875l.getVirtualViewAt(motionEvent.getX(), motionEvent.getY()), 64, (Bundle) null);
            }
            this.f27875l.dispatchHoverEvent(motionEvent);
            if (virtualViewAt != Integer.MIN_VALUE) {
                this.f27875l.getAccessibilityNodeProvider(this).performAction(this.f27875l.getVirtualViewAt(motionEvent.getX(), motionEvent.getY()), 128, (Bundle) null);
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }

    /* renamed from: a */
    private boolean m19931a() {
        return (getContext().getApplicationInfo().flags & 2) != 0;
    }
}
