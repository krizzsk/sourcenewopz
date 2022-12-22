package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: MemberDeserializer.kt */
final class MemberDeserializer$getPropertyFieldAnnotations$1 extends Lambda implements Function0<List<? extends AnnotationDescriptor>> {
    final /* synthetic */ boolean $isDelegate;
    final /* synthetic */ ProtoBuf.Property $proto;
    final /* synthetic */ MemberDeserializer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MemberDeserializer$getPropertyFieldAnnotations$1(MemberDeserializer memberDeserializer, boolean z, ProtoBuf.Property property) {
        super(0);
        this.this$0 = memberDeserializer;
        this.$isDelegate = z;
        this.$proto = property;
    }

    public final List<AnnotationDescriptor> invoke() {
        List<AnnotationDescriptor> list;
        MemberDeserializer memberDeserializer = this.this$0;
        ProtoContainer access$asProtoContainer = memberDeserializer.m44976a(memberDeserializer.f60998a.getContainingDeclaration());
        if (access$asProtoContainer == null) {
            list = null;
        } else {
            boolean z = this.$isDelegate;
            MemberDeserializer memberDeserializer2 = this.this$0;
            ProtoBuf.Property property = this.$proto;
            if (z) {
                list = CollectionsKt.toList(memberDeserializer2.f60998a.getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations(access$asProtoContainer, property));
            } else {
                list = CollectionsKt.toList(memberDeserializer2.f60998a.getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations(access$asProtoContainer, property));
            }
        }
        return list != null ? list : CollectionsKt.emptyList();
    }
}
