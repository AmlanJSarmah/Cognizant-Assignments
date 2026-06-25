package DSA;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "Book{id=" + bookId + ", title='" + title + "', author='" + author + "'}";
    }
}

public class Exercise6 {
    public static Book linearSearchByTitle(Book[] books, String targetTitle) {
        for (Book b : books) {
            if (b.title.equals(targetTitle)) return b;
        }
        return null;
    }

    public static Book binarySearchByTitle(Book[] books, String targetTitle) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareTo(targetTitle);
            if (cmp == 0) return books[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"),
            new Book(2, "Moby Dick", "Herman Melville"),
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Brave New World", "Aldous Huxley")
        };

        Book[] sortedBooks = {
            new Book(3, "1984", "George Orwell"),
            new Book(4, "Brave New World", "Aldous Huxley"),
            new Book(1, "Moby Dick", "Herman Melville"),
            new Book(2, "The Great Gatsby", "F. Scott Fitzgerald")
        };

        String target = "Moby Dick";
        Book res = linearSearchByTitle(books, target);
        System.out.println("Linear: " + (res != null ? res : "Not found"));

        res = binarySearchByTitle(sortedBooks, target);
        System.out.println("Binary: " + (res != null ? res : "Not found"));
    }
}
