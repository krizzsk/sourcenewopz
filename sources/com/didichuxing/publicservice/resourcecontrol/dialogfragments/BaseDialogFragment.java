package com.didichuxing.publicservice.resourcecontrol.dialogfragments;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didichuxing.publicservice.general.AppUtils;
import com.didichuxing.publicservice.general.ConstantUtils;
import com.didichuxing.publicservice.resourcecontrol.api.ResourceApi;
import com.didichuxing.publicservice.resourcecontrol.utils.ResourceManager;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;

public class BaseDialogFragment extends DialogFragment {
    private static final String TAG = BaseDialogFragment.class.getSimpleName();
    public static HashMap<String, Object> tunaDownloadMapList = new HashMap<>();
    public FragmentActivity activity;
    protected Bundle bundle;
    public int code;
    public ResourceApi.OnSplashListener onSplashListener;
    protected int resouceId;
    public ViewGroup rootContainer;
    protected Serializable serializable;
    protected String sharedkey = null;

    public void onCreate(Bundle bundle2) {
        super.onCreate(bundle2);
        if (Build.VERSION.SDK_INT <= 20) {
            setStyle(2, R.style.BaseDialogWithoutTopLine);
        } else {
            setStyle(0, R.style.BaseDialogWithoutTopLine);
        }
    }

    public void onStart() {
        super.onStart();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        window.setAttributes(attributes);
        window.setBackgroundDrawable(new ColorDrawable(0));
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = getActivity();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle2) {
        View inflate = layoutInflater.inflate(R.layout.asset_activity_show, viewGroup, false);
        this.rootContainer = (ViewGroup) inflate.findViewById(R.id.fragmentshow);
        Bundle arguments = getArguments();
        this.bundle = arguments;
        this.serializable = arguments.getSerializable(ConstantUtils.EXTRA_RESOURCE_STR);
        this.resouceId = this.bundle.getInt(ConstantUtils.EXTRA_RESOURCE_ID, 0);
        this.code = this.bundle.getInt(ConstantUtils.EXTRA_RESOURCE_TYPE);
        this.sharedkey = this.bundle.getString(ConstantUtils.SHAREDPRERENCE_KEY);
        return inflate;
    }

    public void onStop() {
        super.onStop();
        AppUtils.log("=== BaseDialogFragment =========> onStop ====");
        int i = this.code;
        if (i == 1003 || i == 1001 || i == 1002 || i == 1004) {
            ResourceManager.WINDOW_SHOWING = false;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        AppUtils.log("=== BaseDialogFragment =========> onDestroyView,code = " + this.code + " , fragment = " + this);
        if (!TextUtils.isEmpty(this.sharedkey)) {
            AppUtils.log("删除缓存, type = " + this);
            if (getActivity() != null) {
                AppUtils.saveStringToPreference(getActivity(), this.sharedkey, (String) null);
            }
        }
    }

    public void setOnSplashListener(ResourceApi.OnSplashListener onSplashListener2) {
        this.onSplashListener = onSplashListener2;
    }

    public void close() {
        dismiss();
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.remove(this);
        beginTransaction.commitAllowingStateLoss();
    }

    public void onDestroy() {
        super.onDestroy();
        this.onSplashListener = null;
    }
}
