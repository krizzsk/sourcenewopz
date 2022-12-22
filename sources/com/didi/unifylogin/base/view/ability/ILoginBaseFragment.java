package com.didi.unifylogin.base.view.ability;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.view.AbsLoginBaseActivity;
import com.didi.unifylogin.base.view.BaseViewUtil;
import com.didi.unifylogin.utils.LoginState;

public interface ILoginBaseFragment extends ILoginBaseView {
    boolean canSlide();

    AbsLoginBaseActivity getBaseActivity();

    FragmentMessenger getMessenger();

    LoginState getNowState();

    void goBack();

    void goJump();

    void hideLoading();

    void initListener();

    View initView(LayoutInflater layoutInflater, ViewGroup viewGroup);

    boolean isAutoSlide();

    boolean isForbidBack();

    boolean isLoginFlow();

    void onFlowFinish(int i);

    void setForbidBack(boolean z);

    void setSubTitle(CharSequence charSequence);

    void setTitle(CharSequence charSequence);

    void setTitleBarCenterMsg(String str);

    void setTitleBarCenterVisible(boolean z);

    void setTitleBarLeftListener(View.OnClickListener onClickListener);

    void setTitleBarLeftVisible(boolean z);

    void setTitleBarRightListener(View.OnClickListener onClickListener);

    void setTitleBarRightText(CharSequence charSequence);

    void setTitleBarRightVisible(boolean z);

    void showError(int i);

    void showError(String str);

    void showInfoDialog(FragmentActivity fragmentActivity, String str, String str2, BaseViewUtil.DialogItem dialogItem, BaseViewUtil.DialogItem dialogItem2, BaseViewUtil.DialogItem dialogItem3);

    void showInfoDialog(String str, String str2, String str3, View.OnClickListener onClickListener);

    void showInfoDialog(String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2);

    void showKeyBoardDelay(View view);

    void showLoading(String str);

    void showLongToast(int i);

    void showLongToast(String str);

    void showShortCompleted(int i);

    void showShortCompleted(String str);

    void showShortError(int i);

    void showShortError(String str);

    void showShortToast(int i);

    void showShortToast(String str);
}
