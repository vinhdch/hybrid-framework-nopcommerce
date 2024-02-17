package javaCollection;

import java.util.ArrayList;
import java.util.List;

public class Topic_01_ArrayList {

	public static void main(String[] args) {

		List<String> studentList = getStudentList(new ArrayList<>());
	}

	public static List<String> getStudentList(List<String> list) {
		list.add(new String("nam"));
		list.add(new String("nguyen van b"));
		return list;
	}
}
