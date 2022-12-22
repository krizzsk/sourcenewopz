package com.didi.addressnew.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;
import java.util.ArrayList;

public class EmptyView<T> extends FrameLayout {

    /* renamed from: a */
    private View f7649a;

    /* renamed from: b */
    private TextView f7650b;

    /* renamed from: c */
    private ListView f7651c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View.OnClickListener f7652d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public OnSelectAddressListener f7653e;

    /* renamed from: f */
    private ArrayList<EmptyViewItem> f7654f;

    public interface OnSelectAddressListener<T> {
        void onSelect(T t);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public EmptyView(Context context) {
        this(context, (AttributeSet) null);
    }

    public EmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7649a = null;
        this.f7650b = null;
        this.f7651c = null;
        this.f7652d = null;
        this.f7653e = null;
        this.f7654f = null;
        LayoutInflater.from(context).inflate(R.layout.poi_one_address_view_empty, this);
        View findViewById = findViewById(R.id.layout_error);
        this.f7649a = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EmptyView.this.f7652d != null) {
                    EmptyView.this.f7652d.onClick(view);
                }
            }
        });
        this.f7650b = (TextView) findViewById(R.id.text_error_title);
        ListView listView = (ListView) findViewById(R.id.list_error);
        this.f7651c = listView;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* JADX WARNING: type inference failed for: r1v0, types: [android.widget.AdapterView<?>, android.widget.AdapterView] */
            /* JADX WARNING: Unknown variable types count: 1 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void onItemClick(android.widget.AdapterView<?> r1, android.view.View r2, int r3, long r4) {
                /*
                    r0 = this;
                    com.didi.autotracker.AutoTrackHelper.trackViewOnClick((android.widget.AdapterView) r1, (android.view.View) r2, (int) r3)
                    android.widget.Adapter r1 = r1.getAdapter()     // Catch:{ Exception -> 0x0057 }
                    java.lang.Object r1 = r1.getItem(r3)     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.EmptyViewItem r1 = (com.didi.addressnew.widget.EmptyViewItem) r1     // Catch:{ Exception -> 0x0057 }
                    if (r1 == 0) goto L_0x0057
                    int r3 = r1.emptyViewType     // Catch:{ Exception -> 0x0057 }
                    r4 = 2
                    if (r3 != r4) goto L_0x0026
                    com.didi.addressnew.widget.EmptyView r1 = com.didi.addressnew.widget.EmptyView.this     // Catch:{ Exception -> 0x0057 }
                    android.view.View$OnClickListener r1 = r1.f7652d     // Catch:{ Exception -> 0x0057 }
                    if (r1 == 0) goto L_0x0057
                    com.didi.addressnew.widget.EmptyView r1 = com.didi.addressnew.widget.EmptyView.this     // Catch:{ Exception -> 0x0057 }
                    android.view.View$OnClickListener r1 = r1.f7652d     // Catch:{ Exception -> 0x0057 }
                    r1.onClick(r2)     // Catch:{ Exception -> 0x0057 }
                    goto L_0x0057
                L_0x0026:
                    int r2 = r1.emptyViewType     // Catch:{ Exception -> 0x0057 }
                    r3 = 1
                    if (r2 != r3) goto L_0x003f
                    com.didi.addressnew.widget.EmptyView r2 = com.didi.addressnew.widget.EmptyView.this     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.EmptyView$OnSelectAddressListener r2 = r2.f7653e     // Catch:{ Exception -> 0x0057 }
                    if (r2 == 0) goto L_0x0057
                    com.didi.addressnew.widget.EmptyView r2 = com.didi.addressnew.widget.EmptyView.this     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.EmptyView$OnSelectAddressListener r2 = r2.f7653e     // Catch:{ Exception -> 0x0057 }
                    T r1 = r1.address     // Catch:{ Exception -> 0x0057 }
                    r2.onSelect(r1)     // Catch:{ Exception -> 0x0057 }
                    goto L_0x0057
                L_0x003f:
                    int r2 = r1.emptyViewType     // Catch:{ Exception -> 0x0057 }
                    r3 = 3
                    if (r2 != r3) goto L_0x0057
                    com.didi.addressnew.widget.EmptyView r2 = com.didi.addressnew.widget.EmptyView.this     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.EmptyView$OnSelectAddressListener r2 = r2.f7653e     // Catch:{ Exception -> 0x0057 }
                    if (r2 == 0) goto L_0x0057
                    com.didi.addressnew.widget.EmptyView r2 = com.didi.addressnew.widget.EmptyView.this     // Catch:{ Exception -> 0x0057 }
                    com.didi.addressnew.widget.EmptyView$OnSelectAddressListener r2 = r2.f7653e     // Catch:{ Exception -> 0x0057 }
                    T r1 = r1.address     // Catch:{ Exception -> 0x0057 }
                    r2.onSelect(r1)     // Catch:{ Exception -> 0x0057 }
                L_0x0057:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.widget.EmptyView.C33782.onItemClick(android.widget.AdapterView, android.view.View, int, long):void");
            }
        });
    }

    public void setEmptyClickListener(View.OnClickListener onClickListener) {
        this.f7652d = onClickListener;
    }

    public void setSelectAddressListener(OnSelectAddressListener onSelectAddressListener) {
        this.f7653e = onSelectAddressListener;
    }

    public void showError(CharSequence charSequence) {
        this.f7649a.setVisibility(0);
        this.f7650b.setText(charSequence);
        this.f7651c.setVisibility(8);
    }
}
