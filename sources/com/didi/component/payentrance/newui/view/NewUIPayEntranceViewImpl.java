package com.didi.component.payentrance.newui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.core.IPresenter;
import com.didi.component.payentrance.model.Jumpable;
import com.didi.component.payentrance.model.JumpableItem;
import com.didi.component.payentrance.utils.PEUtils;
import com.didi.component.payentrance.utils.SimpleSpanStringBuilder;
import com.didi.component.payentrance.utils.TextUtil;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.component.payentrance.view.Mode;
import com.didi.component.payentrance.view.PayentranceLoadingView;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewUIPayEntranceViewImpl implements INewUIPayEntranceView {
    protected static final float PRICE_RATIO = 1.5f;

    /* renamed from: n */
    private static final String f14931n = "([1-9]\\d*\\.\\d*|0\\.\\d*|[0-9]+)";

    /* renamed from: a */
    private View f14932a;

    /* renamed from: b */
    private Mode f14933b;

    /* renamed from: c */
    private TextView f14934c;

    /* renamed from: d */
    private TextView f14935d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f14936e;

    /* renamed from: f */
    private LinearLayout f14937f;

    /* renamed from: g */
    private TextView f14938g;

    /* renamed from: h */
    private TextView f14939h;

    /* renamed from: i */
    private View f14940i;

    /* renamed from: j */
    private Jumpable f14941j;

    /* renamed from: k */
    private ViewGroup f14942k;

    /* renamed from: l */
    private PayentranceLoadingView f14943l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public IPayEntranceView.OnErrorClickListener f14944m;
    protected Context mContext;
    protected LayoutInflater mInflater;
    protected IPayEntranceView.OnCancelRuleClickListener mOnCancelRuleClickListener;
    protected IPayEntranceView.OnJumpableClickListener mOnJumpableClickListener;
    protected IPayEntranceView.OnPayListener mOnPayListener;
    protected View.OnClickListener mOnViewClickListener = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (NewUIPayEntranceViewImpl.this.mOnJumpableClickListener != null) {
                NewUIPayEntranceViewImpl.this.mOnJumpableClickListener.onItemClick((JumpableItem) view.getTag());
            }
        }
    };

    public void addSupplement(DeductionInfo deductionInfo, String str) {
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.global_new_ui_pay_normal_view;
    }

    public void removeSupplement() {
    }

    public void setActionButtonEnable(boolean z) {
    }

    public void setCancelRuleShow(boolean z) {
    }

    public void setCouponSupplement(String str, String str2) {
    }

    public void setIconShow(boolean z) {
    }

    public void setInputHint(CharSequence charSequence) {
    }

    public void setInputLabel(CharSequence charSequence) {
    }

    public void setMessage(CharSequence charSequence) {
    }

    public void setOnInputValueChangeListener(IPayEntranceView.OnInputValueChangeListener onInputValueChangeListener) {
    }

    public void setPayWay(String str) {
    }

    public void setPresenter(IPresenter iPresenter) {
    }

    public void showTipsCheckbox(String str, boolean z, IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener) {
    }

    public NewUIPayEntranceViewImpl(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.mContext = context;
        this.mInflater = layoutInflater;
        View inflate = layoutInflater.inflate(getLayoutId(), viewGroup, false);
        this.f14932a = inflate;
        onViewCreated(inflate);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        this.f14934c = (TextView) view.findViewById(R.id.new_ui_pay_view_title);
        this.f14935d = (TextView) view.findViewById(R.id.new_ui_pay_view_subtitle);
        this.f14936e = (TextView) view.findViewById(R.id.new_ui_pay_view_fee);
        this.f14937f = (LinearLayout) view.findViewById(R.id.new_ui_pay_view_fee_layout);
        this.f14938g = (TextView) view.findViewById(R.id.new_ui_pay_view_btn);
        TextView textView = (TextView) view.findViewById(R.id.new_ui_add_card_view_btn);
        this.f14939h = textView;
        textView.setText(R.string.pe_pay_entrance_cancel_fee_binding_card);
        this.f14940i = view.findViewById(R.id.new_ui_pay_arrow_icon);
        this.f14938g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                NewUIPayEntranceViewImpl.this.omegaTrack("ibt_gp_endtrip_payerror_pay_ck");
                NewUIPayEntranceViewImpl.this.performOnPay(TextUtil.getFirstMoneyFromText(String.valueOf(NewUIPayEntranceViewImpl.this.f14936e.getText())), "0");
            }
        });
    }

    /* access modifiers changed from: protected */
    public void performOnPay(String str, String str2) {
        IPayEntranceView.OnPayListener onPayListener = this.mOnPayListener;
        if (onPayListener != null) {
            onPayListener.onPayClick(this.f14933b, Double.valueOf(str.trim()).doubleValue(), Double.valueOf(str2.trim()).doubleValue());
        }
    }

    public View getView() {
        return this.f14932a;
    }

    public void setFeeDescribe(CharSequence charSequence) {
        if (charSequence == null || TextUtil.isEmpty(charSequence.toString())) {
            this.f14935d.setVisibility(8);
            return;
        }
        this.f14935d.setText(charSequence);
        this.f14935d.setVisibility(0);
    }

    public void setPrice(double d) {
        setPrice(this.mContext.getString(R.string.pe_pay_entrance_money, new Object[]{PEUtils.format(d)}));
    }

    public void setPrice(String str) {
        this.f14937f.setVisibility(0);
        setMoneyWithUnit(this.f14936e, str, 1.5f);
    }

    public void setOnCancelRuleClickListener(IPayEntranceView.OnCancelRuleClickListener onCancelRuleClickListener) {
        this.mOnCancelRuleClickListener = onCancelRuleClickListener;
    }

    public void setActionText(String str) {
        this.f14938g.setVisibility(0);
        this.f14938g.setText(str);
        this.f14939h.setVisibility(8);
    }

    public void setOnPayListener(IPayEntranceView.OnPayListener onPayListener) {
        this.mOnPayListener = onPayListener;
    }

    public void setJumpableItems(List<Jumpable> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Jumpable next : list) {
                if (next.getId() == 1) {
                    this.f14941j = next;
                } else if (next.getId() != 3) {
                    arrayList.add(next);
                }
            }
            if (this.f14941j != null) {
                this.f14940i.setVisibility(0);
                this.f14936e.setTag(this.f14941j);
                this.f14936e.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        NewUIPayEntranceViewImpl.this.omegaTrack("ibt_gp_endtrip_payerror_price_ck");
                        NewUIPayEntranceViewImpl.this.mOnViewClickListener.onClick(view);
                    }
                });
            }
        }
        addJumpableViews(this.f14942k, arrayList);
    }

    /* access modifiers changed from: protected */
    public void addJumpableViews(ViewGroup viewGroup, List<Jumpable> list) {
        if (viewGroup != null && list != null && list.size() != 0) {
            viewGroup.removeAllViews();
            for (Jumpable createJumpableView : list) {
                viewGroup.addView(createJumpableView(viewGroup, createJumpableView));
            }
            if (viewGroup.getVisibility() == 8) {
                viewGroup.setVisibility(0);
            }
        }
    }

    public View createJumpableView(ViewGroup viewGroup, Jumpable jumpable) {
        TextView textView = (TextView) this.mInflater.inflate(R.layout.global_pe_jumpalbe_item_view, viewGroup, false);
        if (!TextUtils.isEmpty(jumpable.getText())) {
            textView.setText(jumpable.getText());
        } else {
            textView.setText(jumpable.getTextRes());
        }
        textView.setContentDescription(textView.getText() + textView.getContext().getString(R.string.pe_voice_btn_to_jump));
        textView.setTag(jumpable);
        textView.setOnClickListener(this.mOnViewClickListener);
        return textView;
    }

    public void setOnJumpableClickListener(IPayEntranceView.OnJumpableClickListener onJumpableClickListener) {
        this.mOnJumpableClickListener = onJumpableClickListener;
    }

    public void setMode(Mode mode) {
        this.f14933b = mode;
    }

    public Mode getMode() {
        return this.f14933b;
    }

    /* access modifiers changed from: protected */
    public View getLoadingArea() {
        return this.f14932a.findViewById(R.id.new_ui_pay_layout_container);
    }

    public void showLoading() {
        View loadingArea = getLoadingArea();
        if (loadingArea != null) {
            ViewParent parent = loadingArea.getParent();
            if (parent instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) parent;
                loadingArea.setVisibility(4);
                if (this.f14943l == null) {
                    this.f14943l = new PayentranceLoadingView(this.mContext);
                }
                if (this.f14943l.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 17;
                    frameLayout.addView(this.f14943l, 0, layoutParams);
                }
                this.f14943l.showMask();
                frameLayout.setOnClickListener((View.OnClickListener) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r1 = (android.widget.FrameLayout) r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void hideLoading() {
        /*
            r5 = this;
            android.view.View r0 = r5.getLoadingArea()
            if (r0 == 0) goto L_0x002a
            android.view.ViewParent r1 = r0.getParent()
            boolean r2 = r1 instanceof android.widget.FrameLayout
            if (r2 == 0) goto L_0x002a
            android.widget.FrameLayout r1 = (android.widget.FrameLayout) r1
            r2 = 0
            android.view.View r3 = r1.getChildAt(r2)
            if (r3 == 0) goto L_0x002a
            boolean r4 = r3 instanceof com.didi.component.payentrance.view.PayentranceLoadingView
            if (r4 == 0) goto L_0x002a
            com.didi.component.payentrance.view.PayentranceLoadingView r3 = (com.didi.component.payentrance.view.PayentranceLoadingView) r3
            r3.hideMask()
            r1.removeView(r3)
            r0.setVisibility(r2)
            r0 = 0
            r1.setOnClickListener(r0)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.payentrance.newui.view.NewUIPayEntranceViewImpl.hideLoading():void");
    }

    public void showError(CharSequence charSequence) {
        View loadingArea = getLoadingArea();
        if (loadingArea != null) {
            ViewParent parent = loadingArea.getParent();
            if (parent instanceof FrameLayout) {
                FrameLayout frameLayout = (FrameLayout) parent;
                loadingArea.setVisibility(4);
                if (this.f14943l == null) {
                    this.f14943l = new PayentranceLoadingView(this.mContext);
                }
                if (this.f14943l.getParent() == null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 17;
                    frameLayout.addView(this.f14943l, 0, layoutParams);
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    this.f14943l.showError(charSequence);
                } else {
                    this.f14943l.showError();
                }
                frameLayout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (NewUIPayEntranceViewImpl.this.f14944m != null) {
                            NewUIPayEntranceViewImpl.this.f14944m.onErrorClick();
                        }
                    }
                });
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = (android.widget.FrameLayout) r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void hideError() {
        /*
            r4 = this;
            android.view.View r0 = r4.getLoadingArea()
            if (r0 == 0) goto L_0x002a
            android.view.ViewParent r0 = r0.getParent()
            boolean r1 = r0 instanceof android.widget.FrameLayout
            if (r1 == 0) goto L_0x002a
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r1 = 0
            android.view.View r2 = r0.getChildAt(r1)
            if (r2 == 0) goto L_0x002a
            boolean r3 = r2 instanceof com.didi.component.payentrance.view.PayentranceLoadingView
            if (r3 == 0) goto L_0x002a
            com.didi.component.payentrance.view.PayentranceLoadingView r2 = (com.didi.component.payentrance.view.PayentranceLoadingView) r2
            r2.hideError()
            r3 = 0
            r0.setOnClickListener(r3)
            r0.removeView(r2)
            r0.setVisibility(r1)
        L_0x002a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.payentrance.newui.view.NewUIPayEntranceViewImpl.hideError():void");
    }

    public void setOnErrorListener(IPayEntranceView.OnErrorClickListener onErrorClickListener) {
        this.f14944m = onErrorClickListener;
    }

    public void showBindCard(boolean z) {
        if (z) {
            this.f14939h.setVisibility(0);
            this.f14938g.setVisibility(8);
            this.f14937f.setVisibility(8);
            return;
        }
        this.f14939h.setVisibility(8);
        this.f14938g.setVisibility(0);
        this.f14937f.setVisibility(0);
    }

    public void setOnBindCardClickListener(final IPayEntranceView.OnBindCardClickListener onBindCardClickListener) {
        this.f14939h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IPayEntranceView.OnBindCardClickListener onBindCardClickListener = onBindCardClickListener;
                if (onBindCardClickListener != null) {
                    onBindCardClickListener.onClick(view);
                }
            }
        });
    }

    public void setMoneyWithUnit(TextView textView, String str, float f) {
        SimpleSpanStringBuilder simpleSpanStringBuilder = new SimpleSpanStringBuilder(m10718a(str));
        simpleSpanStringBuilder.spanNumSize(f);
        textView.setText(simpleSpanStringBuilder);
        textView.setVisibility(0);
    }

    /* renamed from: a */
    private String m10718a(String str) {
        Matcher matcher = Pattern.compile(f14931n).matcher(str);
        int start = matcher.find() ? matcher.start() : 0;
        if (start == 0) {
            return str;
        }
        String substring = str.substring(0, start);
        return str.replace(substring, substring + " ");
    }

    public void setTitle(String str) {
        this.f14934c.setVisibility(0);
        this.f14934c.setText(str);
    }

    public void setPayInfo(final BasicPayInfo basicPayInfo) {
        try {
            this.f14935d.setTextColor(Color.parseColor(basicPayInfo.payStatusColor));
            if (!TextUtils.isEmpty(basicPayInfo.payStatusLink)) {
                this.f14935d.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DRouter.build(basicPayInfo.payStatusLink).start(NewUIPayEntranceViewImpl.this.mContext);
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBtnClickable(boolean z) {
        this.f14939h.setClickable(z);
        this.f14938g.setClickable(z);
        this.f14939h.setEnabled(z);
        this.f14938g.setEnabled(z);
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(new int[]{R.attr.new_evaluate_cancel_dialog_button_ok_text_color});
        int color = obtainStyledAttributes.getColor(0, -16777216);
        obtainStyledAttributes.recycle();
        if (z) {
            this.f14939h.setTextColor(color);
            this.f14938g.setTextColor(color);
            return;
        }
        int color2 = ResourcesHelper.getColor(this.mContext, R.color.grayscale_color_4);
        this.f14939h.setTextColor(color2);
        this.f14938g.setTextColor(color2);
    }

    public void omegaTrack(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", getOmegaType());
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }

    public String getOmegaType() {
        return BusinessDataUtil.isCancelFeeNeedPay() ? "cancel" : "order";
    }
}
