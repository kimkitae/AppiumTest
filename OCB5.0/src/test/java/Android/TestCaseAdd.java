package Android;

import java.io.File;
import java.util.ArrayList;

public class TestCaseAdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = System.getProperty("user.dir") + "/src/test/java";

		// 읽어올 경로
		File dir = new File(path);

		// 탐색할 파일을 저장할 리스트
		ArrayList files = new ArrayList();

		// 삭제할 파일을 저장할 리스트
		ArrayList deletefiles = new ArrayList();

		// 파일을 탐색한다.
		testcaseFind(files, dir);

		int a = 0;
		final int count = files.size();

		while (a < count) {
			if (files.get(a).toString().matches(".*.DS_Store.*") == true
					|| files.get(a).toString().matches(".*.Android.Auth.*") == true) {
				deletefiles.add(files.get(a));

			}

			a++;

		}

		files.removeAll(deletefiles);

		testcaseNames(files, path);

		for (Object object : testcaseNames(files, path)) {

			System.out.println(object.toString() + ",");

		}

	}

	public static void testcaseFind(ArrayList files, File dir) {

		if (dir.isDirectory()) {
			File[] children = dir.listFiles();
			for (File f : children) {
				testcaseFind(files, f);
			}
		} else {
			files.add(dir);

		}

	}

	public static ArrayList testcaseNames(ArrayList files, String path) {

		ArrayList testcaseNames = new ArrayList();

		for (int i = 0; i < files.size(); i++) {
			String text1 = files.get(i).toString().replaceAll(path + ".", "");
			String text2 = text1.replaceAll("/", ".");
			String text3 = text2.replaceAll(".java", ".class");
			testcaseNames.add(text3);

		}

		return testcaseNames;

	}

}