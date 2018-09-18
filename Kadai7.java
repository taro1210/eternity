package exB2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Kadai7 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("実行するクラスを入力して下さい。");
		System.out.print("例)「Aクラス」を実行する場合は「A」と入力 >");
		String inputX = new java.util.Scanner(System.in).nextLine();
		switch (inputX) {
		case "A":
		case "a":
			Class<ReflectionClassA> clazzA = ReflectionClassA.class;
			Method[] methods = clazzA.getDeclaredMethods();
			ReflectionClassA reflectionTestObj = new ReflectionClassA();
			for (Method method : methods) {
				try {
					// reflectionTestObjのメソッドの実行 引数はなし
					method.invoke(reflectionTestObj, null);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			break;

		case "B":
		case "b":
			Class<ReflectionClassB> clazzB = ReflectionClassB.class;
			methods = clazzB.getDeclaredMethods();
			ReflectionClassB reflectionTestObjB = new ReflectionClassB();
			for (Method method : methods) {
				try {
					// reflectionTestObjのメソッドの実行 引数はなし
					method.invoke(reflectionTestObjB, null);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			break;

		case "C":
		case "c":
			Class<ReflectionClassC> clazzC = ReflectionClassC.class;
			methods = clazzC.getDeclaredMethods();
			ReflectionClassC reflectionTestObjC = new ReflectionClassC();
			for (Method method : methods) {
				try {
					// reflectionTestObjのメソッドの実行 引数はなし
					method.invoke(reflectionTestObjC, null);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
			}
			break;

		default:
			System.out.println("Errer!!");
		}

	}
}
