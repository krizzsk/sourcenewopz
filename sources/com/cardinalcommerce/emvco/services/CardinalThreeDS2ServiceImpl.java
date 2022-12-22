package com.cardinalcommerce.emvco.services;

import android.content.Context;
import android.content.res.Resources;
import com.cardinalcommerce.emvco.parameters.AuthenticationRequestParameters;
import com.cardinalcommerce.emvco.parameters.ConfigParameters;
import com.cardinalcommerce.p060a.JWK;
import com.cardinalcommerce.p060a.setHeight;
import com.cardinalcommerce.p060a.setHorizontallyScrolling;
import com.cardinalcommerce.p060a.setImageMatrix;
import com.cardinalcommerce.p060a.setMaxEms;
import com.cardinalcommerce.p060a.setMaxHeight;
import com.cardinalcommerce.p060a.setMinEms;
import com.cardinalcommerce.p060a.setProgressBackgroundTintMode;
import com.cardinalcommerce.p060a.setProgressDrawable;
import com.cardinalcommerce.p060a.setProgressTintBlendMode;
import com.cardinalcommerce.p060a.setSecondaryProgressTintBlendMode;
import com.cardinalcommerce.p060a.setTextCursorDrawable;
import com.cardinalcommerce.p060a.setTextSelectHandle;
import com.cardinalcommerce.shared.models.Warning;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import com.cardinalcommerce.shared.models.exceptions.SDKNotInitializedException;
import com.cardinalcommerce.shared.models.exceptions.SDKRuntimeException;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardinalThreeDS2ServiceImpl implements ThreeDS2Service {

    /* renamed from: a */
    private static Context f3265a;

    /* renamed from: g */
    private static List<Warning> f3266g = null;

    /* renamed from: b */
    private ConfigParameters f3267b = null;

    /* renamed from: c */
    private UiCustomization f3268c = null;

    /* renamed from: d */
    private setTextCursorDrawable f3269d;

    /* renamed from: e */
    private final setProgressBackgroundTintMode f3270e = setProgressBackgroundTintMode.init();

    /* renamed from: f */
    private boolean f3271f = false;

    static {
        Security.insertProviderAt(new JWK(), 1);
    }

    public void initialize(Context context, ConfigParameters configParameters, String str, UiCustomization uiCustomization) throws InvalidInputException, setMinEms, SDKRuntimeException {
        if (!this.f3271f) {
            this.f3271f = true;
            this.f3270e.Cardinal("EMVCoInitialize", "Initialize called");
            setProgressBackgroundTintMode setprogressbackgroundtintmode = this.f3270e;
            StringBuilder sb = new StringBuilder("SDKVersion ");
            sb.append(setHeight.values);
            setprogressbackgroundtintmode.Cardinal("EMVCoInitialize", sb.toString());
            if (context == null || configParameters == null || str == null || uiCustomization == null) {
                String str2 = "";
                if (context == null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str2);
                    sb2.append("Null Context ");
                    str2 = sb2.toString();
                    this.f3270e.init(new setImageMatrix(11113, "EMVCO Initialize CardinalError: Null Context "));
                }
                if (configParameters == null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str2);
                    sb3.append("Null Parameters ");
                    str2 = sb3.toString();
                    this.f3270e.init(new setImageMatrix(11102, "EMVCO Initialize CardinalError: Null Parameters "));
                }
                if (str == null) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str2);
                    sb4.append("Null Locale ");
                    str2 = sb4.toString();
                    this.f3270e.init(new setImageMatrix(11111, "EMVCO Initialize CardinalError: Null Locale "));
                }
                if (uiCustomization == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    sb5.append("Null UICustomization ");
                    str2 = sb5.toString();
                    this.f3270e.init(new setImageMatrix(11112, "EMVCO Initialize CardinalError: Null UICustomization "));
                }
                throw new InvalidInputException("InvalidInputException", new Throwable("Invalid Input Exception: ".concat(String.valueOf(str2))));
            }
            f3265a = context;
            boolean z = setHeight.Cardinal;
            this.f3267b = configParameters;
            this.f3268c = uiCustomization;
            f3266g = new ArrayList();
            setTextCursorDrawable settextcursordrawable = new setTextCursorDrawable(!getClass().getName().equals(CardinalThreeDS2ServiceImpl.class.getName()), context);
            this.f3269d = settextcursordrawable;
            f3266g.addAll(settextcursordrawable.cca_continue);
            setTextSelectHandle.cca_continue(f3265a.getApplicationContext());
            setSecondaryProgressTintBlendMode setsecondaryprogresstintblendmode = setSecondaryProgressTintBlendMode.EMVCO;
            if (setMaxEms.Cardinal == null) {
                setMaxEms.Cardinal = new setMaxEms();
            }
            setMaxEms setmaxems = setMaxEms.Cardinal;
            setmaxems.cca_continue = setsecondaryprogresstintblendmode;
            setmaxems.init = uiCustomization;
            this.f3270e.Cardinal("EMVCoInitialize", "UIInteractionFactory Configured");
            this.f3270e.Cardinal("EMVCoInitialize", "Initialized");
            return;
        }
        this.f3270e.init(new setImageMatrix(11101, "SDK already initialized "));
        throw new setMinEms("SDKAlreadyInitializedException", new Throwable("ThreeDS SDK is already initialized"));
    }

    public void initialize(Context context, ConfigParameters configParameters) throws InvalidInputException, setMinEms, SDKRuntimeException {
        initialize(context, configParameters, Resources.getSystem().getConfiguration().locale.toString(), new UiCustomization());
    }

    public Transaction createTransaction(String str) throws InvalidInputException, SDKNotInitializedException, SDKRuntimeException {
        return createTransaction(str, "2.2.0");
    }

    public Transaction createTransaction(String str, String str2) throws InvalidInputException, SDKNotInitializedException, SDKRuntimeException {
        if (!this.f3271f) {
            this.f3270e.init(new setImageMatrix(11301, "SDK not initialized"));
            throw new SDKNotInitializedException("SDKNotInitializedException", new Throwable("ThreeDS SDK is not initialized"));
        } else if (str2 == null || !m2225a(str2)) {
            this.f3270e.init(new setImageMatrix(11303, "Create Transaction CardinalError "));
            StringBuilder sb = new StringBuilder("MessageVersion ");
            sb.append(str2);
            sb.append(" is Invalid");
            throw new InvalidInputException("Invalid MessageVersion", new Throwable(sb.toString()));
        } else {
            setProgressDrawable setprogressdrawable = new setProgressDrawable(f3265a, str, this.f3268c, setHorizontallyScrolling.getInstance(str2), this.f3269d, this.f3267b.getParamValue("locationDataConsentGiven"));
            setProgressTintBlendMode cca_continue = setProgressTintBlendMode.cca_continue();
            try {
                if (new setMaxHeight(f3265a).configure(str)) {
                    setProgressTintBlendMode.CardinalError.Cardinal("EMVCoTransaction", "Configure called");
                    cca_continue.getInstance = setprogressdrawable;
                    char[] instance = setHorizontallyScrolling.getInstance(setprogressdrawable.Cardinal);
                    char[] configure = cca_continue.configure();
                    cca_continue.Cardinal = setHorizontallyScrolling.getInstance(UUID.randomUUID().toString());
                    setprogressdrawable.getSDKVersion = new String(cca_continue.Cardinal);
                    char[] instance2 = setProgressTintBlendMode.getInstance(setprogressdrawable);
                    setProgressBackgroundTintMode setprogressbackgroundtintmode = setProgressTintBlendMode.CardinalError;
                    StringBuilder sb2 = new StringBuilder("SDKAppID ");
                    sb2.append(setprogressdrawable.Cardinal);
                    setprogressbackgroundtintmode.Cardinal("EMVCoTransaction", sb2.toString());
                    if (cca_continue.Cardinal != null) {
                        setProgressBackgroundTintMode setprogressbackgroundtintmode2 = setProgressTintBlendMode.CardinalError;
                        StringBuilder sb3 = new StringBuilder("SDKTransactionID ");
                        sb3.append(new String(cca_continue.Cardinal));
                        setprogressbackgroundtintmode2.Cardinal("EMVCoTransaction", sb3.toString());
                        cca_continue.cca_continue = new AuthenticationRequestParameters(cca_continue.Cardinal, instance2, configure, instance, setHorizontallyScrolling.getInstance(setprogressdrawable.getInstance), setprogressdrawable.init());
                    } else {
                        setProgressTintBlendMode.CardinalError.init(new setImageMatrix(11313, " Null SDKTransactionID \n"));
                    }
                    this.f3270e.Cardinal("EMVCoTransaction", "Transaction created");
                    this.f3270e.getInstance();
                    return cca_continue;
                }
                this.f3270e.init(new setImageMatrix(11302, "Directory Server ID is not available "));
                StringBuilder sb4 = new StringBuilder("Directory Server Id ");
                sb4.append(str);
                sb4.append(" is not available");
                throw new InvalidInputException("Invalid Directory Server ID", new Throwable(sb4.toString()));
            } catch (InvalidAlgorithmParameterException e) {
                setProgressBackgroundTintMode setprogressbackgroundtintmode3 = this.f3270e;
                StringBuilder sb5 = new StringBuilder("Create Transaction CardinalError ");
                sb5.append(e.getLocalizedMessage());
                setprogressbackgroundtintmode3.init(new setImageMatrix(11311, sb5.toString()));
                throw new InvalidInputException("Exception in Creating transaction", e.getCause());
            } catch (NoSuchAlgorithmException e2) {
                setProgressBackgroundTintMode setprogressbackgroundtintmode4 = this.f3270e;
                StringBuilder sb6 = new StringBuilder("Create Transaction CardinalError ");
                sb6.append(e2.getLocalizedMessage());
                setprogressbackgroundtintmode4.init(new setImageMatrix(11312, sb6.toString()));
                throw new SDKRuntimeException("Exception in Creating transaction", e2.getCause());
            }
        }
    }

    /* renamed from: a */
    private static boolean m2225a(String str) {
        return setHeight.init.contains(str);
    }

    public void cleanup(Context context) throws SDKNotInitializedException {
        if (this.f3271f) {
            if (f3265a != null) {
                f3265a = null;
            }
            setProgressTintBlendMode.cca_continue().close();
            this.f3271f = false;
            return;
        }
        this.f3270e.init(new setImageMatrix(11501, "SDK Not Initialized"));
        throw new SDKNotInitializedException("SDKNotInitializedException", new Throwable("ThreeDS SDK is not initialized"));
    }

    public String getSDKVersion() throws SDKNotInitializedException, SDKRuntimeException {
        if (!this.f3271f) {
            this.f3270e.init(new setImageMatrix(11601, "SDK Not Initialized"));
            throw new SDKNotInitializedException("SDKNotInitializedException", new Throwable("ThreeDS SDK is not initialized"));
        } else if (setHeight.values != null) {
            return setHeight.values;
        } else {
            this.f3270e.init(new setImageMatrix(11602, "SDK RuntimeException at getSDKVersion()"));
            throw new SDKRuntimeException("SDKRuntimeException", new Throwable("ThreeDS SDK getVersion() RuntimeException"));
        }
    }

    public List<Warning> getWarnings() {
        return f3266g;
    }
}
