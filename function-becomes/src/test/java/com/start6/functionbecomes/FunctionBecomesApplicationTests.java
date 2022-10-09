package com.start6.functionbecomes;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

@SpringBootTest
class FunctionBecomesApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testLambda() {
		// 例子1
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("测试线程启动1");
			}
		}).start();


		new Thread(()->{
			System.out.println("测试线程启动，lambda表达式");
		}).start();

		// 例子2
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

		// 例子3
		printNum(new IntPredicate() {
			@Override
			public boolean test(int value) {
				return false;
			}
		});
		printNum((int value) -> value%2 == 0);
	}

	public static void printNum(IntPredicate intPredicate) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		for (int i : arr) {
			if(intPredicate.test(i)) {
				System.out.println("例子3" + i);
			}
		}
	}
	public static int calculateNum(IntBinaryOperator operator) {
		int a = 10;
		int b = 20;
		return operator.applyAsInt(a, b);
	}

	@Test
	public void testLambda1() {
		String integer = typeConver(new Function<String, String>() {
			@Override
			public String apply(String s) {
				return s + "zk";
			}
		});
		System.out.println(integer);

		Integer integer1 = typeConver((String s) -> Integer.valueOf(s));
		System.out.println(integer1);
	}
	public static <R> R typeConver(Function<String, R> function) {
		String str  = "1235";
		R result = function.apply(str);
		return result;
	}

	@Test
	public void testLambda2() {
		foreachArr(new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.println(value);
			}
		});

		foreachArr((int value)->{
			System.out.println(value);
		});
	}
	public static void foreachArr(IntConsumer consumer) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		for (int i : arr) {
			consumer.accept(i);
		}
	}
}
