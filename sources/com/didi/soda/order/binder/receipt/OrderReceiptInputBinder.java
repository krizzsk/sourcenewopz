package com.didi.soda.order.binder.receipt;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.soda.customer.base.binder.ComponentLogicUnit;
import com.didi.soda.customer.base.binder.logic.BinderLogic;
import com.didi.soda.customer.base.binder.logic.CustomerLogicItemBinder;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerEditTextCompat;
import com.didi.soda.customer.widget.text.IconTextView;
import com.didi.soda.order.binder.receipt.OrderReceiptInputBinder;
import com.didi.soda.order.binder.receipt.OrderReceiptInputLogicRepo;
import com.didi.soda.order.model.OrderReceiptInputRvModel;
import com.taxis99.R;

public abstract class OrderReceiptInputBinder extends CustomerLogicItemBinder<OrderReceiptInputBinderLogicImpl, OrderReceiptInputRvModel, ViewHolder> {
    private ScopeContext mScopeContext;

    public static abstract class AbsOrderReceiptInputBinderLogic extends BinderLogic<OrderReceiptInputLogicRepo> {
        public abstract void onMailClicked();

        public abstract void onNameChanged(CharSequence charSequence);
    }

    public abstract void onBind(View view);

    public class ViewHolder_ViewBinding implements Unbinder {
        private ViewHolder target;

