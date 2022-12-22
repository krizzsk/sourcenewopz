package com.didichuxing.diface.appeal.brazil;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.TakePhotoDoneEvent;
import com.didichuxing.diface.appeal.TakePhotoInfo;
import com.squareup.otto.Subscribe;
import com.taxis99.R;

public class BRTakePhotoGuideAct extends DFBaseAct {

    /* renamed from: a */
    private ImageView f47036a;

    /* renamed from: b */
    private TextView f47037b;

    /* renamed from: c */
    private TextView f47038c;

    /* renamed from: d */
    private TextView f47039d;

    /* renamed from: e */
    private TextView f47040e;

    /* renamed from: f */
    private Button f47041f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public int f47042g;

    /* renamed from: h */
    private final SparseArray<ResInfo> f47043h = new SparseArray<>();

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.br_act_df_take_photo_guide_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context, int i) {
        Intent intent = new Intent(context, BRTakePhotoGuideAct.class);
        intent.putExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, i);
        context.startActivity(intent);
    }

    public static class ResInfo {
        /* access modifiers changed from: private */
        public final int imageRes;
        /* access modifiers changed from: private */
        public final int stringArray;

        ResInfo(int i, int i2) {
            this.imageRes = i;
            this.stringArray = i2;
        }
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f47043h.put(1, new ResInfo(R.drawable.br_df_appeal_driver_license_g1, R.array.df_appeal_driver_license_g1));
        this.f47043h.put(2, new ResInfo(R.drawable.df_appeal_driver_license_g2_qr, R.array.df_appeal_driver_license_g2_qr));
        this.f47043h.put(3, new ResInfo(R.drawable.df_appeal_doc_rg, R.array.df_appeal_doc_type_RG));
        this.f47043h.put(4, new ResInfo(R.drawable.df_appeal_doc_cdr, R.array.df_appeal_doc_type_cdr));
        this.f47043h.put(5, new ResInfo(R.drawable.br_df_appeal_doc_cdt, R.array.df_appeal_doc_type_cdt));
        this.f47043h.put(6, new ResInfo(R.drawable.br_df_appeal_doc_passport, R.array.df_appeal_doc_type_passport));
        this.f47043h.put(7, new ResInfo(R.drawable.br_df_appeal_self_photo, R.array.df_appeal_self_photo));
        this.f47042g = intent.getIntExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, 0);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        boolean isValidType = TakePhotoInfo.isValidType(this.f47042g);
        CheckUtils.checkAssert(isValidType, "invalid photoType, mPhotoType=" + this.f47042g);
        if (!isValidType) {
            finish();
            return;
        }
        this.f47036a = (ImageView) findViewById(R.id.photo_demo);
        this.f47037b = (TextView) findViewById(R.id.photo_req0);
        this.f47038c = (TextView) findViewById(R.id.photo_req1);
        this.f47039d = (TextView) findViewById(R.id.photo_req2);
        this.f47040e = (TextView) findViewById(R.id.photo_req3);
        Button button = (Button) findViewById(R.id.take_photo_btn);
        this.f47041f = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoGuideAct bRTakePhotoGuideAct = BRTakePhotoGuideAct.this;
                BRTakePhotoAct.start(bRTakePhotoGuideAct, bRTakePhotoGuideAct.f47042g);
            }
        });
        m33709a(this.f47043h.get(this.f47042g));
    }

    /* renamed from: a */
    private void m33709a(ResInfo resInfo) {
        this.f47036a.setImageResource(resInfo.imageRes);
        String[] stringArray = getResources().getStringArray(resInfo.stringArray);
        TextView[] textViewArr = {this.f47037b, this.f47038c, this.f47039d, this.f47040e};
        for (int i = 0; i < stringArray.length; i++) {
            String str = stringArray[i];
            if (!TextUtils.isEmpty(str)) {
                textViewArr[i].setVisibility(0);
                textViewArr[i].setText(str);
            } else {
                textViewArr[i].setVisibility(8);
            }
        }
    }

    @Subscribe
    public void onTakePhotoDoneEvent(TakePhotoDoneEvent takePhotoDoneEvent) {
        if (!TakePhotoInfo.FILE_DOC_RG_FRONT.equals(takePhotoDoneEvent.photo)) {
            finish();
        }
    }
}
