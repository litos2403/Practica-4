import java.math.BigDecimal;
import java.util.Date;

public class MoneyLoan extends Loan{

	private BigDecimal amount;

	public MoneyLoan(Person p, Date loanDate, Date devolutionDate,BigDecimal amount,String comment) throws ArithmeticException {
		super(p, comment, loanDate, devolutionDate);
		if (amount.compareTo(BigDecimal.ZERO) > 0) {

			setAmount(amount);

		} else {

			throw new ArithmeticException();

		}

	}
	
	public MoneyLoan(Person p, Date loanDate, Date devolutionDate,BigDecimal amount) throws ArithmeticException {
		this(p, loanDate, devolutionDate, amount, null);
		//prueba
	}
	
	public MoneyLoan(Person p,BigDecimal amount) throws ArithmeticException {
		this(p, null, null, amount, null);
	}

	public MoneyLoan(Person p, Date loanDate, Date devolutionDate,MoneyLoan ml,String comment) throws ArithmeticException {
		this(p, loanDate, devolutionDate,ml.getAmount(), comment);
	}
	
	public MoneyLoan(Person p, Date loanDate, Date devolutionDate,MoneyLoan ml) throws ArithmeticException {
		this(p, loanDate, devolutionDate,ml.getAmount(), null);
	}
	
	public MoneyLoan(Person p, MoneyLoan ml) throws ArithmeticException {
		this(p, null, null,ml.getAmount(), null);
	}

	public BigDecimal getAmount() {

		return amount;

	}

	public void setAmount(BigDecimal amount) {

		this.amount = amount;

	}

	public void sumAmount(BigDecimal bd) {

		amount = amount.add(bd);

	}

	public void sumAmount(double d) {

		sumAmount(BigDecimal.valueOf(d));

	}

	public void subtractAmount(BigDecimal bd) throws IllegalArgumentException {

		if (amount.compareTo(bd) > 0) {

			amount = amount.subtract(bd);

		} else {

			throw new IllegalArgumentException();

		}

	}

	public void subtractAmount(double d) throws IllegalArgumentException {

		subtractAmount(BigDecimal.valueOf(d));

	}
	
	public void closeLoan() {

		if (!super.isClosed()) {

			super.closeLoan();

			BigDecimal prestamo=new BigDecimal(0);
			this.setAmount(prestamo);

		}
	}

}
