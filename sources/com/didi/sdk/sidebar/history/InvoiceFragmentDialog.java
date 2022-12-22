package com.didi.sdk.sidebar.history;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.config.commonconfig.p149sp.CommonConfigSp;
import com.taxis99.R;

public class InvoiceFragmentDialog extends DialogFragment {

    /* renamed from: a */
    private TextView f37337a;

    /* renamed from: b */
    private EditText f37338b;

    /* renamed from: c */
    private TextView f37339c;

    /* renamed from: d */
    private Button f37340d;

    /* renamed from: e */
    private View.OnClickListener f37341e;

    /* renamed from: f */
    private Spanned f37342f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 16973939);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.requestWindowFeature(1);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.guarana_invoice_dlg, (ViewGroup) null);
        this.f37337a = (TextView) inflate.findViewById(R.id.content);
        EditText editText = (EditText) inflate.findViewById(R.id.email);
        this.f37338b = editText;
        editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(128)});
        this.f37337a.setText(this.f37342f);
        TextView textView = (TextView) inflate.findViewById(R.id.cancel);
        this.f37339c = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                InvoiceFragmentDialog.this.dismiss();
            }
        });
        Button button = (Button) inflate.findViewById(R.id.send);
        this.f37340d = button;
        button.setOnClickListener(this.f37341e);
        this.f37338b.setText(CommonConfigSp.getInstance().get(CommonConfigSp.KEY_COMMON_LASTEMAIL, ""));
        return inflate;
    }

    public void setContent(String str) {
        Spanned fromHtml = Html.fromHtml(str);
        this.f37342f = fromHtml;
        TextView textView = this.f37337a;
        if (textView != null) {
            textView.setText(fromHtml);
        }
    }

    public String getEmail() {
        return this.f37338b.getText().toString();
    }

    public void setRightOnclickListener(View.OnClickListener onClickListener) {
        this.f37341e = onClickListener;
    }
}
