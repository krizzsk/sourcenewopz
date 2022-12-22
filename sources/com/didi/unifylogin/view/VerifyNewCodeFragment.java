package com.didi.unifylogin.view;

import androidx.core.text.BidiFormatter;
import com.didi.unifylogin.base.net.LoginScene;
import com.didi.unifylogin.country.CountryManager;
import com.didi.unifylogin.presenter.VerifyCodeInputCodePresenter;
import com.didi.unifylogin.presenter.VerifyNewCodeInChangePhoneByIDPresenter;
import com.didi.unifylogin.presenter.VerifyNewCodePresenter;
import com.didi.unifylogin.presenter.ability.IVerifyCodePresenter;
import com.didi.unifylogin.utils.CertificationController;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.OmegaUtils;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.taxis99.R;

public class VerifyNewCodeFragment extends VerifyCodeFragment {

    /* renamed from: a */
    private long f45073a;

    public void onResume() {
        super.onResume();
        this.f45073a = System.currentTimeMillis();
        if (CertificationController.isAlreadyCheck()) {
            LoginLog.write(this.TAG + " onResume handleIdentityBack");
            ((IVerifyCodePresenter) this.presenter).setCell(true, false);
            cleanCode();
        }
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        String str;
        super.updateView();
        this.titleTv.setText(getString(R.string.login_unify_verify_new_code));
        if (this.messenger.getNewCellCountry() != null) {
            str = this.messenger.getNewCellCountry().calling_code + " " + PhoneUtils.toSpecialPhone(((IVerifyCodePresenter) this.presenter).getPhone());
        } else {
            str = CountryManager.getIns().getCurrentCountryCode() + " " + PhoneUtils.toSpecialPhone(((IVerifyCodePresenter) this.presenter).getPhone());
        }
        this.phoneOrEmailTv.setText(BidiFormatter.getInstance().unicodeWrap(str));
    }

    public void onPause() {
        super.onPause();
        if (this.preScene == LoginScene.SCENE_CHANGE_PHONE_BY_ID) {
            OmegaUtils.ibt_gd_time_brchangephone_verify_sw(System.currentTimeMillis() - this.f45073a);
        }
    }

    /* access modifiers changed from: protected */
    public IVerifyCodePresenter bindPresenter() {
        if (this.preScene == null) {
            return new VerifyNewCodePresenter(this, this.context);
        }
        LoginLog.write(this.TAG + " preScene: " + this.preScene.getSceneNum());
        int i = C147571.$SwitchMap$com$didi$unifylogin$base$net$LoginScene[this.preScene.ordinal()];
        if (i == 1) {
            return new VerifyCodeInputCodePresenter(this, this.context);
        }
        if (i != 2) {
            return new VerifyNewCodePresenter(this, this.context);
        }
        OmegaUtils.ibt_gd_brchangephone_verify_sw();
        return new VerifyNewCodeInChangePhoneByIDPresenter(this, this.context);
    }

    /* renamed from: com.didi.unifylogin.view.VerifyNewCodeFragment$1 */
    static /* synthetic */ class C147571 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$base$net$LoginScene;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.unifylogin.base.net.LoginScene[] r0 = com.didi.unifylogin.base.net.LoginScene.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$unifylogin$base$net$LoginScene = r0
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_CHANGE_PHONE_WITH_CODE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$unifylogin$base$net$LoginScene     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.unifylogin.base.net.LoginScene r1 = com.didi.unifylogin.base.net.LoginScene.SCENE_CHANGE_PHONE_BY_ID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.view.VerifyNewCodeFragment.C147571.<clinit>():void");
        }
    }

    public LoginState getNowState() {
        return LoginState.STATE_NEW_CODE;
    }
}
