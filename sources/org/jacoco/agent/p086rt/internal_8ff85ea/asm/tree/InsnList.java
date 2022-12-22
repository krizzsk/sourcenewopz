package org.jacoco.agent.p086rt.internal_8ff85ea.asm.tree;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.jacoco.agent.p086rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.InsnList */
public class InsnList {
    AbstractInsnNode[] cache;
    private AbstractInsnNode first;
    private AbstractInsnNode last;
    private int size;

    public int size() {
        return this.size;
    }

    public AbstractInsnNode getFirst() {
        return this.first;
    }

    public AbstractInsnNode getLast() {
        return this.last;
    }

    public AbstractInsnNode get(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (this.cache == null) {
            this.cache = toArray();
        }
        return this.cache[i];
    }

    public boolean contains(AbstractInsnNode abstractInsnNode) {
        AbstractInsnNode abstractInsnNode2 = this.first;
        while (abstractInsnNode2 != null && abstractInsnNode2 != abstractInsnNode) {
            abstractInsnNode2 = abstractInsnNode2.next;
        }
        return abstractInsnNode2 != null;
    }

    public int indexOf(AbstractInsnNode abstractInsnNode) {
        if (this.cache == null) {
            this.cache = toArray();
        }
        return abstractInsnNode.index;
    }

    public void accept(MethodVisitor methodVisitor) {
        for (AbstractInsnNode abstractInsnNode = this.first; abstractInsnNode != null; abstractInsnNode = abstractInsnNode.next) {
            abstractInsnNode.accept(methodVisitor);
        }
    }

    public ListIterator<AbstractInsnNode> iterator() {
        return iterator(0);
    }

    public ListIterator<AbstractInsnNode> iterator(int i) {
        return new InsnListIterator(i);
    }

    public AbstractInsnNode[] toArray() {
        AbstractInsnNode abstractInsnNode = this.first;
        AbstractInsnNode[] abstractInsnNodeArr = new AbstractInsnNode[this.size];
        int i = 0;
        while (abstractInsnNode != null) {
            abstractInsnNodeArr[i] = abstractInsnNode;
            abstractInsnNode.index = i;
            abstractInsnNode = abstractInsnNode.next;
            i++;
        }
        return abstractInsnNodeArr;
    }

    public void set(AbstractInsnNode abstractInsnNode, AbstractInsnNode abstractInsnNode2) {
        AbstractInsnNode abstractInsnNode3 = abstractInsnNode.next;
        abstractInsnNode2.next = abstractInsnNode3;
        if (abstractInsnNode3 != null) {
            abstractInsnNode3.prev = abstractInsnNode2;
        } else {
            this.last = abstractInsnNode2;
        }
        AbstractInsnNode abstractInsnNode4 = abstractInsnNode.prev;
        abstractInsnNode2.prev = abstractInsnNode4;
        if (abstractInsnNode4 != null) {
            abstractInsnNode4.next = abstractInsnNode2;
        } else {
            this.first = abstractInsnNode2;
        }
        if (this.cache != null) {
            int i = abstractInsnNode.index;
            this.cache[i] = abstractInsnNode2;
            abstractInsnNode2.index = i;
        } else {
            abstractInsnNode2.index = 0;
        }
        abstractInsnNode.index = -1;
        abstractInsnNode.prev = null;
        abstractInsnNode.next = null;
    }

    public void add(AbstractInsnNode abstractInsnNode) {
        this.size++;
        AbstractInsnNode abstractInsnNode2 = this.last;
        if (abstractInsnNode2 == null) {
            this.first = abstractInsnNode;
            this.last = abstractInsnNode;
        } else {
            abstractInsnNode2.next = abstractInsnNode;
            abstractInsnNode.prev = this.last;
        }
        this.last = abstractInsnNode;
        this.cache = null;
        abstractInsnNode.index = 0;
    }

    public void add(InsnList insnList) {
        int i = insnList.size;
        if (i != 0) {
            this.size += i;
            AbstractInsnNode abstractInsnNode = this.last;
            if (abstractInsnNode == null) {
                this.first = insnList.first;
                this.last = insnList.last;
            } else {
                AbstractInsnNode abstractInsnNode2 = insnList.first;
                abstractInsnNode.next = abstractInsnNode2;
                abstractInsnNode2.prev = this.last;
                this.last = insnList.last;
            }
            this.cache = null;
            insnList.removeAll(false);
        }
    }

