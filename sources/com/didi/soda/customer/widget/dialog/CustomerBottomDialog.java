package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.soda.customer.animation.CustomerVerticalTransformAnimation;
import com.didi.soda.customer.foundation.skin.SkinUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.MaxHeightScrollView;
import com.didi.soda.customer.widget.dialog.CustomerCommonDialog;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;

public class CustomerBottomDialog extends Dialog implements BottomSheetDialog {
    public static final int ANIMATION_DURATION = 300;

    /* renamed from: a */
    private LinearLayout f41695a;

    /* renamed from: b */
    private DialogBuilder.CustomerDialogModel f41696b;

    /* renamed from: c */
    private Context f41697c;

    /* renamed from: d */
    private IconTextView f41698d;

    /* renamed from: e */
    private TextView f41699e;

    /* renamed from: f */
    private TextView f41700f;

    /* renamed from: g */
    private View.OnClickListener f41701g = new View.OnClickListener() {
        public final void onClick(View view) {
            CustomerBottomDialog.this.m29454b(view);
        }
    };

    public void onDestroy() {
    }

    public void onDismiss() {
    }

    public void onShow() {
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m29454b(View view) {
        dismiss();
    }

    public CustomerBottomDialog(Context context, DialogBuilder.CustomerDialogModel customerDialogModel) {
        this.f41696b = customerDialogModel;
        this.f41697c = context;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.f41695a = (LinearLayout) layoutInflater.inflate(R.layout.customer_dialog_bottom_base, viewGroup, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f41695a.setLayoutParams(layoutParams);
        m29455e();
        return this.f41695a;
    }

    public TransformAnimation getEnterAnimation() {
        return new CustomerVerticalTransformAnimation(300, true, new DecelerateInterpolator());
    }

    public TransformAnimation getExitAnimation() {
        return new CustomerVerticalTransformAnimation(300, true, new DecelerateInterpolator());
    }

    public boolean onHandleBack() {
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f41696b;
        if (!(customerDialogModel == null || customerDialogModel.mOnHandleBackListener == null)) {
            this.f41696b.mOnHandleBackListener.onClick((View) null);
        }
        return super.onHandleBack();
    }

    /* renamed from: e */
    private void m29455e() {
        this.f41698d = (IconTextView) this.f41695a.findViewById(R.id.customer_custom_common_dialog_close);
        CustomerAppCompatTextView customerAppCompatTextView = (CustomerAppCompatTextView) this.f41695a.findViewById(R.id.customer_custom_common_dialog_title);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(customerAppCompatTextView, IToolsService.FontType.MEDIUM);
        View findViewById = this.f41695a.findViewById(R.id.customer_view_dialog_shadow);
        MaxHeightScrollView maxHeightScrollView = (MaxHeightScrollView) this.f41695a.findViewById(R.id.customer_custom_container);
        TextView textView = (TextView) this.f41695a.findViewById(R.id.customer_custom_common_dialog_confirm);
        this.f41699e = textView;
        textView.setTextColor(SkinUtil.getUponBrandPrimaryTextColorStateList());
        this.f41700f = (TextView) this.f41695a.findViewById(R.id.customer_custom_common_dialog_cancle);
        maxHeightScrollView.setMinimumHeight((CustomerSystemUtil.getScreenHeight(this.f41697c) / 4) - ResourceHelper.getDimensionPixelSize(R.dimen.customer_70px));
        maxHeightScrollView.setOnScrollChangeListener(new MaxHeightScrollView.OnScrollChangeListener() {
            public final void onScrollChanged(int i, int i2, int i3, int i4) {
                CustomerBottomDialog.m29451a(View.this, i, i2, i3, i4);
            }
        });
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f41696b;
        if (customerDialogModel != null) {
            setCancelable(customerDialogModel.mCancelable);
            if (!TextUtils.isEmpty(this.f41696b.title)) {
                customerAppCompatTextView.setText(this.f41696b.title);
            }
            m29452a(this.f41699e, this.f41696b.mMainAction);
            m29452a(this.f41700f, this.f41696b.mSubAction1);
            if (this.f41696b.mContentView != null) {
                maxHeightScrollView.addView(this.f41696b.mContentView);
            }
        }
        this.f41698d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CustomerBottomDialog.this.m29450a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m29451a(View view, int i, int i2, int i3, int i4) {
        if (i2 > 0) {
            view.setVisibility(0);
        } else {
            view.setVisibility(4);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29450a(View view) {
        dismiss();
        DialogBuilder.CustomerDialogModel customerDialogModel = this.f41696b;
        if (customerDialogModel != null && customerDialogModel.onCloseListener != null) {
            this.f41696b.onCloseListener.onClick(view);
        }
    }

    /* renamed from: a */
    private void m29452a(TextView textView, CustomerCommonDialog.DialogAction dialogAction) {
        textView.setText(dialogAction.mActionName);
        textView.setVisibility(0);
        if (dialogAction.mListener == null) {
            textView.setOnClickListener(this.f41701g);
        } else {
            textView.setOnClickListener(new View.OnClickListener(dialogAction) {
                public final /* synthetic */ CustomerCommonDialog.DialogAction f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    CustomerBottomDialog.this.m29453a(this.f$1, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m29453a(CustomerCommonDialog.DialogAction dialogAction, View view) {
        if (dialogAction.mIsAutoDismiss) {
            dismiss();
        }
        dialogAction.mListener.onClick(view);
    }
}
