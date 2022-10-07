package strings;

import java.util.List;

public class JoinKt {

	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3);
		String joinToString = JoinToStringKt.joinToString(list, ", ", "", "");
		System.out.println("joinToString = " + joinToString);

		String test = "              바 보      ";
		System.out.println("test = " + test.trim());
	}

}
