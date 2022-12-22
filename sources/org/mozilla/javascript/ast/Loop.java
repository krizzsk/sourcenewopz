package org.mozilla.javascript.ast;

public abstract class Loop extends Scope {
    protected AstNode body;

    /* renamed from: lp */
    protected int f6642lp = -1;

    /* renamed from: rp */
    protected int f6643rp = -1;

    public Loop() {
    }

    public Loop(int i) {
        super(i);
    }

    public Loop(int i, int i2) {
        super(i, i2);
    }

    public AstNode getBody() {
        return this.body;
    }

    public void setBody(AstNode astNode) {
        this.body = astNode;
        setLength((astNode.getPosition() + astNode.getLength()) - getPosition());
        astNode.setParent(this);
    }

    public int getLp() {
        return this.f6642lp;
    }

    public void setLp(int i) {
        this.f6642lp = i;
    }

    public int getRp() {
        return this.f6643rp;
    }

    public void setRp(int i) {
        this.f6643rp = i;
    }

    public void setParens(int i, int i2) {
        this.f6642lp = i;
        this.f6643rp = i2;
    }
}
