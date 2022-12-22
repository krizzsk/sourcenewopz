package com.didiglobal.eevee.mew.widget.titlebar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.taxis99.R;

public class EeveeTopBarView implements EeveeIView<C16807a> {

    /* renamed from: a */
    private C16807a f50087a;

    /* renamed from: b */
    private ViewGroup f50088b;

    /* renamed from: c */
    private ImageView f50089c;

    public void setView() {
    }

    public View getView() {
        return this.f50088b;
    }

    public EeveeTopBarView(Context context) {
        m36089a(context);
    }

    public void setPresenter(C16807a aVar) {
        this.f50087a = aVar;
    }

    /* renamed from: a */
    private void m36089a(Context context) {
        ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.layout_top_bar, (ViewGroup) null);
        this.f50088b = viewGroup;
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.eevee_top_bar_back);
        this.f50089c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                EeveeTopBarView.this.m36090a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m36090a(View view) {
        this.f50087a.mo122485a();
    }
}
