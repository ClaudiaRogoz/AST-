
interface ASTVisitor{
	
	  /**  Visit a Constant Node */
	  public abstract double visit(Constant node);
	  
	  /**  Visit an Operator Node */
	  public abstract double visit(Operator node);
	  
	  public abstract double visit(ExponentationOperator node);
	  
	  public abstract double visit(Function node);

	public abstract double visit(UnaryMinus unaryMinus);
	  
}
