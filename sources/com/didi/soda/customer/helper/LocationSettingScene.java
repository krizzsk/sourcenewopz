package com.didi.soda.customer.helper;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION})
@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, mo175978d2 = {"Lcom/didi/soda/customer/helper/LocationSettingScene;", "", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Retention(RetentionPolicy.SOURCE)
/* compiled from: CustomerLocationSettingHelper.kt */
public @interface LocationSettingScene {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int Default = 0;
    public static final int FromAddressList = 5;
    public static final int FromNoAddress = 4;
    public static final int FromNoLocationPermission = 2;
    public static final int FromNoLocationService = 3;
    public static final int FromSplash = 1;

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/helper/LocationSettingScene$Companion;", "", "()V", "Default", "", "FromAddressList", "FromNoAddress", "FromNoLocationPermission", "FromNoLocationService", "FromSplash", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CustomerLocationSettingHelper.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int Default = 0;
        public static final int FromAddressList = 5;
        public static final int FromNoAddress = 4;
        public static final int FromNoLocationPermission = 2;
        public static final int FromNoLocationService = 3;
        public static final int FromSplash = 1;

        private Companion() {
        }
    }
}
