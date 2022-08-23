//
// Generated by JTB 1.3.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * Provides default methods which visit each node in the tree in depth-first
 * order.  Your visitors may extend this class.
 */
public class GJDepthFirst<R,A> implements GJVisitor<R,A> {
   //
   // Auto class visitors--probably don't need to be overridden.
   //
   public R visit(NodeList n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeListOptional n, A argu) {
      if ( n.present() ) {
         R _ret=null;
         int _count=0;
         for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
            e.nextElement().accept(this,argu);
            _count++;
         }
         return _ret;
      }
      else
         return null;
   }

   public R visit(NodeOptional n, A argu) {
      if ( n.present() ) {
    	  String s=(String)n.node.accept(this,argu);
    	  if(s!=null) {
    		  s=s+":";
    		  System.out.println(s);
    	  }
         return n.node.accept(this,argu);
      }
         else
         return null;
   }

   public R visit(NodeSequence n, A argu) {
      R _ret=null;
      int _count=0;
      for ( Enumeration<Node> e = n.elements(); e.hasMoreElements(); ) {
         e.nextElement().accept(this,argu);
         _count++;
      }
      return _ret;
   }

   public R visit(NodeToken n, A argu) { return null; }

   //
   // User-generated visitor methods below
   //
   public class args{
	   int arg1;
	   int arg2;
	   int arg3;
   }
   
   public args createArgs() {
	   args a=new args();
	   a.arg1=0;
	   a.arg2=0;
	   a.arg3=0;
	   return a;
	   
   }
   /**
    * f0 -> "MAIN"
    * f1 -> "["
    * f2 -> IntegerLiteral()
    * f3 -> "]"
    * f4 -> "["
    * f5 -> IntegerLiteral()
    * f6 -> "]"
    * f7 -> "["
    * f8 -> IntegerLiteral()
    * f9 -> "]"
    * f10 -> StmtList()
    * f11 -> "END"
    * f12 -> ( SpillInfo() )?
    * f13 -> ( Procedure() )*
    * f14 -> <EOF>
    */
   
   Vector<String> reg=new Vector<String>();
   
   
   public R visit(Goal n, A argu) {
      R _ret=null;
      System.out.println("\t.text");
      System.out.println("\t.globl           main");
      System.out.println("main:");
      
      for(int i=0;i<=3;i++) {
    	  reg.add("a"+i);
      }
      for(int i=0;i<=7;i++) {
    	  reg.add("t"+i);
      }
      for(int i=0;i<=7;i++) {
    	  reg.add("s"+i);
      }
      reg.add("t8");
      reg.add("t9");
      for(int i=0;i<=1;i++) {
    	  reg.add("v"+i);
      }
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      String arg1=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      String arg2=(String)n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      String arg3=(String)n.f8.accept(this, argu);
      args a=createArgs();
      a.arg1=Integer.parseInt(arg1);
      a.arg2=Integer.parseInt(arg2);
      a.arg3=Integer.parseInt(arg3);
      int x=a.arg2+2;
      x*=4;
      argu=(A)a;
      int y=Math.max(0,a.arg3-4);
      x=x+y*4;
      
      System.out.println("\tmove $fp, $sp\n"
      		+ "        subu $sp, $sp, "+x+"\n"
      		+ "        sw $ra, -4($fp)");
      n.f9.accept(this, argu);
      n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      System.out.println("\tlw $ra, -4($fp)");
      System.out.println("\taddu $sp, $sp, "+x);
      System.out.println("\tjal _exitret");
//      System.out.println("li $v0 10");
//      System.out.println("syscall");
      n.f12.accept(this, argu);
      n.f13.accept(this, argu);
      n.f14.accept(this, argu);
      //System.out.println(reg);
System.out.println("         .text\n"
		+ "         .globl _halloc\n"
		+ "_halloc:\n"
		+ "         li $v0, 9\n"
		+ "         syscall\n"
		+ "         jr $ra\n"
		+ "\n"
		+ "         .text\n"
		+ "         .globl _print\n"
		+ "_print:\n"
		+ "         li $v0, 1\n"
		+ "         syscall\n"
		+ "         la $a0, newl\n"
		+ "         li $v0, 4\n"
		+ "         syscall\n"
		+ "         jr $ra\n"
		+ "\n"
		+"          .text\n"
		+ "         .globl _exitret\n"
		+ "_exitret:\n"
		+ "         li $v0, 10\n"
		+ "         syscall\n"
		+ "\n"
		+ "         .data\n"
		+ "         .align   0\n"
		+ "newl:    .asciiz \"\\n\" \n"
		+ "         .data\n"
		+ "         .align   0\n"
		+ "str_er:  .asciiz \" ERROR: abnormal termination\\n\" \n"
		+ "");
      return _ret;
   }

   /**
    * f0 -> ( ( Label() )? Stmt() )*
    */
   public R visit(StmtList n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> Label()
    * f1 -> "["
    * f2 -> IntegerLiteral()
    * f3 -> "]"
    * f4 -> "["
    * f5 -> IntegerLiteral()
    * f6 -> "]"
    * f7 -> "["
    * f8 -> IntegerLiteral()
    * f9 -> "]"
    * f10 -> StmtList()
    * f11 -> "END"
    * f12 -> ( SpillInfo() )?
    */
   public R visit(Procedure n, A argu) {
      R _ret=null;
      String fn=(String)n.f0.accept(this, argu);
      System.out.println("\t.text");
      System.out.println("\t.globl           "+fn);
      System.out.println(fn+":");
      args a=createArgs();
      n.f1.accept(this, argu);
      String arg1=(String)n.f2.accept(this, argu);
      n.f3.accept(this, argu);
      n.f4.accept(this, argu);
      String arg2=(String)n.f5.accept(this, argu);
      n.f6.accept(this, argu);
      n.f7.accept(this, argu);
      String arg3=(String)n.f8.accept(this, argu);
      a.arg1=Integer.parseInt(arg1);
      a.arg2=Integer.parseInt(arg2);
      a.arg3=Integer.parseInt(arg3);
      argu=(A)a;
      n.f9.accept(this, argu);
      int x=a.arg2+2;
      x*=4;
      int y=Math.max(0, a.arg3-4);
    	  x=x+y*4;
      System.out.println("\tsw $fp, -8($sp)");
      System.out.println("\tmove $fp, $sp");
      System.out.println("\tsubu $sp, $sp, "+x);
      System.out.println("\tsw $ra, -4($fp)");
      n.f10.accept(this, argu);
      n.f11.accept(this, argu);
      n.f12.accept(this, argu);
      System.out.println("\tlw $ra, -4($fp)");
      System.out.println("\tlw $fp, "+(x-8)+"($sp)");
      System.out.println("\taddu $sp, $sp, "+x);
      System.out.println("\tjr $ra");
      return _ret;
   }

   /**
    * f0 -> NoOpStmt()
    *       | ErrorStmt()
    *       | CJumpStmt()
    *       | JumpStmt()
    *       | HStoreStmt()
    *       | HLoadStmt()
    *       | MoveStmt()
    *       | PrintStmt()
    *       | ALoadStmt()
    *       | AStoreStmt()
    *       | PassArgStmt()
    *       | CallStmt()
    */
   public R visit(Stmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> "NOOP"
    */
   public R visit(NoOpStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      System.out.println("\tnop");
      return _ret;
   }

   /**
    * f0 -> "ERROR"
    */
   public R visit(ErrorStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
     System.out.println("      li $v0, 4\n"
     		+ "la $a0, str_er\n"
     		+ "         syscall\n"
     		+ "         li $v0, 10\n"
     		+ "         syscall");
      return _ret;
   }

   /**
    * f0 -> "CJUMP"
    * f1 -> Reg()
    * f2 -> Label()
    */
   public R visit(CJumpStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String r=(String)n.f1.accept(this, argu);
      String l=(String)n.f2.accept(this, argu);
      System.out.println("\tbeqz $"+r+" "+l);
      return _ret;
   }

   /**
    * f0 -> "JUMP"
    * f1 -> Label()
    */
   public R visit(JumpStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String l=(String)n.f1.accept(this, argu);
      System.out.println("\tb "+l);
      return _ret;
   }

   /**
    * f0 -> "HSTORE"
    * f1 -> Reg()
    * f2 -> IntegerLiteral()
    * f3 -> Reg()
    */
   public R visit(HStoreStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String reg1=(String)n.f1.accept(this, argu);
      String offset=(String)n.f2.accept(this, argu);
      String reg2=(String)n.f3.accept(this, argu);
      System.out.println("\tsw $"+reg2+", "+offset+"($"+reg1+")");
      return _ret;
   }

   /**
    * f0 -> "HLOAD"
    * f1 -> Reg()
    * f2 -> Reg()
    * f3 -> IntegerLiteral()
    */
   public R visit(HLoadStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String reg1=(String)n.f1.accept(this, argu);
      String reg2=(String)n.f2.accept(this, argu);
      String offset=(String)n.f3.accept(this, argu);
      System.out.println("\tlw $"+reg1+", "+offset+"($"+reg2+")");
      return _ret;
   }

   /**
    * f0 -> "MOVE"
    * f1 -> Reg()
    * f2 -> Exp()
    */
   public R visit(MoveStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String r=(String)n.f1.accept(this, argu);
      argu=(A)r;
      n.f2.accept(this, argu);
      //System.out.println("move $"+r);
      return _ret;
   }

   /**
    * f0 -> "PRINT"
    * f1 -> SimpleExp()
    */
   public R visit(PrintStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      Vector<String> temp=(Vector<String>)n.f1.accept(this, argu);
      Vector<String> vec=new Vector<String>();
      vec.add("move $a0 $");
      vec.add("lo $a0 ");
      vec.add("la $a0 ");
      System.out.println("\t"+vec.get(Integer.parseInt(temp.get(0)))+temp.get(1));
      System.out.println("\tjal _print");
      return _ret;
   }

   /**
    * f0 -> "ALOAD"
    * f1 -> Reg()
    * f2 -> SpilledArg()
    */
   public R visit(ALoadStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String reg=(String)n.f1.accept(this, argu);
      Vector<String> spillarg=(Vector<String>)n.f2.accept(this, argu);
      System.out.println("\tlw $"+reg+", "+spillarg.get(0));
      return _ret;
   }

   /**
    * f0 -> "ASTORE"
    * f1 -> SpilledArg()
    * f2 -> Reg()
    */
   public R visit(AStoreStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      Vector<String> spillarg=(Vector<String>)n.f1.accept(this, argu);
      String reg=(String)n.f2.accept(this, argu);
      System.out.println("\tsw $"+reg+", "+spillarg.get(0));
      return _ret;
   }

   /**
    * f0 -> "PASSARG"
    * f1 -> IntegerLiteral()
    * f2 -> Reg()
    */
   public R visit(PassArgStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      String s=(String)n.f1.accept(this, argu);
      String reg=(String)n.f2.accept(this, argu);
      int temp=Integer.parseInt(s)*4;
      temp-=4;
      System.out.println("\tsw $"+reg+", "+temp+"($sp)");
      return _ret;
   }

   /**
    * f0 -> "CALL"
    * f1 -> SimpleExp()
    */
   public R visit(CallStmt n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      Vector<String> vec=(Vector<String>)n.f1.accept(this, argu);
      Vector<String> out=new Vector<String>();
      
    	  out.add("jalr $");
              
          out.add("jal ");      
    	  out.add("jal ");
      //int i=0;
      int i=Integer.parseInt(vec.get(0));
      System.out.println("\t"+out.get(i)+vec.get(1));
      return _ret;
   }

   /**
    * f0 -> HAllocate()
    *       | BinOp()
    *       | SimpleExp()
    */
   public R visit(Exp n, A argu) {
      R _ret=null;
      Vector<String> s=(Vector<String>)n.f0.accept(this, argu);
      Vector<String> out=new Vector<String>();
      out.add("move $");
      out.add("li $");
      out.add("la $");
      if(n.f0.which==2) {
    	  int i=Integer.parseInt(s.get(0));
    	  if(i==0)
    		  System.out.println("\t"+out.get(i)+(String)argu+" $"+s.get(1));
    	  else
    		  System.out.println("\t"+out.get(i)+(String)argu+" "+s.get(1));
    		  
      }
      return _ret;
   }

   /**
    * f0 -> "HALLOCATE"
    * f1 -> SimpleExp()
    */
   public R visit(HAllocate n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      Vector<String> s=(Vector<String>)n.f1.accept(this, argu);
      Vector<String> out=new Vector<String>();
      out.add("move $a0 $");
      out.add("li $a0 ");
      int i=Integer.parseInt(s.get(0));
      System.out.println("\t"+out.get(i)+s.get(1));
      System.out.println("\tjal _halloc");
      System.out.println("\tmove $"+(String)argu+" $v0");
      return _ret;
   }

   /**
    * f0 -> Operator()
    * f1 -> Reg()
    * f2 -> SimpleExp()
    */
   public R visit(BinOp n, A argu) {
      R _ret=null;
      String op=(String)n.f0.accept(this, argu);
      String reg1=(String)n.f1.accept(this, argu);
      Vector<String> s=(Vector<String>)n.f2.accept(this, argu);
      Vector<String> out=new Vector<String>();
      out.add(op);
      out.add(op+"i");
      int i=Integer.parseInt(s.get(0));
      if(i==1){if(out.get(i)=="addi"){
      System.out.println("\t"+out.get(i)+" $"+(String)argu+", $"+reg1+", $"+s.get(1));
      return _ret;}}
      System.out.println("\t"+out.get(i)+" $"+(String)argu+", $"+reg1+", $"+s.get(1));
      
      return _ret;
   }

   /**
    * f0 -> "LE"
    *       | "NE"
    *       | "PLUS"
    *       | "MINUS"
    *       | "TIMES"
    *       | "DIV"
    */
   public R visit(Operator n, A argu) {
      R _ret=null;
      Vector<String> op=new Vector<String>();
      op.add("sle");op.add("sne");op.add("add");
      op.add("sub");op.add("mulo");op.add("div");
      n.f0.accept(this, argu);
      _ret=(R)op.get(n.f0.which);
      return _ret;
   }

   /**
    * f0 -> "SPILLEDARG"
    * f1 -> IntegerLiteral()
    */
   public R visit(SpilledArg n, A argu) {
      R _ret=null;
      args a=(args)argu;
      n.f0.accept(this, argu);
      String str=(String)n.f1.accept(this, argu);
      int temp=Integer.parseInt(str);
      int x=0;
      Vector<String> s=new Vector<String>();
      x=Math.max(0,a.arg1-4);
      int diff=temp-x;
      if(a.arg1>4&&diff<0) {
    	  s.add(" "+((x+diff)*4)+"($fp) ");
    	  _ret=(R)s;
    	  return _ret;
    	 
      }
      //int diff=temp-x;
      temp=diff;
      int y=Math.max(0, a.arg3-4);
      temp+=y;
      temp=temp*4;
      s.add(" "+temp+"($sp) ");
      _ret=(R)s;
      return _ret;
   }

   /**
    * f0 -> Reg()
    *       | IntegerLiteral()
    *       | Label()
    */
   public R visit(SimpleExp n, A argu) {
      R _ret=null;
      Vector<String> vec=new Vector<String>();
      vec.add(String.valueOf(n.f0.which));
      String s=(String)n.f0.accept(this, argu);
      vec.add(s);
      _ret=(R)vec;
      return _ret;
   }

   /**
    * f0 -> "a0"
    *       | "a1"
    *       | "a2"
    *       | "a3"
    *       | "t0"
    *       | "t1"
    *       | "t2"
    *       | "t3"
    *       | "t4"
    *       | "t5"
    *       | "t6"
    *       | "t7"
    *       | "s0"
    *       | "s1"
    *       | "s2"
    *       | "s3"
    *       | "s4"
    *       | "s5"
    *       | "s6"
    *       | "s7"
    *       | "t8"
    *       | "t9"
    *       | "v0"
    *       | "v1"
    */
   public R visit(Reg n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      _ret=(R)reg.get(n.f0.which);
      return _ret;
   }

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public R visit(IntegerLiteral n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      _ret=(R)n.f0.toString();
      return _ret;
   }

   /**
    * f0 -> <IDENTIFIER>
    */
   public R visit(Label n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      _ret=(R)n.f0.toString();
      return _ret;
   }

   /**
    * f0 -> "//"
    * f1 -> SpillStatus()
    */
   public R visit(SpillInfo n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      n.f1.accept(this, argu);
      return _ret;
   }

   /**
    * f0 -> <SPILLED>
    *       | <NOTSPILLED>
    */
   public R visit(SpillStatus n, A argu) {
      R _ret=null;
      n.f0.accept(this, argu);
      return _ret;
   }

}