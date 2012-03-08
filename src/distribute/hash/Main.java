package distribute.hash;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static int getBucketBaseDistrabute(int value, int buckettCount) {
		return value % buckettCount;
	}

	public static int getBucketUpDistrabute(int value, int buckettCount) {
		return value % 1024 % buckettCount;
	}

	public static void addValue(HashMap<Integer, ArrayList<Integer>> map, int value, int bucket) {
		ArrayList<Integer> baselist = null;
		if (map.containsKey(bucket)) {
			baselist = map.get(bucket);
			baselist.add(value);
		} else {
			baselist = new ArrayList<Integer>();
			baselist.add(value);
			map.put(bucket, baselist);
		}
	}

	public static void printMap(HashMap<Integer, ArrayList<Integer>> map) {
		for (Integer key : map.keySet()) {
			ArrayList<Integer> list = map.get(key);
			System.out.print("Key " + key + ":");
			for (Integer i : list) {
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> baselist = new ArrayList<Integer>();
		ArrayList<Integer> uplist = new ArrayList<Integer>();
		HashMap<Integer, ArrayList<Integer>> hashMap4 = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> hashMap6 = new HashMap<Integer, ArrayList<Integer>>();

		HashMap<Integer, ArrayList<Integer>> hashMapUp4 = new HashMap<Integer, ArrayList<Integer>>();
		HashMap<Integer, ArrayList<Integer>> hashMapUp6 = new HashMap<Integer, ArrayList<Integer>>();
		int bucket = 0;
		for (int i = 0; i < 100000; i++) {
			bucket = Main.getBucketBaseDistrabute(i, 4);
			Main.addValue(hashMap4, i, bucket);
			bucket = Main.getBucketBaseDistrabute(i, 6);
			Main.addValue(hashMap6, i, bucket);

			bucket = Main.getBucketUpDistrabute(i, 4);
			Main.addValue(hashMapUp4, i, bucket);
			bucket = Main.getBucketUpDistrabute(i, 6);
			Main.addValue(hashMapUp6, i, bucket);
		}

		System.out.println("hashMap4");
		Main.printMap(hashMap4);
		System.out.println("hashMap6");
		Main.printMap(hashMap6);

		System.out.println("hashMapUp4");
		Main.printMap(hashMapUp4);
		System.out.println("hashMapUp6");
		Main.printMap(hashMapUp6);
	}
}
