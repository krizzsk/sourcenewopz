package com.didi.unifylogin.base.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.base.presenter.ILoginBasePresenter;
import com.didi.unifylogin.base.view.BaseViewUtil;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.KeyboardHelper;
import com.didi.unifylogin.utils.LoginLayoutChangeListener;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.customview.AbsLoginTitleBar;
import com.taxis99.R;
import java.util.HashMap;

public abstract class AbsLoginBaseFragment<P extends ILoginBasePresenter> extends Fragment implements ILoginBaseFragment {
    /* access modifiers changed from: protected */
    public String TAG = getClass().getSimpleName();
    protected AbsLoginBaseActivity baseActivity;
    protected View contentView;
    /* access modifiers changed from: protected */
    public Context context;
    /* access modifiers changed from: protected */
    public FragmentMessenger messenger;
    protected LoginScene preScene;
    /* access modifiers changed from: protected */
    public P presenter;
    protected ScrollView scrollView;
    protected TextView subTitleTv;
    protected AbsLoginTitleBar titleBar;
    protected TextView titleTv;

    /* access modifiers changed from: protected */
    public abstract P bindPresenter();

    public boolean canSlide() {
        return true;
    }

    public boolean isAutoSlide() {
        return true;
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.context = getActivity().getApplicationContext();
        if (getActivity() instanceof AbsLoginBaseActivity) {
            this.baseActivity = (AbsLoginBaseActivity) getActivity();
        }
        initMessenger();
        this.presenter = bindPresenter();
        LoginLog.write(this.TAG + " onCreate");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.login_unify_fragment_base, viewGroup, false);
        this.titleBar = (AbsLoginTitleBar) viewGroup2.findViewById(R.id.v_title_bar);
        View initView = initView(layoutInflater, viewGroup2);
        this.contentView = initView;
        addContent(viewGroup2, initView);
        updateView();
        initListener();
        P p = this.presenter;
        if (p != null) {
            p.updateView();
        }
        LoginLog.write(this.TAG + " onCreateView");
        return viewGroup2;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        this.titleBar.setCenterVisible(false);
        setTitleBarRightVisible(false);
        setTitleBarLeftListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LOGIN_BACKUP_CK).send();
                KeyboardHelper.hideInputMethod(AbsLoginBaseFragment.this.context, AbsLoginBaseFragment.this.contentView);
                AbsLoginBaseFragment.this.goBack();
            }
        });
    }

    public void onResume() {
        super.onResume();
        FragmentMessenger.nowState = getNowState();
        LoginListeners.LoadingViewListener loadingViewListener = ListenerManager.getLoadingViewListener();
        if (loadingViewListener != null && !this.baseActivity.isPopBack()) {
            HashMap hashMap = new HashMap();
            hashMap.put("user_type", LoginStore.getInstance().getUserType() == 1 ? "new" : LoginOmegaUtil.OLD_USER);
            if (!FragmentMessenger.scenesStack.isEmpty()) {
                hashMap.put("scene", Integer.valueOf(this.messenger.getSceneNum()));
                hashMap.put("page", Integer.valueOf(getNowState().getStateNum()));
                loadingViewListener.onCreate(hashMap, this.baseActivity.getLoadingView());
            } else {
                return;
            }
        }
        this.baseActivity.setIsPopBack(false);
    }

    /* access modifiers changed from: protected */
    public void addContent(ViewGroup viewGroup, View view) {
        if (view != null && view.getParent() == null) {
            this.scrollView = (ScrollView) viewGroup.findViewById(R.id.sv_content);
            if (canSlide()) {
                this.scrollView.addView(view);
                if (isAutoSlide()) {
                    setScrolLayoutChange(this.scrollView);
                    return;
                }
                return;
            }
            viewGroup.addView(view);
            this.scrollView.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void setScrolLayoutChange(ScrollView scrollView2) {
        scrollView2.addOnLayoutChangeListener(new LoginLayoutChangeListener(this.context, scrollView2, this.baseActivity.getWindow().getDecorView().getHeight()));
    }

    /* access modifiers changed from: protected */
    public void initMessenger() {
        Bundle arguments = getArguments();
        FragmentMessenger fragmentMessenger = arguments != null ? (FragmentMessenger) arguments.getSerializable("key_fragment_messenger") : null;
        if (fragmentMessenger != null) {
            this.messenger = fragmentMessenger.cloneObj();
        }
        if (this.messenger == null) {
            this.messenger = new FragmentMessenger();
        }
        this.preScene = this.messenger.getScene();
        LoginOmegaUtil.setMessenger(this.messenger);
    }

    public FragmentMessenger getMessenger() {
        if (this.messenger == null) {
            initMessenger();
        }
        return this.messenger;
    }

    public boolean isViewAlive() {
        return getActivity() != null && isAdded();
    }

    public void onFlowFinish(int i) {
        AbsLoginBaseActivity absLoginBaseActivity = this.baseActivity;
        if (absLoginBaseActivity != null) {
            absLoginBaseActivity.onFlowFinish(i, this.messenger);
        }
    }

    public void setTitleBarLeftVisible(boolean z) {
        AbsLoginTitleBar absLoginTitleBar = this.titleBar;
        if (absLoginTitleBar != null) {
            absLoginTitleBar.setLeftVisible(z);
        }
    }

    public void setTitleBarRightVisible(boolean z) {
        AbsLoginTitleBar absLoginTitleBar = this.titleBar;
        if (absLoginTitleBar != null) {
            absLoginTitleBar.setRightVisible(z);
        }
    }

    public void setTitleBarCenterVisible(boolean z) {
        AbsLoginTitleBar absLoginTitleBar = this.titleBar;
        if (absLoginTitleBar != null) {
            absLoginTitleBar.setCenterVisible(z);
        }
    }

    public void setTitleBarCenterMsg(String str) {
        AbsLoginTitleBar absLoginTitleBar = this.titleBar;
        if (absLoginTitleBar != null) {
            absLoginTitleBar.setCenterMsg(str);
        }
    }

    public void setTitleBarRightText(CharSequence charSequence) {
        AbsLoginTitleBar absLoginTitleBar = this.titleBar;
        if (absLoginTitleBar != null) {
            absLoginTitleBar.setRightText(charSequence);
        }
    }

    public void setTitleBarRightListener(View.OnClickListener onClickListener) {
        AbsLoginTitleBar absLoginTitleBar = this.titleBar;
        if (absLoginTitleBar != null) {
            absLoginTitleBar.setRightClickListener(onClickListener);
        }
    }

    public void setTitleBarLeftListener(View.OnClickListener onClickListener) {
        AbsLoginTitleBar absLoginTitleBar = this.titleBar;
        if (absLoginTitleBar != null) {
            absLoginTitleBar.setLeftClickListener(onClickListener);
        }
    }

    public void setTitle(CharSequence charSequence) {
        TextView textView = this.titleTv;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void setSubTitle(CharSequence charSequence) {
        TextView textView = this.subTitleTv;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void goBack() {
        LoginLog.write(this.TAG + " onBackPressed");
        this.baseActivity.onBackPressed();
    }

    public void goJump() {
        new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_SKIP_CK).send();
        this.baseActivity.goJump();
        this.baseActivity.finish();
    }

    public void setForbidBack(boolean z) {
        AbsLoginBaseActivity absLoginBaseActivity = this.baseActivity;
        if (absLoginBaseActivity != null) {
            absLoginBaseActivity.setForbidBack(z);
        }
    }

    public boolean isForbidBack() {
        return this.baseActivity.isForbidBack();
    }

    public boolean isLoginFlow() {
        return this.baseActivity.isLoginFlow();
    }

    public AbsLoginBaseActivity getBaseActivity() {
        return this.baseActivity;
    }

    public void showKeyBoardDelay(final View view) {
        AbsLoginBaseActivity absLoginBaseActivity = this.baseActivity;
        if (absLoginBaseActivity != null && !absLoginBaseActivity.isPopBack()) {
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    view.requestFocus();
                    KeyboardHelper.showInputMethod(AbsLoginBaseFragment.this.context, view);
                }
            }, Build.VERSION.SDK_INT < 21 ? 400 : 200);
        }
    }

    public void showError(String str) {
        if (isViewAlive() && !TextUtil.isEmpty(str)) {
            ToastHelper.showShortInfo(this.context, str);
        }
    }

    public void showError(int i) {
        if (isViewAlive()) {
            showError(getString(i));
        }
    }

    public void showLoading(String str) {
        AbsLoginBaseActivity absLoginBaseActivity = this.baseActivity;
        if (absLoginBaseActivity != null) {
            absLoginBaseActivity.showLoading(str);
        }
    }

    public void hideLoading() {
        AbsLoginBaseActivity absLoginBaseActivity = this.baseActivity;
        if (absLoginBaseActivity != null) {
            absLoginBaseActivity.hideLoading();
        }
    }

    public void showLongToast(String str) {
        if (isViewAlive()) {
            ToastHelper.showLongInfo(this.context, str);
        }
    }

    public void showShortToast(String str) {
        if (isViewAlive()) {
            ToastHelper.showShortInfo(this.context, str);
        }
    }

    public void showShortError(String str) {
        if (isViewAlive()) {
            ToastHelper.showShortError(this.context, str);
        }
    }

    public void showShortToast(int i) {
        if (isViewAlive()) {
            showShortToast(getString(i));
        }
    }

    public void showShortCompleted(String str) {
        if (isViewAlive()) {
            ToastHelper.showShortCompleted(this.context, str);
        }
    }

    public void showShortCompleted(int i) {
        if (isViewAlive()) {
            showShortCompleted(getString(i));
        }
    }

    public void showLongToast(int i) {
        if (isViewAlive()) {
            showLongToast(getString(i));
        }
    }

    public void showShortError(int i) {
        if (isViewAlive()) {
            showShortError(getString(i));
        }
    }

    public void showInfoDialog(String str, String str2, String str3, View.OnClickListener onClickListener) {
        showInfoDialog(str, str2, str3, (String) null, onClickListener, (View.OnClickListener) null);
    }

    public void showInfoDialog(String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        if (isViewAlive()) {
            BaseViewUtil.showInfoDialog(this.baseActivity, str, str2, str3, str4, onClickListener, onClickListener2);
        }
    }

    public void showInfoDialog(FragmentActivity fragmentActivity, String str, String str2, BaseViewUtil.DialogItem dialogItem, BaseViewUtil.DialogItem dialogItem2, BaseViewUtil.DialogItem dialogItem3) {
        if (isViewAlive()) {
            BaseViewUtil.showMultipleDialog(this.baseActivity, str, str2, dialogItem, dialogItem2, dialogItem3);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.baseActivity = null;
        if (!FragmentMessenger.scenesStack.isEmpty()) {
            FragmentMessenger.scenesStack.pop();
        }
    }
}
