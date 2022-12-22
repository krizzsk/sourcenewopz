package com.didi.onehybrid.devmode.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onehybrid.devmode.interfaces.OnItemClickListener;
import com.taxis99.R;

public class Title extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public OnItemClickListener f29587a;

    /* renamed from: b */
    private TextView f29588b;

    public Title(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20807a(context);
    }

    /* renamed from: a */
    private void m20807a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.title, this);
        this.f29588b = (TextView) inflate.findViewById(R.id.title_name);
        ((TextView) inflate.findViewById(R.id.btn_title_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (Title.this.f29587a != null) {
                    Title.this.f29587a.onClickItem();
                }
            }
        });
    }

    public void setTitleName(String str) {
        this.f29588b.setText(str);
    }

    public void setOnClickLinstener(OnItemClickListener onItemClickListener) {
        this.f29587a = onItemClickListener;
    }
}
