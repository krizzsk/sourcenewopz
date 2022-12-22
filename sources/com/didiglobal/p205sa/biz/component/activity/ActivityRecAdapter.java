package com.didiglobal.p205sa.biz.component.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityProperty;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityViewType;
import com.didiglobal.p205sa.biz.component.activity.omega.ActivityOmegaTracker;
import com.didiglobal.p205sa.biz.component.activity.view.ActivityPanelItemContainer;
import com.didiglobal.p205sa.biz.component.activity.viewhold.ActivityEmptyVH;
import com.didiglobal.p205sa.biz.component.activity.viewhold.ActivityOngingEmptyVH;
import com.didiglobal.p205sa.biz.component.activity.viewhold.ActivityOngoingCardVH;
import com.didiglobal.p205sa.biz.component.activity.viewhold.ActivityOngoingMoreCardVH;
import com.didiglobal.p205sa.biz.component.activity.viewhold.ActivityOngoingTitleVH;
import com.didiglobal.p205sa.biz.component.activity.viewhold.ActivityRecentlyCardVH;
import com.didiglobal.p205sa.biz.component.activity.viewhold.ActivityRecentlyTitleVH;
import com.didiglobal.p205sa.biz.component.activity.viewhold.BaseRecVH;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didiglobal.sa.biz.component.activity.ActivityRecAdapter */
public class ActivityRecAdapter extends RecyclerView.Adapter<BaseRecVH> implements ActivityOngoingMoreCardVH.IViewMoreListener {

    /* renamed from: a */
    private final LayoutInflater f50728a;

    /* renamed from: b */
    private Context f50729b;

    /* renamed from: c */
    private List<ActivityProperty> f50730c = new ArrayList();

    /* renamed from: d */
    private int f50731d = -1;

    /* renamed from: e */
    private List<ActivityProperty> f50732e = new ArrayList();

    /* renamed from: f */
    private boolean f50733f = false;
    protected ArrayList<ItemView> footers = new ArrayList<>();
    protected ArrayList<ItemView> headers = new ArrayList<>();

    /* renamed from: com.didiglobal.sa.biz.component.activity.ActivityRecAdapter$ItemView */
    public interface ItemView {
        void onBindView(View view);

        View onCreateView(ViewGroup viewGroup);
    }

    public ActivityRecAdapter(Context context) {
        this.f50729b = context;
        this.f50728a = LayoutInflater.from(context);
    }

    public void addHeader(ItemView itemView) {
        if (itemView != null) {
            this.headers.add(itemView);
            notifyItemInserted(this.headers.size() - 1);
            return;
        }
        throw new NullPointerException("ItemView can't be null");
    }

    public void addFooter(ItemView itemView) {
        if (itemView != null) {
            this.footers.add(itemView);
            notifyItemInserted(((this.headers.size() + this.f50730c.size()) + this.footers.size()) - 1);
            return;
        }
        throw new NullPointerException("ItemView can't be null");
    }

    public void removeFooter(ItemView itemView) {
        int size = this.headers.size() + this.f50730c.size() + this.footers.indexOf(itemView);
        this.footers.remove(itemView);
        notifyItemRemoved(size);
    }

    public ArrayList<ItemView> getFooters() {
        return this.footers;
    }

    public void removeFooters() {
        int size = this.headers.size() + this.f50730c.size();
        int size2 = this.footers.size();
        this.footers.clear();
        notifyItemRangeRemoved(size, size2);
    }

