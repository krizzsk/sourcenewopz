package com.didi.sdk.component.share;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.component.share.ShareView;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class ShareEditDialog extends Dialog {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ShareEditDialogListener f35660a;

    /* renamed from: b */
    private View f35661b;

    /* renamed from: c */
    private ImageView f35662c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public EditText f35663d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f35664e;

    /* renamed from: f */
    private Button f35665f;

    /* renamed from: g */
    private Button f35666g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ShareView.ShareModel f35667h;

    /* renamed from: i */
    private View.OnClickListener f35668i = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            ShareEditDialog.this.dismiss();
            if (ShareEditDialog.this.f35660a != null) {
                ShareEditDialog.this.f35660a.cancel();
            }
        }
    };

    /* renamed from: j */
    private View.OnClickListener f35669j = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (TextUtils.isEmpty(ShareEditDialog.this.getEditContent())) {
                ToastHelper.showShortError(ShareEditDialog.this.getContext(), (int) R.string.share_content_empty);
                return;
            }
            ShareEditDialog.this.f35667h.content = ShareEditDialog.this.getEditContent();
            ShareEditDialog.this.dismiss();
            if (ShareEditDialog.this.f35660a != null) {
                ShareEditDialog.this.f35660a.submit();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public TextWatcher f35670k = new TextWatcher() {
        private int count;
        private int editEnd;
        private int editStart;
        private CharSequence tempInput;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.tempInput = charSequence;
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.count = i2 + i3;
            String obj = ShareEditDialog.this.f35663d.getText().toString();
            String stringFilter = ShareEditDialog.stringFilter(obj);
            if (!obj.equals(stringFilter)) {
                ShareEditDialog.this.f35663d.setText(stringFilter);
            }
            this.count = ShareEditDialog.this.f35663d.length();
            ShareEditDialog.this.f35664e.setText(String.valueOf(140 - this.count));
        }

        public void afterTextChanged(Editable editable) {
            ShareEditDialog.this.f35663d.removeTextChangedListener(ShareEditDialog.this.f35670k);
            this.editStart = ShareEditDialog.this.f35663d.getSelectionStart();
            this.editEnd = ShareEditDialog.this.f35663d.getSelectionEnd();
            if (this.tempInput.length() > 140) {
                editable.delete(this.editStart - 1, this.editEnd);
                int i = this.editStart;
                ShareEditDialog.this.f35663d.setText(editable);
                ShareEditDialog.this.f35663d.setSelection(i);
            }
            ShareEditDialog.this.f35663d.addTextChangedListener(ShareEditDialog.this.f35670k);
        }
    };

    public interface ShareEditDialogListener {
        void cancel();

        void submit();
    }

    public ShareEditDialog(Context context) {
        super(context);
        m25253a();
    }

    public ShareEditDialog(Context context, int i) {
        super(context, i);
        m25253a();
    }

    protected ShareEditDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        m25253a();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.f35661b);
    }

    /* renamed from: a */
    private void m25253a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.v_share_edit_dialog, (ViewGroup) null);
        this.f35661b = inflate;
        this.f35665f = (Button) inflate.findViewById(R.id.btn_cancel);
        this.f35666g = (Button) this.f35661b.findViewById(R.id.btn_share);
        this.f35662c = (ImageView) this.f35661b.findViewById(R.id.img_logo);
        EditText editText = (EditText) this.f35661b.findViewById(R.id.dialog_edit_content);
        this.f35663d = editText;
        editText.addTextChangedListener(this.f35670k);
        this.f35664e = (TextView) this.f35661b.findViewById(R.id.dialog_txt_count);
        this.f35665f.setOnClickListener(this.f35668i);
        this.f35666g.setOnClickListener(this.f35669j);
    }

    public void setDialog(ShareView.ShareModel shareModel) {
        this.f35667h = shareModel;
        if (TextUtils.isEmpty(shareModel.content)) {
            this.f35667h.content = "";
        } else {
            ShareView.ShareModel shareModel2 = this.f35667h;
            shareModel2.content = this.f35667h.content + this.f35667h.url;
        }
        if (!TextUtils.isEmpty(this.f35667h.imageUrl)) {
            Glide.with(getContext()).load(this.f35667h.imageUrl).placeholder(R.drawable.hongbao_share).into(this.f35662c);
        }
        this.f35663d.setText(this.f35667h.content);
        if (!TextUtils.isEmpty(this.f35667h.content)) {
            if (this.f35667h.content.length() <= 140) {
                this.f35663d.setSelection(this.f35667h.content.length());
                this.f35664e.setText(String.valueOf(140 - this.f35667h.content.length()));
            } else {
                this.f35663d.setSelection(140);
                this.f35664e.setText("0");
            }
        }
        requestWindowFeature(1);
    }

    public void setListener(ShareEditDialogListener shareEditDialogListener) {
        this.f35660a = shareEditDialogListener;
    }

    public String getEditContent() {
        return this.f35663d.getText().toString();
    }

    public static String stringFilter(String str) throws PatternSyntaxException {
        return Pattern.compile("[\t]").matcher(str).replaceAll("");
    }
}
