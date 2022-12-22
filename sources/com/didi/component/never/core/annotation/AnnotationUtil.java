package com.didi.component.never.core.annotation;

import com.didi.component.never.core.IComponent;
import com.didi.component.never.core.node.Node;
import com.didi.component.never.core.sender.DataSender;
import com.didi.component.never.core.sender.SenderName;
import com.didi.component_processor.annonation.ComponentName;
import com.didi.component_processor.annonation.NodeName;
import com.didi.sdk.apm.SystemUtils;
import java.lang.annotation.Annotation;

public class AnnotationUtil {

    /* renamed from: a */
    private static final String f14648a = AnnotationUtil.class.getSimpleName();

    public static String getNodeId(Class<? extends Node> cls) {
        if (cls == null) {
            SystemUtils.log(6, f14648a, "clazz is null", (Throwable) null, "com.didi.component.never.core.annotation.AnnotationUtil", 21);
            return null;
        }
        String str = "";
        for (Annotation annotation : cls.getDeclaredAnnotations()) {
            if (annotation instanceof NodeName) {
                str = ((NodeName) annotation).name();
            }
        }
        return str;
    }

    public static String getComponentName(Class<? extends IComponent> cls) {
        if (cls == null) {
            SystemUtils.log(6, f14648a, "clazz is null", (Throwable) null, "com.didi.component.never.core.annotation.AnnotationUtil", 36);
            return null;
        }
        String str = "";
        for (Annotation annotation : cls.getDeclaredAnnotations()) {
            if (annotation instanceof ComponentName) {
                str = ((ComponentName) annotation).type();
            }
        }
        return str;
    }

    public static String getSenderName(Class<? extends DataSender> cls) {
        if (cls == null) {
            SystemUtils.log(6, f14648a, "clazz is null", (Throwable) null, "com.didi.component.never.core.annotation.AnnotationUtil", 51);
            return null;
        }
        String str = "";
        for (Annotation annotation : cls.getDeclaredAnnotations()) {
            if (annotation instanceof SenderName) {
                str = ((SenderName) annotation).name();
            }
        }
        return str;
    }
}
