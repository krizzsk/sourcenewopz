package com.didi.soda.customer.widget.loading;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.widget.loading.ILoadingRender;
import com.didi.soda.customer.widget.loading.render.GradientLoadingRender;
import com.didi.soda.customer.widget.loading.render.LottieLoadingRender;
import com.didi.soda.customer.widget.loading.render.ProgressBarLoadingRender;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Loading {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Loading f42079a = new Loading();

    /* renamed from: b */
    private Map<LoadingRenderType, Class<? extends ILoadingRender>> f42080b = new HashMap();

    /* renamed from: c */
    private Map<LoadingRenderType, Bundle> f42081c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map<View, ViewRecord> f42082d = new HashMap();

    static {
        m29686b();
    }

    private Loading() {
    }

    public static Loading make(Context context, View view) {
        return make(context, LoadingRenderType.ANIMATION, (Bundle) null, view, false);
    }

    public static Loading make(Context context, LoadingRenderType loadingRenderType, View view) {
        return make(context, loadingRenderType, (Bundle) null, view, false);
    }

    public static Loading make(Context context, LoadingRenderType loadingRenderType, View view, int i) {
        Bundle bundle = new Bundle();
        if (i == 48 || i == 80) {
            bundle.putInt("Loading::Gravity", i);
        }
        return make(context, loadingRenderType, bundle, view, false);
    }

    public static Loading make(Context context, LoadingRenderType loadingRenderType, Bundle bundle, View view) {
        return make(context, loadingRenderType, bundle, view, false);
    }

    public static Loading make(Context context, LoadingRenderType loadingRenderType, Bundle bundle, View view, int i) {
        return make(context, loadingRenderType, bundle, view, false, i);
    }

    public static Loading make(Context context, LoadingRenderType loadingRenderType, View view, boolean z) {
        return make(context, loadingRenderType, (Bundle) null, view, z);
    }

    public static Loading make(Context context, LoadingRenderType loadingRenderType, View view, boolean z, int i) {
        return make(context, loadingRenderType, (Bundle) null, view, z, i);
    }

    public static Loading make(Context context, LoadingRenderType loadingRenderType, Bundle bundle, View view, boolean z) {
        return make(context, loadingRenderType, bundle, view, z, 80);
    }

    public static Loading make(Context context, LoadingRenderType loadingRenderType, Bundle bundle, View view, boolean z, int i) {
        if (i == 48 || i == 80) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt("Loading::Gravity", i);
        }
        ViewRecord remove = f42079a.f42082d.remove(view);
        if (!(remove == null || remove.mRender == null)) {
            remove.mRender.stop();
        }
        ViewRecord viewRecord = new ViewRecord();
        viewRecord.mRender = f42079a.m29681a(context, loadingRenderType, bundle);
        viewRecord.mUseMaskLayer = z;
        f42079a.f42082d.put(view, viewRecord);
        return f42079a;
    }

    public static void show(final View view) {
        if (view != null && view.getParent() != null) {
            Object tag = view.getTag(R.id.CustomerFallbackRenderRunnerId);
            if (tag instanceof Runnable) {
                view.removeCallbacks((Runnable) tag);
            }
            C138711 r1 = new Runnable() {
                public void run() {
                    ViewRecord viewRecord;
                    if (View.this.getParent() != null && (viewRecord = (ViewRecord) Loading.f42079a.f42082d.get(View.this)) != null) {
                        Loading.m29687b(View.this, viewRecord.mRender, viewRecord.mUseMaskLayer);
                    }
                }
            };
            view.setTag(R.id.CustomerFallbackRenderRunnerId, r1);
            view.postDelayed(r1, 300);
        }
    }

    public static void hide(View view) {
        ViewRecord remove;
        if (view != null && (remove = f42079a.f42082d.remove(view)) != null && remove.mRender != null) {
            remove.mRender.stop();
            LogUtil.m29100d("Loading", "render[" + remove.mRender + "] stop on fallback " + view);
        }
    }

    public static void hide() {
        Iterator<Map.Entry<View, ViewRecord>> it = f42079a.f42082d.entrySet().iterator();
        while (it.hasNext()) {
            View view = (View) it.next().getKey();
            ViewRecord viewRecord = f42079a.f42082d.get(view);
            if (!(viewRecord == null || viewRecord.mRender == null)) {
                viewRecord.mRender.stop();
                it.remove();
                LogUtil.m29100d("Loading", "render[" + viewRecord.mRender + "] stop on fallback " + view);
            }
        }
    }

    public static boolean isShowing(View view) {
        ViewRecord viewRecord = f42079a.f42082d.get(view);
        if (viewRecord == null || viewRecord.mRender == null) {
            return false;
        }
        return viewRecord.mRender.isRunning();
    }

    public static boolean isShowing() {
        for (Map.Entry<View, ViewRecord> value : f42079a.f42082d.entrySet()) {
            ILoadingRender iLoadingRender = ((ViewRecord) value.getValue()).mRender;
            if (iLoadingRender != null && iLoadingRender.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public static void configRender(LoadingRenderType loadingRenderType, Class<? extends ILoadingRender> cls, Bundle bundle) {
        f42079a.f42080b.put(loadingRenderType, cls);
        if (bundle != null) {
            Bundle bundle2 = f42079a.f42081c.get(loadingRenderType);
            if (bundle2 != null) {
                bundle2.putAll(bundle);
            } else {
                f42079a.f42081c.put(loadingRenderType, bundle);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m29687b(View view, ILoadingRender iLoadingRender, boolean z) {
        if (z) {
            final ViewGroup a = f42079a.m29680a(view);
            iLoadingRender.layoutRender(view, a);
            iLoadingRender.addCallback(new ILoadingRender.SimpleCallback() {
                public void onStart() {
                    super.onStart();
                    a.setVisibility(0);
                }

                public void onStop() {
                    super.onStop();
                    a.setVisibility(8);
                }
            });
        } else {
            iLoadingRender.layoutRender(view, (ViewGroup) null);
        }
        iLoadingRender.start();
        LogUtil.m29100d("Loading", "render[" + iLoadingRender + "] start on fallback " + view);
    }

    /* renamed from: b */
    private static void m29686b() {
        Bundle bundle = new Bundle();
        bundle.putInt(ProgressBarLoadingRender.sIndeterminateDrawableId, R.drawable.progress_indeterminate_horizontal_holo);
        bundle.putInt("Loading::Interpolator::Id", 17563659);
        bundle.putInt("Loading::Duration", 1200);
        configRender(LoadingRenderType.PROGRESS, ProgressBarLoadingRender.class, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("Loading::Gradient::Head::Image::ID", R.drawable.img_loading_head);
        bundle2.putInt("Loading::Gradient::Body::Image::ID", R.drawable.img_loading_body);
        configRender(LoadingRenderType.ANIMATION, GradientLoadingRender.class, bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("Loading::Animation::Lottie::Asset::File::Name", "loading.json");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LottieLoadingRender.LoopRangeModel(30, Integer.MAX_VALUE, new int[]{1, Integer.MAX_VALUE}));
        bundle3.putParcelableArrayList("Loading::Animation::Lottie::LoopRanges", arrayList);
        configRender(LoadingRenderType.LOTTIE, LottieLoadingRender.class, bundle3);
    }

    public void show() {
        for (Map.Entry<View, ViewRecord> key : f42079a.f42082d.entrySet()) {
            show((View) key.getKey());
        }
    }

    /* renamed from: a */
    private ViewGroup m29680a(View view) {
        ViewGroup b = m29685b(view);
        InterceptableFrameLayer interceptableFrameLayer = (InterceptableFrameLayer) b.findViewWithTag("CustomerProgressMaskLayer");
        if (interceptableFrameLayer == null) {
            InterceptableFrameLayer interceptableFrameLayer2 = new InterceptableFrameLayer(b.getContext());
            interceptableFrameLayer2.setTag("CustomerProgressMaskLayer");
            interceptableFrameLayer2.setBackgroundColor(218103807);
            interceptableFrameLayer2.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            interceptableFrameLayer2.setInterceptable(true);
            b.addView(interceptableFrameLayer2);
            return interceptableFrameLayer2;
        }
        interceptableFrameLayer.setInterceptable(true);
        return interceptableFrameLayer;
    }

    /* renamed from: b */
    private ViewGroup m29685b(View view) {
        do {
            if ((view instanceof FrameLayout) && view.getId() == R.id.customer_root_container) {
                return (FrameLayout) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
        } while (view != null);
        throw new IllegalArgumentException("view is null or decor content view not found!");
    }

    /* renamed from: a */
    private ILoadingRender m29681a(Context context, LoadingRenderType loadingRenderType, Bundle bundle) {
        Class cls = this.f42080b.get(loadingRenderType);
        if (cls != null) {
            ILoadingRender iLoadingRender = null;
            try {
                ILoadingRender iLoadingRender2 = (ILoadingRender) cls.newInstance();
                try {
                    Bundle bundle2 = this.f42081c.get(loadingRenderType);
                    if (bundle2 == null) {
                        return iLoadingRender2;
                    }
                    Bundle bundle3 = (Bundle) bundle2.clone();
                    if (bundle != null) {
                        bundle3.putAll(bundle);
                    }
                    iLoadingRender2.createRender(context, bundle3);
                    return iLoadingRender2;
                } catch (IllegalAccessException e) {
                    e = e;
                    iLoadingRender = iLoadingRender2;
                    e.printStackTrace();
                    return iLoadingRender;
                } catch (InstantiationException e2) {
                    e = e2;
                    iLoadingRender = iLoadingRender2;
                    e.printStackTrace();
                    return iLoadingRender;
                }
            } catch (IllegalAccessException e3) {
                e = e3;
                e.printStackTrace();
                return iLoadingRender;
            } catch (InstantiationException e4) {
                e = e4;
                e.printStackTrace();
                return iLoadingRender;
            }
        } else {
            throw new IllegalStateException("The RenderType[$renderType] isn't supported! ");
        }
    }

    static class ViewRecord {
        ILoadingRender mRender;
        boolean mUseMaskLayer = false;

        ViewRecord() {
        }
    }

    class InterceptableFrameLayer extends FrameLayout {
        private boolean mIsInterceptEnable = false;

        InterceptableFrameLayer(Context context) {
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.mIsInterceptEnable) {
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
            if (this.mIsInterceptEnable) {
                return true;
            }
            return super.dispatchKeyEventPreIme(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (this.mIsInterceptEnable) {
                return true;
            }
            return super.dispatchKeyShortcutEvent(keyEvent);
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (this.mIsInterceptEnable) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i != 4 || !this.mIsInterceptEnable) {
                return super.onKeyDown(i, keyEvent);
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public void setInterceptable(boolean z) {
            this.mIsInterceptEnable = z;
        }
    }
}
