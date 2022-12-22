package com.didi.global.loading;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.didi.global.loading.ILoadingRender;
import com.didi.global.loading.render.GradientLoadingRender;
import com.didi.global.loading.render.LottieLoadingRender;
import com.didi.global.loading.render.ProgressBarLoadingRender;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Loading {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Loading f22639a = new Loading();

    /* renamed from: b */
    private Map<LoadingRenderType, Class<? extends ILoadingRender>> f22640b = new HashMap();

    /* renamed from: c */
    private Map<LoadingRenderType, Bundle> f22641c = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Map<View, ViewRecord> f22642d = new HashMap();

    static {
        m16316b();
    }

    private Loading() {
    }

    static class ViewRecord {
        LoadingConfig mConfig;
        ILoadingRender mRender;

        ViewRecord() {
        }
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
        return make(context, view, LoadingConfig.create().setLoadingGravity(i).setRenderType(loadingRenderType).setWithMaskLayer(z).setRenderParams(bundle).build());
    }

    public static Loading make(Context context, View view, LoadingConfig loadingConfig) {
        LoadingRenderType renderType = loadingConfig.getRenderType();
        Bundle renderParams = loadingConfig.getRenderParams();
        int loadingGravity = loadingConfig.getLoadingGravity();
        if (loadingGravity == 48 || loadingGravity == 80) {
            if (renderParams == null) {
                renderParams = new Bundle();
            }
            renderParams.putInt("Loading::Gravity", loadingGravity);
        }
        ViewRecord remove = f22639a.f22642d.remove(view);
        if (!(remove == null || remove.mRender == null)) {
            remove.mRender.stop();
        }
        ViewRecord viewRecord = new ViewRecord();
        viewRecord.mRender = f22639a.m16311a(context, renderType, renderParams);
        viewRecord.mConfig = loadingConfig;
        f22639a.f22642d.put(view, viewRecord);
        return f22639a;
    }

    public void show() {
        for (Map.Entry<View, ViewRecord> key : f22639a.f22642d.entrySet()) {
            show((View) key.getKey());
        }
    }

    public static void show(final View view) {
        if (view != null && view.getParent() != null) {
            Object tag = view.getTag(R.id.id_fallback_render_runner);
            if (tag instanceof Runnable) {
                view.removeCallbacks((Runnable) tag);
            }
            C86741 r1 = new Runnable() {
                public void run() {
                    ViewRecord viewRecord;
                    if (view.getParent() != null && (viewRecord = (ViewRecord) Loading.f22639a.f22642d.get(view)) != null && viewRecord.mConfig != null) {
                        Loading.m16317b(view, viewRecord.mRender, viewRecord.mConfig.isWithMaskLayer());
                    }
                }
            };
            ViewRecord viewRecord = f22639a.f22642d.get(view);
            if (viewRecord != null && viewRecord.mConfig != null) {
                view.setTag(R.id.id_fallback_render_runner, r1);
                view.postDelayed(r1, viewRecord.mConfig.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m16317b(final View view, ILoadingRender iLoadingRender, boolean z) {
        if (z) {
            final ViewGroup a = f22639a.m16310a(view);
            final InterceptableDialog interceptableDialog = new InterceptableDialog(view.getContext());
            iLoadingRender.layoutRender(view, a);
            iLoadingRender.addCallback(new ILoadingRender.SimpleCallback() {
                public void onStart() {
                    super.onStart();
                    ViewGroup viewGroup = a;
                    if (viewGroup != null) {
                        viewGroup.setVisibility(0);
                    }
                    Context context = view.getContext();
                    if ((context instanceof Activity) && !((Activity) context).isFinishing() && Looper.myLooper() == Looper.getMainLooper()) {
                        SystemUtils.showDialog(interceptableDialog);
                        SystemUtils.log(3, "zl-loading", "mask dialog show on fallback " + view, (Throwable) null, "com.didi.global.loading.Loading$2", 274);
                    }
                }

                public void onStop() {
                    super.onStop();
                    ViewGroup viewGroup = a;
                    if (viewGroup != null) {
                        viewGroup.setVisibility(8);
                    }
                    Context context = view.getContext();
                    if (context instanceof Activity) {
                        Activity activity = (Activity) context;
                        if (!activity.isFinishing() && Build.VERSION.SDK_INT >= 17 && !activity.isDestroyed()) {
                            interceptableDialog.dismiss();
                        }
                    }
                    SystemUtils.log(3, "zl-loading", "mask dialog hide on fallback " + view, (Throwable) null, "com.didi.global.loading.Loading$2", 292);
                }
            });
        } else {
            iLoadingRender.layoutRender(view, (ViewGroup) null);
        }
        iLoadingRender.start();
        Log.d("zl-loading", "render[" + iLoadingRender + "] start on fallback " + view);
    }

    /* renamed from: a */
    private ViewGroup m16310a(View view) {
        ViewGroup viewGroup;
        try {
            viewGroup = m16315b(view);
        } catch (Exception e) {
            e.printStackTrace();
            viewGroup = null;
        }
        if (viewGroup == null) {
            return null;
        }
        ViewRecord viewRecord = f22639a.f22642d.get(view);
        int i = LoadingConfig.DEFAULT_MASK_LAYER_BACKGROUND_COLOR;
        if (!(viewRecord == null || viewRecord.mConfig == null)) {
            i = viewRecord.mConfig.getMaskBackgroundColor();
        }
        InterceptableFrameLayer interceptableFrameLayer = (InterceptableFrameLayer) viewGroup.findViewWithTag("progress_mask_layer");
        if (interceptableFrameLayer == null) {
            interceptableFrameLayer = new InterceptableFrameLayer(viewGroup.getContext());
            interceptableFrameLayer.setTag("progress_mask_layer");
            interceptableFrameLayer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            interceptableFrameLayer.setInterceptable(true);
            viewGroup.addView(interceptableFrameLayer);
        } else {
            interceptableFrameLayer.setInterceptable(true);
        }
        interceptableFrameLayer.setBackgroundColor(i);
        return interceptableFrameLayer;
    }

    /* renamed from: b */
    private ViewGroup m16315b(View view) throws IllegalArgumentException {
        do {
            if ((view instanceof FrameLayout) && view.getId() == 16908290) {
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
        throw new IllegalArgumentException("ContentView(android.R.id.content) not found!");
    }

    public static void hide(View view) {
        ViewRecord remove;
        if (view != null && (remove = f22639a.f22642d.remove(view)) != null && remove.mRender != null) {
            remove.mRender.stop();
            Log.d("zl-loading", "render[" + remove.mRender + "] stop on fallback " + view);
        }
    }

    public static void hide() {
        Iterator<Map.Entry<View, ViewRecord>> it = f22639a.f22642d.entrySet().iterator();
        while (it.hasNext()) {
            View view = (View) it.next().getKey();
            ViewRecord viewRecord = f22639a.f22642d.get(view);
            if (!(viewRecord == null || viewRecord.mRender == null)) {
                viewRecord.mRender.stop();
                it.remove();
                Log.d("zl-loading", "render[" + viewRecord.mRender + "] stop on fallback " + view);
            }
        }
    }

    public static boolean isShowing(View view) {
        ViewRecord viewRecord = f22639a.f22642d.get(view);
        if (viewRecord == null || viewRecord.mRender == null) {
            return false;
        }
        return viewRecord.mRender.isRunning();
    }

    public static boolean isShowing() {
        for (Map.Entry<View, ViewRecord> value : f22639a.f22642d.entrySet()) {
            ILoadingRender iLoadingRender = ((ViewRecord) value.getValue()).mRender;
            if (iLoadingRender != null && iLoadingRender.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public static void configRender(LoadingRenderType loadingRenderType, Class<? extends ILoadingRender> cls, Bundle bundle) {
        f22639a.f22640b.put(loadingRenderType, cls);
        if (bundle != null) {
            Bundle bundle2 = f22639a.f22641c.get(loadingRenderType);
            if (bundle2 != null) {
                bundle2.putAll(bundle);
            } else {
                f22639a.f22641c.put(loadingRenderType, bundle);
            }
        }
    }

    /* renamed from: a */
    private ILoadingRender m16311a(Context context, LoadingRenderType loadingRenderType, Bundle bundle) {
        Class cls = this.f22640b.get(loadingRenderType);
        if (cls != null) {
            ILoadingRender iLoadingRender = null;
            try {
                ILoadingRender iLoadingRender2 = (ILoadingRender) cls.newInstance();
                try {
                    Bundle bundle2 = this.f22641c.get(loadingRenderType);
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

    /* renamed from: b */
    private static void m16316b() {
        Bundle bundle = new Bundle();
        bundle.putInt(ProgressBarLoadingRender.kIndeterminateDrawableId, R.drawable.progress_indeterminate_horizontal_holo);
        bundle.putInt("Loading::Interpolator::Id", 17563659);
        bundle.putInt("Loading::Duration", 1200);
        configRender(LoadingRenderType.PROGRESS, ProgressBarLoadingRender.class, bundle);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("Loading::Gradient::Head::Image::ID", R.drawable.img_loading_head);
        bundle2.putInt("Loading::Gradient::Body::Image::ID", R.drawable.img_loading_body);
        configRender(LoadingRenderType.ANIMATION, GradientLoadingRender.class, bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putString("Loading::Animation::Lottie::Asset::File::Name", "loading.json");
        configRender(LoadingRenderType.LOTTIE, LottieLoadingRender.class, bundle3);
    }

    class InterceptableFrameLayer extends FrameLayout {
        private boolean isInterceptEnable = false;

        public InterceptableFrameLayer(Context context) {
            super(context);
        }

        /* access modifiers changed from: package-private */
        public void setInterceptable(boolean z) {
            this.isInterceptEnable = z;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            if (this.isInterceptEnable) {
                return true;
            }
            return super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (this.isInterceptEnable) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }

        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i != 4 || !this.isInterceptEnable) {
                return super.onKeyDown(i, keyEvent);
            }
            return true;
        }

        public boolean dispatchKeyEventPreIme(KeyEvent keyEvent) {
            if (this.isInterceptEnable) {
                return true;
            }
            return super.dispatchKeyEventPreIme(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            if (this.isInterceptEnable) {
                return true;
            }
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
    }

    static class InterceptableDialog extends Dialog {
        InterceptableDialog(Context context) {
            super(context, R.style.Transparent);
            setCancelable(false);
            setCanceledOnTouchOutside(false);
            getWindow().setDimAmount(0.0f);
        }
    }
}
