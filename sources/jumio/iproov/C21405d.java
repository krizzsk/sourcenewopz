package jumio.iproov;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.iproov.sdk.IProov;
import com.iproov.sdk.cameray.Orientation;
import com.iproov.sdk.core.exception.IProovException;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.ImageData;
import com.jumio.commons.camera.Size;
import com.jumio.commons.enums.ScreenAngle;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.Controller;
import com.jumio.core.api.calls.IproovTokenCall;
import com.jumio.core.api.calls.IproovValidateCall;
import com.jumio.core.api.calls.UploadCall;
import com.jumio.core.data.ScanMode;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.extraction.liveness.extraction.LivenessDataModel;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.FaceScanPartModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.core.models.IproovValidateModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.provider.IproovProvider;
import com.jumio.core.scanpart.ScanPart;
import com.jumio.core.util.DeviceUtil;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.views.JumioAnimationView;
import com.taxis99.R;
import java.io.File;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* renamed from: jumio.iproov.d */
/* compiled from: IproovScanPart.kt */
public final class C21405d extends ScanPart<FaceScanPartModel> implements IProov.Listener, ApiBinding {

    /* renamed from: h */
    public static final String f59742h = C21405d.class.getSimpleName();

    /* renamed from: i */
    public static final C21410e f59743i = new C21410e();

    /* renamed from: a */
    public int f59744a;

    /* renamed from: b */
    public int f59745b;

    /* renamed from: c */
    public IproovProvider f59746c;

    /* renamed from: d */
    public Bitmap f59747d;

    /* renamed from: e */
    public SettingsModel f59748e;

    /* renamed from: f */
    public IproovTokenModel f59749f;

    /* renamed from: g */
    public IproovValidateModel f59750g;

    /* renamed from: jumio.iproov.d$a */
    /* compiled from: IproovScanPart.kt */
    public static final class C21406a {
        public C21406a() {
        }

        public /* synthetic */ C21406a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: jumio.iproov.d$b */
    /* compiled from: IproovScanPart.kt */
    public /* synthetic */ class C21407b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f59751a;

        static {
            int[] iArr = new int[C21411f.values().length];
            iArr[C21411f.UPFRONT_HELP.ordinal()] = 1;
            iArr[C21411f.TOKEN_REQUEST.ordinal()] = 2;
            iArr[C21411f.RETRY_HELP.ordinal()] = 3;
            iArr[C21411f.VALIDATE.ordinal()] = 4;
            f59751a = iArr;
        }
    }

    /* renamed from: jumio.iproov.d$c */
    /* compiled from: IproovScanPart.kt */
    public static final class C21408c extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        public final /* synthetic */ C21405d f59752a;

        /* renamed from: b */
        public final /* synthetic */ Ref.ObjectRef<File> f59753b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C21408c(C21405d dVar, Ref.ObjectRef<File> objectRef) {
            super(0);
            this.f59752a = dVar;
            this.f59753b = objectRef;
        }

        /* renamed from: a */
        public final void mo175937a() {
            String str;
            Bitmap a = this.f59752a.f59747d;
            if ((a != null && !a.isRecycled()) && this.f59753b.element != null) {
                CameraUtils.saveBitmap(this.f59752a.f59747d, (File) this.f59753b.element, Bitmap.CompressFormat.WEBP, 75, this.f59752a.getController().getAuthorizationModel().getSessionKey());
            }
            ImageData.Image image = ((FaceScanPartModel) this.f59752a.getScanPartModel()).getImageData().getImage();
            File file = (File) this.f59753b.element;
            if (file == null || (str = file.getAbsolutePath()) == null) {
                str = "";
            }
            image.setPath(str);
            LivenessDataModel livenessDataModel = new LivenessDataModel();
            livenessDataModel.setType(ScanMode.FACE_IPROOV);
            livenessDataModel.setPassed(Boolean.valueOf(this.f59752a.mo175930c().getPassed()));
            ((FaceScanPartModel) this.f59752a.getScanPartModel()).setLivenessData(livenessDataModel);
            this.f59752a.setComplete(true);
            ScanPart.sendScanStep$default(this.f59752a, JumioScanStep.CAN_FINISH, (Object) null, (Object) null, 6, (Object) null);
        }

