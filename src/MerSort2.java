public class MerSort2 {
    public static void main(String[] args){
        int[] a={49,38,65,97,76,13,27};
        int low=0;
        int heigh=6;
        int[] sort=merSort(a,low,heigh);
        for (int i=0;i<sort.length;i++)
            System.out.println(sort[i]);
    }
    public static int[] merSort(int[] a,int low,int height){
        int mid=(low+height)/2;
        if (low<height){

            merSort(a,low,mid);
            merSort(a,mid+1,height);
            //到底层时候进行比较并排序
            merge(a,low,mid,height);
        }
        return a;
    }
//    public static void merge(int[] a, int low, int mid, int high) {
//        int[] temp = new int[high-low+1];
//        int i= low;
//        int j = mid+1;
//        int k=0;
//        // 把较小的数先移到新数组中
//        while(i<=mid && j<=high){
//            if(a[i]<a[j]){
//                temp[k++] = a[i++];
//            }else{
//                temp[k++] = a[j++];
//            }
//        }
//        // 把左边剩余的数移入数组
//        while(i<=mid){
//            temp[k++] = a[i++];
//        }
//        // 把右边边剩余的数移入数组
//        while(j<=high){
//            temp[k++] = a[j++];
//        }
//        // 把新数组中的数覆盖nums数组
//        for(int x=0;x<temp.length;x++){
//            a[x+low] = temp[x];
//        }
//    }
    public static void merge(int[] a,int low,int mid,int height){
        int[] temp=new int[height-low+1];
        int i=low;
        int j=mid+1;//左边第一个和右边数组第一个进行比较
        int k=0;
        while (i<=mid&&j<=height){
           if (a[i]<a[j]){
               temp[k++]=a[i++];
           }else {
               temp[k++]=a[j++];
           }
        }
        //将左边剩余的补上
        while (i<=mid){
            temp[k++]=a[i++];
        }
        //将右边补上
        while (j<=height){
            temp[k++]=a[j++];
        }
        //用temp数组中的值将a数组中的值覆盖
        for (int m=0;m<temp.length;m++){
            a[low+m]=temp[m];
        }
    }
}
