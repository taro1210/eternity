package exB2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Kadai7_ouyou {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		System.out.println("実行するクラスを入力して下さい。");
		System.out.print("例)「Aクラス」を実行する場合は「A」と入力 >");
		String inputX = new java.util.Scanner(System.in).nextLine();
		Class<?> clazz = null;
		switch (inputX) {
		case "A":
		case "a":
			clazz = ReflectionClassA.class;
			break;

		case "B":
		case "b":
			clazz = ReflectionClassB.class;
			break;

		case "C":
		case "c":
			clazz = ReflectionClassC.class;
			break;

		default:
			clazz = ReflectionClassD.class;
		}
		Object m = clazz.newInstance();
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			try {
				// reflectionTestObjのメソッドの実行 引数はなし
				method.invoke(m, null);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		}

	}
}