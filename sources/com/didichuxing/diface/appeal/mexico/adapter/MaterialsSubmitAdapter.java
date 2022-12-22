package com.didichuxing.diface.appeal.mexico.adapter;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.didichuxing.diface.appeal.mexico.model.DocumentCardsBean;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class MaterialsSubmitAdapter extends AbsAdapter<DocumentCardsBean, MaterialsSubmitViewHolder> {

    /* renamed from: a */
    private final List<DocumentCardsBean> f47079a = new ArrayList();

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.layout_materials_submit_item;
    }

    public MaterialsSubmitAdapter(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void bindViewHolder(MaterialsSubmitViewHolder materialsSubmitViewHolder, int i, DocumentCardsBean documentCardsBean) {
        materialsSubmitViewHolder.tvTitle.setText(documentCardsBean.getDocName());
        materialsSubmitViewHolder.tvDesc.setText(documentCardsBean.getDocDesc());
        if (this.f47079a.contains(documentCardsBean)) {
            materialsSubmitViewHolder.tvTakePhoto.setText(R.string.df_retake_photo);
        } else {
            materialsSubmitViewHolder.tvTakePhoto.setText(R.string.df_take_photo);
        }
    }

    /* access modifiers changed from: protected */
    public MaterialsSubmitViewHolder createViewHolder(View view) {
        return new MaterialsSubmitViewHolder(view);
    }

    public void takeDone(DocumentCardsBean documentCardsBean) {
        if (!this.f47079a.contains(documentCardsBean)) {
            this.f47079a.add(documentCardsBean);
            notifyDataSetChanged();
        }
    }

    public static final class MaterialsSubmitViewHolder extends ViewHolder {
        public final TextView tvDesc;
        public final TextView tvTakePhoto;
        public final TextView tvTitle;

        public MaterialsSubmitViewHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.iv_doc_type_title);
            this.tvDesc = (TextView) view.findViewById(R.id.iv_doc_type_desc);
            this.tvTakePhoto = (TextView) view.findViewById(R.id.iv_doc_type_take_photo);
        }
    }
}