    public BaseRecVH onCreateViewHolder(ViewGroup viewGroup, int i) {
        View a = m36431a(viewGroup, i);
        if (a != null) {
            return new ActivityEmptyVH(a);
        }
        if (i == ActivityViewType.ongoing_title.getViewType()) {
            return new ActivityOngoingTitleVH(this.f50728a.inflate(ActivityViewType.ongoing_title.getResId(), viewGroup, false));
        }
        if (i == ActivityViewType.ongoing_card.getViewType()) {
            View inflate = this.f50728a.inflate(ActivityViewType.ongoing_card.getResId(), (ViewGroup) null);
            ActivityPanelItemContainer activityPanelItemContainer = new ActivityPanelItemContainer("", i, this.f50729b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            if (inflate != null) {
                activityPanelItemContainer.addView(inflate, layoutParams);
            }
            return new ActivityOngoingCardVH(activityPanelItemContainer);
        } else if (i == ActivityViewType.recently_title.getViewType()) {
            return new ActivityRecentlyTitleVH(this.f50728a.inflate(ActivityViewType.recently_title.getResId(), viewGroup, false));
        } else {
            if (i == ActivityViewType.recently_card.getViewType()) {
                return new ActivityRecentlyCardVH(this.f50728a.inflate(ActivityViewType.recently_card.getResId(), viewGroup, false));
            }
            if (i == ActivityViewType.recently_card_last.getViewType()) {
                return new ActivityRecentlyCardVH(this.f50728a.inflate(ActivityViewType.recently_card_last.getResId(), viewGroup, false));
            }
            if (i == ActivityViewType.ongoing_more_card.getViewType()) {
                return new ActivityOngoingMoreCardVH(this.f50728a.inflate(ActivityViewType.ongoing_more_card.getResId(), viewGroup, false), this);
            }
            if (i == ActivityViewType.ongoing_empty_card.getViewType()) {
                return new ActivityOngingEmptyVH(this.f50728a.inflate(ActivityViewType.ongoing_empty_card.getResId(), viewGroup, false));
            }
            ActivityOmegaTracker.OmegaError(2);
            return new ActivityEmptyVH(new View(this.f50729b));
        }
    }

    public void onBindViewHolder(BaseRecVH baseRecVH, int i) {
        if (this.headers.size() == 0 || i >= this.headers.size()) {
            int size = (i - this.headers.size()) - this.f50730c.size();
            if (this.footers.size() == 0 || size < 0) {
                int size2 = i - this.headers.size();
                if (baseRecVH != null) {
                    baseRecVH.bindView(this.f50730c.get(size2).getModel());
                    ActivityOmegaTracker.omegaCardShow(this.f50730c.get(size2));
                    return;
                }
                return;
            }
            this.footers.get(size).onBindView(baseRecVH.itemView);
            return;
        }
        this.headers.get(i).onBindView(baseRecVH.itemView);
    }

    public int getItemCount() {
        return this.f50730c.size() + this.headers.size() + this.footers.size();
    }

    public int getItemViewType(int i) {
        int size;
        if (this.headers.size() != 0 && i < this.headers.size()) {
            return this.headers.get(i).hashCode();
        }
        if (this.footers.size() != 0 && (size = (i - this.headers.size()) - this.f50730c.size()) >= 0) {
            return this.footers.get(size).hashCode();
        }
        int size2 = i - this.headers.size();
        ActivityViewType[] values = ActivityViewType.values();
        int length = values.length;
        int i2 = 0;
        while (i2 < length) {
            ActivityViewType activityViewType = values[i2];
            if (!activityViewType.getTypeId().equals(this.f50730c.get(size2).getTypeId())) {
                i2++;
            } else if (size2 != this.f50730c.size() - 1 || !ActivityViewType.recently_card.getTypeId().equals(this.f50730c.get(size2).getTypeId())) {
                return activityViewType.getViewType();
            } else {
                return ActivityViewType.recently_card_last.getViewType();
            }
        }
        return -1;
    }

    public void addAll(List<ActivityProperty> list, int i) {
        if (list != null) {
            this.f50730c.clear();
            this.f50732e.clear();
            this.f50731d = i;
            this.f50730c.addAll(list);
            if (i > 0) {
                int i2 = 0;
                for (int i3 = 0; i3 < list.size(); i3++) {
                    ActivityProperty activityProperty = list.get(i3);
                    if (activityProperty.getTypeId().equals(ActivityViewType.ongoing_card.getTypeId()) && (i2 = i2 + 1) > i) {
                        this.f50732e.add(activityProperty);
                    }
                }
                if (!CollectionUtil.isEmpty((Collection<?>) this.f50732e) && !this.f50733f) {
                    this.f50730c.removeAll(this.f50732e);
                }
            }
            notifyDataSetChanged();
        }
    }

    public void onLoadMoreOrLess(boolean z) {
        this.f50733f = z;
        if (z) {
            this.f50730c.addAll(this.f50731d + 1, this.f50732e);
            notifyItemRangeInserted(this.headers.size() + this.f50731d + 1, this.f50732e.size());
            return;
        }
        this.f50730c.removeAll(this.f50732e);
        notifyItemRangeRemoved(this.headers.size() + this.f50731d + 1, this.f50732e.size());
    }

    /* renamed from: a */
    private View m36431a(ViewGroup viewGroup, int i) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        StaggeredGridLayoutManager.LayoutParams layoutParams2;
        Iterator<ItemView> it = this.headers.iterator();
        while (it.hasNext()) {
            ItemView next = it.next();
            if (next.hashCode() == i) {
                View onCreateView = next.onCreateView(viewGroup);
                if (onCreateView.getLayoutParams() != null) {
                    layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(onCreateView.getLayoutParams());
                } else {
                    layoutParams2 = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                }
                layoutParams2.setFullSpan(true);
                onCreateView.setLayoutParams(layoutParams2);
                return onCreateView;
            }
        }
        Iterator<ItemView> it2 = this.footers.iterator();
        while (it2.hasNext()) {
            ItemView next2 = it2.next();
            if (next2.hashCode() == i) {
                View onCreateView2 = next2.onCreateView(viewGroup);
                if (onCreateView2.getLayoutParams() != null) {
                    layoutParams = new StaggeredGridLayoutManager.LayoutParams(onCreateView2.getLayoutParams());
                } else {
                    layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
                }
                layoutParams.setFullSpan(true);
                onCreateView2.setLayoutParams(layoutParams);
                return onCreateView2;
            }
        }
        return null;
    }
}
