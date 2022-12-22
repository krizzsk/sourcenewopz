package com.didi.payment.base.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class BackInfoHintDialogFragment extends SimplePopupBase {

    /* renamed from: a */
    private String f29862a;

    /* renamed from: b */
    private String f29863b;

    /* renamed from: c */
    private String f29864c;

    /* renamed from: d */
    private String f29865d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View.OnClickListener f29866e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f29867f;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.pay_base_drawer_dialog;
    }

    public static void show(FragmentActivity fragmentActivity, String str, String str2, String str3, String str4, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        BackInfoHintDialogFragment backInfoHintDialogFragment = new BackInfoHintDialogFragment();
        backInfoHintDialogFragment.f29862a = str;
        backInfoHintDialogFragment.f29863b = str2;
        backInfoHintDialogFragment.f29864c = str3;
        backInfoHintDialogFragment.f29865d = str4;
        backInfoHintDialogFragment.f29866e = onClickListener;
        backInfoHintDialogFragment.f29867f = onClickListener2;
        backInfoHintDialogFragment.show(fragmentActivity.getSupportFragmentManager(), "back_info_dialog");
    }

    /* access modifiers changed from: protected */
    public void initView() {
        TextView textView = (TextView) this.mRootView.findViewById(R.id.drawer_dialog_left_btn);
        TextView textView2 = (TextView) this.mRootView.findViewById(R.id.drawer_dialog_right_btn);
        ((TextView) this.mRootView.findViewById(R.id.drawer_dialog_title_tv)).setText(this.f29862a);
        ((TextView) this.mRootView.findViewById(R.id.drawer_dialog_content_tv)).setText(this.f29863b);
        textView.setText(this.f29864c);
        textView2.setText(this.f29865d);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BackInfoHintDialogFragment.this.dismiss();
                if (BackInfoHintDialogFragment.this.f29866e != null) {
                    BackInfoHintDialogFragment.this.f29866e.onClick(view);
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BackInfoHintDialogFragment.this.dismiss();
                if (BackInfoHintDialogFragment.this.f29867f != null) {
                    BackInfoHintDialogFragment.this.f29867f.onClick(view);
                }
            }
        });
    }
}
