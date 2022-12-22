package com.cardinalcommerce.cardinalmobilesdk;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalConfigurationParameters;
import com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError;
import com.cardinalcommerce.cardinalmobilesdk.services.CardinalInitService;
import com.cardinalcommerce.cardinalmobilesdk.services.CardinalValidateReceiver;
import com.cardinalcommerce.p060a.C1990configure;
import com.cardinalcommerce.p060a.C2014init;
import com.cardinalcommerce.p060a.CardinalRenderType;
import com.cardinalcommerce.p060a.CardinalUiType;
import com.cardinalcommerce.p060a.cca_continue;
import com.cardinalcommerce.p060a.getInstance;
import com.cardinalcommerce.p060a.setBaselineAligned;
import com.cardinalcommerce.p060a.setCompoundDrawablePadding;
import com.cardinalcommerce.p060a.setCompoundDrawableTintList;
import com.cardinalcommerce.p060a.setCompoundDrawables;
import com.cardinalcommerce.p060a.setHorizontallyScrolling;
import com.cardinalcommerce.p060a.setLinkTextColor;
import com.cardinalcommerce.p060a.setMaxEms;
import com.cardinalcommerce.p060a.setProgress;
import com.cardinalcommerce.p060a.setSecondaryProgressTintBlendMode;
import com.cardinalcommerce.p060a.setShadowLayer;
import com.cardinalcommerce.p060a.setTextAppearance;
import com.cardinalcommerce.p060a.setTextCursorDrawable;
import com.cardinalcommerce.p060a.setTextSelectHandle;
import com.cardinalcommerce.p060a.setTextSize;
import com.cardinalcommerce.shared.models.Warning;
import com.cardinalcommerce.shared.models.exceptions.InvalidInputException;
import com.cardinalcommerce.shared.userinterfaces.UiCustomization;
import java.lang.ref.WeakReference;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.json.JSONException;

public class Cardinal {

    /* renamed from: a */
    private static Cardinal f3117a;

    /* renamed from: b */
    private static final Object f3118b = new Object();

    /* renamed from: c */
    private static C2014init f3119c;

    /* renamed from: d */
    private static boolean f3120d;

    public static synchronized Cardinal getInstance() {
        Cardinal cardinal;
        synchronized (Cardinal.class) {
            if (f3117a == null) {
                synchronized (f3118b) {
                    if (f3117a == null) {
                        f3117a = new Cardinal();
                        f3119c = C2014init.init();
                    }
                }
            }
            cardinal = f3117a;
        }
        return cardinal;
    }

