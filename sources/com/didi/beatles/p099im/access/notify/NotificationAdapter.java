package com.didi.beatles.p099im.access.notify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.didi.beatles.p099im.resource.IMResource;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.access.notify.NotificationAdapter */
public class NotificationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int TYPE_FOOTER = 1;
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 2;

    /* renamed from: a */
    private List<String> f8798a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MyItemClickListener f8799b;

    /* renamed from: c */
    private View f8800c;

    /* renamed from: d */
    private View f8801d;

    /* renamed from: e */
    private Context f8802e;

    /* renamed from: com.didi.beatles.im.access.notify.NotificationAdapter$MyItemClickListener */
    public interface MyItemClickListener {
        void onItemClick(ViewHolder viewHolder, String str);
    }

    public NotificationAdapter(Context context, List<String> list) {
        this.f8798a = list;
        this.f8802e = context;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = this.f8800c;
        if (view != null && i == 0) {
            return new ViewHolder(view);
        }
        View view2 = this.f8801d;
        if (view2 != null && i == 1) {
            return new ViewHolder(view2);
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_notify_item_layout, viewGroup, false);
        inflate.setBackgroundResource(IMResource.getDrawableID(R.drawable.bts_im_notify_selector));
        final ViewHolder viewHolder = new ViewHolder(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (NotificationAdapter.this.f8799b != null) {
                    NotificationAdapter.this.f8799b.onItemClick(viewHolder, (String) view.getTag());
                    MyItemClickListener unused = NotificationAdapter.this.f8799b = null;
                }
            }
        });
        return viewHolder;
    }

    public void showHasSend(ViewHolder viewHolder) {
        if (viewHolder != null) {
            viewHolder.tvHasSend.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
            viewHolder.tvHasSend.setVisibility(0);
        }
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 2) {
            if (this.f8800c != null) {
                i--;
            }
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.itemView.setTag(IMTextUtils.getContent(this.f8798a.get(i)));
            viewHolder2.textViewMain.setText(IMTextUtils.getContent(this.f8798a.get(i)));
        }
    }

    public int getItemViewType(int i) {
        if (i != 0 || this.f8800c == null) {
            return (i != getItemCount() - 1 || this.f8801d == null) ? 2 : 1;
        }
        return 0;
    }

    public int getItemCount() {
        int i = this.f8800c != null ? 1 : 0;
        if (this.f8801d != null) {
            i++;
        }
        List<String> list = this.f8798a;
        return list != null ? list.size() + i : i;
    }

    public void setOnItemClickListener(MyItemClickListener myItemClickListener) {
        this.f8799b = myItemClickListener;
    }

    public View getHeaderView() {
        return this.f8800c;
    }

    public void setHeaderView(View view) {
        this.f8800c = view;
        notifyItemInserted(0);
    }

    public View getFooterView() {
        return this.f8801d;
    }

    public void setFooterView(View view) {
        this.f8801d = view;
        notifyItemInserted(getItemCount() - 1);
    }

    /* renamed from: com.didi.beatles.im.access.notify.NotificationAdapter$ViewHolder */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public TextView textViewMain;
        /* access modifiers changed from: private */
        public TextView tvHasSend;

        public ViewHolder(View view) {
            super(view);
            this.textViewMain = (TextView) view.findViewById(R.id.recycler_item_tv_main);
            this.tvHasSend = (TextView) view.findViewById(R.id.recycler_item_tv_has_send);
        }
    }
}
