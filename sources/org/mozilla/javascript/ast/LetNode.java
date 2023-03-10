package org.mozilla.javascript.ast;

public class LetNode extends Scope {
    private AstNode body;

    /* renamed from: lp */
    private int f6640lp = -1;

    /* renamed from: rp */
    private int f6641rp = -1;
    private VariableDeclaration variables;

    public LetNode() {
        this.type = 158;
    }

    public LetNode(int i) {
        super(i);
        this.type = 158;
    }

    public LetNode(int i, int i2) {
        super(i, i2);
        this.type = 158;
    }

    public VariableDeclaration getVariables() {
        return this.variables;
    }

    public void setVariables(VariableDeclaration variableDeclaration) {
        assertNotNull(variableDeclaration);
        this.variables = variableDeclaration;
        variableDeclaration.setParent(this);
    }

    public AstNode getBody() {
        return this.body;
    }

    public void setBody(AstNode astNode) {
        this.body = astNode;
        if (astNode != null) {
            astNode.setParent(this);
        }
    }

    public int getLp() {
        return this.f6640lp;
    }

    public void setLp(int i) {
        this.f6640lp = i;
    }

    public int getRp() {
        return this.f6641rp;
    }

    public void setRp(int i) {
        this.f6641rp = i;
    }

    public void setParens(int i, int i2) {
        this.f6640lp = i;
        this.f6641rp = i2;
    }

    public String toSource(int i) {
        String makeIndent = makeIndent(i);
        StringBuilder sb = new StringBuilder();
        sb.append(makeIndent);
        sb.append("let (");
        printList(this.variables.getVariables(), sb);
        sb.append(") ");
        AstNode astNode = this.body;
        if (astNode != null) {
            sb.append(astNode.toSource(i));
        }
        return sb.toString();
    }

    public void visit(NodeVisitor nodeVisitor) {
        if (nodeVisitor.visit(this)) {
            this.variables.visit(nodeVisitor);
            AstNode astNode = this.body;
            if (astNode != null) {
                astNode.visit(nodeVisitor);
            }
        }
    }
}
