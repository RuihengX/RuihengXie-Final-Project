package app.controller;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class HelperLoanCalc {
	
	private double LoanAmount;
	private double AdditionalPayment;
	private int NbrOfYears;
	private double InterestRate;
	
	
	public HelperLoanCalc(double LoanAmount, double InterestRate, int NbrOfYears, double AdditionalPayment) {
		this.LoanAmount = LoanAmount;
		this.InterestRate = InterestRate;
		this.NbrOfYears = NbrOfYears;
		this.AdditionalPayment = AdditionalPayment;
		
	}

	public double getLoanAmount() {
		return LoanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		LoanAmount = loanAmount;
	}

	public double getAdditionalPayment() {
		return AdditionalPayment;
	}

	public void setAdditionalPayment(double additionalPayment) {
		AdditionalPayment = additionalPayment;
	}

	public int getNbrOfYears() {
		return NbrOfYears;
	}

	public void setNbrOfYears(int nbrOfYears) {
		NbrOfYears = nbrOfYears;
	}

	public double getInterestRate() {
		return InterestRate;
	}

	public void setInterestRate(double interestRate) {
		InterestRate = interestRate;
	}

	public double CalculateInterest(double amount) {
		double rate = InterestRate/12;
		double interest = amount*rate;
		return interest;
	}
	
	public double CalculatePMT() {
		double r = InterestRate/12;
		double n = NbrOfYears*12;
		double p = LoanAmount;
		double f = 0;
		boolean t = false;
		
		double ConstantPayment = Math.abs(FinanceLib.pmt(r, n, p, f, t));
		return ConstantPayment;
	}
	
	public double CalculateTotalPayment() {
		double interest = 0;
		double PPMT = 0;
		double pv = LoanAmount;
		
		while(PPMT + AdditionalPayment < pv) {
			double PMT = CalculatePMT();
			pv -= PPMT + AdditionalPayment;
			PPMT = PMT - CalculateInterest(pv);
			interest += PMT-PPMT;
			System.out.println(PPMT+AdditionalPayment);
		}
		Double FinalInterest = CalculateInterest(pv);
		return interest + LoanAmount + FinalInterest;
	}
	
	public double CalculateTotalInterest() {
		double TotalInterest = CalculateTotalPayment() - LoanAmount;
		return TotalInterest;
	}
}