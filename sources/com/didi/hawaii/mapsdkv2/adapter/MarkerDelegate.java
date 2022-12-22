package com.didi.hawaii.mapsdkv2.adapter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import com.didi.hawaii.mapsdkv2.adapter.animation.GLViewAnimationFactory;
import com.didi.hawaii.mapsdkv2.adapter.option.GLCollisionMarkerOptionAdapter;
import com.didi.hawaii.mapsdkv2.adapter.option.GLMarkerOptionAdapter;
import com.didi.hawaii.mapsdkv2.common.DataUtil;
import com.didi.hawaii.mapsdkv2.core.GLAndroidView;
import com.didi.hawaii.mapsdkv2.core.GLOverlayView;
import com.didi.hawaii.mapsdkv2.core.GLView;
import com.didi.hawaii.mapsdkv2.core.GLViewManager;
import com.didi.hawaii.mapsdkv2.core.IGLInfoWindow;
import com.didi.hawaii.mapsdkv2.core.Texture;
import com.didi.hawaii.mapsdkv2.core.overlay.GLAndroidInfoWindow;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarker;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarkerInfo;
import com.didi.hawaii.mapsdkv2.core.overlay.GLMarkerInfoWindow;
import com.didi.map.alpha.maps.internal.IMarkerDelegate;
import com.didi.map.alpha.maps.internal.MarkerControl;
import com.didi.map.common.accessibility.MapAccessibilityEventSource;
import com.didi.map.outer.map.DMarker;
import com.didi.map.outer.map.DiMapInterface;
import com.didi.map.outer.map.DidiMap;
import com.didi.map.outer.map.InfoWindowAnimationManager;
import com.didi.map.outer.map.MapView;
import com.didi.map.outer.model.BaseMarkerOption;
import com.didi.map.outer.model.BitmapDescriptor;
import com.didi.map.outer.model.CollisionMarker;
import com.didi.map.outer.model.CollisionMarkerOption;
import com.didi.map.outer.model.LatLng;
import com.didi.map.outer.model.LatLngBounds;
import com.didi.map.outer.model.Marker;
import com.didi.map.outer.model.MarkerInfoWindowOption;
import com.didi.map.outer.model.MarkerOptions;
import com.didi.map.outer.model.animation.Animation;
import com.didi.map.outer.model.animation.AnimationSet;
import com.didi.map.outer.model.animation.TranslateAnimation;
import com.taxis99.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MarkerDelegate<T extends DMarker> extends C9003b implements IMarkerDelegate<T> {

    /* renamed from: b */
    private static final GLMarkerOptionAdapter f23715b = new GLMarkerOptionAdapter();

    /* renamed from: c */
    private Map<String, Animation.AnimationListener> f23716c = new HashMap();

    /* renamed from: d */
    private final C9004c f23717d;

    /* renamed from: e */
    private final C9002a f23718e;

    /* renamed from: f */
    private MapAccessibilityEventSource f23719f;

    /* renamed from: g */
    private final MarkerViewDelegate f23720g;

    /* renamed from: h */
    private volatile boolean f23721h = true;

    public void clearMarkers() {
    }

    public Point getFixingPoint(String str) {
        return null;
    }

    public InfoWindowAnimationManager getInfoWindowAnimationManager() {
        return null;
    }

    public DidiMap.OnMarkerClickListener getOnClickListener(String str) {
        return null;
    }

    public void setBitmap(String str, Bitmap bitmap) {
    }

    public void setDraggable(String str, boolean z) {
    }

    public void setNaviState(String str, boolean z, boolean z2) {
    }

    public void setOnTapMapInfoWindowHidden(String str, boolean z) {
    }

    public void setPositionNotUpdate(String str, LatLng latLng) {
    }

    public void setRotateAngleNotUpdate(String str, float f) {
    }

    public void setSnippet(String str, String str2) {
    }

    public void setTitle(String str, String str2) {
    }

    public MarkerDelegate(GLViewManager gLViewManager, Map<String, Pair<?, GLOverlayView>> map, MapView mapView, MarkerViewDelegate markerViewDelegate) {
        super(gLViewManager, map);
        this.f23717d = new C9004c(mapView);
        this.f23718e = new C9002a(this.context);
        this.f23720g = markerViewDelegate;
    }

    public Marker addMarker(MarkerOptions markerOptions, MarkerControl markerControl) {
        GLMarkerInfo gLMarkerInfo = new GLMarkerInfo(this.viewManager, f23715b.get(markerOptions, this.viewManager));
        gLMarkerInfo.setScreenBoundUpdateRealTime(true);
        Marker marker = new Marker(markerOptions, markerControl, gLMarkerInfo.getId());
        add(marker.getId(), marker, gLMarkerInfo);
        return marker;
    }

    public void removeMarker(String str) {
        if (this.f23719f != null) {
            this.f23719f.removeMarkerEvent(m16863c(str));
        }
        remove(str);
        this.f23716c.remove(str);
    }

    /* renamed from: b */
    private GLMarkerInfo m16861b(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.second instanceof GLMarkerInfo)) {
            return null;
        }
        return (GLMarkerInfo) a.second;
    }

    /* renamed from: c */
    private T m16863c(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.first instanceof DMarker)) {
            return null;
        }
        return (DMarker) a.first;
    }

    public void setAnchor(String str, float f, float f2) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setAnchor(f, f2);
        }
    }

    public void setIcon(String str, BitmapDescriptor bitmapDescriptor) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setTexture(Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmapDescriptor.getBitmap(this.viewManager.getMapContext().getAndroidContext())));
        }
    }

    public void setPosition(String str, LatLng latLng) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setPosition(latLng);
        }
    }

    public void setMarkerInfoOption(String str, MarkerInfoWindowOption markerInfoWindowOption) {
        GLMarkerInfo b = m16861b(str);
        if (b != null && markerInfoWindowOption != null) {
            b.setBestViewInclude(markerInfoWindowOption.bestViewInclude);
            b.setInfoWindowZindex(markerInfoWindowOption.infoWindowZindex);
        }
    }

    public LatLng getPosition(String str) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            return b.getPosition();
        }
        return null;
    }

    public void setVisible(String str, boolean z) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setVisible(z);
        }
    }

    public void setInfoWindowUnique(boolean z) {
        this.f23721h = z;
    }

    public boolean showInfoWindow(String str) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.first instanceof DMarker) || !(a.second instanceof GLMarkerInfo) || !((DMarker) a.first).isInfoWindowEnable() || a.second == null) {
            return false;
        }
        GLMarkerInfo gLMarkerInfo = (GLMarkerInfo) a.second;
        if (this.f23721h) {
            m16858a(gLMarkerInfo);
        }
        m16857a(gLMarkerInfo, (DMarker) a.first, 1);
        gLMarkerInfo.showInfoWindow(true);
        return true;
    }

    public boolean showInfoWindowWithGravity(String str, int i) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.first instanceof DMarker) || !(a.second instanceof GLMarkerInfo) || !((DMarker) a.first).isInfoWindowEnable() || a.second == null) {
            return false;
        }
        GLMarkerInfo gLMarkerInfo = (GLMarkerInfo) a.second;
        if (this.f23721h) {
            m16858a(gLMarkerInfo);
        }
        m16857a(gLMarkerInfo, (DMarker) a.first, i);
        gLMarkerInfo.showInfoWindow(true);
        return true;
    }

    public boolean hideInfoWindow(String str) {
        GLMarkerInfo b = m16861b(str);
        if (b == null) {
            return false;
        }
        b.showInfoWindow(false);
        return true;
    }

    public boolean isInfoWindowShown(String str) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            return b.isInfoWindowShow();
        }
        return false;
    }

    /* renamed from: a */
    private Bitmap m16855a(T t, int i) {
        View view;
        DiMapInterface.IWindowAdapter infoWindowAdapter = t.getInfoWindowAdapter();
        if (infoWindowAdapter == null) {
            infoWindowAdapter = this.f23718e;
            for (View view2 : infoWindowAdapter.getInfoWindow(t)) {
                if (view2 != null) {
                    ((TextView) view2.findViewById(R.id.hawaii_default_infowindow_title)).setText(t.getTitle());
                    ((TextView) view2.findViewById(R.id.hawaii_default_infowindow_snippet)).setText(t.getSnippet());
                }
            }
        }
        if (infoWindowAdapter instanceof DidiMap.MultiPositionInfoWindowAdapter) {
            view = ((DidiMap.MultiPositionInfoWindowAdapter) infoWindowAdapter).getInfoWindow((Marker) t)[i];
        } else if (infoWindowAdapter instanceof DidiMap.CollisionMarkerInfoWindowAdapter) {
            view = ((DidiMap.CollisionMarkerInfoWindowAdapter) infoWindowAdapter).getInfoWindow((CollisionMarker) t)[i];
        } else {
            view = infoWindowAdapter.getInfoWindow(t)[i];
        }
        return this.f23717d.mo69651a(view);
    }

    /* renamed from: a */
    private void m16858a(GLMarkerInfo gLMarkerInfo) {
        GLMarkerInfo gLMarkerInfo2;
        for (Map.Entry value : this.f23761a.entrySet()) {
            Pair pair = (Pair) value.getValue();
            if (pair != null && (pair.first instanceof DMarker) && (pair.second instanceof GLMarkerInfo) && (gLMarkerInfo2 = (GLMarkerInfo) pair.second) != null && !gLMarkerInfo.getId().equals(gLMarkerInfo2.getId())) {
                gLMarkerInfo2.removeInfoWindow();
            }
        }
    }

    /* renamed from: a */
    private IGLInfoWindow m16857a(GLMarkerInfo gLMarkerInfo, T t, int i) {
        Pair<Texture, PointF> c;
        IGLInfoWindow infoWindowView = gLMarkerInfo.getInfoWindowView();
        if (infoWindowView == null) {
            int infoWindowType = t.getInfoWindowType();
            if (infoWindowType == 1) {
                infoWindowView = m16860b(gLMarkerInfo, t, i);
            } else if (infoWindowType == 2) {
                infoWindowView = m16856a(gLMarkerInfo, t);
            }
            if (infoWindowView == null) {
                return null;
            }
            gLMarkerInfo.setInfoWindowView(infoWindowView);
        } else if ((infoWindowView instanceof GLMarkerInfoWindow) && (c = m16862c(gLMarkerInfo, t, i)) != null) {
            GLMarkerInfoWindow gLMarkerInfoWindow = (GLMarkerInfoWindow) infoWindowView;
            gLMarkerInfoWindow.setTexture((Texture) c.first);
            gLMarkerInfoWindow.setAnchor(((PointF) c.second).x, ((PointF) c.second).y);
        }
        return infoWindowView;
    }

    /* renamed from: b */
    private IGLInfoWindow m16860b(GLMarkerInfo gLMarkerInfo, final T t, int i) {
        Pair<Texture, PointF> c = m16862c(gLMarkerInfo, t, i);
        if (c == null) {
            return null;
        }
        GLMarker.Option option = new GLMarker.Option();
        option.setAnchor(((PointF) c.second).x, ((PointF) c.second).y);
        option.setTexture((Texture) c.first);
        option.setAngle(0.0f);
        LatLng position = gLMarkerInfo.getPosition();
        option.setPosition(position.longitude, position.latitude);
        option.setZIndex(Integer.valueOf((int) gLMarkerInfo.getInfoWindowZindex()));
        final GLMarkerInfoWindow gLMarkerInfoWindow = new GLMarkerInfoWindow(this.viewManager, option);
        gLMarkerInfoWindow.setClickable(true);
        gLMarkerInfoWindow.setOnClickListener(new GLView.OnClickListener() {
            public boolean onClick(GLView gLView, LatLng latLng, float f, float f2) {
                int i;
                DiMapInterface.IOnInfoWindowClickListener onInfoWindowClickListener = t.getOnInfoWindowClickListener();
                if (onInfoWindowClickListener != null) {
                    if (onInfoWindowClickListener instanceof DidiMap.OnInfoWindowClickListener) {
                        RectF screenBound = gLMarkerInfoWindow.getScreenBound();
                        DidiMap.OnInfoWindowClickListener onInfoWindowClickListener2 = (DidiMap.OnInfoWindowClickListener) onInfoWindowClickListener;
                        onInfoWindowClickListener2.onInfoWindowClick((Marker) t);
                        int i2 = gLMarkerInfoWindow.getTextureWH()[0];
                        int i3 = gLMarkerInfoWindow.getTextureWH()[1];
                        int i4 = -1;
                        if (screenBound == null) {
                            i = -1;
                        } else {
                            i = (int) (f - screenBound.left);
                        }
                        if (screenBound != null) {
                            i4 = (int) (f2 - screenBound.top);
                        }
                        onInfoWindowClickListener2.onInfoWindowClickLocation(i2, i3, i, i4);
                    } else if (onInfoWindowClickListener instanceof DidiMap.OnCollisionInfoWindowClickListener) {
                        ((DidiMap.OnCollisionInfoWindowClickListener) onInfoWindowClickListener).onInfoWindowClick((CollisionMarker) t);
                    }
                }
                return true;
            }
        });
        return gLMarkerInfoWindow;
    }

    /* renamed from: a */
    private IGLInfoWindow m16856a(GLMarkerInfo gLMarkerInfo, T t) {
        View view;
        DiMapInterface.IWindowAdapter infoWindowAdapter = t.getInfoWindowAdapter();
        if (infoWindowAdapter == null) {
            return null;
        }
        if (infoWindowAdapter instanceof DidiMap.MultiPositionInfoWindowAdapter) {
            view = ((DidiMap.MultiPositionInfoWindowAdapter) infoWindowAdapter).getInfoWindow((Marker) t)[0];
        } else if (infoWindowAdapter instanceof DidiMap.CollisionMarkerInfoWindowAdapter) {
            view = ((DidiMap.CollisionMarkerInfoWindowAdapter) infoWindowAdapter).getInfoWindow((CollisionMarker) t)[0];
        } else {
            view = infoWindowAdapter.getInfoWindow(t)[0];
        }
        if (view == null) {
            return null;
        }
        GLAndroidView.Option option = new GLAndroidView.Option();
        option.view = view;
        Texture texture = gLMarkerInfo.getTexture();
        if (texture == null || texture.getBitmap() == null) {
            option.anchorX = 0.5f;
            option.anchorY = 0.5f;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            option.anchorX = 0.5f;
            option.anchorY = ((((float) texture.getBitmap().getHeight()) * gLMarkerInfo.getAnchorY()) / ((float) view.getHeight())) + 1.0f;
        }
        option.latLng = new LatLng(gLMarkerInfo.getPosition());
        return new GLAndroidInfoWindow(this.viewManager, option, this.f23720g.ensureHostView());
    }

    /* renamed from: c */
    private Pair<Texture, PointF> m16862c(GLMarkerInfo gLMarkerInfo, T t, int i) {
        Bitmap a = m16855a(t, 0);
        if (a == null) {
            return null;
        }
        Texture texture = gLMarkerInfo.getTexture();
        Texture bitmap = Texture.bitmap(this.viewManager.getMapContext().getResources(), a);
        PointF pointF = new PointF(0.5f, 0.5f);
        if (!(texture == null || texture.getBitmap() == null)) {
            if (i == 0) {
                pointF.x = ((((float) texture.getBitmap().getWidth()) * gLMarkerInfo.getAnchorX()) / ((float) bitmap.getBitmap().getWidth())) + 1.0f;
                pointF.y = ((((float) texture.getBitmap().getHeight()) * gLMarkerInfo.getAnchorY()) - (((float) (texture.getBitmap().getHeight() - bitmap.getBitmap().getHeight())) / 2.0f)) / ((float) bitmap.getBitmap().getHeight());
            } else if (i == 2) {
                pointF.x = (((float) (-texture.getBitmap().getWidth())) * gLMarkerInfo.getAnchorX()) / ((float) bitmap.getBitmap().getWidth());
                pointF.y = ((((float) texture.getBitmap().getHeight()) * gLMarkerInfo.getAnchorY()) - (((float) (texture.getBitmap().getHeight() - bitmap.getBitmap().getHeight())) / 2.0f)) / ((float) bitmap.getBitmap().getHeight());
            } else if (i != 3) {
                pointF.x = 0.5f;
                pointF.y = ((((float) texture.getBitmap().getHeight()) * gLMarkerInfo.getAnchorY()) / ((float) bitmap.getBitmap().getHeight())) + 1.0f;
            } else {
                pointF.x = 0.5f;
                pointF.y = (((float) (-texture.getBitmap().getHeight())) * (1.0f - gLMarkerInfo.getAnchorY())) / ((float) bitmap.getBitmap().getHeight());
            }
        }
        return new Pair<>(bitmap, pointF);
    }

    public void setMarkerRotateAngle(String str, float f) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setAngle(f);
        }
    }

    public float getRotateAngle(String str) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            return b.getAngle();
        }
        return 0.0f;
    }

    public void setAnimation(String str, Animation animation) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            if (animation instanceof TranslateAnimation) {
                if (!m16859a(animation, (GLMarker) b)) {
                    return;
                }
            } else if (animation instanceof AnimationSet) {
                for (Animation next : ((AnimationSet) animation).getAnimationList()) {
                    if ((next instanceof TranslateAnimation) && !m16859a(next, (GLMarker) b)) {
                        return;
                    }
                }
            }
            b.setAnimator(GLViewAnimationFactory.convertToAnimator(animation));
        }
    }

    /* renamed from: a */
    private boolean m16859a(Animation animation, GLMarker gLMarker) {
        if (((TranslateAnimation) animation).getLatLngFrom() == null) {
            try {
                Field declaredField = animation.getClass().getDeclaredField("latLngFrom");
                declaredField.setAccessible(true);
                declaredField.set(animation, gLMarker.getPosition());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
                return false;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean startAnimation(String str) {
        GLMarkerInfo b = m16861b(str);
        if (b == null) {
            return false;
        }
        m16864d(str);
        b.startAnimator();
        return false;
    }

    /* renamed from: d */
    private void m16864d(String str) {
        Animator pendingAnimator;
        GLMarkerInfo b = m16861b(str);
        if (b != null && (pendingAnimator = b.getPendingAnimator()) != null) {
            final Animation.AnimationListener animationListener = this.f23716c.get(str);
            pendingAnimator.addListener(new AnimatorListenerAdapter() {
                boolean isCancel = false;

                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    Animation.AnimationListener animationListener = animationListener;
                    if (animationListener != null && !this.isCancel) {
                        animationListener.onAnimationEnd();
                    }
                }

                public void onAnimationCancel(Animator animator) {
                    this.isCancel = true;
                    super.onAnimationCancel(animator);
                }

                public void onAnimationStart(Animator animator) {
                    super.onAnimationStart(animator);
                    Animation.AnimationListener animationListener = animationListener;
                    if (animationListener != null) {
                        animationListener.onAnimationStart();
                    }
                }
            });
        }
    }

    public void setAnimationListener(String str, Animation.AnimationListener animationListener) {
        if (m16861b(str) != null) {
            this.f23716c.put(str, animationListener);
        }
    }

    public void setAlpha(String str, float f) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setAlpha(f);
        }
    }

    public void setScale(String str, PointF pointF) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setScale(pointF);
        }
    }

    public void setOffset(String str, PointF pointF) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setOffset(pointF);
        }
    }

    public void setClickable(String str, boolean z) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setClickable(z);
        }
    }

    public boolean isClickable(String str) {
        GLMarkerInfo b = m16861b(str);
        if (b == null) {
            return false;
        }
        b.isClickable();
        return false;
    }

    public void setFixingPointEnable(String str, boolean z) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setFixEnable(z);
        }
    }

    public boolean isFixingPointEnabled(String str) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            return b.isFixPosition();
        }
        return false;
    }

    public void setFixingPoint(String str, int i, int i2) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setFixPosition(i, i2);
        }
    }

    public void setMarkerOptions(String str, BaseMarkerOption baseMarkerOption) {
        GLMarkerInfo b = m16861b(str);
        if (b == null) {
            return;
        }
        if (baseMarkerOption instanceof MarkerOptions) {
            b.updateOption(f23715b.get((MarkerOptions) baseMarkerOption, this.viewManager));
        } else if (baseMarkerOption instanceof CollisionMarkerOption) {
            b.updateOption(GLCollisionMarkerOptionAdapter.GL_COLLISION_MARKER_OPTION_ADAPTER.get((CollisionMarkerOption) baseMarkerOption, this.viewManager));
        }
    }

    public void setZIndex(String str, float f) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setZIndex((int) f);
        }
    }

    public void setOnClickListener(String str, final DiMapInterface.IOnMarkerClickListener<T> iOnMarkerClickListener) {
        final GLMarkerInfo b = m16861b(str);
        if (b != null) {
            final DMarker c = m16863c(str);
            b.setOnClickListener(new GLView.OnClickListener() {
                public boolean onClick(GLView gLView, LatLng latLng, float f, float f2) {
                    DiMapInterface.IOnMarkerClickListener iOnMarkerClickListener;
                    DMarker dMarker = c;
                    if (dMarker == null || (iOnMarkerClickListener = iOnMarkerClickListener) == null) {
                        return true;
                    }
                    if (iOnMarkerClickListener instanceof DidiMap.OnMarkerClickListener) {
                        ((DidiMap.OnMarkerClickListener) iOnMarkerClickListener).onMarkerClick((Marker) dMarker);
                        return true;
                    } else if (!(iOnMarkerClickListener instanceof DidiMap.OnCollisionMarkerClickListener)) {
                        return true;
                    } else {
                        ((DidiMap.OnCollisionMarkerClickListener) iOnMarkerClickListener).onMarkerClick((CollisionMarker) dMarker);
                        RectF screenBound = b.getScreenBound();
                        ((DidiMap.OnCollisionMarkerClickListener) iOnMarkerClickListener).onMarkerClick((CollisionMarker) c, f - screenBound.left, f2 - screenBound.top);
                        return true;
                    }
                }
            });
        }
    }

    public void setOnVisibleChangeListener(String str, final DidiMap.OnMarkerVisibleChangeListener onMarkerVisibleChangeListener) {
        GLMarkerInfo b = m16861b(str);
        if (b == null) {
            return;
        }
        if (onMarkerVisibleChangeListener == null) {
            b.setOnVisibleChangeListener((GLMarker.OnVisibleChangeListener) null);
        } else {
            b.setOnVisibleChangeListener(new GLMarker.OnVisibleChangeListener() {
                public void onVisibleChange(final boolean z, final long j) {
                    MarkerDelegate.this.viewManager.getMainHandler().post(new Runnable() {
                        public void run() {
                            if (onMarkerVisibleChangeListener != null) {
                                onMarkerVisibleChangeListener.onVisibleChange(z, j);
                            }
                        }
                    });
                }
            });
        }
    }

    public List<LatLng> getBounderPoints(String str) {
        LatLngBounds infoWindowGeoBound;
        ArrayList arrayList = new ArrayList();
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.first instanceof Marker) && (a.second instanceof GLMarkerInfo)) {
            Marker marker = (Marker) a.first;
            GLMarkerInfo gLMarkerInfo = (GLMarkerInfo) a.second;
            if (gLMarkerInfo != null) {
                LatLngBounds geoBound = gLMarkerInfo.getGeoBound();
                if (geoBound != null) {
                    arrayList.add(geoBound.northeast);
                    arrayList.add(geoBound.southwest);
                }
                if (marker.isInfoWindowEnable() && gLMarkerInfo.isInfoWindowShow() && (infoWindowGeoBound = gLMarkerInfo.getInfoWindowGeoBound()) != null) {
                    arrayList.add(infoWindowGeoBound.northeast);
                    arrayList.add(infoWindowGeoBound.southwest);
                }
            }
        }
        return arrayList;
    }

    public Rect getScreenRect(String str) {
        RectF screenBound;
        GLMarkerInfo b = m16861b(str);
        if (b == null || (screenBound = b.getScreenBound()) == null) {
            return null;
        }
        return new Rect((int) screenBound.left, (int) screenBound.top, (int) screenBound.right, (int) screenBound.bottom);
    }

    public RectF getInfoWindowScreenRect(String str) {
        RectF infoWindowScreenRect;
        GLMarkerInfo b = m16861b(str);
        if (b == null || (infoWindowScreenRect = b.getInfoWindowScreenRect()) == null) {
            return null;
        }
        return new RectF((float) ((int) infoWindowScreenRect.left), (float) ((int) infoWindowScreenRect.top), (float) ((int) infoWindowScreenRect.right), (float) ((int) infoWindowScreenRect.bottom));
    }

    public Rect getBound(String str) {
        LatLngBounds geoBound;
        LatLngBounds geoBound2;
        GLMarkerInfo b = m16861b(str);
        if (b == null || (geoBound = b.getGeoBound()) == null) {
            return null;
        }
        Rect rect = DataUtil.toRect(geoBound);
        IGLInfoWindow infoWindowView = b.getInfoWindowView();
        if (!(infoWindowView == null || !infoWindowView.isVisible() || (geoBound2 = infoWindowView.getGeoBound()) == null)) {
            rect.union(DataUtil.toRect(geoBound2));
        }
        return rect;
    }

    public RectF getPixel20Bound(String str, float f) {
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a != null && (a.first instanceof Marker) && (a.second instanceof GLMarkerInfo)) {
            GLMarkerInfo gLMarkerInfo = (GLMarkerInfo) a.second;
            if (((Marker) a.first).isInfoWindowEnable() && gLMarkerInfo.isInfoWindowShow()) {
                return gLMarkerInfo.getPiexBound(f);
            }
        }
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            return b.getPiexBound(f);
        }
        return null;
    }

    public void setGroundIcon(String str, LatLngBounds latLngBounds, BitmapDescriptor bitmapDescriptor) {
        GLMarkerInfo b = m16861b(str);
        if (b != null) {
            b.setGroundIcon(latLngBounds, Texture.bitmap(this.viewManager.getMapContext().getResources(), bitmapDescriptor.getBitmap(this.viewManager.getMapContext().getAndroidContext())));
        }
    }

    public List<LatLng> getInfoWindowBoderPoints(String str) {
        LatLngBounds infoWindowGeoBound;
        Pair<?, GLOverlayView> a = mo69649a(str);
        if (a == null || !(a.first instanceof Marker) || !(a.second instanceof GLMarkerInfo)) {
            return null;
        }
        GLMarkerInfo gLMarkerInfo = (GLMarkerInfo) a.second;
        if (!((Marker) a.first).isInfoWindowEnable() || !gLMarkerInfo.isInfoWindowShow() || (infoWindowGeoBound = gLMarkerInfo.getInfoWindowGeoBound()) == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(infoWindowGeoBound.northeast);
        arrayList.add(infoWindowGeoBound.southwest);
        return arrayList;
    }

    public void onSetTouchableContent(DMarker dMarker) {
        MapAccessibilityEventSource mapAccessibilityEventSource;
        if (dMarker != null && (mapAccessibilityEventSource = this.f23719f) != null) {
            mapAccessibilityEventSource.sendMarkerEvent(dMarker);
        }
    }

    public void setAccessibilityDelegate(MapAccessibilityEventSource mapAccessibilityEventSource) {
        this.f23719f = mapAccessibilityEventSource;
    }
}
