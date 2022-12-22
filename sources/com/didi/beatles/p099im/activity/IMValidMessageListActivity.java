package com.didi.beatles.p099im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.activity.IMValidMessageListActivity */
public class IMValidMessageListActivity extends IMMessageListActivity {
    public static void startActivity(Context context, int i) {
        Intent intent = new Intent(context, IMValidMessageListActivity.class);
        if (i != 0) {
            intent.putExtra("sessin_type", i);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startActivityWithNewTask(Context context, int i) {
        Intent intent = new Intent(context, IMValidMessageListActivity.class);
        if (i != 0) {
            intent.putExtra("sessin_type", i);
        }
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void parseIntent() {
        this.mNeedSessionType = getIntent().getIntExtra("sessin_type", 23);
    }

    public List<IMSession> addFootView(List<IMSession> list) {
        if (list != null) {
            IMSession iMSession = new IMSession();
            iMSession.setType(-1);
            list.add(list.size(), iMSession);
        }
        return list;
    }

    public List<IMSession> removeFootView(List<IMSession> list) {
        if (list != null && list.size() > 0 && list.get(list.size() - 1).getType() == -1) {
            list.remove(list.size() - 1);
        }
        return list;
    }

    public void handleEmptyCheckOverDueView(View view) {
        TextView textView = (TextView) view.findViewById(R.id.empty_check_over_due_view);
        if (this.mSessionModule == null || !this.mSessionModule.isHaveOverDueMessage(0)) {
            textView.setVisibility(8);
        } else {
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMValidMessageListActivity iMValidMessageListActivity = IMValidMessageListActivity.this;
                    IMEngine.startOverdueChatListActivity(iMValidMessageListActivity, iMValidMessageListActivity.mNeedSessionType);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void initTitle() {
        this.titleBar.setTitle(getString(R.string.bts_im_title));
    }

    /* access modifiers changed from: protected */
    public void loadSessionAsync() {
        if (this.mSessionModule != null) {
            this.isValidList = true;
            this.mSessionModule.loadSessionAsync(true, this.mNeedSessionType);
        }
    }

    /* access modifiers changed from: protected */
    public String getNoMsgWording() {
        return getString(R.string.bts_im_no_chat_tip1);
    }

    public void onSessionStatusUpdate(List<IMSession> list) {
        if (this.mSessionModule != null) {
            this.mSessionModule.loadSessionAsync(true, this.mNeedSessionType);
        }
    }
}
