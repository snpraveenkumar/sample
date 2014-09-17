package com.paypal.compliance.refactor.exercise;

public class AmortizationConstants {
	
	public static final String HeaderFormat = "%1$-20s%2$-20s%3$-20s%4$s,%5$s,%6$s\n";
	public static final String outputFormat = "%1$-20d%2$-20.2f%3$-20.2f%4$.2f,%5$.2f,%6$.2f\n";	
	public static final double[] aprRange = new double[] { 0.000001d, 100d };
	public static final int[] termRange = new int[] { 1, 1000000 };
	public static final double[] borrowAmountRange = new double[] { 0.01d, 1000000000000d };

}
