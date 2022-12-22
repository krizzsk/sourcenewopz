package kshark;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kshark.HeapAnalyzer;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "Lkshark/HeapAnalyzer$TrieNode$ParentNode;", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 15})
/* compiled from: HeapAnalyzer.kt */
final class HeapAnalyzer$updateTrie$childNode$1 extends Lambda implements Function0<HeapAnalyzer.TrieNode.ParentNode> {
    final /* synthetic */ long $objectId;
    final /* synthetic */ HeapAnalyzer.TrieNode.ParentNode $parentNode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HeapAnalyzer$updateTrie$childNode$1(long j, HeapAnalyzer.TrieNode.ParentNode parentNode) {
        super(0);
        this.$objectId = j;
        this.$parentNode = parentNode;
    }

    public final HeapAnalyzer.TrieNode.ParentNode invoke() {
        HeapAnalyzer.TrieNode.ParentNode parentNode = new HeapAnalyzer.TrieNode.ParentNode(this.$objectId);
        this.$parentNode.getChildren().put(Long.valueOf(this.$objectId), parentNode);
        return parentNode;
    }
}
