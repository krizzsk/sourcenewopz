package com.cardinalcommerce.p060a;

import android.content.Context;
import com.cardinalcommerce.cardinalmobilesdk.models.CardinalActionCode;
import com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse;
import com.cardinalcommerce.cardinalmobilesdk.p061cm.models.CardinalError;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.json.JSONException;

/* renamed from: com.cardinalcommerce.a.setTextSelectHandle */
public final class setTextSelectHandle implements CardinalError, setIndeterminateTintBlendMode {

    /* renamed from: d */
    private static int f3062d = 0;

    /* renamed from: e */
    private static int f3063e = 1;
    public static setTextSelectHandle getInstance;
    public setAutoSizeTextTypeUniformWithConfiguration Cardinal;

    /* renamed from: a */
    private String f3064a;

    /* renamed from: b */
    private setProgressBackgroundTintList f3065b;

    /* renamed from: c */
    private values f3066c;
    public final WeakReference<Context> cca_continue;
    public final setTextMetricsParams configure = setTextMetricsParams.getSDKVersion();

    private setTextSelectHandle(Context context) {
        this.cca_continue = new WeakReference<>(context.getApplicationContext());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r3 != false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        if ((getInstance == null ? 26 : '=') != '=') goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.cardinalcommerce.p060a.setTextSelectHandle cca_continue(android.content.Context r6) throws com.cardinalcommerce.shared.models.exceptions.InvalidInputException {
        /*
            java.lang.Class<com.cardinalcommerce.a.setTextSelectHandle> r0 = com.cardinalcommerce.p060a.setTextSelectHandle.class
            monitor-enter(r0)
            int r1 = f3063e     // Catch:{ all -> 0x007c }
            int r1 = r1 + 20
            r2 = 1
            int r1 = r1 - r2
            int r3 = r1 % 128
            f3062d = r3     // Catch:{ all -> 0x007c }
            int r1 = r1 % 2
            r3 = 0
            if (r1 == 0) goto L_0x0014
            r1 = 1
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x0026
            com.cardinalcommerce.a.setTextSelectHandle r1 = getInstance     // Catch:{ all -> 0x007c }
            r4 = 0
            super.hashCode()     // Catch:{ all -> 0x0024 }
            if (r1 != 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r3 = 1
        L_0x0021:
            if (r3 == 0) goto L_0x0033
            goto L_0x0066
        L_0x0024:
            r6 = move-exception
            throw r6     // Catch:{ all -> 0x007c }
        L_0x0026:
            com.cardinalcommerce.a.setTextSelectHandle r1 = getInstance     // Catch:{ all -> 0x007c }
            r3 = 61
            if (r1 != 0) goto L_0x002f
            r1 = 26
            goto L_0x0031
        L_0x002f:
            r1 = 61
        L_0x0031:
            if (r1 == r3) goto L_0x0066
        L_0x0033:
            if (r6 == 0) goto L_0x0057
            com.cardinalcommerce.a.setTextSelectHandle r1 = new com.cardinalcommerce.a.setTextSelectHandle     // Catch:{ all -> 0x007c }
            android.content.Context r6 = r6.getApplicationContext()     // Catch:{ all -> 0x007c }
            r1.<init>(r6)     // Catch:{ all -> 0x007c }
            getInstance = r1     // Catch:{ all -> 0x007c }
            int r6 = f3063e     // Catch:{ all -> 0x007c }
            r1 = r6 & -112(0xffffffffffffff90, float:NaN)
            int r3 = ~r6     // Catch:{ all -> 0x007c }
            r3 = r3 & 111(0x6f, float:1.56E-43)
            r1 = r1 | r3
            r6 = r6 & 111(0x6f, float:1.56E-43)
            int r6 = r6 << r2
            r3 = r1 ^ r6
            r6 = r6 & r1
            int r6 = r6 << r2
            int r3 = r3 + r6
            int r6 = r3 % 128
            f3062d = r6     // Catch:{ all -> 0x007c }
            int r3 = r3 % 2
            goto L_0x0066
        L_0x0057:
            java.lang.Throwable r6 = new java.lang.Throwable     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "Caught in UIInteractionFactory getInstance(), null Context passed"
            r6.<init>(r1)     // Catch:{ all -> 0x007c }
            com.cardinalcommerce.shared.models.exceptions.InvalidInputException r1 = new com.cardinalcommerce.shared.models.exceptions.InvalidInputException     // Catch:{ all -> 0x007c }
            java.lang.String r2 = "InvalidInputException"
            r1.<init>(r2, r6)     // Catch:{ all -> 0x007c }
            throw r1     // Catch:{ all -> 0x007c }
        L_0x0066:
            com.cardinalcommerce.a.setTextSelectHandle r6 = getInstance     // Catch:{ all -> 0x007c }
            int r1 = f3062d     // Catch:{ all -> 0x007c }
            r3 = 87
            r4 = r1 & -88
            int r5 = ~r1     // Catch:{ all -> 0x007c }
            r5 = r5 & r3
            r4 = r4 | r5
            r1 = r1 & r3
            int r1 = r1 << r2
            int r4 = r4 + r1
            int r1 = r4 % 128
            f3063e = r1     // Catch:{ all -> 0x007c }
            int r4 = r4 % 2
            monitor-exit(r0)
            return r6
        L_0x007c:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextSelectHandle.cca_continue(android.content.Context):com.cardinalcommerce.a.setTextSelectHandle");
    }

    public final void cca_continue(setTypeface settypeface, setAutoSizeTextTypeUniformWithConfiguration setautosizetexttypeuniformwithconfiguration, String str) {
        this.Cardinal = setautosizetexttypeuniformwithconfiguration;
        this.f3064a = str;
        if (setMaxEms.Cardinal == null) {
            setMaxEms.Cardinal = new setMaxEms();
        }
        if (setMaxEms.Cardinal.cca_continue == setSecondaryProgressTintBlendMode.EMVCO) {
            this.configure.init("EMVCoDoChallenge", "UI Interaction Factory sendUserResponse EMVCo", (String) null);
            try {
                this.f3065b = new setProgressBackgroundTintList(this, settypeface);
            } catch (JSONException e) {
                setTextMetricsParams settextmetricsparams = this.configure;
                StringBuilder sb = new StringBuilder("Error while creating new ChallengeTask \n");
                sb.append(e.getLocalizedMessage());
                settextmetricsparams.configure("11417", sb.toString(), (String) null);
                configure("", new setSecondaryProgressTintMode());
            }
            setProgressBackgroundTintList setprogressbackgroundtintlist = this.f3065b;
            if (setprogressbackgroundtintlist != null) {
                setprogressbackgroundtintlist.configure();
                setprogressbackgroundtintlist.getSDKVersion.execute(new Runnable() {
                    private static int Cardinal;
                    private static int configure;

                    /*  JADX ERROR: Method generation error
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
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
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                    /*  JADX ERROR: Method generation error: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                        jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
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
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                    public final void run(
/*
Method generation error in method: com.cardinalcommerce.a.setKeyListener.4.run():void, dex: classes.dex
                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
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
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                this.configure.init("EMVCoDoChallenge", "Challenge Task started 02", (String) null);
                return;
            }
            return;
        }
        setTextMetricsParams settextmetricsparams2 = this.configure;
        if (setMaxEms.Cardinal == null) {
            setMaxEms.Cardinal = new setMaxEms();
        }
        settextmetricsparams2.init("CardinalContinue", "UI Interaction Factory sendUserResponse", setMaxEms.Cardinal.configure.getInstance);
        if (this.cca_continue.get() != null) {
            if (settypeface == null) {
                ValidateResponse validateResponse = new ValidateResponse(CardinalActionCode.ERROR, new CardinalError(10713));
                if (this.cca_continue.get() != null) {
                    if (setMaxEms.Cardinal == null) {
                        setMaxEms.Cardinal = new setMaxEms();
                    }
                    setMaxEms.Cardinal.getInstance.init(validateResponse, "");
                }
            } else {
                if (setMaxEms.Cardinal == null) {
                    setMaxEms.Cardinal = new setMaxEms();
                }
                if (setMaxEms.Cardinal.configure != null) {
                    if (setMaxEms.Cardinal == null) {
                        setMaxEms.Cardinal = new setMaxEms();
                    }
                    if (setMaxEms.Cardinal.configure.getInstance != null) {
                        if (setMaxEms.Cardinal == null) {
                            setMaxEms.Cardinal = new setMaxEms();
                        }
                        String str2 = setMaxEms.Cardinal.configure.getInstance;
                        this.configure.init("CardinalContinue", "In Stepup user Input. SessionId : ".concat(String.valueOf(str2)), str2);
                        if (settypeface.getInstance.getInstance()) {
                            if (setMaxEms.Cardinal == null) {
                                setMaxEms.Cardinal = new setMaxEms();
                            }
                            settypeface.CardinalRenderType = setHorizontallyScrolling.getInstance(setMaxEms.Cardinal.getWarnings);
                            settypeface.getWarnings = setHorizontallyScrolling.getInstance(str2);
                            if (setMaxEms.Cardinal == null) {
                                setMaxEms.Cardinal = new setMaxEms();
                            }
                            settypeface.values = setHorizontallyScrolling.getInstance(setMaxEms.Cardinal.cleanup);
                            if (setMaxEms.Cardinal == null) {
                                setMaxEms.Cardinal = new setMaxEms();
                            }
                            if (!setMaxEms.Cardinal.getSDKVersion.equals("")) {
                                if (setMaxEms.Cardinal == null) {
                                    setMaxEms.Cardinal = new setMaxEms();
                                }
                                settypeface.getSDKVersion = setHorizontallyScrolling.getInstance(setMaxEms.Cardinal.getSDKVersion);
                            }
                            if (setMaxEms.Cardinal == null) {
                                setMaxEms.Cardinal = new setMaxEms();
                            }
                            values values = new values(settypeface, this, setMaxEms.Cardinal.values);
                            this.f3066c = values;
                            values.configure();
                            values.getSDKVersion.execute(new Runnable() {
                                private static int Cardinal;
                                private static int configure;

                                /*  JADX ERROR: Method generation error
                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
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
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                                /*  JADX ERROR: Method generation error: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
                                    jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
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
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                                public final void run(
/*
Method generation error in method: com.cardinalcommerce.a.setKeyListener.4.run():void, dex: classes.dex
                                jadx.core.utils.exceptions.JadxRuntimeException: Method args not loaded: com.cardinalcommerce.a.setKeyListener.4.run():void, class status: UNLOADED
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
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:156)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
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
                        } else {
                            ValidateResponse validateResponse2 = new ValidateResponse(CardinalActionCode.ERROR, new CardinalError(10703));
                            if (this.cca_continue.get() != null) {
                                if (setMaxEms.Cardinal == null) {
                                    setMaxEms.Cardinal = new setMaxEms();
                                }
                                setMaxEms.Cardinal.getInstance.init(validateResponse2, "");
                            }
                        }
                    } else {
                        this.configure.configure("10711", "Internal Error", (String) null);
                        ValidateResponse validateResponse3 = new ValidateResponse(CardinalActionCode.ERROR, new CardinalError(10711));
                        if (this.cca_continue.get() != null) {
                            if (setMaxEms.Cardinal == null) {
                                setMaxEms.Cardinal = new setMaxEms();
                            }
                            setMaxEms.Cardinal.getInstance.init(validateResponse3, "");
                        }
                    }
                } else {
                    ValidateResponse validateResponse4 = new ValidateResponse(CardinalActionCode.ERROR, new CardinalError(10711));
                    if (this.cca_continue.get() != null) {
                        if (setMaxEms.Cardinal == null) {
                            setMaxEms.Cardinal = new setMaxEms();
                        }
                        setMaxEms.Cardinal.getInstance.init(validateResponse4, "");
                    }
                }
            }
        }
        if (setHorizontallyScrolling.init(settypeface.init())) {
            return;
        }
        if (Arrays.equals(settypeface.init(), setHeight.getWarnings) || Arrays.equals(settypeface.init(), setHeight.cleanup)) {
            setautosizetexttypeuniformwithconfiguration.Cardinal();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if ((!r7.getWarnings.equalsIgnoreCase("N")) != true) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        if ((r0) != false) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cca_continue(com.cardinalcommerce.p060a.setBaselineAligned r7) {
        /*
            r6 = this;
            int r0 = f3062d
            r1 = r0 ^ 17
            r0 = r0 & 17
            r2 = 1
            int r0 = r0 << r2
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3063e = r0
            int r1 = r1 % 2
            java.lang.String r0 = r7.init
            java.lang.String r1 = r6.f3064a
            boolean r0 = r0.equalsIgnoreCase(r1)
            r1 = 0
            if (r0 == 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            if (r0 == r2) goto L_0x0020
            goto L_0x0075
        L_0x0020:
            int r0 = f3063e
            r3 = r0 | 87
            int r3 = r3 << r2
            r0 = r0 ^ 87
            int r3 = r3 - r0
            int r0 = r3 % 128
            f3062d = r0
            int r3 = r3 % 2
            r0 = 16
            if (r3 == 0) goto L_0x0035
            r3 = 16
            goto L_0x0037
        L_0x0035:
            r3 = 41
        L_0x0037:
            java.lang.String r4 = "N"
            if (r3 == r0) goto L_0x0049
            java.lang.String r0 = r7.getWarnings
            boolean r0 = r0.equalsIgnoreCase(r4)
            if (r0 == 0) goto L_0x0045
            r0 = 0
            goto L_0x0046
        L_0x0045:
            r0 = 1
        L_0x0046:
            if (r0 == r2) goto L_0x0075
            goto L_0x0058
        L_0x0049:
            java.lang.String r0 = r7.getWarnings
            boolean r0 = r0.equalsIgnoreCase(r4)
            r3 = 0
            int r3 = r3.length     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x0055
            r0 = 1
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            if (r0 == 0) goto L_0x0075
        L_0x0058:
            com.cardinalcommerce.a.setAutoSizeTextTypeUniformWithConfiguration r0 = r6.Cardinal
            r0.configure(r7)
            int r7 = f3062d
            int r7 = r7 + 85
            int r0 = r7 % 128
            f3063e = r0
            int r7 = r7 % 2
            if (r7 != 0) goto L_0x006b
            r7 = 1
            goto L_0x006c
        L_0x006b:
            r7 = 0
        L_0x006c:
            if (r7 == r2) goto L_0x006f
            return
        L_0x006f:
            r7 = 95
            int r7 = r7 / r1
            return
        L_0x0073:
            r7 = move-exception
            throw r7
        L_0x0075:
            java.lang.ref.WeakReference<android.content.Context> r0 = r6.cca_continue
            java.lang.Object r0 = r0.get()
            android.content.Context r0 = (android.content.Context) r0
            com.cardinalcommerce.a.setMaxEms r3 = com.cardinalcommerce.p060a.setMaxEms.Cardinal
            if (r3 != 0) goto L_0x009b
            com.cardinalcommerce.a.setMaxEms r3 = new com.cardinalcommerce.a.setMaxEms
            r3.<init>()
            com.cardinalcommerce.p060a.setMaxEms.Cardinal = r3
            int r3 = f3063e
            r4 = r3 & 5
            r3 = r3 ^ 5
            r3 = r3 | r4
            int r3 = -r3
            int r3 = -r3
            r5 = r4 & r3
            r3 = r3 | r4
            int r5 = r5 + r3
            int r3 = r5 % 128
            f3062d = r3
            int r5 = r5 % 2
        L_0x009b:
            com.cardinalcommerce.a.setMaxEms r3 = com.cardinalcommerce.p060a.setMaxEms.Cardinal
            com.cardinalcommerce.shared.userinterfaces.UiCustomization r3 = r3.init
            com.cardinalcommerce.p060a.setTextAppearance.getInstance(r7, r0, r3)
            int r7 = f3063e
            r0 = r7 & 92
            r7 = r7 | 92
            int r0 = r0 + r7
            int r0 = r0 - r1
            int r0 = r0 - r2
            int r7 = r0 % 128
            f3062d = r7
            int r0 = r0 % 2
            r7 = 19
            if (r0 == 0) goto L_0x00b8
            r0 = 19
            goto L_0x00ba
        L_0x00b8:
            r0 = 12
        L_0x00ba:
            if (r0 == r7) goto L_0x00bd
            return
        L_0x00bd:
            r7 = 57
            int r7 = r7 / r1
            return
        L_0x00c1:
            r7 = move-exception
            throw r7
        L_0x00c3:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextSelectHandle.cca_continue(com.cardinalcommerce.a.setBaselineAligned):void");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.os.CountDownTimer, java.lang.Object] */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
        if ((r2 != null ? org.bouncycastle.pqc.math.linearalgebra.Matrix.MATRIX_TYPE_ZERO : '$') != 'Z') goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
        if ((com.cardinalcommerce.p060a.setProgressTintBlendMode.configure != null ? 'J' : '7') != '7') goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void configure(java.lang.String r8, com.cardinalcommerce.p060a.setSecondaryProgressTintMode r9) {
        /*
            r7 = this;
            int r0 = f3063e
            int r0 = r0 + 72
            r1 = r0 & -1
            r0 = r0 | -1
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3062d = r0
            int r1 = r1 % 2
            r0 = 62
            r2 = 38
            if (r1 == 0) goto L_0x0018
            r1 = 62
            goto L_0x001a
        L_0x0018:
            r1 = 38
        L_0x001a:
            r3 = 0
            if (r1 == r2) goto L_0x0035
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r1 = com.cardinalcommerce.p060a.setProgressTintBlendMode.init
            com.cardinalcommerce.p060a.setProgressTintBlendMode.cca_continue()
            android.os.CountDownTimer r2 = com.cardinalcommerce.p060a.setProgressTintBlendMode.configure
            super.hashCode()     // Catch:{ all -> 0x0033 }
            r4 = 90
            if (r2 == 0) goto L_0x002e
            r2 = 90
            goto L_0x0030
        L_0x002e:
            r2 = 36
        L_0x0030:
            if (r2 == r4) goto L_0x0047
            goto L_0x005b
        L_0x0033:
            r8 = move-exception
            throw r8
        L_0x0035:
            com.cardinalcommerce.emvco.services.ChallengeStatusReceiver r1 = com.cardinalcommerce.p060a.setProgressTintBlendMode.init
            com.cardinalcommerce.p060a.setProgressTintBlendMode.cca_continue()
            android.os.CountDownTimer r2 = com.cardinalcommerce.p060a.setProgressTintBlendMode.configure
            r4 = 55
            if (r2 == 0) goto L_0x0043
            r2 = 74
            goto L_0x0045
        L_0x0043:
            r2 = 55
        L_0x0045:
            if (r2 == r4) goto L_0x005b
        L_0x0047:
            android.os.CountDownTimer r2 = com.cardinalcommerce.p060a.setProgressTintBlendMode.configure
            r2.cancel()
            com.cardinalcommerce.p060a.setProgressTintBlendMode.configure = r3
            int r2 = f3063e
            r4 = r2 & 71
            r2 = r2 | 71
            int r4 = r4 + r2
            int r2 = r4 % 128
            f3062d = r2
            int r4 = r4 % 2
        L_0x005b:
            java.lang.String r2 = "ProtocolError"
            boolean r2 = java.util.Objects.equals(r8, r2)
            r4 = 28
            if (r2 == 0) goto L_0x0068
            r2 = 66
            goto L_0x006a
        L_0x0068:
            r2 = 28
        L_0x006a:
            r5 = 0
            r6 = 1
            if (r2 == r4) goto L_0x00a2
            int r8 = f3062d
            int r8 = r8 + 79
            int r0 = r8 % 128
            f3063e = r0
            int r8 = r8 % 2
            if (r8 != 0) goto L_0x007b
            r5 = 1
        L_0x007b:
            if (r5 == 0) goto L_0x0088
            com.cardinalcommerce.emvco.events.ProtocolErrorEvent r9 = (com.cardinalcommerce.emvco.events.ProtocolErrorEvent) r9
            r1.protocolError(r9)
            super.hashCode()     // Catch:{ all -> 0x0086 }
            goto L_0x008d
        L_0x0086:
            r8 = move-exception
            throw r8
        L_0x0088:
            com.cardinalcommerce.emvco.events.ProtocolErrorEvent r9 = (com.cardinalcommerce.emvco.events.ProtocolErrorEvent) r9
            r1.protocolError(r9)
        L_0x008d:
            int r8 = f3062d
            r9 = r8 | 97
            int r9 = r9 << r6
            r8 = r8 ^ 97
            int r8 = -r8
            r0 = r9 ^ r8
            r8 = r8 & r9
            int r8 = r8 << r6
            int r0 = r0 + r8
            int r8 = r0 % 128
            f3063e = r8
        L_0x009e:
            int r0 = r0 % 2
            goto L_0x0180
        L_0x00a2:
            java.lang.String r2 = "RunTimeError"
            boolean r2 = java.util.Objects.equals(r8, r2)
            if (r2 == 0) goto L_0x00ac
            r2 = 0
            goto L_0x00ad
        L_0x00ac:
            r2 = 1
        L_0x00ad:
            if (r2 == 0) goto L_0x0147
            java.lang.String r9 = "TimeOutError"
            boolean r9 = java.util.Objects.equals(r8, r9)
            r2 = 3
            if (r9 == 0) goto L_0x00b9
            r0 = 3
        L_0x00b9:
            if (r0 == r2) goto L_0x0110
            java.lang.String r9 = "CancelTimeout"
            boolean r8 = java.util.Objects.equals(r8, r9)
            r9 = 84
            if (r8 == 0) goto L_0x00c8
            r8 = 84
            goto L_0x00ca
        L_0x00c8:
            r8 = 96
        L_0x00ca:
            if (r8 == r9) goto L_0x00ce
            goto L_0x0180
        L_0x00ce:
            int r8 = f3062d
            int r8 = r8 + 59
            int r8 = r8 - r6
            r9 = r8 & -1
            r8 = r8 | -1
            int r9 = r9 + r8
            int r8 = r9 % 128
            f3063e = r8
            int r9 = r9 % 2
            com.cardinalcommerce.a.setMaxEms r8 = com.cardinalcommerce.p060a.setMaxEms.Cardinal
            if (r8 != 0) goto L_0x00f9
            com.cardinalcommerce.a.setMaxEms r8 = new com.cardinalcommerce.a.setMaxEms
            r8.<init>()
            com.cardinalcommerce.p060a.setMaxEms.Cardinal = r8
            int r8 = f3062d
            r9 = r8 & 3
            r8 = r8 | r2
            r0 = r9 | r8
            int r0 = r0 << r6
            r8 = r8 ^ r9
            int r0 = r0 - r8
            int r8 = r0 % 128
            f3063e = r8
            int r0 = r0 % 2
        L_0x00f9:
            com.cardinalcommerce.a.setSecondaryProgressTintBlendMode r8 = com.cardinalcommerce.p060a.setSecondaryProgressTintBlendMode.EMVCO
            r1.cancelled()
            int r8 = f3063e
            r9 = r8 & 21
            r8 = r8 | 21
            r0 = r9 & r8
            r8 = r8 | r9
            int r0 = r0 + r8
            int r8 = r0 % 128
            f3062d = r8
            int r0 = r0 % 2
            goto L_0x0180
        L_0x0110:
            int r8 = f3062d
            r9 = r8 | 2
            int r9 = r9 << r6
            r8 = r8 ^ 2
            int r9 = r9 - r8
            int r9 = r9 - r5
            int r9 = r9 - r6
            int r8 = r9 % 128
            f3063e = r8
            int r9 = r9 % 2
            r8 = 45
            if (r9 != 0) goto L_0x0127
            r9 = 45
            goto L_0x0128
        L_0x0127:
            r9 = 6
        L_0x0128:
            r1.timedout()
            if (r9 == r8) goto L_0x012e
            goto L_0x012f
        L_0x012e:
            int r8 = r3.length     // Catch:{ all -> 0x0145 }
        L_0x012f:
            int r8 = f3063e
            r9 = r8 | 25
            int r0 = r9 << 1
            r8 = r8 & 25
            int r8 = ~r8
            r8 = r8 & r9
            int r8 = -r8
            r9 = r0 & r8
            r8 = r8 | r0
            int r9 = r9 + r8
            int r8 = r9 % 128
            f3062d = r8
            int r9 = r9 % 2
            goto L_0x0180
        L_0x0145:
            r8 = move-exception
            throw r8
        L_0x0147:
            int r8 = f3062d
            r0 = r8 & 121(0x79, float:1.7E-43)
            r8 = r8 ^ 121(0x79, float:1.7E-43)
            r8 = r8 | r0
            int r8 = ~r8
            int r0 = r0 - r8
            int r0 = r0 - r6
            int r8 = r0 % 128
            f3063e = r8
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x015b
            r8 = 1
            goto L_0x015c
        L_0x015b:
            r8 = 0
        L_0x015c:
            if (r8 == 0) goto L_0x0168
            com.cardinalcommerce.emvco.events.RuntimeErrorEvent r9 = (com.cardinalcommerce.emvco.events.RuntimeErrorEvent) r9
            r1.runtimeError(r9)
            r8 = 7
            int r8 = r8 / r5
            goto L_0x016d
        L_0x0166:
            r8 = move-exception
            throw r8
        L_0x0168:
            com.cardinalcommerce.emvco.events.RuntimeErrorEvent r9 = (com.cardinalcommerce.emvco.events.RuntimeErrorEvent) r9
            r1.runtimeError(r9)
        L_0x016d:
            int r8 = f3063e
            r9 = r8 | 23
            int r9 = r9 << r6
            r8 = r8 ^ 23
            int r8 = -r8
            r0 = r9 | r8
            int r0 = r0 << r6
            r8 = r8 ^ r9
            int r0 = r0 - r8
            int r8 = r0 % 128
            f3062d = r8
            goto L_0x009e
        L_0x0180:
            com.cardinalcommerce.a.setAutoSizeTextTypeUniformWithConfiguration r8 = r7.Cardinal
            r8.Cardinal()
            int r8 = f3063e
            r9 = 111(0x6f, float:1.56E-43)
            r0 = r8 & -112(0xffffffffffffff90, float:NaN)
            int r1 = ~r8
            r1 = r1 & r9
            r0 = r0 | r1
            r8 = r8 & r9
            int r8 = r8 << r6
            int r8 = ~r8
            int r0 = r0 - r8
            int r0 = r0 - r6
            int r8 = r0 % 128
            f3062d = r8
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextSelectHandle.configure(java.lang.String, com.cardinalcommerce.a.setSecondaryProgressTintMode):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        if (r0 != true) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
        if ((r4.Cardinal != null ? 5 : '=') != 5) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cca_continue(com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse r5, java.lang.String r6) {
        /*
            r4 = this;
            int r0 = f3062d
            r1 = r0 ^ 9
            r2 = r0 & 9
            r1 = r1 | r2
            r2 = 1
            int r1 = r1 << r2
            r3 = r0 & -10
            int r0 = ~r0
            r0 = r0 & 9
            r0 = r0 | r3
            int r0 = -r0
            r3 = r1 | r0
            int r3 = r3 << r2
            r0 = r0 ^ r1
            int r3 = r3 - r0
            int r0 = r3 % 128
            f3063e = r0
            int r3 = r3 % 2
            r0 = 0
            if (r3 != 0) goto L_0x0020
            r1 = 1
            goto L_0x0021
        L_0x0020:
            r1 = 0
        L_0x0021:
            r3 = 0
            if (r1 == 0) goto L_0x0031
            com.cardinalcommerce.a.setAutoSizeTextTypeUniformWithConfiguration r1 = r4.Cardinal
            super.hashCode()     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x002c
            r0 = 1
        L_0x002c:
            if (r0 == r2) goto L_0x003d
            goto L_0x004f
        L_0x002f:
            r5 = move-exception
            throw r5
        L_0x0031:
            com.cardinalcommerce.a.setAutoSizeTextTypeUniformWithConfiguration r0 = r4.Cardinal
            r1 = 5
            if (r0 == 0) goto L_0x0038
            r0 = 5
            goto L_0x003a
        L_0x0038:
            r0 = 61
        L_0x003a:
            if (r0 == r1) goto L_0x003d
            goto L_0x004f
        L_0x003d:
            com.cardinalcommerce.a.setAutoSizeTextTypeUniformWithConfiguration r0 = r4.Cardinal
            r0.Cardinal()
            int r0 = f3063e
            r1 = r0 & 99
            r0 = r0 | 99
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3062d = r0
            int r1 = r1 % 2
        L_0x004f:
            com.cardinalcommerce.a.setMaxEms r0 = com.cardinalcommerce.p060a.setMaxEms.Cardinal
            if (r0 != 0) goto L_0x0067
            com.cardinalcommerce.a.setMaxEms r0 = new com.cardinalcommerce.a.setMaxEms
            r0.<init>()
            com.cardinalcommerce.p060a.setMaxEms.Cardinal = r0
            int r0 = f3063e
            r1 = r0 & 65
            r0 = r0 | 65
            int r1 = r1 + r0
            int r0 = r1 % 128
            f3062d = r0
            int r1 = r1 % 2
        L_0x0067:
            com.cardinalcommerce.a.setMaxEms r0 = com.cardinalcommerce.p060a.setMaxEms.Cardinal
            com.cardinalcommerce.a.getWarnings r0 = r0.getInstance
            r0.init(r5, r6)
            int r5 = f3062d
            r6 = r5 ^ 47
            r5 = r5 & 47
            r5 = r5 | r6
            int r5 = r5 << r2
            int r6 = -r6
            int r6 = ~r6
            int r5 = r5 - r6
            int r5 = r5 - r2
            int r6 = r5 % 128
            f3063e = r6
            int r5 = r5 % 2
            r6 = 85
            if (r5 != 0) goto L_0x0087
            r5 = 52
            goto L_0x0089
        L_0x0087:
            r5 = 85
        L_0x0089:
            if (r5 == r6) goto L_0x008f
            int r5 = r3.length     // Catch:{ all -> 0x008d }
            return
        L_0x008d:
            r5 = move-exception
            throw r5
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextSelectHandle.cca_continue(com.cardinalcommerce.cardinalmobilesdk.models.ValidateResponse, java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        if ((r1 != null ? 16 : org.apache.commons.p071io.IOUtils.DIR_SEPARATOR_UNIX) != '/') goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if ((r7.f3065b != null ? '`' : '6') != '`') goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void configure() {
        /*
            r7 = this;
            int r0 = f3062d
            r1 = r0 & 109(0x6d, float:1.53E-43)
            r0 = r0 ^ 109(0x6d, float:1.53E-43)
            r0 = r0 | r1
            int r0 = -r0
            int r0 = -r0
            int r0 = ~r0
            int r1 = r1 - r0
            r0 = 1
            int r1 = r1 - r0
            int r2 = r1 % 128
            f3063e = r2
            int r1 = r1 % 2
            r2 = 0
            if (r1 != 0) goto L_0x0018
            r1 = 0
            goto L_0x0019
        L_0x0018:
            r1 = 1
        L_0x0019:
            r3 = 0
            if (r1 == r0) goto L_0x002d
            com.cardinalcommerce.a.setProgressBackgroundTintList r1 = r7.f3065b
            int r4 = r3.length     // Catch:{ all -> 0x002b }
            r4 = 47
            if (r1 == 0) goto L_0x0026
            r1 = 16
            goto L_0x0028
        L_0x0026:
            r1 = 47
        L_0x0028:
            if (r1 == r4) goto L_0x0058
            goto L_0x003b
        L_0x002b:
            r0 = move-exception
            throw r0
        L_0x002d:
            com.cardinalcommerce.a.setProgressBackgroundTintList r1 = r7.f3065b
            r4 = 96
            if (r1 == 0) goto L_0x0036
            r1 = 96
            goto L_0x0038
        L_0x0036:
            r1 = 54
        L_0x0038:
            if (r1 == r4) goto L_0x003b
            goto L_0x0058
        L_0x003b:
            com.cardinalcommerce.a.setProgressBackgroundTintList r1 = r7.f3065b
            java.util.concurrent.ExecutorService r1 = r1.getSDKVersion
            r1.shutdownNow()
            int r1 = f3063e
            r4 = 97
            r5 = r1 ^ 97
            r6 = r1 & 97
            r5 = r5 | r6
            int r5 = r5 << r0
            r6 = r1 & -98
            int r1 = ~r1
            r1 = r1 & r4
            r1 = r1 | r6
            int r5 = r5 - r1
            int r1 = r5 % 128
            f3062d = r1
            int r5 = r5 % 2
        L_0x0058:
            com.cardinalcommerce.a.values r1 = r7.f3066c
            if (r1 == 0) goto L_0x005e
            r1 = 0
            goto L_0x005f
        L_0x005e:
            r1 = 1
        L_0x005f:
            if (r1 == 0) goto L_0x0062
            goto L_0x00a9
        L_0x0062:
            int r1 = f3063e
            r4 = 33
            r5 = r1 ^ 33
            r6 = r1 & 33
            r5 = r5 | r6
            int r5 = r5 << r0
            r6 = r1 & -34
            int r1 = ~r1
            r1 = r1 & r4
            r1 = r1 | r6
            int r1 = -r1
            r4 = r5 | r1
            int r4 = r4 << r0
            r1 = r1 ^ r5
            int r4 = r4 - r1
            int r1 = r4 % 128
            f3062d = r1
            int r4 = r4 % 2
            r1 = 82
            if (r4 == 0) goto L_0x0084
            r4 = 86
            goto L_0x0086
        L_0x0084:
            r4 = 82
        L_0x0086:
            if (r4 == r1) goto L_0x0094
            com.cardinalcommerce.a.values r1 = r7.f3066c
            java.util.concurrent.ExecutorService r1 = r1.getSDKVersion
            r1.shutdownNow()
            r1 = 4
            int r1 = r1 / r2
            goto L_0x009b
        L_0x0092:
            r0 = move-exception
            throw r0
        L_0x0094:
            com.cardinalcommerce.a.values r1 = r7.f3066c
            java.util.concurrent.ExecutorService r1 = r1.getSDKVersion
            r1.shutdownNow()
        L_0x009b:
            int r1 = f3063e
            r2 = r1 ^ 63
            r1 = r1 & 63
            int r1 = r1 << r0
            int r2 = r2 + r1
            int r1 = r2 % 128
            f3062d = r1
            int r2 = r2 % 2
        L_0x00a9:
            int r1 = f3063e
            r2 = r1 & 79
            r1 = r1 ^ 79
            r1 = r1 | r2
            int r1 = -r1
            int r1 = -r1
            int r1 = ~r1
            int r2 = r2 - r1
            int r2 = r2 - r0
            int r0 = r2 % 128
            f3062d = r0
            int r2 = r2 % 2
            r0 = 17
            if (r2 == 0) goto L_0x00c2
            r1 = 93
            goto L_0x00c4
        L_0x00c2:
            r1 = 17
        L_0x00c4:
            if (r1 == r0) goto L_0x00ca
            int r0 = r3.length     // Catch:{ all -> 0x00c8 }
            return
        L_0x00c8:
            r0 = move-exception
            throw r0
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cardinalcommerce.p060a.setTextSelectHandle.configure():void");
    }
}
