// TC: O(N!)
// SC: O(N)
// Did it run successfully on Leetcode? : Yes
// where N is the input number

public class LC526 {
    private void swap(int arr[], int i, int j){
        if(i==j) return;
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }
    private boolean isValid(int num1, int num2){
        if((num1%num2)==0) return true;
        if((num2%num1)==0) return true;
        return false;
    }
    private int permute(int arr[], int i, int n){
        // BC
        if(i==n) return 1;

        int ans = 0;
        //Logic
        for(int pos=i;pos<n;pos++){
            if(!isValid(i+1, arr[pos])) continue;
            swap(arr, i, pos);
            ans += permute(arr, i+1, n);
            swap(arr, i, pos);
        }
        return ans;
    }
    public int countArrangement(int n) {
        if(n==1) return 1;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=i+1;
        }
        int ans = permute(arr, 0, n);
        return ans;
    }
}