package rs.ac.bg.etf.pp1;
import java.rmi.NoSuchObjectException;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class SemanticPass extends VisitorAdaptor {

	static Struct booltype=new Struct(Struct.Bool);
	static Obj boool=Tab.insert(Obj.Type, "bool", booltype);
	
	boolean errorDetected = false;
	int printCallCount = 0;
	Obj currentMethod = null;
	boolean returnFound = false;
	int nVars;
	int brLinije=0;
	String varName;
	boolean imaZagrade=false;
	Struct a;
	
	
	int varDeclCount = 0;

	Logger log = Logger.getLogger(getClass());

	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.error(msg.toString());
	}

	public void report_info(String message, SyntaxNode info) {
		StringBuilder msg = new StringBuilder(message); 
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void report_info(String message, int linija) {
		StringBuilder msg = new StringBuilder(message); 
		int line = linija;
		if (line != 0)
			msg.append (" na liniji ").append(line);
		log.info(msg.toString());
	}
	
	public void visit(Program program) {		
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgName().obj);
		if(Tab.find("main")==Tab.noObj) {
			report_error("ne postoji main funkcija",null);
		}
		else {
			
		}
		Tab.closeScope();
		
	}

	public void visit(ProgName progName) {
		
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		
		Tab.openScope();     	
	}

	public void visit(FormParsFormExist prom) {
		report_error("main funkcija ne sme imati parametre",null);
	}
	
	
	public void visit(VarDecl varDecl) {
		
		
		
	
		/*
		Obj daLiMain=Tab.find("main");
		
		if(daLiMain==Tab.noObj) {
			if(imaZagrade==true) {
				report_info("Deklarisana globalna promenljiva "+ varDecl.getVarName()+"tipa 3",varDecl);
				Struct hehe=new Struct(3,new Struct(varDecl.getType().struct.getKind()));
				Obj varNode=Tab.insert(Obj.Var, varDecl.getVarName(), hehe);
			}
			else {
				report_info("Deklarisana globalna promenljiva "+ varDecl.getVarName() +" tipa "+varDecl.getType().struct.getKind(), varDecl);
				Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), varDecl.getType().struct);
			}
			
		}
		else {
			if(imaZagrade==true) {
				report_info("Deklarisana lokalna promenljiva "+ varDecl.getVarName()+"tipa 3",varDecl);
				Struct hehe=new Struct(3,new Struct(varDecl.getType().struct.getKind()));
				Obj varNode=Tab.insert(Obj.Var, varDecl.getVarName(), hehe);
			}
			else {
				report_info("Deklarisana lokalna promenljiva "+ varDecl.getVarName() +" tipa "+varDecl.getType().struct.getKind(), varDecl);
				Obj varNode = Tab.insert(Obj.Var, varDecl.getVarName(), varDecl.getType().struct);
			}
		}
	*/
		
	}
	
	
	
	public void visit(VarDeclNameYesBrackets varDecl) {
		Obj daLiMain=Tab.find("main");
		if(daLiMain==Tab.noObj) {
			if(Tab.find(varDecl.getVarName())!=Tab.noObj){
				report_error("Semanticka greska na liniji " + varDecl.getLine() + " -> promenljiva " + varDecl.getVarName() + " je vec deklarisana", null);
			}
			else {
				report_info("Deklarisana globalna promenljiva " + varDecl.getVarName() + " tipa 3",varDecl);
			
			Struct hehe=new Struct(Struct.Array,a);
			Obj varNode=Tab.insert(Obj.Var, varDecl.getVarName(),hehe );}
		}
		else {
			if(Tab.find(varDecl.getVarName())!=Tab.noObj && Tab.find(varDecl.getVarName()).getLevel()>0 ) {
				report_error("Semanticka greska na liniji " + varDecl.getLine() + " -> promenljiva " + varDecl.getVarName() + " je vec deklarisana", null);
			}
			
			else{report_info("Deklarisana lokalna promenljiva " + varDecl.getVarName() + " tipa 3",varDecl);
			Struct hehe=new Struct(3,a);
			Obj varNode=Tab.insert(Obj.Var, varDecl.getVarName(),hehe );}
		}
		
	}
	
	
	
	
	public void visit(VarDeclNameNoBrackets varDecl) {
		Obj daLiMain=Tab.find("main");
		if(daLiMain==Tab.noObj) {
			if(Tab.find(varDecl.getVarName())!=Tab.noObj){
				report_error("Semanticka greska na liniji " + varDecl.getLine() + " -> promenljiva " + varDecl.getVarName() + " je vec deklarisana", null);
			}
			
			else{report_info("Deklarisana globalna promenljiva " + varDecl.getVarName() + " tipa "+ a.getKind(),varDecl);
			
			Obj varNode=Tab.insert(Obj.Var, varDecl.getVarName(),a );}
		}
		else {
			if(Tab.find(varDecl.getVarName())!=Tab.noObj && Tab.find(varDecl.getVarName()).getLevel()>0 ) {
				report_error("Semanticka greska na liniji " + varDecl.getLine() + " -> promenljiva " + varDecl.getVarName() + " je vec deklarisana ", null);
			}
			
			else{report_info("Deklarisana lokalna promenljiva " + varDecl.getVarName()+ " tipa "+ a.getKind(),varDecl);
			
			Obj varNode=Tab.insert(Obj.Var, varDecl.getVarName(),a );}
		}
	}
	
	public void visit(BracketsExist bracketsExist) {
		/*Obj daLiMain=Tab.find("main");
		
		String ime=nizIme;
		
		if(daLiMain==Tab.noObj) {
			report_info("Deklarisana globalna promenljiva "+ ime +" tipa 3", bracketsExist);
			Struct haha=new Struct(3,new Struct(1));
			Obj varNode = Tab.insert(Obj.Var, ime, haha);
		}
		
		else {
			report_info("Deklarisana lokalna promenljiva "+ ime +" tipa 3", bracketsExist);
			Struct haha=new Struct(3,new Struct(1));
			Obj varNode = Tab.insert(Obj.Var, ime, haha);
		}*/
		imaZagrade=true;
	}
	
	public void visit(NoBrackets noBrackets) {
		/*Obj daLiMain=Tab.find("main");
		
		String ime=nizIme;
		
		if(daLiMain==Tab.noObj) {
			Obj typeIme=Tab.find(varName);
			report_info("Deklarisana globalna promenljiva "+ ime +" tipa "+typeIme.getType().getKind(), noBrackets);
			Obj varNode = Tab.insert(Obj.Var, ime,typeIme.getType() );
		}
		
		else {
			
			Obj typeIme=Tab.find(varName);
			report_info("Deklarisana lokalna promenljiva "+ ime +" tipa "+typeIme.getType().getKind(), noBrackets);
			Obj varNode = Tab.insert(Obj.Var, ime,typeIme.getType() );
		}*/
		imaZagrade=false;
	}
	
	

	
	
	/*public void visit(BracketsName BracketsName) {
		
		
		Obj daLiMain=Tab.find("main");
		if(daLiMain==Tab.noObj ) {
			Obj typeIme=Tab.find(varName);
			if(imaZagrade==true) {
				report_info("Deklarisana globalna promenljiva "+ BracketsName.getBracketsName()+" tipa 3", BracketsName);
				Struct hehe=new Struct(3,new Struct(typeIme.getType().getKind()));
				Obj constNode = Tab.insert(Obj.Var,BracketsName.getBracketsName(),hehe);
				
			}
			else {
				report_info("Deklarisana globalna promenljiva "+ BracketsName.getBracketsName()+" tipa "+typeIme.getType().getKind(), BracketsName);
				Obj constNode = Tab.insert(Obj.Var,BracketsName.getBracketsName(),typeIme.getType());
			}
			if(imaZagrade==true) {
				report_info("Deklarisana globalna promenljiva "+ BracketsName.getBracketsName()+" tipa 3", BracketsName);
				Struct hehe=new Struct(3,new Struct(typeIme.getType().getKind()));
				Obj constNode = Tab.insert(Obj.Var,BracketsName.getBracketsName(),hehe);
				
			}
			else {
				report_info("Deklarisana globalna promenljiva "+ BracketsName.getBracketsName()+" tipa "+typeIme.getType().getKind(), BracketsName);
				Obj constNode = Tab.insert(Obj.Var,BracketsName.getBracketsName(),typeIme.getType());
			}
		}
		
	}*/
	
	
	public void visit(ConstDecl constDecl) {
		/*
		if(Tab.find(constDecl.getConstValName().getConstName())!=Tab.noObj){
			report_error("Semanticka greska na liniji " + constDecl.getLine() + " -> promenljiva " + constDecl.getConstValName().getConstName() + " je vec deklarisana", null);
		}
		else if(constDecl.getConstValName().getConstVal().struct!=constDecl.getType().struct) {
			report_error("Semanticka greska na liniji " + constDecl.getLine() + " -> tip promenljive " + constDecl.getConstValName().getConstName() + " se ne slaze sa tipom dodeljene vrednosti ", null);
		}
		else{report_info("Deklarisana konstanta "+ constDecl.getConstValName().getConstName()+" tipa "+constDecl.getType().struct.getKind(), constDecl);
		Obj constNode = Tab.insert(Obj.Con,constDecl.getConstValName().getConstName(),constDecl.getType().struct);}*/
	}
	
	
	public void visit(ConstValName constValList) {
		Obj typeIme=Tab.find(varName);
		if(Tab.find(constValList.getConstName())!=Tab.noObj){
			report_error("Semanticka greska na liniji " + constValList.getLine() + " -> promenljiva " + constValList.getConstName() + " je vec deklarisana", null);
		}
		else if(constValList.getConstVal().obj.getType()!=typeIme.getType()) {
			report_error("Semanticka greska na liniji " + constValList.getLine() + " -> tip promenljive " + constValList.getConstName()+ " se ne slaze sa tipom dodeljene vrednosti ", null);
		}
		else{report_info("Deklarisana konstanta "+ constValList.getConstName()+" tipa "+typeIme.getType().getKind(), constValList);
		
		
		constValList.obj = Tab.insert(Obj.Con,constValList.getConstName(),typeIme.getType());
		constValList.obj.setAdr(constValList.getConstVal().obj.getAdr());
		//constValList.obj.setAdr(constValList.getConstVal().);
		//constValList.obj.setAdr(constValList.getConstVal());
		}
		
		
	}
	
	
	public void visit(ConstValNum val) {
		val.obj=new Obj(Obj.Con,"$",Tab.intType);
		val.obj.setAdr(val.getN1());
		//val.struct=Tab.intType;
	}
	public void visit(ConstValBool val) {
		val.obj=new Obj(Obj.Con,"$", booltype);
		if(val.getB1())
			val.obj.setAdr(1);
		else {
			val.obj.setAdr(0);
		}
		
		//val.struct=Tab.find("bool").getType();
	}
	public void visit(ConstValChar val) {
		val.obj=new Obj(Obj.Con, "$", Tab.charType);
		val.obj.setAdr(val.getC1());
		//val.struct=Tab.charType;
	}
	
	
	
	

	public void visit(Type type) {
		Obj typeNode = Tab.find(type.getTypeName());
		if (typeNode == Tab.noObj) {
			report_error("Nije pronadjen tip " + type.getTypeName() + " u tabeli simbola", null);
			type.struct = Tab.noType;
		} 
		else {
			if (Obj.Type == typeNode.getKind()) {
				varName=type.getTypeName();
				type.struct = typeNode.getType();
			} 
			else {
				report_error("Greska: Ime " + type.getTypeName() + " ne predstavlja tip ", type);
				type.struct = Tab.noType;
			}
		}
		a=type.struct;
	}

	public void visit(MethodDecl methodDecl) {
		if (!returnFound && currentMethod.getType() != Tab.noType) {
			report_error("Semanticka greska na liniji " + methodDecl.getLine() + ": funcija " + currentMethod.getName() + " nema return iskaz!", null);
		}
		
		Tab.chainLocalSymbols(currentMethod);
		Tab.closeScope();
		
		returnFound = false;
		currentMethod = null;
	}

	public void visit(MethodName methodName) {
		currentMethod = Tab.insert(Obj.Meth, methodName.getMethodName(), Tab.noType);
		methodName.obj = currentMethod;
		Tab.openScope();
		report_info("Obradjuje se funkcija " + methodName.getMethodName(), methodName);
	}

	public void visit(PrintStmtComma print) {
		printCallCount++;
		
		if(print.getExpr().struct==null || print.getExpr().struct.getKind()!=Struct.Bool && print.getExpr().struct.getKind()!=Struct.Int && print.getExpr().struct.getKind()!=Struct.Char) {
			report_error("Greska na liniji : " + print.getLine()+"  print (expr) -> expr nije int/char/bool" ,null);
		}
		
	}
	
	public void visit(PrintStmt print){
		printCallCount++; 
		if(print.getExpr().struct==null || print.getExpr().struct.getKind()!=Struct.Bool && print.getExpr().struct.getKind()!=Struct.Int && print.getExpr().struct.getKind()!=Struct.Char) {
			report_error("Greska na liniji : " + print.getLine()+"  print (expr) -> expr nije int/char/bool" ,null);
		}
		
		
	}
	
	
	public void visit(ReadStmt read) {
		Obj obj=read.getDesignator().obj;
		if(read.getDesignator().obj.getKind()!=Obj.Var && read.getDesignator().obj.getKind()!=Obj.Elem ) {
			
			report_error("Greska na liniji : " + read.getLine()+"  read (Designator) -> Deasignator nije promenljiva ili element niza" ,null);
			
			//report_error("Greska na liniji : " + read.getLine()+"  read (Designator) -> Deasignator nije int/char/bool/promenljiva/element niza" ,null);
		}
		else {
			if( read.getDesignator().obj.getType()==null || read.getDesignator().obj.getType().getKind()!=Struct.Bool && read.getDesignator().obj.getType().getKind()!=Struct.Int&& read.getDesignator().obj.getType().getKind()!=Struct.Char) {
				report_error("Greska na liniji : " + read.getLine()+"  read (Designator) -> Deasignator nije int ili char ili bool" ,null);
			}
			
		}
		
	}
	
	public void visit(FindAnyStmt findAny) {
		Obj obj2=findAny.getDesignator().obj;
		Obj obj=findAny.getRightDesignator().getDesignator().obj;
		if(findAny.getDesignator().obj.getType()==null || findAny.getDesignator().obj.getType().getKind()!=Struct.Bool) {
			report_error("Greska na liniji : " + findAny.getLine()+"  findAny -> Deasignator sa leve strane  nije  bool" ,null);
		}
		else {
			if(findAny.getRightDesignator().getDesignator().obj.getType().getKind()!=Struct.Array) {
				report_error("Greska na liniji : " + findAny.getLine()+"  findAny -> Deasignator sa desne strane  nije niz" ,null);
			}
		}
	}
	
	
	public void visit(DesignatorStmt3 designatorStmt) {
		Struct designatorType = designatorStmt.getDesignator().obj.getType();
		Obj obj =designatorStmt.getDesignator().obj;
		Struct exprr=designatorStmt.getExpr().struct;
		
		
		if(obj.getKind()!=Obj.Var && obj.getKind()!=Obj.Elem) {
			report_error("Greska na liniji : " + designatorStmt.getLine()+"  DesignatorStatement -> Designator Assignop Expr : Deasignator nije promenljiva ili element niza" ,null);
		}
		
		else {
			if(designatorType==null ||  (exprr.getKind()!= designatorType.getKind() && designatorType.getKind()!=Struct.Array) || (exprr.getKind()!= designatorType.getKind() && designatorType.getKind()==Struct.Array && designatorType.getElemType().getKind()!=exprr.getKind()) )  {
					report_error("Greska na liniji : " + designatorStmt.getLine()+"  DesignatorStatement -> Designator Assignop Expr : Designator i expr nisu istog tipa" ,null);
			}
			
		}
		
		
		//Struct exprType = designatorStmt.getExpr()
	}
	
	public void visit(DesignatorStmt1 designatorStmt) {
		Struct designatorType = designatorStmt.getDesignator().obj.getType();
		Obj obj =designatorStmt.getDesignator().obj;
		if(obj.getKind()!=Obj.Var && obj.getKind()!=Obj.Elem) {
			report_error("Greska na liniji : " + designatorStmt.getLine()+"  DesignatorStatement -> Designator Assignop Expr : Deasignator nije promenljiva ili element niza" ,null);
		}
		else {
			if(designatorType==null || designatorType.getKind()!=Struct.Int) {
				report_error("Greska na liniji : " + designatorStmt.getLine()+"  DesignatorStatement -> Designator ++ | -- : Designator nije tipa int" ,null);
			}
		}
		
	}
	
	public void visit(DesignatorStmt2 designatorStmt) {
		
		Obj desForm= designatorStmt.getDesignatorForm().obj;
		Obj desFormList=designatorStmt.getDesignatorFormList().obj;
		
		if(designatorStmt.getDesignator().obj.getType().getKind()!=Struct.Array) {
			report_error("Greska na liniji : " + designatorStmt.getLine()+"   Designator sa desne strane jednakosti nije niz" ,null);
		}
		if(desForm==Tab.noObj && desFormList==Tab.noObj) {
			
		}
		else if(desForm==Tab.noObj && desFormList!=Tab.noObj) {
			if(desFormList.getKind()!=Obj.Elem && desFormList.getKind()!=Obj.Var) {
				report_error("Greska na liniji : " + designatorStmt.getLine()+"   Designator/i sa leve strane nisu promenljive ili elementi nizaa" ,null);
			}
			else if( designatorStmt.getDesignator().obj.getType().getElemType().getKind() != desFormList.getType().getKind() ) {
				report_error("Greska na liniji : " + designatorStmt.getLine()+"   Designator/i sa leve strane nisu istog tipa  kao elementi niza sa desne strane" ,null);
			}
		}
		else if(desForm!=Tab.noObj && desFormList==Tab.noObj) {
			if(desForm.getKind()!=Obj.Elem && desForm.getKind()!=Obj.Var ) {
				report_error("Greska na liniji : " + designatorStmt.getLine()+"   Designator/i sa leve strane nisu promenljive ili elementi nizaaa" ,null);
			}
			else if(designatorStmt.getDesignator().obj.getType().getElemType().getKind()!=desForm.getType().getKind()) {
				report_error("Greska na liniji : " + designatorStmt.getLine()+"   Designator/i sa leve strane nisu istog tipa  kao elementi niza sa desne strane" ,null);
			}
		}
		else {
			
		
			if((desForm.getKind()!=Obj.Elem && desForm.getKind()!=Obj.Var) || (desFormList.getKind()!=Obj.Elem && desFormList.getKind()!=Obj.Var)) {
				report_error("Greska na liniji : " + designatorStmt.getLine()+"   Designator/i sa leve strane nisu promenljive ili elementi nizaaaa" ,null);
			}
			else if(designatorStmt.getDesignator().obj.getType().getElemType().getKind()!=desForm.getType().getKind() || designatorStmt.getDesignator().obj.getType().getElemType().getKind() != desFormList.getType().getKind() ) {
				report_error("Greska na liniji : " + designatorStmt.getLine()+"   Designator/i sa leve strane nisu istog tipa  kao elementi niza sa desne strane" ,null);
			}
		}
		
		
		
	}
	
	
	public void visit(DesignatorFormExist designator) {
		designator.obj=designator.getDesignator().obj;
		//report_info("designatorFormExist :  "+ designator.getDesignator().obj.getName(),null);
	}
	
	public void visit(NoDesignator designator) {
		designator.obj=Tab.noObj;
	}
	
	public void visit(DesignatorFormListExist designatorForm) {
		Obj objForm=designatorForm.getDesignatorForm().obj;
		Obj objFormList=designatorForm.getDesignatorFormList().obj;
		
		if(objForm==Tab.noObj && objFormList==Tab.noObj) {
			designatorForm.obj=Tab.noObj;
		}
		else if(objForm==Tab.noObj && objFormList!=Tab.noObj) {
			if(objFormList.getKind()!=Obj.Elem && objFormList.getKind()!=Obj.Var) {
				//report_error("Greska na liniji : " + designatorForm.getLine()+" Designator/i sa leve strane nisu promenljiva ili clan niza" ,null);
				designatorForm.obj=new Obj(Obj.Fld,"nebitno",new Struct(Struct.None));
			}
			else {
				designatorForm.obj=objFormList;
			}
		}
		else if(objForm!=Tab.noObj && objFormList==Tab.noObj) {
			if(objForm.getKind()!=Obj.Elem && objForm.getKind()!=Obj.Var) {
				//report_error("Greska na liniji : " + designatorForm.getLine()+" Designator/i sa leve strane nisu promenljiva ili clan niza" ,null);
				designatorForm.obj=new Obj(Obj.Fld,"nebitno",new Struct(Struct.None));
			}
			else {
				
				designatorForm.obj=objForm;
			}
		}
		else if(objForm!=Tab.noObj && objFormList!=Tab.noObj) {
			if((objForm.getKind()!=Obj.Elem && objForm.getKind()!=Obj.Var ) || ( objFormList.getKind()!=Obj.Elem && objFormList.getKind()!=Obj.Var)) {
				//report_error("Greska na liniji : " + designatorForm.getLine()+" Designator/i sa leve strane nisu promenljiva ili clan niza" ,null);
				designatorForm.obj=new Obj(Obj.Fld,"nebitno",new Struct(Struct.None));
			}
			else if(objForm.getType().getKind()!=objFormList.getType().getKind()) {
				//report_error("Greska na liniji : " + designatorForm.getLine()+" Designatori u listi nisu istih tipova vrednosti" ,null);
				designatorForm.obj=new Obj(Obj.Fld,"nebitno",new Struct(Struct.None));
			}
			else {
				designatorForm.obj=objForm;
			}
		}
	}
	
	public void visit(NoDesignatorForm designatorForm) {
		designatorForm.obj=Tab.noObj;
	}
	
	
	
	
	public void visit(DesignatorNoExpr designator) {
		
		Obj obj =Tab.find(designator.getDesName());
		if (obj==Tab.noObj) {report_error("Greska na liniji : " + designator.getLine()+"  ime : " +designator.getDesName()+" nije deklarisanoo", null);}
		else {
			report_info(" na liniji : " + designator.getLine()+"  se koristi promenljiva : " +designator.getDesName(), null);
		}
		designator.obj=obj;
	}
	
	public void visit(DesignatorExpr designator) {
		Obj obj =Tab.find(designator.getDesignatorName().getDesName());
		if (obj==Tab.noObj) {report_error("Greska na liniji " + designator.getLine()+": ime " +designator.getDesignatorName().getDesName()+" nije deklarisano", null);}
		else {
			if(obj.getType().getKind()!=Struct.Array || designator.getExpr().struct.getKind()!=Struct.Int) {
				report_error("Greska na liniji : " + designator.getLine()+" designator[expr] -> designator : " +designator.getDesignatorName().getDesName()+" nije niz ili expr nije int", null);
			}
			else {
				report_info(" na liniji : " + designator.getLine()+"  se koristi promenljiva (niz) : " +designator.getDesignatorName().getDesName(), null);
			}
		}
		designator.obj=new Obj(Obj.Elem,"clanniza",obj.getType().getElemType());
		
		designator.getDesignatorName().obj=obj;
	
		
	}
	
	
	public void visit(DesignatorName designator) {
		//Obj obj =Tab.find(designator.getDesName());
		//designator.obj=new Obj(Obj.Elem,"clanniza",obj.getType().getElemType());
	}
	
	
	public void visit(ExprMinus expr) {
		if(expr.getTerm().struct.getKind()!=Struct.Int || expr.getAddopTermList().struct.getKind()!=Struct.Int) {
			report_error("Greska na liniji : " + expr.getLine()+"  Expr= - term {addop term} -> Term nije int " , null);
		}
			expr.struct=expr.getTerm().struct;
		
	}
	
	public void visit(ExprPositive expr) {
		if(expr.getTerm().struct.getKind()!=Struct.Int || expr.getAddopTermList().struct.getKind()!=Struct.Int) {
			report_error("Greska na liniji : " + expr.getLine()+"  Expr= term {addop term} -> Term nije int " , null);
		}
		expr.struct=expr.getTerm().struct;
	}
	
	public void visit(ExprMinusNoTermList expr) {
		if(expr.getTerm().struct.getKind()!=Struct.Int) {
			report_error("Greska na liniji : " + expr.getLine()+"  Expr= - term {addop term} -> Term nije int " , null);
		}
			expr.struct=expr.getTerm().struct;
	}
	
	public void visit(ExprPOsitiveNoTermList expr) {
		
		expr.struct=expr.getTerm().struct;
	}
	
	public void visit(AddopTermListExist addopterm) {
		addopterm.struct=addopterm.getTerm().struct;
	}
	public void visit(NoAddopTerm addopterm) {
		addopterm.struct=addopterm.getTerm().struct;
	}
	
	
	
	public void visit(TermNoMulop term) {
		term.struct=term.getFactor().struct;
	}
	
	public void visit(TermYesMulop term) {
		if(term.getFactor().struct.getKind()!=Struct.Int || term.getMulopFactorList().struct.getKind()!=Struct.Int) {
			report_error("Greska na liniji : " + term.getLine()+"  Term = Term Mulop Factor -> Term i/ili Factor nisu int " , null);
		}
		term.struct=term.getFactor().struct;
		
	}
	
	public void visit(MulopFactorListExist mulopfactor) {
		mulopfactor.struct=mulopfactor.getFactor().struct;
	}
	public void visit(NoMulopFactor mulopfactor) {
		mulopfactor.struct=mulopfactor.getFactor().struct;
	}
	
	
	public void visit(NumFactor numFactor){
		numFactor.struct = Tab.intType;    	
	}
	public void visit(CharFactor charFactor) {
		charFactor.struct=Tab.charType;
	}
	public void visit(BoolFactor boolFactor) {
		boolFactor.struct=Tab.find("bool").getType();
	}
	public void visit(NewFactor newFactor) {
		if(newFactor.getExpr().struct.getKind()!= Struct.Int) {
			report_error("Greska na liniji : " + newFactor.getLine()+"  Factor = new Type [Expr] -> Expr nije int "  , null);
		}
			newFactor.struct=newFactor.getType().struct;
		
	}
	public void visit(ExprFactor exprFacotr) {
		exprFacotr.struct=exprFacotr.getExpr().struct;
	}
	public void visit(DesignatorFactor designatorFactor) {
		designatorFactor.struct=designatorFactor.getDesignator().obj.getType();
	}
	
	public void visit(AddopPlus addop) {
		
	}
	
	public void visit(AddopMinus addop) {
		
	}
	

	
	/*public void visit(Assignment assignment) {
		if (!assignment.getExpr().struct.assignableTo(assignment.getDesignator().obj.getType()))
			report_error("Greska na liniji " + assignment.getLine() + " : " + " nekompatibilni tipovi u dodeli vrednosti ", null);
	}

	

	public void visit(ReturnExpr returnExpr){
		returnFound = true;
		Struct currMethType = currentMethod.getType();
		if (!currMethType.compatibleWith(returnExpr.getExpr().struct)) {
			report_error("Greska na liniji " + returnExpr.getLine() + " : " + "tip izraza u return naredbi ne slaze se sa tipom povratne vrednosti funkcije " + currentMethod.getName(), null);
		}			  	     	
	}

	public void visit(ProcCall procCall){
		Obj func = procCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) { 
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + procCall.getLine(), null);
			//RESULT = func.getType();
		} 
		else {
			report_error("Greska na liniji " + procCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
			//RESULT = Tab.noType;
		}     	
	}    

	public void visit(AddExpr addExpr) {
		Struct te = addExpr.getExpr().struct;
		Struct t = addExpr.getTerm().struct;
		if (te.equals(t) && te == Tab.intType)
			addExpr.struct = te;
		else {
			report_error("Greska na liniji "+ addExpr.getLine()+" : nekompatibilni tipovi u izrazu za sabiranje.", null);
			addExpr.struct = Tab.noType;
		} 
	}

	public void visit(TermExpr termExpr) {
		termExpr.struct = termExpr.getTerm().struct;
	}

	public void visit(Term term) {
		term.struct = term.getFactor().struct;    	
	}

	public void visit(Const cnst){
		cnst.struct = Tab.intType;    	
	}
	
	public void visit(Var var) {
		var.struct = var.getDesignator().obj.getType();
	}

	public void visit(FuncCall funcCall){
		Obj func = funcCall.getDesignator().obj;
		if (Obj.Meth == func.getKind()) { 
			report_info("Pronadjen poziv funkcije " + func.getName() + " na liniji " + funcCall.getLine(), null);
			funcCall.struct = func.getType();
		} 
		else {
			report_error("Greska na liniji " + funcCall.getLine()+" : ime " + func.getName() + " nije funkcija!", null);
			funcCall.struct = Tab.noType;
		}

	}

	public void visit(Designator designator){
		Obj obj = Tab.find(designator.getName());
		if (obj == Tab.noObj) { 
			report_error("Greska na liniji " + designator.getLine()+ " : ime "+designator.getName()+" nije deklarisano! ", null);
		}
		designator.obj = obj;
	}
	*/
	public boolean passed() {
		return !errorDetected;
	}
	
}

