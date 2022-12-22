package com.didi.safetoolkit.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;

public class DiDiProgressDialog extends Dialog {

    /* renamed from: a */
    private Context f34518a;

    /* renamed from: b */
    private TextView f34519b;

    public DiDiProgressDialog(Context context) {
        super(context, R.style.Dialog);
        this.f34518a = context;
        m24377a();
    }

    /* renamed from: a */
    private void m24377a() {
        View inflate = View.inflate(this.f34518a, R.layout.sf_progress_dialog_layout, (ViewGroup) null);
        super.setContentView(inflate);
        this.f34519b = (TextView) inflate.findViewById(R.id.loading_text);
    }

    public void showDialog(boolean z) {
        showDialog(z, SfStringGetter.getString(R.string.sf_loading));
    }

    public void showDialog(boolean z, String str) {
        if (!(getContext() instanceof Activity) || !((Activity) getContext()).isFinishing()) {
            try {
                setCancelable(z);
                this.f34519b.setText(str);
                super.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