        public ViewHolder_ViewBinding(ViewHolder viewHolder, View view) {
            this.target = viewHolder;
            viewHolder.mNameInput = (CustomerEditTextCompat) Utils.findRequiredViewAsType(view, R.id.customer_custom_name_input, "field 'mNameInput'", CustomerEditTextCompat.class);
            viewHolder.mNameCancelIv = (ImageView) Utils.findRequiredViewAsType(view, R.id.customer_iv_email_cancel, "field 'mNameCancelIv'", ImageView.class);
            viewHolder.mNameErrorTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_receipt_name_error, "field 'mNameErrorTv'", TextView.class);
            viewHolder.mEmailInput = (CustomerEditTextCompat) Utils.findRequiredViewAsType(view, R.id.customer_custom_email_input, "field 'mEmailInput'", CustomerEditTextCompat.class);
            viewHolder.mGoVerifyTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_receipt_go_verify, "field 'mGoVerifyTv'", TextView.class);
            viewHolder.mGoTv = (IconTextView) Utils.findRequiredViewAsType(view, R.id.customer_custom_go, "field 'mGoTv'", IconTextView.class);
            viewHolder.mMailErrorTv = (TextView) Utils.findRequiredViewAsType(view, R.id.customer_receipt_mail_error, "field 'mMailErrorTv'", TextView.class);
            viewHolder.mNameLine = Utils.findRequiredView(view, R.id.customer_view_name_line, "field 'mNameLine'");
            viewHolder.mMailLine = Utils.findRequiredView(view, R.id.customer_view_mail_line, "field 'mMailLine'");
        }

        public void unbind() {
            ViewHolder viewHolder = this.target;
            if (viewHolder != null) {
                this.target = null;
                viewHolder.mNameInput = null;
                viewHolder.mNameCancelIv = null;
                viewHolder.mNameErrorTv = null;
                viewHolder.mEmailInput = null;
                viewHolder.mGoVerifyTv = null;
                viewHolder.mGoTv = null;
                viewHolder.mMailErrorTv = null;
                viewHolder.mNameLine = null;
                viewHolder.mMailLine = null;
                return;
            }
            throw new IllegalStateException("Bindings already cleared.");
        }
    }

    public OrderReceiptInputBinder(ScopeContext scopeContext, ComponentLogicUnit componentLogicUnit) {
        super(componentLogicUnit);
        this.mScopeContext = scopeContext;
    }

    public OrderReceiptInputBinderLogicImpl onCreateBinderLogic() {
        return new OrderReceiptInputBinderLogicImpl();
    }

    public ViewHolder create(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_binder_receipt_input, viewGroup, false));
    }

    public void bind(final ViewHolder viewHolder, OrderReceiptInputRvModel orderReceiptInputRvModel) {
        $$Lambda$OrderReceiptInputBinder$s5paCTxhTOcDyHkkZ3oJCq6AGg r0 = new View.OnClickListener() {
            public final void onClick(View view) {
                OrderReceiptInputBinder.this.lambda$bind$0$OrderReceiptInputBinder(view);
            }
        };
        setNameTextStyle(viewHolder, orderReceiptInputRvModel.receiptName);
        viewHolder.mNameInput.setText(orderReceiptInputRvModel.receiptName);
        viewHolder.mNameCancelIv.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderReceiptInputBinder.ViewHolder.this.mNameInput.setText("");
            }
        });
        viewHolder.mEmailInput.setText(orderReceiptInputRvModel.receiptMail);
        viewHolder.mEmailInput.setOnClickListener(r0);
        viewHolder.mGoTv.setOnClickListener(r0);
        if (orderReceiptInputRvModel.mailVerified) {
            viewHolder.mGoVerifyTv.setVisibility(8);
            viewHolder.mGoVerifyTv.setOnClickListener((View.OnClickListener) null);
        } else {
            viewHolder.mGoVerifyTv.setVisibility(0);
            viewHolder.mGoVerifyTv.setOnClickListener(r0);
        }
        viewHolder.mNameInput.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (TextUtils.isEmpty(charSequence)) {
                    viewHolder.mNameCancelIv.setVisibility(8);
                } else {
                    viewHolder.mNameCancelIv.setVisibility(0);
                }
                OrderReceiptInputBinder.this.setNameTextStyle(viewHolder, charSequence);
                ((OrderReceiptInputBinderLogicImpl) OrderReceiptInputBinder.this.getBinderLogic()).onNameChanged(charSequence);
            }
        });
        viewHolder.mNameInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                OrderReceiptInputBinder.lambda$bind$2(OrderReceiptInputBinder.ViewHolder.this, view, z);
            }
        });
        if (!orderReceiptInputRvModel.mIsOrderFinished || orderReceiptInputRvModel.mailVerified) {
            viewHolder.mMailErrorTv.setVisibility(4);
        } else {
            viewHolder.mMailErrorTv.setTextColor(ResourceHelper.getColor(R.color.rf_color_gery_3_60_999999));
            viewHolder.mMailErrorTv.setText(ResourceHelper.getString(R.string.customer_receipt_tip_finished));
            viewHolder.mMailErrorTv.setVisibility(0);
        }
        ((OrderReceiptInputLogicRepo) ((OrderReceiptInputBinderLogicImpl) getBinderLogic()).getLogicRepo()).subscribe(this.mScopeContext, new Action1() {
            public final void call(Object obj) {
                OrderReceiptInputBinder.lambda$bind$3(OrderReceiptInputBinder.ViewHolder.this, (OrderReceiptInputLogicRepo.ReceiptInputLogicModel) obj);
            }
        });
        onBind(viewHolder.mNameInput);
    }

    public /* synthetic */ void lambda$bind$0$OrderReceiptInputBinder(View view) {
        ((OrderReceiptInputBinderLogicImpl) getBinderLogic()).onMailClicked();
    }

    static /* synthetic */ void lambda$bind$2(ViewHolder viewHolder, View view, boolean z) {
        if (!z) {
            viewHolder.mNameCancelIv.setVisibility(4);
        } else if (!TextUtils.isEmpty(viewHolder.mNameInput.getText())) {
            viewHolder.mNameCancelIv.setVisibility(0);
        } else {
            viewHolder.mNameCancelIv.setVisibility(4);
        }
    }

    static /* synthetic */ void lambda$bind$3(ViewHolder viewHolder, OrderReceiptInputLogicRepo.ReceiptInputLogicModel receiptInputLogicModel) {
        if (receiptInputLogicModel != null && receiptInputLogicModel.logicType == 100) {
            if (receiptInputLogicModel.isNameValid) {
                viewHolder.mNameErrorTv.setVisibility(4);
                viewHolder.mNameLine.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
            } else {
                viewHolder.mNameErrorTv.setVisibility(0);
                viewHolder.mNameLine.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_alert_red_100_FF4E45));
            }
            if (receiptInputLogicModel.isMailValid) {
                viewHolder.mMailErrorTv.setVisibility(4);
                viewHolder.mMailLine.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
                return;
            }
            viewHolder.mMailErrorTv.setVisibility(0);
            viewHolder.mMailErrorTv.setText(ResourceHelper.getString(R.string.customer_receipt_mail_not_verified));
            viewHolder.mMailErrorTv.setTextColor(ResourceHelper.getColor(R.color.rf_color_alert_red_100_FF4E45));
            viewHolder.mMailLine.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_alert_red_100_FF4E45));
        }
    }

    public Class<OrderReceiptInputRvModel> bindDataType() {
        return OrderReceiptInputRvModel.class;
    }

    /* access modifiers changed from: private */
    public void setNameTextStyle(ViewHolder viewHolder, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mNameInput, IToolsService.FontType.NORMAL);
            return;
        }
        viewHolder.mNameErrorTv.setVisibility(4);
        viewHolder.mNameLine.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(viewHolder.mNameInput, IToolsService.FontType.MEDIUM);
    }

    public static class OrderReceiptInputBinderLogicImpl extends AbsOrderReceiptInputBinderLogic {
        public Class<OrderReceiptInputLogicRepo> bindLogicRepoType() {
            return OrderReceiptInputLogicRepo.class;
        }

        public void onMailClicked() {
            ((OrderReceiptInputLogicRepo) getLogicRepo()).setValue(OrderReceiptInputLogicRepo.ReceiptInputLogicModel.newMailClickedModel());
        }

        public void onNameChanged(CharSequence charSequence) {
            ((OrderReceiptInputLogicRepo) getLogicRepo()).setValue(OrderReceiptInputLogicRepo.ReceiptInputLogicModel.newNameChangedModel(charSequence));
        }
    }

    public static class ViewHolder extends ItemViewHolder<OrderReceiptInputRvModel> {
        @BindView(17971)
        CustomerEditTextCompat mEmailInput;
        @BindView(17979)
        IconTextView mGoTv;
        @BindView(18611)
        TextView mGoVerifyTv;
        @BindView(18612)
        TextView mMailErrorTv;
        @BindView(19234)
        View mMailLine;
        @BindView(18397)
        ImageView mNameCancelIv;
        @BindView(18613)
        TextView mNameErrorTv;
        @BindView(18009)
        CustomerEditTextCompat mNameInput;
        @BindView(19236)
        View mNameLine;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind((Object) this, view);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mEmailInput, IToolsService.FontType.MEDIUM);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mNameErrorTv, IToolsService.FontType.LIGHT);
            ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.mMailErrorTv, IToolsService.FontType.LIGHT);
        }
    }
}
