package global.didi.pay.threeds.method.cybs;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.cardinalcommerce.cardinalmobilesdk.Cardinal;
import com.cardinalcommerce.cardinalmobilesdk.enums.CardinalEnvironment;
import com.cardinalcommerce.cardinalmobilesdk.enums.CardinalRenderType;
import com.cardinalcommerce.cardinalmobilesdk.enums.CardinalUiType;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import global.didi.pay.threeds.contract.ICybs3DS;
import global.didi.pay.threeds.contract.ICybs3DSConfig;
import global.didi.pay.threeds.model.Cybs3DSModel;
import global.didi.pay.threeds.model.CybsNotifyEvent;
import global.didi.pay.threeds.network.api.ThreedsApi;
import global.didi.pay.threeds.network.callback.ThreedsNetCallback;
import global.didi.pay.threeds.network.model.ThreedsAuthCode;
import global.didi.pay.threeds.network.model.ThreedsChannelInfo;
import global.didi.pay.threeds.network.model.ThreedsCybsDataResponse;
import global.didi.pay.threeds.network.model.ThreedsCybsResultResponse;
import global.didi.pay.threeds.network.model.ThreedsError;
import global.didi.pay.threeds.network.model.ThreedsInit;
import global.didi.pay.threeds.network.model.ThreedsVerify;
import global.didi.pay.threeds.utils.ThreeDSUiThreadHandler;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;

