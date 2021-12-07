package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class InstallmentService {

	private TaxService taxService;
	
	public InstallmentService() {
		
	}

	public InstallmentService(TaxService taxService) {
		this.taxService = taxService;
	}
	
	public void proccessContract(Contract contract, int num) {
		double basicQuota = contract.getTotalValue() / num;
		for (int i=1; i<=num; i++) {
			double updatedQuota = basicQuota + taxService.interest(basicQuota, i);
			double fullQuota = updatedQuota + taxService.paymentFee(updatedQuota);
			Date dueDate = addMonths(contract.getDate(), i);
			contract.getInstallment().add(new Installment(dueDate, fullQuota));
		}
	}
	
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
	
}
