package com.didi.beatles.p099im.views.popup;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.module.IMExtendBtnModule;
import com.didi.beatles.p099im.omega.IMMsgOmega;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.views.widget.IMDividerDecoration;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.views.popup.IMExtendBtnPopup */
public class IMExtendBtnPopup {

    /* renamed from: a */
    private static final String f10409a = "IMExtendBtnPopup";

    /* renamed from: f */
    private static final int f10410f = 45;

    /* renamed from: g */
    private static final int f10411g = 106;

    /* renamed from: h */
    private static final int f10412h = 30;

    /* renamed from: i */
    private static final int f10413i = 130;

    /* renamed from: b */
    private PopupWindow f10414b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Context f10415c;

    /* renamed from: d */
    private RecyclerView f10416d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<IMExtendBtnModule> f10417e;

    public IMExtendBtnPopup(Context context, List<IMExtendBtnModule> list) {
        if (list == null || list.size() == 0) {
            IMLog.m6631d(f10409a, "the button list is null !");
            return;
        }
        this.f10415c = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.im_extend_btns_popup, (ViewGroup) null);
        this.f10414b = new PopupWindow(inflate, IMViewUtil.dp2px(context, 106.0f), IMViewUtil.dp2px(context, 45.0f));
        this.f10416d = (RecyclerView) inflate.findViewById(R.id.extend_popup_rview);
        this.f10417e = list;
        this.f10414b.setOutsideTouchable(true);
        this.f10414b.setBackgroundDrawable(new BitmapDrawable());
    }

    public void dismiss() {
        this.f10414b.dismiss();
    }

    public boolean isShowing() {
        return this.f10414b.isShowing();
    }

    public void show(View view) {
        List<IMExtendBtnModule> list;
        if (view != null && (list = this.f10417e) != null && list.size() != 0) {
            this.f10414b.setHeight(IMViewUtil.dp2px(this.f10415c, (float) ((this.f10417e.size() * 50) + 10 + 11)));
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            this.f10414b.showAtLocation(view, 48, IMViewUtil.dp2px(this.f10415c, 130.0f), iArr[1] + IMViewUtil.dp2px(this.f10415c, 30.0f));
            IMExtendBtnsAdapter iMExtendBtnsAdapter = new IMExtendBtnsAdapter();
            this.f10416d.setLayoutManager(new LinearLayoutManager(this.f10415c));
            this.f10416d.setAdapter(iMExtendBtnsAdapter);
            IMDividerDecoration iMDividerDecoration = new IMDividerDecoration();
            iMDividerDecoration.setDividerColor(IMResource.getColor(R.color.im_op_gray_line));
            this.f10416d.addItemDecoration(iMDividerDecoration);
            this.f10414b.setFocusable(true);
        }
    }

    /* renamed from: com.didi.beatles.im.views.popup.IMExtendBtnPopup$IMExtendBtnsAdapter */
    private class IMExtendBtnsAdapter extends RecyclerView.Adapter {
        private IMExtendBtnsAdapter() {
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new IMExtendViewHolder(LayoutInflater.from(IMExtendBtnPopup.this.f10415c).inflate(R.layout.im_item_extend_btns, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
            IMExtendViewHolder iMExtendViewHolder = (IMExtendViewHolder) viewHolder;
            if (((IMExtendBtnModule) IMExtendBtnPopup.this.f10417e.get(i)).icon != null) {
                BtsImageLoader.getInstance().loadInto(((IMExtendBtnModule) IMExtendBtnPopup.this.f10417e.get(i)).icon, iMExtendViewHolder.mImageview);
            }
            iMExtendViewHolder.mTextView.setText(((IMExtendBtnModule) IMExtendBtnPopup.this.f10417e.get(i)).text);
            iMExtendViewHolder.rootView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (((IMExtendBtnModule) IMExtendBtnPopup.this.f10417e.get(i)).link == null) {
                        IMLog.m6631d(IMExtendBtnPopup.f10409a, "link is null !");
                        return;
                    }
                    IMCommonUtil.startUriActivity(IMExtendBtnPopup.this.f10415c, ((IMExtendBtnModule) IMExtendBtnPopup.this.f10417e.get(i)).link);
                    IMExtendBtnPopup.this.dismiss();
                    IMMsgOmega.getInstance().trackMoreBtn(((IMExtendBtnModule) IMExtendBtnPopup.this.f10417e.get(i)).text);
                }
            });
        }

        public int getItemCount() {
            if (IMExtendBtnPopup.this.f10417e != null) {
                return IMExtendBtnPopup.this.f10417e.size();
            }
            return 0;
        }

        /* renamed from: com.didi.beatles.im.views.popup.IMExtendBtnPopup$IMExtendBtnsAdapter$IMExtendViewHolder */
        class IMExtendViewHolder extends RecyclerView.ViewHolder {
            ImageView mImageview;
            TextView mTextView;
            View rootView;

            public IMExtendViewHolder(View view) {
                super(view);
                this.mImageview = (ImageView) view.findViewById(R.id.extend_btn_icon);
                this.mTextView = (TextView) view.findViewById(R.id.extend_btn_text);
                this.rootView = view;
            }
        }
    }
}
