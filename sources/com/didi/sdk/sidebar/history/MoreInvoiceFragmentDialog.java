package com.didi.sdk.sidebar.history;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.fintech.cashier.core.ktx.StringKtxKt;
import com.taxis99.R;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoreInvoiceFragmentDialog extends DialogFragment {
    public static final int TYPE_INVALIDATE = 0;
    public static final int TYPE_VALIDATE = 1;

    /* renamed from: a */
    private TextView f37343a;

    /* renamed from: b */
    private View f37344b;

    /* renamed from: c */
    private View f37345c;

    /* renamed from: d */
    private View f37346d;

    /* renamed from: e */
    private TextView f37347e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public EditText f37348f;

    /* renamed from: g */
    private TextView f37349g;

    /* renamed from: h */
    private EditText f37350h;

    /* renamed from: i */
    private ImageView f37351i;

    /* renamed from: j */
    private TextView f37352j;

    /* renamed from: k */
    private Button f37353k;

    /* renamed from: l */
    private View.OnClickListener f37354l;

    /* renamed from: m */
    private View.OnClickListener f37355m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public View.OnClickListener f37356n;

    /* renamed from: o */
    private String f37357o;

    /* renamed from: p */
    private String f37358p;

    /* renamed from: q */
    private int f37359q;

    /* renamed from: r */
    private int f37360r;

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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.global_more_invoice_dlg, (ViewGroup) null);
        this.f37343a = (TextView) inflate.findViewById(R.id.tv_invoice_title);
        this.f37348f = (EditText) inflate.findViewById(R.id.et_invoice_title);
        this.f37349g = (TextView) inflate.findViewById(R.id.tv_invoice_email);
        this.f37350h = (EditText) inflate.findViewById(R.id.et_invoice_email);
        this.f37346d = inflate.findViewById(R.id.v_invoice_title_line);
        this.f37344b = inflate.findViewById(R.id.ll_invoice_title);
        this.f37345c = inflate.findViewById(R.id.iv_invoice_title_clear);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_invoice_email_desc);
        this.f37347e = textView;
        textView.setText(m26558a(getContext().getString(R.string.global_invoice_email_desc), getContext().getResources().getColor(R.color.global_invoice_validate_desc), getContext().getResources().getColor(R.color.global_invoice_validate_status)));
        this.f37351i = (ImageView) inflate.findViewById(R.id.iv_invoice_email_edit);
        this.f37352j = (TextView) inflate.findViewById(R.id.cancel);
        Button button = (Button) inflate.findViewById(R.id.send);
        this.f37353k = button;
        button.setOnClickListener(this.f37354l);
        this.f37352j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (MoreInvoiceFragmentDialog.this.f37356n != null) {
                    MoreInvoiceFragmentDialog.this.f37356n.onClick(view);
                }
                MoreInvoiceFragmentDialog.this.dismiss();
            }
        });
        this.f37351i.setOnClickListener(this.f37355m);
        this.f37345c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MoreInvoiceFragmentDialog.this.f37348f.setText("");
            }
        });
        updateUI();
        return inflate;
    }

    public void updateUI() {
        EditText editText = this.f37348f;
        if (editText != null) {
            editText.setText(this.f37357o);
        }
        EditText editText2 = this.f37350h;
        if (editText2 != null) {
            editText2.setText(this.f37358p);
        }
        if (!(this.f37349g == null || getContext() == null)) {
            TextView textView = this.f37349g;
            Context context = getContext();
            textView.setText(context.getString(R.string.global_invoice_email_title, new Object[]{this.f37359q + ""}));
        }
        if (this.f37360r == 1) {
            m26559a((View) this.f37343a, 0);
            m26559a(this.f37344b, 0);
            m26559a((View) this.f37351i, 0);
            m26559a(this.f37346d, 0);
            m26559a((View) this.f37347e, 8);
            m26560a((TextView) this.f37353k, getContext().getString(R.string.global_invoice_send_email));
            return;
        }
        m26559a((View) this.f37343a, 8);
        m26559a(this.f37344b, 8);
        m26559a((View) this.f37351i, 8);
        m26559a(this.f37346d, 8);
        m26559a((View) this.f37347e, 0);
        m26560a((TextView) this.f37353k, getContext().getString(R.string.global_invoice_go_validate));
    }

    public void setUIData(String str, String str2, int i, int i2) {
        this.f37357o = str;
        this.f37358p = str2;
        this.f37359q = i;
        this.f37360r = i2;
    }

    /* renamed from: a */
    private void m26559a(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    /* renamed from: a */
    private void m26560a(TextView textView, String str) {
        if (textView != null) {
            textView.setText(str);
        }
    }

    public String getEmail() {
        return this.f37350h.getText().toString();
    }

    public String getTitle() {
        return this.f37348f.getText().toString();
    }

    public void setRightOnclickListener(View.OnClickListener onClickListener) {
        this.f37354l = onClickListener;
    }

    public void setOnCancelListener(View.OnClickListener onClickListener) {
        this.f37356n = onClickListener;
    }

    public void setEditListener(View.OnClickListener onClickListener) {
        this.f37355m = onClickListener;
    }

    /* renamed from: a */
    private CharSequence m26558a(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Matcher matcher = Pattern.compile(StringKtxKt.REGULAR_EXPRESSION).matcher(str);
        if (!matcher.find()) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.delete(matcher.start(), matcher.start() + 1);
        spannableStringBuilder.delete(matcher.end() - 2, matcher.end() - 1);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i2), matcher.start(), matcher.end() - 2, 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), 0, matcher.start(), 18);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), matcher.end() - 2, spannableStringBuilder.length(), 18);
        return spannableStringBuilder;
    }
}
