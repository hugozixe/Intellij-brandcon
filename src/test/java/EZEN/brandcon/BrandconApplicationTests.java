package EZEN.brandcon;

import org.assertj.core.api.Assertions;
import org.assertj.core.internal.Integers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//@SpringBootTest
class BrandconApplicationTests {

	String solution(String cipher, int code) {
		// 주어진 String을 다 읽을 때까지 반복한다.
		// code번째 문자를 읽는다.
		// 기존에 이어 놓은 String에 합친다.
		// 합친 String을 return 한다.

		String result = "";

		// 주어진 String의 문자 하나하나를 다 읽을 때까지 반복
		for (int i = 0; i < cipher.length(); i++) {
			if ((i + 1) % code == 0) { // (i+1)번재가 code 값의 배수인지 확인
				char c = cipher.charAt(i); // 인덱스 i 자리의 문자 추출
				result = result + c; // 문자 이어 붙이기
			}
		}
		return result;
	}

	String 꼬리_문자열(List<String> strList, String ex) {
		return strList.stream().filter(s -> !s.endsWith(ex))
				.collect(Collectors.joining());
	}

	int 음양_더하기(int[] absolutes, boolean[] signs) {
		ArrayList<Integer> integers = new ArrayList<>();
		for (int i = 0; i < absolutes.length; i++) {
			// signs[i]
			if(signs[i]) { // sign 값이 true 이면
				integers.add(absolutes[i]);  // 양수로 추가
			} else {
				integers.add(-absolutes[i]); // 음수로 추가
			}
		}
		int result = 0;
//		for (Integer integer : integers) { // integer 에 .for 를 추가하면 자동으로 호출됨
//			result = result + integer;
//		}
		for (int i = 0; i < integers.size(); i++) {
			result = result + integers.get(i);
		}
		return result;
	}

	int 숫자_문자열과_영단어(String s) {
		Map<String, String> map = Map.of(
				"zero", "0",
				"one", "1",
				"two", "2",
				"three", "3",
				"four", "4",
				"five", "5",
				"six", "6",
				"seven", "7",
				"eight", "8",
				"nine", "9"
		);
		// 주어진 String에 map에 있는 key들(one, two, ...)이 있으면
		// 전부 value("1", "2", ...)로 교체해 준다.
		String result = s;
		// key 사이에는 순서는 없지만 모든 key를 가지고 반복 할 수는 있음
		for (String key : map.keySet()) {
//			s.replace(key, value); // 이런 식이 되어야 하겠지만, value 라는 변수는 없다.
			result = result.replace(key, map.get(key));
		}
		return Integer.parseInt(result);
	}

	@Test
	void contextLoads() {
//		String result = "";
//		result = result + 'a' + 't' + 't' + 'a' + 'c' + 'k';
//		Assertions.assertThat(result).isEqualTo("attack");

		String result1 = solution("dfjardstddetckdaccccdegk", 4);
		Assertions.assertThat(result1).isEqualTo("attack");

		String result2 = solution("pfqallllabwaoclk", 2);
		Assertions.assertThat(result2).isEqualTo("fallback");
	}

	int 없는_숫자_더하기(List<Integer> numbers) {
		int result = 45;
		for (Integer number : numbers) {
			result = result - number;
		}
		return result;
	}

	@Test
	void 없는_숫자_더하기_테스트() {
		List<Integer> input1 = List.of(1, 2, 3, 4, 6, 7, 8, 0);
		int output1 = 14;
		List<Integer> input2 = List.of(5, 8, 4, 0, 6, 7, 9);
		int output2 = 6;
		Assertions.assertThat(없는_숫자_더하기(input1)).isEqualTo(output1);
		Assertions.assertThat(없는_숫자_더하기(input2)).isEqualTo(output2);
	}

	@Test
	void 꼬리_문자열_테스트() {
		Assertions.assertThat(("abcx").endsWith("cx")).isTrue();
		List.of("a", "b").stream().filter(s -> s.length() > 0).collect(Collectors.joining());

		ArrayList<String> strings = new ArrayList<>();

		List<String> input1_1 = List.of("abc", "def", "ghi");
		String input1_2 = "ef";
		String  output1 = "abcghi";
		List<String > input2_1 = List.of("abc", "bbc", "cbc");
		String input2_2 = "c";
		String  output2 = "";

		Assertions.assertThat(꼬리_문자열(input1_1, input1_2)).isEqualTo(output1);
		Assertions.assertThat(꼬리_문자열(input2_1, input2_2)).isEqualTo(output2);
	}

	@Test
	void 음양_더하기_테스트() {

		int[] input1_1 = new int[]{4, 7, 12};
		boolean[] input1_2 = new boolean[]{true, false, true};
		Assertions.assertThat(음양_더하기(input1_1, input1_2)).isEqualTo(9);

		int[] input2_1 = new int[]{1, 2, 3};
		boolean[] input2_2 = new boolean[]{false, false, true};
		Assertions.assertThat(음양_더하기(input2_1, input2_2)).isEqualTo(0);
	}

	@Test
	void 숫자_문자열과_영단어_테스트() {
		Assertions.assertThat("one4seveneight".replace("seven", "7")
						.replace("eight", "8")
						.replace("one", "1"))
				.isEqualTo("1478");

		Assertions.assertThat(Integer.parseInt("1478")).isEqualTo(1478);

		String input1 = "one4seveneight";
		int output1 = 1478;
		String input2 = "23four5six7";
		int output2 = 234567;
		String input3 = "2three45sixseven";
		int output3 = 234567;
		String input4 = "123";
		int output4 = 123;

		Assertions.assertThat(숫자_문자열과_영단어(input1)).isEqualTo(output1);
		Assertions.assertThat(숫자_문자열과_영단어(input2)).isEqualTo(output2);
		Assertions.assertThat(숫자_문자열과_영단어(input3)).isEqualTo(output3);
		Assertions.assertThat(숫자_문자열과_영단어(input4)).isEqualTo(output4);
	}
}
