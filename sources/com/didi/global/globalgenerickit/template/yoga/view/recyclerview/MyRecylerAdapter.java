package com.didi.global.globalgenerickit.template.yoga.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class MyRecylerAdapter extends RecyclerView.Adapter<MyHolder> {

    /* renamed from: a */
    public ArrayList<SubCardData> f22305a = new ArrayList<>();

    /* renamed from: b */
    private String f22306b = "XpanelHorizontalRecyclerView";

    /* renamed from: c */
    private Context f22307c;

    /* renamed from: d */
    private StartSnapHelper f22308d;

    /* renamed from: e */
    private XPanelHorizontalRecyclerView f22309e;

    /* renamed from: f */
    private ArrayList<View> f22310f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EventListener f22311g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f22312h;

    public int getItemViewType(int i) {
        return i;
    }

    public MyRecylerAdapter(Context context, StartSnapHelper startSnapHelper, XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView) {
        this.f22307c = context;
        this.f22308d = startSnapHelper;
        this.f22309e = xPanelHorizontalRecyclerView;
    }

    /* renamed from: a */
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyHolder(this.f22310f.get(i), this.f22308d, this.f22309e);
    }

    /* renamed from: a */
    public void onBindViewHolder(MyHolder myHolder, int i) {
        myHolder.bind(i);
    }

    public int getItemCount() {
        return this.f22310f.size();
    }

    /* renamed from: a */
    public void mo66712a(View view) {
        this.f22310f.add(view);
        this.f22305a.add(new SubCardData("", this.f22310f.size() - 1, (String) view.getTag(R.id.cardId)));
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo66715a(String str) {
        Iterator<SubCardData> it = this.f22305a.iterator();
        while (it.hasNext()) {
            it.next().cardId = str;
        }
    }

    /* renamed from: a */
    public void mo66713a(EventListener eventListener) {
        this.f22311g = eventListener;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        /* access modifiers changed from: private */
        public int position = 1;

        public MyHolder(final View view, StartSnapHelper startSnapHelper, final XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView) {
            super(view);
            view.setOnClickListener(new View.OnClickListener(MyRecylerAdapter.this) {
                public void onClick(View view) {
                    String str;
                    AutoTrackHelper.trackViewOnClick(view);
                    try {
                        str = (String) view.getTag();
                    } catch (ClassCastException e) {
                        e.printStackTrace();
                        str = "";
                    }
                    int measuredWidth = xPanelHorizontalRecyclerView.getMeasuredWidth();
                    int left = view.getLeft();
                    int right = view.getRight();
                    if (left < measuredWidth && right > measuredWidth) {
                        if (MyRecylerAdapter.this.f22312h == 0 && xPanelHorizontalRecyclerView.getLayoutManager().getChildCount() > 0) {
                            int unused = MyRecylerAdapter.this.f22312h = xPanelHorizontalRecyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                        }
                        xPanelHorizontalRecyclerView.smoothScrollBy(MyRecylerAdapter.this.f22312h, 0);
                    } else if (left >= 0 || right >= measuredWidth || right <= 0) {
                        HashMap hashMap = new HashMap();
                        if (view.getTag(R.id.cardId) != null) {
                            hashMap.put("subcard_id", (String) view.getTag(R.id.cardId));
                        }
                        hashMap.put("scroolCard_position", MyHolder.this.position + "");
                        if (MyRecylerAdapter.this.f22311g != null) {
                            hashMap.put("url", str);
                            MyRecylerAdapter.this.f22311g.handleEvent("click", str, hashMap);
                            MyRecylerAdapter.this.f22311g.handleEvent("xpanel_subcard_ck", str, hashMap);
                            MyRecylerAdapter.this.f22311g.handleEvent("xpanel_card_ck", str, hashMap);
                        }
                    } else {
                        XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView = xPanelHorizontalRecyclerView;
                        xPanelHorizontalRecyclerView.smoothScrollBy(left - xPanelHorizontalRecyclerView.decorationPadding, 0);
                    }
                }
            });
        }

        public void bind(int i) {
            this.position = i + 1;
        }
    }
}
