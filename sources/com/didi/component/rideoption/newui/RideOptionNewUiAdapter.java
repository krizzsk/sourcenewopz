package com.didi.component.rideoption.newui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class RideOptionNewUiAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    /* renamed from: a */
    private LayoutInflater f15316a;

    /* renamed from: b */
    private Context f15317b;

    /* renamed from: c */
    private List<PopupSelectModel> f15318c;

    /* renamed from: d */
    private String f15319d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public PopupSelectView.OnPopupSelectListClickListener f15320e;

    public int getItemViewType(int i) {
        return 0;
    }

    public RideOptionNewUiAdapter(Context context) {
        this.f15316a = LayoutInflater.from(context);
        this.f15318c = new ArrayList();
        this.f15317b = context;
    }

    public void updateItems(List<PopupSelectModel> list) {
        this.f15318c = list;
        notifyDataSetChanged();
    }

    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemViewHolder(this.f15316a.inflate(R.layout.global_ride_option_new_ui_select_view_item, viewGroup, false));
    }

    public void onBindViewHolder(ItemViewHolder itemViewHolder, final int i) {
        String str = this.f15318c.get(i).name;
        if (!TextUtils.isEmpty(str)) {
            itemViewHolder.name.setText(str);
        }
        if (this.f15319d.equals(this.f15318c.get(i).f38171id)) {
            itemViewHolder.img.setImageResource(DidiThemeManager.getIns().getResPicker(this.f15317b).getResIdByTheme(R.attr.new_ui_common_icon_radio_large));
        } else {
            itemViewHolder.img.setImageResource(R.drawable.com_icon_radio_large_unsel);
        }
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (RideOptionNewUiAdapter.this.f15320e != null) {
                    RideOptionNewUiAdapter.this.f15320e.onItemClick(i);
                }
            }
        });
    }

    public int getItemCount() {
        List<PopupSelectModel> list = this.f15318c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public void setSelectItem(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f15319d = str;
            notifyDataSetChanged();
        }
    }

    public void setOnPopupSelectListClickListener(PopupSelectView.OnPopupSelectListClickListener onPopupSelectListClickListener) {
        this.f15320e = onPopupSelectListClickListener;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name;

        public ItemViewHolder(View view) {
            super(view);
            this.img = (ImageView) view.findViewById(R.id.select_item_icon);
            this.name = (TextView) view.findViewById(R.id.select_item_name);
        }
    }
}
