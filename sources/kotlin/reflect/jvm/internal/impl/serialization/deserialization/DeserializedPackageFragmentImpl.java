package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolverImpl;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerSource;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPackageMemberScope;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: DeserializedPackageFragmentImpl.kt */
public abstract class DeserializedPackageFragmentImpl extends DeserializedPackageFragment {

    /* renamed from: a */
    private final BinaryVersion f60988a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final DeserializedContainerSource f60989b;

    /* renamed from: c */
    private final NameResolverImpl f60990c;

    /* renamed from: d */
    private final ProtoBasedClassDataFinder f60991d;

    /* renamed from: e */
    private ProtoBuf.PackageFragment f60992e;

    /* renamed from: f */
    private MemberScope f60993f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor moduleDescriptor, ProtoBuf.PackageFragment packageFragment, BinaryVersion binaryVersion, DeserializedContainerSource deserializedContainerSource) {
        super(fqName, storageManager, moduleDescriptor);
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        Intrinsics.checkNotNullParameter(packageFragment, "proto");
        Intrinsics.checkNotNullParameter(binaryVersion, "metadataVersion");
        this.f60988a = binaryVersion;
        this.f60989b = deserializedContainerSource;
        ProtoBuf.StringTable strings = packageFragment.getStrings();
        Intrinsics.checkNotNullExpressionValue(strings, "proto.strings");
        ProtoBuf.QualifiedNameTable qualifiedNames = packageFragment.getQualifiedNames();
        Intrinsics.checkNotNullExpressionValue(qualifiedNames, "proto.qualifiedNames");
        NameResolverImpl nameResolverImpl = new NameResolverImpl(strings, qualifiedNames);
        this.f60990c = nameResolverImpl;
        this.f60991d = new ProtoBasedClassDataFinder(packageFragment, nameResolverImpl, this.f60988a, new DeserializedPackageFragmentImpl$classDataFinder$1(this));
        this.f60992e = packageFragment;
    }

    public ProtoBasedClassDataFinder getClassDataFinder() {
        return this.f60991d;
    }

    public void initialize(DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "components");
        ProtoBuf.PackageFragment packageFragment = this.f60992e;
        if (packageFragment != null) {
            this.f60992e = null;
            ProtoBuf.Package packageR = packageFragment.getPackage();
            Intrinsics.checkNotNullExpressionValue(packageR, "proto.`package`");
            this.f60993f = new DeserializedPackageMemberScope(this, packageR, this.f60990c, this.f60988a, this.f60989b, deserializationComponents, Intrinsics.stringPlus("scope of ", this), new DeserializedPackageFragmentImpl$initialize$1(this));
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    public MemberScope getMemberScope() {
        MemberScope memberScope = this.f60993f;
        if (memberScope != null) {
            return memberScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("_memberScope");
        return null;
    }
}
