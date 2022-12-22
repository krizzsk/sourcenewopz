package com.didi.unifylogin.base.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.manager.LoginFillerFragmentManager;
import com.didi.unifylogin.base.manager.LoginFragmentManager;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.view.ability.ILoginBaseActivity;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.store.LoginStore;
import com.didi.unifylogin.utils.LoginDisplayMetrics;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginPermissionUtil;
import com.didi.unifylogin.utils.LoginProgressDialog;
import com.didi.unifylogin.utils.LoginState;
import com.taxis99.R;
import java.util.Map;

public abstract class AbsLoginBaseActivity extends FragmentActivity implements ILoginBaseActivity {
    public static final String EXTRA_PARAM_ID_NUM = "extra_id_num";
    public static final String EXTRA_PARAM_IS_CHANGE_PHONE_BY_ID = "is_change_phone_by_ID";
    public static final String EXTRA_PARAM_SESSION_ID = "extra_session_id";

    /* renamed from: c */
    private static final String f44705c = "instance_messenger";

    /* renamed from: d */
    private static final String f44706d = "instance_state";
    /* access modifiers changed from: protected */
    public String TAG = getClass().getSimpleName();

    /* renamed from: a */
    private String f44707a = "";

    /* renamed from: b */
    private String f44708b = "";

    /* renamed from: e */
    private FragmentMessenger f44709e;

    /* renamed from: f */
    private LoginState f44710f;

    /* renamed from: g */
    private boolean f44711g = false;

    /* renamed from: h */
    private boolean f44712h;

    /* renamed from: i */
    private LinearLayout f44713i;
    public boolean isChangePhoneByID = false;
    /* access modifiers changed from: protected */
    public Context mContext;

    public boolean isLoginFlow() {
        return false;
    }

    public void onBackPressed() {
        try {
            m31733b();
        } catch (IllegalStateException e) {
            Log.d("AbsLoginBaseActivity", "onBackPressed", e);
        }
    }

