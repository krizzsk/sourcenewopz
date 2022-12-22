package com.didi.payment.wallet.global.wallet.view.fragment;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.wallet.global.model.event.WalletNewBalanceLoadingEvent;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInterestResp;
import com.didi.payment.wallet.global.utils.ColorsUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceInterestContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletNewBalanceInterestPresenter;
import com.didi.payment.wallet.global.wallet.view.view.WalletBalanceIntroductionView;
import com.didi.payment.wallet.global.wallet.view.view.WalletScrollView;
import com.didi.payment.wallet.global.wallet.view.view.WalletSimpleBarChart;
import com.didi.payment.wallet.global.wallet.view.view.WalletSimpleLineChart;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.EventBus;

public class WalletNewBalanceInterestFragment extends Fragment implements View.OnClickListener, WalletNewBalanceInterestContract.View {
    public static final String TYPE_KEY = "FragmentType";
    public static final int TYPE_VALUE_CALLBACK = 1;
    public static final int TYPE_VALUE_INTEREST = 0;

    /* renamed from: a */
    private int f32358a = 0;

    /* renamed from: b */
    private ViewGroup f32359b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WalletScrollView f32360c;

    /* renamed from: d */
    private View f32361d;

    /* renamed from: e */
    private View f32362e;

    /* renamed from: f */
    private ViewGroup f32363f;

    /* renamed from: g */
    private TextView f32364g;

    /* renamed from: h */
    private TextView f32365h;

    /* renamed from: i */
    private TextView f32366i;

    /* renamed from: j */
    private TextView f32367j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public LinearLayout f32368k;

    /* renamed from: l */
    private ArrayList<TextView> f32369l;

    /* renamed from: m */
    private LinearLayout f32370m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ImageView f32371n;

    /* renamed from: o */
    private TextView f32372o;

    /* renamed from: p */
    private WalletSimpleBarChart f32373p;

    /* renamed from: q */
    private WalletSimpleLineChart f32374q;

    /* renamed from: r */
    private WalletBalanceIntroductionView f32375r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public WalletNewBalanceInterestContract.Presenter f32376s;

    /* renamed from: t */
    private String f32377t;

    /* renamed from: u */
    private int f32378u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f32379v;

    /* renamed from: w */
    private FragmentActivity f32380w;

    public void initLoadingDialog(Activity activity) {
    }

