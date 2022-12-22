package com.didi.hawaii.mapsdkv2.adapter;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.didi.hawaii.mapsdkv2.adapter.option.GLCollisionGroupOptionAdapter;
import com.didi.hawaii.mapsdkv2.adapter.option.GLCollisionMarkerOptionAdapter;
import com.didi.hawaii.mapsdkv2.adapter.option.GLCollisionStubOptionAdapter;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.overlay.GLCollisionGroup;
import com.didi.hawaii.mapsdkv2.core.overlay.GLCollisionMarker;
import com.didi.hawaii.mapsdkv2.core.overlay.GLCollisionStub;
import com.didi.map.alpha.maps.internal.ICollisionGroupDelegate;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.model.CameraPosition;
import com.didi.map.outer.model.CollisionGroup;
import com.didi.map.outer.model.CollisionGroupOption;
import com.didi.map.outer.model.CollisionMarker;
import com.didi.map.outer.model.CollisionMarkerOption;
import com.didi.map.outer.model.CollisionStub;
import com.didi.map.outer.model.CollisionStubOption;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.MapGestureListener;
import com.didi.map.outer.model.MapGestureListenerAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CollisionGroupDelegate extends C9003b implements ICollisionGroupDelegate {

    /* renamed from: b */
    private static final GLCollisionGroupOptionAdapter f23692b = new GLCollisionGroupOptionAdapter();

    /* renamed from: c */
    private static final long f23693c = 300;

    /* renamed from: d */
    private final Handler f23694d = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: e */
    public float f23695e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public float f23696f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public float f23697g;

    /* renamed from: h */
    private final MarkerDelegate f23698h;

    /* renamed from: i */
    private final ConcurrentHashMap<String, List<String>> f23699i = new ConcurrentHashMap<>();

    /* renamed from: j */
    private final DidiMap.OnCameraChangeListener f23700j = new DidiMap.OnCameraChangeListener() {
        public void onCameraChange(CameraPosition cameraPosition) {
            float f = cameraPosition.zoom;
            float f2 = cameraPosition.bearing;
            float f3 = cameraPosition.tilt;
            if (CollisionGroupDelegate.this.f23695e != f && f != 0.0f) {
                float unused = CollisionGroupDelegate.this.f23695e = f;
                CollisionGroupDelegate.this.m16832a();
            } else if (CollisionGroupDelegate.this.f23696f != f2 && f2 != 0.0f) {
                float unused2 = CollisionGroupDelegate.this.f23696f = f2;
                CollisionGroupDelegate.this.m16832a();
            } else if (CollisionGroupDelegate.this.f23697g != f3 && f3 != 0.0f) {
                float unused3 = CollisionGroupDelegate.this.f23697g = f3;
                CollisionGroupDelegate.this.m16832a();
            }
        }
    };

    /* renamed from: k */
    private final MapGestureListener f23701k = new MapGestureListenerAdapter() {
        public void onMapStable() {
            CollisionGroupDelegate.this.m16840c();
        }
    };

    /* renamed from: l */
    private final Runnable f23702l = new Runnable() {
        public void run() {
            CollisionGroupDelegate.this.m16840c();
        }
    };

    public CollisionGroupDelegate(MarkerDelegate markerDelegate, MapManagerDelegate mapManagerDelegate, GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map) {
        super(gLViewManager, map);
        mapManagerDelegate.addOnCameraChangeListener(this.f23700j);
        mapManagerDelegate.addMapGestureListener(this.f23701k);
        this.f23698h = markerDelegate;
    }

    public CollisionGroup addCollisionGroup(CollisionGroupOption collisionGroupOption) {
        GLCollisionGroup gLCollisionGroup = new GLCollisionGroup(this.viewManager, f23692b.get(collisionGroupOption, this.viewManager));
        CollisionGroup collisionGroup = new CollisionGroup(collisionGroupOption, this, gLCollisionGroup.getId());
        add(gLCollisionGroup.getId(), collisionGroup, gLCollisionGroup);
        this.f23699i.put(gLCollisionGroup.getId(), new ArrayList());
        return collisionGroup;
    }

    public CollisionMarker addCollisionOverlay(String str, CollisionMarkerOption collisionMarkerOption) {
        GLCollisionGroup c = m16839c(str);
        List list = this.f23699i.get(str);
        if (c == null || list == null) {
            return null;
        }
        GLCollisionMarker gLCollisionMarker = new GLCollisionMarker(this.viewManager, GLCollisionMarkerOptionAdapter.GL_COLLISION_MARKER_OPTION_ADAPTER.get(collisionMarkerOption, this.viewManager));
        gLCollisionMarker.setUpdateRealTime(true);
        CollisionMarker collisionMarker = new CollisionMarker(collisionMarkerOption, this, this.f23698h, gLCollisionMarker.getId(), c.getId());
        c.addView(gLCollisionMarker);
        this.f23698h.add(gLCollisionMarker.getId(), collisionMarker, gLCollisionMarker);
        list.add(gLCollisionMarker.getId());
        return collisionMarker;
    }

    public CollisionStub addVirtualCollsionStub(String str, CollisionStubOption collisionStubOption) {
        GLCollisionGroup c = m16839c(str);
        List list = this.f23699i.get(str);
        if (c == null || list == null) {
            return null;
        }
        GLCollisionStub gLCollisionStub = new GLCollisionStub(this.viewManager, GLCollisionStubOptionAdapter.GL_COLLISION_STUB_OPTION_ADAPTER.get(collisionStubOption, this.viewManager));
        CollisionStub collisionStub = new CollisionStub(collisionStubOption, this, gLCollisionStub.getId(), c.getId());
        c.addView(gLCollisionStub);
        list.add(gLCollisionStub.getId());
        this.f23761a.put(gLCollisionStub.getId(), new Pair(collisionStub, gLCollisionStub));
        return collisionStub;
    }

    public void removeCollisionOverlay(String str, String str2) {
        GLCollisionGroup c = m16839c(str);
        List list = this.f23699i.get(str);
        if (c != null && list != null) {
            Pair<?, GLOverlayView> a = this.f23698h.mo69649a(str2);
            if (a != null) {
                remove(str2);
                c.removeView((GLOverlayView) a.second);
            }
            list.remove(str2);
        }
    }

    public void updateCollisionMarkerPosition(String str, String str2, LatLng latLng) {
        if (m16839c(str) != null) {
            this.f23698h.setPosition(str2, latLng);
        }
    }

    public void updateCollisionMarkerOption(String str, String str2, CollisionMarkerOption collisionMarkerOption) {
        if (m16839c(str) != null) {
            this.f23698h.setMarkerOptions(str2, collisionMarkerOption);
        }
    }

    public void updateCollisionOverlay(String str, String str2, CollisionMarkerOption collisionMarkerOption) {
        if (m16839c(str) != null) {
            this.f23698h.setMarkerOptions(str2, collisionMarkerOption);
        }
    }

    public void clearCollisionOverlay(String str) {
        GLCollisionGroup c = m16839c(str);
        if (c != null) {
            c.clearView();
            m16836b(str);
        }
    }

    public void requestCollision(String str) {
        GLCollisionGroup c = m16839c(str);
        if (c != null) {
            c.checkCollision();
        }
    }

    public void clearGroup() {
        for (Map.Entry entry : this.f23761a.entrySet()) {
            if (((Pair) entry.getValue()).second instanceof GLCollisionGroup) {
                removeCollisionGroup(((GLCollisionGroup) ((Pair) entry.getValue()).second).getId());
            }
        }
    }

    public void removeCollisionGroup(String str) {
        m16836b(str);
        remove(str);
        this.f23699i.remove(str);
    }

    public void setCollisonGroupPadding(String str, Rect rect) {
        GLCollisionGroup c = m16839c(str);
        if (c != null) {
            c.setPadding(rect);
        }
    }

    public void setGroupVisible(String str, boolean z) {
        GLCollisionGroup c = m16839c(str);
        if (c != null) {
            c.setVisible(z);
        }
    }

    public void setVisible(String str, String str2, boolean z) {
        if (m16839c(str) != null) {
            this.f23698h.setVisible(str2, z);
        }
    }

    public int getCurShowTexture(String str, String str2) {
        GLCollisionMarker a = m16831a(str, str2);
        if (a != null) {
            return a.getCurShowTextureIndex();
        }
        return -1;
    }

    public boolean isVisible(String str, String str2) {
        GLCollisionMarker a = m16831a(str, str2);
        if (a != null) {
            return a.isTrueVisible();
        }
        return false;
    }

    public void addRoute4Collision(String str, List<LatLng> list) {
        GLCollisionGroup c = m16839c(str);
        if (c != null) {
            c.addRoute4Collision(list);
        }
    }

    public void clearRoute4Collision(String str) {
        GLCollisionGroup c = m16839c(str);
        if (c != null) {
            c.clearRoute4Collision();
        }
    }

    /* renamed from: b */
    private void m16836b(String str) {
        List<String> list = this.f23699i.get(str);
        if (list != null && list.size() > 0) {
            for (String remove : list) {
                remove(remove);
            }
        }
    }

    /* renamed from: c */
    private GLCollisionGroup m16839c(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.second instanceof GLCollisionGroup)) {
            return null;
        }
        return (GLCollisionGroup) a.second;
    }

    /* renamed from: a */
    private GLCollisionMarker m16831a(String str, String str2) {
        Pair<?, GLOverlayView> a;
        if (m16839c(str) == null || (a = mo69649a(str2)) == null || !(a.second instanceof GLCollisionMarker)) {
            return null;
        }
        return (GLCollisionMarker) a.second;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16832a() {
        m16834b();
    }

    /* renamed from: b */
    private void m16834b() {
        this.f23694d.removeCallbacks(this.f23702l);
        this.f23694d.postDelayed(this.f23702l, 300);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m16840c() {
        for (Map.Entry entry : this.f23761a.entrySet()) {
            if (((Pair) entry.getValue()).second instanceof GLCollisionGroup) {
                ((GLCollisionGroup) ((Pair) entry.getValue()).second).checkCollision();
            }
        }
    }
}
