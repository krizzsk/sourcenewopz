package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.view.helper.IViewFreezeApplyer;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.payment.wallet.global.wallet.view.view.helper.WalletLineViewHelper;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.util.List;

@Deprecated
public class WalletPayMethodSectionView extends WalletAbsSectionView<WalletPageInfo.PayMethodSection, IWalletMainListEventListener> implements IViewFreezeApplyer {

    /* renamed from: a */
    private static final int f32469a = 6;

    /* renamed from: b */
    private ViewGroup f32470b;

    /* renamed from: c */
    private TextView f32471c;

    /* renamed from: d */
    private ImageView f32472d;

    /* renamed from: e */
    private LinearLayout f32473e;

    /* renamed from: f */
    private LinearLayout f32474f;

    /* renamed from: g */
    private TextView f32475g;

    /* renamed from: h */
    private TextView f32476h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f32477i = false;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WalletPageInfo.PayMethodSection f32478j;

    public WalletPayMethodSectionView(Context context) {
        super(context);
    }

    public WalletPayMethodSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletPayMethodSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_global_v_paymethod_section, this, true);
        this.f32470b = (ViewGroup) inflate.findViewById(R.id.ll_paymethod_title);
        this.f32471c = (TextView) inflate.findViewById(R.id.tv_paymethod_title);
        this.f32472d = (ImageView) inflate.findViewById(R.id.iv_paymethod_help);
        this.f32473e = (LinearLayout) inflate.findViewById(R.id.ll_paymethod_entry_container);
        this.f32474f = (LinearLayout) inflate.findViewById(R.id.ll_addpay);
        this.f32475g = (TextView) inflate.findViewById(R.id.tv_addpay_title);
        this.f32476h = (TextView) inflate.findViewById(R.id.tv_addpay_desc);
    }

    public void updateContent(final WalletPageInfo.PayMethodSection payMethodSection) {
        if (payMethodSection == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f32478j = payMethodSection;
        if (TextUtils.isEmpty(payMethodSection.title)) {
            this.f32470b.setVisibility(8);
        } else {
            this.f32470b.setVisibility(0);
            this.f32471c.setText(payMethodSection.title);
        }
        if (TextUtils.isEmpty(payMethodSection.helpUrl)) {
            this.f32472d.setVisibility(8);
            this.f32470b.setOnClickListener((View.OnClickListener) null);
        } else {
            this.f32472d.setVisibility(0);
            this.f32470b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (WalletPayMethodSectionView.this.mListener != null) {
                        ((IWalletMainListEventListener) WalletPayMethodSectionView.this.mListener).onPayMethodHelpEvent(payMethodSection.helpUrl);
                    }
                }
            });
        }
        if (payMethodSection.signEntry != null) {
            this.f32474f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (WalletPayMethodSectionView.this.mListener != null) {
                        ((IWalletMainListEventListener) WalletPayMethodSectionView.this.mListener).onPayMethodAddEvent(WalletPayMethodSectionView.this.f32478j.signEntry.dialogInfo);
                    }
                }
            });
            this.f32475g.setText(payMethodSection.signEntry.title);
            this.f32476h.setText(payMethodSection.signEntry.desc);
        }
        m23031a(payMethodSection.payMethodItems);
    }

    /* renamed from: a */
    private void m23031a(List<WalletPageInfo.PayMethodItem> list) {
        this.f32473e.removeAllViews();
        if (list != null && list.size() > 0) {
            int size = list.size();
            if (list.size() > 6 && !this.f32477i) {
                size = 6;
            }
            for (int i = 0; i < size; i++) {
                final WalletPageInfo.PayMethodItem payMethodItem = list.get(i);
                View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.wallet_global_v_paymethod_section_item, (ViewGroup) null, false);
                inflate.setLayoutParams(new RelativeLayout.LayoutParams(-1, PaymentTextUtil.dip2px(this.mContext, 60.0f)));
                TextView textView = (TextView) inflate.findViewById(R.id.tv_paymethod_desc);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_paymethod_right_text);
                View findViewById = inflate.findViewById(R.id.iv_paymethod_check);
                GlideUtils.with2load2into(getContext(), payMethodItem.iconUrl, (ImageView) inflate.findViewById(R.id.iv_paymethod_icon));
                ((TextView) inflate.findViewById(R.id.tv_paymethod_name)).setText(payMethodItem.title);
                if (TextUtils.isEmpty(payMethodItem.desc)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setEnabled(payMethodItem.cardStatus != 1);
                    textView.setText(payMethodItem.desc);
                }
                if (payMethodItem.channelId == 190 || payMethodItem.channelId == 120) {
                    findViewById.setVisibility(8);
                } else {
                    findViewById.setVisibility(0);
                    inflate.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (WalletPayMethodSectionView.this.mListener != null) {
                                ((IWalletMainListEventListener) WalletPayMethodSectionView.this.mListener).onPayMethodItemClickEvent(payMethodItem);
                            }
                        }
                    });
                }
                if (payMethodItem.expired == 1 && !TextUtils.isEmpty(payMethodItem.expiredDesc)) {
                    textView2.setVisibility(0);
                    textView2.setTextColor(ResourcesHelper.getColor(this.mContext, R.color.wallet_boleto_cashin_tv_min_value_red));
                    textView2.setText(payMethodItem.expiredDesc);
                }
                this.f32473e.addView(inflate);
                if (i != size - 1) {
                    WalletLineViewHelper.addLeftMarginLineView(this.mContext, this.f32473e);
                }
            }
            if (list.size() > 6) {
                View inflate2 = LayoutInflater.from(this.mContext).inflate(R.layout.wallet_global_v_paymethod_section_expand, (ViewGroup) null, false);
                inflate2.setLayoutParams(new RelativeLayout.LayoutParams(-1, PaymentTextUtil.dip2px(this.mContext, 45.0f)));
                inflate2.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        WalletPayMethodSectionView walletPayMethodSectionView = WalletPayMethodSectionView.this;
                        boolean unused = walletPayMethodSectionView.f32477i = !walletPayMethodSectionView.f32477i;
                        WalletPayMethodSectionView walletPayMethodSectionView2 = WalletPayMethodSectionView.this;
                        walletPayMethodSectionView2.updateContent(walletPayMethodSectionView2.f32478j);
                    }
                });
                if (this.f32477i) {
                    inflate2.findViewById(R.id.tv_more).setVisibility(8);
                    inflate2.findViewById(R.id.tv_less).setVisibility(0);
                } else {
                    inflate2.findViewById(R.id.tv_more).setVisibility(0);
                    inflate2.findViewById(R.id.tv_less).setVisibility(8);
                }
                this.f32473e.addView(inflate2);
            }
        }
    }

    public void apply(IViewFreezeApplyer.FreezeState freezeState) {
        if (freezeState != null && freezeState.isFreeze) {
            this.f32475g.setTextColor(ResourcesHelper.getColor(getContext(), R.color.pay_base_orange_disable));
            this.f32476h.setTextColor(ResourcesHelper.getColor(getContext(), R.color.wallet_color_gray_disable));
            this.f32474f.setOnClickListener((View.OnClickListener) null);
        }
    }
}
