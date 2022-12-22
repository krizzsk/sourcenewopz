package com.didi.payment.wallet.global.wallet.view.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.PaySharedPreferencesUtil;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.sdk.view.tips.TipsView;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.List;

public class WalletBalanceSectionView extends WalletAbsSectionView<WalletPageInfo.BalanceSection, IWalletMainListEventListener> {

    /* renamed from: a */
    private static final String f32402a = "KEY_TOPUP_GUIDE_CLOSED";

    /* renamed from: b */
    private Context f32403b;

    /* renamed from: c */
    private TextView f32404c;

    /* renamed from: d */
    private ImageView f32405d;

    /* renamed from: e */
    private LinearLayout f32406e;

    /* renamed from: f */
    private TextView f32407f;

    /* renamed from: g */
    private TextView f32408g;

    /* renamed from: h */
    private ImageView f32409h;

    /* renamed from: i */
    private TextView f32410i;

    /* renamed from: j */
    private ImageView f32411j;

    /* renamed from: k */
    private LinearLayout f32412k;

    /* renamed from: l */
    private TipsView f32413l;

    public WalletBalanceSectionView(Context context) {
        super(context);
    }

    public WalletBalanceSectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WalletBalanceSectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Context context) {
        this.f32403b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.wallet_global_v_balance_section, this, true);
        this.f32404c = (TextView) inflate.findViewById(R.id.tv_balance_title);
        this.f32405d = (ImageView) inflate.findViewById(R.id.iv_balance_help);
        this.f32407f = (TextView) inflate.findViewById(R.id.tv_balance_symbol);
        this.f32408g = (TextView) inflate.findViewById(R.id.tv_balance_value);
        this.f32408g = (TextView) inflate.findViewById(R.id.tv_balance_value);
        this.f32409h = (ImageView) inflate.findViewById(R.id.tv_balance_value_arrow);
        this.f32410i = (TextView) inflate.findViewById(R.id.tv_tips);
        this.f32411j = (ImageView) inflate.findViewById(R.id.iv_banner);
        this.f32406e = (LinearLayout) inflate.findViewById(R.id.ll_balance_value);
        this.f32413l = (TipsView) findViewById(R.id.v_tips);
        this.f32412k = (LinearLayout) inflate.findViewById(R.id.ll_balance_entry_container);
    }

    public void updateContent(final WalletPageInfo.BalanceSection balanceSection) {
        if (balanceSection == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.f32413l.setVisibility(8);
        this.f32411j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletBalanceSectionView.this.mListener != null && !TextUtils.isEmpty(balanceSection.bannerLinkUrl)) {
                    ((IWalletMainListEventListener) WalletBalanceSectionView.this.mListener).onBalanceBannerClickEvent(balanceSection.bannerLinkUrl);
                }
            }
        });
        this.f32405d.setVisibility(TextUtils.isEmpty(balanceSection.helpUrl) ? 8 : 0);
        this.f32405d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletBalanceSectionView.this.mListener != null && !TextUtils.isEmpty(balanceSection.helpUrl)) {
                    ((IWalletMainListEventListener) WalletBalanceSectionView.this.mListener).onBalanceHelpEvent(balanceSection.helpUrl);
                }
            }
        });
        this.f32406e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (WalletBalanceSectionView.this.mListener != null && !TextUtils.isEmpty(balanceSection.linkUrl) && balanceSection.status == 1) {
                    ((IWalletMainListEventListener) WalletBalanceSectionView.this.mListener).onBalanceDetailClickEvent(balanceSection.linkUrl);
                }
            }
        });
        if (balanceSection.status == 1) {
            this.f32407f.setEnabled(true);
            this.f32408g.setEnabled(true);
            this.f32409h.setEnabled(true);
        } else {
            this.f32408g.setEnabled(false);
            this.f32407f.setEnabled(false);
            this.f32409h.setEnabled(false);
        }
        if (TextUtils.isEmpty(balanceSection.desc)) {
            this.f32410i.setVisibility(8);
        } else {
            this.f32410i.setVisibility(0);
            this.f32410i.setText(balanceSection.desc);
        }
        if (!TextUtils.isEmpty(balanceSection.bannerUrl)) {
            this.f32411j.setVisibility(0);
            GlideUtils.loadRoundImage(this.f32403b, balanceSection.bannerUrl, 2, this.f32411j);
        } else {
            this.f32411j.setVisibility(8);
        }
        this.f32404c.setText(balanceSection.title);
        this.f32407f.setText(balanceSection.symbol);
        this.f32408g.setText(balanceSection.value);
        m23004a(balanceSection.menuItems);
    }

    /* renamed from: a */
    private void m23004a(List<WalletPageInfo.BalanceItem> list) {
        this.f32412k.removeAllViews();
        if (list == null || list.size() == 0) {
            this.f32412k.setVisibility(8);
            return;
        }
        this.f32412k.setVisibility(0);
        for (int i = 0; i < list.size(); i++) {
            final WalletPageInfo.BalanceItem balanceItem = list.get(i);
            View inflate = LayoutInflater.from(this.f32403b).inflate(R.layout.wallet_global_v_balance_section_item, (ViewGroup) null, false);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.weight = 1.0f;
            inflate.setLayoutParams(layoutParams);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.ll_balance_entry_image);
            TextView textView = (TextView) inflate.findViewById(R.id.ll_balance_entry_text);
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_sale_tip);
            if (!TextUtils.isEmpty(balanceItem.iconUrl)) {
                GlideUtils.with2load2into(getContext(), balanceItem.iconUrl, imageView);
            }
            if (balanceItem.status == 1) {
                textView.setEnabled(true);
            } else {
                textView.setEnabled(false);
            }
            textView.setText(balanceItem.title);
            if (!TextUtils.isEmpty(balanceItem.promotionText)) {
                textView2.setVisibility(0);
                textView2.setText(balanceItem.promotionText);
            } else {
                textView2.setVisibility(8);
            }
            inflate.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (WalletBalanceSectionView.this.mListener != null && balanceItem.status == 1) {
                        ((IWalletMainListEventListener) WalletBalanceSectionView.this.mListener).onBalanceItemClickEvent(balanceItem);
                    }
                }
            });
            this.f32412k.addView(inflate);
            m23003a(balanceItem, (View) imageView, i, list.size());
        }
    }

    /* renamed from: a */
    private void m23003a(WalletPageInfo.BalanceItem balanceItem, View view, int i, int i2) {
        if (!PaySharedPreferencesUtil.getBoolean(getContext(), f32402a, false) && TextUtils.equals(balanceItem.f32015id, "topup")) {
            m23002a(getContext(), view, i, i2);
        }
    }

    /* renamed from: a */
    private void m23002a(final Context context, View view, int i, int i2) {
        this.f32413l.setVisibility(0);
        this.f32413l.setMoreLineTips(context.getString(R.string.wallet_global_topup_tips));
        this.f32413l.setId(view.hashCode());
        this.f32413l.setCloseListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                PaySharedPreferencesUtil.putBoolean(context, WalletBalanceSectionView.f32402a, true);
            }
        });
        this.f32413l.setPos(1, 2);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f32413l.getLayoutParams();
        marginLayoutParams.leftMargin = ((((i * 2) + 1) * UIUtils.getScreenWidth(getContext())) / (i2 * 2)) - UIUtils.dip2px(getContext(), 25.0f);
        this.f32413l.setLayoutParams(marginLayoutParams);
    }
}
