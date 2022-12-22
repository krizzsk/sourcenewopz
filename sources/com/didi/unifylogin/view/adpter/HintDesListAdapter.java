package com.didi.unifylogin.view.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.base.net.pojo.entity.PromptContent;
import com.didi.unifylogin.utils.HighlightUtil;
import com.taxis99.R;
import java.util.List;

public class HintDesListAdapter extends BaseAdapter {

    /* renamed from: a */
    Context f45085a;

    /* renamed from: b */
    List<PromptContent> f45086b;

    public long getItemId(int i) {
        return (long) i;
    }

    public HintDesListAdapter(Context context, List<PromptContent> list) {
        this.f45085a = context;
        this.f45086b = list;
    }

    public int getCount() {
        return this.f45086b.size();
    }

    public Object getItem(int i) {
        return this.f45086b.get(i);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(this.f45085a).inflate(R.layout.login_unify_item_list_hint_des, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.tag = (TextView) view.findViewById(R.id.tv_tag);
            viewHolder.des = (TextView) view.findViewById(R.id.tv_des);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        PromptContent promptContent = this.f45086b.get(i);
        if (promptContent == null || TextUtil.isEmpty(promptContent.getMsg())) {
            viewHolder.des.setVisibility(8);
        } else {
            viewHolder.des.setVisibility(0);
            viewHolder.des.setText(HighlightUtil.highlight(promptContent.getMsg()));
            if (promptContent.getType() == 1) {
                viewHolder.des.setTextColor(this.f45085a.getResources().getColor(R.color.login_unify_color_cancel_des_error));
            } else {
                viewHolder.des.setTextColor(this.f45085a.getResources().getColor(R.color.login_unify_color_cancel_des_normal));
            }
        }
        if (!TextUtil.isEmpty(promptContent.getTag())) {
            viewHolder.tag.setText(HighlightUtil.highlight(promptContent.getTag()));
        }
        return view;
    }

    class ViewHolder {
        TextView des;
        TextView tag;

        ViewHolder() {
        }
    }
}
