package com.didi.beatles.p099im.views.feed;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMRTLUtils;
import com.didi.beatles.p099im.views.IMTipsToast;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.feed.IMListTopVHolder */
public class IMListTopVHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private TextView f10281a = ((TextView) this.itemView.findViewById(R.id.change_txt));

    /* renamed from: b */
    private TextView f10282b = ((TextView) this.itemView.findViewById(R.id.clear_txt));

    /* renamed from: c */
    private View f10283c = this.itemView.findViewById(R.id.mid_line);
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ClearListener f10284d;

    /* renamed from: com.didi.beatles.im.views.feed.IMListTopVHolder$ClearListener */
    public interface ClearListener {
        void changeFeed(boolean z);

        void clearMsg(View view);
    }

    public IMListTopVHolder(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.im_list_item_top, viewGroup, false));
    }

    public void bindData(boolean z, boolean z2, boolean z3, int i, ClearListener clearListener) {
        this.f10284d = clearListener;
        if (z) {
            m7017a(z2);
            this.f10281a.setVisibility(0);
        } else {
            this.f10281a.setVisibility(8);
        }
        if (z3) {
            m7014a(i);
            this.f10282b.setVisibility(0);
        } else {
            this.f10282b.setVisibility(8);
        }
        if (!z || !z3) {
            this.f10283c.setVisibility(8);
        } else {
            this.f10283c.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m7017a(final boolean z) {
        if (z) {
            this.f10281a.setText(this.itemView.getResources().getString(R.string.im_change_list));
            IMRTLUtils.setCompoundDrawablesWithIntrinsicBoundsRTL(this.f10281a, this.itemView.getResources().getDrawable(R.drawable.im_icon_switch_list), (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            this.f10281a.setText(this.itemView.getResources().getString(R.string.im_change_feed));
            IMRTLUtils.setCompoundDrawablesWithIntrinsicBoundsRTL(this.f10281a, this.itemView.getResources().getDrawable(R.drawable.im_icon_switch_card), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.f10281a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (IMListTopVHolder.this.f10284d != null) {
                    IMListTopVHolder.this.f10284d.changeFeed(!z);
                }
            }
        });
    }

    /* renamed from: a */
    private void m7014a(final int i) {
        this.f10282b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                IMTraceUtil.addBusinessEvent("ddim_service_list_notice_clean_ck").report();
                if (i <= 0) {
                    IMListTopVHolder iMListTopVHolder = IMListTopVHolder.this;
                    iMListTopVHolder.m7016a(iMListTopVHolder.itemView.getResources().getString(R.string.im_list_clear_empty));
                }
                if (IMListTopVHolder.this.f10284d != null) {
                    IMListTopVHolder.this.f10284d.clearMsg(IMListTopVHolder.this.itemView);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7016a(String str) {
        Toast makeText = IMTipsToast.makeText(IMContextInfoHelper.getContext(), (CharSequence) "", 0);
        if (Build.VERSION.SDK_INT < 14) {
            makeText.cancel();
        }
        SystemUtils.showToast(makeText);
        IMTipsToast.setIcon(makeText, IMResource.getDrawableID(R.drawable.im_toast_warm));
        IMTipsToast.setText(makeText, str);
    }
}
