package com.didi.addressold.view;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.MotionEventCompat;
import androidx.customview.widget.ViewDragHelper;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;

public class CommonAddressItemView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public ViewGroup f7865a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f7866b;

    /* renamed from: c */
    private ImageView f7867c;

    /* renamed from: d */
    private ImageView f7868d;

    /* renamed from: e */
    private LinearLayout f7869e;

    /* renamed from: f */
    private TextView f7870f;

    /* renamed from: g */
    private TextView f7871g;

    /* renamed from: h */
    private TextView f7872h;

    /* renamed from: i */
    private ViewDragHelper f7873i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Point f7874j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Point f7875k;

    /* renamed from: l */
    private RpcCommonPoi f7876l;

    /* renamed from: m */
    private boolean f7877m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f7878n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public DragStateCallback f7879o;

    /* renamed from: p */
    private ViewDragHelper.Callback f7880p;

    public interface DragStateCallback {
        void onDragToExpand();
    }

    public CommonAddressItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CommonAddressItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7865a = null;
        this.f7866b = null;
        this.f7867c = null;
        this.f7868d = null;
        this.f7869e = null;
        this.f7870f = null;
        this.f7871g = null;
        this.f7872h = null;
        this.f7873i = null;
        this.f7874j = new Point();
        this.f7875k = new Point();
        this.f7876l = null;
        this.f7877m = false;
        this.f7878n = false;
        this.f7880p = new ViewDragHelper.Callback() {
            public boolean tryCaptureView(View view, int i) {
                return CommonAddressItemView.this.f7865a == view;
            }

            public void onViewDragStateChanged(int i) {
                if (i != 0) {
                    return;
                }
                if (CommonAddressItemView.this.f7865a.getLeft() == 0) {
                    boolean unused = CommonAddressItemView.this.f7878n = false;
                } else {
                    boolean unused2 = CommonAddressItemView.this.f7878n = true;
                }
            }

            public int clampViewPositionHorizontal(View view, int i, int i2) {
                if (view != CommonAddressItemView.this.f7865a) {
                    return 0;
                }
                if (CommonAddressItemView.this.f7866b.getWidth() + i < 0) {
                    return -CommonAddressItemView.this.f7866b.getWidth();
                }
                if (i > 0) {
                    return 0;
                }
                return i;
            }

            public void onViewReleased(View view, float f, float f2) {
                if (view != CommonAddressItemView.this.f7865a) {
                    return;
                }
                if (f > 0.0f) {
                    CommonAddressItemView.this.close();
                } else if (f < 0.0f) {
                    CommonAddressItemView.this.expand();
                    CommonAddressItemView.this.f7879o.onDragToExpand();
                } else if (CommonAddressItemView.this.f7865a.getLeft() <= (CommonAddressItemView.this.f7875k.x - CommonAddressItemView.this.f7874j.x) / 2) {
                    CommonAddressItemView.this.expand();
                    CommonAddressItemView.this.f7879o.onDragToExpand();
                } else {
                    CommonAddressItemView.this.close();
                }
            }

            public int getViewHorizontalDragRange(View view) {
                return CommonAddressItemView.this.f7866b.getWidth();
            }
        };
        LayoutInflater.from(getContext()).inflate(R.layout.old_poi_one_address_view_common_address_item, this);
        this.f7865a = (ViewGroup) findViewById(R.id.layout_item);
        this.f7867c = (ImageView) findViewById(R.id.image_delete);
        this.f7868d = (ImageView) findViewById(R.id.image_title);
        this.f7869e = (LinearLayout) findViewById(R.id.text_container);
        this.f7870f = (TextView) findViewById(R.id.text_title);
        this.f7871g = (TextView) findViewById(R.id.text_content);
        this.f7872h = (TextView) findViewById(R.id.text_not_set);
        this.f7866b = findViewById(R.id.button_delete);
        this.f7873i = ViewDragHelper.create(this, 1.0f, this.f7880p);
    }

    public void expand() {
        ViewDragHelper viewDragHelper = this.f7873i;
        if (viewDragHelper != null && this.f7877m) {
            viewDragHelper.smoothSlideViewTo(this.f7865a, this.f7875k.x, this.f7875k.y);
            invalidate();
        }
    }

    public void close() {
        ViewDragHelper viewDragHelper = this.f7873i;
        if (viewDragHelper != null) {
            viewDragHelper.smoothSlideViewTo(this.f7865a, this.f7874j.x, this.f7874j.y);
            invalidate();
        }
    }

    public void setDeleteState(boolean z) {
        if (z) {
            this.f7867c.setVisibility(0);
        } else {
            this.f7867c.setVisibility(8);
        }
    }

    public boolean getDeleteState() {
        return this.f7877m && this.f7867c.getVisibility() == 0;
    }

    public void setDragClickListener(View.OnClickListener onClickListener) {
        ViewGroup viewGroup = this.f7865a;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(onClickListener);
        }
    }

    public boolean isExpanded() {
        if (this.f7865a.getLeft() == 0) {
            return false;
        }
        return this.f7878n;
    }

    public void setDeleteClickListener(View.OnClickListener onClickListener) {
        View view = this.f7866b;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
        ImageView imageView = this.f7867c;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setExpandable(boolean z) {
        this.f7877m = z;
    }

    public void setCommonAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7876l = rpcCommonPoi;
        if (rpcCommonPoi == null) {
            return;
        }
        if (3 == rpcCommonPoi.type) {
            this.f7868d.setImageResource(R.drawable.poi_one_address_list_home);
            if (getContext().getString(R.string.global_sug_add_home).equals(this.f7876l.displayName)) {
                this.f7869e.setVisibility(8);
                this.f7872h.setVisibility(0);
                this.f7872h.setText(this.f7876l.displayName);
                return;
            }
            this.f7872h.setVisibility(8);
            this.f7869e.setVisibility(0);
            this.f7870f.setText(this.f7876l.name);
            this.f7871g.setText(this.f7876l.getAddress());
        } else if (4 == this.f7876l.type) {
            this.f7868d.setImageResource(R.drawable.poi_one_address_list_company);
            if (getContext().getString(R.string.global_sug_add_company).equals(this.f7876l.displayName)) {
                this.f7869e.setVisibility(8);
                this.f7872h.setVisibility(0);
                this.f7872h.setText(this.f7876l.displayName);
                return;
            }
            this.f7872h.setVisibility(8);
            this.f7869e.setVisibility(0);
            this.f7870f.setText(this.f7876l.name);
            this.f7871g.setText(this.f7876l.getAddress());
        } else if (5 == this.f7876l.type) {
            this.f7868d.setImageResource(R.drawable.poi_one_address_favorite);
            this.f7872h.setVisibility(8);
            this.f7869e.setVisibility(0);
            this.f7870f.setText(this.f7876l.aliasName);
            this.f7871g.setText(this.f7876l.address);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f7874j.x = this.f7865a.getLeft();
        this.f7874j.y = this.f7865a.getTop();
        this.f7875k.x = this.f7865a.getLeft() - this.f7866b.getWidth();
        this.f7875k.y = this.f7865a.getTop();
    }

    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.f7873i;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true) && this.f7877m) {
            invalidate();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f7877m || this.f7873i == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 3 && actionMasked != 1) {
            return this.f7873i.shouldInterceptTouchEvent(motionEvent);
        }
        this.f7873i.cancel();
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (!this.f7877m || (viewDragHelper = this.f7873i) == null) {
            return true;
        }
        viewDragHelper.processTouchEvent(motionEvent);
        return true;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.savedCommonAddress = this.f7876l;
        savedState.savedExpandable = this.f7877m ? 1 : 0;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            setCommonAddress(savedState.savedCommonAddress);
            setExpandable(savedState.savedExpandable != 0);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        RpcCommonPoi savedCommonAddress;
        int savedExpandable;

        SavedState(Parcelable parcelable) {
            super(parcelable);
            this.savedCommonAddress = null;
            this.savedExpandable = 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeSerializable(this.savedCommonAddress);
            parcel.writeInt(this.savedExpandable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.savedCommonAddress = null;
            this.savedExpandable = 0;
            this.savedCommonAddress = (RpcCommonPoi) parcel.readSerializable();
            this.savedExpandable = parcel.readInt();
        }
    }

    public void setDragStateCallback(DragStateCallback dragStateCallback) {
        this.f7879o = dragStateCallback;
    }
}
