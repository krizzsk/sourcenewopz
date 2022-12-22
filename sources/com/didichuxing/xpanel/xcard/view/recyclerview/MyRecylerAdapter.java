package com.didichuxing.xpanel.xcard.view.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.xpanel.xcard.ICardListener;
import com.didichuxing.xpanel.xcard.XPanelCardDataHelper;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

class MyRecylerAdapter extends RecyclerView.Adapter<MyHolder> {

    /* renamed from: a */
    public ArrayList<SubCardData> f49701a = new ArrayList<>();

    /* renamed from: b */
    private String f49702b = "XpanelHorizontalRecyclerView";

    /* renamed from: c */
    private Context f49703c;

    /* renamed from: d */
    private StartSnapHelper f49704d;

    /* renamed from: e */
    private XPanelHorizontalRecyclerView f49705e;

    /* renamed from: f */
    private ArrayList<View> f49706f = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public XPanelCardDataHelper f49707g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ICardListener f49708h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f49709i;

    public int getItemViewType(int i) {
        return i;
    }

    public MyRecylerAdapter(Context context, StartSnapHelper startSnapHelper, XPanelHorizontalRecyclerView xPanelHorizontalRecyclerView) {
        this.f49703c = context;
        this.f49704d = startSnapHelper;
        this.f49705e = xPanelHorizontalRecyclerView;
    }

    /* renamed from: a */
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyHolder(this.f49706f.get(i), this.f49704d, this.f49705e);
    }

    /* renamed from: a */
    public void onBindViewHolder(MyHolder myHolder, int i) {
        myHolder.bind(i);
    }

    public int getItemCount() {
        return this.f49706f.size();
    }

    /* renamed from: a */
    public void mo121808a(View view) {
        this.f49706f.add(view);
        this.f49701a.add(new SubCardData("", this.f49706f.size() - 1, (String) view.getTag(R.id.cardId)));
        notifyDataSetChanged();
    }

    /* renamed from: a */
    public void mo121812a(String str) {
        Iterator<SubCardData> it = this.f49701a.iterator();
        while (it.hasNext()) {
            it.next().cardId = str;
        }
    }

    /* renamed from: a */
    public void mo121810a(XPanelCardDataHelper xPanelCardDataHelper) {
        this.f49707g = xPanelCardDataHelper;
    }

    /* renamed from: a */
    public void mo121809a(ICardListener iCardListener) {
        this.f49708h = iCardListener;
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
                        if (MyRecylerAdapter.this.f49709i == 0 && xPanelHorizontalRecyclerView.getLayoutManager().getChildCount() > 0) {
                            int unused = MyRecylerAdapter.this.f49709i = xPanelHorizontalRecyclerView.getLayoutManager().getChildAt(0).getMeasuredWidth();
                        }
                        xPanelHorizontalRecyclerView.smoothScrollBy(MyRecylerAdapter.this.f49709i, 0);
                    } else if (left >= 0 || right >= measuredWidth || right <= 0) {
                        HashMap hashMap = new HashMap();
                        if (view.getTag(R.id.cardId) != null) {
                            hashMap.put("subcard_id", (String) view.getTag(R.id.cardId));
                        }
                        hashMap.put("scroolCard_position", MyHolder.this.position + "");
                        if (MyRecylerAdapter.this.f49707g != null) {
                            MyRecylerAdapter.this.f49707g.onClick(str);
                            MyRecylerAdapter.this.f49707g.clickSubCardOmega(hashMap);
                            MyRecylerAdapter.this.f49707g.clickOmega("card", hashMap);
                        } else if (MyRecylerAdapter.this.f49708h != null) {
                            hashMap.put("url", str);
                            MyRecylerAdapter.this.f49708h.handleEvent("click", hashMap);
                            MyRecylerAdapter.this.f49708h.handleEvent("xpanel_subcard_ck", hashMap);
                            MyRecylerAdapter.this.f49708h.handleEvent("xpanel_card_ck", hashMap);
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
