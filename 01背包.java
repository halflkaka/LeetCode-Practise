f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]

input: L (max weight), N, price, weight

public int sol(int L, int N, List<List<Integer>> input) {
	int[][] f = new int[N+1][L+1];
	int[] weight = new int[N+1];
	int[] price = new int[N+1];
	for (int i = 1; i <= input.size(); i++) {
		price[i] = input.get(i).get(0);
		weight[i] = input.get(i).get(1);
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 0; j <= L; j++) {
			if (weight[i] > j) f[i][j] = f[i-1][j];
			else f[i][j] = Math.max(f[i-1][j], f[i-1][j-weight[i]] + price[i]);
		}
	}
	return f[N][L];
}