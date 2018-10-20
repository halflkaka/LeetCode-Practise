# 第一道:找到最长的字符串的长度，要求这个子字符串的头字符和尾字符相同。
# 如 abdcbe, 则最长的是 bdcb,头 b 和尾 b 相同，返回 4。要求时间复杂度 O(n)。

class Solution {
	public int find(String s) {
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			List<Integer> pos = map.getOrDefault(s.charAt(i), new ArrayList<>());
			pos.add(i);
			map.put(s.charAt(i), pos);
		}

		int res = 0;
		for (char k : map.keySet()) {
			List<Integer> pos = map.get(k);
			res = Math.max(res, pos.get(pos.size()-1) - pos.get(0));
		}
		return res;
	}
}

# 给 x,y 轴上一堆点，点的坐标都是正整数，问这些点是否是关于 x = ? 的直线对称。

# 给一个长方形框（宽和高）和一段话，问能把整段话放进框里的最大字号，你可以调用两个现有的函数，分别返回每个字符的宽度和字符高度。
# 典型的二分查找，在字号范围内不断二分，最后就返回能把整段话放进框里的最大字号了

public Font find(int screen_width, int screen_height, int num_chars, Font font_sizes) {
	int lo = 0, lw = font_sizes.length - 1;
	while (lo < lw) {
		int mid = lo + (lw-lo) / 2;
		Font font = font_sizes[mid];
		int width = API(font_sizes).width, height = API(font_sizes).height;
		if (!isFir(screen_width, screen_height, width, height, num_chars)) {
			lw = mid - 1;
		} else {
			lo = mid;
		}
	}
	return font_sizes[lo];
}

public boolean isFir(int screen_width, int screen_height, int width, int height, int num_chars) {
	int num_line = screen_width / width;
	int num_col = screen_height / height;

	return num_chars <= num_line * num_col;
}