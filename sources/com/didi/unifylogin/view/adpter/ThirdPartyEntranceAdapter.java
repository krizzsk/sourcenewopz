package com.didi.unifylogin.view.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.thirdpartylogin.base.AbsThirdPartyLoginBase;
import com.didi.unifylogin.store.LoginStore;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;
import java.util.List;

public class ThirdPartyEntranceAdapter extends BaseAdapter {

    /* renamed from: a */
    Context f45087a;

    /* renamed from: b */
    LayoutInflater f45088b;

    /* renamed from: c */
    List<AbsThirdPartyLoginBase> f45089c;

    /* renamed from: d */
    ItemClickListener f45090d;

    /* renamed from: e */
    int f45091e = 0;

    public interface ItemClickListener {
        void OnItemClickListener(int i);
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public ThirdPartyEntranceAdapter(Context context, ItemClickListener itemClickListener, List<AbsThirdPartyLoginBase> list) {
        this.f45087a = context;
        this.f45089c = list;
        this.f45088b = LayoutInflater.from(context);
        this.f45090d = itemClickListener;
    }

    public void setVersion(int i) {
        this.f45091e = i;
    }

    public int getCount() {
        return this.f45089c.size();
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f45088b.inflate(this.f45091e == 2 ? R.layout.login_unify_view_third_way_v2 : R.layout.login_unify_view_third_way, (ViewGroup) null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.icon = (ImageView) view.findViewById(R.id.iv_icon);
            viewHolder.name = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(viewHolder);
        }
        ViewHolder viewHolder2 = (ViewHolder) view.getTag();
        AbsThirdPartyLoginBase absThirdPartyLoginBase = this.f45089c.get(i);
        viewHolder2.name.setText(absThirdPartyLoginBase.getText());
        viewHolder2.icon.setBackgroundResource(absThirdPartyLoginBase.getIconResource());
        viewHolder2.icon.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (ThirdPartyEntranceAdapter.this.f45090d != null) {
                    ThirdPartyEntranceAdapter.this.f45090d.OnItemClickListener(i);
                }
            }
        });
        DIDIFontUtils.Companion.setTypeface(LoginStore.getContext(), viewHolder2.name);
        return view;
    }

    class ViewHolder {
        ImageView icon;
        TextView name;

        ViewHolder() {
        }
    }
}
