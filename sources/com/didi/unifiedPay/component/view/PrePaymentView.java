package com.didi.unifiedPay.component.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didi.trackupload.sdk.Constants;
import com.didi.unifiedPay.component.model.PayChannelItem;
import com.didi.unifiedPay.component.model.PayTypes;
import com.didi.unifiedPay.component.view.IPrePayView;
import com.didi.unifiedPay.component.widget.PayMethodView;
import com.didi.unifiedPay.component.widget.RootRelativeLayout;
import com.didi.unifiedPay.component.widget.SingleSelectionListView;
import com.didi.unifiedPay.component.widget.loading.FailStateDialog;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.taxis99.R;
import java.util.List;

public class PrePaymentView extends FrameLayout implements View.OnClickListener, IPrePayView {

    /* renamed from: a */
    private RootRelativeLayout f44426a;

    /* renamed from: b */
    private TextView f44427b;

    /* renamed from: c */
    private TextView f44428c;

    /* renamed from: d */
    private TextView f44429d;

    /* renamed from: e */
    private TextView f44430e;

    /* renamed from: f */
    private ImageView f44431f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PayMethodView f44432g;

    /* renamed from: h */
    private ImageView f44433h;

    /* renamed from: i */
    private ImageView f44434i;

    /* renamed from: j */
    private LinearLayout f44435j;

    /* renamed from: k */
    private LinearLayout f44436k;

    /* renamed from: l */
    private ImageView f44437l;

    /* renamed from: m */
    private Context f44438m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public IPrePayView.PayViewListener f44439n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public FailStateDialog f44440o;

    /* renamed from: p */
    private ProgressDialogFragment f44441p;

    /* renamed from: q */
    private FragmentManager f44442q;

    public View getView() {
        return this;
    }

    public PrePaymentView(Context context, FragmentManager fragmentManager) {
        super(context);
        this.f44438m = context;
        this.f44442q = fragmentManager;
        m31554a();
    }

