
public class ExponentationOperator implements AST{

	private Operators op;
	private AST left;
	private AST right;
	
	public ExponentationOperator(AST left, Operators op, AST right){
		this.left = left;
		this.right = right;
		this.op = op;
	}
	
	public Operators getOp(){
		return op;
	}
	
	public AST getLeft() {
		return left;
	}

	public void setLeft(AST left) {
		this.left = left;
	}

	public AST getRight() {
		return right;
	}

	public void setRight(AST right) {
		this.right = right;
	}
	

	@Override
	public double accept(ASTVisitor visitor) {
		return visitor.visit(this);
		
	}

	@Override
	public double getValue() {
		return op.apply(right.getValue(), left.getValue());
	}

}
