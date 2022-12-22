package com.didi.safetoolkit.business.triprecording;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.didi.safetoolkit.api.ISFTripRecordingService;
import com.didi.safetoolkit.base.BaseSafeToolkitActivity;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.safetoolkit.business.triprecording.view.RecordWaveView;
import com.didi.safetoolkit.dialog.DiDiLoadingDialog;
import com.didi.safetoolkit.util.SfAppUtils;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014J-\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001b2\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0!2\u0006\u0010\"\u001a\u00020#H\u0016¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020\u0019H\u0002J\b\u0010)\u001a\u00020\u0019H\u0014J\b\u0010*\u001a\u00020\u0019H\u0002J\b\u0010+\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, mo175978d2 = {"Lcom/didi/safetoolkit/business/triprecording/TripRecordingActivity;", "Lcom/didi/safetoolkit/base/BaseSafeToolkitActivity;", "()V", "autoRecord", "", "autoRecordClick", "mBtnStart", "Landroid/widget/TextView;", "mDurationListener", "com/didi/safetoolkit/business/triprecording/TripRecordingActivity$mDurationListener$1", "Lcom/didi/safetoolkit/business/triprecording/TripRecordingActivity$mDurationListener$1;", "mOid", "", "mRecordAnimation", "Lcom/didi/safetoolkit/business/triprecording/view/RecordWaveView;", "mTvContent", "mTvDuration", "mTvLaw", "mTvStatus", "sfViewRecordingModel", "Lcom/didi/safetoolkit/business/toolkit/model/SfViewRecordMenuModel;", "switchAutoRecording", "Landroid/widget/Switch;", "checkPermission", "findViews", "", "getBasicContentLayoutResId", "", "initData", "onDestroy", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "parseBundle", "bundle", "Landroid/os/Bundle;", "refreshRecordingStatus", "setListener", "startRecord", "startRecordingInner", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: TripRecordingActivity.kt */
public final class TripRecordingActivity extends BaseSafeToolkitActivity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f34473a = "";

    /* renamed from: b */
    private TextView f34474b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public TextView f34475c;

    /* renamed from: d */
    private TextView f34476d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f34477e;

    /* renamed from: f */
    private RecordWaveView f34478f;

    /* renamed from: g */
    private TextView f34479g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfViewRecordMenuModel f34480h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Switch f34481i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f34482j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f34483k;

    /* renamed from: l */
    private final TripRecordingActivity$mDurationListener$1 f34484l = new TripRecordingActivity$mDurationListener$1(this);

    /* renamed from: m */
    private HashMap f34485m;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f34485m;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f34485m == null) {
            this.f34485m = new HashMap();
        }
        View view = (View) this.f34485m.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f34485m.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_recording_activity_trip_recording;
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        findViewById(R.id.iv_recording_back).setOnClickListener(new TripRecordingActivity$setListener$1(this));
        TextView textView = this.f34476d;
        if (textView != null) {
            textView.setOnClickListener(new TripRecordingActivity$setListener$2(this));
        }
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f34474b = (TextView) findViewById(R.id.tv_recording_status);
        this.f34475c = (TextView) findViewById(R.id.tv_recording_duration);
        this.f34476d = (TextView) findViewById(R.id.tv_recording_law_link);
        this.f34476d = (TextView) findViewById(R.id.tv_recording_law_link);
        SfViewRecordMenuModel sfViewRecordMenuModel = this.f34480h;
        Integer num = null;
        if (!TextUtils.isEmpty(sfViewRecordMenuModel != null ? sfViewRecordMenuModel.detailLawTitle : null)) {
            TextView textView = this.f34476d;
            if (textView != null) {
                SfViewRecordMenuModel sfViewRecordMenuModel2 = this.f34480h;
                textView.setText(sfViewRecordMenuModel2 != null ? sfViewRecordMenuModel2.detailLawTitle : null);
            }
        } else {
            TextView textView2 = this.f34476d;
            if (textView2 != null) {
                textView2.setText(SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_privacy_clause_mPCh));
            }
        }
        this.f34479g = (TextView) findViewById(R.id.tv_recording_law);
        SfViewRecordMenuModel sfViewRecordMenuModel3 = this.f34480h;
        if (!TextUtils.isEmpty(sfViewRecordMenuModel3 != null ? sfViewRecordMenuModel3.detailContent : null)) {
            TextView textView3 = this.f34479g;
            if (textView3 != null) {
                SfViewRecordMenuModel sfViewRecordMenuModel4 = this.f34480h;
                textView3.setText(sfViewRecordMenuModel4 != null ? sfViewRecordMenuModel4.detailContent : null);
            }
        } else {
            TextView textView4 = this.f34479g;
            if (textView4 != null) {
                textView4.setText(SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_recording_trip_keKz));
            }
        }
        this.f34477e = (TextView) findViewById(R.id.btn_recording);
        this.f34478f = (RecordWaveView) findViewById(R.id.view_recording_animation);
        View findViewById = findViewById(R.id.ll_auto_recording);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById<View>(R.id.ll_auto_recording)");
        boolean z = false;
        findViewById.setVisibility(this.f34483k ? 0 : 8);
        Switch switchR = (Switch) findViewById(R.id.switch_sf_auto_recording);
        this.f34481i = switchR;
        if (switchR != null) {
            SfViewRecordMenuModel sfViewRecordMenuModel5 = this.f34480h;
            if (sfViewRecordMenuModel5 != null) {
                num = Integer.valueOf(sfViewRecordMenuModel5.autoVoiceSwitch);
            }
            switchR.setChecked(Intrinsics.areEqual((Object) num, (Object) 1));
        }
        Switch switchR2 = this.f34481i;
        if (switchR2 != null) {
            switchR2.setOnCheckedChangeListener(new TripRecordingActivity$findViews$1(this));
        }
        SfViewRecordMenuModel sfViewRecordMenuModel6 = this.f34480h;
        if (sfViewRecordMenuModel6 != null) {
            z = sfViewRecordMenuModel6.canRecord;
        }
        TripRecordOmageUtils.sendTripRecordingActShowOmega(z, this.f34473a);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra(TripRecordingActivityKt.RECORDING_ACTIVITY_EXTRA_OID);
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f34473a = stringExtra;
        Serializable serializableExtra = getIntent().getSerializableExtra(TripRecordingActivityKt.RECORDING_ACTIVITY_EXTRA_RECORD_MODEL);
        if (serializableExtra instanceof SfViewRecordMenuModel) {
            SfViewRecordMenuModel sfViewRecordMenuModel = (SfViewRecordMenuModel) serializableExtra;
            this.f34480h = sfViewRecordMenuModel;
            this.f34483k = sfViewRecordMenuModel == null || sfViewRecordMenuModel.autoVoiceSwitch != 0;
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        TextView textView = this.f34475c;
        if (textView != null) {
            textView.setText("00:00:00");
        }
        SfViewRecordMenuModel sfViewRecordMenuModel = this.f34480h;
        if (sfViewRecordMenuModel != null) {
            boolean z = true;
            if (sfViewRecordMenuModel.canRecord) {
                if (this.f34473a.length() <= 0) {
                    z = false;
                }
                if (z) {
                    m24369a();
                    return;
                }
            }
        }
        TextView textView2 = this.f34477e;
        if (textView2 != null) {
            textView2.setEnabled(false);
        }
        TextView textView3 = this.f34477e;
        if (textView3 != null) {
            textView3.setText(SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_open_agree_mVFt));
        }
        TextView textView4 = this.f34474b;
        if (textView4 != null) {
            textView4.setText(SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_recording_opening_zsVk));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m24369a() {
        if (TripRecordingManager.Companion.getInstance().isRecording()) {
            TripRecordingManager.Companion.getInstance().setDurationListener(this.f34484l);
            TextView textView = this.f34477e;
            if (textView != null) {
                textView.setEnabled(false);
            }
            TextView textView2 = this.f34477e;
            if (textView2 != null) {
                textView2.setText(SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_Recording_CPlD));
            }
            TextView textView3 = this.f34474b;
            if (textView3 != null) {
                textView3.setText(SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_Recording_jjLT));
            }
            RecordWaveView recordWaveView = this.f34478f;
            if (recordWaveView != null) {
                recordWaveView.start();
                return;
            }
            return;
        }
        TextView textView4 = this.f34477e;
        if (textView4 != null) {
            textView4.setEnabled(true);
        }
        TextView textView5 = this.f34477e;
        if (textView5 != null) {
            textView5.setText(SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_open_agree_mVFt));
        }
        TextView textView6 = this.f34474b;
        if (textView6 != null) {
            textView6.setText(SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_recording_opening_zsVk));
        }
        TextView textView7 = this.f34477e;
        if (textView7 != null) {
            textView7.setOnClickListener(new TripRecordingActivity$refreshRecordingStatus$1(this));
        }
        RecordWaveView recordWaveView2 = this.f34478f;
        if (recordWaveView2 != null) {
            recordWaveView2.stop();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m24370b() {
        if (m24372d()) {
            m24371c();
        }
    }

    /* renamed from: c */
    private final void m24371c() {
        DiDiLoadingDialog diDiLoadingDialog = new DiDiLoadingDialog(this);
        diDiLoadingDialog.showLoadingDialog(false);
        TripRecordingManager.Companion.getInstance().start(this.f34473a, new TripRecordingActivity$startRecord$1(this, diDiLoadingDialog));
    }

    /* renamed from: d */
    private final boolean m24372d() {
        if (ContextCompat.checkSelfPermission(this, Permission.RECORD_AUDIO) == 0) {
            return true;
        }
        Activity activity = this;
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Permission.RECORD_AUDIO)) {
            ISFTripRecordingService bussinessCallback = TripRecordingManager.Companion.getInstance().getBussinessCallback();
            if (bussinessCallback != null) {
                String string = SfStringGetter.getString(R.string.Global_Driver_In_trip_recording_DRV_microphone_audio_TsIB, SfAppUtils.getAppName());
                Intrinsics.checkExpressionValueIsNotNull(string, "SfStringGetter.getString… SfAppUtils.getAppName())");
                String string2 = SfStringGetter.getString(R.string.sf_confirm);
                Intrinsics.checkExpressionValueIsNotNull(string2, "SfStringGetter.getString(R.string.sf_confirm)");
                String string3 = SfStringGetter.getString(R.string.sf_cancel);
                Intrinsics.checkExpressionValueIsNotNull(string3, "SfStringGetter.getString(R.string.sf_cancel)");
                bussinessCallback.showDialog(this, "", string, string2, string3, new TripRecordingActivity$checkPermission$1(this));
            }
        } else {
            ActivityCompat.requestPermissions(activity, new String[]{Permission.RECORD_AUDIO}, 256);
        }
        return false;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        m24371c();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        RecordWaveView recordWaveView = this.f34478f;
        if (recordWaveView != null) {
            recordWaveView.stop();
        }
        TripRecordingManager.Companion.getInstance().removeDurationListener(this.f34484l);
    }
}
