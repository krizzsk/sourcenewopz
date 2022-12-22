package com.didi.onekeyshare.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.didi.onekeyshare.entity.ShareInstrInfo;
import com.didi.onekeyshare.util.ShareUtil;
import com.taxis99.R;

public class ShareInstructView extends LinearLayout {

    /* renamed from: a */
    private RecyclerView f29785a;

    /* renamed from: b */
    private TextView f29786b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ShareInstrInfo f29787c;

    /* renamed from: d */
    private InstructAdapter f29788d;

    public ShareInstructView(Context context) {
        super(context);
        m20902a();
    }

    public ShareInstructView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20902a();
    }

    public ShareInstructView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20902a();
    }

    public ShareInstructView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m20902a();
    }

    /* renamed from: a */
    private void m20902a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.share_instruct_layout, this);
        this.f29786b = (TextView) inflate.findViewById(R.id.share_instr_title);
        this.f29785a = (RecyclerView) inflate.findViewById(R.id.share_instr_content);
        this.f29785a.setLayoutManager(new GridLayoutManager(getContext(), 2));
        this.f29785a.addItemDecoration(new RecyclerView.ItemDecoration() {
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                if (recyclerView.getChildCount() != 0) {
                    rect.top = ShareUtil.dip2px(ShareInstructView.this.getContext(), 10.0f);
                }
            }
        });
    }

    public void setData(ShareInstrInfo shareInstrInfo) {
        if (shareInstrInfo != null) {
            this.f29787c = shareInstrInfo;
            TextView textView = this.f29786b;
            if (textView != null) {
                textView.setText(shareInstrInfo.title);
            }
            InstructAdapter instructAdapter = this.f29788d;
            if (instructAdapter == null) {
                InstructAdapter instructAdapter2 = new InstructAdapter();
                this.f29788d = instructAdapter2;
                this.f29785a.setAdapter(instructAdapter2);
                return;
            }
            instructAdapter.notifyDataSetChanged();
        }
    }

    public class InstructAdapter extends RecyclerView.Adapter<ViewHolder> {
        public InstructAdapter() {
        }

        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View inflate = LayoutInflater.from(ShareInstructView.this.getContext()).inflate(R.layout.share_instruct_item, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder(inflate);
            viewHolder.imageView = (ImageView) inflate.findViewById(R.id.share_instrcut_content_iv);
            viewHolder.textView = (TextView) inflate.findViewById(R.id.share_instruct_content_tv);
            return viewHolder;
        }

        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            if (ShareInstructView.this.f29787c != null && ShareInstructView.this.f29787c.item != null && ShareInstructView.this.f29787c.item.size() != 0) {
                ShareInstrInfo.InstrContent instrContent = ShareInstructView.this.f29787c.item.get(i);
                if (viewHolder != null) {
                    viewHolder.textView.setText(instrContent.item_text);
                    Glide.with(ShareInstructView.this.getContext()).load(instrContent.item_icon).placeholder(R.drawable.share_instr_content_icon).error(R.drawable.share_instr_content_icon).into(viewHolder.imageView);
                }
            }
        }

        public int getItemCount() {
            if (ShareInstructView.this.f29787c == null || ShareInstructView.this.f29787c.item == null) {
                return 0;
            }
            return ShareInstructView.this.f29787c.item.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;
            public TextView textView;

            public ViewHolder(View view) {
                super(view);
            }
        }
    }
}
