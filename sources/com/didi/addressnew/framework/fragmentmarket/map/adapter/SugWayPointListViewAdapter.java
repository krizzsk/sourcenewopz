package com.didi.addressnew.framework.fragmentmarket.map.adapter;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.address.model.WayPoint;
import com.didi.addressnew.framework.animator.EaseCubicInterpolator;
import com.didi.addressnew.framework.fragmentmarket.map.adapter.SugWayPointListViewAdapter;
import com.didi.addressnew.framework.fragmentmarket.map.presenter.SugMapWayPointPagePresenter;
import com.didi.addressnew.framework.fragmentmarket.map.view.SugWayPointEditView;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SugWayPointListViewAdapter extends RecyclerView.Adapter<WayPointViewHolder> {

    /* renamed from: a */
    List<WayPoint> f7085a = new ArrayList();

    /* renamed from: b */
    private List<WeakReference<WayPointViewHolder>> f7086b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SugWayPointEditView.OnActionListener f7087c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public WayPointRecyclerAdapterCallback f7088d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugMapWayPointPagePresenter f7089e;

    /* renamed from: f */
    private Context f7090f;

    /* renamed from: g */
    private boolean f7091g;

    public interface WayPointRecyclerAdapterCallback {
        boolean addStopAble();

        void addToStopPoints(WayPoint wayPoint);

        void clearStopPoints();

        void onDradEnd();

        void onDragStart(RecyclerView.ViewHolder viewHolder);
    }

    public void clearGuideView() {
    }

    public SugWayPointListViewAdapter(Context context) {
        this.f7090f = context;
    }

    public void setWayPointRecyclerAdapterCallback(WayPointRecyclerAdapterCallback wayPointRecyclerAdapterCallback) {
        this.f7088d = wayPointRecyclerAdapterCallback;
    }

    public void setOnActionListener(SugWayPointEditView.OnActionListener onActionListener) {
        this.f7087c = onActionListener;
    }

    public void setWayPointEditPagePresenter(SugMapWayPointPagePresenter sugMapWayPointPagePresenter) {
        this.f7089e = sugMapWayPointPagePresenter;
    }

    public void setDataList(List<WayPoint> list) {
        this.f7085a = list;
    }

    public void onItemMove(int i, int i2) {
        m4240a("onItemMove: fromPosition: " + i + ", toPosition: " + i2);
        List<WayPoint> list = this.f7085a;
        if (list != null && i >= 0 && i2 >= 0 && list.size() > i2 && this.f7085a.get(i2).isEditable()) {
            Collections.swap(this.f7085a, i, i2);
            notifyItemMoved(i, i2);
        }
    }

    public void updateDataType() {
        this.f7088d.clearStopPoints();
        if (this.f7085a != null) {
            WayPoint wayPoint = null;
            for (int i = 0; i < this.f7085a.size(); i++) {
                WayPoint wayPoint2 = this.f7085a.get(i);
                if (i == 0) {
                    if (wayPoint2.getWayPointType() != 1) {
                        wayPoint2.setWayPointType(1);
                        SugWayPointEditView.OnActionListener onActionListener = this.f7087c;
                        if (onActionListener != null) {
                            onActionListener.addToChangedWayPoints(wayPoint2);
                        }
                    }
                } else if (i != this.f7085a.size() - 1) {
                    wayPoint2.setWayPointType(2);
                    SugWayPointEditView.OnActionListener onActionListener2 = this.f7087c;
                    if (onActionListener2 != null) {
                        onActionListener2.addToChangedWayPoints(wayPoint2);
                    }
                    this.f7088d.addToStopPoints(wayPoint2);
                } else if (wayPoint2.getWayPointType() != 3) {
                    wayPoint2.setWayPointType(3);
                    SugWayPointEditView.OnActionListener onActionListener3 = this.f7087c;
                    if (onActionListener3 != null) {
                        onActionListener3.addToChangedWayPoints(wayPoint2);
                    }
                    wayPoint = wayPoint2;
                }
            }
            if (wayPoint != null) {
                wayPoint.setCanAdd(this.f7088d.addStopAble());
            }
            new Handler().post(new Runnable() {
                public final void run() {
                    SugWayPointListViewAdapter.this.m4244c();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m4244c() {
        notifyDataSetChanged();
    }

    public void dragEnd() {
        m4240a("dragEnd ...");
        m4242b();
        updateDataType();
        WayPointRecyclerAdapterCallback wayPointRecyclerAdapterCallback = this.f7088d;
        if (wayPointRecyclerAdapterCallback != null) {
            wayPointRecyclerAdapterCallback.onDradEnd();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4237a() {
        setItemAnimFlag(false);
        m4240a("onDragStart mViewHolderCacheList.size()=" + this.f7086b.size());
        if (this.f7086b.size() != 0) {
            for (WeakReference next : this.f7086b) {
                if (!(next == null || next.get() == null)) {
                    ((WayPointViewHolder) next.get()).wayPointEditView.onStartDrag();
                }
            }
        }
    }

    public void setItemAnimFlag(boolean z) {
        this.f7091g = z;
    }

    /* renamed from: b */
    private void m4242b() {
        if (this.f7086b.size() != 0) {
            for (WeakReference next : this.f7086b) {
                if (!(next == null || next.get() == null)) {
                    ((WayPointViewHolder) next.get()).wayPointEditView.onEndDrag();
                }
            }
        }
    }

    public WayPointViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        m4240a("onCreateViewHolder i=" + i);
        return new WayPointViewHolder(new SugWayPointEditView(viewGroup.getContext()));
    }

    public void onBindViewHolder(WayPointViewHolder wayPointViewHolder, int i) {
        if (wayPointViewHolder != null) {
            m4238a(wayPointViewHolder.itemView, i);
            wayPointViewHolder.onBindData(this.f7085a.get(i), i);
            this.f7086b.add(new WeakReference(wayPointViewHolder));
        }
    }

    public int getItemCount() {
        m4240a("getItemCount mWayPoints=" + this.f7085a.size());
        return this.f7085a.size();
    }

    /* renamed from: a */
    private void m4238a(View view, int i) {
        if (this.f7085a.size() > 2 && this.f7091g) {
            AnimationSet animationSet = new AnimationSet(true);
            if (i == this.f7085a.size() - 2) {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                animationSet.addAnimation(alphaAnimation);
                alphaAnimation.setDuration((long) 600);
            }
            if (i == this.f7085a.size() - 1) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f7090f, R.anim.input_view_item_anim);
                long j = (long) 500;
                loadAnimation.setDuration(j);
                animationSet.addAnimation(loadAnimation);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setDuration(j);
                animationSet.addAnimation(alphaAnimation2);
            }
            animationSet.setInterpolator(new EaseCubicInterpolator(0.3f, 0.2f, 0.1f, 1.0f));
            animationSet.setFillAfter(true);
            view.startAnimation(animationSet);
        }
    }

    public class WayPointViewHolder extends RecyclerView.ViewHolder {
        public SugWayPointEditView wayPointEditView;

        public WayPointViewHolder(SugWayPointEditView sugWayPointEditView) {
            super(sugWayPointEditView);
            this.wayPointEditView = sugWayPointEditView;
            sugWayPointEditView.setPresenter(SugWayPointListViewAdapter.this.f7089e);
        }

        public void onBindData(WayPoint wayPoint, int i) {
            if (wayPoint != null) {
                this.wayPointEditView.update(wayPoint, i);
                this.wayPointEditView.setActionListener(SugWayPointListViewAdapter.this.f7087c);
                if (wayPoint.getWayPointType() != 1) {
                    this.wayPointEditView.setDragTouchListener(new View.OnTouchListener() {
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return SugWayPointListViewAdapter.WayPointViewHolder.this.mo38817xbd2bf2fb(view, motionEvent);
                        }
                    });
                }
            }
        }

        /* renamed from: lambda$onBindData$0$SugWayPointListViewAdapter$WayPointViewHolder */
        public /* synthetic */ boolean mo38817xbd2bf2fb(View view, MotionEvent motionEvent) {
            SugWayPointListViewAdapter sugWayPointListViewAdapter = SugWayPointListViewAdapter.this;
            sugWayPointListViewAdapter.m4240a("onTouch action=" + motionEvent.getAction());
            if (motionEvent.getAction() != 0 || SugWayPointListViewAdapter.this.f7088d == null) {
                return false;
            }
            SugWayPointListViewAdapter.this.m4237a();
            this.wayPointEditView.onSelfStartDrag();
            SugWayPointListViewAdapter.this.f7088d.onDragStart(this);
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4240a(String str) {
        SystemUtils.log(4, "wayPointDebug", str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.adapter.SugWayPointListViewAdapter", 253);
    }
}
