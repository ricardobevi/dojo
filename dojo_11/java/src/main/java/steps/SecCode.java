package steps;

public class SecCode implements CheckoutStep {

	CheckoutStep nextStep;

	public SecCode(CheckoutStep nextStep) {
		this.nextStep = nextStep;
	}

	public CheckoutStep input(int secCode) {
		return nextStep;
	}

}
