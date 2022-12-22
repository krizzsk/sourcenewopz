package com.didi.flutter.nacho.p114ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.flutter.nacho.Default;
import com.didi.flutter.nacho.Nacho;
import com.didi.flutter.nacho.NachoPlugin;
import com.didi.flutter.nacho.p114ui.blur.BlurDialogEngine;
import com.didi.flutter.nacho2.p115v2.NachoLifecycleManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;
import p242io.flutter.embedding.android.FlutterFragment;
import p242io.flutter.embedding.engine.FlutterEngine;
import p242io.flutter.embedding.engine.FlutterEngineCache;

/* renamed from: com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment */
public class FlutterBottomSheetDialogFragment extends BottomSheetDialogFragment {

    /* renamed from: a */
    private BlurDialogEngine f21104a;

    /* renamed from: b */
    private FlutterFragment f21105b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f21106c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BottomSheetBehavior<FrameLayout> f21107d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FlutterBottomSheetDialogFragmentBuilder f21108e;

    /* renamed from: f */
    private FlutterEngine f21109f;

    /* renamed from: g */
    private int f21110g = 0;

    /* renamed from: h */
    private final String f21111h = (SystemClock.uptimeMillis() + "@" + Integer.toHexString(hashCode()));

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        int screenHeight = UIHelper.getScreenHeight(context);
        if (screenHeight > 0) {
            if (this.f21108e.height > 0) {
                this.f21110g = screenHeight - this.f21108e.height;
            } else if (this.f21108e.heightRatio <= 0.0f || this.f21108e.heightRatio >= 1.0f) {
                this.f21110g = 20;
            } else {
                this.f21110g = (int) (((float) screenHeight) * (1.0f - this.f21108e.heightRatio));
            }
        }
        if (this.f21108e.withNewEngine) {
            this.f21109f = Nacho.getInstance().getEngine(this.f21111h);
            this.f21105b = FlutterFragment.withCachedEngine(this.f21111h).destroyEngineWithFragment(true).build();
        } else {
            this.f21105b = FlutterFragment.withCachedEngine(Nacho.getInstance().cachedEngineId()).destroyEngineWithFragment(false).build();
        }
        m15540c();
        BlurDialogEngine blurDialogEngine = this.f21104a;
        if (blurDialogEngine != null) {
            blurDialogEngine.onAttach(m15538b());
        }
    }

    public void onDestroy() {
        super.onDestroy();
        BlurDialogEngine blurDialogEngine = this.f21104a;
        if (blurDialogEngine != null) {
            blurDialogEngine.onDetach();
        }
        NachoPlugin a = m15534a();
        a.registerUiUpdateListener((UIUpdateListener) null);
        a.sendLifecycleEvent(this.f21111h, NachoLifecycleManager.LIFECYCLE_ON_DESTROY, Nacho.getInstance().cachedEngineId(), (Map<String, String>) null, (Map<String, String>) null);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        Window window = onCreateDialog.getWindow();
        if (window != null) {
            if (this.f21108e.blur) {
                window.setDimAmount(0.0f);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (onCreateDialog instanceof BottomSheetDialog) {
            BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) onCreateDialog;
            bottomSheetDialog.setCanceledOnTouchOutside(this.f21108e.canceledOnTouchOutsideSet);
            BottomSheetBehavior<FrameLayout> behavior = bottomSheetDialog.getBehavior();
            this.f21107d = behavior;
            behavior.setHalfExpandedRatio(1.0E-7f);
            this.f21107d.setSkipCollapsed(true);
            this.f21107d.setPeekHeight(-1);
            this.f21107d.setFitToContents(false);
            this.f21107d.setState(5);
            this.f21107d.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                NachoPlugin nachoPlugin = FlutterBottomSheetDialogFragment.this.m15534a();

                public void onSlide(View view, float f) {
                }

                public void onStateChanged(View view, int i) {
                    if (!this.nachoPlugin.isNativeProcessGesture() && i == 1) {
                        FlutterBottomSheetDialogFragment.this.f21107d.setState(FlutterBottomSheetDialogFragment.this.f21106c);
                    }
                    int state = FlutterBottomSheetDialogFragment.this.f21107d.getState();
                    if (state == 6 || state == 4) {
                        FlutterBottomSheetDialogFragment.this.f21107d.setState(5);
                    }
                    if (state != 1 && state != 2) {
                        int unused = FlutterBottomSheetDialogFragment.this.f21106c = state;
                    }
                }
            });
        }
        return onCreateDialog;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public NachoPlugin m15534a() {
        Nacho instance = Nacho.getInstance();
        FlutterEngine flutterEngine = this.f21109f;
        if (flutterEngine == null) {
            flutterEngine = Nacho.getInstance().getEengine();
        }
        return instance.getNachoPlugin(flutterEngine);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.f21108e.blur) {
            BlurDialogEngine blurDialogEngine = new BlurDialogEngine(m15538b());
            this.f21104a = blurDialogEngine;
            blurDialogEngine.setBlurRadius(8);
            this.f21104a.setDownScaleFactor(8.0f);
            this.f21104a.debug(true);
            this.f21104a.setBlurActionBar(false);
            this.f21104a.setUseRenderScript(false);
        }
    }

    /* renamed from: b */
    private Activity m15538b() {
        return getActivity() != null ? getActivity() : Nacho.getInstance().getTopActivity();
    }

    public void onStart() {
        super.onStart();
        BlurDialogEngine blurDialogEngine = this.f21104a;
        if (blurDialogEngine != null) {
            blurDialogEngine.onResume(false);
        }
        this.f21106c = this.f21107d.getState();
        View view = (View) getView().getParent();
        ColorDrawable colorDrawable = new ColorDrawable(0);
        view.setBackground(colorDrawable);
        view.post(new Runnable() {
            public void run() {
                FlutterBottomSheetDialogFragment.this.f21107d.setState(3);
            }
        });
        ((View) view.getParent()).setBackground(colorDrawable);
    }

    public void onStop() {
        super.onStop();
        BlurDialogEngine blurDialogEngine = this.f21104a;
        if (blurDialogEngine != null) {
            blurDialogEngine.onDismiss();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog, viewGroup, false);
        inflate.setPadding(0, this.f21110g, 0, 0);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (FlutterBottomSheetDialogFragment.this.f21108e.cancelable && FlutterBottomSheetDialogFragment.this.f21108e.canceledOnTouchOutsideSet) {
                    FlutterBottomSheetDialogFragment.this.dismissAllowingStateLoss();
                }
            }
        });
        getChildFragmentManager().beginTransaction().add((int) R.id.content, (Fragment) this.f21105b).commit();
        return inflate;
    }

    /* renamed from: c */
    private void m15540c() {
        HashMap hashMap = new HashMap();
        hashMap.put("initial_route", this.f21108e.initialRoute);
        Nacho instance = Nacho.getInstance();
        FlutterEngine flutterEngine = this.f21109f;
        if (flutterEngine == null) {
            flutterEngine = Nacho.getInstance().getEengine();
        }
        instance.getNachoPlugin(flutterEngine).sendLifecycleEvent(this.f21111h, NachoLifecycleManager.LIFECYCLE_ON_CREATE, Nacho.getInstance().cachedEngineId(), hashMap, this.f21108e.params);
    }

    public void onDestroyView() {
        FlutterEngineCache.getInstance().remove(this.f21111h);
        getChildFragmentManager().beginTransaction().remove(this.f21105b).commitAllowingStateLoss();
        super.onDestroyView();
    }

    public static FlutterBottomSheetDialogFragmentBuilder Builder() {
        return new FlutterBottomSheetDialogFragmentBuilder();
    }

    public void show() {
        show(Nacho.getInstance().getTopActivity());
    }

    public void show(Context context) {
        if (context instanceof FragmentActivity) {
            show(((FragmentActivity) context).getSupportFragmentManager(), Default.TAG_BOTTOM_DIALOG);
        }
    }

    /* renamed from: com.didi.flutter.nacho.ui.FlutterBottomSheetDialogFragment$FlutterBottomSheetDialogFragmentBuilder */
    public static class FlutterBottomSheetDialogFragmentBuilder {
        /* access modifiers changed from: private */
        public boolean blur = false;
        /* access modifiers changed from: private */
        public boolean cancelable = true;
        /* access modifiers changed from: private */
        public boolean canceledOnTouchOutsideSet = true;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        public float heightRatio;
        /* access modifiers changed from: private */
        public String initialRoute;
        /* access modifiers changed from: private */
        public HashMap params;
        /* access modifiers changed from: private */
        public boolean withNewEngine;

        public void setCanceledOnTouchOutsideSet(boolean z) {
            this.canceledOnTouchOutsideSet = z;
        }

        public void setCancelable(boolean z) {
            this.cancelable = z;
        }

        public FlutterBottomSheetDialogFragment build() {
            FlutterBottomSheetDialogFragment flutterBottomSheetDialogFragment = new FlutterBottomSheetDialogFragment();
            FlutterBottomSheetDialogFragmentBuilder unused = flutterBottomSheetDialogFragment.f21108e = this;
            flutterBottomSheetDialogFragment.setCancelable(this.cancelable);
            return flutterBottomSheetDialogFragment;
        }

        public FlutterBottomSheetDialogFragmentBuilder withNewEngine() {
            this.withNewEngine = true;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder initialRoute(String str) {
            this.initialRoute = str;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder height(int i) {
            this.height = i;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder heightRatio(float f) {
            this.heightRatio = f;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder params(HashMap hashMap) {
            this.params = hashMap;
            return this;
        }

        public FlutterBottomSheetDialogFragmentBuilder blur(boolean z) {
            this.blur = z;
            return this;
        }
    }
}
