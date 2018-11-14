
public class ActivatedFunctions {
	static double relu(double x) {
		return (x > 0 ? x : 0);
	}
	
	static double derivated_relu(double x) {
		return (x > 0 ? 1 : 0);
	}
	
	static double linear(double x) {
		return x;
	}
	
	public static double derivated_linear(double x) {
		return 1;
	}
	
	public static double sigmoid(double x) {
		return 1/(1+Math.pow(Math.E,-x));
	}
}
