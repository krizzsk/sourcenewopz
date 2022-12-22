package com.didi.sdk.fastframe.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.fastframe.presenter.IPresenter;
import com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment;
import com.didi.sdk.login.view.CommonDialog;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.lang.reflect.InvocationTargetException;

public abstract class BaseFragment extends InstanceStateFragment implements IView {

    /* renamed from: a */
    private ProgressDialogFragment f35907a = null;

    /* renamed from: b */
    private boolean f35908b = false;

    /* renamed from: c */
    private CommonDialog f35909c = null;

    public boolean inContentView() {
        return false;
    }

    public void showContentView() {
    }

    public void showEmptyView() {
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f35907a == null) {
            this.f35907a = new ProgressDialogFragment();
        }
    }

    public <P extends IPresenter> P getPresenter(Class<P> cls) {
        if (cls == null) {
            return null;
        }
        try {
            return (IPresenter) cls.getConstructors()[0].newInstance(new Object[]{getActivity(), this});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r1 = getFragmentManager();
        r2 = java.lang.Class.forName("androidx.fragment.app.FragmentManagerImpl").getDeclaredField("mStateSaved");
        r2.setAccessible(true);
        r2.set(r1, false);
        r4.f35907a.setContent(r5, r6);
        r4.f35907a.show(r1, r4.f35907a.getClass().getSimpleName());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void showProgressDialog(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            boolean r0 = r4.isAdded()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 1
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r1 = r4.f35907a     // Catch:{ Exception -> 0x0036 }
            r1.setContent(r5, r6)     // Catch:{ Exception -> 0x0036 }
            boolean r1 = r4.f35908b     // Catch:{ Exception -> 0x0036 }
            if (r1 == 0) goto L_0x0012
            return
        L_0x0012:
            androidx.fragment.app.FragmentManager r1 = r4.getFragmentManager()     // Catch:{ Exception -> 0x0036 }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r2 = r4.f35907a     // Catch:{ Exception -> 0x0036 }
            boolean r2 = r2.isAdded()     // Catch:{ Exception -> 0x0036 }
            if (r2 != 0) goto L_0x0065
            r4.f35908b = r0     // Catch:{ Exception -> 0x0036 }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r2 = r4.f35907a     // Catch:{ Exception -> 0x0036 }
            java.lang.Class<com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment> r3 = com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment.class
            java.lang.String r3 = r3.getSimpleName()     // Catch:{ Exception -> 0x0036 }
            r2.show((androidx.fragment.app.FragmentManager) r1, (java.lang.String) r3)     // Catch:{ Exception -> 0x0036 }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r1 = r4.f35907a     // Catch:{ Exception -> 0x0036 }
            com.didi.sdk.fastframe.view.BaseFragment$1 r2 = new com.didi.sdk.fastframe.view.BaseFragment$1     // Catch:{ Exception -> 0x0036 }
            r2.<init>()     // Catch:{ Exception -> 0x0036 }
            r1.setmCancelListener(r2)     // Catch:{ Exception -> 0x0036 }
            goto L_0x0065
        L_0x0036:
            androidx.fragment.app.FragmentManager r1 = r4.getFragmentManager()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r2 = "androidx.fragment.app.FragmentManagerImpl"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ Exception -> 0x0065 }
            java.lang.String r3 = "mStateSaved"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ Exception -> 0x0065 }
            r2.setAccessible(r0)     // Catch:{ Exception -> 0x0065 }
            r0 = 0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x0065 }
            r2.set(r1, r0)     // Catch:{ Exception -> 0x0065 }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r0 = r4.f35907a     // Catch:{ Exception -> 0x0065 }
            r0.setContent(r5, r6)     // Catch:{ Exception -> 0x0065 }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r5 = r4.f35907a     // Catch:{ Exception -> 0x0065 }
            com.didi.sdk.fastframe.view.dialog.ProgressDialogFragment r6 = r4.f35907a     // Catch:{ Exception -> 0x0065 }
            java.lang.Class r6 = r6.getClass()     // Catch:{ Exception -> 0x0065 }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ Exception -> 0x0065 }
            r5.show((androidx.fragment.app.FragmentManager) r1, (java.lang.String) r6)     // Catch:{ Exception -> 0x0065 }
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.fastframe.view.BaseFragment.showProgressDialog(java.lang.String, boolean):void");
    }

    public void showProgressDialog(boolean z) {
        if (isAdded()) {
            showProgressDialog(getString(R.string.one_fastframe_waiting), z);
        }
    }

    public void dismissProgressDialog() {
        if (isAdded()) {
            try {
                this.f35908b = false;
                this.f35907a.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    public void showDialog(String str, String str2, String str3, String str4, CommonDialog.ButtonType buttonType, CommonDialog.CommonDialogListener commonDialogListener) {
        if (isAdded()) {
            CommonDialog commonDialog = this.f35909c;
            if (commonDialog != null) {
                commonDialog.dismiss();
            }
            CommonDialog commonDialog2 = new CommonDialog(getActivity());
            this.f35909c = commonDialog2;
            commonDialog2.setCheckboxVisibility(false);
            this.f35909c.setIconVisible(TextUtils.isEmpty(str));
            CommonDialog commonDialog3 = this.f35909c;
            if (TextUtils.isEmpty(str3)) {
                str3 = getString(R.string.one_fastframe_confirm);
            }
            commonDialog3.setSubmitBtnText(str3);
            CommonDialog commonDialog4 = this.f35909c;
            if (TextUtils.isEmpty(str4)) {
                str4 = getString(R.string.one_fastframe_cancel);
            }
            commonDialog4.setCancelBtnText(str4);
            this.f35909c.setButtonType(buttonType);
            this.f35909c.setTitleContent(str, str2);
            this.f35909c.setListener(commonDialogListener);
            SystemUtils.showDialog(this.f35909c);
        }
    }

    public void showToastComplete(String str) {
        if (isAdded() && str != null) {
            showToastComplete(str, str.length() > 20);
        }
    }

    public void showToastComplete(String str, boolean z) {
        if (!isAdded() || str == null) {
            return;
        }
        if (z) {
            ToastHelper.showLongCompleteMessage((Context) getActivity(), str);
        } else {
            ToastHelper.showShortCompleted((Context) getActivity(), str);
        }
    }

    public void showToastInfo(String str) {
        if (isAdded() && str != null) {
            showToastInfo(str, str.length() > 20);
        }
    }

    public void showToastInfo(String str, boolean z) {
        if (!isAdded() || str == null) {
            return;
        }
        if (z) {
            ToastHelper.showLongInfo((Context) getActivity(), str);
        } else {
            ToastHelper.showShortInfo((Context) getActivity(), str);
        }
    }

    public void showToastError(String str) {
        if (isAdded() && str != null) {
            showToastError(str, str.length() > 20);
        }
    }

    public void showToastError(String str, boolean z) {
        if (!isAdded() || str == null) {
            return;
        }
        if (z) {
            ToastHelper.showLongError((Context) getActivity(), str);
        } else {
            ToastHelper.showShortError((Context) getActivity(), str);
        }
    }

    @Deprecated
    public void showToast(String str) {
        if (isAdded()) {
            showToastComplete(str);
        }
    }
}