    public void insert(AbstractInsnNode abstractInsnNode) {
        this.size++;
        AbstractInsnNode abstractInsnNode2 = this.first;
        if (abstractInsnNode2 == null) {
            this.first = abstractInsnNode;
            this.last = abstractInsnNode;
        } else {
            abstractInsnNode2.prev = abstractInsnNode;
            abstractInsnNode.next = this.first;
        }
        this.first = abstractInsnNode;
        this.cache = null;
        abstractInsnNode.index = 0;
    }

    public void insert(InsnList insnList) {
        int i = insnList.size;
        if (i != 0) {
            this.size += i;
            AbstractInsnNode abstractInsnNode = this.first;
            if (abstractInsnNode == null) {
                this.first = insnList.first;
                this.last = insnList.last;
            } else {
                AbstractInsnNode abstractInsnNode2 = insnList.last;
                abstractInsnNode.prev = abstractInsnNode2;
                abstractInsnNode2.next = this.first;
                this.first = insnList.first;
            }
            this.cache = null;
            insnList.removeAll(false);
        }
    }

    public void insert(AbstractInsnNode abstractInsnNode, AbstractInsnNode abstractInsnNode2) {
        this.size++;
        AbstractInsnNode abstractInsnNode3 = abstractInsnNode.next;
        if (abstractInsnNode3 == null) {
            this.last = abstractInsnNode2;
        } else {
            abstractInsnNode3.prev = abstractInsnNode2;
        }
        abstractInsnNode.next = abstractInsnNode2;
        abstractInsnNode2.next = abstractInsnNode3;
        abstractInsnNode2.prev = abstractInsnNode;
        this.cache = null;
        abstractInsnNode2.index = 0;
    }

    public void insert(AbstractInsnNode abstractInsnNode, InsnList insnList) {
        int i = insnList.size;
        if (i != 0) {
            this.size += i;
            AbstractInsnNode abstractInsnNode2 = insnList.first;
            AbstractInsnNode abstractInsnNode3 = insnList.last;
            AbstractInsnNode abstractInsnNode4 = abstractInsnNode.next;
            if (abstractInsnNode4 == null) {
                this.last = abstractInsnNode3;
            } else {
                abstractInsnNode4.prev = abstractInsnNode3;
            }
            abstractInsnNode.next = abstractInsnNode2;
            abstractInsnNode3.next = abstractInsnNode4;
            abstractInsnNode2.prev = abstractInsnNode;
            this.cache = null;
            insnList.removeAll(false);
        }
    }

    public void insertBefore(AbstractInsnNode abstractInsnNode, AbstractInsnNode abstractInsnNode2) {
        this.size++;
        AbstractInsnNode abstractInsnNode3 = abstractInsnNode.prev;
        if (abstractInsnNode3 == null) {
            this.first = abstractInsnNode2;
        } else {
            abstractInsnNode3.next = abstractInsnNode2;
        }
        abstractInsnNode.prev = abstractInsnNode2;
        abstractInsnNode2.next = abstractInsnNode;
        abstractInsnNode2.prev = abstractInsnNode3;
        this.cache = null;
        abstractInsnNode2.index = 0;
    }

    public void insertBefore(AbstractInsnNode abstractInsnNode, InsnList insnList) {
        int i = insnList.size;
        if (i != 0) {
            this.size += i;
            AbstractInsnNode abstractInsnNode2 = insnList.first;
            AbstractInsnNode abstractInsnNode3 = insnList.last;
            AbstractInsnNode abstractInsnNode4 = abstractInsnNode.prev;
            if (abstractInsnNode4 == null) {
                this.first = abstractInsnNode2;
            } else {
                abstractInsnNode4.next = abstractInsnNode2;
            }
            abstractInsnNode.prev = abstractInsnNode3;
            abstractInsnNode3.next = abstractInsnNode;
            abstractInsnNode2.prev = abstractInsnNode4;
            this.cache = null;
            insnList.removeAll(false);
        }
    }

    public void remove(AbstractInsnNode abstractInsnNode) {
        this.size--;
        AbstractInsnNode abstractInsnNode2 = abstractInsnNode.next;
        AbstractInsnNode abstractInsnNode3 = abstractInsnNode.prev;
        if (abstractInsnNode2 == null) {
            if (abstractInsnNode3 == null) {
                this.first = null;
                this.last = null;
            } else {
                abstractInsnNode3.next = null;
                this.last = abstractInsnNode3;
            }
        } else if (abstractInsnNode3 == null) {
            this.first = abstractInsnNode2;
            abstractInsnNode2.prev = null;
        } else {
            abstractInsnNode3.next = abstractInsnNode2;
            abstractInsnNode2.prev = abstractInsnNode3;
        }
        this.cache = null;
        abstractInsnNode.index = -1;
        abstractInsnNode.prev = null;
        abstractInsnNode.next = null;
    }

