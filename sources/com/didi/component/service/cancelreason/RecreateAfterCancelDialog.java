package com.didi.component.service.cancelreason;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.service.cancelreason.model.CRListModel;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.travel.psnger.model.response.CancelReasonInfo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.Iterator;

public class RecreateAfterCancelDialog extends SimplePopupBase {

    /* renamed from: a */
    private static final String f15738a = "key_operations";

    /* renamed from: b */
    private static final String f15739b = "key_model";

    /* renamed from: c */
    private TextView f15740c;

    /* renamed from: d */
    private TextView f15741d;

    /* renamed from: e */
    private TextView f15742e;

    /* renamed from: f */
    private TextView f15743f;

    /* renamed from: g */
    private CancelReasonInfo.CancelReasonOperation f15744g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public CRListModel f15745h;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_recreate_after_cancel_dialog;
    }

    public static RecreateAfterCancelDialog getInstance(CancelReasonInfo.CancelReasonOperation cancelReasonOperation, CRListModel cRListModel) {
        RecreateAfterCancelDialog recreateAfterCancelDialog = new RecreateAfterCancelDialog();
        Bundle bundle = new Bundle();
        bundle.putSerializable(f15738a, cancelReasonOperation);
        bundle.putSerializable(f15739b, cRListModel);
        recreateAfterCancelDialog.setArguments(bundle);
        return recreateAfterCancelDialog;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f15744g = (CancelReasonInfo.CancelReasonOperation) getArguments().get(f15738a);
            this.f15745h = (CRListModel) getArguments().get(f15739b);
        }
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f15740c = (TextView) this.mRootView.findViewById(R.id.tv_recreate_order_title);
        this.f15741d = (TextView) this.mRootView.findViewById(R.id.tv_recreate_order_content);
        this.f15742e = (TextView) this.mRootView.findViewById(R.id.tv_recreate_order_pos);
        this.f15743f = (TextView) this.mRootView.findViewById(R.id.tv_recreate_order_neg);
        try {
            this.f15740c.setText(this.f15744g.btn_title);
            if (!TextUtils.isEmpty(this.f15744g.btn_context)) {
                this.f15741d.setVisibility(0);
                this.f15741d.setText(this.f15744g.btn_context);
            }
            Iterator<CancelReasonInfo.CancelReasonBtn> it = this.f15744g.btn_list.iterator();
            while (it.hasNext()) {
                CancelReasonInfo.CancelReasonBtn next = it.next();
                if (next.btn_type == 1) {
                    this.f15742e.setText(next.title);
                } else {
                    this.f15743f.setText(next.title);
                }
            }
        } catch (Exception unused) {
            Context context = this.mRootView.getContext();
            if (context != null) {
                this.f15740c.setText(context.getResources().getString(R.string.global_cancel_reason_dialog_title));
                this.f15742e.setText(context.getResources().getString(R.string.global_cancel_reason_dialog_pos_btn));
                this.f15743f.setText(context.getResources().getString(R.string.global_cancel_reason_dialog_neg_btn));
            }
        }
        this.f15742e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = true;
                if (RecreateAfterCancelDialog.this.f15745h.reason_type != 1) {
                    z = false;
                }
                BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.CancelOrder.EVENT_CANCEL_REASON_SUBMIT_SKIP, Boolean.valueOf(z));
                OmegaSDKAdapter.trackEvent("gp_cancelreason_panel_request_ck");
                RecreateAfterCancelDialog.this.dismiss();
                if (RecreateAfterCancelDialog.this.getActivity() != null) {
                    RecreateAfterCancelDialog.this.getActivity().finish();
                }
            }
        });
        this.f15743f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaSDKAdapter.trackEvent("gp_cancelreason_panel_norequest_ck");
                RecreateAfterCancelDialog.this.dismiss();
                if (RecreateAfterCancelDialog.this.getActivity() != null) {
                    RecreateAfterCancelDialog.this.getActivity().finish();
                }
            }
        });
        setCancelable(false);
    }
}
