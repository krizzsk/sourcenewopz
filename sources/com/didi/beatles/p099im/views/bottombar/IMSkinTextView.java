package com.didi.beatles.p099im.views.bottombar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.resource.IMResource;
import java.util.Map;

/* renamed from: com.didi.beatles.im.views.bottombar.IMSkinTextView */
public class IMSkinTextView extends AppCompatTextView implements IIMSkin {
    public static final String IM_SKIN_CANCEL = "cancel";
    public static final String IM_SKIN_COMMON = "common";
    public static final String IM_SKIN_DISABLE = "disable";

    /* renamed from: a */
    private Map<String, IMSkinElement> f10010a;

    /* renamed from: b */
    private View f10011b;

    /* renamed from: c */
    private int f10012c;

    /* renamed from: d */
    private int f10013d;

    /* renamed from: e */
    private int f10014e;

    /* renamed from: f */
    private int f10015f;

    /* renamed from: g */
    private int f10016g;

    /* renamed from: h */
    private String f10017h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f10018i;

    public IMSkinTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMSkinTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public IMSkinTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10017h = IM_SKIN_COMMON;
        this.f10018i = 0;
        this.f10011b = this;
    }

    public void showDisableSkin() {
        m6794a("disable");
    }

    public void showCommonSkin() {
        m6794a(IM_SKIN_COMMON);
    }

    public void showCancelSkin() {
        m6794a("cancel");
    }

    public void showCustomSkin(String str) {
        m6794a(str);
    }

    public void setSkinMap(Map<String, IMSkinElement> map) {
        this.f10010a = map;
    }

    public void setShowImage(boolean z) {
        if (z) {
            m6792a();
        }
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        this.f10013d = i;
        this.f10014e = i2;
        this.f10015f = i3;
        this.f10016g = i4;
        View view = this.f10011b;
        if (view instanceof ImageView) {
            view.setPadding(i, i2, i3, i4);
        }
    }

    public void setVisibility(int i) {
        View view = this.f10011b;
        if (view instanceof ImageView) {
            view.setVisibility(i);
        } else {
            super.setVisibility(i);
        }
    }

    public void setClickable(boolean z) {
        View view = this.f10011b;
        if (view instanceof ImageView) {
            view.setClickable(z);
        } else {
            super.setClickable(z);
        }
    }

    /* renamed from: a */
    private void m6794a(String str) {
        Map<String, IMSkinElement> map = this.f10010a;
        if (map != null) {
            this.f10017h = str;
            IMSkinElement iMSkinElement = map.get(str);
            if (iMSkinElement != null) {
                m6793a(iMSkinElement);
            }
        }
    }

    public boolean post(Runnable runnable) {
        View view = this.f10011b;
        if (view instanceof ImageView) {
            return view.post(runnable);
        }
        return super.post(runnable);
    }

    public boolean postDelayed(Runnable runnable, long j) {
        View view = this.f10011b;
        if (view instanceof ImageView) {
            return view.postDelayed(runnable, j);
        }
        return super.postDelayed(runnable, j);
    }

    public void setImageSrcId(int i) {
        if (i != 0) {
            View view = this.f10011b;
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(IMResource.getDrawableID(i));
            }
        }
    }

    /* renamed from: a */
    private void m6793a(IMSkinElement iMSkinElement) {
        if (iMSkinElement.getSrcDrawable() != 0) {
            setImageSrcId(iMSkinElement.getSrcDrawable());
            return;
        }
        if (iMSkinElement.getBgDrawable() != 0) {
            setBackgroundResource(iMSkinElement.getBgDrawable());
        } else if (iMSkinElement.getBgColor() != 0) {
            setBackgroundColor(iMSkinElement.getBgColor());
        }
        if (!TextUtils.isEmpty(iMSkinElement.getText())) {
            setText(iMSkinElement.getText());
            if (iMSkinElement.getTextColor() != 0) {
                setTextColor(iMSkinElement.getTextColor());
            }
        }
    }

    public void setViewClickListener(final View.OnClickListener onClickListener) {
        this.f10011b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                View.OnClickListener onClickListener;
                AutoTrackHelper.trackViewOnClick(view);
                if (System.currentTimeMillis() - IMSkinTextView.this.f10018i > 400 && (onClickListener = onClickListener) != null) {
                    onClickListener.onClick(IMSkinTextView.this);
                }
                long unused = IMSkinTextView.this.f10018i = System.currentTimeMillis();
            }
        });
    }

    /* renamed from: a */
    private void m6792a() {
        if (!(this.f10011b instanceof ImageView)) {
            ViewGroup viewGroup = (ViewGroup) getParent();
            int indexOfChild = viewGroup.indexOfChild(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(this.f10012c);
            imageView.setPadding(this.f10013d, this.f10014e, this.f10015f, this.f10016g);
            imageView.setLayoutParams(layoutParams);
            viewGroup.removeViewAt(indexOfChild);
            imageView.setId(getId());
            viewGroup.addView(imageView, indexOfChild);
            this.f10011b = imageView;
        }
    }

    public View getRealView() {
        return this.f10011b;
    }

    public void resetViewSkin() {
        m6794a(this.f10017h);
    }

    public void setImageContentDescription(String str) {
        if (this.f10011b != null && !TextUtils.isEmpty(str)) {
            this.f10011b.setContentDescription(str);
        }
    }
}
