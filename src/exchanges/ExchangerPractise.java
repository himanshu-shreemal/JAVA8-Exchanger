package exchanges;

import java.util.concurrent.Exchanger;

/*Simple exchanger example that can help to understand how exchanger works with/for thread*/

public class ExchangerPractise {

	// Create a exchane point.
	Exchanger<Character> exchange = new Exchanger();

	public static void main(String[] args) {
		new ExchangerPractise().startExchenging();
	}

	private void startExchenging() {

		// Pass exchnange point to both of the thread
		ThreadA a = new ThreadA(exchange);
		ThreadB b = new ThreadB(exchange);

		// Start both the threads
		new Thread(a).start();
		new Thread(b).start();

	}

}
