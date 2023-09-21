// generated with ast extension for cup
// version 0.8
// 13/8/2023 0:3:14


package rs.ac.bg.etf.pp1.ast;

public class ConstValListsExist extends ConstValList {

    private ConstValList ConstValList;
    private ConstValName ConstValName;

    public ConstValListsExist (ConstValList ConstValList, ConstValName ConstValName) {
        this.ConstValList=ConstValList;
        if(ConstValList!=null) ConstValList.setParent(this);
        this.ConstValName=ConstValName;
        if(ConstValName!=null) ConstValName.setParent(this);
    }

    public ConstValList getConstValList() {
        return ConstValList;
    }

    public void setConstValList(ConstValList ConstValList) {
        this.ConstValList=ConstValList;
    }

    public ConstValName getConstValName() {
        return ConstValName;
    }

    public void setConstValName(ConstValName ConstValName) {
        this.ConstValName=ConstValName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstValList!=null) ConstValList.accept(visitor);
        if(ConstValName!=null) ConstValName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstValList!=null) ConstValList.traverseTopDown(visitor);
        if(ConstValName!=null) ConstValName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstValList!=null) ConstValList.traverseBottomUp(visitor);
        if(ConstValName!=null) ConstValName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstValListsExist(\n");

        if(ConstValList!=null)
            buffer.append(ConstValList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstValName!=null)
            buffer.append(ConstValName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstValListsExist]");
        return buffer.toString();
    }
}
