package com.didiglobal.privacy.disclosure;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public abstract class PrivacyDisclosureBaseDialog extends BaseDialogFragment {
    protected View bottomShadowView;
    protected Builder builder;
    protected View content;
    protected TextView descTxt;
    protected boolean isPendingDismiss;
    protected TextView negativeBtn;
    protected TextView positiveBtn;
    protected ScrollView scrollView;
    protected TextView titleTxt;
    protected View topShadowView;

    public interface Callback {
        void onNegativeResult();

        void onPositiveResult(PositiveResultReason positiveResultReason);
    }

    /* access modifiers changed from: protected */
    public abstract void uploadInfo(Context context, UploadParam uploadParam);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, 2132017496);
        setCancelable(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().getWindow().clearFlags(2);
        BasePrivacyDisclosureInitParam initParam = PrivacyDisclosureBaseManager.getInitParam();
        View inflate = layoutInflater.inflate(initParam.getDialogLayoutResInt(), viewGroup, false);
        m36304a(inflate, initParam);
        return inflate;
    }

    /* renamed from: a */
    private void m36304a(View view, IPrivacyDisclosureInitParam iPrivacyDisclosureInitParam) {
        this.content = view.findViewById(R.id.content);
        this.titleTxt = (TextView) view.findViewById(R.id.title);
        this.descTxt = (TextView) view.findViewById(R.id.desc);
        TextView textView = (TextView) view.findViewById(R.id.btn_positive);
        this.positiveBtn = textView;
        textView.setBackgroundResource(iPrivacyDisclosureInitParam.getPositiveBtnResInt());
        this.positiveBtn.setTextColor(iPrivacyDisclosureInitParam.getPositionBtnTextColor());
        this.positiveBtn.setText(iPrivacyDisclosureInitParam.getPositiveBtnText(getContext()));
        TextView textView2 = (TextView) view.findViewById(R.id.btn_negative);
        this.negativeBtn = textView2;
        textView2.setBackgroundResource(iPrivacyDisclosureInitParam.getNegativeBtnResInt());
        this.negativeBtn.setTextColor(iPrivacyDisclosureInitParam.getNegativeBtnTextColor());
        this.negativeBtn.setText(iPrivacyDisclosureInitParam.getNegativeBtnText(getContext()));
        this.scrollView = (ScrollView) view.findViewById(R.id.scroll_view);
        this.topShadowView = view.findViewById(R.id.top_shadow);
        this.bottomShadowView = view.findViewById(R.id.bottom_shadow);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m36305a() {
        View childAt;
        ScrollView scrollView2 = this.scrollView;
        if (scrollView2 == null || (childAt = scrollView2.getChildAt(0)) == null || this.scrollView.getHeight() >= childAt.getHeight()) {
            return false;
        }
        return true;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Builder builder2 = this.builder;
        if (builder2 != null) {
            String customDialogTitle = builder2.privacyType.getCustomDialogTitle();
            if (!TextUtils.isEmpty(customDialogTitle)) {
                this.titleTxt.setText(customDialogTitle);
            }
            this.descTxt.setText(this.builder.privacyType.getDialogDesc());
            this.positiveBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (PrivacyDisclosureBaseDialog.this.builder.callback != null) {
                        PrivacyDisclosureBaseDialog.this.builder.callback.onPositiveResult(PositiveResultReason.USER_CLICK_AGREE_BTN);
                    }
                    PrivacyDisclosureBaseDialog.this.dismiss();
                    DisclosureSpUtils.m36292a(PrivacyDisclosureBaseDialog.this.getActivity(), PrivacyDisclosureBaseDialog.this.builder.privacyType, true);
                    PrivacyDisclosureBaseDialog.this.builder.uploadParam.setClickTime(System.currentTimeMillis() / 1000).setUserAction(1);
                    PrivacyDisclosureBaseDialog privacyDisclosureBaseDialog = PrivacyDisclosureBaseDialog.this;
                    privacyDisclosureBaseDialog.uploadInfo(privacyDisclosureBaseDialog.getActivity(), PrivacyDisclosureBaseDialog.this.builder.uploadParam);
                }
            });
            this.negativeBtn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (PrivacyDisclosureBaseDialog.this.builder.callback != null) {
                        PrivacyDisclosureBaseDialog.this.builder.callback.onNegativeResult();
                    }
                    PrivacyDisclosureBaseDialog.this.dismiss();
                    DisclosureSpUtils.m36292a(PrivacyDisclosureBaseDialog.this.getActivity(), PrivacyDisclosureBaseDialog.this.builder.privacyType, false);
                    PrivacyDisclosureBaseDialog.this.builder.uploadParam.setClickTime(System.currentTimeMillis() / 1000).setUserAction(2);
                    PrivacyDisclosureBaseDialog privacyDisclosureBaseDialog = PrivacyDisclosureBaseDialog.this;
                    privacyDisclosureBaseDialog.uploadInfo(privacyDisclosureBaseDialog.getActivity(), PrivacyDisclosureBaseDialog.this.builder.uploadParam);
                }
            });
            this.isPendingDismiss = false;
            this.content.post(new Runnable() {
                public void run() {
                    int measuredHeight = PrivacyDisclosureBaseDialog.this.content.getMeasuredHeight();
                    PrivacyDisclosureBaseDialog.this.content.animate().cancel();
                    PrivacyDisclosureBaseDialog.this.content.setTranslationY((float) measuredHeight);
                    PrivacyDisclosureBaseDialog.this.content.animate().withStartAction(new Runnable() {
                        public void run() {
                            PrivacyDisclosureBaseDialog.this.content.setVisibility(0);
                        }
                    }).translationYBy((float) (-measuredHeight)).setDuration(300).start();
                    if (PrivacyDisclosureBaseDialog.this.scrollView != null) {
                        boolean a = PrivacyDisclosureBaseDialog.this.m36305a();
                        int i = 0;
                        if (PrivacyDisclosureBaseDialog.this.topShadowView != null) {
                            PrivacyDisclosureBaseDialog.this.topShadowView.setVisibility(a ? 0 : 4);
                        }
                        if (PrivacyDisclosureBaseDialog.this.bottomShadowView != null) {
                            View view = PrivacyDisclosureBaseDialog.this.bottomShadowView;
                            if (!a) {
                                i = 4;
                            }
                            view.setVisibility(i);
                        }
                    }
                }
            });
            return;
        }
        dismiss();
    }

    public void show(FragmentManager fragmentManager, String str, Builder builder2) {
        this.builder = builder2;
        if (builder2 != null) {
            show(fragmentManager, str);
        }
    }

    public void dismiss() {
        if (this.builder != null) {
            this.isPendingDismiss = true;
            this.content.animate().translationYBy((float) this.content.getMeasuredHeight()).setDuration(300).withEndAction(new Runnable() {
                public void run() {
                    PrivacyDisclosureBaseDialog.this.content.setVisibility(4);
                    PrivacyDisclosureBaseDialog.super.dismiss();
                }
            }).start();
            return;
        }
        super.dismiss();
    }

    public boolean isPendingDismiss() {
        return this.isPendingDismiss;
    }

    public static class Builder {
        Callback callback;
        int negativeBtnResInt;
        int negativeBtnTextColor;
        int positiveBtnResInt;
        int positiveBtnTextColor;
        IPrivacyType privacyType;
        UploadParam uploadParam;

        public Builder setPrivacyType(IPrivacyType iPrivacyType) {
            this.privacyType = iPrivacyType;
            return this;
        }

        public Builder setCallback(Callback callback2) {
            this.callback = callback2;
            return this;
        }

        public Builder setPositiveBtnResInt(int i) {
            this.positiveBtnResInt = i;
            return this;
        }

        public Builder setNegativeBtnResInt(int i) {
            this.negativeBtnResInt = i;
            return this;
        }

        public Builder setUploadParam(UploadParam uploadParam2) {
            this.uploadParam = uploadParam2;
            return this;
        }

        public Builder setPositiveBtnTextColor(int i) {
            this.positiveBtnTextColor = i;
            return this;
        }

        public Builder setNegativeBtnTextColor(int i) {
            this.negativeBtnTextColor = i;
            return this;
        }
    }
}
