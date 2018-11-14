package app;

class ActivatedFunctions {
	static double relu(double x) {
		return (x > 0 ? x : 0);
	}
	
	static double derivated_relu(double x) {
		return (x > 0 ? 1 : 0);
	}
	
	static double linear(double x) {
		return x;
	}

}
