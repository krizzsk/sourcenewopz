package com.didi.map.global.component.streetview;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.streetview.IStreetViewLoader;
import com.didi.map.global.component.streetview.utils.StreetOmegaUtils;
import com.didi.map.global.component.streetview.widget.RoundImageView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class StreetViewComp {
    public static final String ACTION_CLOSE_BIG_STREET = "action_close_big_street";

    /* renamed from: a */
    private static final String f26194a = "StreetViewComp";

    /* renamed from: b */
    private StreetViewCompParams f26195b;

    /* renamed from: c */
    private View f26196c;

    /* renamed from: d */
    private RoundImageView f26197d;

    /* renamed from: e */
    private Lazy<StreetViewBuilder> f26198e;

    /* renamed from: f */
    private ILoadCallback f26199f;

    public interface ILoadCallback {
        void onFail();

        void onStreetViewInvalid();

        void onSuccess();
    }

    @FunctionalInterface
    public interface Lazy<V> {
        V get();
    }

    public StreetViewComp(StreetViewCompParams streetViewCompParams) {
        this.f26195b = streetViewCompParams;
        m18550a();
        m18551b();
    }

    /* renamed from: a */
    private void m18550a() {
        StreetViewCompParams streetViewCompParams = this.f26195b;
        if (streetViewCompParams == null || streetViewCompParams.getStreetVersion() == null || this.f26195b.getActivity() == null) {
            DLog.m7384d(f26194a, "param || streetVersion || context  must not null", new Object[0]);
            return;
        }
        int i = C96082.f26200x1b7f6d62[this.f26195b.getStreetVersion().ordinal()];
        if (i == 1) {
            View inflate = LayoutInflater.from(this.f26195b.getActivity()).inflate(R.layout.map_comp_layout_streetview_comp_tips_view, (ViewGroup) null);
            this.f26196c = inflate;
            this.f26197d = (RoundImageView) inflate.findViewById(R.id.vTipsImg);
            Drawable drawable = this.f26197d.getResources().getDrawable(R.drawable.map_comp_ic_bubble_arrow);
            drawable.setAutoMirrored(true);
            ((ImageView) this.f26196c.findViewById(R.id.arrow)).setImageDrawable(drawable);
        } else if (i == 2) {
            View inflate2 = LayoutInflater.from(this.f26195b.getActivity()).inflate(R.layout.map_comp_layout_streetview_comp_tips_view, (ViewGroup) null);
            this.f26196c = inflate2;
            RoundImageView roundImageView = (RoundImageView) inflate2.findViewById(R.id.vTipsImg);
            this.f26197d = roundImageView;
            roundImageView.setImageResource(R.drawable.map_street_tip_default_and_pin);
            Drawable drawable2 = this.f26197d.getResources().getDrawable(R.drawable.map_comp_ic_bubble_arrow);
            drawable2.setAutoMirrored(true);
            ((ImageView) this.f26196c.findViewById(R.id.arrow)).setImageDrawable(drawable2);
        } else if (i == 3) {
            View inflate3 = LayoutInflater.from(this.f26195b.getActivity()).inflate(R.layout.map_comp_layout_streetview_comp_minibus_view, (ViewGroup) null);
            this.f26196c = inflate3;
            RoundImageView roundImageView2 = (RoundImageView) inflate3.findViewById(R.id.vTipsImg);
            this.f26197d = roundImageView2;
            roundImageView2.setImageResource(R.drawable.map_street_mini_bus_default);
            if (!TextUtils.isEmpty(this.f26195b.getStreetHintContent())) {
                ((TextView) this.f26196c.findViewById(R.id.tv_content)).setText(this.f26195b.getStreetHintContent());
            }
        }
    }

    /* renamed from: com.didi.map.global.component.streetview.StreetViewComp$2 */
    static /* synthetic */ class C96082 {

        /* renamed from: $SwitchMap$com$didi$map$global$component$streetview$StreetVersion */
        static final /* synthetic */ int[] f26200x1b7f6d62;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.map.global.component.streetview.StreetVersion[] r0 = com.didi.map.global.component.streetview.StreetVersion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f26200x1b7f6d62 = r0
                com.didi.map.global.component.streetview.StreetVersion r1 = com.didi.map.global.component.streetview.StreetVersion.STREET_V1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f26200x1b7f6d62     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.map.global.component.streetview.StreetVersion r1 = com.didi.map.global.component.streetview.StreetVersion.STREET_V2     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f26200x1b7f6d62     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.map.global.component.streetview.StreetVersion r1 = com.didi.map.global.component.streetview.StreetVersion.STREET_V3     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.component.streetview.StreetViewComp.C96082.<clinit>():void");
        }
    }

    /* renamed from: b */
    private void m18551b() {
        StreetViewCompParams streetViewCompParams = this.f26195b;
        if (streetViewCompParams != null && streetViewCompParams.getActivity() != null) {
            this.f26198e = m18549a(this.f26195b.getActivity(), this.f26195b.getStreetVersion());
        }
    }

    /* renamed from: a */
    private Lazy<StreetViewBuilder> m18549a(final Activity activity, final StreetVersion streetVersion) {
        return new Lazy<StreetViewBuilder>() {
            private StreetViewBuilder mBuilder;

            public synchronized StreetViewBuilder get() {
                if (this.mBuilder == null) {
                    this.mBuilder = new StreetViewBuilder(activity, streetVersion);
                }
                return this.mBuilder;
            }
        };
    }

    public void load(ILoadCallback iLoadCallback) {
        this.f26199f = iLoadCallback;
        if (this.f26195b.getActivity() != null && !this.f26195b.getActivity().isDestroyed() && !this.f26195b.getActivity().isFinishing()) {
            this.f26198e.get().load(this.f26195b, this.f26197d, this.f26199f);
        }
    }

    public void show() {
        Lazy<StreetViewBuilder> lazy;
        if (this.f26195b != null && (lazy = this.f26198e) != null && lazy.get() != null) {
            this.f26198e.get().showStreetView(this.f26195b.getOrderId(), this.f26195b.getUid());
        }
    }

    public void hide() {
        Lazy<StreetViewBuilder> lazy = this.f26198e;
        if (lazy != null && lazy.get() != null) {
            this.f26198e.get().hideStreetView();
        }
    }

    public boolean isStreetViewDialogShow() {
        Lazy<StreetViewBuilder> lazy = this.f26198e;
        if (lazy == null || lazy.get() == null) {
            return false;
        }
        return this.f26198e.get().isDialogShow();
    }

    public View getTipsView() {
        return this.f26196c;
    }

    public void onDestroy() {
        Lazy<StreetViewBuilder> lazy = this.f26198e;
        if (lazy != null && lazy.get() != null) {
            this.f26198e.get().onDestroy();
        }
    }

    private static class StreetViewBuilder {
        /* access modifiers changed from: private */
        public Activity mActivity;
        /* access modifiers changed from: private */
        public StreetViewDialog mDialog;
        private IStreetViewLoader mLoader;
        private View mRootView;
        /* access modifiers changed from: private */
        public BroadcastReceiver receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (StreetViewComp.ACTION_CLOSE_BIG_STREET.equals(intent.getAction())) {
                    StreetViewBuilder.this.hideStreetView();
                }
            }
        };
        private StreetVersion streetVersion;

        public StreetViewBuilder(Activity activity, StreetVersion streetVersion2) {
            this.mActivity = activity;
            this.streetVersion = streetVersion2;
            if (streetVersion2 != null) {
                int i = C96082.f26200x1b7f6d62[streetVersion2.ordinal()];
                if (i == 1) {
                    this.mLoader = new StreetViewLoaderImplV1();
                } else if (i == 2) {
                    this.mLoader = new StreetViewLoaderImplV2();
                } else if (i == 3) {
                    this.mLoader = new StreetViewLoaderImplV3();
                }
            }
            this.mRootView = this.mLoader.createView(LayoutInflater.from(activity));
        }

        public void load(StreetViewCompParams streetViewCompParams, ImageView imageView, ILoadCallback iLoadCallback) {
            if (!(StreetVersion.STREET_V2 != this.streetVersion || this.mActivity == null || streetViewCompParams == null)) {
                DLog.m7384d(StreetViewComp.f26194a, "V2 版本，重建loader", new Object[0]);
                IStreetViewLoader iStreetViewLoader = this.mLoader;
                if (iStreetViewLoader != null) {
                    iStreetViewLoader.cancelStreetViewLoad();
                    this.mLoader = null;
                }
                StreetViewLoaderImplV2 streetViewLoaderImplV2 = new StreetViewLoaderImplV2();
                this.mLoader = streetViewLoaderImplV2;
                this.mRootView = streetViewLoaderImplV2.createView(LayoutInflater.from(this.mActivity));
                showStreetView(streetViewCompParams.getOrderId(), streetViewCompParams.getUid());
            }
            IStreetViewLoader iStreetViewLoader2 = this.mLoader;
            if (iStreetViewLoader2 != null) {
                iStreetViewLoader2.load(streetViewCompParams, imageView, iLoadCallback);
            }
        }

        public void showStreetView(final String str, final String str2) {
            Activity activity;
            if (this.mLoader != null && this.streetVersion != null && (activity = this.mActivity) != null && !activity.isFinishing() && !this.mActivity.isDestroyed()) {
                if (this.mRootView.getParent() != null) {
                    ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
                }
                StreetViewDialog streetViewDialog = this.mDialog;
                if (streetViewDialog != null) {
                    streetViewDialog.cancel();
                    this.mDialog = null;
                }
                StreetViewDialog streetViewDialog2 = new StreetViewDialog(this.mActivity);
                this.mDialog = streetViewDialog2;
                streetViewDialog2.setContentView(this.mRootView);
                SystemUtils.showDialog(this.mDialog);
                this.mLoader.setListener(new IStreetViewLoader.OnStreetViewActionListener() {
                    public void hideView() {
                        if (StreetViewBuilder.this.mDialog != null) {
                            StreetViewBuilder.this.mDialog.dismiss();
                        }
                    }

                    public void goFeedback() {
                        if (StreetViewBuilder.this.mActivity != null) {
                            Intent intent = new Intent(StreetViewBuilder.this.mActivity, StreetViewFeedbackActivity.class);
                            intent.putExtra("order_id", str);
                            intent.putExtra("uid", str2);
                            StreetViewBuilder.this.mActivity.startActivity(intent);
                            IntentFilter intentFilter = new IntentFilter();
                            intentFilter.addAction(StreetViewComp.ACTION_CLOSE_BIG_STREET);
                            LocalBroadcastManager.getInstance(StreetViewBuilder.this.mActivity).registerReceiver(StreetViewBuilder.this.receiver, intentFilter);
                            StreetOmegaUtils.onStreetViewToFeedbackPageClick(str);
                        }
                    }
                });
                this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    public void onDismiss(DialogInterface dialogInterface) {
                        if (StreetViewBuilder.this.mActivity != null) {
                            LocalBroadcastManager.getInstance(StreetViewBuilder.this.mActivity).unregisterReceiver(StreetViewBuilder.this.receiver);
                        }
                        StreetViewBuilder.this.destroyLoader();
                    }
                });
            }
        }

        public void hideStreetView() {
            try {
                if (this.mDialog != null) {
                    this.mDialog.dismiss();
                }
            } catch (IllegalArgumentException e) {
                DLog.m7384d("street view", "hideStreetView:" + e.toString(), new Object[0]);
            }
        }

        public void destroyLoader() {
            IStreetViewLoader iStreetViewLoader = this.mLoader;
            if (iStreetViewLoader != null) {
                iStreetViewLoader.cancelStreetViewLoad();
            }
        }

        public boolean isDialogShow() {
            StreetViewDialog streetViewDialog = this.mDialog;
            if (streetViewDialog != null) {
                return streetViewDialog.isShowing();
            }
            return false;
        }

        public void onDestroy() {
            View view = this.mRootView;
            if (view != null && (view.getParent() instanceof ViewGroup)) {
                ((ViewGroup) this.mRootView.getParent()).removeView(this.mRootView);
            }
            StreetViewDialog streetViewDialog = this.mDialog;
            if (streetViewDialog != null) {
                streetViewDialog.dismiss();
            }
            destroyLoader();
        }
    }
}