@Metadata(mo175977d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 H2\u00020\u0001:\u0001HB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004JN\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f0\u001d2\u0016\b\u0002\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001d2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u001f0\u001dH\u0002J\u0010\u0010#\u001a\u00020\u001f2\b\u0010$\u001a\u0004\u0018\u00010\u0018J\u0012\u0010%\u001a\u00020\u001f2\b\u0010&\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010'\u001a\u00020\u001fH\u0002J\u0010\u0010(\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020\u0010H\u0016J\u0010\u0010*\u001a\u00020\u001f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003JQ\u0010+\u001a\u00020\u001f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010/\u001a\u0004\u0018\u0001002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u00102\u001a\u000200¢\u0006\u0002\u00103J\u000e\u00104\u001a\u00020\u001f2\u0006\u0010,\u001a\u000200J\u0006\u00105\u001a\u00020\u001fJ\u000e\u00106\u001a\u00020\u001f2\u0006\u00102\u001a\u000200J\u001a\u00107\u001a\u00020\u001f2\b\b\u0002\u00102\u001a\u0002002\b\b\u0002\u00108\u001a\u000200J\u0010\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001eH\u0002J\u0018\u0010<\u001a\u00020\u001f2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u000200H\u0002J\u0012\u0010@\u001a\u00020\u001f2\b\u0010A\u001a\u0004\u0018\u00010BH\u0007J\u0012\u0010C\u001a\u00020\u001f2\b\u0010D\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010E\u001a\u00020\u001fH\u0016J\u001c\u0010F\u001a\u00020\u001f2\u0012\u0010G\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017X\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, mo175978d2 = {"Lglobal/didi/pay/threeds/method/cybs/Cybs3DS;", "Lglobal/didi/pay/threeds/contract/ICybs3DS;", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "cardinal", "Lcom/cardinalcommerce/cardinalmobilesdk/Cardinal;", "getCardinal", "()Lcom/cardinalcommerce/cardinalmobilesdk/Cardinal;", "cardinal$delegate", "Lkotlin/Lazy;", "cybs3DSListener", "Lglobal/didi/pay/threeds/method/cybs/ICybs3DSListener;", "cybs3DSModel", "Lglobal/didi/pay/threeds/model/Cybs3DSModel;", "network", "Lglobal/didi/pay/threeds/network/api/ThreedsApi;", "getNetwork", "()Lglobal/didi/pay/threeds/network/api/ThreedsApi;", "network$delegate", "omegaAttr", "", "", "callback", "Lglobal/didi/pay/threeds/network/callback/ThreedsNetCallback;", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsResultResponse;", "success", "Lkotlin/Function1;", "Lglobal/didi/pay/threeds/network/model/ThreedsCybsDataResponse;", "", "pending", "failed", "Lglobal/didi/pay/threeds/network/model/ThreedsError;", "channelAuth", "consumerSessionId", "channelVerify", "authId", "getChannelInfo", "handleModel", "model", "init", "omegaAuthCode", "type", "auth", "version", "errno", "", "errno_json", "status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;I)V", "omegaChallengePageCloseSw", "omegaChallengePageSw", "omegaInit", "omegaVerify", "result", "onChannelAuth", "", "dataResponse", "onChannelInfo", "channelInfo", "Lglobal/didi/pay/threeds/network/model/ThreedsChannelInfo;", "repeatTime", "onEvent", "data", "Lglobal/didi/pay/threeds/model/CybsNotifyEvent;", "registerListener", "listener", "unregisterListener", "updateOmegaAttr", "map", "Companion", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Cybs3DS.kt */
public final class Cybs3DS implements ICybs3DS {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static String appVersion;
    /* access modifiers changed from: private */
    public static String sdkVersion;
    /* access modifiers changed from: private */
    public static String terminalId;
    /* access modifiers changed from: private */
    public static Boolean testEnv = false;
    private final FragmentActivity activity;
    private final Lazy cardinal$delegate = LazyKt.lazy(Cybs3DS$cardinal$2.INSTANCE);
    /* access modifiers changed from: private */
    public ICybs3DSListener cybs3DSListener;
    private Cybs3DSModel cybs3DSModel;
    private final Lazy network$delegate = LazyKt.lazy(new Cybs3DS$network$2(this));
    private final Map<String, String> omegaAttr = new LinkedHashMap();

    @Metadata(mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Cybs3DS.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CardinalActionCode.values().length];
            iArr[CardinalActionCode.SUCCESS.ordinal()] = 1;
            iArr[CardinalActionCode.CANCEL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public Cybs3DS(FragmentActivity fragmentActivity) {
        this.activity = fragmentActivity;
        init(this.activity);
    }

    public final FragmentActivity getActivity() {
        return this.activity;
    }

    @Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, mo175978d2 = {"Lglobal/didi/pay/threeds/method/cybs/Cybs3DS$Companion;", "", "()V", "appVersion", "", "getAppVersion", "()Ljava/lang/String;", "setAppVersion", "(Ljava/lang/String;)V", "sdkVersion", "getSdkVersion", "setSdkVersion", "terminalId", "getTerminalId", "setTerminalId", "testEnv", "", "getTestEnv", "()Ljava/lang/Boolean;", "setTestEnv", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "payThreeds_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: Cybs3DS.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getAppVersion() {
            return Cybs3DS.appVersion;
        }

        public final void setAppVersion(String str) {
            Cybs3DS.appVersion = str;
        }

        public final String getTerminalId() {
            return Cybs3DS.terminalId;
        }

        public final void setTerminalId(String str) {
            Cybs3DS.terminalId = str;
        }

        public final String getSdkVersion() {
            return Cybs3DS.sdkVersion;
        }

        public final void setSdkVersion(String str) {
            Cybs3DS.sdkVersion = str;
        }

        public final Boolean getTestEnv() {
            return Cybs3DS.testEnv;
        }

        public final void setTestEnv(Boolean bool) {
            Cybs3DS.testEnv = bool;
        }
    }

    private final Cardinal getCardinal() {
        Object value = this.cardinal$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-cardinal>(...)");
        return (Cardinal) value;
    }

    private final ThreedsApi getNetwork() {
        return (ThreedsApi) this.network$delegate.getValue();
    }

    public final void init(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null) {
            ICybs3DSConfig iCybs3DSConfig = (ICybs3DSConfig) ServiceLoader.load(ICybs3DSConfig.class).get();
            Context context = fragmentActivity;
            appVersion = iCybs3DSConfig.appVersion(context);
            sdkVersion = iCybs3DSConfig.sdkVersion(context);
            terminalId = iCybs3DSConfig.terminalId(context);
            testEnv = iCybs3DSConfig.testEnv(context);
        }
        CardinalConfigurationParameters cardinalConfigurationParameters = new CardinalConfigurationParameters();
        Cybs3DS cybs3DS = this;
        Cybs3DS cybs3DS2 = null;
        Cybs3DS cybs3DS3 = Intrinsics.areEqual((Object) testEnv, (Object) true) ? this : null;
        if (cybs3DS3 != null) {
            cardinalConfigurationParameters.setEnvironment(CardinalEnvironment.STAGING);
            cybs3DS2 = cybs3DS3;
        }
        if (cybs3DS2 == null) {
            cardinalConfigurationParameters.setEnvironment(CardinalEnvironment.PRODUCTION);
        }
        cardinalConfigurationParameters.setRequestTimeout(8000);
        cardinalConfigurationParameters.setChallengeTimeout(5);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(CardinalRenderType.OTP);
        jSONArray.put(CardinalRenderType.SINGLE_SELECT);
        jSONArray.put(CardinalRenderType.MULTI_SELECT);
        jSONArray.put(CardinalRenderType.OOB);
        jSONArray.put(CardinalRenderType.HTML);
        cardinalConfigurationParameters.setRenderType(jSONArray);
        cardinalConfigurationParameters.setUiType(CardinalUiType.BOTH);
        getCardinal().configure(fragmentActivity, cardinalConfigurationParameters);
    }

    static /* synthetic */ ThreedsNetCallback callback$default(Cybs3DS cybs3DS, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = null;
        }
        return cybs3DS.callback(function1, function12, function13);
    }

    private final ThreedsNetCallback<ThreedsCybsResultResponse> callback(Function1<? super ThreedsCybsDataResponse, Unit> function1, Function1<? super ThreedsCybsDataResponse, Unit> function12, Function1<? super ThreedsError, Unit> function13) {
        return new Cybs3DS$callback$1(function13, function1, function12, this);
    }

    public void updateOmegaAttr(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.omegaAttr.putAll(map);
    }

    public void handleModel(Cybs3DSModel cybs3DSModel2) {
        Intrinsics.checkNotNullParameter(cybs3DSModel2, "model");
        this.cybs3DSModel = cybs3DSModel2;
        getChannelInfo();
    }

    private final void getChannelInfo() {
        ThreedsApi network = getNetwork();
        if (network != null) {
            ThreedsInit threedsInit = new ThreedsInit((String) null, 1, (DefaultConstructorMarker) null);
            Cybs3DSModel cybs3DSModel2 = this.cybs3DSModel;
            if (cybs3DSModel2 != null) {
                threedsInit.setSessionId(cybs3DSModel2.sessionId);
                Unit unit = Unit.INSTANCE;
                network.channelInfo3DSInit(threedsInit, callback(new Cybs3DS$getChannelInfo$2(this), (Function1<? super ThreedsCybsDataResponse, Unit>) null, new Cybs3DS$getChannelInfo$3(this)));
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("cybs3DSModel");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    public final void onChannelInfo(ThreedsChannelInfo threedsChannelInfo, int i) {
        getCardinal().init(threedsChannelInfo.getJwt(), new Cybs3DS$onChannelInfo$1(this, i, threedsChannelInfo));
    }

    public final void channelAuth(String str) {
        ThreedsApi network = getNetwork();
        if (network != null) {
            ThreedsAuthCode threedsAuthCode = new ThreedsAuthCode((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            Cybs3DSModel cybs3DSModel2 = this.cybs3DSModel;
            if (cybs3DSModel2 != null) {
                threedsAuthCode.setSessionId(cybs3DSModel2.sessionId);
                threedsAuthCode.setConsumerSessionId(str);
                Unit unit = Unit.INSTANCE;
                network.channelInfo3DSAuthCode(threedsAuthCode, callback(new Cybs3DS$channelAuth$2(this), new Cybs3DS$channelAuth$3(this), new Cybs3DS$channelAuth$4(this)));
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("cybs3DSModel");
            throw null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onChannelAuth(global.didi.pay.threeds.network.model.ThreedsCybsDataResponse r10) {
        /*
            r9 = this;
            java.lang.String r3 = r10.getVersion()
            java.lang.String r1 = "challenge"
            java.lang.String r2 = "pending"
            r4 = 0
            r5 = 0
            r6 = 1
            r7 = 24
            r8 = 0
            r0 = r9
            omegaAuthCode$default(r0, r1, r2, r3, r4, r5, r6, r7, r8)
            java.lang.String r0 = r10.getVersion()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x001c
        L_0x001a:
            r0 = 0
            goto L_0x0025
        L_0x001c:
            char r0 = r0.charAt(r2)
            r3 = 49
            if (r0 != r3) goto L_0x001a
            r0 = 1
        L_0x0025:
            if (r0 == 0) goto L_0x0066
            java.lang.String r0 = r10.getUrlOf3ds()
            if (r0 != 0) goto L_0x002f
        L_0x002d:
            r0 = 0
            goto L_0x003d
        L_0x002f:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0039
            r0 = 1
            goto L_0x003a
        L_0x0039:
            r0 = 0
        L_0x003a:
            if (r0 != r1) goto L_0x002d
            r0 = 1
        L_0x003d:
            if (r0 == 0) goto L_0x0066
            r9.omegaChallengePageSw()
            global.didi.pay.threeds.method.cybs.CybsWebActivity$Companion r3 = global.didi.pay.threeds.method.cybs.CybsWebActivity.Companion
            androidx.fragment.app.FragmentActivity r0 = r9.activity
            r4 = r0
            android.app.Activity r4 = (android.app.Activity) r4
            java.lang.String r5 = r10.getPayload()
            java.lang.String r6 = r10.getUrlOf3ds()
            global.didi.pay.threeds.model.Cybs3DSModel r0 = r9.cybs3DSModel
            if (r0 == 0) goto L_0x005f
            java.lang.String r7 = r0.sessionId
            java.lang.String r8 = r10.getAuthId()
            r3.startActivity(r4, r5, r6, r7, r8)
            return r1
        L_0x005f:
            java.lang.String r10 = "cybs3DSModel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
            r10 = 0
            throw r10
        L_0x0066:
            java.lang.String r0 = r10.getVersion()
            if (r0 != 0) goto L_0x006e
        L_0x006c:
            r0 = 0
            goto L_0x0077
        L_0x006e:
            char r0 = r0.charAt(r2)
            r3 = 50
            if (r0 != r3) goto L_0x006c
            r0 = 1
        L_0x0077:
            if (r0 == 0) goto L_0x00c5
            java.lang.String r0 = r10.getPayload()
            if (r0 != 0) goto L_0x0081
        L_0x007f:
            r0 = 0
            goto L_0x008f
        L_0x0081:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x008b
            r0 = 1
            goto L_0x008c
        L_0x008b:
            r0 = 0
        L_0x008c:
            if (r0 != r1) goto L_0x007f
            r0 = 1
        L_0x008f:
            if (r0 == 0) goto L_0x00c5
            java.lang.String r0 = r10.getAuthId()
            if (r0 != 0) goto L_0x0099
        L_0x0097:
            r0 = 0
            goto L_0x00a7
        L_0x0099:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x00a3
            r0 = 1
            goto L_0x00a4
        L_0x00a3:
            r0 = 0
        L_0x00a4:
            if (r0 != r1) goto L_0x0097
            r0 = 1
        L_0x00a7:
            if (r0 == 0) goto L_0x00c5
            r9.omegaChallengePageSw()
            com.cardinalcommerce.cardinalmobilesdk.Cardinal r0 = r9.getCardinal()
            java.lang.String r2 = r10.getAuthId()
            java.lang.String r3 = r10.getPayload()
            androidx.fragment.app.FragmentActivity r4 = r9.activity
            android.app.Activity r4 = (android.app.Activity) r4
            global.didi.pay.threeds.method.cybs.-$$Lambda$Cybs3DS$1344OJfJKAM8ICmJz_q-Ib80Kys r5 = new global.didi.pay.threeds.method.cybs.-$$Lambda$Cybs3DS$1344OJfJKAM8ICmJz_q-Ib80Kys
            r5.<init>(r10)
            r0.cca_continue(r2, r3, r4, r5)
            return r1
        L_0x00c5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: global.didi.pay.threeds.method.cybs.Cybs3DS.onChannelAuth(global.didi.pay.threeds.network.model.ThreedsCybsDataResponse):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: onChannelAuth$lambda-10  reason: not valid java name */
    public static final void m47660onChannelAuth$lambda10(Cybs3DS cybs3DS, ThreedsCybsDataResponse threedsCybsDataResponse, Context context, ValidateResponse validateResponse, String str) {
        Intrinsics.checkNotNullParameter(cybs3DS, "this$0");
        Intrinsics.checkNotNullParameter(threedsCybsDataResponse, "$dataResponse");
        SystemUtils.log(4, "Arirus", Intrinsics.stringPlus("onChannelAuth: ", str), (Throwable) null, "global.didi.pay.threeds.method.cybs.Cybs3DS", 248);
        CardinalActionCode actionCode = validateResponse.getActionCode();
        int i = actionCode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[actionCode.ordinal()];
        if (i == 1) {
            cybs3DS.channelVerify(threedsCybsDataResponse.getAuthId());
            cybs3DS.omegaChallengePageCloseSw(1);
        } else if (i != 2) {
            ThreeDSUiThreadHandler.INSTANCE.post(new Runnable() {
                public final void run() {
                    Cybs3DS.m47662onChannelAuth$lambda10$lambda9(Cybs3DS.this);
                }
            });
        } else {
            ThreeDSUiThreadHandler.INSTANCE.post(new Runnable() {
                public final void run() {
                    Cybs3DS.m47661onChannelAuth$lambda10$lambda7(Cybs3DS.this);
                }
            });
            cybs3DS.omegaChallengePageCloseSw(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onChannelAuth$lambda-10$lambda-7  reason: not valid java name */
    public static final void m47661onChannelAuth$lambda10$lambda7(Cybs3DS cybs3DS) {
        String string;
        Intrinsics.checkNotNullParameter(cybs3DS, "this$0");
        ICybs3DSListener iCybs3DSListener = cybs3DS.cybs3DSListener;
        if (iCybs3DSListener != null) {
            ThreedsError author_error = ThreedsError.Companion.getAUTHOR_ERROR();
            FragmentActivity activity2 = cybs3DS.getActivity();
            String str = "";
            if (!(activity2 == null || (string = activity2.getString(R.string.threeds_fail_message)) == null)) {
                str = string;
            }
            author_error.setMessage(str);
            Unit unit = Unit.INSTANCE;
            iCybs3DSListener.onFailure(author_error);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onChannelAuth$lambda-10$lambda-9  reason: not valid java name */
    public static final void m47662onChannelAuth$lambda10$lambda9(Cybs3DS cybs3DS) {
        String string;
        Intrinsics.checkNotNullParameter(cybs3DS, "this$0");
        ICybs3DSListener iCybs3DSListener = cybs3DS.cybs3DSListener;
        if (iCybs3DSListener != null) {
            ThreedsError init_error = ThreedsError.Companion.getINIT_ERROR();
            FragmentActivity activity2 = cybs3DS.getActivity();
            String str = "";
            if (!(activity2 == null || (string = activity2.getString(R.string.threeds_fail_message)) == null)) {
                str = string;
            }
            init_error.setMessage(str);
            Unit unit = Unit.INSTANCE;
            iCybs3DSListener.onFailure(init_error);
        }
    }

    private final void channelVerify(String str) {
        ThreedsApi network = getNetwork();
        if (network != null) {
            ThreedsVerify threedsVerify = new ThreedsVerify((String) null, (String) null, 3, (DefaultConstructorMarker) null);
            Cybs3DSModel cybs3DSModel2 = this.cybs3DSModel;
            if (cybs3DSModel2 != null) {
                threedsVerify.setSessionId(cybs3DSModel2.sessionId);
                threedsVerify.setAuthId(str);
                Unit unit = Unit.INSTANCE;
                network.channelInfo3DSVerify(threedsVerify, callback(new Cybs3DS$channelVerify$2(this), (Function1<? super ThreedsCybsDataResponse, Unit>) null, new Cybs3DS$channelVerify$3(this)));
                return;
            }
            Intrinsics.throwUninitializedPropertyAccessException("cybs3DSModel");
            throw null;
        }
    }

    public void registerListener(ICybs3DSListener iCybs3DSListener) {
        this.cybs3DSListener = iCybs3DSListener;
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    public void unregisterListener() {
        this.cybs3DSListener = null;
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Subscribe
    public final void onEvent(CybsNotifyEvent cybsNotifyEvent) {
        String string;
        if (Intrinsics.areEqual((Object) cybsNotifyEvent == null ? null : cybsNotifyEvent.getType(), (Object) "1.0")) {
            omegaChallengePageCloseSw(1);
            channelVerify(cybsNotifyEvent.getAuthId());
            return;
        }
        omegaChallengePageCloseSw(0);
        ICybs3DSListener iCybs3DSListener = this.cybs3DSListener;
        if (iCybs3DSListener != null) {
            ThreedsError author_error = ThreedsError.Companion.getAUTHOR_ERROR();
            FragmentActivity activity2 = getActivity();
            String str = "";
            if (!(activity2 == null || (string = activity2.getString(R.string.threeds_fail_message)) == null)) {
                str = string;
            }
            author_error.setMessage(str);
            Unit unit = Unit.INSTANCE;
            iCybs3DSListener.onFailure(author_error);
        }
    }

    public final void omegaInit(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", this.omegaAttr.get("uid"));
        linkedHashMap.put("scene", this.omegaAttr.get("scene"));
        linkedHashMap.put("type", "");
        linkedHashMap.put("order_id", this.omegaAttr.get("order_id"));
        linkedHashMap.put("pub_biz", "fintech");
        linkedHashMap.put("status", Integer.valueOf(i));
        Unit unit = Unit.INSTANCE;
        OmegaSDKAdapter.trackEvent("fin_cybs_3ds_verify_st", (Map<String, Object>) linkedHashMap);
    }

    public static /* synthetic */ void omegaAuthCode$default(Cybs3DS cybs3DS, String str, String str2, String str3, Integer num, String str4, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            num = null;
        }
        if ((i2 & 16) != 0) {
            str4 = null;
        }
        if ((i2 & 32) != 0) {
            i = 1;
        }
        cybs3DS.omegaAuthCode(str, str2, str3, num, str4, i);
    }

    public final void omegaAuthCode(String str, String str2, String str3, Integer num, String str4, int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", this.omegaAttr.get("uid"));
        linkedHashMap.put("scene", this.omegaAttr.get("scene"));
        linkedHashMap.put("type", str);
        linkedHashMap.put("auth", str2);
        linkedHashMap.put("version", str3);
        linkedHashMap.put("errno", num);
        linkedHashMap.put("errno_json", str4);
        linkedHashMap.put("order_id", this.omegaAttr.get("order_id"));
        linkedHashMap.put("pub_biz", "fintech");
        linkedHashMap.put("status", Integer.valueOf(i));
        Unit unit = Unit.INSTANCE;
        OmegaSDKAdapter.trackEvent("fin_cybs_3ds_verify_result_ex", (Map<String, Object>) linkedHashMap);
    }

    public static /* synthetic */ void omegaVerify$default(Cybs3DS cybs3DS, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        if ((i3 & 2) != 0) {
            i2 = 1;
        }
        cybs3DS.omegaVerify(i, i2);
    }

    public final void omegaVerify(int i, int i2) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", this.omegaAttr.get("uid"));
        linkedHashMap.put("scene", this.omegaAttr.get("scene"));
        linkedHashMap.put("order_id", this.omegaAttr.get("order_id"));
        linkedHashMap.put("pub_biz", "fintech");
        linkedHashMap.put("status", Integer.valueOf(i));
        linkedHashMap.put("result", Integer.valueOf(i2));
        Unit unit = Unit.INSTANCE;
        OmegaSDKAdapter.trackEvent("fin_cybs_3ds_verify_result_server_st", (Map<String, Object>) linkedHashMap);
    }

    public final void omegaChallengePageSw() {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", this.omegaAttr.get("uid"));
        linkedHashMap.put("scene", this.omegaAttr.get("scene"));
        linkedHashMap.put("order_id", this.omegaAttr.get("order_id"));
        linkedHashMap.put("pub_biz", "fintech");
        Unit unit = Unit.INSTANCE;
        OmegaSDKAdapter.trackEvent("fin_cybs_3ds_verify_challenge_en", (Map<String, Object>) linkedHashMap);
    }

    public final void omegaChallengePageCloseSw(int i) {
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", this.omegaAttr.get("uid"));
        linkedHashMap.put("scene", this.omegaAttr.get("scene"));
        linkedHashMap.put("order_id", this.omegaAttr.get("order_id"));
        linkedHashMap.put("pub_biz", "fintech");
        linkedHashMap.put("type", Integer.valueOf(i));
        Unit unit = Unit.INSTANCE;
        OmegaSDKAdapter.trackEvent("fin_cybs_3ds_verify_challenge_ex", (Map<String, Object>) linkedHashMap);
    }
}