    public void configure(Context context, CardinalConfigurationParameters cardinalConfigurationParameters) throws InvalidInputException {
        Class<Cardinal> cls = Cardinal.class;
        boolean z = true;
        boolean z2 = !getClass().getName().equals(cls.getName());
        f3120d = z2;
        C2014init init = f3119c;
        if (!getInstance.cca_continue(C2014init.CardinalError, cca_continue.Configured)) {
            CardinalRenderType cardinalRenderType = C2014init.CardinalEnvironment;
            StringBuilder sb = new StringBuilder("Error: Current State, Next state  :");
            sb.append(C2014init.CardinalError);
            sb.append(", ");
            sb.append(cca_continue.Configured);
            CardinalError cardinalError = new CardinalError(10101, sb.toString());
            cardinalRenderType.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, (String) null);
        } else if (context != null) {
            if (cardinalConfigurationParameters == null) {
                CardinalRenderType cardinalRenderType2 = C2014init.CardinalEnvironment;
                CardinalError cardinalError2 = new CardinalError(10103);
                cardinalRenderType2.configure(String.valueOf(cardinalError2.Cardinal), cardinalError2.init, (String) null);
                cardinalConfigurationParameters = new CardinalConfigurationParameters();
            }
            CardinalRenderType.cca_continue(cardinalConfigurationParameters.isEnableLogging());
            CardinalRenderType cardinalRenderType3 = C2014init.CardinalEnvironment;
            StringBuilder sb2 = new StringBuilder("SDKAppID: ");
            sb2.append(C2014init.configure(context));
            cardinalRenderType3.init("CardinalConfigure", sb2.toString());
            C2014init.CardinalError = cca_continue.Configured;
            C2014init.cca_continue = new WeakReference<>(context.getApplicationContext());
            C2014init.configure = CardinalUiType.getInstance(cardinalConfigurationParameters);
            init.CardinalRenderType = cardinalConfigurationParameters;
            if (!z2 && setLinkTextColor.getInstance(C2014init.class).equals(cls.getName())) {
                z = false;
            }
            C2014init.valueOf = z;
            C2014init.CardinalEnvironment.init("CardinalConfigure", "LASSO started");
            setProgress Cardinal = setProgress.Cardinal();
            boolean z3 = C2014init.valueOf;
            setCompoundDrawablePadding setcompounddrawablepadding = setProgress.getInstance;
            setcompounddrawablepadding.getSDKVersion = cardinalConfigurationParameters.isLocationDataConsentGiven();
            setcompounddrawablepadding.CardinalError = new setCompoundDrawables();
            setcompounddrawablepadding.cca_continue(context);
            setcompounddrawablepadding.init = new setTextSize(context);
            setcompounddrawablepadding.configure = new setCompoundDrawableTintList(context);
            C2014init.init();
            setcompounddrawablepadding.Cardinal = setHorizontallyScrolling.getInstance(C2014init.configure(setShadowLayer.cca_continue));
            setcompounddrawablepadding.cleanup = cardinalConfigurationParameters.getJSON();
            Cardinal.init = new setTextCursorDrawable(z3, context);
            setProgress.getInstance.getWarnings = Cardinal.init;
        } else {
            CardinalRenderType cardinalRenderType4 = C2014init.CardinalEnvironment;
            CardinalError cardinalError3 = new CardinalError(10102);
            cardinalRenderType4.configure(String.valueOf(cardinalError3.Cardinal), cardinalError3.init, (String) null);
            throw new InvalidInputException("InvalidInputException", new Throwable("Invalid Input Exception - Application Context"));
        }
    }

    public void init(String str, CardinalInitService cardinalInitService) throws InvalidInputException {
        C2014init init = f3119c;
        C2014init.CardinalEnvironment.init("CardinalInit", "Init started");
        if (cardinalInitService != null) {
            init.values = cardinalInitService;
            if (getInstance.cca_continue(C2014init.CardinalError, cca_continue.InitStarted)) {
                init.init(str);
                return;
            }
            CardinalRenderType cardinalRenderType = C2014init.CardinalEnvironment;
            StringBuilder sb = new StringBuilder("Error: Current State, Next state  :");
            sb.append(C2014init.CardinalError);
            sb.append(", ");
            sb.append(cca_continue.InitStarted);
            CardinalError cardinalError = new CardinalError(10201, sb.toString());
            cardinalRenderType.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, (String) null);
            init.Cardinal(new CardinalError(10201));
            return;
        }
        CardinalRenderType cardinalRenderType2 = C2014init.CardinalEnvironment;
        CardinalError cardinalError2 = new CardinalError(10203);
        cardinalRenderType2.configure(String.valueOf(cardinalError2.Cardinal), cardinalError2.init, (String) null);
        throw new InvalidInputException("InvalidInputException", new Throwable("Null CardinalInitService received on init"));
    }

    @Deprecated
    public void init(String str, String str2, CardinalInitService cardinalInitService) throws InvalidInputException {
        C2014init init = f3119c;
        if (cardinalInitService != null) {
            init.values = cardinalInitService;
            if (getInstance.cca_continue(C2014init.CardinalError, cca_continue.InitStarted)) {
                C2014init.CardinalEnvironment.init("CardinalInit", "Init started");
                init.init(str);
                return;
            }
            CardinalRenderType cardinalRenderType = C2014init.CardinalEnvironment;
            StringBuilder sb = new StringBuilder("Error: Current State, Next state  :");
            sb.append(C2014init.CardinalError);
            sb.append(", ");
            sb.append(cca_continue.InitStarted);
            CardinalError cardinalError = new CardinalError(10201, sb.toString());
            cardinalRenderType.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, (String) null);
            init.Cardinal(new CardinalError(10201));
            return;
        }
        CardinalRenderType cardinalRenderType2 = C2014init.CardinalEnvironment;
        CardinalError cardinalError2 = new CardinalError(10203);
        cardinalRenderType2.configure(String.valueOf(cardinalError2.Cardinal), cardinalError2.init, (String) null);
        throw new InvalidInputException("InvalidInputException", new Throwable("Null CardinalInitService received on init"));
    }

    public void cca_continue(String str, String str2, Activity activity, CardinalValidateReceiver cardinalValidateReceiver) throws InvalidInputException {
        C2014init init = f3119c;
        if (cardinalValidateReceiver != null) {
            init.getWarnings = cardinalValidateReceiver;
            if (!getInstance.cca_continue(C2014init.CardinalError, cca_continue.Continue)) {
                CardinalRenderType cardinalRenderType = C2014init.CardinalEnvironment;
                StringBuilder sb = new StringBuilder("Invalid Transition: An error occurred during Cardinal Init.");
                sb.append(C2014init.CardinalError);
                sb.append(", ");
                sb.append(cca_continue.Continue);
                CardinalError cardinalError = new CardinalError(10601, sb.toString());
                cardinalRenderType.configure(String.valueOf(cardinalError.Cardinal), cardinalError.init, init.cleanup.getInstance);
                init.getInstance(CardinalActionCode.ERROR, new CardinalError(10601), activity, "");
            } else if (str == null || str.isEmpty()) {
                init.getInstance(CardinalActionCode.ERROR, new CardinalError(10603), activity, "");
            } else if (str2 == null || str2.isEmpty()) {
                init.getInstance(CardinalActionCode.ERROR, new CardinalError(10604), activity, "");
            } else if (activity == null || activity.getApplicationContext() == null) {
                init.getInstance(CardinalActionCode.ERROR, new CardinalError(10609), activity, "");
            } else {
                try {
                    init.Cardinal = new WeakReference<>(activity);
                    C2014init.CardinalEnvironment.init("CardinalContinue", "Continue started with transactionID: ".concat(String.valueOf(str)), init.cleanup.getInstance);
                    setBaselineAligned setbaselinealigned = new setBaselineAligned(new String(Base64.decode(str2, 0), StandardCharsets.UTF_8));
                    if (setbaselinealigned.setRenderType.getInstance()) {
                        setTextAppearance.getInstance = false;
                        int challengeTimeout = init.CardinalRenderType.getChallengeTimeout();
                        if (C2014init.getInstance != null) {
                            C2014init.getInstance.cancel();
                        }
                        init.Cardinal.get().runOnUiThread(new Runnable(challengeTimeout) {
                            private static int cca_continue;
                            private static int getInstance;
                            private /* synthetic */ int init;

                            public final void run(
/*
Method generation error in method: com.cardinalcommerce.a.init.1.run():void, dex: classes.dex
                            jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.init.1.run():void, class status: UNLOADED
                            	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:278)
                            	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:116)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:313)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:676)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:607)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:231)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:123)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:107)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:787)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:728)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:311)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:68)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:175)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:152)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:485)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:497)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                            
*/
                        });
                        init.CardinalActionCode = new WeakReference<>(activity.getApplicationContext());
                        setTextSelectHandle cca_continue = setTextSelectHandle.cca_continue(activity.getApplicationContext());
                        setSecondaryProgressTintBlendMode setsecondaryprogresstintblendmode = setSecondaryProgressTintBlendMode.CARDINAL;
                        UiCustomization uICustomization = init.CardinalRenderType.getUICustomization();
                        C1990configure configure = init.cleanup;
                        String str3 = init.getSDKVersion;
                        String instance = CardinalUiType.getInstance(init.CardinalRenderType);
                        String threeDSRequestorAppURL = init.CardinalRenderType.getThreeDSRequestorAppURL();
                        if (setMaxEms.Cardinal == null) {
                            setMaxEms.Cardinal = new setMaxEms();
                        }
                        setMaxEms setmaxems = setMaxEms.Cardinal;
                        setmaxems.cca_continue = setsecondaryprogresstintblendmode;
                        setmaxems.init = uICustomization;
                        setmaxems.getInstance = init;
                        setmaxems.configure = configure;
                        setmaxems.getWarnings = str3;
                        setmaxems.cleanup = str;
                        setmaxems.values = instance;
                        setmaxems.getSDKVersion = threeDSRequestorAppURL;
                        cca_continue.configure.init("CardinalContinue", "UI Interaction Factory Configured", configure.getInstance);
                        com.cardinalcommerce.p060a.Cardinal.configure(setbaselinealigned, init.Cardinal.get(), init.CardinalRenderType, init.getWarnings, init.cleanup.getInstance);
                        C2014init.CardinalError = cca_continue.Continue;
                        return;
                    }
                    CardinalRenderType cardinalRenderType2 = C2014init.CardinalEnvironment;
                    CardinalError cardinalError2 = new CardinalError(10606);
                    cardinalRenderType2.configure(String.valueOf(cardinalError2.Cardinal), cardinalError2.init, init.cleanup.getInstance);
                    init.getInstance(CardinalActionCode.ERROR, new CardinalError(10606), activity, "");
                } catch (UnsupportedOperationException | JSONException e) {
                    CardinalRenderType cardinalRenderType3 = C2014init.CardinalEnvironment;
                    CardinalError cardinalError3 = new CardinalError(10610, e.getLocalizedMessage());
                    cardinalRenderType3.configure(String.valueOf(cardinalError3.Cardinal), cardinalError3.init, init.cleanup.getInstance);
                    init.getInstance(CardinalActionCode.ERROR, new CardinalError(10605), activity, "");
                }
            }
        } else {
            CardinalRenderType cardinalRenderType4 = C2014init.CardinalEnvironment;
            CardinalError cardinalError4 = new CardinalError(10602);
            cardinalRenderType4.configure(String.valueOf(cardinalError4.Cardinal), cardinalError4.init, (String) null);
            throw new InvalidInputException("InvalidInputException", new Throwable("Null CardinalValidateReceiver received on cca_continue"));
        }
    }

    public List<Warning> getWarnings() {
        return C2014init.cca_continue();
    }

    public String getSDKVersion() {
        return C2014init.getInstance();
    }

    public void cleanup() {
        C2014init init = f3119c;
        if (C2014init.cca_continue != null) {
            C2014init.cca_continue.clear();
        }
        if (init.CardinalActionCode != null) {
            init.CardinalActionCode.clear();
        }
        if (init.Cardinal != null) {
            init.Cardinal.clear();
        }
        C2014init.init = null;
        if (C2014init.getInstance != null) {
            C2014init.getInstance.cancel();
        }
        C2014init.getInstance = null;
        setProgress.Cardinal();
        if (setProgress.getInstance != null) {
            setProgress.getInstance.init();
        }
        setProgress.getInstance = null;
        setProgress.configure = null;
        f3117a = null;
        f3119c = null;
    }
}
