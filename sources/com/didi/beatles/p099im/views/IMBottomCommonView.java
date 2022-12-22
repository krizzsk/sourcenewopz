package com.didi.beatles.p099im.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.beatles.p099im.resource.IMResource;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.IMBottomCommonView */
public class IMBottomCommonView extends LinearLayout {

    /* renamed from: a */
    private ListView f9858a;

    /* renamed from: b */
    private List<String> f9859b;

    /* renamed from: c */
    private CommonAdapter f9860c;

    public IMBottomCommonView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBottomCommonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.bts_im_bottom_common, this, true);
        this.f9858a = (ListView) findViewById(R.id.bottom_list);
        m6670a(context);
    }

    /* renamed from: a */
    private void m6670a(Context context) {
        CommonAdapter commonAdapter = new CommonAdapter(this.f9859b, context);
        this.f9860c = commonAdapter;
        this.f9858a.setAdapter(commonAdapter);
    }

    public void setDatas(List<String> list) {
        this.f9859b = list;
        this.f9860c.notifyDataSetChanged();
    }

    /* renamed from: com.didi.beatles.im.views.IMBottomCommonView$CommonAdapter */
    public class CommonAdapter extends BaseAdapter {
        private List<String> datas = new ArrayList();
        private Context mContext;

        public int getCount() {
            return 6;
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public CommonAdapter(List<String> list, Context context) {
            this.mContext = context;
        }

        public Object getItem(int i) {
            return this.datas.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHodler viewHodler;
            if (view == null) {
                viewHodler = new ViewHodler();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.bts_common_item_layout, (ViewGroup) null);
                viewHodler.f9861tv = (TextView) view.findViewById(R.id.common_text);
                view.setTag(viewHodler);
            } else {
                viewHodler = (ViewHodler) view.getTag();
            }
            viewHodler.f9861tv.setText(IMResource.getString(R.string.im_say_hi));
            return view;
        }

        /* renamed from: com.didi.beatles.im.views.IMBottomCommonView$CommonAdapter$ViewHodler */
        class ViewHodler {

            /* renamed from: tv */
            TextView f9861tv;

            ViewHodler() {
            }
        }
    }
}
