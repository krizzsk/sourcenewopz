package com.didi.onekeyshare.view;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.sdk.view.BaseDialogFragment;
import com.taxis99.R;

public class DownloadProgressDialogFragment extends BaseDialogFragment {

    /* renamed from: a */
    private String f29780a;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().requestWindowFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        View inflate = layoutInflater.inflate(R.layout.dialog_fragment_download, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_msg);
        if (!TextUtils.isEmpty(this.f29780a)) {
            textView.setText(this.f29780a);
        }
        return inflate;
    }

    public void setContent(String str) {
        this.f29780a = str;
    }
}
