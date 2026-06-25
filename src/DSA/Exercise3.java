package DSA;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "Order{id=" + orderId + ", customer='" + customerName + "', total=" + totalPrice + "}";
    }
}

public class Exercise3 {
    public static void bubbleSort(Order[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice <= pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Order[] orders = {
            new Order(3, "Alice", 250.50),
            new Order(1, "Bob", 100.00),
            new Order(4, "Charlie", 300.75),
            new Order(2, "Diana", 150.25)
        };

        Order[] forBubble = orders.clone();
        bubbleSort(forBubble);
        System.out.println("Bubble Sorted:");
        for (Order o : forBubble) System.out.println(o);

        Order[] forQuick = orders.clone();
        quickSort(forQuick, 0, forQuick.length - 1);
        System.out.println("\nQuick Sorted:");
        for (Order o : forQuick) System.out.println(o);
    }
}
