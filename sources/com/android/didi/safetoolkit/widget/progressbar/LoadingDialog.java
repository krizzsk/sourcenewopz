package com.android.didi.safetoolkit.widget.progressbar;

import android.os.Bundle;
import android.widget.TextView;
import com.android.didi.safetoolkit.fragment.BaseDialogFragment;
import com.taxis99.R;

public class LoadingDialog extends BaseDialogFragment {
    public static final String LOADING_TV_TXT = "loadingText";
    private TextView loadingTv;

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.layout_loading_dialog;
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
    }

    /* access modifiers changed from: protected */
    public void setListener() {
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.loadingTv = (TextView) findViewById(R.id.loading_tv);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        this.loadingTv.setText(getArguments().getString(LOADING_TV_TXT));
    }
}
