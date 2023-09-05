package pagination;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++) {
			list.add(i);
		}
		System.out.println(list.subList(0, 4));
		System.out.println(list.subList(4, list.size()));
	
	}
}
