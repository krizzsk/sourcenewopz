package com.didichuxing.diface.appeal.mexico.adapter;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.didichuxing.diface.appeal.mexico.model.AppealAdditionTypesBean;
import com.taxis99.R;

public class DocSelectAdapter extends AbsAdapter<AppealAdditionTypesBean, DocViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f47078a = 0;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.layout_doc_select_item;
    }

    public DocSelectAdapter(Context context) {
        super(context);
        setOnItemClickListener(new OnItemClickListener<AppealAdditionTypesBean>() {
            public void onClick(View view, int i, AppealAdditionTypesBean appealAdditionTypesBean) {
                int unused = DocSelectAdapter.this.f47078a = i;
                DocSelectAdapter.this.notifyDataSetChanged();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void bindViewHolder(DocViewHolder docViewHolder, int i, AppealAdditionTypesBean appealAdditionTypesBean) {
        if (this.f47078a == i) {
            docViewHolder.cbSelect.setChecked(true);
        } else {
            docViewHolder.cbSelect.setChecked(false);
        }
        docViewHolder.tvTitle.setText(appealAdditionTypesBean.getTitle());
        docViewHolder.tvDesc.setText(appealAdditionTypesBean.getDesc());
    }

    /* access modifiers changed from: protected */
    public DocViewHolder createViewHolder(View view) {
        return new DocViewHolder(view);
    }

    public static final class DocViewHolder extends ViewHolder {
        public final CheckBox cbSelect;
        public final TextView tvDesc;
        public final TextView tvTitle;

        public DocViewHolder(View view) {
            super(view);
            this.cbSelect = (CheckBox) view.findViewById(R.id.cb_select);
            this.tvTitle = (TextView) view.findViewById(R.id.tv_title);
            this.tvDesc = (TextView) view.findViewById(R.id.tv_desc);
        }
    }

    public AppealAdditionTypesBean getCurrent() {
        return (AppealAdditionTypesBean) getItem(this.f47078a);
    }
}
