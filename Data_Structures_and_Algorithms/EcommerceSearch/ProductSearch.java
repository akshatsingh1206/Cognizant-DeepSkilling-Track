// Exercise 2: E-commerce Platform Search Function
import java.util.Arrays;

public class ProductSearch {
    // Binary Search to find product ID efficiently
    public static int searchProduct(int[] productIds, int targetId) {
        Arrays.sort(productIds); // Ensure sorted for binary search
        int left = 0, right = productIds.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (productIds[mid] == targetId) return mid;
            if (productIds[mid] < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ids = {101, 505, 202, 303, 404};
        int target = 303;
        int result = searchProduct(ids, target);
        
        System.out.println(result != -1 ? "Product ID " + target + " found." : "Product not found.");
    }
}