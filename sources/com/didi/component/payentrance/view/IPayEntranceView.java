package com.didi.component.payentrance.view;

import android.view.View;
import com.didi.component.core.IView;
import com.didi.component.payentrance.model.Jumpable;
import com.didi.component.payentrance.model.JumpableItem;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import java.util.List;

public interface IPayEntranceView extends IView {

    public interface OnBindCardClickListener {
        void onClick(View view);
    }

    public interface OnCancelRuleClickListener {
        void onCancelRuleClick();
    }

    public interface OnErrorClickListener {
        void onErrorClick();
    }

    public interface OnInputValueChangeListener {
        void onInputValueChanged(double d);
    }

    public interface OnJumpableClickListener {
        void onItemClick(JumpableItem jumpableItem);
    }

    public interface OnPayListener {
        void onPayClick(Mode mode, double d, double d2);
    }

    public interface OnTipsCheckChangeListener {
        void onTipsCheckChanged(boolean z);
    }

    void addSupplement(DeductionInfo deductionInfo, String str);

    Mode getMode();

    void hideError();

    void hideLoading();

    void removeSupplement();

    void setActionButtonEnable(boolean z);

    void setActionText(String str);

    void setCancelRuleShow(boolean z);

    void setCouponSupplement(String str, String str2);

    void setFeeDescribe(CharSequence charSequence);

    void setIconShow(boolean z);

    void setInputHint(CharSequence charSequence);

    void setInputLabel(CharSequence charSequence);

    void setJumpableItems(List<Jumpable> list);

    void setMessage(CharSequence charSequence);

    void setMode(Mode mode);

    void setOnBindCardClickListener(OnBindCardClickListener onBindCardClickListener);

    void setOnCancelRuleClickListener(OnCancelRuleClickListener onCancelRuleClickListener);

    void setOnErrorListener(OnErrorClickListener onErrorClickListener);

    void setOnInputValueChangeListener(OnInputValueChangeListener onInputValueChangeListener);

    void setOnJumpableClickListener(OnJumpableClickListener onJumpableClickListener);

    void setOnPayListener(OnPayListener onPayListener);

    void setPayWay(String str);

    void setPrice(double d);

    void setPrice(String str);

    void showBindCard(boolean z);

    void showError(CharSequence charSequence);

    void showLoading();

    void showTipsCheckbox(String str, boolean z, OnTipsCheckChangeListener onTipsCheckChangeListener);
}
