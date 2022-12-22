package com.didi.dimina.container.p106ui.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.dialog.ActionSheetItemView */
public class ActionSheetItemView extends RelativeLayout {

    /* renamed from: a */
    TextView f17534a;

    /* renamed from: b */
    private ActionSheetItemClick f17535b;

    /* renamed from: com.didi.dimina.container.ui.dialog.ActionSheetItemView$ActionSheetItemClick */
    public interface ActionSheetItemClick {
        void onClick();
    }

    public ActionSheetItemView(Context context) {
        super(context);
        m13051a();
    }

    /* renamed from: a */
    private void m13051a() {
        LayoutInflater.from(getContext()).inflate(R.layout.dimina_item_action_sheet, this);
        TextView textView = (TextView) findViewById(R.id.action_sheet_text);
        this.f17534a = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ActionSheetItemView.this.m13052a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m13052a(View view) {
        ActionSheetItemClick actionSheetItemClick = this.f17535b;
        if (actionSheetItemClick != null) {
            actionSheetItemClick.onClick();
        }
    }

    public void setTextValue(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            this.f17534a.setText(str);
            this.f17534a.setTextColor(i);
        }
    }

    public void setActionSheetItemClick(ActionSheetItemClick actionSheetItemClick) {
        this.f17535b = actionSheetItemClick;
    }
}
