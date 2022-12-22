package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.evaluateentrance.evaluate.model.EvaluateQuestionItemModel;
import com.taxis99.R;
import java.util.List;

public class EvaluateQuestionItemAdapter extends RecyclerView.Adapter {

    /* renamed from: a */
    private static final int f13506a = 1;

    /* renamed from: b */
    private static final int f13507b = 2;

    /* renamed from: c */
    private List<EvaluateQuestionItemModel> f13508c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Context f13509d;

    /* renamed from: e */
    private boolean f13510e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public OnSelectedListener f13511f;

    public interface OnSelectedListener {
        void onSelected(int i);
    }

    public void setData(List<EvaluateQuestionItemModel> list, Context context, boolean z) {
        this.f13508c = list;
        this.f13509d = context;
        this.f13510e = z;
        notifyDataSetChanged();
    }

    public void updateData(List<EvaluateQuestionItemModel> list) {
        this.f13508c = list;
        notifyDataSetChanged();
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.f13511f = onSelectedListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BaseViewHolder(LayoutInflater.from(this.f13509d).inflate(i == 2 ? R.layout.g_xp_evaluate_question_vertical_item : R.layout.g_xp_evaluate_question_horizontal_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((BaseViewHolder) viewHolder).bindData(i, this.f13508c.get(i));
    }

    public int getItemCount() {
        List<EvaluateQuestionItemModel> list = this.f13508c;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public int getItemViewType(int i) {
        return this.f13510e ? 2 : 1;
    }

    public void updateHorizontalData(int i) {
        try {
            int i2 = 1;
            this.f13508c.get(i).selected = true;
            notifyItemChanged(i);
            if (i != 0) {
                i2 = 0;
            }
            this.f13508c.remove(i2);
            notifyItemRemoved(i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public class BaseViewHolder extends RecyclerView.ViewHolder {
        private ImageView iconView;
        private TextView titleView;

        public BaseViewHolder(View view) {
            super(view);
            this.iconView = (ImageView) view.findViewById(R.id.g_xp_evaluate_question_icon);
            this.titleView = (TextView) view.findViewById(R.id.g_xp_evaluate_question_title);
        }

        public void bindData(final int i, EvaluateQuestionItemModel evaluateQuestionItemModel) {
            if (evaluateQuestionItemModel != null) {
                if (!evaluateQuestionItemModel.selected) {
                    this.itemView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (EvaluateQuestionItemAdapter.this.f13511f != null) {
                                EvaluateQuestionItemAdapter.this.f13511f.onSelected(i);
                            }
                        }
                    });
                } else {
                    this.itemView.setOnClickListener((View.OnClickListener) null);
                }
                if (evaluateQuestionItemModel != null) {
                    if (!TextUtils.isEmpty(evaluateQuestionItemModel.iconUrl)) {
                        this.iconView.setVisibility(0);
                        this.itemView.setBackground((Drawable) null);
                        Glide.with(this.iconView.getContext()).load(evaluateQuestionItemModel.iconUrl).into(this.iconView);
                        if (evaluateQuestionItemModel.selected) {
                            this.titleView.setVisibility(8);
                        } else {
                            this.titleView.setVisibility(0);
                        }
                    } else {
                        this.iconView.setVisibility(8);
                        this.titleView.setVisibility(0);
                        if (evaluateQuestionItemModel.selected) {
                            this.itemView.setBackgroundResource(R.drawable.g_xp_evaluate_question_selected);
                            this.titleView.setTextColor(EvaluateQuestionItemAdapter.this.f13509d.getResources().getColor(R.color.g_color_ffffff));
                        } else {
                            this.titleView.setTextColor(EvaluateQuestionItemAdapter.this.f13509d.getResources().getColor(R.color.g_color_000));
                            this.itemView.setBackgroundResource(R.drawable.g_xp_evaluate_question_unselected);
                        }
                    }
                    if (!TextUtils.isEmpty(evaluateQuestionItemModel.text)) {
                        this.titleView.setText(evaluateQuestionItemModel.text);
                    }
                }
            }
        }
    }
}
