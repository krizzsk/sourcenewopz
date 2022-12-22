package com.didi.app.nova.support.view.recyclerview.view.helper;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;

public class NovaItemTouchHelper extends C3793a implements RecyclerView.OnChildAttachStateChangeListener {

    /* renamed from: a */
    private static final int f8628a = 0;

    /* renamed from: b */
    private static final int f8629b = 1;

    /* renamed from: c */
    private int f8630c = 0;

    /* renamed from: d */
    private int f8631d = -1;

    /* renamed from: e */
    private int f8632e;

    /* renamed from: f */
    private float f8633f;

    /* renamed from: g */
    private float f8634g;
    public ItemViewHolder mSelected;

    public void onChildViewAttachedToWindow(View view) {
    }

    public /* bridge */ /* synthetic */ void attachToRecyclerView(NovaRecyclerView novaRecyclerView) {
        super.attachToRecyclerView(novaRecyclerView);
    }

    public /* bridge */ /* synthetic */ void detachToRecyclerView() {
        super.detachToRecyclerView();
    }

    /* access modifiers changed from: protected */
    public void onAttachToRecyclerView(NovaRecyclerView novaRecyclerView) {
        novaRecyclerView.addOnChildAttachStateChangeListener(this);
    }

    public void onDetachToRecyclerView(NovaRecyclerView novaRecyclerView) {
        novaRecyclerView.removeOnChildAttachStateChangeListener(this);
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked == 0) {
            this.f8631d = motionEvent.getPointerId(0);
            this.mInitialTouchX = motionEvent.getX();
            this.mInitialTouchY = motionEvent.getY();
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f8631d = -1;
            m5749a((RecyclerView.ViewHolder) null, 0);
        } else {
            int i = this.f8631d;
            if (i != -1) {
                m5751a(actionMasked, motionEvent, motionEvent.findPointerIndex(i));
            }
        }
        if (this.mSelected != null) {
            return true;
        }
        return false;
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f8631d != -1) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int findPointerIndex = motionEvent.findPointerIndex(this.f8631d);
            m5751a(actionMasked, motionEvent, findPointerIndex);
            if (this.mSelected != null) {
                int i = 0;
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        if (actionMasked != 3) {
                            if (actionMasked == 6) {
                                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                                if (motionEvent.getPointerId(actionIndex) == this.f8631d) {
                                    if (actionIndex == 0) {
                                        i = 1;
                                    }
                                    this.f8631d = motionEvent.getPointerId(i);
                                    m5748a(motionEvent, this.f8632e, actionIndex);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else if (findPointerIndex >= 0) {
                        m5748a(motionEvent, this.f8632e, findPointerIndex);
                        m5747a();
                        return;
                    } else {
                        return;
                    }
                }
                m5749a((RecyclerView.ViewHolder) null, 0);
                this.f8631d = -1;
            }
        }
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m5749a((RecyclerView.ViewHolder) null, 0);
        }
    }

    /* renamed from: a */
    private void m5749a(RecyclerView.ViewHolder viewHolder, int i) {
        if (this.mSelected != viewHolder || this.f8630c != i) {
            ItemViewHolder itemViewHolder = this.mSelected;
            if (itemViewHolder != null) {
                itemViewHolder.onMoveFinished();
                this.mSelected = null;
            }
            this.f8630c = i;
            if (viewHolder != null) {
                this.f8633f = (float) viewHolder.itemView.getLeft();
                this.f8634g = (float) viewHolder.itemView.getTop();
                ItemViewHolder itemViewHolder2 = (ItemViewHolder) viewHolder;
                this.mSelected = itemViewHolder2;
                this.f8632e = itemViewHolder2.getMoveDirections();
            }
            ViewParent parent = this.mRecyclerView.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(this.mSelected != null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        if (r3 <= r0) goto L_0x0034;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5747a() {
        /*
            r9 = this;
            float[] r0 = r9.mTmpPosition
            r9.m5750a((float[]) r0)
            float[] r0 = r9.mTmpPosition
            r1 = 0
            r0 = r0[r1]
            float[] r1 = r9.mTmpPosition
            r2 = 1
            r1 = r1[r2]
            float r3 = java.lang.Math.abs(r0)
            float r4 = java.lang.Math.abs(r1)
            r5 = -1
            r6 = 4
            r7 = 0
            int r8 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x0036
            int r0 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0023
            goto L_0x0027
        L_0x0023:
            r0 = 8
            r6 = 8
        L_0x0027:
            com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder r0 = r9.mSelected
            int r0 = r0.getMaxMoveX()
            if (r0 == r5) goto L_0x0034
            float r0 = (float) r0
            int r8 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r8 > 0) goto L_0x0037
        L_0x0034:
            r0 = r3
            goto L_0x0037
        L_0x0036:
            r0 = 0
        L_0x0037:
            int r8 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x0052
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 >= 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r1 = 2
            r2 = 2
        L_0x0042:
            com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder r1 = r9.mSelected
            int r1 = r1.getMaxMoveY()
            if (r1 == r5) goto L_0x0053
            float r1 = (float) r1
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x0050
            goto L_0x0053
        L_0x0050:
            r4 = r1
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder r1 = r9.mSelected
            r1.onMove(r6, r0, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.app.nova.support.view.recyclerview.view.helper.NovaItemTouchHelper.m5747a():void");
    }

    /* renamed from: a */
    private boolean m5751a(int i, MotionEvent motionEvent, int i2) {
        RecyclerView.ViewHolder a;
        if (i2 < 0 || this.mSelected != null || i != 2 || this.mRecyclerView.getScrollState() == 1 || (a = m5746a(motionEvent)) == null || !(a instanceof ItemViewHolder)) {
            return false;
        }
        ItemViewHolder itemViewHolder = (ItemViewHolder) a;
        if (!itemViewHolder.isMovable()) {
            return false;
        }
        int moveDirections = itemViewHolder.getMoveDirections();
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        float f = x - this.mInitialTouchX;
        float f2 = y - this.mInitialTouchY;
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (abs < ((float) this.mSlop) && abs2 < ((float) this.mSlop)) {
            return false;
        }
        if (abs > abs2) {
            if (f < 0.0f && (moveDirections & 4) == 0) {
                return false;
            }
            if (f > 0.0f && (moveDirections & 8) == 0) {
                return false;
            }
        } else if (f2 < 0.0f && (moveDirections & 1) == 0) {
            return false;
        } else {
            if (f2 > 0.0f && (moveDirections & 2) == 0) {
                return false;
            }
        }
        this.mDy = 0.0f;
        this.mDx = 0.0f;
        this.f8631d = motionEvent.getPointerId(0);
        m5749a(a, 1);
        return true;
    }

    /* renamed from: a */
    private RecyclerView.ViewHolder m5746a(MotionEvent motionEvent) {
        View b;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        int i = this.f8631d;
        if (i == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.mInitialTouchX);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.mInitialTouchY);
        if (abs < ((float) this.mSlop) && abs2 < ((float) this.mSlop)) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (b = m5753b(motionEvent)) != null) {
            return this.mRecyclerView.getChildViewHolder(b);
        }
        return null;
    }

    /* renamed from: b */
    private View m5753b(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        ItemViewHolder itemViewHolder = this.mSelected;
        if (itemViewHolder != null) {
            View view = itemViewHolder.itemView;
            if (m5752a(view, x, y, this.f8633f + this.mDx, this.f8634g + this.mDy)) {
                return view;
            }
        }
        return this.mRecyclerView.findChildViewUnder(x, y);
    }

    /* renamed from: a */
    private static boolean m5752a(View view, float f, float f2, float f3, float f4) {
        return f >= f3 && f <= f3 + ((float) view.getWidth()) && f2 >= f4 && f2 <= f4 + ((float) view.getHeight());
    }

    /* renamed from: a */
    private void m5748a(MotionEvent motionEvent, int i, int i2) {
        float x = motionEvent.getX(i2);
        float y = motionEvent.getY(i2);
        this.mDx = x - this.mInitialTouchX;
        this.mDy = y - this.mInitialTouchY;
        if ((i & 4) == 0) {
            this.mDx = Math.max(0.0f, this.mDx);
        }
        if ((i & 8) == 0) {
            this.mDx = Math.min(0.0f, this.mDx);
        }
        if ((i & 1) == 0) {
            this.mDy = Math.max(0.0f, this.mDy);
        }
        if ((i & 2) == 0) {
            this.mDy = Math.min(0.0f, this.mDy);
        }
    }

    /* renamed from: a */
    private void m5750a(float[] fArr) {
        if ((this.f8632e & 12) != 0) {
            fArr[0] = (this.f8633f + this.mDx) - ((float) this.mSelected.itemView.getLeft());
        } else {
            fArr[0] = ViewCompat.getTranslationX(this.mSelected.itemView);
        }
        if ((this.f8632e & 3) != 0) {
            fArr[1] = (this.f8634g + this.mDy) - ((float) this.mSelected.itemView.getTop());
        } else {
            fArr[1] = ViewCompat.getTranslationY(this.mSelected.itemView);
        }
    }

    public void onChildViewDetachedFromWindow(View view) {
        ItemViewHolder itemViewHolder;
        RecyclerView.ViewHolder childViewHolder = this.mRecyclerView.getChildViewHolder(view);
        if (childViewHolder != null && (itemViewHolder = this.mSelected) != null && childViewHolder == itemViewHolder) {
            m5749a((RecyclerView.ViewHolder) null, 0);
        }
    }
}
