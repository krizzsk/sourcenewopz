package com.didi.dimina.starbox.module.jsbridge.fileexplorer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.dimina.starbox.p107ui.base.AbsRecyclerAdapter;
import com.didi.dimina.starbox.p107ui.base.AbsViewBinder;
import com.taxis99.R;

public class TextContentAdapter extends AbsRecyclerAdapter<AbsViewBinder<String>, String> {
    public TextContentAdapter(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public AbsViewBinder<String> createViewHolder(View view, int i) {
        return new TextContentViewHolder(view);
    }

    /* access modifiers changed from: protected */
    public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        return layoutInflater.inflate(R.layout.dimina_starbox_item_text_content, viewGroup, false);
    }

    private class TextContentViewHolder extends AbsViewBinder<String> {
        private TextView mTextView;

        public TextContentViewHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public void getViews() {
            this.mTextView = (TextView) getView(R.id.text);
        }

        public void bind(String str) {
            this.mTextView.setText(str);
        }
    }
}
