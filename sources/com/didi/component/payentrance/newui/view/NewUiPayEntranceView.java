package com.didi.component.payentrance.newui.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.component.core.IPresenter;
import com.didi.component.payentrance.model.Jumpable;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.component.payentrance.view.Mode;
import com.didi.unifiedPay.sdk.model.BasicPayInfo;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.didiglobal.travel.infra.view.ViewKt;
import java.util.List;

public class NewUiPayEntranceView implements NewUiIPayEntranceViewContainer {
    protected FrameLayout mContainer;
    protected Context mContext;
    protected INewUIPayEntranceView payEntranceView;

    public Mode getMode() {
        return null;
    }

    public void hide() {
    }

    public void hideError() {
    }

    public void hideLoading() {
    }

    public void setNewCard(boolean z) {
    }

    public void setPresenter(IPresenter iPresenter) {
    }

    public void showError(CharSequence charSequence) {
    }

    public void showLoading() {
    }

    public NewUiPayEntranceView(Context context) {
        this.mContext = context;
        FrameLayout frameLayout = new FrameLayout(context);
        this.mContainer = frameLayout;
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        createViewByMode();
    }

    public void setFeeDescribe(CharSequence charSequence) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setFeeDescribe(charSequence);
        }
    }

    public void setPrice(double d) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setPrice(d);
        }
    }

    public void setPrice(String str) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setPrice(str);
        }
    }

    public void setMessage(CharSequence charSequence) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setMessage(charSequence);
        }
    }

    public void setCouponSupplement(String str, String str2) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setCouponSupplement(str, str2);
        }
    }

    public void addSupplement(DeductionInfo deductionInfo, String str) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.addSupplement(deductionInfo, str);
        }
    }

    public void removeSupplement() {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.removeSupplement();
        }
    }

    public void setCancelRuleShow(boolean z) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setCancelRuleShow(z);
        }
    }

    public void setOnCancelRuleClickListener(IPayEntranceView.OnCancelRuleClickListener onCancelRuleClickListener) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setOnCancelRuleClickListener(onCancelRuleClickListener);
        }
    }

    public void setActionText(String str) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setActionText(str);
        }
    }

    public void setActionButtonEnable(boolean z) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setActionButtonEnable(z);
        }
    }

    public void setOnPayListener(IPayEntranceView.OnPayListener onPayListener) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setOnPayListener(onPayListener);
        }
    }

    public void setIconShow(boolean z) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setIconShow(z);
        }
    }

    public void setJumpableItems(List<Jumpable> list) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setJumpableItems(list);
        }
    }

    public void setOnJumpableClickListener(IPayEntranceView.OnJumpableClickListener onJumpableClickListener) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setOnJumpableClickListener(onJumpableClickListener);
        }
    }

    public void showTipsCheckbox(String str, boolean z, IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.showTipsCheckbox(str, z, onTipsCheckChangeListener);
        }
    }

    public void setMode(Mode mode) {
        m10720a(createViewByMode());
    }

    /* renamed from: a */
    private void m10720a(View view) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
        ViewKt.removeFromParent(view);
        this.mContainer.addView(view, layoutParams);
        if (this.mContainer.getChildCount() > 1) {
            this.mContainer.removeViewAt(0);
        }
    }

    /* access modifiers changed from: protected */
    public View createViewByMode() {
        LayoutInflater from = LayoutInflater.from(this.mContext);
        if (this.payEntranceView == null) {
            this.payEntranceView = new NewUIPayEntranceViewImpl(this.mContext, from, this.mContainer);
        }
        return this.payEntranceView.getView();
    }

    public void setOnErrorListener(IPayEntranceView.OnErrorClickListener onErrorClickListener) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setOnErrorListener(onErrorClickListener);
        }
    }

    public void setInputLabel(CharSequence charSequence) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setInputLabel(charSequence);
        }
    }

    public void setInputHint(CharSequence charSequence) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setInputHint(charSequence);
        }
    }

    public void setOnInputValueChangeListener(IPayEntranceView.OnInputValueChangeListener onInputValueChangeListener) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setOnInputValueChangeListener(onInputValueChangeListener);
        }
    }

    public void setPayWay(String str) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setPayWay(str);
        }
    }

    public void showBindCard(boolean z) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.showBindCard(z);
        }
    }

    public void setOnBindCardClickListener(IPayEntranceView.OnBindCardClickListener onBindCardClickListener) {
        INewUIPayEntranceView iNewUIPayEntranceView = this.payEntranceView;
        if (iNewUIPayEntranceView != null) {
            iNewUIPayEntranceView.setOnBindCardClickListener(onBindCardClickListener);
        }
    }

    public View getView() {
        return this.mContainer;
    }

    public void setTitle(String str) {
        this.payEntranceView.setTitle(str);
    }

    public void setPayInfo(BasicPayInfo basicPayInfo) {
        this.payEntranceView.setPayInfo(basicPayInfo);
    }

    public void setBtnClickable(boolean z) {
        this.payEntranceView.setBtnClickable(z);
    }
}
