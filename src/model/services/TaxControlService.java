package model.services;

public class TaxControlService implements TaxService{

	@Override
	public double paymentFee(double amount) {
		return amount * 0.02;
	}

	@Override
	public double interest(double amount, int num) {
		return amount * 0.01 * num;
	}
	


}
