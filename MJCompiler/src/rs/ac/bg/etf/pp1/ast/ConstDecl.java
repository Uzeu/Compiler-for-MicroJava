// generated with ast extension for cup
// version 0.8
// 13/8/2023 0:3:14


package rs.ac.bg.etf.pp1.ast;

public class ConstDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    public rs.etf.pp1.symboltable.concepts.Obj obj = null;

    private Type Type;
    private ConstValName ConstValName;
    private ConstValList ConstValList;

    public ConstDecl (Type Type, ConstValName ConstValName, ConstValList ConstValList) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ConstValName=ConstValName;
        if(ConstValName!=null) ConstValName.setParent(this);
        this.ConstValList=ConstValList;
        if(ConstValList!=null) ConstValList.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public ConstValName getConstValName() {
        return ConstValName;
    }

    public void setConstValName(ConstValName ConstValName) {
        this.ConstValName=ConstValName;
    }

    public ConstValList getConstValList() {
        return ConstValList;
    }

    public void setConstValList(ConstValList ConstValList) {
        this.ConstValList=ConstValList;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstValName!=null) ConstValName.accept(visitor);
        if(ConstValList!=null) ConstValList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstValName!=null) ConstValName.traverseTopDown(visitor);
        if(ConstValList!=null) ConstValList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstValName!=null) ConstValName.traverseBottomUp(visitor);
        if(ConstValList!=null) ConstValList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDecl(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstValName!=null)
            buffer.append(ConstValName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstValList!=null)
            buffer.append(ConstValList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDecl]");
        return buffer.toString();
    }
}
