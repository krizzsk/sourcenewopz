package com.didi.addressnew.framework.fragmentmarket.map.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.address.model.WayPoint;
import com.didi.addressnew.framework.fragmentmarket.map.presenter.SugMapWayPointPagePresenter;
import com.didi.addressnew.util.ViewFastDoubleClickInterceptor;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class SugWayPointEditView extends FrameLayout {

    /* renamed from: a */
    private Context f7190a;

    /* renamed from: b */
    private boolean f7191b;

    /* renamed from: c */
    private WayPoint f7192c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnActionListener f7193d;

    /* renamed from: e */
    private ImageView f7194e;

    /* renamed from: f */
    private View f7195f;

    /* renamed from: g */
    private TextView f7196g;

    /* renamed from: h */
    private ImageView f7197h;

    /* renamed from: i */
    private View f7198i;

    /* renamed from: j */
    private View f7199j;

    /* renamed from: k */
    private ImageView f7200k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SugMapWayPointPagePresenter f7201l;

    /* renamed from: m */
    private View f7202m;

    /* renamed from: n */
    private boolean f7203n = false;

    /* renamed from: o */
    private int f7204o = 1;

    /* renamed from: p */
    private int f7205p;

    public interface OnActionListener {
        void addToChangedWayPoints(WayPoint wayPoint);

        void onSelectAddress(WayPoint wayPoint, int i);
    }

    public SugWayPointEditView(Context context) {
        super(context);
        init(context);
    }

    public SugWayPointEditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SugWayPointEditView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public WayPoint getWayPoint() {
        return this.f7192c;
    }

    public void setPresenter(SugMapWayPointPagePresenter sugMapWayPointPagePresenter) {
        this.f7201l = sugMapWayPointPagePresenter;
    }

    public void init(Context context) {
        this.f7190a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.map_waypoint_edit_view_layout, this);
        this.f7199j = inflate;
        this.f7202m = inflate.findViewById(R.id.rlBgLayer);
        this.f7196g = (TextView) this.f7199j.findViewById(R.id.tvEditAddress);
        this.f7194e = (ImageView) this.f7199j.findViewById(R.id.imgWayPointAction);
        this.f7195f = this.f7199j.findViewById(R.id.wayPointActionContainer);
        this.f7197h = (ImageView) this.f7199j.findViewById(R.id.imgWayPointDrag);
        this.f7198i = this.f7199j.findViewById(R.id.wayPointDragContainer);
        this.f7200k = (ImageView) this.f7199j.findViewById(R.id.global_waypoint_point);
        this.f7196g.setText("");
    }

    public void setActionListener(OnActionListener onActionListener) {
        this.f7193d = onActionListener;
    }

    public void setDragTouchListener(View.OnTouchListener onTouchListener) {
        View view = this.f7198i;
        if (view != null && onTouchListener != null) {
            view.setOnTouchListener(onTouchListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m4360a(View view) {
        SugMapWayPointPagePresenter sugMapWayPointPagePresenter = this.f7201l;
        if (sugMapWayPointPagePresenter != null) {
            sugMapWayPointPagePresenter.deleteWayPoint(this.f7192c);
        }
    }

    /* renamed from: a */
    private void m4359a(int i, int i2, boolean z) {
        if (i == 1) {
            this.f7195f.setVisibility(4);
            this.f7198i.setVisibility(8);
            this.f7196g.setHint(R.string.GRider_Sug_2020_currentLoc);
            if (this.f7192c.isArrived() || !z || !this.f7192c.isEditable()) {
                this.f7200k.setImageResource(R.drawable.waypoint_icon_pick_up_dis);
            } else {
                this.f7200k.setImageResource(R.drawable.waypoint_icon_pickup);
            }
        } else if (i == 2) {
            this.f7194e.setImageResource(R.drawable.waypoint_action_icon_close_selector);
            int i3 = R.string.global_sug_input_stop_hint;
            if (i2 == 1) {
                i3 = R.string.GRider_Sug_2020_stop1;
            } else if (i2 == 2) {
                i3 = R.string.GRider_Sug_2020_stop2;
            }
            this.f7196g.setHint(i3);
            if (this.f7191b) {
                this.f7195f.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        SugWayPointEditView.this.m4360a(view);
                    }
                });
            } else {
                this.f7195f.setOnClickListener((View.OnClickListener) null);
            }
            if (this.f7192c.isArrived()) {
                this.f7200k.setImageResource(R.drawable.waypoint_icon_stop_dis);
                this.f7198i.setVisibility(8);
                this.f7195f.setVisibility(8);
            } else {
                this.f7200k.setImageResource(R.drawable.waypoint_icon_stop);
                this.f7198i.setVisibility(0);
                this.f7195f.setVisibility(0);
            }
        } else if (i == 3) {
            this.f7195f.setVisibility(0);
            this.f7194e.setImageResource(R.drawable.waypoint_action_icon_add_selector);
            this.f7195f.setContentDescription(getContext() == null ? "" : getContext().getString(R.string.GRider_0111_Add_Trip_KZdE));
            this.f7200k.setImageResource(R.drawable.waypoint_icon_point_destination);
            this.f7196g.setHint(R.string.GRider_Sug_2020_stopLast);
        }
        if (!this.f7192c.isEditable() || !z) {
            this.f7196g.setTextColor(getContext().getResources().getColor(R.color.waypoint_textview_disnabled_color));
        } else {
            this.f7196g.setTextColor(getContext().getResources().getColor(R.color.waypoint_textview_enabled_color));
        }
    }

    public void update(final WayPoint wayPoint, int i) {
        if (wayPoint != null) {
            this.f7192c = wayPoint;
            this.f7204o = i;
            this.f7196g.setVisibility(0);
            this.f7195f.setVisibility(0);
            this.f7191b = wayPoint.isEditable();
            m4359a(wayPoint.getWayPointType(), i, wayPoint.isUIEnable());
            Address address = wayPoint.getAddress();
            if (address == null) {
                this.f7196g.setText("");
            } else if (!TextUtils.isEmpty(address.getDisplayName())) {
                this.f7196g.setText(address.getDisplayName());
            } else if (!TextUtils.isEmpty(address.getName())) {
                this.f7196g.setText(address.getName());
            } else if (!TextUtils.isEmpty(address.getAddress())) {
                this.f7196g.setText(address.getAddress());
            } else {
                this.f7196g.setText("");
            }
            this.f7196g.setEnabled(this.f7191b);
            int wayPointType = wayPoint.getWayPointType();
            if (wayPointType == 2) {
                this.f7194e.setEnabled(this.f7191b);
                this.f7195f.setEnabled(this.f7191b);
                if (this.f7191b) {
                    this.f7198i.setVisibility(0);
                } else {
                    this.f7195f.setVisibility(4);
                    this.f7198i.setVisibility(4);
                }
            } else if (wayPointType == 3) {
                if (this.f7201l.hasEditableStopPoint()) {
                    this.f7198i.setVisibility(0);
                    if (this.f7201l.canAddStop()) {
                        this.f7194e.setImageResource(R.drawable.waypoint_action_icon_add_selector);
                    } else {
                        this.f7194e.setImageResource(R.drawable.waypoint_action_icon_close_selector);
                    }
                } else {
                    this.f7198i.setVisibility(4);
                    if (this.f7201l.canAddStop()) {
                        this.f7194e.setImageResource(R.drawable.waypoint_action_icon_add_selector);
                        this.f7195f.setVisibility(0);
                    } else {
                        this.f7195f.setVisibility(4);
                    }
                }
                this.f7195f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SugWayPointEditView.this.f7193d == null) {
                            return;
                        }
                        if (wayPoint.isCanAdd()) {
                            SugWayPointEditView.this.m4363a("addStop start...");
                            SugWayPointEditView.this.f7201l.createStop();
                            return;
                        }
                        SugWayPointEditView.this.m4363a("deleteWayPoint start...");
                        SugWayPointEditView.this.f7201l.deleteWayPoint(wayPoint);
                    }
                });
            }
            this.f7196g.setOnClickListener(new View.OnClickListener(wayPoint, i) {
                public final /* synthetic */ WayPoint f$1;
                public final /* synthetic */ int f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    SugWayPointEditView.this.m4361a(this.f$1, this.f$2, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m4361a(WayPoint wayPoint, int i, View view) {
        OnActionListener onActionListener;
        m4363a("addressText onclicklistener");
        if (!ViewFastDoubleClickInterceptor.isFastClick() && (onActionListener = this.f7193d) != null) {
            onActionListener.onSelectAddress(wayPoint, i);
        }
    }

    public void onStartDrag() {
        this.f7205p = this.f7195f.getVisibility();
        this.f7195f.setVisibility(4);
    }

    public void onEndDrag() {
        this.f7195f.setVisibility(this.f7205p);
        if (this.f7203n) {
            onSelfEndDrag();
        }
    }

    public void onSelfStartDrag() {
        this.f7203n = true;
    }

    public void onSelfEndDrag() {
        this.f7203n = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4363a(String str) {
        SystemUtils.log(4, "wayPointDebug", str, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.map.view.SugWayPointEditView", 300);
    }
}
