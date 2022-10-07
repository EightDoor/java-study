package com.start6.functionbecomes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.IntBinaryOperator;

@SpringBootTest
class FunctionBecomesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testLambda() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("测试线程启动1");
			}
		}).start();


		new Thread(()->{
			System.out.println("测试线程启动，lambda表达式");
		}).start();

		int num = calculateNum(new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {
				return left + right;
			}
		});
		System.out.println(num);

		int num1 = calculateNum((int left, int right) -> {
			return left + right;
		});
		System.out.println(num1);
	}

	public static int calculateNum(IntBinaryOperator operator) {
		int a = 10;
		int b = 20;
		return operator.applyAsInt(a, b);
	}
}
