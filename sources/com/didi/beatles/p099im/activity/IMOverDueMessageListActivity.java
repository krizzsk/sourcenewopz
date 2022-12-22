package com.didi.beatles.p099im.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.beatles.im.activity.IMOverDueMessageListActivity */
public class IMOverDueMessageListActivity extends IMMessageListActivity {
    public void onSessionStatusUpdate(List<IMSession> list) {
        if (this.mSessionModule != null) {
            this.mSessionModule.loadSessionAsync(false, this.mNeedSessionType);
        }
    }

    /* access modifiers changed from: protected */
    public void loadSessionAsync() {
        if (this.mSessionModule != null) {
            this.mSessionModule.loadSessionAsync(false, this.mNeedSessionType);
        }
    }

    public static void startActivity(Context context, int i) {
        Intent intent = new Intent(context, IMOverDueMessageListActivity.class);
        if (i != 0) {
            intent.putExtra("sessin_type", i);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public String getNoMsgWording() {
        return getString(R.string.bts_im_no_overdue_chat_tip1);
    }

    /* access modifiers changed from: protected */
    public void initTitle() {
        this.titleBar.setTitle(getString(R.string.bts_im_title_history));
    }

    /* access modifiers changed from: protected */
    public void parseIntent() {
        this.mNeedSessionType = getIntent().getIntExtra("sessin_type", 23);
    }

    public void handleEmptyCheckOverDueView(View view) {
        ((TextView) view.findViewById(R.id.empty_check_over_due_view)).setVisibility(8);
    }

    public void handleHeaderInfoView() {
        if (this.SELECT_MODE != this.CHOICE_MODE) {
            this.headerInfoLayout.setVisibility(0);
        } else {
            this.headerInfoLayout.setVisibility(8);
        }
    }
}
