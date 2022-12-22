package com.didi.sdk.global.indexbar.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

@Deprecated
public class SearchView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f36180a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f36181b;

    /* renamed from: c */
    private Context f36182c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnSearchListener f36183d;

    public interface OnSearchListener {
        void onSearch(String str);
    }

    public SearchView(Context context) {
        super(context);
        m25559a(context);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25559a(context);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25559a(context);
    }

    /* renamed from: a */
    private void m25559a(Context context) {
        this.f36182c = context;
        inflate(context, R.layout.one_payment_search_view, this);
        EditText editText = (EditText) findViewById(R.id.et_search);
        this.f36180a = editText;
        editText.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                SearchView.this.f36181b.setVisibility(editable.length() > 0 ? 0 : 8);
                if (SearchView.this.f36183d != null) {
                    SearchView.this.f36183d.onSearch(editable.toString());
                }
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.iv_clear);
        this.f36181b = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SearchView.this.f36180a.setText("");
                if (SearchView.this.f36183d != null) {
                    SearchView.this.f36183d.onSearch((String) null);
                }
            }
        });
    }

    public void setOnSearchListener(OnSearchListener onSearchListener) {
        this.f36183d = onSearchListener;
    }
}