    public void setListener(IPrePayView.PayViewListener payViewListener) {
        this.f44439n = payViewListener;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick() && this.f44439n != null && view != null) {
            int id = view.getId();
            if (id == R.id.iv_close) {
                this.f44439n.onCloseBtnClick();
            } else if (id == R.id.oc_btn_pay) {
                this.f44439n.onPayBtnClick();
            } else if (id == R.id.iv_protocol_switch) {
                m31558b();
            } else if (id == R.id.iv_protocol_url) {
                this.f44439n.onProtocolBtnClick();
            }
        }
    }

    public void onPayFailure(FailStateDialog.Config config) {
        m31555a(config);
    }

    public void onPaySuccess() {
        enableAllViews(false);
    }

    public void onPayLoadingStart() {
        enableAllViews(false);
        if (this.f44441p == null) {
            this.f44441p = new ProgressDialogFragment();
            this.f44441p.setContent(ResourcesHelper.getString(this.f44438m, R.string.oc_uni_pre_pay_queryloading), false);
        }
        if (!this.f44441p.isAdded()) {
            this.f44441p.show(this.f44442q, "");
        }
    }

    public void onPayLoadingEnd() {
        enableAllViews(true);
        ProgressDialogFragment progressDialogFragment = this.f44441p;
        if (progressDialogFragment != null && progressDialogFragment.isAdded()) {
            this.f44441p.dismissAllowingStateLoss();
        }
    }

    public void onPageLoadingStart() {
        this.f44436k.setVisibility(8);
        if (this.f44435j.getVisibility() != 0) {
            RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
            rotateAnimation.setDuration(Constants.SUBTITUDE_LOC_EFFECTIVE_TIME);
            rotateAnimation.setRepeatCount(-1);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new LinearInterpolator());
            this.f44437l.startAnimation(rotateAnimation);
            this.f44435j.setVisibility(0);
        }
    }

    public void onPageLoadingEnd() {
        this.f44435j.clearAnimation();
        this.f44435j.setVisibility(8);
        this.f44436k.setVisibility(0);
    }

    public void onPayMethodSelected(boolean z) {
        PayMethodView payMethodView = this.f44432g;
        if (payMethodView != null && payMethodView.hasLoadingStateItem()) {
            this.f44432g.setBlockChangeResult(z);
        }
        enableAllViews(true);
    }

    public void setFee(String str) {
        UnipayTextUtil unipayTextUtil = new UnipayTextUtil(str);
        unipayTextUtil.spanNumSize(3.0f);
        this.f44429d.setText(unipayTextUtil);
    }

    public void setPayBtnText(String str) {
        if (!UnipayTextUtil.isEmpty(str)) {
            this.f44430e.setText(str);
        }
    }

    public void setPayBtnState(PayBtnState payBtnState) {
        if (payBtnState == PayBtnState.ENABLE) {
            this.f44431f.setVisibility(8);
            this.f44430e.setVisibility(0);
            this.f44430e.setEnabled(true);
        } else if (payBtnState == PayBtnState.DISABLE) {
            this.f44431f.setVisibility(8);
            this.f44430e.setVisibility(0);
            this.f44430e.setEnabled(false);
        } else if (payBtnState == PayBtnState.LOADING) {
            this.f44430e.setVisibility(8);
            this.f44431f.setVisibility(0);
            ((AnimationDrawable) this.f44431f.getDrawable()).start();
        }
    }

    public void updateThirdPartPayView(List<PayChannelItem> list, int i, boolean z) {
        if (list == null || list.size() < 1 || list.size() <= i) {
            this.f44432g.setVisibility(8);
            return;
        }
        this.f44432g.setVisibility(0);
        this.f44432g.setData(list, z, false);
        this.f44432g.onItemClick(i, true);
        if (z) {
            this.f44432g.setSelection(i);
        }
        this.f44432g.setOnSelectionListener(new SingleSelectionListView.OnSelectListener() {
            public void itemClicked(int i, PayChannelItem payChannelItem) {
            }

            public void onSelect(int i, Object obj) {
                if (PrePaymentView.this.f44432g.hasLoadingStateItem()) {
                    PrePaymentView.this.enableAllViews(false);
                }
                if (PrePaymentView.this.f44439n != null) {
                    PrePaymentView.this.f44439n.onSelectPayMethod(i, (PayChannelItem) obj);
                }
            }

            public void unSelect(int i, Object obj) {
                if (PrePaymentView.this.f44439n != null) {
                    PrePaymentView.this.f44439n.onUnSelectPayMethod(i, (PayChannelItem) obj);
                }
            }
        });
    }

    public void enableClose(boolean z) {
        this.f44434i.setEnabled(z);
    }

    public void enablePay(boolean z) {
        if (z) {
            setPayBtnState(PayBtnState.ENABLE);
        } else {
            setPayBtnState(PayBtnState.DISABLE);
        }
    }

    public void enableChangeChannel(boolean z) {
        this.f44432g.setItemEnable(z);
    }

    /* renamed from: a */
    private void m31556a(boolean z) {
        this.f44433h.setEnabled(z);
    }

    public boolean isCloseEnabled() {
        return this.f44434i.isEnabled();
    }

    public void enableAllViews(boolean z) {
        if (z) {
            enableClose(true);
            m31556a(true);
            if (!m31560c() || !m31561d()) {
                enablePay(false);
                enableChangeChannel(false);
                return;
            }
            enablePay(true);
            enableChangeChannel(true);
            return;
        }
        enableClose(false);
        enableChangeChannel(false);
        enablePay(false);
        m31556a(false);
    }

    public void setTitle(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != null && !TextUtils.isEmpty(charSequence.toString())) {
            this.f44427b.setText(charSequence);
        }
        if (charSequence2 == null || TextUtils.isEmpty(charSequence2.toString())) {
            this.f44428c.setVisibility(8);
            return;
        }
        this.f44428c.setText(charSequence2);
        this.f44428c.setVisibility(0);
    }

    public PayTypes getPayMethodTypes() {
        PayTypes payTypes = new PayTypes();
        PayChannelItem selection = this.f44432g.getSelection();
        if (selection != null) {
            payTypes.thirdPartPayType = selection.channelId;
        }
        return payTypes;
    }

    /* renamed from: a */
    private void m31554a() {
        LayoutInflater.from(getContext()).inflate(R.layout.view_pre_pay_layout, this);
        this.f44427b = (TextView) findViewById(R.id.tv_main_title);
        this.f44428c = (TextView) findViewById(R.id.tv_subtitle);
        this.f44429d = (TextView) findViewById(R.id.tv_pre_pay_value);
        this.f44430e = (TextView) findViewById(R.id.oc_btn_pay);
        this.f44432g = (PayMethodView) findViewById(R.id.oc_paymethod_view);
        this.f44435j = (LinearLayout) findViewById(R.id.ll_page_loading);
        this.f44437l = (ImageView) findViewById(R.id.iv_page_loading_icon);
        this.f44436k = (LinearLayout) findViewById(R.id.oc_ll_pay_biz_view);
        this.f44431f = (ImageView) findViewById(R.id.oc_btn_pay_loading);
        this.f44433h = (ImageView) findViewById(R.id.iv_protocol_switch);
        this.f44426a = (RootRelativeLayout) findViewById(R.id.oc_pay_root);
        ImageView imageView = (ImageView) findViewById(R.id.iv_close);
        this.f44434i = imageView;
        imageView.setOnClickListener(this);
        findViewById(R.id.iv_protocol_url).setOnClickListener(this);
        this.f44433h.setOnClickListener(this);
        this.f44433h.setSelected(true);
        this.f44430e.setOnClickListener(this);
    }

    /* renamed from: b */
    private void m31558b() {
        if (this.f44433h.isSelected()) {
            this.f44433h.setSelected(false);
            enableChangeChannel(false);
            enablePay(false);
            return;
        }
        this.f44433h.setSelected(true);
        enableChangeChannel(true);
        enablePay(true);
    }

    /* renamed from: c */
    private boolean m31560c() {
        return this.f44433h.isSelected();
    }

    /* renamed from: d */
    private boolean m31561d() {
        return this.f44429d.getText().length() > 0;
    }

    /* renamed from: a */
    private void m31555a(FailStateDialog.Config config) {
        if (this.f44440o == null) {
            FailStateDialog failStateDialog = new FailStateDialog(this.f44438m, 2132018107);
            this.f44440o = failStateDialog;
            Window window = failStateDialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setGravity(17);
            WindowManager windowManager = this.f44440o.getWindow().getWindowManager();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            attributes.width = (int) (((double) displayMetrics.widthPixels) * 0.8d);
            window.setAttributes(attributes);
        }
        if (!this.f44440o.isShowing()) {
            final FailStateDialog.onClickListener onclicklistener = config.listener;
            config.listener = new FailStateDialog.onClickListener() {
                public void onCancel() {
                    PrePaymentView.this.f44440o.dismiss();
                    FailStateDialog.onClickListener onclicklistener = onclicklistener;
                    if (onclicklistener != null) {
                        onclicklistener.onCancel();
                    }
                }

                public void onConfirm() {
                    PrePaymentView.this.f44440o.dismiss();
                    FailStateDialog.onClickListener onclicklistener = onclicklistener;
                    if (onclicklistener != null) {
                        onclicklistener.onConfirm();
                    }
                }
            };
            this.f44440o.setupView(config);
            SystemUtils.showDialog(this.f44440o);
        }
    }
}