    public void releaseLoadingDialog() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f32380w = getActivity();
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f32358a = arguments.getInt(TYPE_KEY, 0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.wallet_global_fragment_new_balance_interest, viewGroup, false);
        m22982a(inflate);
        WalletNewBalanceInterestPresenter walletNewBalanceInterestPresenter = new WalletNewBalanceInterestPresenter(this.f32380w, this);
        this.f32376s = walletNewBalanceInterestPresenter;
        walletNewBalanceInterestPresenter.init();
        return inflate;
    }

    /* renamed from: a */
    private void m22982a(View view) {
        this.f32359b = (ViewGroup) view.findViewById(R.id.fl_wallet_new_balance_interest_container);
        this.f32360c = (WalletScrollView) view.findViewById(R.id.sv_wallet_new_balance_interest_scroll_container);
        this.f32363f = (ViewGroup) view.findViewById(R.id.ll_wallet_new_balance_interest_content);
        this.f32364g = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_day);
        this.f32365h = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_month);
        this.f32366i = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_total);
        this.f32367j = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_amount);
        this.f32372o = (TextView) view.findViewById(R.id.tv_wallet_new_balance_interest_date);
        this.f32373p = (WalletSimpleBarChart) view.findViewById(R.id.bc_wallet_new_balance_interest);
        this.f32374q = (WalletSimpleLineChart) view.findViewById(R.id.lc_wallet_new_balance_interest);
        this.f32368k = (LinearLayout) view.findViewById(R.id.ll_wallet_new_balance_interest_items_container);
        this.f32370m = (LinearLayout) view.findViewById(R.id.ll_view_all);
        this.f32371n = (ImageView) view.findViewById(R.id.iv_view_all);
        this.f32375r = (WalletBalanceIntroductionView) view.findViewById(R.id.ll_introduction_container);
        this.f32364g.setOnClickListener(this);
        this.f32365h.setOnClickListener(this);
        this.f32366i.setOnClickListener(this);
        this.f32373p.setOperationListener(new WalletSimpleBarChart.OperationListener() {
            public void onOperationStart() {
                WalletNewBalanceInterestFragment.this.f32360c.setScrollable(false);
            }

            public void onOperationEnd() {
                WalletNewBalanceInterestFragment.this.f32360c.setScrollable(true);
            }

            public void onOperationVerticalScroll() {
                WalletNewBalanceInterestFragment.this.f32360c.setScrollable(true);
            }
        });
        this.f32374q.setOperationListener(new WalletSimpleLineChart.OperationListener() {
            public void onOperationStart() {
                WalletNewBalanceInterestFragment.this.f32360c.setScrollable(false);
            }

            public void onOperationEnd() {
                WalletNewBalanceInterestFragment.this.f32360c.setScrollable(true);
            }

            public void onOperationVerticalScroll() {
                WalletNewBalanceInterestFragment.this.f32360c.setScrollable(true);
            }
        });
    }

    public void showLoadingDialog() {
        WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent = new WalletNewBalanceLoadingEvent();
        walletNewBalanceLoadingEvent.showLoading = true;
        EventBus.getDefault().post(walletNewBalanceLoadingEvent);
    }

    public void dismissLoadingDialog() {
        WalletNewBalanceLoadingEvent walletNewBalanceLoadingEvent = new WalletNewBalanceLoadingEvent();
        walletNewBalanceLoadingEvent.showLoading = false;
        EventBus.getDefault().post(walletNewBalanceLoadingEvent);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.tv_wallet_new_balance_interest_day) {
            this.f32376s.onInterestDayClicked();
        } else if (view.getId() == R.id.tv_wallet_new_balance_interest_month) {
            this.f32376s.onInterestMonthClicked();
        } else if (view.getId() == R.id.tv_wallet_new_balance_interest_total) {
            this.f32376s.onInterestTotalClicked();
        }
    }

    public void updateMetaData(WalletBalanceInterestResp.MetaInfo metaInfo) {
        this.f32360c.setVisibility(0);
        View view = this.f32361d;
        if (!(view == null || view.getParent() == null)) {
            ((ViewGroup) this.f32361d.getParent()).removeView(this.f32361d);
            this.f32361d = null;
            this.f32363f.setVisibility(0);
        }
        View view2 = this.f32362e;
        if (!(view2 == null || view2.getParent() == null)) {
            ((ViewGroup) this.f32362e.getParent()).removeView(this.f32362e);
            this.f32362e = null;
            this.f32363f.setVisibility(0);
        }
        if (metaInfo != null && !CollectionUtil.isEmpty((Object[]) metaInfo.interestTitles)) {
            this.f32368k.removeAllViews();
            if (this.f32369l == null) {
                this.f32369l = new ArrayList<>();
            }
            this.f32369l.clear();
            int i = 0;
            while (true) {
                int i2 = 8;
                if (i >= metaInfo.interestTitles.length) {
                    break;
                }
                String str = metaInfo.interestTitles[i];
                View inflate = LayoutInflater.from(this.f32380w).inflate(R.layout.wallet_global_new_balance_interest_item, this.f32368k, false);
                if (i < 3) {
                    i2 = 0;
                }
                inflate.setVisibility(i2);
                ((TextView) inflate.findViewById(R.id.tv_wallet_new_balance_interest_left)).setText(str);
                this.f32368k.addView(inflate);
                this.f32369l.add((TextView) inflate.findViewById(R.id.tv_wallet_new_balance_interest_right));
                i++;
            }
            this.f32379v = false;
            if (metaInfo.interestTitles.length > 3) {
                this.f32370m.setVisibility(0);
                this.f32370m.setOnClickListener(m22980a());
            } else {
                this.f32370m.setVisibility(8);
            }
            this.f32377t = metaInfo.symbol != null ? metaInfo.symbol : "";
            this.f32378u = metaInfo.symbolAfterValue;
        }
    }

    /* renamed from: a */
    private View.OnClickListener m22980a() {
        return new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                int i = WalletNewBalanceInterestFragment.this.f32379v ? 8 : 0;
                int childCount = WalletNewBalanceInterestFragment.this.f32368k.getChildCount();
                for (int i2 = 3; i2 < childCount; i2++) {
                    View childAt = WalletNewBalanceInterestFragment.this.f32368k.getChildAt(i2);
                    if (childAt != null) {
                        childAt.setVisibility(i);
                    }
                }
                WalletNewBalanceInterestFragment walletNewBalanceInterestFragment = WalletNewBalanceInterestFragment.this;
                boolean unused = walletNewBalanceInterestFragment.f32379v = !walletNewBalanceInterestFragment.f32379v;
                WalletNewBalanceInterestFragment.this.f32371n.setImageDrawable(WalletNewBalanceInterestFragment.this.getResources().getDrawable(WalletNewBalanceInterestFragment.this.f32379v ? R.drawable.icon_balance_arrow_up : R.drawable.icon_balance_arrow_down));
            }
        };
    }

    public void showChartInDay(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr) {
        m22983a(this.f32364g);
        m22984a(interestInfoArr, strArr, (WalletSimpleBarChart.OnSelectedListener) new WalletSimpleBarChart.OnSelectedListener() {
            public void onSelectedListener(int i) {
                WalletNewBalanceInterestFragment.this.f32376s.onChartItemSelectedInDay(i);
            }
        });
    }

    public void showChartInMonth(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr) {
        m22983a(this.f32365h);
        m22984a(interestInfoArr, strArr, (WalletSimpleBarChart.OnSelectedListener) new WalletSimpleBarChart.OnSelectedListener() {
            public void onSelectedListener(int i) {
                WalletNewBalanceInterestFragment.this.f32376s.onChartItemSelectedInMonth(i);
            }
        });
    }

    /* renamed from: a */
    private void m22984a(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr, WalletSimpleBarChart.OnSelectedListener onSelectedListener) {
        this.f32374q.setVisibility(8);
        if (CollectionUtil.isEmpty((Object[]) interestInfoArr) || CollectionUtil.isEmpty((Object[]) strArr)) {
            this.f32373p.setVisibility(8);
            return;
        }
        this.f32373p.setVisibility(0);
        float[] fArr = new float[interestInfoArr.length];
        for (int i = 0; i < interestInfoArr.length; i++) {
            fArr[i] = (float) interestInfoArr[i].amount;
        }
        this.f32373p.setDataList(fArr, strArr);
        this.f32373p.setOnSelectedListener(onSelectedListener);
    }

    public void showChartInTotal(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr) {
        m22983a(this.f32366i);
        m22985a(interestInfoArr, strArr, (WalletSimpleLineChart.OnSelectedListener) new WalletSimpleLineChart.OnSelectedListener() {
            public void onSelectedListener(int i) {
                WalletNewBalanceInterestFragment.this.f32376s.onChartItemSelectedInTotal(i);
            }
        });
    }

    /* renamed from: a */
    private void m22983a(TextView textView) {
        TextView textView2 = this.f32364g;
        boolean z = true;
        textView2.setSelected(textView == textView2);
        TextView textView3 = this.f32365h;
        textView3.setSelected(textView == textView3);
        TextView textView4 = this.f32366i;
        if (textView != textView4) {
            z = false;
        }
        textView4.setSelected(z);
        TextView textView5 = this.f32364g;
        textView5.setTypeface(textView == textView5 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        TextView textView6 = this.f32365h;
        textView6.setTypeface(textView == textView6 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
        TextView textView7 = this.f32366i;
        textView7.setTypeface(textView == textView7 ? Typeface.DEFAULT_BOLD : Typeface.DEFAULT);
    }

    /* renamed from: a */
    private void m22985a(WalletBalanceInterestResp.InterestInfo[] interestInfoArr, String[] strArr, WalletSimpleLineChart.OnSelectedListener onSelectedListener) {
        this.f32373p.setVisibility(8);
        if (CollectionUtil.isEmpty((Object[]) interestInfoArr) || CollectionUtil.isEmpty((Object[]) strArr)) {
            this.f32374q.setVisibility(8);
            return;
        }
        this.f32374q.setVisibility(0);
        float[] fArr = new float[interestInfoArr.length];
        for (int i = 0; i < interestInfoArr.length; i++) {
            if (interestInfoArr[i].amount > 3.4028234663852886E38d) {
                fArr[i] = Float.MAX_VALUE;
            } else {
                fArr[i] = (float) interestInfoArr[i].amount;
            }
        }
        this.f32374q.setDataList(fArr, strArr);
        this.f32374q.setOnSelectedListener(onSelectedListener);
    }

    public void showInterestInfo(WalletBalanceInterestResp.InterestInfo interestInfo, String str) {
        String str2;
        SpannableStringBuilder spannableStringBuilder;
        if (TextUtil.isEmpty(str)) {
            this.f32372o.setText("");
        } else {
            this.f32372o.setText(str);
        }
        if (interestInfo == null) {
            this.f32367j.setText("");
            this.f32368k.setVisibility(4);
            return;
        }
        char c = interestInfo.amount < 0.0d ? '-' : '+';
        if (this.f32378u == 0) {
            str2 = c + this.f32377t;
        } else {
            str2 = this.f32377t;
        }
        int dip2px = UIUtils.dip2px(this.f32380w, 21.0f);
        SpannableString spannableString = new SpannableString(str2);
        int i = 0;
        spannableString.setSpan(new AbsoluteSizeSpan(dip2px), 0, spannableString.length(), 33);
        String str3 = interestInfo.amountText != null ? interestInfo.amountText : DCryptoMainFragment.DCRYPTO_ZERO;
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        if (this.f32378u == 0) {
            spannableStringBuilder = spannableStringBuilder2.append(spannableString).append(" ").append(str3);
        } else {
            spannableStringBuilder = spannableStringBuilder2.append(c).append(str3).append(" ").append(spannableString);
        }
        this.f32367j.setText(spannableStringBuilder);
        if (interestInfo.amountItems == null || interestInfo.amountItems.length == 0 || this.f32369l.size() == 0) {
            this.f32368k.setVisibility(4);
            return;
        }
        this.f32368k.setVisibility(0);
        while (i < this.f32369l.size() && this.f32369l.get(i) != null) {
            if (i < interestInfo.amountItems.length) {
                this.f32369l.get(i).setText(interestInfo.amountItems[i]);
            } else {
                this.f32369l.get(i).setText("");
            }
            i++;
        }
    }

    public void showErrorPage() {
        View view = this.f32361d;
        if (view != null) {
            view.setVisibility(0);
        } else if (getActivity() != null) {
            View view2 = this.f32362e;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.f32363f.setVisibility(8);
            View inflate = LayoutInflater.from(this.f32380w).inflate(R.layout.wallet_global_activity_balance_item_network_error, this.f32363f, false);
            View findViewById = inflate.findViewById(R.id.ll_account_balance_retry_btn);
            findViewById.setBackground(m22987b());
            findViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletNewBalanceInterestFragment.this.f32376s.requestData();
                }
            });
            this.f32360c.setVisibility(0);
            this.f32363f.setVisibility(8);
            this.f32359b.addView(inflate);
            this.f32361d = inflate;
        }
    }

    /* renamed from: b */
    private Drawable m22987b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) UIUtil.dp2px(40.0f));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{ColorsUtils.parseColor("#FFF366"), ColorsUtils.parseColor("#FFC040")});
        return gradientDrawable;
    }

    public void showEmptyPage(final WalletBalanceInterestResp.MetaInfo metaInfo) {
        View view = this.f32362e;
        if (view != null) {
            view.setVisibility(0);
        } else if (getActivity() != null && metaInfo != null && metaInfo.topupBtn != null) {
            View view2 = this.f32361d;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.f32363f.setVisibility(8);
            View inflate = LayoutInflater.from(this.f32380w).inflate(R.layout.wallet_global_activity_balance_item_empty_view, this.f32363f, false);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_balance_empty);
            if (!TextUtils.isEmpty(metaInfo.topupBtn.notice)) {
                textView.setText(metaInfo.topupBtn.notice);
            }
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_balance_todo);
            if (!TextUtils.isEmpty(metaInfo.topupBtn.text)) {
                textView2.setText(metaInfo.topupBtn.text);
            }
            textView2.setBackground(m22987b());
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    HashMap hashMap = new HashMap();
                    hashMap.put("pub_page", "walletbalance");
                    hashMap.put("button_name", "topup");
                    FinOmegaSDK.trackEvent("fin_walletbalance_button_ck", hashMap);
                    if (!TextUtils.isEmpty(metaInfo.topupBtn.link)) {
                        DRouter.build(metaInfo.topupBtn.link).start(WalletNewBalanceInterestFragment.this.getActivity());
                    }
                }
            });
            this.f32360c.setVisibility(0);
            this.f32363f.setVisibility(8);
            this.f32359b.addView(inflate);
            this.f32362e = inflate;
        }
    }

    public void showIntroduction(WalletBalanceInterestResp.MetaInfo metaInfo) {
        if (metaInfo == null) {
            this.f32375r.setVisibility(8);
            return;
        }
        this.f32375r.setVisibility(0);
        this.f32375r.updateContent(metaInfo.introductionTitle, metaInfo.introductions);
    }

    public int getType() {
        return this.f32358a;
    }
}