    public boolean isViewAlive() {
        if (Build.VERSION.SDK_INT <= 17) {
            return !isFinishing();
        }
        if (isFinishing() || isDestroyed()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        this.isChangePhoneByID = getIntent().getBooleanExtra(EXTRA_PARAM_IS_CHANGE_PHONE_BY_ID, false);
        this.f44707a = getIntent().getStringExtra(EXTRA_PARAM_ID_NUM);
        this.f44708b = getIntent().getStringExtra(EXTRA_PARAM_SESSION_ID);
        setTheme(LoginPreferredConfig.getThemeResInt());
        if (ListenerManager.getActivityDelegate() != null) {
            ListenerManager.getActivityDelegate().onCreate(bundle, this);
            LoginLog.write(this.TAG + "onCreate: ActivityDelegate");
        } else {
            SystemUtils.hookSetRequestedOrientation(this, 7);
        }
        LoginLog.write(this.TAG + "onCreate: Orientation :" + getResources().getConfiguration().orientation);
        this.mContext = getApplicationContext();
        setContentView((int) R.layout.login_unify_activity_main);
        this.f44713i = (LinearLayout) findViewById(R.id.login_unify_loading_view);
        if (bundle == null) {
            startFirstPage();
        }
        LoginPermissionUtil.requestPermissions(this);
        m31732a();
    }

    /* renamed from: a */
    private void m31732a() {
        TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(R.style.OneLoginStyle, new int[]{R.attr.login_unify_color_basic_theme});
        LoginPreferredConfig.setThemeColor(obtainStyledAttributes.getColor(0, 0));
        obtainStyledAttributes.recycle();
    }

    public LinearLayout getLoadingView() {
        return this.f44713i;
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        if (ListenerManager.getActivityDelegate() != null) {
            ListenerManager.getActivityDelegate().onRestart(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (ListenerManager.getActivityDelegate() != null) {
            ListenerManager.getActivityDelegate().onResume(this);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LoginLog.write(this.TAG + " onConfigurationChanged: " + getResources().getConfiguration().orientation);
        setContentView((int) R.layout.login_unify_activity_main);
        startFirstPage();
    }

    /* access modifiers changed from: protected */
    public void startFirstPage() {
        LoginLog.write(this.TAG + " startFirstPage: " + getInitScene().getSceneNum());
        transform((LoginState) null, getInitState(), getInitMessenger());
    }

    /* access modifiers changed from: protected */
    public FragmentMessenger getInitMessenger() {
        return new FragmentMessenger().setScene(getInitScene()).updateOmegaScene(getInitScene()).setCell(LoginStore.getInstance().getPhone()).setHideEmail(LoginStore.getInstance().getHideEmail()).setCredential(LoginStore.getInstance().getCredential()).setChangePhoneByID(this.isChangePhoneByID).setIdNum(this.f44707a).setSessionId(this.f44708b);
    }

    public void transform(LoginState loginState, final LoginState loginState2, final FragmentMessenger fragmentMessenger) {
        LoginLog.write(this.TAG + "( state  ): " + loginState + " -> " + loginState2);
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append("(messenger): ");
        sb.append(fragmentMessenger);
        LoginLog.write(sb.toString());
        try {
            Fragment fragment = LoginFragmentManager.getFragment(loginState2);
            if (fragment != null) {
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.setCustomAnimations(R.anim.login_unify_anim_right_slide_in, R.anim.login_unify_anim_left_side_out, R.anim.login_unify_anim_left_side_int, 0);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_fragment_messenger", fragmentMessenger);
                fragment.setArguments(bundle);
                if ((loginState == LoginState.STATE_CAPTCHA || loginState == LoginState.STATE_CODE || loginState == LoginState.STATE_NEW_CODE) && !isFinishing()) {
                    getSupportFragmentManager().popBackStack();
                    setIsPopBack(true);
                }
                beginTransaction.replace(R.id.fl_fragment, fragment, fragment.getClass().getName());
                if (loginState != null) {
                    beginTransaction.addToBackStack((String) null);
                } else {
                    getSupportFragmentManager().popBackStackImmediate((String) null, 1);
                }
                beginTransaction.commitAllowingStateLoss();
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        LoginOmegaUtil.pageShow(loginState2, fragmentMessenger);
                    }
                }, 200);
                this.f44709e = fragmentMessenger;
                this.f44710f = loginState2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        if (ListenerManager.getActivityDelegate() != null) {
            context = ListenerManager.getActivityDelegate().getAttachBaseContext(context, this);
        }
        super.attachBaseContext(context);
    }

    /* renamed from: b */
    private void m31733b() {
        LoginOmegaUtil.trackBackEvent();
        if (!isFinishing()) {
            Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fl_fragment);
            if ((!(findFragmentById instanceof AbsLoginBaseFragment) || !((AbsLoginBaseFragment) findFragmentById).onBackPressed()) && !getSupportFragmentManager().popBackStackImmediate()) {
                onCancel();
                supportFinishAfterTransition();
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.fl_fragment);
        LoginDisplayMetrics.setWidth((linearLayout.getWidth() - linearLayout.getPaddingLeft()) - linearLayout.getPaddingRight());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LoginOmegaUtil.setOmegaMap((Map<String, Object>) null);
        LoginFillerFragmentManager.cleanFillers();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        try {
            super.onSaveInstanceState(bundle);
        } catch (Exception unused) {
        }
        LoginLog.write(this.TAG + "onSaveInstanceState  " + this.f44710f);
        bundle.putSerializable(f44705c, this.f44709e);
        bundle.putSerializable(f44706d, this.f44710f);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        FragmentMessenger fragmentMessenger = (FragmentMessenger) bundle.getSerializable(f44705c);
        LoginState loginState = (LoginState) bundle.getSerializable(f44706d);
        LoginLog.write(this.TAG + "onRestoreInstanceState  " + loginState);
        if (fragmentMessenger == null || loginState == null) {
            startFirstPage();
        } else {
            transform((LoginState) null, loginState, fragmentMessenger);
        }
    }

    public void setForbidBack(boolean z) {
        this.f44711g = z;
    }

    public boolean isForbidBack() {
        return this.f44711g;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f44711g) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        LoginPermissionUtil.handlePermissionsResult(this, i, strArr, iArr);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (ListenerManager.getActivityDelegate() != null) {
            ListenerManager.getActivityDelegate().onActivityResult(this);
        }
    }

    public boolean isPopBack() {
        return this.f44712h;
    }

    public void setIsPopBack(boolean z) {
        this.f44712h = z;
    }

    public void goJump() {
        onCancel();
        finish();
    }

    public void showLoading(String str) {
        if (isViewAlive()) {
            if (TextUtils.isEmpty(str)) {
                str = getString(R.string.login_unify_loading);
            }
            LoginProgressDialog.showDialog(this, str, false);
        }
    }

    public void hideLoading() {
        LoginProgressDialog.dismissProgressDialogFragmentSafely();
    }
}
