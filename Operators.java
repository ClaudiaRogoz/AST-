public enum Operators {
	
	PLUS("+"),
	MINUS("-"), 
	MULT("*"),
	DIV("/"),
	POW("^"),
	SQRT("sqrt"),
	LOG("log"),
	SIN("sin"),
	COS("cos"),
	UNARY("-"),
	OPENBRACKET("("),
	CLOSEBRACKET(")");
	
	
	private String name;
	
	private Operators(String name) 
		{ 
		this.name = name;
		}
	
	public String toString() 
		{ return name; }
	
	public static int parsePrior(String s){

		if (Operators.MINUS.name.equals(s) || Operators.PLUS.name.equals(s)) 
			return 0;

		if (Operators.POW.name.equals(s) || Operators.DIV.name.equals(s)
				|| Operators.MULT.name.equals(s) )
			return 1;
		
		if (Operators.COS.name.equals(s) || Operators.SIN.name.equals(s) ||
				Operators.LOG.name.equals(s) || Operators.SQRT.name.equals(s))
			return 2;
		
		if (Operators.UNARY.name.equals(s) )
			return 2;
		if ( Operators.OPENBRACKET.name.equals(s) || Operators.CLOSEBRACKET.name.equals(s))
			return 3;
		
		else return -1; 
		//throw new UnsupportedOperationException(s);
	}
	
	public static boolean isOpenBracket(String s){
		if ( Operators.OPENBRACKET.name.equals(s) )
			return true;
		return false;
	}
	
	public static int isCloseBracket(String s){
		if ( Operators.CLOSEBRACKET.name.equals(s) )
			return 1;
		return 0;
	}
	
	public static Operators parseOp(String s) {
		if (Operators.PLUS.name.equals(s)) 
			return Operators.PLUS;
		if (Operators.MINUS.name.equals(s)) 
			return Operators.MINUS;
		if (Operators.MULT.name.equals(s)) 
			return Operators.MULT;
		if (Operators.DIV.name.equals(s)) 
			return Operators.DIV;
		if (Operators.POW.name.equals(s))
			return Operators.POW;
		if (Operators.SQRT.name.equals(s))
			return Operators.SQRT;
		if (Operators.LOG.name.equals(s))
			return Operators.LOG;
		if (Operators.SIN.name.equals(s))
			return Operators.SIN;
		if (Operators.COS.name.equals(s))
			return Operators.COS;
		throw new UnsupportedOperationException(s);
	}

	public double apply(double d, double e) {
		switch (this) {
			case PLUS: return d + e; 
			case MINUS: return d - e; 
			case MULT: return d * e; 
			case DIV: return d / e;
			case POW: return Math.pow(e , d);
			default: 
			throw new UnsupportedOperationException(this.toString());
		}
	}
	
	
	public double apply (double d){
		switch(this) {
			case SQRT: return Math.sqrt(d);
			case LOG: return Math.log10(d);
			case SIN: return Math.sin(d);
			case COS: return Math.cos(d);
		default:
			throw new UnsupportedOperationException(this.toString());
			
		}
	}
	
}