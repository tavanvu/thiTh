package TH;

import java.util.Scanner;

public class phoneMenu {
   private static PhonebookManagenr phonebookManagenr = new PhonebookManagenr();

    static {
        phonebookManagenr.add(new Phonebook("123","1","vu","nam","hn","vu@gmail.com"));
        phonebookManagenr.add(new Phonebook("456","2","nam","nam","hn","na@gmail.com"));
        phonebookManagenr.add(new Phonebook("003","3","tuan","nam","hn","tu@gmail.com"));
    }
    public void Run() {

        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            Menu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    phonebookManagenr.show();
                    break;
                case 2:
                    Phonebook phonebook = input(scanner);
                    phonebookManagenr.add(phonebook);
                    break;
                case 3:
                    update(phonebookManagenr, scanner);
                    break;
                case 4:
                    delete(phonebookManagenr, scanner);
                    break;
                case 5:
                    phonebookManagenr.fileOut();
                    break;
                case 6:
                    phonebookManagenr.fileInput();
                    break;
            }
        } while (choice != 0);

    }

    private static void delete(PhonebookManagenr phonebookManagenr, Scanner scanner) {
        System.out.println("nhập SĐT");
        String phoneNumber = scanner.nextLine();
        phonebookManagenr.deletePhoneNumber(phoneNumber);
    }

    private static void update(PhonebookManagenr phonebookManagenr, Scanner scanner) {
        System.out.println("mời bạn nhạp SĐT");
        String phoneNumber = scanner.nextLine();
        phonebookManagenr.update(phoneNumber, input(scanner));
    }
    private static Phonebook input(Scanner scanner) {
        System.out.println("nhập số điện thoại");
        String phoneNumber = scanner.nextLine();
        System.out.println("nhập nhóm");
        String Group = scanner.nextLine();
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập giới tính");
        String gender = scanner.nextLine();
        System.out.println("nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("nhập email");
        String email = scanner.nextLine();
        Phonebook phonebook = new Phonebook(phoneNumber, Group, name, gender, address, email);
        return phonebook;
    }

    private static void Menu() {
        System.out.println("1.hiển thị tất cả thông tin danh bạ");
        System.out.println("2.thêm danh bạ");
        System.out.println("3.cập nhập danh bạ theo sdt");
        System.out.println("4.xóa danh bạ theo sdt");
        System.out.println("5.đọc file");
        System.out.println("6.ghi file");
        System.out.println("0.exit");
    }
}
