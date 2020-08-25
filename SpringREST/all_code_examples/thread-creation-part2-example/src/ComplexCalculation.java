import java.math.BigInteger;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ComplexCalculation {

	public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2)
			throws InterruptedException {
		BigInteger result = BigInteger.ONE;

		Long startTime = null;
		Long endTime = null;
		List<PowerCalculatingThread> threads = new ArrayList<>();

		threads.add(new PowerCalculatingThread(base1, power1));
		threads.add(new PowerCalculatingThread(base2, power2));

		for (Thread thread : threads) {
			thread.start();
			startTime= System.currentTimeMillis();
		}

		try {
			for (Thread thread : threads) {
				thread.join(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if ((startTime - System.currentTimeMillis()) > 2000) {
			for (Thread thread : threads) {
				thread.interrupt();
				
			}
			System.exit(0);
		}

		for (int i = 0; i < threads.size(); i++) {
			PowerCalculatingThread powerCalculatingThread = threads.get(i);
			if (powerCalculatingThread.isFinished()) {
				System.out.println("Power of " + powerCalculatingThread.base + " to " + powerCalculatingThread.power
						+ " is = " + powerCalculatingThread.getResult());
				System.exit(0);
			} else {
				System.out.println("Power of " + powerCalculatingThread.base + " to " + powerCalculatingThread.power
						+ " is  in progress");
			}
			if (Thread.currentThread().isInterrupted()) {
				System.out.println("Prematurely interrupted computation");
				return BigInteger.ZERO;
			}
		}
		return result;
	}

	public static void main(String[] args) throws InterruptedException {
		ComplexCalculation complexCalculation = new ComplexCalculation();

		System.out.println(
				"Result is = "+complexCalculation.calculateResult(BigInteger.ONE, BigInteger.TEN, BigInteger.ONE, BigInteger.TEN));

	}

	private static class PowerCalculatingThread extends Thread {
		private BigInteger result = BigInteger.ONE;
		private BigInteger base;
		private BigInteger power;
		private Boolean isFinished = false;

		public PowerCalculatingThread(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			this.result = calculatePower(base, power);
			this.isFinished = true;
		}

		public BigInteger calculatePower(BigInteger base, BigInteger power) {
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i.add(BigInteger.ONE)) {
				result = result.multiply(base);
			}
			return result;
		}

		public Boolean isFinished() {
			return isFinished;
		}

		public BigInteger getResult() {
			return result;
		}
	}
}