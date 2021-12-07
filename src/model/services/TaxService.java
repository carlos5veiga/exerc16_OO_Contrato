package model.services;

public interface TaxService {

	double paymentFee(double amount);
	double interest(double amount, int num);
	
}
