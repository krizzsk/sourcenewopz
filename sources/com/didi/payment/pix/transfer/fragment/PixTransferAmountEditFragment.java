package com.didi.payment.pix.transfer.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.global.fintech.cashier.core.presenter.GlobalCashierBizPresenter;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel0;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.payment.base.dialog.BackInfoHintDialogFragment;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.utils.ServiceLoaderUtil;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.net.PixQrCodeQueryResp;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.p129ui.event.BackStackEvent;
import com.didi.payment.commonsdk.p129ui.helper.NFloatInputHelper;
import com.didi.payment.commonsdk.p129ui.helper.NLEGODialogBuilder;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.creditcard.global.utils.InputTools;
import com.didi.payment.pix.constant.PixRouter;
import com.didi.payment.pix.net.response.PixKeyVerifyResp;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.pix.net.response.PixTransferOption;
import com.didi.payment.pix.transfer.p141vm.model.AmountEditVM;
import com.didi.payment.pix.transfer.p141vm.model.BankAccountMetaData;
import com.didi.payment.pix.utils.ViewExtsKt;
import com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp;
import com.didi.payment.wallet.password.PasswordDataVo;
import com.didi.payment.wallet.password.PasswordScene;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didiglobal.pay.paysecure.OpenCertificationListener;
import com.didiglobal.pay.paysecure.PaySecure;
import com.pay99.diff_base.DiffConstants;
import com.pay99.diff_base.DiffUtil;
import com.pay99.diff_base.base.IDiff;
import com.pay99.diff_base.base.ITransferAmountTip;
import com.taxis99.R;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J1\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u0002062\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u001d\u0010\u0001\u001a\u00020p2\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0002JQ\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u0002062\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u0001062\t\u0010\u0001\u001a\u0004\u0018\u0001062\b\u0010\u0001\u001a\u00030\u0001H\u0002J\b\u0010\u0001\u001a\u00030\u0001J\u0012\u0010\u0001\u001a\u0002062\u0007\u0010\u0001\u001a\u000206H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0016J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020FH\u0016J\u0013\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0005H\u0002J\n\u0010\u0001\u001a\u00030\u0001H\u0016J\u001e\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u0002062\t\u0010\u0001\u001a\u0004\u0018\u00010SH\u0002J(\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u00052\n\u0010 \u0001\u001a\u0005\u0018\u00010¡\u0001H\u0016J\t\u0010¢\u0001\u001a\u00020pH\u0016J\u0016\u0010£\u0001\u001a\u00030\u00012\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0016J\n\u0010¦\u0001\u001a\u00030\u0001H\u0016J\n\u0010§\u0001\u001a\u00030\u0001H\u0016J\t\u0010¨\u0001\u001a\u00020\u0005H\u0016J\n\u0010©\u0001\u001a\u00030\u0001H\u0016J\u001f\u0010ª\u0001\u001a\u00030\u00012\u0007\u0010«\u0001\u001a\u00020F2\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001H\u0016J\n\u0010¬\u0001\u001a\u00030\u0001H\u0002J\u0013\u0010­\u0001\u001a\u00030\u00012\u0007\u0010®\u0001\u001a\u00020pH\u0002J\u0011\u0010¯\u0001\u001a\u00030\u00012\u0007\u0010°\u0001\u001a\u00020\u0005J\n\u0010±\u0001\u001a\u00030\u0001H\u0002JD\u0010²\u0001\u001a\u00030\u00012\u0007\u0010³\u0001\u001a\u00020\"2\t\u0010´\u0001\u001a\u0004\u0018\u0001062\u0011\u0010µ\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010¶\u00012\u0011\u0010·\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010¶\u0001H\u0002J\u0011\u0010¸\u0001\u001a\u00030\u00012\u0007\u0010«\u0001\u001a\u00020FJ\u001c\u0010¹\u0001\u001a\u00030\u00012\u0007\u0010º\u0001\u001a\u0002062\u0007\u0010»\u0001\u001a\u000206H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0010\u00105\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010$\"\u0004\b;\u0010&R\u001a\u0010<\u001a\u00020\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001e\"\u0004\b>\u0010 R\u0010\u0010?\u001a\u0004\u0018\u00010@X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010B\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010$\"\u0004\bD\u0010&R\u001a\u0010E\u001a\u00020FX.¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010M\u001a\u00020FX.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010H\"\u0004\bO\u0010JR\u000e\u0010P\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020FX.¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX.¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\"X.¢\u0006\u0002\n\u0000R.\u0010X\u001a\"\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020Z\u0018\u00010Yj\u0010\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020Z\u0018\u0001`[X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\\\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010$\"\u0004\b^\u0010&R\u001a\u0010_\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010$\"\u0004\ba\u0010&R\u001a\u0010b\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010$\"\u0004\bd\u0010&R\u0010\u0010e\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u0004\u0018\u00010fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u0004\u0018\u000106X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\t\"\u0004\bn\u0010\u000bR\u001a\u0010o\u001a\u00020pX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001a\u0010u\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\t\"\u0004\bw\u0010\u000bR\u001a\u0010x\u001a\u00020FX.¢\u0006\u000e\n\u0000\u001a\u0004\by\u0010H\"\u0004\bz\u0010JR\u001a\u0010{\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010\t\"\u0004\b}\u0010\u000bR\u001b\u0010~\u001a\u00020\"X.¢\u0006\u000f\n\u0000\u001a\u0004\b\u0010$\"\u0005\b\u0001\u0010&¨\u0006¼\u0001"}, mo175978d2 = {"Lcom/didi/payment/pix/transfer/fragment/PixTransferAmountEditFragment;", "Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "Lcom/didi/payment/pix/transfer/vm/model/AmountEditVM;", "()V", "EDIT_MODE_NORMAL", "", "EDIT_MODE_UNMODIFIED", "MAX_EXTRA_INPUT_LENGTH", "getMAX_EXTRA_INPUT_LENGTH", "()I", "setMAX_EXTRA_INPUT_LENGTH", "(I)V", "MODE_BANKMETA", "getMODE_BANKMETA", "setMODE_BANKMETA", "MODE_PIXACOUNT", "getMODE_PIXACOUNT", "setMODE_PIXACOUNT", "MODE_QRCODE", "getMODE_QRCODE", "setMODE_QRCODE", "NFloatParser", "Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "getNFloatParser", "()Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "setNFloatParser", "(Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;)V", "amountInputEt", "Landroidx/appcompat/widget/AppCompatEditText;", "getAmountInputEt", "()Landroidx/appcompat/widget/AppCompatEditText;", "setAmountInputEt", "(Landroidx/appcompat/widget/AppCompatEditText;)V", "balanceTv", "Landroid/widget/TextView;", "getBalanceTv", "()Landroid/widget/TextView;", "setBalanceTv", "(Landroid/widget/TextView;)V", "bankAccountMeta", "Lcom/didi/payment/pix/transfer/vm/model/BankAccountMetaData;", "blockDialog", "Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "getBlockDialog", "()Lcom/didi/global/globaluikit/drawer/LEGODrawer;", "setBlockDialog", "(Lcom/didi/global/globaluikit/drawer/LEGODrawer;)V", "btnLoadingView", "Lcom/airbnb/lottie/LottieAnimationView;", "getBtnLoadingView", "()Lcom/airbnb/lottie/LottieAnimationView;", "setBtnLoadingView", "(Lcom/airbnb/lottie/LottieAnimationView;)V", "cpfNo", "", "defaultTextWatcher", "Landroid/text/TextWatcher;", "exceedTv", "getExceedTv", "setExceedTv", "extraInfoEt", "getExtraInfoEt", "setExtraInfoEt", "headIconImg", "Landroid/widget/ImageView;", "headIconTv", "inputLeftTv", "getInputLeftTv", "setInputLeftTv", "mBottomBtn", "Landroid/view/View;", "getMBottomBtn", "()Landroid/view/View;", "setMBottomBtn", "(Landroid/view/View;)V", "mConfirmDrawer", "Lcom/didi/global/globalgenerickit/drawer/GGKDrawer;", "mEditContentVp", "getMEditContentVp", "setMEditContentVp", "mEditMode", "mPayeeHeadView", "mTransferOption", "Lcom/didi/payment/pix/net/response/PixTransferOption$TransferOptionInfo;", "mUnableAmountBtn", "mUnableAmountContainer", "Landroid/widget/RelativeLayout;", "mUnableAmountLabel", "omegaPageParams", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "payButton", "getPayButton", "setPayButton", "paymentToDescTv", "getPaymentToDescTv", "setPaymentToDescTv", "paymentToTv", "getPaymentToTv", "setPaymentToTv", "pixAccount", "Lcom/didi/payment/pix/net/response/PixKeyVerifyResp$PixAccount;", "pixAccountFromQR", "pixAmountSourcePage", "pixPayeeKey", "pixQRCodeData", "Lcom/didi/payment/commonsdk/net/PixQrCodeQueryResp$QRCodeData;", "productId", "getProductId", "setProductId", "refreshFromTopup", "", "getRefreshFromTopup", "()Z", "setRefreshFromTopup", "(Z)V", "textColorNormal", "getTextColorNormal", "setTextColorNormal", "titlebar", "getTitlebar", "setTitlebar", "tradeType", "getTradeType", "setTradeType", "tvCurrency", "getTvCurrency", "setTvCurrency", "checkNightAndMaxAvailableLimit", "", "value", "", "nightLimit", "nightLimitEffectiveTime", "maxAvailable", "checkSingleLimit", "limit", "checkValue", "riskLimitQuota", "description", "link", "gotoTopupBalance", "handleValueForSecurity", "origin", "initAmountEditText", "initCommonTitlebar", "commonTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initContentView", "root", "initPayeeHeader", "mode", "initViewModels", "invalidatePayButton", "userInput", "transferOption", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackKeyPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "onInflateLayout", "onResume", "onViewCreated", "view", "parserARguments", "payButtonLoading", "loading", "refreshPageUIVisibility", "visibility", "refreshUI", "setOutOfLimitInfo", "textView", "text", "listener", "Lkotlin/Function0;", "omegaAction", "setParentLayout", "showUnableDialogView", "title", "confirmBtn", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTransferAmountEditFragment.kt */
public final class PixTransferAmountEditFragment extends AbsWBaseFragment<AmountEditVM> {

    /* renamed from: A */
    private String f31231A;

    /* renamed from: B */
    private String f31232B;

    /* renamed from: C */
    private View f31233C;

    /* renamed from: D */
    private TextWatcher f31234D = new PixTransferAmountEditFragment$defaultTextWatcher$1(this);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final HashMap<String, Object> f31235a = new HashMap<>();
    public AppCompatEditText amountInputEt;

    /* renamed from: b */
    private String f31236b;
    public TextView balanceTv;
    public LottieAnimationView btnLoadingView;

    /* renamed from: c */
    private TextView f31237c;

    /* renamed from: d */
    private ImageView f31238d;

    /* renamed from: e */
    private RelativeLayout f31239e;
    public TextView exceedTv;
    public AppCompatEditText extraInfoEt;

    /* renamed from: f */
    private TextView f31240f;

    /* renamed from: g */
    private TextView f31241g;

    /* renamed from: h */
    private GGKDrawer f31242h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public PixTransferOption.TransferOptionInfo f31243i;
    public TextView inputLeftTv;

    /* renamed from: j */
    private int f31244j = -16777216;

    /* renamed from: k */
    private boolean f31245k;

    /* renamed from: l */
    private int f31246l = 140;

    /* renamed from: m */
    private NFloatInputHelper f31247m = new NFloatInputHelper();
    public View mBottomBtn;
    public View mEditContentVp;

    /* renamed from: n */
    private int f31248n;

    /* renamed from: o */
    private int f31249o;

    /* renamed from: p */
    private LEGODrawer f31250p;
    public TextView payButton;
    public TextView paymentToDescTv;
    public TextView paymentToTv;

    /* renamed from: q */
    private int f31251q = 1;

    /* renamed from: r */
    private int f31252r = 2;

    /* renamed from: s */
    private int f31253s = 3;

    /* renamed from: t */
    private int f31254t;
    public View titlebar;
    public TextView tvCurrency;

    /* renamed from: u */
    private int f31255u = 1;

    /* renamed from: v */
    private int f31256v = this.f31254t;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public BankAccountMetaData f31257w;

    /* renamed from: x */
    private PixKeyVerifyResp.PixAccount f31258x;

    /* renamed from: y */
    private PixKeyVerifyResp.PixAccount f31259y;

    /* renamed from: z */
    private PixQrCodeQueryResp.QRCodeData f31260z;

    /* renamed from: a */
    private final boolean m21999a(long j, long j2) {
        return j2 < 0 || j <= j2;
    }

    public int onInflateLayout() {
        return R.layout.fragment_transfer_amount_edit;
    }

    public final void refreshPageUIVisibility(int i) {
    }

    public static final /* synthetic */ AmountEditVM access$getVm(PixTransferAmountEditFragment pixTransferAmountEditFragment) {
        return (AmountEditVM) pixTransferAmountEditFragment.getVm();
    }

    public final TextView getExceedTv() {
        TextView textView = this.exceedTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("exceedTv");
        return null;
    }

    public final void setExceedTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.exceedTv = textView;
    }

    public final View getTitlebar() {
        View view = this.titlebar;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titlebar");
        return null;
    }

    public final void setTitlebar(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.titlebar = view;
    }

    public final TextView getPaymentToTv() {
        TextView textView = this.paymentToTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentToTv");
        return null;
    }

    public final void setPaymentToTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.paymentToTv = textView;
    }

    public final TextView getPaymentToDescTv() {
        TextView textView = this.paymentToDescTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("paymentToDescTv");
        return null;
    }

    public final void setPaymentToDescTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.paymentToDescTv = textView;
    }

    public final TextView getBalanceTv() {
        TextView textView = this.balanceTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("balanceTv");
        return null;
    }

    public final void setBalanceTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.balanceTv = textView;
    }

    public final TextView getInputLeftTv() {
        TextView textView = this.inputLeftTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("inputLeftTv");
        return null;
    }

    public final void setInputLeftTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.inputLeftTv = textView;
    }

    public final TextView getTvCurrency() {
        TextView textView = this.tvCurrency;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvCurrency");
        return null;
    }

    public final void setTvCurrency(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.tvCurrency = textView;
    }

    public final AppCompatEditText getAmountInputEt() {
        AppCompatEditText appCompatEditText = this.amountInputEt;
        if (appCompatEditText != null) {
            return appCompatEditText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("amountInputEt");
        return null;
    }

    public final void setAmountInputEt(AppCompatEditText appCompatEditText) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "<set-?>");
        this.amountInputEt = appCompatEditText;
    }

    public final AppCompatEditText getExtraInfoEt() {
        AppCompatEditText appCompatEditText = this.extraInfoEt;
        if (appCompatEditText != null) {
            return appCompatEditText;
        }
        Intrinsics.throwUninitializedPropertyAccessException("extraInfoEt");
        return null;
    }

    public final void setExtraInfoEt(AppCompatEditText appCompatEditText) {
        Intrinsics.checkNotNullParameter(appCompatEditText, "<set-?>");
        this.extraInfoEt = appCompatEditText;
    }

    public final TextView getPayButton() {
        TextView textView = this.payButton;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("payButton");
        return null;
    }

    public final void setPayButton(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.payButton = textView;
    }

    public final LottieAnimationView getBtnLoadingView() {
        LottieAnimationView lottieAnimationView = this.btnLoadingView;
        if (lottieAnimationView != null) {
            return lottieAnimationView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnLoadingView");
        return null;
    }

    public final void setBtnLoadingView(LottieAnimationView lottieAnimationView) {
        Intrinsics.checkNotNullParameter(lottieAnimationView, "<set-?>");
        this.btnLoadingView = lottieAnimationView;
    }

    public final int getTextColorNormal() {
        return this.f31244j;
    }

    public final void setTextColorNormal(int i) {
        this.f31244j = i;
    }

    public final boolean getRefreshFromTopup() {
        return this.f31245k;
    }

    public final void setRefreshFromTopup(boolean z) {
        this.f31245k = z;
    }

    public final int getMAX_EXTRA_INPUT_LENGTH() {
        return this.f31246l;
    }

    public final void setMAX_EXTRA_INPUT_LENGTH(int i) {
        this.f31246l = i;
    }

    public final NFloatInputHelper getNFloatParser() {
        return this.f31247m;
    }

    public final void setNFloatParser(NFloatInputHelper nFloatInputHelper) {
        Intrinsics.checkNotNullParameter(nFloatInputHelper, "<set-?>");
        this.f31247m = nFloatInputHelper;
    }

    public final int getProductId() {
        return this.f31248n;
    }

    public final void setProductId(int i) {
        this.f31248n = i;
    }

    public final int getTradeType() {
        return this.f31249o;
    }

    public final void setTradeType(int i) {
        this.f31249o = i;
    }

    public final LEGODrawer getBlockDialog() {
        return this.f31250p;
    }

    public final void setBlockDialog(LEGODrawer lEGODrawer) {
        this.f31250p = lEGODrawer;
    }

    public final int getMODE_BANKMETA() {
        return this.f31251q;
    }

    public final void setMODE_BANKMETA(int i) {
        this.f31251q = i;
    }

    public final int getMODE_PIXACOUNT() {
        return this.f31252r;
    }

    public final void setMODE_PIXACOUNT(int i) {
        this.f31252r = i;
    }

    public final int getMODE_QRCODE() {
        return this.f31253s;
    }

    public final void setMODE_QRCODE(int i) {
        this.f31253s = i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m21980a();
    }

    /* renamed from: a */
    private final void m21980a() {
        Integer amount;
        Serializable serializable;
        String str;
        Serializable serializable2;
        String str2;
        Serializable serializable3;
        String str3;
        Bundle arguments = getArguments();
        if (arguments != null) {
            Float f = null;
            if (arguments.containsKey("bank_metadata") && (serializable3 = arguments.getSerializable("bank_metadata")) != null) {
                BankAccountMetaData bankAccountMetaData = (BankAccountMetaData) serializable3;
                this.f31257w = bankAccountMetaData;
                if (bankAccountMetaData == null) {
                    str3 = null;
                } else {
                    str3 = bankAccountMetaData.getCpf();
                }
                this.f31232B = str3;
            }
            if (arguments.containsKey("pix_account") && (serializable2 = arguments.getSerializable("pix_account")) != null) {
                PixKeyVerifyResp.PixAccount pixAccount = (PixKeyVerifyResp.PixAccount) serializable2;
                this.f31258x = pixAccount;
                if (pixAccount == null) {
                    str2 = null;
                } else {
                    str2 = pixAccount.getKey();
                }
                this.f31231A = str2;
                PixKeyVerifyResp.PixAccount pixAccount2 = this.f31258x;
                this.f31232B = pixAccount2 == null ? null : pixAccount2.getCpf();
            }
            if (arguments.containsKey("detected_qrcode") && (serializable = arguments.getSerializable("detected_qrcode")) != null) {
                PixQrCodeQueryResp.QRCodeData qRCodeData = (PixQrCodeQueryResp.QRCodeData) serializable;
                this.f31260z = qRCodeData;
                if (qRCodeData == null) {
                    str = null;
                } else {
                    str = qRCodeData.getKey();
                }
                this.f31231A = str;
            }
            HashMap<String, Object> hashMap = this.f31235a;
            if (hashMap != null) {
                hashMap.put("pix_payee_key", String.valueOf(this.f31231A));
            }
            HashMap<String, Object> hashMap2 = this.f31235a;
            if (hashMap2 != null) {
                hashMap2.put("cpf_number", String.valueOf(this.f31232B));
            }
            String string = arguments.getString("source_page");
            this.f31236b = string;
            HashMap<String, Object> hashMap3 = this.f31235a;
            if (hashMap3 != null) {
                hashMap3.put("pix_amount_source_page", String.valueOf(string));
            }
            PixQrCodeQueryResp.QRCodeData qRCodeData2 = this.f31260z;
            if (!(qRCodeData2 == null || (amount = qRCodeData2.getAmount()) == null)) {
                f = Float.valueOf((float) amount.intValue());
            }
            int i = f != null ? 1 : 0;
            HashMap<String, Object> hashMap4 = this.f31235a;
            if (hashMap4 != null) {
                hashMap4.put("pre_filled_amount", Integer.valueOf(i));
            }
        }
    }

    public void initViewModels() {
        String key;
        ViewModel viewModel = new ViewModelProvider(this).get(AmountEditVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…AmountEditVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        ((AmountEditVM) getVm()).getTransferOption().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m21990a(PixTransferAmountEditFragment.this, (PixTransferOption.TransferOptionInfo) obj);
            }
        });
        ((AmountEditVM) getVm()).getErrCreateOrder().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m21987a(PixTransferAmountEditFragment.this, (WBaseResp) obj);
            }
        });
        ((AmountEditVM) getVm()).getNightlyLimitVo().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m21991a(PixTransferAmountEditFragment.this, (GetNightlyLimitResp.NightlyLimitVo) obj);
            }
        });
        ((AmountEditVM) getVm()).getPwdData().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m21992a(PixTransferAmountEditFragment.this, (PasswordDataVo) obj);
            }
        });
        ((AmountEditVM) getVm()).getOrderDetailLD().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m21989a(PixTransferAmountEditFragment.this, (PixOrderDetailResp.OrderDetail) obj);
            }
        });
        ((AmountEditVM) getVm()).getOrderDetailLooping().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m21993a(PixTransferAmountEditFragment.this, (Boolean) obj);
            }
        });
        ((AmountEditVM) getVm()).getTransferOption().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m22003b(PixTransferAmountEditFragment.this, (PixTransferOption.TransferOptionInfo) obj);
            }
        });
        ((AmountEditVM) getVm()).getPixAccountQueryByQr().observe(getViewLifecycleOwner(), new Observer() {
            public final void onChanged(Object obj) {
                PixTransferAmountEditFragment.m21988a(PixTransferAmountEditFragment.this, (PixKeyVerifyResp.PixAccount) obj);
            }
        });
        PixQrCodeQueryResp.QRCodeData qRCodeData = this.f31260z;
        if (qRCodeData != null && (key = qRCodeData.getKey()) != null) {
            ((AmountEditVM) getVm()).queryPixKeyDetail(key);
            ((AmountEditVM) getVm()).triggerRealtimePush(key, 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21990a(PixTransferAmountEditFragment pixTransferAmountEditFragment, PixTransferOption.TransferOptionInfo transferOptionInfo) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (transferOptionInfo != null) {
            pixTransferAmountEditFragment.f31243i = transferOptionInfo;
            pixTransferAmountEditFragment.m21994a(String.valueOf(pixTransferAmountEditFragment.getAmountInputEt().getText()), transferOptionInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21987a(PixTransferAmountEditFragment pixTransferAmountEditFragment, WBaseResp wBaseResp) {
        FragmentActivity activity;
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (wBaseResp != null && (activity = pixTransferAmountEditFragment.getActivity()) != null) {
            WalletToastNew.showFailedMsg(activity, wBaseResp.errmsg);
            pixTransferAmountEditFragment.m21998a(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21991a(PixTransferAmountEditFragment pixTransferAmountEditFragment, GetNightlyLimitResp.NightlyLimitVo nightlyLimitVo) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (nightlyLimitVo != null) {
            Editable text = pixTransferAmountEditFragment.getAmountInputEt().getText();
            String obj = text == null ? null : text.toString();
            CharSequence charSequence = obj;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                pixTransferAmountEditFragment.m21994a(obj, ((AmountEditVM) pixTransferAmountEditFragment.getVm()).getTransferOption().getValue());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21992a(PixTransferAmountEditFragment pixTransferAmountEditFragment, PasswordDataVo passwordDataVo) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        pixTransferAmountEditFragment.m21998a(false);
        if (passwordDataVo.getType() == 0) {
            if (passwordDataVo.getTitle() != null && passwordDataVo.getContent() != null && passwordDataVo.getConfirmButton() != null && passwordDataVo.getCancelButton() != null) {
                Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.m42317to("pub_page", "cashier"), TuplesKt.m42317to(GlobalCashierBizPresenter.OMEGA_ATTR_PUB_SOURCE, PasswordScene.PIX_IN.name()), TuplesKt.m42317to("pub_biz", "fintech"));
                FinOmegaSDK.trackEvent("ibt_password_paying_bottom_popoup_sw", MapsKt.toMap(mutableMapOf));
                BackInfoHintDialogFragment.show(pixTransferAmountEditFragment.requireActivity(), passwordDataVo.getTitle(), passwordDataVo.getContent(), passwordDataVo.getCancelButton(), passwordDataVo.getConfirmButton(), new View.OnClickListener(mutableMapOf) {
                    public final /* synthetic */ Map f$0;

                    {
                        this.f$0 = r1;
                    }

                    public final void onClick(View view) {
                        PixTransferAmountEditFragment.m21996a(this.f$0, view);
                    }
                }, new View.OnClickListener(mutableMapOf, pixTransferAmountEditFragment, passwordDataVo) {
                    public final /* synthetic */ Map f$0;
                    public final /* synthetic */ PixTransferAmountEditFragment f$1;
                    public final /* synthetic */ PasswordDataVo f$2;

                    {
                        this.f$0 = r1;
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        PixTransferAmountEditFragment.m21997a(this.f$0, this.f$1, this.f$2, view);
                    }
                });
            }
        } else if (passwordDataVo.getType() == 1) {
            OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
            String paySessionId = passwordDataVo.getPaySessionId();
            if (openCertificationListener != null && paySessionId != null) {
                PaySecure paySecure = PaySecure.INSTANCE;
                String name = PasswordScene.CHECK_OUT_WALLET.name();
                StringBuilder sb = new StringBuilder();
                sb.append(pixTransferAmountEditFragment.getTvCurrency().getText());
                sb.append(pixTransferAmountEditFragment.getAmountInputEt().getText());
                paySecure.verifyPayPassword(name, paySessionId, sb.toString(), new PixTransferAmountEditFragment$initViewModels$4$3(pixTransferAmountEditFragment, passwordDataVo), openCertificationListener);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21996a(Map map, View view) {
        Intrinsics.checkNotNullParameter(map, "$map");
        map.put("pub_button", LoginOmegaUtil.NO_EMAIL);
        FinOmegaSDK.trackEvent("ibt_password_paying_bottom_popoup_yes_ck", MapsKt.toMap(map));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21997a(Map map, PixTransferAmountEditFragment pixTransferAmountEditFragment, PasswordDataVo passwordDataVo, View view) {
        Intrinsics.checkNotNullParameter(map, "$map");
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        map.put("pub_button", "yes");
        FinOmegaSDK.trackEvent("ibt_password_paying_bottom_popoup_yes_ck", MapsKt.toMap(map));
        OpenCertificationListener openCertificationListener = (OpenCertificationListener) ServiceLoaderUtil.getInstance().load(OpenCertificationListener.class);
        if (openCertificationListener != null) {
            PaySecure.INSTANCE.createPayPassword(PasswordScene.PIX_IN.name(), openCertificationListener, new PixTransferAmountEditFragment$initViewModels$4$2$1(pixTransferAmountEditFragment, passwordDataVo));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21989a(PixTransferAmountEditFragment pixTransferAmountEditFragment, PixOrderDetailResp.OrderDetail orderDetail) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (orderDetail != null) {
            if (orderDetail.isDialogBlock()) {
                FragmentActivity requireActivity = pixTransferAmountEditFragment.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                NLEGODialogBuilder nLEGODialogBuilder = new NLEGODialogBuilder(requireActivity);
                PixOrderDetailResp.DialogInfo dialog = orderDetail.getDialog();
                String title = dialog == null ? null : dialog.getTitle();
                Intrinsics.checkNotNull(title);
                NLEGODialogBuilder title2 = nLEGODialogBuilder.title(title);
                PixOrderDetailResp.DialogInfo dialog2 = orderDetail.getDialog();
                Intrinsics.checkNotNull(dialog2);
                NLEGODialogBuilder confirmAction = title2.confirmAction(dialog2.getConsiderBtn(), new PixTransferAmountEditFragment$initViewModels$5$1$dialogBuilder$1(pixTransferAmountEditFragment));
                PixOrderDetailResp.DialogInfo dialog3 = orderDetail.getDialog();
                if (dialog3 != null) {
                    if (!TextUtil.isEmpty(dialog3.getDesc())) {
                        confirmAction.subTitle(dialog3.getDesc());
                    }
                    if (!TextUtil.isEmpty(dialog3.getIgnoreBtn())) {
                        confirmAction.negativeAction(dialog3.getIgnoreBtn(), new PixTransferAmountEditFragment$initViewModels$5$1$1$1(pixTransferAmountEditFragment));
                    }
                }
                pixTransferAmountEditFragment.setBlockDialog(NLEGODialogBuilder.build$default(confirmAction, 0, 1, (Object) null).show());
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("order_id", orderDetail.getOrderId());
            bundle.putSerializable("order_detail", orderDetail);
            ((Request) DRouter.build(PixRouter.build("/pix_order_detail")).putExtras(bundle)).start(pixTransferAmountEditFragment.getActivity());
            EventBus.getDefault().post(new WalletRefreshDataEvent());
            EventBus.getDefault().post(new BackStackEvent());
            FragmentActivity activity = pixTransferAmountEditFragment.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21993a(PixTransferAmountEditFragment pixTransferAmountEditFragment, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        Intrinsics.checkNotNullExpressionValue(bool, "it");
        pixTransferAmountEditFragment.m21998a(bool.booleanValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m22003b(PixTransferAmountEditFragment pixTransferAmountEditFragment, PixTransferOption.TransferOptionInfo transferOptionInfo) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        pixTransferAmountEditFragment.m22004c();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21988a(PixTransferAmountEditFragment pixTransferAmountEditFragment, PixKeyVerifyResp.PixAccount pixAccount) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        pixTransferAmountEditFragment.f31259y = pixAccount;
        pixTransferAmountEditFragment.m21981a(pixTransferAmountEditFragment.getMODE_PIXACOUNT());
        pixTransferAmountEditFragment.m22004c();
    }

    /* renamed from: a */
    private final void m21998a(boolean z) {
        if (z) {
            getPayButton().setText("");
            getBtnLoadingView().setRepeatCount(-1);
            getBtnLoadingView().setVisibility(0);
            getBtnLoadingView().playAnimation();
            return;
        }
        getPayButton().setText(getString(R.string.GRider_payment_Continue_BofS));
        getBtnLoadingView().setVisibility(8);
        if (getBtnLoadingView().isAnimating()) {
            getBtnLoadingView().cancelAnimation();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_amount_sw", this.f31235a);
        ((AmountEditVM) getVm()).loadData();
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        commonTitleBar.setTitle(getString(R.string.CS_payment_PIX_Transfer_Onrd));
        View findViewById = commonTitleBar.findViewById(R.id.title_bar_layout_above);
        if (findViewById != null) {
            findViewById.setBackgroundColor(0);
        }
        commonTitleBar.setLeftBackListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixTransferAmountEditFragment.m21986a(PixTransferAmountEditFragment.this, view);
            }
        });
        super.initCommonTitlebar(commonTitleBar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21986a(PixTransferAmountEditFragment pixTransferAmountEditFragment, View view) {
        String key;
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        PixQrCodeQueryResp.QRCodeData qRCodeData = pixTransferAmountEditFragment.f31260z;
        if (!(qRCodeData == null || (key = qRCodeData.getKey()) == null)) {
            ((AmountEditVM) pixTransferAmountEditFragment.getVm()).triggerRealtimePush(key, 2);
        }
        pixTransferAmountEditFragment.backToPrePage();
    }

    public final View getMEditContentVp() {
        View view = this.mEditContentVp;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mEditContentVp");
        return null;
    }

    public final void setMEditContentVp(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mEditContentVp = view;
    }

    public final View getMBottomBtn() {
        View view = this.mBottomBtn;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mBottomBtn");
        return null;
    }

    public final void setMBottomBtn(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mBottomBtn = view;
    }

    public void initContentView(View view) {
        int i;
        Intrinsics.checkNotNullParameter(view, "root");
        super.initContentView(view);
        View findViewById = view.findViewById(R.id.transfer_amount_edit_titlebar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.t…fer_amount_edit_titlebar)");
        setTitlebar(findViewById);
        View findViewById2 = view.findViewById(R.id.payee_header_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById<View>(R.id.payee_header_view)");
        this.f31233C = findViewById2;
        View findViewById3 = view.findViewById(R.id.pix_amount_edit_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById<View>(….pix_amount_edit_content)");
        setMEditContentVp(findViewById3);
        ViewParent parent = getMEditContentVp().getParent();
        if (parent != null) {
            ((ViewGroup) parent).setOnClickListener(C10857x728e150b.INSTANCE);
        }
        View findViewById4 = view.findViewById(R.id.pix_amount_edit_bottom_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById<View>(…x_amount_edit_bottom_btn)");
        setMBottomBtn(findViewById4);
        View findViewById5 = view.findViewById(R.id.payment_to_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.payment_to_tv)");
        setPaymentToTv((TextView) findViewById5);
        View findViewById6 = view.findViewById(R.id.payment_to_desc_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.payment_to_desc_tv)");
        setPaymentToDescTv((TextView) findViewById6);
        this.f31238d = (ImageView) view.findViewById(R.id.payee_head_icon_img);
        this.f31237c = (TextView) view.findViewById(R.id.payee_head_icon_tv);
        View findViewById7 = view.findViewById(R.id.current_balance_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "root.findViewById(R.id.current_balance_tv)");
        setBalanceTv((TextView) findViewById7);
        View findViewById8 = view.findViewById(R.id.tv_currency);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "root.findViewById(R.id.tv_currency)");
        setTvCurrency((TextView) findViewById8);
        View findViewById9 = view.findViewById(R.id.pix_transfer_amount_et);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "root.findViewById(R.id.pix_transfer_amount_et)");
        setAmountInputEt((AppCompatEditText) findViewById9);
        View findViewById10 = view.findViewById(R.id.confirm_button_animation_view);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "root.findViewById(R.id.c…rm_button_animation_view)");
        setBtnLoadingView((LottieAnimationView) findViewById10);
        View findViewById11 = view.findViewById(R.id.transfer_amount_confirm_btn_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "root.findViewById(R.id.t…er_amount_confirm_btn_tv)");
        setPayButton((TextView) findViewById11);
        getPayButton().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixTransferAmountEditFragment.m22002b(PixTransferAmountEditFragment.this, view);
            }
        });
        getPayButton().setEnabled(false);
        getAmountInputEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return PixTransferAmountEditFragment.m22000a(PixTransferAmountEditFragment.this, textView, i, keyEvent);
            }
        });
        View findViewById12 = view.findViewById(R.id.append_info_et);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "root.findViewById(R.id.append_info_et)");
        setExtraInfoEt((AppCompatEditText) findViewById12);
        getExtraInfoEt().setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(this.f31246l)});
        View findViewById13 = view.findViewById(R.id.input_left_number_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById13, "root.findViewById(R.id.input_left_number_tv)");
        setInputLeftTv((TextView) findViewById13);
        getInputLeftTv().setText(Intrinsics.stringPlus("0/", Integer.valueOf(this.f31246l)));
        View findViewById14 = view.findViewById(R.id.input_amount_exceed_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById14, "root.findViewById(R.id.input_amount_exceed_tv)");
        setExceedTv((TextView) findViewById14);
        IDiff diffValue = DiffUtil.INSTANCE.getDiffValue(DiffConstants.DIFF_WALLET_TRANSFER_AMOUNT_TIP);
        TextView textView = null;
        ITransferAmountTip iTransferAmountTip = diffValue instanceof ITransferAmountTip ? (ITransferAmountTip) diffValue : null;
        if (iTransferAmountTip != null) {
            getExceedTv().setText(iTransferAmountTip.getWarningMsg(getContext()));
            getExceedTv().setEnabled(iTransferAmountTip.isEnableClick());
        }
        m22001b();
        if (this.f31257w != null) {
            i = this.f31251q;
        } else {
            i = this.f31258x != null ? this.f31252r : this.f31253s;
        }
        m21981a(i);
        View findViewById15 = view.findViewById(R.id.unable_amount_container);
        Intrinsics.checkNotNullExpressionValue(findViewById15, "root.findViewById(R.id.unable_amount_container)");
        this.f31239e = (RelativeLayout) findViewById15;
        View findViewById16 = view.findViewById(R.id.unable_amount_label);
        Intrinsics.checkNotNullExpressionValue(findViewById16, "root.findViewById(R.id.unable_amount_label)");
        this.f31240f = (TextView) findViewById16;
        View findViewById17 = view.findViewById(R.id.unable_amount_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById17, "root.findViewById(R.id.unable_amount_btn)");
        TextView textView2 = (TextView) findViewById17;
        this.f31241g = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUnableAmountBtn");
        } else {
            textView = textView2;
        }
        textView.setOnClickListener(new PixTransferAmountEditFragment$initContentView$5(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21984a(View view) {
        SystemUtils.log(3, "", "page level click event consume...", (Throwable) null, "com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment", 430);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m22002b(PixTransferAmountEditFragment pixTransferAmountEditFragment, View view) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_amount_ck", pixTransferAmountEditFragment.f31235a);
        NFloatInputHelper nFloatParser = pixTransferAmountEditFragment.getNFloatParser();
        Editable text = pixTransferAmountEditFragment.getAmountInputEt().getText();
        String str = null;
        int dollarToCent = MathUtil.dollarToCent(nFloatParser.parseFloatValue(text == null ? null : text.toString()));
        BankAccountMetaData bankAccountMetaData = pixTransferAmountEditFragment.f31257w;
        if (bankAccountMetaData != null) {
            JSONObject bizContent = bankAccountMetaData.toBizContent();
            bizContent.put("tradeType", 3);
            bizContent.put("amount", dollarToCent);
            Editable text2 = pixTransferAmountEditFragment.getExtraInfoEt().getText();
            bizContent.put("note", text2 == null ? null : text2.toString());
            String jSONObject = bizContent.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "bizContentJson.toString()");
            AmountEditVM.createPixTransferOrder$default((AmountEditVM) pixTransferAmountEditFragment.getVm(), 99996, jSONObject, (String) null, 4, (Object) null);
        }
        PixKeyVerifyResp.PixAccount pixAccount = pixTransferAmountEditFragment.f31258x;
        if (pixAccount != null) {
            JSONObject bizContent2 = pixAccount.toBizContent();
            bizContent2.put("tradeType", 1);
            bizContent2.put("amount", dollarToCent);
            Editable text3 = pixTransferAmountEditFragment.getExtraInfoEt().getText();
            bizContent2.put("note", text3 == null ? null : text3.toString());
            String jSONObject2 = bizContent2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "bizContentJson.toString()");
            AmountEditVM.createPixTransferOrder$default((AmountEditVM) pixTransferAmountEditFragment.getVm(), 99996, jSONObject2, (String) null, 4, (Object) null);
        }
        PixQrCodeQueryResp.QRCodeData qRCodeData = pixTransferAmountEditFragment.f31260z;
        if (qRCodeData != null) {
            JSONObject bizContent3 = qRCodeData.toBizContent();
            PixKeyVerifyResp.PixAccount pixAccount2 = pixTransferAmountEditFragment.f31259y;
            if (pixAccount2 != null) {
                bizContent3.put("toIconUrl", pixAccount2.getIcon());
            }
            bizContent3.put("tradeType", 2);
            bizContent3.put("amount", dollarToCent);
            Editable text4 = pixTransferAmountEditFragment.getExtraInfoEt().getText();
            if (text4 != null) {
                str = text4.toString();
            }
            bizContent3.put("note", str);
            String jSONObject3 = bizContent3.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject3, "bizContentJson.toString()");
            AmountEditVM.createPixTransferOrder$default((AmountEditVM) pixTransferAmountEditFragment.getVm(), 99996, jSONObject3, (String) null, 4, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final boolean m22000a(PixTransferAmountEditFragment pixTransferAmountEditFragment, TextView textView, int i, KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        if (5 == i) {
            TextView payButton2 = pixTransferAmountEditFragment.getPayButton();
            if ((payButton2 == null ? null : Boolean.valueOf(payButton2.isEnabled())).booleanValue()) {
                TextView payButton3 = pixTransferAmountEditFragment.getPayButton();
                if (payButton3 != null) {
                    payButton3.performClick();
                }
                InputTools.hideKeyboard(textView);
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21995a(String str, String str2) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.item_title_layout, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…itle_layout, null, false)");
        TextView textView = (TextView) inflate.findViewById(R.id.drawer_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.drawer_btn_ok);
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixTransferAmountEditFragment.m22005c(PixTransferAmountEditFragment.this, view);
            }
        });
        textView.setText(str);
        Intrinsics.checkNotNullExpressionValue(textView, "contentView");
        setParentLayout(textView);
        Intrinsics.checkNotNullExpressionValue(textView2, "okBtn");
        setParentLayout(textView2);
        this.f31242h = GGKUICreatorWithThemeCheck.showDrawerModel(getActivity(), new GGKDrawerModel0().setExtendedView(inflate).setClickOutsideCanCancel(false));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m22005c(PixTransferAmountEditFragment pixTransferAmountEditFragment, View view) {
        Intrinsics.checkNotNullParameter(pixTransferAmountEditFragment, "this$0");
        GGKDrawer gGKDrawer = pixTransferAmountEditFragment.f31242h;
        if (gGKDrawer != null) {
            gGKDrawer.dismiss();
        }
    }

    public final void setParentLayout(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.leftMargin = UiUtils.dip2px(getContext(), 18.0f);
            marginLayoutParams.rightMargin = UiUtils.dip2px(getContext(), 18.0f);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    /* renamed from: a */
    private final String m21979a(String str) {
        if ((StringsKt.startsWith$default(str, "*", false, 2, (Object) null) && StringsKt.endsWith$default(str, "*", false, 2, (Object) null)) || str.length() <= 5) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("***");
        int length = str.length() - 2;
        if (str != null) {
            String substring = str.substring(3, length);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append("**");
            return sb.toString();
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    /* renamed from: a */
    private final void m21981a(int i) {
        PixQrCodeQueryResp.QRCodeData qRCodeData;
        Integer amount;
        int intValue;
        String str;
        if (i == this.f31251q) {
            BankAccountMetaData bankAccountMetaData = this.f31257w;
            if (bankAccountMetaData != null) {
                TextView paymentToTv2 = getPaymentToTv();
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = getString(R.string.GRider_payment_Transfer_to_gulk);
                Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRide…payment_Transfer_to_gulk)");
                String format = String.format(string, Arrays.copyOf(new Object[]{bankAccountMetaData.getPayeeName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                paymentToTv2.setText(format);
                CharSequence cpf4Display = bankAccountMetaData.getCpf4Display();
                String cpf = cpf4Display == null || cpf4Display.length() == 0 ? bankAccountMetaData.getCpf() : bankAccountMetaData.getCpf4Display();
                TextView paymentToDescTv2 = getPaymentToDescTv();
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String string2 = getString(R.string.GRider_payment__cpf_sBCN);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.GRider_payment__cpf_sBCN)");
                String format2 = String.format(string2, Arrays.copyOf(new Object[]{m21979a(cpf), bankAccountMetaData.getPspName()}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                paymentToDescTv2.setText(format2);
                if (!TextUtil.isEmpty(bankAccountMetaData.getPayeeName())) {
                    ImageView imageView = this.f31238d;
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    TextView textView = this.f31237c;
                    if (textView != null) {
                        textView.setVisibility(0);
                    }
                    TextView textView2 = this.f31237c;
                    if (textView2 != null) {
                        String payeeName = bankAccountMetaData.getPayeeName();
                        if (payeeName != null) {
                            String substring = payeeName.substring(0, 1);
                            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            textView2.setText(substring);
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    return;
                }
                ImageView imageView2 = this.f31238d;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
            }
        } else if (i == this.f31252r) {
            PixKeyVerifyResp.PixAccount pixAccount = this.f31258x;
            if (pixAccount == null) {
                pixAccount = this.f31259y;
            }
            if (pixAccount != null) {
                TextView paymentToTv3 = getPaymentToTv();
                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                String string3 = getString(R.string.GRider_payment_Transfer_to_gulk);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(R.string.GRide…payment_Transfer_to_gulk)");
                String format3 = String.format(string3, Arrays.copyOf(new Object[]{pixAccount.getName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
                paymentToTv3.setText(format3);
                PixKeyVerifyResp.PspInfo psp = pixAccount.getPsp();
                String name = !TextUtil.isEmpty(psp.getName()) ? psp.getName() : "";
                TextView paymentToDescTv3 = getPaymentToDescTv();
                StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                String string4 = getString(R.string.GRider_payment__cpf_sBCN);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(R.string.GRider_payment__cpf_sBCN)");
                Object[] objArr = new Object[2];
                String cpf2 = pixAccount.getCpf();
                String str2 = null;
                if (cpf2 == null) {
                    str = null;
                } else {
                    str = m21979a(cpf2);
                }
                objArr[0] = str;
                objArr[1] = name;
                String format4 = String.format(string4, Arrays.copyOf(objArr, 2));
                Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(format, *args)");
                paymentToDescTv3.setText(format4);
                if (!TextUtil.isEmpty(pixAccount.getIcon())) {
                    ImageView imageView3 = this.f31238d;
                    if (imageView3 != null) {
                        imageView3.setVisibility(0);
                    }
                    TextView textView3 = this.f31237c;
                    if (textView3 != null) {
                        textView3.setVisibility(4);
                    }
                    GlideUtils.loadCircleImageWithDefaultImg(getContext(), Uri.parse(pixAccount.getIcon()), R.drawable.pay_icon_contacts, this.f31238d);
                    return;
                }
                ImageView imageView4 = this.f31238d;
                if (imageView4 != null) {
                    imageView4.setVisibility(4);
                }
                TextView textView4 = this.f31237c;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                TextView textView5 = this.f31237c;
                if (textView5 != null) {
                    String name2 = pixAccount.getName();
                    if (name2 != null) {
                        str2 = name2.substring(0, 1);
                        Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    textView5.setText(str2);
                }
            }
        } else if (i == this.f31253s && (qRCodeData = this.f31260z) != null && (amount = qRCodeData.getAmount()) != null && (intValue = amount.intValue()) >= 0) {
            String centToDollar = MathUtil.centToDollar(Double.valueOf((double) intValue));
            getAmountInputEt().removeTextChangedListener(this.f31234D);
            getAmountInputEt().setFilters((InputFilter[]) new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(10)});
            getAmountInputEt().setText(centToDollar);
            getAmountInputEt().setEnabled(false);
            this.f31256v = this.f31255u;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0073, code lost:
        r9 = r3.limitRiskDetail;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0080 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a7 A[ADDED_TO_REGION] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m21994a(java.lang.String r17, com.didi.payment.pix.net.response.PixTransferOption.TransferOptionInfo r18) {
        /*
            r16 = this;
            r12 = r16
            android.content.Context r0 = r16.getContext()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            com.didi.payment.pix.net.response.PixKeyVerifyResp$PixAccount r0 = r12.f31258x
            r1 = 0
            if (r0 == 0) goto L_0x001e
            if (r0 != 0) goto L_0x0012
        L_0x0010:
            r0 = 0
            goto L_0x003c
        L_0x0012:
            java.lang.Boolean r0 = r0.isSameCpf()
            if (r0 != 0) goto L_0x0019
            goto L_0x0010
        L_0x0019:
            boolean r0 = r0.booleanValue()
            goto L_0x003c
        L_0x001e:
            com.didi.payment.pix.net.response.PixKeyVerifyResp$PixAccount r0 = r12.f31259y
            if (r0 == 0) goto L_0x0031
            if (r0 != 0) goto L_0x0025
            goto L_0x0010
        L_0x0025:
            java.lang.Boolean r0 = r0.isSameCpf()
            if (r0 != 0) goto L_0x002c
            goto L_0x0010
        L_0x002c:
            boolean r0 = r0.booleanValue()
            goto L_0x003c
        L_0x0031:
            com.didi.payment.pix.transfer.vm.model.BankAccountMetaData r0 = r12.f31257w
            if (r0 == 0) goto L_0x0010
            if (r0 != 0) goto L_0x0038
            goto L_0x0010
        L_0x0038:
            boolean r0 = r0.isSameCpf()
        L_0x003c:
            com.didi.payment.commonsdk.ui.helper.NFloatInputHelper r2 = r12.f31247m
            r3 = r17
            float r2 = r2.parseFloatValue(r3)
            int r2 = com.didi.payment.base.utils.MathUtil.dollarToCent((float) r2)
            com.didi.payment.commonsdk.ui.WBaseViewModel r3 = r16.getVm()
            com.didi.payment.pix.transfer.vm.model.AmountEditVM r3 = (com.didi.payment.pix.transfer.p141vm.model.AmountEditVM) r3
            androidx.lifecycle.MutableLiveData r3 = r3.getNightlyLimitVo()
            java.lang.Object r3 = r3.getValue()
            com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp$NightlyLimitVo r3 = (com.didi.payment.wallet.global.model.resp.GetNightlyLimitResp.NightlyLimitVo) r3
            r4 = -1
            if (r0 == 0) goto L_0x005e
        L_0x005c:
            r6 = r4
            goto L_0x0068
        L_0x005e:
            if (r3 != 0) goto L_0x0061
            goto L_0x005c
        L_0x0061:
            com.didi.payment.wallet.global.model.resp.LimitRiskDetailVo r6 = r3.limitRiskDetail
            if (r6 != 0) goto L_0x0066
            goto L_0x005c
        L_0x0066:
            long r6 = r6.riskLimitQuota
        L_0x0068:
            r8 = 0
            if (r0 == 0) goto L_0x006f
            r9 = r8
            java.lang.String r9 = (java.lang.String) r9
            goto L_0x007a
        L_0x006f:
            if (r3 != 0) goto L_0x0073
        L_0x0071:
            r9 = r8
            goto L_0x007a
        L_0x0073:
            com.didi.payment.wallet.global.model.resp.LimitRiskDetailVo r9 = r3.limitRiskDetail
            if (r9 != 0) goto L_0x0078
            goto L_0x0071
        L_0x0078:
            java.lang.String r9 = r9.description
        L_0x007a:
            if (r0 == 0) goto L_0x0080
            java.lang.String r8 = (java.lang.String) r8
        L_0x007e:
            r10 = r8
            goto L_0x008b
        L_0x0080:
            if (r3 != 0) goto L_0x0083
        L_0x0082:
            goto L_0x007e
        L_0x0083:
            com.didi.payment.wallet.global.model.resp.LimitRiskDetailVo r10 = r3.limitRiskDetail
            if (r10 != 0) goto L_0x0088
            goto L_0x0082
        L_0x0088:
            java.lang.String r8 = r10.link
            goto L_0x007e
        L_0x008b:
            if (r18 != 0) goto L_0x008f
            r8 = -1
            goto L_0x0093
        L_0x008f:
            int r8 = r18.getUserAvailableAmount()
        L_0x0093:
            r11 = 1
            if (r0 != 0) goto L_0x00a3
            if (r3 != 0) goto L_0x009a
        L_0x0098:
            r13 = 0
            goto L_0x009f
        L_0x009a:
            boolean r13 = r3.isHit
            if (r13 != r11) goto L_0x0098
            r13 = 1
        L_0x009f:
            if (r13 == 0) goto L_0x00a3
            long r4 = r3.remainingLimit
        L_0x00a3:
            java.lang.String r13 = ""
            if (r0 != 0) goto L_0x00b6
            if (r3 != 0) goto L_0x00aa
            goto L_0x00af
        L_0x00aa:
            boolean r0 = r3.isHit
            if (r0 != r11) goto L_0x00af
            r1 = 1
        L_0x00af:
            if (r1 == 0) goto L_0x00b6
            java.lang.String r0 = r3.effectiveTime
            if (r0 == 0) goto L_0x00b6
            r13 = r0
        L_0x00b6:
            long r1 = (long) r2
            long r14 = (long) r8
            r0 = r16
            r3 = r4
            r5 = r13
            r8 = r9
            r9 = r10
            r10 = r14
            r0.m21983a(r1, r3, r5, r6, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment.m21994a(java.lang.String, com.didi.payment.pix.net.response.PixTransferOption$TransferOptionInfo):void");
    }

    /* renamed from: b */
    private final void m22001b() {
        getAmountInputEt().addTextChangedListener(this.f31234D);
        getAmountInputEt().setFilters(new InputFilter[]{new NFloatInputHelper.NumberDecimalInputFilter(2, this.f31247m.decimalSeperatorBySys), new InputFilter.LengthFilter(10)});
        getExtraInfoEt().addTextChangedListener(new PixTransferAmountEditFragment$initAmountEditText$1(this));
    }

    /* renamed from: a */
    private final void m21983a(long j, long j2, String str, long j3, String str2, String str3, long j4) {
        String str4 = str2;
        long j5 = j;
        if (m21999a(j, j3)) {
            m21982a(j, j2, str, j4);
            return;
        }
        CharSequence charSequence = str4;
        if (!(charSequence == null || charSequence.length() == 0)) {
            m21985a(getExceedTv(), Intrinsics.stringPlus(str4, " >"), (Function0<Unit>) new PixTransferAmountEditFragment$checkValue$1(str3, this), (Function0<Unit>) PixTransferAmountEditFragment$checkValue$2.INSTANCE);
        }
        getAmountInputEt().setTextColor(ContextCompat.getColor(requireContext(), R.color.wallet_pix_transfer_amount_error_color));
        getPayButton().setEnabled(false);
    }

    /* renamed from: a */
    private final void m21982a(long j, long j2, String str, long j3) {
        String str2;
        boolean z = false;
        if (!m21999a(j, j2)) {
            if (TextUtils.isEmpty(str)) {
                str2 = getString(R.string.GRider_limit_Beyond_the_GuvV);
            } else {
                str2 = getString(R.string.GRider_2_When_the_QyBM);
            }
            m21985a(getExceedTv(), Intrinsics.stringPlus(str2, " >"), (Function0<Unit>) new PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$2(this), (Function0<Unit>) new PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$3(j));
            getAmountInputEt().setTextColor(ContextCompat.getColor(requireContext(), R.color.wallet_pix_transfer_amount_error_color));
            getPayButton().setEnabled(false);
        } else if (m21999a(j, j3)) {
            TextView payButton2 = getPayButton();
            if (j > 0) {
                z = true;
            }
            payButton2.setEnabled(z);
            getAmountInputEt().setTextColor(-16777216);
            m21985a(getExceedTv(), (String) null, (Function0<Unit>) null, (Function0<Unit>) null);
        } else {
            m21985a(getExceedTv(), getString(R.string.GRider_payment_Over_the_QBYD), (Function0<Unit>) new PixTransferAmountEditFragment$checkNightAndMaxAvailableLimit$1(this), (Function0<Unit>) null);
            getAmountInputEt().setTextColor(ContextCompat.getColor(requireContext(), R.color.wallet_pix_transfer_amount_error_color));
            getPayButton().setEnabled(false);
        }
    }

    /* renamed from: a */
    private final void m21985a(TextView textView, String str, Function0<Unit> function0, Function0<Unit> function02) {
        CharSequence charSequence = str;
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        ViewExtsKt.click(textView, function0);
        if (!TextUtils.isEmpty(charSequence) && function02 != null) {
            function02.invoke();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v2 */
    /* JADX WARNING: type inference failed for: r3v3, types: [android.widget.RelativeLayout] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5, types: [android.widget.TextView] */
    /* JADX WARNING: type inference failed for: r3v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m22004c() {
        /*
            r7 = this;
            com.didi.payment.pix.net.response.PixTransferOption$TransferOptionInfo r0 = r7.f31243i
            if (r0 != 0) goto L_0x0006
            goto L_0x00e4
        L_0x0006:
            int r1 = r0.getUserAvailableAmount()
            double r1 = (double) r1
            java.lang.Double r1 = java.lang.Double.valueOf(r1)
            java.lang.String r1 = com.didi.payment.base.utils.MathUtil.centToDollar(r1)
            kotlin.jvm.internal.StringCompanionObject r2 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            r2 = 2131952846(0x7f1304ce, float:1.9542146E38)
            java.lang.String r2 = r7.getString(r2)
            java.lang.String r3 = "%s"
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r3)
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = " {R$ "
            r5.append(r6)
            r5.append(r1)
            r1 = 125(0x7d, float:1.75E-43)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r5 = 0
            r4[r5] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r4, r3)
            java.lang.String r1 = java.lang.String.format(r2, r1)
            java.lang.String r2 = "java.lang.String.format(format, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            android.content.res.Resources r2 = r7.getResources()
            r4 = 2131101903(0x7f0608cf, float:1.7816229E38)
            int r2 = r2.getColor(r4)
            android.text.SpannableStringBuilder r1 = com.didi.payment.base.utils.TextHighlightUtil.highlight((java.lang.CharSequence) r1, (int) r2, (boolean) r3)
            android.widget.TextView r2 = r7.getBalanceTv()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2.setText(r1)
            int r1 = r0.getUserBlockAmount()
            java.lang.String r2 = "mUnableAmountContainer"
            r3 = 0
            if (r1 == 0) goto L_0x00d6
            java.lang.String r1 = r0.getUnableAmountDesc()
            boolean r1 = com.didi.sdk.util.TextUtil.isEmpty(r1)
            if (r1 != 0) goto L_0x00d6
            java.lang.String r1 = r0.getUnableAmountBtnLabel()
            boolean r1 = com.didi.sdk.util.TextUtil.isEmpty(r1)
            if (r1 != 0) goto L_0x00d6
            java.lang.String r0 = r0.getUnableAmountLabel()
            boolean r0 = com.didi.sdk.util.TextUtil.isEmpty(r0)
            if (r0 != 0) goto L_0x00d6
            android.widget.RelativeLayout r0 = r7.f31239e
            if (r0 != 0) goto L_0x0094
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r0 = r3
        L_0x0094:
            r0.setVisibility(r5)
            android.widget.TextView r0 = r7.f31240f
            if (r0 != 0) goto L_0x00a1
            java.lang.String r0 = "mUnableAmountLabel"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r0 = r3
        L_0x00a1:
            com.didi.payment.pix.net.response.PixTransferOption$TransferOptionInfo r1 = r7.f31243i
            if (r1 != 0) goto L_0x00a7
            r1 = r3
            goto L_0x00ab
        L_0x00a7:
            java.lang.String r1 = r1.getUnableAmountLabel()
        L_0x00ab:
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r7.f31241g
            java.lang.String r1 = "mUnableAmountBtn"
            if (r0 != 0) goto L_0x00ba
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r0 = r3
        L_0x00ba:
            com.didi.payment.pix.net.response.PixTransferOption$TransferOptionInfo r2 = r7.f31243i
            if (r2 != 0) goto L_0x00c0
            r2 = r3
            goto L_0x00c4
        L_0x00c0:
            java.lang.String r2 = r2.getUnableAmountBtnLabel()
        L_0x00c4:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            android.widget.TextView r0 = r7.f31241g
            if (r0 != 0) goto L_0x00d1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            goto L_0x00d2
        L_0x00d1:
            r3 = r0
        L_0x00d2:
            r3.setVisibility(r5)
            goto L_0x00e4
        L_0x00d6:
            android.widget.RelativeLayout r0 = r7.f31239e
            if (r0 != 0) goto L_0x00de
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            goto L_0x00df
        L_0x00de:
            r3 = r0
        L_0x00df:
            r0 = 8
            r3.setVisibility(r0)
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.transfer.fragment.PixTransferAmountEditFragment.m22004c():void");
    }

    public void onResume() {
        super.onResume();
        if (this.f31245k) {
            this.f31245k = false;
            ((AmountEditVM) getVm()).loadData();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        hideLoading();
    }

    public final void gotoTopupBalance() {
        this.f31245k = true;
        if (WalletApolloUtil.getTopUpIsNew()) {
            DRouter.build("GuaranaOneTravel://one/ddw_top_up?pub_source=pix_transfer").start(getActivity());
        } else {
            DRouter.build("99pay://one/wallet_topup_amount").start(getActivity());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    public boolean onBackKeyPressed() {
        String key;
        PixQrCodeQueryResp.QRCodeData qRCodeData = this.f31260z;
        if (!(qRCodeData == null || (key = qRCodeData.getKey()) == null)) {
            ((AmountEditVM) getVm()).triggerRealtimePush(key, 2);
        }
        return super.onBackKeyPressed();
    }

    public void onDestroyView() {
        super.onDestroyView();
        ((AmountEditVM) getVm()).stopCountTimer();
    }
}
