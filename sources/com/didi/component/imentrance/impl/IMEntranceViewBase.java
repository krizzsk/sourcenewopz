package com.didi.component.imentrance.impl;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.module.entity.IMSysChatUnreadCount;
import com.didi.component.imentrance.AbsIMEntrancePresenter;
import com.didi.component.imentrance.IIMEntranceView;
import com.didi.component.imentrance.model.DriverOptionModel;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.taxis99.R;

public abstract class IMEntranceViewBase implements View.OnClickListener, IIMEntranceView {

    /* renamed from: a */
    private IIMEntranceView.OnIMEntranceClickListener f14151a;
    protected Context mContext;
    protected TextView mIMCount = ((TextView) findView(R.id.im_entrance_msg));
    protected AbsIMEntrancePresenter mPresenter;
    protected ViewGroup mView;

    /* access modifiers changed from: protected */
    public abstract ViewGroup inflateContentView(Context context, ViewGroup viewGroup);

    public void nearPickupShow() {
    }

    public void refreshMessageCount(IMSysChatUnreadCount iMSysChatUnreadCount) {
    }

    public void setData(DriverOptionModel driverOptionModel) {
    }

    public IMEntranceViewBase(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        ViewGroup inflateContentView = inflateContentView(context, viewGroup);
        this.mView = inflateContentView;
        inflateContentView.setClipChildren(false);
        this.mView.setClipToPadding(false);
        this.mView.setOnClickListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        IIMEntranceView.OnIMEntranceClickListener onIMEntranceClickListener = this.f14151a;
        if (onIMEntranceClickListener != null) {
            onIMEntranceClickListener.onIMEntranceClick();
        }
    }

    public void refreshMessageCount(int i) {
        TextView textView = this.mIMCount;
        if (textView != null) {
            textView.setVisibility(i > 0 ? 0 : 8);
            this.mIMCount.setText(i > 99 ? "···" : String.valueOf(i));
        }
    }

    /* access modifiers changed from: protected */
    public void refreshMessageCount(TextView textView, IMSysChatUnreadCount iMSysChatUnreadCount) {
        int i;
        if (textView != null) {
            textView.setVisibility(iMSysChatUnreadCount.chatMsgUnreadCount + iMSysChatUnreadCount.sysMsgUnreadCount > 0 ? 0 : 8);
            if (iMSysChatUnreadCount.chatMsgUnreadCount > 0) {
                ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                if (iMSysChatUnreadCount.chatMsgUnreadCount > 99) {
                    i = ResUtils.dp2px(25.0f);
                } else {
                    i = iMSysChatUnreadCount.chatMsgUnreadCount > 9 ? ResUtils.dp2px(20.0f) : ResUtils.dp2px(15.0f);
                }
                layoutParams.width = i;
                layoutParams.height = ResUtils.dp2px(15.0f);
                textView.setLayoutParams(layoutParams);
                textView.setText(iMSysChatUnreadCount.chatMsgUnreadCount > 99 ? "99+" : String.valueOf(iMSysChatUnreadCount.chatMsgUnreadCount));
            } else if (iMSysChatUnreadCount.sysMsgUnreadCount > 0) {
                ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                int dp2px = ResUtils.dp2px(8.0f);
                layoutParams2.width = dp2px;
                layoutParams2.height = dp2px;
                textView.setLayoutParams(layoutParams2);
                textView.setText("");
            }
        }
    }

    public void setIMClickable(boolean z) {
        this.mView.setClickable(z);
    }

    public void show() {
        this.mView.setEnabled(true);
        this.mView.setClickable(true);
    }

    public void hide() {
        this.mView.setEnabled(false);
        this.mView.setClickable(false);
    }

    public void setOnIMEntranceClickListener(IIMEntranceView.OnIMEntranceClickListener onIMEntranceClickListener) {
        this.f14151a = onIMEntranceClickListener;
    }

    public View getView() {
        return this.mView;
    }

    public void setPresenter(AbsIMEntrancePresenter absIMEntrancePresenter) {
        this.mPresenter = absIMEntrancePresenter;
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findView(int i) {
        return this.mView.findViewById(i);
    }
}
