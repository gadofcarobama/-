public class MaxSubListSum {
        /**
         * 最大子序列的实现方法
         *
         * @param arr
         *            --数组
         * @param left
         * @param right
         * @return
         */
        public static int maxsubListSum(int arr[], int left, int right) {

            if (left == right) {// arr.length==1
                if (arr[left] > 0) {
                    return arr[left];
                } else {
                    return 0;
                }
            }

            // 划分数组
            int center = (left + right) / 2;
            int maxLeftSum = maxsubListSum(arr, left, center);// 左边最大值
            int maxRightSum = maxsubListSum(arr, center + 1, right);// 右边最大值

            // 左边求和
            int maxLeftBorderSum = 0, leftBorderSum = 0;
            for (int i = center; i >= left; i--) {
                leftBorderSum += arr[i];
                if (leftBorderSum > maxLeftBorderSum) {
                    maxLeftBorderSum = leftBorderSum;
                }
            }

            // 右边求和
            int maxRightBorderSum = 0, rightBorderSum = 0;
            for(int i = center+1;i<=right;i++){
                rightBorderSum += arr[i];
                if(rightBorderSum>maxRightBorderSum){
                    maxRightBorderSum = rightBorderSum;
                }
            }

            return maxList(maxLeftSum,maxRightSum,maxLeftBorderSum+maxRightBorderSum);

        }

        /**
         * 获取 多个Id 的最大值
         * @param elements
         * @return
         */
        private static  int maxList(int... elements){
            int max = 0;
            for(int i = 0;i<elements.length;i++){
                if(elements[i]>max){
                    max = elements[i];
                }
            }
            return max;
        }

        public static void main(String[] args) {
            int[] a = {4, -3, 5, -2, -1, 2, 6, -2};
            System.out.println(maxsubListSum(a, 0, a.length-1));
        }
    }

