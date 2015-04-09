
public class Constant implements AST{

	private int value;

	
	public Constant (int value){
		this.setValue(value);
	}
	
	@Override
	public double accept(ASTVisitor visitor) {
		return visitor.visit(this);
		
	}

	public double getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
