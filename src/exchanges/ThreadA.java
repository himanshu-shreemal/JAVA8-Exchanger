package exchanges;

import java.util.Arrays;
import java.util.concurrent.Exchanger;
import java.util.stream.Stream;

public class ThreadA implements Runnable {

	Exchanger<Character> exe;

	public ThreadA(Exchanger<Character> exe) {
		this.exe = exe;
	}

	@Override
	public void run() {
		char ch = 'A';
		char result;
		char generated[] = new char[5];
		char received[] = new char[5];
		Thread.currentThread().setName("A");
		for (int i = 0; i < 5; ++i, ++ch) {
			System.out.println("Generate By " + Thread.currentThread().getName() +" : " + ch);
			System.out.println("Request to exchange with Thread B ");
			try {
				result = exe.exchange(ch);
				System.out.println("Got the value from Thread A : " + result);
				generated[i] = ch;
				received[i] = result;
			} catch (InterruptedException e) {
				System.out.println("Error while exchanging the data");
			}

		}
		System.out.println("Exchange work is done from thread A");
		System.out.println("Generated characters at A : " + Arrays.toString(generated));
		System.out.println("Received characters at A : " +Arrays.toString(received));
	}

}