    /* access modifiers changed from: package-private */
    public void removeAll(boolean z) {
        if (z) {
            AbstractInsnNode abstractInsnNode = this.first;
            while (abstractInsnNode != null) {
                AbstractInsnNode abstractInsnNode2 = abstractInsnNode.next;
                abstractInsnNode.index = -1;
                abstractInsnNode.prev = null;
                abstractInsnNode.next = null;
                abstractInsnNode = abstractInsnNode2;
            }
        }
        this.size = 0;
        this.first = null;
        this.last = null;
        this.cache = null;
    }

    public void clear() {
        removeAll(false);
    }

    public void resetLabels() {
        for (AbstractInsnNode abstractInsnNode = this.first; abstractInsnNode != null; abstractInsnNode = abstractInsnNode.next) {
            if (abstractInsnNode instanceof LabelNode) {
                ((LabelNode) abstractInsnNode).resetLabel();
            }
        }
    }

    /* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.InsnList$InsnListIterator */
    private final class InsnListIterator implements ListIterator {
        AbstractInsnNode next;
        AbstractInsnNode prev;
        AbstractInsnNode remove;

        InsnListIterator(int i) {
            if (i == InsnList.this.size()) {
                this.next = null;
                this.prev = InsnList.this.getLast();
                return;
            }
            AbstractInsnNode abstractInsnNode = InsnList.this.get(i);
            this.next = abstractInsnNode;
            this.prev = abstractInsnNode.prev;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public Object next() {
            AbstractInsnNode abstractInsnNode = this.next;
            if (abstractInsnNode != null) {
                this.prev = abstractInsnNode;
                this.next = abstractInsnNode.next;
                this.remove = abstractInsnNode;
                return abstractInsnNode;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            AbstractInsnNode abstractInsnNode = this.remove;
            if (abstractInsnNode != null) {
                AbstractInsnNode abstractInsnNode2 = this.next;
                if (abstractInsnNode == abstractInsnNode2) {
                    this.next = abstractInsnNode2.next;
                } else {
                    this.prev = this.prev.prev;
                }
                InsnList.this.remove(this.remove);
                this.remove = null;
                return;
            }
            throw new IllegalStateException();
        }

        public boolean hasPrevious() {
            return this.prev != null;
        }

        public Object previous() {
            AbstractInsnNode abstractInsnNode = this.prev;
            this.next = abstractInsnNode;
            this.prev = abstractInsnNode.prev;
            this.remove = abstractInsnNode;
            return abstractInsnNode;
        }

        public int nextIndex() {
            if (this.next == null) {
                return InsnList.this.size();
            }
            if (InsnList.this.cache == null) {
                InsnList insnList = InsnList.this;
                insnList.cache = insnList.toArray();
            }
            return this.next.index;
        }

        public int previousIndex() {
            if (this.prev == null) {
                return -1;
            }
            if (InsnList.this.cache == null) {
                InsnList insnList = InsnList.this;
                insnList.cache = insnList.toArray();
            }
            return this.prev.index;
        }

        public void add(Object obj) {
            AbstractInsnNode abstractInsnNode = this.next;
            if (abstractInsnNode != null) {
                InsnList.this.insertBefore(abstractInsnNode, (AbstractInsnNode) obj);
            } else {
                AbstractInsnNode abstractInsnNode2 = this.prev;
                if (abstractInsnNode2 != null) {
                    InsnList.this.insert(abstractInsnNode2, (AbstractInsnNode) obj);
                } else {
                    InsnList.this.add((AbstractInsnNode) obj);
                }
            }
            this.prev = (AbstractInsnNode) obj;
            this.remove = null;
        }

        public void set(Object obj) {
            AbstractInsnNode abstractInsnNode = this.remove;
            if (abstractInsnNode != null) {
                AbstractInsnNode abstractInsnNode2 = (AbstractInsnNode) obj;
                InsnList.this.set(abstractInsnNode, abstractInsnNode2);
                if (this.remove == this.prev) {
                    this.prev = abstractInsnNode2;
                } else {
                    this.next = abstractInsnNode2;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
