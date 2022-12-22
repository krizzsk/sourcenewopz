package com.didi.payment.wallet.global.wallet.view.adapter;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.widget.CommonEditText;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.creditcard.global.utils.InputTools;
import com.didi.payment.wallet.global.model.resp.WalletTopUpAmountItemsResp;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletTopUpAdapter extends RecyclerView.Adapter<BaseAmountHolder> implements View.OnClickListener {

    /* renamed from: a */
    private static final int f32334a = 1;

    /* renamed from: b */
    private static final int f32335b = 2;

    /* renamed from: c */
    private final List<WalletTopUpAmountItemsResp.TopupItem> f32336c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final OnAmountClickListener f32337d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final OnCustomerAmountChangeListener f32338e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Context f32339f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextWatcher f32340g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f32341h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TrackOmegaCallback f32342i;

    public interface OnAmountClickListener {
        void onClick(WalletTopUpAmountItemsResp.TopupItem topupItem, String str);
    }

    public interface OnCustomerAmountChangeListener {
        void onChange(double d);
    }

    public interface TrackOmegaCallback {
        void onTrackOmega(int i);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
    }

    public void setTrackOmegaCallback(TrackOmegaCallback trackOmegaCallback) {
        this.f32342i = trackOmegaCallback;
    }

    public WalletTopUpAdapter(Context context, List<WalletTopUpAmountItemsResp.TopupItem> list, String str, OnAmountClickListener onAmountClickListener, OnCustomerAmountChangeListener onCustomerAmountChangeListener) {
        ArrayList arrayList = new ArrayList();
        this.f32336c = arrayList;
        if (list != null) {
            arrayList.addAll(list);
        }
        this.f32341h = str;
        this.f32337d = onAmountClickListener;
        this.f32338e = onCustomerAmountChangeListener;
        this.f32339f = context;
    }

    public void refreshSelectAmount(WalletTopUpAmountItemsResp.TopupItem topupItem) {
        Iterator<WalletTopUpAmountItemsResp.TopupItem> it = this.f32336c.iterator();
        while (it.hasNext()) {
            WalletTopUpAmountItemsResp.TopupItem next = it.next();
            boolean z = true;
            next.selected = next == topupItem;
            if (next != topupItem || TextUtils.isEmpty(topupItem.customer)) {
                z = false;
            }
            next.isInput = z;
        }
        notifyDataSetChanged();
    }

    public void refreshCustomerAmountUnInputStatus() {
        for (WalletTopUpAmountItemsResp.TopupItem topupItem : this.f32336c) {
            topupItem.isInput = false;
        }
        notifyDataSetChanged();
    }

    public WalletTopUpAmountItemsResp.TopupItem getCurrentSelectItem() {
        for (WalletTopUpAmountItemsResp.TopupItem next : this.f32336c) {
            if (next.selected) {
                return next;
            }
        }
        return null;
    }

    public BaseAmountHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2) {
            return new AmountCustomerInputHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_v_topup_amount_customer_item, viewGroup, false));
        }
        return new AmountHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_global_v_topup_amount_item, viewGroup, false));
    }

    public void onBindViewHolder(BaseAmountHolder baseAmountHolder, int i) {
        baseAmountHolder.bind(this.f32336c.get(i));
    }

    public int getItemViewType(int i) {
        return this.f32336c.get(i).isInput ? 2 : 1;
    }

    public int getItemCount() {
        return this.f32336c.size();
    }

    abstract class BaseAmountHolder extends RecyclerView.ViewHolder {
        private View mVSelected;

        /* access modifiers changed from: package-private */
        public abstract void updateUI(WalletTopUpAmountItemsResp.TopupItem topupItem);

        public BaseAmountHolder(View view) {
            super(view);
            this.mVSelected = view.findViewById(R.id.v_selected);
        }

        public void bind(final WalletTopUpAmountItemsResp.TopupItem topupItem) {
            if (topupItem.selected) {
                this.mVSelected.setVisibility(0);
            } else {
                this.mVSelected.setVisibility(8);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!topupItem.isInput) {
                        InputTools.hideKeyboard(BaseAmountHolder.this.itemView);
                    }
                    if (WalletTopUpAdapter.this.f32337d != null) {
                        WalletTopUpAdapter.this.f32337d.onClick(topupItem, WalletTopUpAdapter.this.f32341h);
                    }
                }
            });
            updateUI(topupItem);
        }
    }

    public class AmountHolder extends BaseAmountHolder {
        private View mShadowView;
        private TextView mTvDesc;
        private TextView mTvExtra;
        private TextView mTvName;

        public /* bridge */ /* synthetic */ void bind(WalletTopUpAmountItemsResp.TopupItem topupItem) {
            super.bind(topupItem);
        }

        public AmountHolder(View view) {
            super(view);
            this.mTvName = (TextView) view.findViewById(R.id.tv_name);
            this.mTvDesc = (TextView) view.findViewById(R.id.tv_desc);
            this.mTvExtra = (TextView) view.findViewById(R.id.tv_extra);
            this.mShadowView = view.findViewById(R.id.view_shadow);
        }

        /* access modifiers changed from: package-private */
        public void updateUI(WalletTopUpAmountItemsResp.TopupItem topupItem) {
            if (!TextUtils.isEmpty(topupItem.name) || TextUtils.isEmpty(topupItem.customer)) {
                if (TextUtils.isEmpty(topupItem.extraInfo)) {
                    this.mTvExtra.setVisibility(8);
                    this.mTvDesc.setVisibility(8);
                    this.mTvName.setText(WalletTopUpAdapter.this.m22956a(topupItem.name, false, topupItem.isDisable()));
                } else {
                    this.mTvDesc.setVisibility(0);
                    this.mTvExtra.setVisibility(0);
                    this.mTvName.setText(WalletTopUpAdapter.this.m22956a(topupItem.name, false, topupItem.isDisable()));
                    this.mTvDesc.setText(WalletTopUpAdapter.this.m22956a(topupItem.desc, false, topupItem.isDisable()));
                    this.mTvExtra.setText(WalletTopUpAdapter.this.m22955a(topupItem.extraInfo));
                }
                if (topupItem.isDisable()) {
                    this.mShadowView.setVisibility(0);
                } else {
                    this.mShadowView.setVisibility(8);
                }
            } else {
                this.mTvDesc.setVisibility(8);
                this.mTvExtra.setVisibility(8);
                this.mTvName.setText(topupItem.customer);
            }
        }
    }

    class AmountCustomerInputHolder extends BaseAmountHolder {
        /* access modifiers changed from: private */
        public CommonEditText mEtCustomer;
        /* access modifiers changed from: private */
        public TextView mTvHint;

        public AmountCustomerInputHolder(View view) {
            super(view);
            this.mTvHint = (TextView) view.findViewById(R.id.tv_hint);
            CommonEditText commonEditText = (CommonEditText) view.findViewById(R.id.et_customer);
            this.mEtCustomer = commonEditText;
            commonEditText.setGravity(8388627);
        }

        /* access modifiers changed from: package-private */
        public void updateUI(final WalletTopUpAmountItemsResp.TopupItem topupItem) {
            if (WalletTopUpAdapter.this.f32340g != null) {
                this.mEtCustomer.removeTextChangedListener(WalletTopUpAdapter.this.f32340g);
            }
            this.mEtCustomer.addTextChangedListener(WalletTopUpAdapter.this.f32340g = new TextWatcher() {
                boolean isTracked = false;

                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    String obj = AmountCustomerInputHolder.this.mEtCustomer.getText().toString();
                    AmountCustomerInputHolder.this.mTvHint.setVisibility(TextUtils.isEmpty(obj) ? 0 : 8);
                    if (!TextUtils.isEmpty(obj)) {
                        WalletTopUpAmountItemsResp.TopupItem topupItem = topupItem;
                        topupItem.name = "/" + topupItem.currency + "/" + obj;
                        topupItem.price = obj;
                    } else {
                        topupItem.name = "";
                        topupItem.price = "";
                    }
                    if (WalletTopUpAdapter.this.f32338e != null) {
                        WalletTopUpAdapter.this.f32338e.onChange((double) WalletTopUpAdapter.this.convertStringToInt(topupItem.price));
                    }
                    if (!this.isTracked && WalletTopUpAdapter.this.f32342i != null) {
                        WalletTopUpAdapter.this.f32342i.onTrackOmega(4);
                        this.isTracked = true;
                    }
                }
            });
            TextView textView = this.mTvHint;
            textView.setText(WalletTopUpAdapter.this.convertStringToInt(topupItem.minPrice) + "-" + WalletTopUpAdapter.this.convertStringToInt(topupItem.maxPrice));
            this.mEtCustomer.setOnKeyboardListener(new CommonEditText.KeyboardListener() {
                public void onStateChanged(CommonEditText commonEditText, boolean z) {
                    if (!z) {
                        WalletTopUpAdapter.this.refreshCustomerAmountUnInputStatus();
                    }
                }
            });
            C113253 r0 = new InputFilter() {
                public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                    try {
                        String str = spanned.toString().substring(0, i3) + charSequence + spanned.toString().substring(i4, spanned.length());
                        if (TextUtils.isEmpty(str)) {
                            return null;
                        }
                        int parseInt = Integer.parseInt(str);
                        if (parseInt <= WalletTopUpAdapter.this.convertStringToInt(topupItem.maxPrice) && parseInt >= WalletTopUpAdapter.this.convertStringToInt(topupItem.minPrice)) {
                            return null;
                        }
                        WalletToastNew.showFailedMsg(WalletTopUpAdapter.this.f32339f, WalletTopUpAdapter.this.f32339f.getString(R.string.wallet_toast_amount_error));
                        if (WalletTopUpAdapter.this.f32342i != null) {
                            WalletTopUpAdapter.this.f32342i.onTrackOmega(5);
                        }
                        return "";
                    } catch (Exception unused) {
                    }
                }
            };
            this.mEtCustomer.setFilters(new InputFilter[]{r0});
            if (TextUtils.isEmpty(topupItem.name)) {
                this.mTvHint.setVisibility(0);
            } else {
                this.mEtCustomer.setText(String.valueOf(topupItem.price));
            }
            this.mEtCustomer.requestFocus();
            this.mEtCustomer.post(new Runnable() {
                public void run() {
                    InputTools.showKeyboard(AmountCustomerInputHolder.this.mEtCustomer);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public SpannableStringBuilder m22956a(String str, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableStringBuilder("");
        }
        String[] split = str.split("/");
        if (split.length != 3) {
            return new SpannableStringBuilder(str);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f32339f, 21.0f));
        spannableStringBuilder.append(split[0] + " ");
        spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 34);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f32339f, 21.0f));
        spannableStringBuilder.append(split[1]);
        spannableStringBuilder.setSpan(absoluteSizeSpan2, split[0].length() + 1, spannableStringBuilder.length(), 34);
        AbsoluteSizeSpan absoluteSizeSpan3 = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f32339f, 28.0f));
        spannableStringBuilder.append(split[2]);
        spannableStringBuilder.setSpan(absoluteSizeSpan3, split[0].length() + split[1].length() + 1, spannableStringBuilder.length(), 34);
        int color = this.f32339f.getResources().getColor(R.color.wallet_color_333333);
        if (z2) {
            color = this.f32339f.getResources().getColor(R.color.wallet_color_D4D7D9);
        } else if (z) {
            color = Color.parseColor("#ff6f2f");
        }
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        if (z) {
            spannableStringBuilder.setSpan(foregroundColorSpan, split[0].length() + split[1].length() + 1, spannableStringBuilder.length(), 34);
        } else {
            spannableStringBuilder.setSpan(foregroundColorSpan, split[0].length() + 1, spannableStringBuilder.length(), 34);
        }
        return spannableStringBuilder;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public SpannableStringBuilder m22955a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new SpannableStringBuilder("");
        }
        String[] split = str.split("/");
        if (split.length != 2) {
            return new SpannableStringBuilder(str);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f32339f, 11.0f));
        spannableStringBuilder.append(split[0]);
        spannableStringBuilder.setSpan(absoluteSizeSpan, 0, spannableStringBuilder.length(), 34);
        spannableStringBuilder.append("\n");
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(PaymentTextUtil.dip2px(this.f32339f, 9.0f));
        spannableStringBuilder.append(split[1]);
        spannableStringBuilder.setSpan(absoluteSizeSpan2, split[0].length(), spannableStringBuilder.length(), 34);
        return spannableStringBuilder;
    }

    public int convertStringToInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.contains(",")) {
            str = str.substring(0, str.indexOf(","));
        } else if (str.contains(".")) {
            str = str.substring(0, str.indexOf("."));
        }
        return Integer.valueOf(str).intValue();
    }
}
