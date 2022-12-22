package com.didi.beatles.p099im.views.dialog.addWord;

import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.event.IMAddCustomWordEvent;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.views.dialog.IMAddCommonWordDialog;
import com.taxis99.R;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.dialog.addWord.IMAddCommonWordGlobalPsg */
public class IMAddCommonWordGlobalPsg implements IMAddCommonWord {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public IMAddCommonWordDialog f10196a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f10197b;

    /* renamed from: c */
    private EditText f10198c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f10199d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f10200e;

    /* renamed from: f */
    private View f10201f;

    /* renamed from: g */
    private View f10202g;

    /* renamed from: h */
    private View f10203h;

    public int layoutRes() {
        return R.layout.im_add_common_word_view_global_psg;
    }

    public void release() {
    }

    public void bind(IMAddCommonWordDialog iMAddCommonWordDialog) {
        this.f10196a = iMAddCommonWordDialog;
        m6956a();
        m6957b();
        this.f10198c.requestFocus();
    }

    /* renamed from: a */
    private void m6956a() {
        Window window = this.f10196a.getWindow();
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(-1, -1);
    }

    /* renamed from: b */
    private void m6957b() {
        this.f10202g = this.f10196a.findViewById(R.id.im_add_common_word_parent);
        this.f10203h = this.f10196a.findViewById(R.id.im_add_common_word_layout);
        this.f10200e = this.f10196a.findViewById(R.id.im_add_common_word_confirm_line);
        this.f10201f = this.f10196a.findViewById(R.id.im_add_common_word_confirm_close);
        this.f10198c = (EditText) this.f10196a.findViewById(R.id.im_add_common_word_et);
        TextView textView = (TextView) this.f10196a.findViewById(R.id.im_word_count);
        this.f10199d = textView;
        textView.setText(String.format(this.f10196a.getString(R.string.im_word_count_string), new Object[]{0}));
        this.f10197b = (TextView) this.f10196a.findViewById(R.id.im_add_common_word_confirm_btn);
        m6960c();
        if (!TextUtils.isEmpty(this.f10196a.mContentText)) {
            this.f10198c.setText(this.f10196a.mContentText);
            this.f10198c.setSelection(this.f10198c.getText().toString().length());
        }
        this.f10202g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMAddCommonWordGlobalPsg.this.f10196a.closeSoftInput();
            }
        });
        this.f10203h.setClickable(true);
        this.f10197b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMAddCommonWordGlobalPsg.this.m6964e()) {
                    EventBus.getDefault().post(new IMAddCustomWordEvent(new IMAddCommonWordDialog.CustomWord(IMAddCommonWordGlobalPsg.this.m6962d(), IMAddCommonWordGlobalPsg.this.f10196a.mResource)));
                    IMAddCommonWordGlobalPsg.this.f10196a.dismiss();
                }
            }
        });
        this.f10201f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMAddCommonWordGlobalPsg.this.f10196a.dismiss();
            }
        });
    }

    /* renamed from: c */
    private void m6960c() {
        this.f10198c.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                boolean z = false;
                int textNum = !TextUtils.isEmpty(charSequence) ? IMTextUtil.getTextNum(charSequence.toString()) : 0;
                IMAddCommonWordGlobalPsg.this.f10199d.setText(String.format(IMAddCommonWordGlobalPsg.this.f10196a.getString(R.string.im_word_count_string), new Object[]{Integer.valueOf(textNum)}));
                IMAddCommonWordGlobalPsg.this.f10199d.setSelected(textNum > 60);
                IMAddCommonWordGlobalPsg.this.f10200e.setSelected(textNum > 60);
                TextView f = IMAddCommonWordGlobalPsg.this.f10197b;
                if (textNum > 0 && textNum <= 60) {
                    z = true;
                }
                f.setEnabled(z);
            }
        });
    }

    /* renamed from: a */
    private String m6955a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        if (TextUtils.isEmpty(trim)) {
            return null;
        }
        return Pattern.compile("\\s*\n|\r").matcher(trim).replaceAll("");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public String m6962d() {
        return m6955a(this.f10198c.getText().toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m6964e() {
        String obj = this.f10198c.getText().toString();
        if (!TextUtils.isEmpty(obj) && TextUtils.getTrimmedLength(obj) >= 1) {
            return true;
        }
        this.f10196a.showToast(IMResource.getString(R.string.im_content_cant_null));
        return false;
    }
}
