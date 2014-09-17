package com.paypal.compliance.refactor.exercise;

import java.io.IOException;

public class InputProcessor {	

	public static AmortizationInput processInput()
	{
		String[] userPrompts = {
				"Please enter the amount you would like to borrow: ",
				"Please enter the annual percentage rate used to repay the loan: ",
				"Please enter the term, in years, over which the loan is repaid: "
		};

		String line = "";
		double amount = 0;
		double apr = 0;
		int years = 0;
		AmortizationInput input = new AmortizationInput();

		for (int i = 0; i< userPrompts.length; ) {
			String userPrompt = userPrompts[i];
			try {
				line = ConsoleHelper.readLine(userPrompt);
			} catch (IOException e) {
				ConsoleHelper.print("An IOException was encountered. Terminating program.\n");
				return null;
			}
			boolean isValidValue = true;
			try {
				switch (i) {
				case 0:
					amount = Double.parseDouble(line);
					if (isValidBorrowAmount(amount) == false) {
						isValidValue = false;
						double range[] = getBorrowAmountRange();
						ConsoleHelper.print("Please enter a positive value between " + range[0] + " and " + range[1] + ". ");
					}
					input.setAmount(amount);
					break;
				case 1:
					apr = Double.parseDouble(line);
					if (isValidAPRValue(apr) == false) {
						isValidValue = false;
						double range[] = getAPRRange();
						ConsoleHelper.print("Please enter a positive value between " + range[0] + " and " + range[1] + ". ");
					}
					input.setApr(apr);
					break;
				case 2:
					years = Integer.parseInt(line);
					if (isValidTerm(years) == false) {
						isValidValue = false;
						int range[] = getTermRange();
						ConsoleHelper.print("Please enter a positive integer value between " + range[0] + " and " + range[1] + ". ");
					}
					input.setYears(years);
					break;
				}
			} catch (NumberFormatException e) {
				isValidValue = false;
			}
			if (isValidValue) {
				i++;
			} else {
				ConsoleHelper.print("An invalid value was entered.\n");
			}			
		}
		return input;
	}

	public static boolean isValidBorrowAmount(double amount) {
		double range[] = getBorrowAmountRange();
		return ((range[0] <= amount) && (amount <= range[1]));
	}

	public static boolean isValidAPRValue(double rate) {
		double range[] = getAPRRange();
		return ((range[0] <= rate) && (rate <= range[1]));
	}

	public static boolean isValidTerm(int years) {
		int range[] = getTermRange();
		return ((range[0] <= years) && (years <= range[1]));
	}

	public static final double[] getBorrowAmountRange() {
		return AmortizationConstants.borrowAmountRange;
	}

	public static final double[] getAPRRange() {
		return AmortizationConstants.aprRange;
	}

	public static final int[] getTermRange() {
		return AmortizationConstants.termRange;
	}

}
