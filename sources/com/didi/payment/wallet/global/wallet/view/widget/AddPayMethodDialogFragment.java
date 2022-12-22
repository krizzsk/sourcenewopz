package com.didi.payment.wallet.global.wallet.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.payment.wallet.global.wallet.view.view.helper.WalletLineViewHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class AddPayMethodDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private TextView f32811a;

    /* renamed from: b */
    private ImageView f32812b;

    /* renamed from: c */
    private LinearLayout f32813c;

    /* renamed from: d */
    private Context f32814d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AddPayMethodDialogListener f32815e;

    /* renamed from: f */
    private WalletPageInfo.AddPayMethodEntryDialogInfo f32816f;

    public interface AddPayMethodDialogListener {
        void onClose();

        void onItemClick(WalletPageInfo.AddPayMethodEntryDialogItem addPayMethodEntryDialogItem);

        void onShow();
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.wallet_global_dialog_add_paymethod;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f32814d = getContext();
        this.f32811a = (TextView) this.mRootView.findViewById(R.id.tv_title);
        this.f32813c = (LinearLayout) this.mRootView.findViewById(R.id.ll_paymethod_entry_container);
        ImageView imageView = (ImageView) this.mRootView.findViewById(R.id.iv_close);
        this.f32812b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddPayMethodDialogFragment.this.dismissAllowingStateLoss();
                if (AddPayMethodDialogFragment.this.f32815e != null) {
                    AddPayMethodDialogFragment.this.f32815e.onClose();
                }
            }
        });
        m23159a(this.f32816f);
        AddPayMethodDialogListener addPayMethodDialogListener = this.f32815e;
        if (addPayMethodDialogListener != null) {
            addPayMethodDialogListener.onShow();
        }
    }

    public void setAddPayMethodListener(AddPayMethodDialogListener addPayMethodDialogListener) {
        this.f32815e = addPayMethodDialogListener;
    }

    public void setData(WalletPageInfo.AddPayMethodEntryDialogInfo addPayMethodEntryDialogInfo) {
        this.f32816f = addPayMethodEntryDialogInfo;
    }

    /* renamed from: a */
    private void m23159a(WalletPageInfo.AddPayMethodEntryDialogInfo addPayMethodEntryDialogInfo) {
        if (addPayMethodEntryDialogInfo != null && addPayMethodEntryDialogInfo.signEntries != null) {
            this.f32811a.setText(addPayMethodEntryDialogInfo.title);
            this.f32813c.removeAllViews();
            for (int i = 0; i < addPayMethodEntryDialogInfo.signEntries.size(); i++) {
                final WalletPageInfo.AddPayMethodEntryDialogItem addPayMethodEntryDialogItem = addPayMethodEntryDialogInfo.signEntries.get(i);
                View inflate = LayoutInflater.from(this.f32814d).inflate(R.layout.wallet_global_v_paymethod_section_item, (ViewGroup) null, false);
                TextView textView = (TextView) inflate.findViewById(R.id.tv_paymethod_desc);
                GlideUtils.with2load2into(getContext(), addPayMethodEntryDialogItem.iconUrl, (ImageView) inflate.findViewById(R.id.iv_paymethod_icon));
                ((TextView) inflate.findViewById(R.id.tv_paymethod_name)).setText(addPayMethodEntryDialogItem.name);
                if (TextUtils.isEmpty(addPayMethodEntryDialogItem.desc)) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(addPayMethodEntryDialogItem.desc);
                }
                inflate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        AddPayMethodDialogFragment.this.dismissAllowingStateLoss();
                        if (AddPayMethodDialogFragment.this.f32815e != null) {
                            AddPayMethodDialogFragment.this.f32815e.onItemClick(addPayMethodEntryDialogItem);
                        }
                    }
                });
                this.f32813c.addView(inflate);
                if (i != addPayMethodEntryDialogInfo.signEntries.size() - 1) {
                    WalletLineViewHelper.addLeftMarginLineView(this.f32814d, this.f32813c);
                }
            }
        }
    }
}
