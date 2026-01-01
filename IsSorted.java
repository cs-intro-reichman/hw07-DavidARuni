public class IsSorted {

    // Public function: called by the user
    public static boolean isSorted(int[] a) {
        return isSorted(a, 0);
    }

    // Helper recursive function
    // The helper function should check whether the array is sorted starting from
    // index i, and make a recursive call on a smaller subproblem.
    private static boolean isSorted(int[] a, int i) {
        if(a.length == 0 || a.length == 1){
            return true;
        } else if (i == a.length - 1) {
            return true;
        } else if (a[i] <= a[i+1]) {
            return isSorted(a, i+1);
        }
        return false; 
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 5};
        System.out.println(isSorted(a)); // true

        int[] b = {1, 3, 2};
        System.out.println(isSorted(b)); // false
    }
}
