package DSA;

class Task {
    int taskId;
    String taskName;
    String status;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String toString() {
        return "Task{id=" + taskId + ", name='" + taskName + "', status='" + status + "'}";
    }
}

class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class Exercise5 {
    private Node head;

    Exercise5() {
        head = null;
    }

    public void addTask(Task t) {
        Node newNode = new Node(t);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = newNode;
    }

    public Task searchTask(int taskId) {
        Node curr = head;
        while (curr != null) {
            if (curr.task.taskId == taskId) return curr.task;
            curr = curr.next;
        }
        return null;
    }

    public void traverse() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.task);
            curr = curr.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Deleted task " + taskId);
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            if (curr.next.task.taskId == taskId) {
                curr.next = curr.next.next;
                System.out.println("Deleted task " + taskId);
                return;
            }
            curr = curr.next;
        }
        System.out.println("Task not found.");
    }

    public static void main(String[] args) {
        Exercise5 list = new Exercise5();

        list.addTask(new Task(1, "Design", "Pending"));
        list.addTask(new Task(2, "Develop", "In Progress"));
        list.addTask(new Task(3, "Test", "Pending"));

        System.out.println("All tasks:");
        list.traverse();

        System.out.println("\nSearching for id 2: " + list.searchTask(2));

        list.deleteTask(2);

        System.out.println("\nAfter deletion:");
        list.traverse();
    }
}
