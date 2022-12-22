package com.didi.beatles.p099im.views.dialog.addWord;

import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.beatles.p099im.common.IMInputFilter;
import com.didi.beatles.p099im.event.IMAddCustomWordEvent;
import com.didi.beatles.p099im.omega.IMMsgOmega;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.views.dialog.IMAddCommonWordDialog;
import com.taxis99.R;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.dialog.addWord.IMAddCommonWordDefault */
public class IMAddCommonWordDefault implements IMAddCommonWord {

    /* renamed from: a */
    private View.OnClickListener f10187a;

    /* renamed from: b */
    private TextView f10188b;

    /* renamed from: c */
    private TextView f10189c;

    /* renamed from: d */
    private EditText f10190d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f10191e;

    /* renamed from: f */
    private View f10192f;

    /* renamed from: g */
    private EditText f10193g;

    /* renamed from: h */
    private View f10194h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IMAddCommonWordDialog f10195i;

    public int layoutRes() {
        return R.layout.im_add_common_word_view;
    }

    public void release() {
    }

    public void bind(IMAddCommonWordDialog iMAddCommonWordDialog) {
        this.f10195i = iMAddCommonWordDialog;
        m6946a();
    }

    /* renamed from: a */
    private void m6946a() {
        this.f10190d = (EditText) this.f10195i.findViewById(R.id.im_add_common_word_et);
        TextView textView = (TextView) this.f10195i.findViewById(R.id.im_word_count);
        this.f10191e = textView;
        textView.setText(String.format(this.f10195i.getString(R.string.im_word_count_string), new Object[]{0}));
        IMInputFilter iMInputFilter = new IMInputFilter(60);
        this.f10190d.setFilters(new InputFilter[]{iMInputFilter});
        this.f10188b = (TextView) this.f10195i.findViewById(R.id.im_add_common_word_cancel_btn);
        this.f10189c = (TextView) this.f10195i.findViewById(R.id.im_add_common_word_confirm_btn);
        this.f10192f = this.f10195i.findViewById(R.id.im_add_word_view);
        if (this.f10195i.mCommondWordType == 2) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f10195i.getString(R.string.im_custom_word));
            String str = "";
            if (this.f10195i.mCustomWordNum != -1) {
                StringBuilder sb2 = new StringBuilder();
                IMAddCommonWordDialog iMAddCommonWordDialog = this.f10195i;
                int i = iMAddCommonWordDialog.mCustomWordNum + 1;
                iMAddCommonWordDialog.mCustomWordNum = i;
                sb2.append(i);
                sb2.append(str);
                str = sb2.toString();
            }
            sb.append(str);
            String sb3 = sb.toString();
            EditText editText = (EditText) this.f10195i.findViewById(R.id.im_add_common_word_title_et);
            this.f10193g = editText;
            editText.setText(sb3);
            EditText editText2 = this.f10193g;
            int i2 = 10;
            if (sb3.length() <= 10) {
                i2 = sb3.length();
            }
            editText2.setSelection(i2);
            this.f10194h = this.f10195i.findViewById(R.id.im_add_word_title_icon);
            this.f10192f.setVisibility(0);
        } else {
            this.f10192f.setVisibility(8);
        }
        m6950b();
        m6951c();
        if (!TextUtils.isEmpty(this.f10195i.mContentText)) {
            this.f10190d.setText(this.f10195i.mContentText);
            this.f10190d.setSelection(this.f10190d.getText().toString().length());
        }
    }

    /* renamed from: b */
    private void m6950b() {
        this.f10190d.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int textNum = !TextUtils.isEmpty(charSequence) ? IMTextUtil.getTextNum(charSequence.toString()) : 0;
                if (textNum >= 60) {
                    SpannableString spannableString = new SpannableString(String.format(IMAddCommonWordDefault.this.f10195i.getString(R.string.im_word_count_string), new Object[]{60}));
                    spannableString.setSpan(new ForegroundColorSpan(IMResource.getColor(R.color.im_nomix_orange)), 0, 2, 18);
                    IMAddCommonWordDefault.this.f10191e.setText(spannableString);
                    return;
                }
                IMAddCommonWordDefault.this.f10191e.setTextColor(IMResource.getColor(R.color.im_add_word_count_color));
                IMAddCommonWordDefault.this.f10191e.setText(String.format(IMAddCommonWordDefault.this.f10195i.getString(R.string.im_word_count_string), new Object[]{Integer.valueOf(textNum)}));
            }
        });
    }

    /* renamed from: a */
    private String m6945a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        if (TextUtils.isEmpty(trim)) {
            return null;
        }
        return Pattern.compile("\\s*\n|\r").matcher(trim).replaceAll("");
    }

    /* renamed from: c */
    private void m6951c() {
        C43342 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMAddCommonWordDefault.this.m6947a(view.getId());
            }
        };
        this.f10187a = r0;
        this.f10188b.setOnClickListener(r0);
        this.f10189c.setOnClickListener(this.f10187a);
        if (this.f10195i.mCommondWordType == 2) {
            this.f10194h.setOnClickListener(this.f10187a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6947a(int i) {
        if (i == R.id.im_add_common_word_cancel_btn) {
            HashMap hashMap = new HashMap();
            hashMap.put("source", Integer.valueOf(this.f10195i.mResource));
            IMMsgOmega.getInstance().track("ddim_dy_all_cancel_ck", hashMap);
            this.f10195i.dismiss();
        } else if (i == R.id.im_add_common_word_confirm_btn) {
            if (m6953e()) {
                EventBus.getDefault().post(new IMAddCustomWordEvent(new IMAddCommonWordDialog.CustomWord(m6952d(), this.f10195i.mResource)));
                this.f10195i.dismiss();
            }
        } else if (i == R.id.im_add_word_title_icon) {
            this.f10193g.setText("");
        }
    }

    /* renamed from: d */
    private String m6952d() {
        if (this.f10195i.mCommondWordType == 1) {
            return m6945a(this.f10190d.getText().toString());
        }
        String obj = this.f10193g.getText().toString();
        String obj2 = this.f10190d.getText().toString();
        return obj + IMTextUtils.DEVIDER_TAG + m6945a(obj2);
    }

    /* renamed from: e */
    private boolean m6953e() {
        if (this.f10195i.mCommondWordType == 2) {
            String obj = this.f10193g.getText().toString();
            if (TextUtils.isEmpty(obj) || TextUtils.getTrimmedLength(obj) < 1) {
                this.f10195i.showToast(IMResource.getString(R.string.im_title_cant_null));
                return false;
            }
        }
        String obj2 = this.f10190d.getText().toString();
        if (!TextUtils.isEmpty(obj2) && TextUtils.getTrimmedLength(obj2) >= 1) {
            return true;
        }
        this.f10195i.showToast(IMResource.getString(R.string.im_content_cant_null));
        return false;
    }
}
