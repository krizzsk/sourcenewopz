package com.didi.soda.home.component.phone;

import android.app.Activity;
import android.graphics.Rect;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.soda.address.AndroidBug5497Workaround;
import com.didi.soda.customer.base.ICustomerView;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.home.component.phone.HomePhoneView;
import com.didi.soda.home.widget.InputPhoneLayout;
import com.taxis99.R;

public class HomePhoneView extends ICustomerView<HomePhonePresenter> {

    /* renamed from: a */
    private boolean f42612a = false;

    /* renamed from: b */
    private boolean f42613b = true;

    /* renamed from: c */
    private OnLayoutChangeListener f42614c = new OnLayoutChangeListener();
    @BindView(18780)
    View mBackView;
    @BindView(19175)
    InputPhoneLayout mInputPhoneLayout;
    @BindView(19092)
    LinearLayout mPrivacyLayout;
    @BindView(19093)
    TextView mPrivacyTextView;
    @BindView(18711)
    ScrollView mScrollView;
    @BindView(19176)
    RFMainButton mSubmitBtn;

    public void updateCallingCode(String str) {
        this.mInputPhoneLayout.updateCode(str);
    }

    public void showOrHideLoading(boolean z) {
        this.mSubmitBtn.setLoading(z);
    }

    public void hideSoftInput() {
        KeyboardUtils.hideSoftInput(getContext(), this.mInputPhoneLayout.getEditTextView());
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        getView().getViewTreeObserver().addOnGlobalLayoutListener(this.f42614c);
        AndroidBug5497Workaround.getInstance((Activity) getContext()).assistComponent(getScopeContext(), getView());
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomePhoneView.this.m30095d(view);
            }
        });
        this.mInputPhoneLayout.setOnCodeClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomePhoneView.this.m30092c(view);
            }
        });
        m30094d();
        this.mSubmitBtn.setEnabled(false);
        this.mSubmitBtn.setText(ResourceHelper.getString(R.string.customer_hone_non_submit));
        this.mSubmitBtn.setOnClickListener((View.OnClickListener) null);
        m30085a();
        this.mPrivacyLayout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                HomePhoneView.this.m30090b(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m30095d(View view) {
        getScopeContext().getNavigator().finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m30092c(View view) {
        KeyboardUtils.hideSoftInput(getContext(), this.mInputPhoneLayout.getEditTextView());
        ((HomePhonePresenter) getPresenter()).showPhoneCode();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m30090b(View view) {
        boolean z = !this.f42612a;
        this.f42612a = z;
        this.mPrivacyLayout.setSelected(z);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f42613b) {
            this.f42613b = false;
            this.mInputPhoneLayout.focus();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (KeyboardUtils.isSoftInputVisible((Activity) getContext())) {
            this.f42613b = true;
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        KeyboardUtils.hideSoftInput(getContext(), this.mInputPhoneLayout.getEditTextView());
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this.f42614c);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_subsrcibe_phone, viewGroup);
    }

    /* renamed from: a */
    private void m30085a() {
        String string = ResourceHelper.getString(R.string.customer_hone_non_i_accept);
        String string2 = ResourceHelper.getString(R.string.customer_hone_non_terms_policy);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string + string2);
        spannableStringBuilder.setSpan(new Clickable($$Lambda$HomePhoneView$dPIGpJpUmjNku4NWlL1rq64bxYk.INSTANCE), string.length(), string.length() + string2.length(), 33);
        this.mPrivacyTextView.setMovementMethod(LinkMovementMethod.getInstance());
        this.mPrivacyTextView.setHighlightColor(ContextCompat.getColor(getContext(), R.color.customer_color_transparent));
        this.mPrivacyTextView.setText(spannableStringBuilder);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m30089b() {
        if (!this.mSubmitBtn.isLoading()) {
            if (!this.f42612a) {
                ToastUtil.showCustomerToast(getScopeContext(), ResourceHelper.getString(R.string.customer_hone_non_agree_terms_policy));
                return;
            }
            ((HomePhonePresenter) getPresenter()).submit(this.mInputPhoneLayout.getPhone());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m30091c() {
        this.mScrollView.post(new Runnable() {
            public final void run() {
                HomePhoneView.this.m30096e();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void m30096e() {
        int childCount = this.mScrollView.getChildCount();
        if (childCount > 0) {
            View childAt = this.mScrollView.getChildAt(childCount - 1);
            this.mScrollView.smoothScrollBy(0, childAt.getBottom() - (this.mScrollView.getScrollY() + this.mScrollView.getHeight()));
        }
    }

    /* renamed from: d */
    private void m30094d() {
        this.mInputPhoneLayout.getEditTextView().addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    HomePhoneView.this.mSubmitBtn.setEnabled(false);
                    HomePhoneView.this.mSubmitBtn.setOnClickListener((View.OnClickListener) null);
                    return;
                }
                HomePhoneView.this.mSubmitBtn.setEnabled(true);
                HomePhoneView.this.mSubmitBtn.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        HomePhoneView.C139731.this.lambda$afterTextChanged$0$HomePhoneView$1(view);
                    }
                });
            }

            public /* synthetic */ void lambda$afterTextChanged$0$HomePhoneView$1(View view) {
                HomePhoneView.this.m30089b();
            }
        });
    }

    private class OnLayoutChangeListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private OnLayoutChangeListener() {
        }

        public void onGlobalLayout() {
            View b = HomePhoneView.this.getView();
            Rect rect = new Rect();
            b.getWindowVisibleDisplayFrame(rect);
            if ((b.getHeight() - rect.height()) - CustomerSystemUtil.getImmersiveStatusBarHeight(HomePhoneView.this.getContext()) > 0) {
                HomePhoneView.this.m30091c();
            }
        }
    }

    class Clickable extends ClickableSpan implements View.OnClickListener {
        private final View.OnClickListener mListener;

        public Clickable(View.OnClickListener onClickListener) {
            this.mListener = onClickListener;
        }

        public void onClick(View view) {
            this.mListener.onClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(HomePhoneView.this.getColor(R.color.rf_color_brands_1_100));
            textPaint.setUnderlineText(false);
        }
    }
}
