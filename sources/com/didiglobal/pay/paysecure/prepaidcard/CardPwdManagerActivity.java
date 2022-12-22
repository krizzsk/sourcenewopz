package com.didiglobal.pay.paysecure.prepaidcard;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.pay.paysecure.p204ui.view.CommonBottomDialog;
import com.didiglobal.pay.paysecure.p204ui.view.DialogType;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\u0007H\u0014R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\r"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CardPwdManagerActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "curMode", "", "Ljava/lang/Integer;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CardPwdManagerActivity.kt */
public final class CardPwdManagerActivity extends FragmentActivity {
    public static final String CARD_MODE_KEY = "card_mode_key";
    public static final int CARD_PASSWORD_FORGET = 4;
    public static final int CARD_PASSWORD_RESET = 2;
    public static final int CARD_PASSWORD_SET_CARD_NO = 1;
    public static final int CARD_PASSWORD_SET_PASSWORD = 5;
    public static final int CARD_PASSWORD_VERIFY = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private Integer f50334a = 1;

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/prepaidcard/CardPwdManagerActivity$Companion;", "", "()V", "CARD_MODE_KEY", "", "CARD_PASSWORD_FORGET", "", "CARD_PASSWORD_RESET", "CARD_PASSWORD_SET_CARD_NO", "CARD_PASSWORD_SET_PASSWORD", "CARD_PASSWORD_VERIFY", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: CardPwdManagerActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_card_pwd_manager);
        Intent intent = getIntent();
        String str = null;
        this.f50334a = intent != null ? Integer.valueOf(intent.getIntExtra(CARD_MODE_KEY, 1)) : null;
        Intent intent2 = getIntent();
        String stringExtra = intent2 != null ? intent2.getStringExtra(BaseCard.KEY_CARD_ID) : null;
        Intent intent3 = getIntent();
        String stringExtra2 = intent3 != null ? intent3.getStringExtra("session_id") : null;
        Intent intent4 = getIntent();
        if (intent4 != null) {
            str = intent4.getStringExtra("scene");
        }
        String str2 = str;
        Integer num = this.f50334a;
        if (num != null && num.intValue() == 1) {
            CardPwdManager.startFragment$default(CardPwdManager.INSTANCE, getSupportFragmentManager(), 1, false, stringExtra, stringExtra2, str2, (String) null, 68, (Object) null);
        } else if (num != null && num.intValue() == 5) {
            CardPwdManager.startFragment$default(CardPwdManager.INSTANCE, getSupportFragmentManager(), 2, false, stringExtra, stringExtra2, str2, (String) null, 68, (Object) null);
        } else if (num != null && num.intValue() == 2) {
            CardPwdManager.startFragment$default(CardPwdManager.INSTANCE, getSupportFragmentManager(), 4, false, stringExtra, stringExtra2, str2, (String) null, 68, (Object) null);
        } else if (num == null || num.intValue() != 3) {
            if (num != null && num.intValue() == 4) {
                CardPwdManager.startFragment$default(CardPwdManager.INSTANCE, getSupportFragmentManager(), 5, false, stringExtra, stringExtra2, str2, (String) null, 68, (Object) null);
            } else {
                CardPwdManager.startFragment$default(CardPwdManager.INSTANCE, getSupportFragmentManager(), 1, false, stringExtra, stringExtra2, str2, (String) null, 68, (Object) null);
            }
        }
    }

    public void onBackPressed() {
        String string = getString(R.string.Fintech_Payment_Password_Conyou_sure_XxPg);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.Finte…assword_Conyou_sure_XxPg)");
        new CommonBottomDialog(this, DialogType.SMALL_BTN.name(), string).show(new CardPwdManagerActivity$onBackPressed$1(this));
        TrackerManager.Companion.trackStopActive();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        CardPwdManager.INSTANCE.setActiveListener((IActiveCardListener) null);
    }
}
