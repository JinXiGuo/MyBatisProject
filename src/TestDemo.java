/**
 * 快速排序
 * @author Administrator
 *
 */
public class TestDemo {
	public static void main(String[] args) {
		int[] nums ={2,3,67,345,212,8,12,12,12,12,12};
		quickSort(nums,0,nums.length-1);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums[i]);
		}
	}
	
	public static void quickSort(int a[], int start, int end) {
		int i, j;
		i = start;
		j = end;
		if ((a == null) || (a.length == 0))
			return;

		while (i < j) {// 查找基准点下标
			while (i < j && a[i] <= a[j])
				// 以数组start下标的数据为key，右侧扫描
				j--;
			if (i < j) { // 右侧扫描，找出第一个比key小的，交换位置
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
			while (i < j && a[i] < a[j])
				// 左侧扫描（此时a[j]中存储着key值）
				i++;
			if (i < j) { // 找出第一个比key大的，交换位置
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		if (i - start > 1) { // 递归调用，把key前面的完成排序
			quickSort(a, 0, i - 1);
		}
		if (end - j > 1) {
			quickSort(a, j + 1, end); // 递归调用，把key后面的完成排序
		}
	}
}