        public /* synthetic */ Object invoke() {
            mo175937a();
            return Unit.INSTANCE;
        }
    }

    /* renamed from: jumio.iproov.d$d */
    /* compiled from: IproovScanPart.kt */
    public static final class C21409d extends Lambda implements Function0<Unit> {

        /* renamed from: a */
        public final /* synthetic */ C21405d f59754a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C21409d(C21405d dVar) {
            super(0);
            this.f59754a = dVar;
        }

        /* renamed from: a */
        public final void mo175938a() {
            this.f59754a.mo175936i();
        }

        public /* synthetic */ Object invoke() {
            mo175938a();
            return Unit.INSTANCE;
        }
    }

    static {
        new C21406a((DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C21405d(com.jumio.core.Controller r7, com.jumio.sdk.credentials.JumioFaceCredential r8, com.jumio.core.models.FaceScanPartModel r9, com.jumio.sdk.interfaces.JumioScanPartInterface r10) {
        /*
            r6 = this;
            java.lang.String r0 = "controller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "credential"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "scanPartModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "scanPartInterface"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r6.<init>(r7, r8, r9, r10)
            r6.reset()
            com.jumio.core.persistence.DataManager r8 = r7.getDataManager()
            java.lang.Class<com.jumio.core.models.IproovTokenModel> r9 = com.jumio.core.models.IproovTokenModel.class
            java.io.Serializable r8 = r8.get(r9)
            com.jumio.core.models.IproovTokenModel r8 = (com.jumio.core.models.IproovTokenModel) r8
            r6.f59749f = r8
            com.jumio.core.persistence.DataManager r8 = r7.getDataManager()
            java.lang.Class<com.jumio.core.models.SettingsModel> r9 = com.jumio.core.models.SettingsModel.class
            java.io.Serializable r8 = r8.get(r9)
            com.jumio.core.models.SettingsModel r8 = (com.jumio.core.models.SettingsModel) r8
            r6.f59748e = r8
            com.jumio.core.models.IproovTokenModel r8 = r6.f59749f
            java.lang.String r8 = r8.getToken()
            int r8 = r8.length()
            r9 = 1
            r10 = 0
            if (r8 != 0) goto L_0x0046
            r8 = 1
            goto L_0x0047
        L_0x0046:
            r8 = 0
        L_0x0047:
            if (r8 != 0) goto L_0x0060
            com.jumio.core.models.IproovTokenModel r8 = r6.f59749f
            java.lang.String r8 = r8.getUrl()
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0057
            r8 = 1
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            if (r8 == 0) goto L_0x005b
            goto L_0x0060
        L_0x005b:
            com.jumio.core.models.SettingsModel r7 = r6.f59748e
            r6.f59746c = r7
            goto L_0x0071
        L_0x0060:
            com.jumio.core.error.Error r8 = new com.jumio.core.error.Error
            com.jumio.core.enums.ErrorCase r1 = com.jumio.core.enums.ErrorCase.OCR_LOADING_FAILED
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            r0 = 2
            r1 = 0
            com.jumio.core.Controller.onError$default(r7, r8, r1, r0, r1)
        L_0x0071:
            com.jumio.core.provider.IproovProvider r7 = r6.f59746c
            if (r7 != 0) goto L_0x0077
            r7 = 3
            goto L_0x007b
        L_0x0077:
            int r7 = r7.getIproovMaxAttempts()
        L_0x007b:
            r6.f59744a = r7
            jumio.iproov.e r7 = f59743i
            r7.mo175939a(r6)
            boolean r8 = r6.mo175929b()
            r8 = r8 ^ r9
            com.iproov.sdk.IProov.registerListener(r7, r8)
            r6.mo175928a((boolean) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C21405d.<init>(com.jumio.core.Controller, com.jumio.sdk.credentials.JumioFaceCredential, com.jumio.core.models.FaceScanPartModel, com.jumio.sdk.interfaces.JumioScanPartInterface):void");
    }

    /* renamed from: b */
    public final boolean mo175929b() {
        HashMap<String, Serializable> data = ((FaceScanPartModel) getScanPartModel()).getData();
        Serializable serializable = data.get("firstStart");
        if (serializable == null) {
            serializable = Boolean.TRUE;
            data.put("firstStart", serializable);
        }
        return ((Boolean) serializable).booleanValue();
    }

    /* renamed from: c */
    public final IproovValidateModel mo175930c() {
        IproovValidateModel iproovValidateModel = this.f59750g;
        if (iproovValidateModel != null) {
            return iproovValidateModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("iproovValidateModel");
        return null;
    }

    public void cancel() {
        reset();
        if (mo175931d() != C21411f.UPFRONT_HELP) {
            mo175927a(C21411f.RETRY_HELP);
        }
        getController().getBackendManager().cancelCall(true);
        C21410e eVar = f59743i;
        eVar.mo175939a((IProov.Listener) null);
        IProov.unregisterListener(eVar);
        super.cancel();
    }

    /* renamed from: d */
    public final C21411f mo175931d() {
        HashMap<String, Serializable> data = ((FaceScanPartModel) getScanPartModel()).getData();
        Serializable serializable = data.get("state");
        if (serializable == null) {
            serializable = C21411f.UPFRONT_HELP;
            data.put("state", serializable);
        }
        return (C21411f) serializable;
    }

    /* renamed from: e */
    public final boolean mo175932e() {
        return StringsKt.equals(this.f59749f.getProductType(), "iproov_premium", true);
    }

    /* renamed from: f */
    public final void mo175933f() {
        try {
            IProov.launch(getController().getContext(), this.f59749f.getUrl(), this.f59749f.getToken(), mo175922a());
        } catch (Exception e) {
            Log.m39462e(f59742h, "Error on launching Iproov", (Throwable) e);
            String string = getController().getContext().getString(R.string.iproov__error_unexpected_error);
            Intrinsics.checkNotNullExpressionValue(string, "controller.context.getSt…__error_unexpected_error)");
            mo175925a(new JumioRetryReason(1, string));
        }
    }

    public void finish() {
        C21410e eVar = f59743i;
        eVar.mo175939a((IProov.Listener) null);
        IProov.unregisterListener(eVar);
        super.finish();
    }

    /* renamed from: g */
    public final void mo175934g() {
        ((FaceScanPartModel) getScanPartModel()).getImageData().setCameraPosition(ImageData.CameraPosition.FRONT);
        ((FaceScanPartModel) getScanPartModel()).getImageData().setOrientationMode(ScreenAngle.PORTRAIT);
        ((FaceScanPartModel) getScanPartModel()).getImageData().setFlashMode(false);
        Size imageSize = ((FaceScanPartModel) getScanPartModel()).getImageData().getImageSize();
        Bitmap bitmap = this.f59747d;
        imageSize.width = bitmap == null ? 0 : bitmap.getWidth();
        Size imageSize2 = ((FaceScanPartModel) getScanPartModel()).getImageData().getImageSize();
        Bitmap bitmap2 = this.f59747d;
        imageSize2.height = bitmap2 == null ? 0 : bitmap2.getHeight();
        if (Log.isLogEnabledForLevel(Log.LogLevel.DEBUG) && this.f59747d != null) {
            LogUtils.dumpImageInSubfolder(this.f59747d, C21405d.class.getSimpleName(), Bitmap.CompressFormat.JPEG, 80, ((FaceScanPartModel) getScanPartModel()).getSide().toString());
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        try {
            File dataDirectory = Environment.getDataDirectory(getController().getContext());
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(Locale.ENGLISH, "tmp_%d", Arrays.copyOf(new Object[]{Long.valueOf(System.currentTimeMillis())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
            objectRef.element = new File(dataDirectory, format);
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
        async(new C21408c(this, objectRef));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 3
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<com.jumio.core.api.calls.IproovTokenCall> r2 = com.jumio.core.api.calls.IproovTokenCall.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<com.jumio.core.api.calls.IproovValidateCall> r2 = com.jumio.core.api.calls.IproovValidateCall.class
            r0[r1] = r2
            r1 = 2
            java.lang.Class<com.jumio.core.api.calls.UploadCall> r2 = com.jumio.core.api.calls.UploadCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C21405d.getBindingClasses():java.lang.Class[]");
    }

    public boolean getHasFallback() {
        return false;
    }

    public void getHelpAnimation(JumioAnimationView jumioAnimationView) {
        Intrinsics.checkNotNullParameter(jumioAnimationView, "animationView");
        jumioAnimationView.removeAllViews();
        View inflate = LayoutInflater.from(jumioAnimationView.getContext()).inflate(R.layout.iproov_custom_animation, jumioAnimationView, false);
        if (inflate != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
            jumioAnimationView.addView(constraintLayout);
            C21402c cVar = new C21402c(jumioAnimationView.getContext());
            View findViewById = constraintLayout.findViewById(R.id.iproov_help_animation);
            if (findViewById != null) {
                cVar.mo175917a((MotionLayout) findViewById, mo175932e());
                HashMap<Integer, Integer> a = mo175923a(jumioAnimationView.getContext());
                Integer num = a.get(Integer.valueOf(R.attr.iproov_animation_foreground)) != null ? a.get(Integer.valueOf(R.attr.iproov_animation_foreground)) : -16777216;
                Integer num2 = a.get(Integer.valueOf(R.attr.iproov_animation_background)) != null ? a.get(Integer.valueOf(R.attr.iproov_animation_background)) : -1;
                if (num2 != null) {
                    jumioAnimationView.setBackgroundColor(num2.intValue());
                }
                if (!(num == null || num2 == null)) {
                    Resources resources = jumioAnimationView.getContext().getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "animationView.context.resources");
                    cVar.mo175916a(resources, num.intValue(), num2.intValue());
                }
                cVar.mo175915a();
                jumioAnimationView.setTag(cVar);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.motion.widget.MotionLayout");
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public JumioScanMode getScanMode() {
        return JumioScanMode.FACE_IPROOV;
    }

    /* renamed from: h */
    public final void mo175935h() {
        mo175927a(C21411f.TOKEN_REQUEST);
        getController().getBackendManager().requestIproovToken();
    }

    /* renamed from: i */
    public final void mo175936i() {
        C21411f d = mo175931d();
        C21411f fVar = C21411f.RETRY_HELP;
        if (d == fVar) {
            mo175935h();
        } else if (mo175931d() != C21411f.UPFRONT_HELP) {
            mo175927a(fVar);
            mo175935h();
        } else if (this.f59749f.getUsed()) {
            mo175935h();
        } else {
            if (this.f59749f.getToken().length() > 0) {
                mo175927a(C21411f.INITIALIZING);
                mo175933f();
                return;
            }
            Controller.onError$default(getController(), new Error(ErrorCase.OCR_LOADING_FAILED, 0, 2301), (Class) null, 2, (Object) null);
        }
    }

    public boolean isCancelable() {
        return (mo175931d() == C21411f.INITIALIZING || mo175931d() == C21411f.RUNNING) ? false : true;
    }

    public void onCancelled() {
        if (mo175931d() == C21411f.RUNNING || mo175931d() == C21411f.PROGRESS) {
            Log.m39466i(f59742h, "onIproovCancelled: ");
            mo175927a(C21411f.RETRY_HELP);
            String string = getController().getContext().getString(R.string.iproov__error_unexpected_error);
            Intrinsics.checkNotNullExpressionValue(string, "controller.context.getSt…__error_unexpected_error)");
            mo175925a(new JumioRetryReason(2, string));
            return;
        }
        Log.m39466i(f59742h, Intrinsics.stringPlus("onCancelled was triggered in state ", mo175931d()));
    }

    public void onConnected() {
        mo175927a(C21411f.RUNNING);
        Log.m39466i(f59742h, Intrinsics.stringPlus("onIproovConnected: ", this.f59749f.getToken()));
        ((IproovTokenModel) getController().getDataManager().get(IproovTokenModel.class)).setUsed(true);
        MetaInfo analyticsScanData = getAnalyticsScanData();
        analyticsScanData.put("additionalData", mo175932e() ? "GPA" : "LA");
        ScanPart.sendScanStep$default(this, JumioScanStep.STARTED, (Object) null, analyticsScanData, 2, (Object) null);
    }

    public void onConnecting() {
        mo175927a(C21411f.INITIALIZING);
        Log.m39466i(f59742h, Intrinsics.stringPlus("onIproovConnecting: ", this.f59749f.getToken()));
    }

    public void onError(IProovException iProovException) {
        Intrinsics.checkNotNullParameter(iProovException, "e");
        C21398a a = C21398a.f59691c.mo175910a(iProovException);
        Log.m39466i(f59742h, Intrinsics.stringPlus("onIproovError: ", iProovException.getReason()));
        int c = a.mo175909c();
        String reason = iProovException.getReason();
        if (reason == null) {
            reason = getController().getContext().getString(R.string.iproov__error_unexpected_error);
            Intrinsics.checkNotNullExpressionValue(reason, "controller.context.getSt…__error_unexpected_error)");
        }
        mo175925a(new JumioRetryReason(c, reason));
    }

    public void onFailure(IProov.FailureResult failureResult) {
        Intrinsics.checkNotNullParameter(failureResult, "failureResult");
        if (mo175931d() == C21411f.RUNNING || mo175931d() == C21411f.PROGRESS) {
            C21400b a = C21400b.f59705d.mo175914a(failureResult.feedbackCode);
            Log.m39466i(f59742h, Intrinsics.stringPlus("onIproovFailure: ", a.mo175911b()));
            Bitmap bitmap = failureResult.frame;
            this.f59747d = bitmap;
            int i = this.f59745b + 1;
            this.f59745b = i;
            if (i < this.f59744a || bitmap == null) {
                int c = a.mo175912c();
                String string = getController().getContext().getString(a.mo175913d());
                Intrinsics.checkNotNullExpressionValue(string, "controller.context.getSt…g(iproovFailure.stringId)");
                mo175925a(new JumioRetryReason(c, string));
                return;
            }
            mo175926a("");
            return;
        }
        Log.m39466i(f59742h, Intrinsics.stringPlus("failure callback was triggered in state ", mo175931d()));
    }

    public void onProcessing(double d, String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        if (mo175931d() == C21411f.RUNNING || mo175931d() == C21411f.PROGRESS) {
            C21411f d2 = mo175931d();
            C21411f fVar = C21411f.PROGRESS;
            if (d2 != fVar) {
                String str2 = f59742h;
                Log.m39466i(str2, "onProgress: " + ((int) (((double) 100) * d)) + " ; " + str);
                MetaInfo analyticsScanData = getAnalyticsScanData();
                analyticsScanData.put("additionalData", mo175932e() ? "GPA" : "LA");
                ScanPart.sendScanStep$default(this, JumioScanStep.IMAGE_TAKEN, (Object) null, analyticsScanData, 2, (Object) null);
            }
            mo175927a(fVar);
            String str3 = f59742h;
            Log.m39466i(str3, "onProgress: " + ((int) (d * ((double) 100))) + " ; " + str);
            return;
        }
        Log.m39466i(f59742h, Intrinsics.stringPlus("processing callback was triggered in state ", mo175931d()));
    }

    public void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        Class<?> call = apiCallDataModel.getCall();
        if (Intrinsics.areEqual((Object) call, (Object) IproovTokenCall.class)) {
            IproovTokenModel iproovTokenModel = (IproovTokenModel) obj;
            if (iproovTokenModel != null) {
                if ((iproovTokenModel.getToken().length() > 0) && !StringsKt.equals(iproovTokenModel.getToken(), this.f59749f.getToken(), true)) {
                    this.f59749f = iproovTokenModel;
                    mo175927a(C21411f.UPFRONT_HELP);
                    post(new C21409d(this));
                    return;
                }
            }
            Log.m39466i(f59742h, "Invalid token received from server");
            String string = getController().getContext().getString(R.string.iproov__error_unexpected_error);
            Intrinsics.checkNotNullExpressionValue(string, "controller.context.getSt…__error_unexpected_error)");
            mo175925a(new JumioRetryReason(209, string));
        } else if (!Intrinsics.areEqual((Object) call, (Object) IproovValidateCall.class)) {
        } else {
            if (obj != null) {
                mo175924a((IproovValidateModel) obj);
                if (mo175930c().getPassed()) {
                    mo175934g();
                } else if (this.f59745b < this.f59744a || this.f59747d == null) {
                    String string2 = getController().getContext().getString(R.string.iproov__error_unexpected_error);
                    Intrinsics.checkNotNullExpressionValue(string2, "controller.context.getSt…__error_unexpected_error)");
                    mo175925a(new JumioRetryReason(4, string2));
                } else {
                    mo175934g();
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.jumio.core.models.IproovValidateModel");
            }
        }
    }

    public void onSuccess(IProov.SuccessResult successResult) {
        Intrinsics.checkNotNullParameter(successResult, "successResult");
        if (mo175931d() == C21411f.RUNNING || mo175931d() == C21411f.PROGRESS) {
            MetaInfo metaInfo = new MetaInfo();
            metaInfo.put("additionalData", successResult.token);
            Analytics.Companion.add(MobileEvents.misc("iproovSuccess", metaInfo));
            this.f59747d = successResult.frame;
            mo175926a(this.f59749f.getToken());
            return;
        }
        Log.m39466i(f59742h, Intrinsics.stringPlus("success callback was triggered in state ", mo175931d()));
    }

    public void persist() {
        super.persist();
        C21410e eVar = f59743i;
        eVar.mo175939a((IProov.Listener) null);
        IProov.unregisterListener(eVar);
    }

    public void retry(JumioRetryReason jumioRetryReason) {
        Intrinsics.checkNotNullParameter(jumioRetryReason, "reason");
        super.retry(jumioRetryReason);
        Log.m39466i(f59742h, Intrinsics.stringPlus("retry triggered for state ", mo175931d()));
        int i = C21407b.f59751a[mo175931d().ordinal()];
        if (i == 1) {
            ScanPart.sendScanStep$default(this, JumioScanStep.PREPARE, (Object) null, (Object) null, 6, (Object) null);
            mo175936i();
        } else if (i == 2 || i == 3) {
            ScanPart.sendScanStep$default(this, JumioScanStep.PREPARE, (Object) null, (Object) null, 6, (Object) null);
            mo175935h();
        } else if (i == 4) {
            mo175926a("");
        }
    }

    public void start() {
        super.start();
        ScanPart.sendScanStep$default(this, JumioScanStep.PREPARE, (Object) null, (Object) null, 6, (Object) null);
        mo175936i();
    }

    /* renamed from: a */
    public final void mo175927a(C21411f fVar) {
        ((FaceScanPartModel) getScanPartModel()).getData().put("state", fVar);
    }

    /* renamed from: a */
    public final void mo175928a(boolean z) {
        ((FaceScanPartModel) getScanPartModel()).getData().put("firstStart", Boolean.valueOf(z));
    }

    /* renamed from: a */
    public final void mo175924a(IproovValidateModel iproovValidateModel) {
        Intrinsics.checkNotNullParameter(iproovValidateModel, "<set-?>");
        this.f59750g = iproovValidateModel;
    }

    /* renamed from: a */
    public final void mo175925a(JumioRetryReason jumioRetryReason) {
        mo175927a(C21411f.RETRY_HELP);
        ScanPart.sendScanStep$default(this, JumioScanStep.RETRY, jumioRetryReason, (Object) null, 4, (Object) null);
    }

    /* renamed from: a */
    public final void mo175926a(String str) {
        Log.m39466i(f59742h, Intrinsics.stringPlus("onIproovSuccess: ", str));
        mo175927a(C21411f.VALIDATE);
        ScanPart.sendScanStep$default(this, JumioScanStep.PROCESSING, (Object) null, (Object) null, 6, (Object) null);
        getController().getBackendManager().validateIproovToken();
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th) {
        Intrinsics.checkNotNullParameter(apiCallDataModel, "apiCallDataModel");
        Class<?> call = apiCallDataModel.getCall();
        boolean z = true;
        if (!(Intrinsics.areEqual((Object) call, (Object) UploadCall.class) ? true : Intrinsics.areEqual((Object) call, (Object) IproovTokenCall.class))) {
            z = Intrinsics.areEqual((Object) call, (Object) IproovValidateCall.class);
        }
        if (z) {
            getController().onError(th, apiCallDataModel.getCall());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0044 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a0 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a1 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b7 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b9 A[Catch:{ Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c7 A[LOOP:0: B:26:0x00ad->B:32:0x00c7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cf A[EDGE_INSN: B:36:0x00cf->B:35:0x00cf ?: BREAK  , SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.HashMap<java.lang.Integer, java.lang.Integer> mo175923a(android.content.Context r9) {
        /*
            r8 = this;
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            boolean r1 = r9 instanceof com.jumio.core.MobileContext
            r2 = 0
            if (r1 == 0) goto L_0x0021
            r1 = r9
            com.jumio.core.MobileContext r1 = (com.jumio.core.MobileContext) r1
            int r3 = r1.getCustomThemeId()
            if (r3 == 0) goto L_0x0021
            androidx.appcompat.view.ContextThemeWrapper r3 = new androidx.appcompat.view.ContextThemeWrapper
            int r1 = r1.getCustomThemeId()
            r3.<init>((android.content.Context) r9, (int) r1)
            android.content.res.Resources$Theme r1 = r3.getTheme()
            goto L_0x0029
        L_0x0021:
            if (r9 != 0) goto L_0x0025
            r1 = r2
            goto L_0x0029
        L_0x0025:
            android.content.res.Resources$Theme r1 = r9.getTheme()
        L_0x0029:
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r4 = 2132017567(0x7f14019f, float:1.9673416E38)
            r5 = 0
            r6 = 1
            if (r1 != 0) goto L_0x0036
            goto L_0x0041
        L_0x0036:
            r7 = 2130969446(0x7f040366, float:1.7547574E38)
            boolean r1 = r1.resolveAttribute(r7, r0, r6)     // Catch:{ Exception -> 0x00c9 }
            if (r1 != r6) goto L_0x0041
            r1 = 1
            goto L_0x0042
        L_0x0041:
            r1 = 0
        L_0x0042:
            if (r1 == 0) goto L_0x0046
            int r4 = r0.data     // Catch:{ Exception -> 0x00c9 }
        L_0x0046:
            r0 = 13
            int[] r0 = new int[r0]     // Catch:{ Exception -> 0x00c9 }
            r1 = 2130969444(0x7f040364, float:1.754757E38)
            r0[r5] = r1     // Catch:{ Exception -> 0x00c9 }
            r1 = 2130969443(0x7f040363, float:1.7547568E38)
            r0[r6] = r1     // Catch:{ Exception -> 0x00c9 }
            r1 = 2
            r6 = 2130969445(0x7f040365, float:1.7547572E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 3
            r6 = 2130969454(0x7f04036e, float:1.754759E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 4
            r6 = 2130969453(0x7f04036d, float:1.7547588E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 5
            r6 = 2130969452(0x7f04036c, float:1.7547586E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 6
            r6 = 2130969448(0x7f040368, float:1.7547578E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 7
            r6 = 2130969447(0x7f040367, float:1.7547576E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 8
            r6 = 2130969455(0x7f04036f, float:1.7547592E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 9
            r6 = 2130969456(0x7f040370, float:1.7547594E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 10
            r6 = 2130969450(0x7f04036a, float:1.7547582E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 11
            r6 = 2130969449(0x7f040369, float:1.754758E38)
            r0[r1] = r6     // Catch:{ Exception -> 0x00c9 }
            r1 = 2130969451(0x7f04036b, float:1.7547584E38)
            r6 = 12
            r0[r6] = r1     // Catch:{ Exception -> 0x00c9 }
            java.util.Arrays.sort(r0)     // Catch:{ Exception -> 0x00c9 }
            if (r9 != 0) goto L_0x00a1
            goto L_0x00ac
        L_0x00a1:
            android.content.res.Resources$Theme r9 = r9.getTheme()     // Catch:{ Exception -> 0x00c9 }
            if (r9 != 0) goto L_0x00a8
            goto L_0x00ac
        L_0x00a8:
            android.content.res.TypedArray r2 = r9.obtainStyledAttributes(r4, r0)     // Catch:{ Exception -> 0x00c9 }
        L_0x00ac:
            r9 = 0
        L_0x00ad:
            int r1 = r9 + 1
            r4 = r0[r9]     // Catch:{ Exception -> 0x00c9 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00c9 }
            if (r2 != 0) goto L_0x00b9
            r9 = -1
            goto L_0x00bd
        L_0x00b9:
            int r9 = r2.getColor(r9, r5)     // Catch:{ Exception -> 0x00c9 }
        L_0x00bd:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x00c9 }
            r3.put(r4, r9)     // Catch:{ Exception -> 0x00c9 }
            if (r1 <= r6) goto L_0x00c7
            goto L_0x00cf
        L_0x00c7:
            r9 = r1
            goto L_0x00ad
        L_0x00c9:
            r9 = move-exception
            java.lang.String r0 = f59742h
            com.jumio.commons.log.Log.m39463e((java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x00cf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.iproov.C21405d.mo175923a(android.content.Context):java.util.HashMap");
    }

    /* renamed from: a */
    public final IProov.Options mo175922a() {
        IProov.Options options = new IProov.Options();
        IProov.Options.C19751UI ui = options.f53992ui;
        ui.genuinePresenceAssurance.autoStartDisabled = false;
        ui.enableScreenshots = DeviceUtil.isDebug(getController().getContext());
        HashMap<Integer, Integer> a = mo175923a((Context) getController().getContext());
        options.f53992ui.activityCompatibilityRequestCode = 4000;
        IProov.Options.C19751UI ui2 = options.f53992ui;
        ui2.title = "";
        ui2.filter = IProov.Filter.VIBRANT;
        ui2.orientation = Orientation.PORTRAIT;
        Integer num = a.get(Integer.valueOf(R.attr.iproov_footerTextColor));
        int i = -1;
        ui2.footerTextColor = num == null ? -1 : num.intValue();
        IProov.Options.C19751UI ui3 = options.f53992ui;
        Integer num2 = a.get(Integer.valueOf(R.attr.iproov_headerTextColor));
        ui3.headerTextColor = num2 == null ? -1 : num2.intValue();
        IProov.Options.C19751UI.GenuinePresenceAssurance genuinePresenceAssurance = options.f53992ui.genuinePresenceAssurance;
        Integer num3 = a.get(Integer.valueOf(R.attr.iproov_genuinePresenceAssurance_progressBarColor));
        genuinePresenceAssurance.progressBarColor = num3 == null ? Color.parseColor("#FF000000") : num3.intValue();
        IProov.Options.C19751UI ui4 = options.f53992ui;
        Integer num4 = a.get(Integer.valueOf(R.attr.iproov_headerBackgroundColor));
        ui4.headerBackgroundColor = num4 == null ? Color.parseColor("#AA000000") : num4.intValue();
        IProov.Options.C19751UI ui5 = options.f53992ui;
        Integer num5 = a.get(Integer.valueOf(R.attr.iproov_footerBackgroundColor));
        ui5.footerBackgroundColor = num5 == null ? Color.parseColor("#AA000000") : num5.intValue();
        IProov.Options.C19751UI.LivenessAssurance livenessAssurance = options.f53992ui.livenessAssurance;
        Integer num6 = a.get(Integer.valueOf(R.attr.iproov_livenessAssurance_primaryTintColor));
        livenessAssurance.primaryTintColor = num6 == null ? Color.parseColor("#2ABC6D") : num6.intValue();
        IProov.Options.C19751UI.LivenessAssurance livenessAssurance2 = options.f53992ui.livenessAssurance;
        Integer num7 = a.get(Integer.valueOf(R.attr.iproov_livenessAssurance_secondaryTintColor));
        if (num7 != null) {
            i = num7.intValue();
        }
        livenessAssurance2.secondaryTintColor = i;
        IProov.Options.C19751UI ui6 = options.f53992ui;
        Integer num8 = a.get(Integer.valueOf(R.attr.iproov_backgroundColor));
        ui6.backgroundColor = num8 == null ? Color.parseColor("#FAFAFA") : num8.intValue();
        IProov.Options.C19751UI ui7 = options.f53992ui;
        Integer num9 = a.get(Integer.valueOf(R.attr.iproov_lineColor));
        int i2 = -16777216;
        ui7.lineColor = num9 == null ? -16777216 : num9.intValue();
        IProov.Options.C19751UI.GenuinePresenceAssurance genuinePresenceAssurance2 = options.f53992ui.genuinePresenceAssurance;
        Integer num10 = a.get(Integer.valueOf(R.attr.iproov_genuinePresenceAssurance_notReadyTintColor));
        genuinePresenceAssurance2.notReadyTintColor = num10 == null ? -16776961 : num10.intValue();
        IProov.Options.C19751UI.GenuinePresenceAssurance genuinePresenceAssurance3 = options.f53992ui.genuinePresenceAssurance;
        Integer num11 = a.get(Integer.valueOf(R.attr.iproov_genuinePresenceAssurance_readyTintColor));
        if (num11 != null) {
            i2 = num11.intValue();
        }
        genuinePresenceAssurance3.readyTintColor = i2;
        options.capture.faceDetector = IProov.FaceDetector.AUTO;
        return options;
    }
}
