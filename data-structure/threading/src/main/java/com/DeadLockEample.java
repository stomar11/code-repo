package com;

public class DeadLockEample {

	String str1 = "Java";
	String str2 = "UNIX";

	Thread t1 = new Thread("My Thread 1") {
		public void run() {
			while (true) {
				synchronized (str1) {
					synchronized (str2) {
						System.out.println(str1 + str2);
					}
				}
			}
		}
	};

	Thread t2 = new Thread("My Thread 2") {
		public void run() {
			while (true) {
				synchronized (str2) {
					synchronized (str1) {
						System.out.println(str2 + str1);
					}
				}
			}
		}
	};

	public static void main(String a[]) {
		DeadLockEample runner = new DeadLockEample();
		runner.t1.start();
		runner.t2.start();
	}
}