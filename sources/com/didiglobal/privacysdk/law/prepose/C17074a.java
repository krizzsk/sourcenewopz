package com.didiglobal.privacysdk.law.prepose;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

/* renamed from: com.didiglobal.privacysdk.law.prepose.a */
/* compiled from: LoginAlertDialog */
class C17074a {
    C17074a() {
    }

    /* renamed from: a */
    public void mo123716a(FragmentActivity fragmentActivity, AlertDialogFragment.OnClickListener onClickListener, AlertDialogFragment.OnClickListener onClickListener2, View.OnClickListener onClickListener3, String str, String str2, String str3, String str4, String str5) {
        View inflate = LayoutInflater.from(fragmentActivity).inflate(R.layout.dialog_law_view, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.text_message);
        textView.setMovementMethod(new ScrollingMovementMethod());
        ((TextView) inflate.findViewById(R.id.text_title)).setText(str);
        textView.setText(str2);
        ((TextView) inflate.findViewById(R.id.text_link_hint)).setText(str3);
        inflate.findViewById(R.id.link_layout).setOnClickListener(onClickListener3);
        new AlertDialogFragment.Builder(fragmentActivity.getApplicationContext()).setPositiveButton((CharSequence) str4, onClickListener).setNegativeButton((CharSequence) str5, onClickListener2).setContentView(inflate).setCancelable(false).setPositiveButtonDefault().setLinkIconVisible(false).create().show(fragmentActivity.getSupportFragmentManager(), (String) null);
    }
}
