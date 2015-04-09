
	public class Function implements AST{

		private Operators op;
		private AST argument;
		
		public double getValue(){
			return op.apply(argument.getValue());
		}
		
		public Function(AST argument, Operators op){
			this.argument = argument;
			this.op = op;
		}
		
		public Operators getOp(){
			return op;
		}
		
		@Override
		public double accept(ASTVisitor visitor) {
			return visitor.visit(this);		
		}

		public AST getArg() {
			return argument;
		}

		public void setArg(AST argument) {
			this.argument = argument;
		}
	}


