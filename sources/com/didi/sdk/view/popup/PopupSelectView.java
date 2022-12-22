package com.didi.sdk.view.popup;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.taxis99.R;
import java.util.List;

public class PopupSelectView extends FrameLayout {

    /* renamed from: a */
    private Context f38163a;

    /* renamed from: b */
    private TextView f38164b;

    /* renamed from: c */
    private TextView f38165c;

    /* renamed from: d */
    private PopupSelectRecyclerView f38166d;

    /* renamed from: e */
    private List<PopupSelectModel> f38167e;

    /* renamed from: f */
    private PopupSelectRecyclerViewAdapter f38168f;

    /* renamed from: g */
    private ImageView f38169g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnPopupSelectListClickListener f38170h;

    public interface OnPopupSelectListClickListener {
        void onCloseButtonClick();

        void onItemClick(int i);
    }

    public PopupSelectView(Context context) {
        super(context);
        this.f38163a = context;
        m26985a();
    }

    public PopupSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38163a = context;
        m26985a();
    }

    public PopupSelectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f38163a = context;
        m26985a();
    }

    /* renamed from: a */
    private void m26985a() {
        LayoutInflater.from(this.f38163a).inflate(R.layout.global_popup_select_view_layout, this);
        this.f38166d = (PopupSelectRecyclerView) findViewById(R.id.recycler_view);
        this.f38164b = (TextView) findViewById(R.id.title);
        this.f38165c = (TextView) findViewById(R.id.content);
        this.f38169g = (ImageView) findViewById(R.id.close_button);
        this.f38168f = new PopupSelectRecyclerViewAdapter(this.f38163a);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f38163a);
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.f38166d.setLayoutManager(linearLayoutManager);
        this.f38166d.setAdapter(this.f38168f);
        m26986b();
    }

    /* renamed from: b */
    private void m26986b() {
        ImageView imageView = this.f38169g;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (PopupSelectView.this.f38170h != null) {
                        PopupSelectView.this.f38170h.onCloseButtonClick();
                    }
                }
            });
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f38164b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(int i) {
        TextView textView = this.f38164b;
        if (textView != null) {
            textView.setText(i);
        }
    }

    public void setContent(String str) {
        TextView textView = this.f38165c;
        if (textView != null) {
            textView.setText(str);
            if (TextUtils.isEmpty(str)) {
                this.f38165c.setVisibility(8);
            } else {
                this.f38165c.setVisibility(0);
            }
        }
    }

    public void setContent(int i) {
        TextView textView = this.f38165c;
        if (textView != null) {
            textView.setText(i);
            this.f38165c.setVisibility(0);
        }
    }

    public void setItems(List<PopupSelectModel> list) {
        this.f38167e = list;
        PopupSelectRecyclerViewAdapter popupSelectRecyclerViewAdapter = this.f38168f;
        if (popupSelectRecyclerViewAdapter != null) {
            popupSelectRecyclerViewAdapter.updateItems(list);
        }
    }

    public void setOnPopupSelectListClickListener(OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f38170h = onPopupSelectListClickListener;
        PopupSelectRecyclerViewAdapter popupSelectRecyclerViewAdapter = this.f38168f;
        if (popupSelectRecyclerViewAdapter != null) {
            popupSelectRecyclerViewAdapter.setOnPopupSelectListClickListener(onPopupSelectListClickListener);
        }
    }

    public void setSelectedPosition(int i) {
        List<PopupSelectModel> list;
        if (this.f38168f != null && (list = this.f38167e) != null && list.size() > i) {
            this.f38168f.setSelectItem(this.f38167e.get(i).f38171id);
        }
    }

    public void setSelectedId(String str) {
        if (this.f38168f != null && this.f38167e != null && !TextUtils.isEmpty(str)) {
            this.f38168f.setSelectItem(str);
        }
    }

    public void setMaxHeight(int i) {
        PopupSelectRecyclerView popupSelectRecyclerView = this.f38166d;
        if (popupSelectRecyclerView != null) {
            popupSelectRecyclerView.setMaxHeight(i);
        }
    }

    public void notifyDataSetChanged() {
        PopupSelectRecyclerViewAdapter popupSelectRecyclerViewAdapter = this.f38168f;
        if (popupSelectRecyclerViewAdapter != null) {
            popupSelectRecyclerViewAdapter.notifyDataSetChanged();
        }
    }
}
