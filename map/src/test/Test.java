package test;


public class Test {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i = 0;i< 1000;i++)
			map.put("hello", i);
		System.out.println(map.get("hello"));
	}
}
