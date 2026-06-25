package DSA;

public class Exercise2 {
    public static int linearSearch(Product[] arr, int targetId) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getProductId() == targetId) return i;
        }
        return -1;
    }

    public static int binarySearch(Product[] arr, int targetId) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].getProductId() == targetId) return mid;
            if (arr[mid].getProductId() < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(3, "Keyboard", 30, 1200),
            new Product(1, "Laptop", 10, 75000),
            new Product(4, "Desk", 5, 15000),
            new Product(2, "Mouse", 50, 500)
        };

        Product[] sorted = {
            new Product(1, "Laptop", 10, 75000),
            new Product(2, "Mouse", 50, 500),
            new Product(3, "Keyboard", 30, 1200),
            new Product(4, "Desk", 5, 15000)
        };

        int target = 3;
        int linRes = linearSearch(products, target);
        System.out.println("Linear: " + (linRes != -1 ? products[linRes] : "Not found"));

        int binRes = binarySearch(sorted, target);
        System.out.println("Binary: " + (binRes != -1 ? sorted[binRes] : "Not found"));
    }
}
