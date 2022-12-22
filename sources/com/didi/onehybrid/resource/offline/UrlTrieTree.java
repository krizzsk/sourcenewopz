package com.didi.onehybrid.resource.offline;

import android.net.Uri;
import com.didi.hawaii.mapsdkv2.HWMapConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class UrlTrieTree {
    private static final Object SYN = new Object();
    private TrieNode root;

    private class TrieNode {
        public ArrayList<TrieNode> children;
        /* access modifiers changed from: private */
        public String localPath;
        /* access modifiers changed from: private */
        public OfflineBundle offlineBundleInfo;
        public String trieNode;

        private TrieNode() {
        }
    }

    public UrlTrieTree() {
        TrieNode trieNode = new TrieNode();
        this.root = trieNode;
        trieNode.trieNode = "root";
        this.root.children = new ArrayList<>();
    }

    private Queue<String> parserUrl(String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        List<String> pathSegments = parse.getPathSegments();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.add(scheme);
        linkedBlockingDeque.add(host);
        for (String add : pathSegments) {
            linkedBlockingDeque.add(add);
        }
        return linkedBlockingDeque;
    }

    public static String getPureUrl(String str) {
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        String host = parse.getHost();
        List<String> pathSegments = parse.getPathSegments();
        StringBuilder sb = new StringBuilder();
        sb.append(scheme);
        sb.append(HWMapConstant.HTTP.SEPARATOR);
        sb.append(host);
        sb.append("/");
        for (String append : pathSegments) {
            sb.append(append);
            sb.append("/");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    private TrieNode IsInTree(TrieNode trieNode, String str) {
        if (trieNode.trieNode.equals(str)) {
            return trieNode;
        }
        Iterator<TrieNode> it = trieNode.children.iterator();
        while (it.hasNext()) {
            TrieNode next = it.next();
            if (next.trieNode.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void addNode(String str, String str2) {
        synchronized (SYN) {
            TrieNode trieNode = this.root;
            Queue<String> parserUrl = parserUrl(str);
            do {
                String poll = parserUrl.poll();
                TrieNode IsInTree = IsInTree(trieNode, poll);
                if (IsInTree == null) {
                    IsInTree = new TrieNode();
                    IsInTree.trieNode = poll;
                    if (parserUrl.size() != 0) {
                        IsInTree.children = new ArrayList<>();
                    } else {
                        String unused = IsInTree.localPath = str2;
                    }
                    trieNode.children.add(IsInTree);
                }
                trieNode = IsInTree;
            } while (parserUrl.size() > 0);
        }
    }

    public void addNode(String str, OfflineBundle offlineBundle) {
        synchronized (SYN) {
            TrieNode trieNode = this.root;
            Queue<String> parserUrl = parserUrl(str);
            do {
                String poll = parserUrl.poll();
                TrieNode IsInTree = IsInTree(trieNode, poll);
                if (IsInTree == null) {
                    IsInTree = new TrieNode();
                    IsInTree.trieNode = poll;
                    if (parserUrl.size() != 0) {
                        IsInTree.children = new ArrayList<>();
                    } else {
                        OfflineBundle unused = IsInTree.offlineBundleInfo = offlineBundle;
                    }
                    trieNode.children.add(IsInTree);
                }
                trieNode = IsInTree;
            } while (parserUrl.size() > 0);
        }
    }

    public String searchUrl(String str) {
        synchronized (SYN) {
            Queue<String> parserUrl = parserUrl(str);
            TrieNode trieNode = this.root;
            do {
                String peek = parserUrl.peek();
                int size = parserUrl.size();
                Iterator<TrieNode> it = trieNode.children.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrieNode next = it.next();
                    if (next.trieNode.equals(peek)) {
                        parserUrl.poll();
                        trieNode = next;
                        break;
                    }
                }
                if (size == parserUrl.size()) {
                    return null;
                }
            } while (parserUrl.size() > 0);
            String access$100 = trieNode.localPath;
            return access$100;
        }
    }

    public OfflineBundle searchUrlEx(String str) {
        synchronized (SYN) {
            Queue<String> parserUrl = parserUrl(str);
            TrieNode trieNode = this.root;
            do {
                String peek = parserUrl.peek();
                int size = parserUrl.size();
                Iterator<TrieNode> it = trieNode.children.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    TrieNode next = it.next();
                    if (next.trieNode.equals(peek)) {
                        parserUrl.poll();
                        trieNode = next;
                        break;
                    }
                }
                if (size == parserUrl.size()) {
                    return null;
                }
                if (!trieNode.trieNode.equalsIgnoreCase("root") && trieNode.children == null) {
                    OfflineBundle access$200 = trieNode.offlineBundleInfo;
                    return access$200;
                }
            } while (parserUrl.size() > 0);
            OfflineBundle access$2002 = trieNode.offlineBundleInfo;
            return access$2002;
        }
    }
}
