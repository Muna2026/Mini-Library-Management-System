package mini.library.management.system;

import java.awt.HeadlessException;
import javax.swing.*;   // GUI components
import java.io.*;       // File handling

/**
 * Mini Library System - SIMPLE VERSION
 * الهدف من النسخة دي:
 * - مناسبة للطلاب الضعاف
 * - استخدام while + switch case
 * - GUI بسيط جدًا باستخدام JOptionPane
 * - Array عادي (ممنوع ArrayList)
 */
public class MiniLibrarySimple {

    // أقصى عدد كتب
    static final int MAX = 50;

    // Array لتخزين الكتب
    static String[] books = new String[MAX];

    // عدد الكتب الحالي
    static int count = 0;

    // اسم الملف
    static String fileName = "books.txt";

    public static void main(String[] args) {

        // تحميل الكتب من الملف
        loadFromFile();

        int choice = 0; // اختيار المستخدم

        // while loop لتكرار القائمة
        while (choice != 6) {

            // عرض المينيو
            String menu = """
                          ==== LIBRARY MENU ====
                          1. Display all books
                          2. Add new book
                          3. Search for book
                          4. Remove book
                          5. Count books
                          6. Save and Exit
                          Enter your choice:""";

            try {
                choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input");
                continue;
            }

            // switch case للاختيارات
        switch (choice) {

                case 1:
                    displayBooks();
                    break;

                case 2:
                    addBook();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    removeBook();
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null, "Total books: " + count);
                    break;

                case 6:
                    saveToFile();
                    JOptionPane.showMessageDialog(null, "Data saved. Goodbye!");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice");
            }
        }
    }

    // ================= METHODS =================

    // قراءة الكتب من الملف
    static void loadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                books[count] = line;
                count++;
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "File not found");
        }
    }

    // عرض كل الكتب
    static void displayBooks() {
        String output = "";
        for (int i = 0; i < count; i++) {
            output += (i + 1) + ". " + books[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }

    // إضافة كتاب جديد
    static void addBook() {
        if (count >= MAX) {
            JOptionPane.showMessageDialog(null, "Library full");
            return;
        }
        String book = JOptionPane.showInputDialog("Enter book title:");
        books[count] = book;
        count++;
    }

    // البحث عن كتاب
    static void searchBook() {
        String search = JOptionPane.showInputDialog("Enter book name:");
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (books[i].equals(search)) {
                JOptionPane.showMessageDialog(null, "Book found at number " + (i + 1));
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Book not found");
        }
    }

    // حذف كتاب
    static void removeBook() {
        int num = Integer.parseInt(JOptionPane.showInputDialog("Enter book number:"));
        int index = num - 1;

        if (index < 0 || index >= count) {
            JOptionPane.showMessageDialog(null, "Invalid number");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            books[i] = books[i + 1];
        }

        count--;
        JOptionPane.showMessageDialog(null, "Book removed");
    }

    // حفظ البيانات في الملف
    static void saveToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < count; i++) {
                bw.write(books[i]);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving file");
        }
    }
}
