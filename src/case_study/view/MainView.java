package case_study.view;

import case_study.controller.OfficialPhoneController;
import case_study.model.OfficialPhone;

import java.util.List;
import java.util.Scanner;

public class MainView {
    public static void main(String[] args) {
        int choice;
        while (true) {
            System.out.println("-----Quản lý chương trình điện thoại-----");
            System.out.println("1. Điện thoại chính hãng");
            System.out.println("2. Điện thoại xách tay");
            System.out.println("3. Thoát chương trình");
            System.out.println("Mời bạn nhập lựa chọn: ");
            choice = inputChoice();
            switch (choice) {
                case 1:
                    OfficialPhoneMenu();
                    break;
                case 2:
                    ImportedPhoneMenu();
                    break;
                default:
                    return;
            }
        }
    }

    public static void OfficialPhoneMenu() {
        OfficialPhoneController officialPhoneController = new OfficialPhoneController();
        List<OfficialPhone> officialPhones;
        OfficialPhone officialPhone;
        while (true) {
            System.out.println("-----Chương trình quản lý điện thoại-----");
            System.out.println("Chọn chức năng theo số để tiếp tục ");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Tìm kiếm theo tên sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Sửa thông tin sản phẩm");
            System.out.println("6. Quay lại");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = inputChoice();
            switch (choice) {
                case 1:
                    System.out.println("Hiển thị danh sách điện thoại chính hãng");
                    officialPhones = officialPhoneController.getAll();
                    displayOfficialPhone(officialPhones);
                    break;
                case 2:
                    System.out.println("Thêm mới sản phẩm");
                    officialPhone = inputOfficialPhone();
                    officialPhoneController.add(officialPhone);
                    System.out.println("Thêm mới sản phẩm thành công!");
                    break;
                case 3:
                    System.out.println("Tìm kiếm theo tên sản phẩm");
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    Scanner scanner = new Scanner(System.in);
                    String name = scanner.nextLine();
                    if (officialPhoneController.findByName(name) != null) {
                        System.out.println(officialPhoneController.findByName(name));
                    } else {
                        System.out.println("Không tìm thấy sản phẩm có tên: " + name);
                    }
                    break;
                case 4:
                    System.out.println("Xóa sản phẩm");
                    deleteOfficialPhone();
                    break;
                case 5:
                    System.out.println("Sửa thông tin sản phẩm");
                    updateOfficialPhone();
                    break;
                case 6:
                    return;
            }
        }
    }

    private static void updateOfficialPhone() {
        Scanner scanner = new Scanner(System.in);
        OfficialPhoneController officialPhoneController = new OfficialPhoneController();
        System.out.print("Mời bạn nhập id cần sửa: ");
        int id2 = scanner.nextInt();
        System.out.println(officialPhoneController.findById(id2));
        if (officialPhoneController.isExists(id2)) {
            System.out.print("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            while (!(name.matches("^[A-za-z0-9]+$"))) {
                System.out.println("Bạn nhập sai định dạng tên");
                System.out.print("Vui lòng nhập lại: ");
                name = scanner.nextLine();
            }

            System.out.print("Nhập giá sản phẩm: ");
            int price = inputNumber();
            while (price < 0) {
                price = inputNumber();
            }

            System.out.print("Nhập số lượng sản phẩm: ");
            int quantity = inputNumber();
            while (quantity < 0) {
                quantity = inputNumber();
            }

            System.out.print("Nhập nhà sản xuất: ");
            String manufacturer = scanner.nextLine();
            while (!(manufacturer.matches("^[A-Za-z]+$"))) {
                System.out.println("Bận nhập sai định dạng tên nhà sản xuất");
                System.out.print("Vui lòng nhập lại: ");
                manufacturer = scanner.nextLine();
            }

            System.out.print("Nhập thời gian bảo hành: ");
            int warranty = inputNumber();
            while (warranty < 0) {
                warranty = inputNumber();
            }

            OfficialPhone officialPhone = new OfficialPhone(id2, name, price, quantity, manufacturer, warranty);
            officialPhoneController.update(officialPhone);
        } else {
            System.out.println("Không tìm thấy id: " + id2);
        }
    }

    private static void deleteOfficialPhone() {
        OfficialPhoneController officialPhoneController = new OfficialPhoneController();
        System.out.print("Mời nhập id sản phẩm muốn xóa: ");
        int id1 = inputIdToFind();
        if (officialPhoneController.isExists(id1)) {
            System.out.println("Bạn có chắc chắn muốn xóa");
            System.out.println(officialPhoneController.isExists(id1));
            System.out.print("Nhấn Y để xóa, hoặc phím bất kỳ để hủy");
            Scanner scanner = new Scanner(System.in);
            String isConfirm = scanner.nextLine();
            if (isConfirm.equalsIgnoreCase("y")) {
                officialPhoneController.deleteById(id1);
                System.out.println("Xóa sản phẩm thành công");
            } else {
                System.out.println("Bạn đã không xóa");
            }
        } else {
            System.out.println("Không tìm thấy id");
        }
    }

    private static int inputIdToFind() {
        Scanner scanner = new Scanner(System.in);
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai. Vui lòng nhập lại: ");
        }
        return 0;
    }

    private static OfficialPhone inputOfficialPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        while (!(name.matches("^[A-za-z0-9]+$"))) {
            System.out.println("Bạn nhập sai định dạng tên");
            System.out.print("Vui lòng nhập lại: ");
            name = scanner.nextLine();
        }

        System.out.print("Nhập giá sản phẩm: ");
        int price = inputNumber();
        while (price < 0) {
            price = inputNumber();
        }

        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = inputNumber();
        while (quantity < 0) {
            quantity = inputNumber();
        }

        System.out.print("Nhập nhà sản xuất: ");
        String manufacturer = scanner.nextLine();
        while (!(manufacturer.matches("^[A-Za-z]+$"))) {
            System.out.println("Bận nhập sai định dạng tên nhà sản xuất");
            System.out.print("Vui lòng nhập lại: ");
            manufacturer = scanner.nextLine();
        }

        System.out.print("Nhập thời gian bảo hành: ");
        int warranty = inputNumber();
        while (warranty < 0) {
            warranty = inputNumber();
        }

        return new OfficialPhone(id, name, price, quantity, manufacturer, warranty);
    }

    private static void displayOfficialPhone(List<OfficialPhone> officialPhones) {
        System.out.println("Danh sách sản phẩm");
        for (OfficialPhone officialPhone : officialPhones) {
            System.out.println(officialPhone);
        }
    }

    private static void ImportedPhoneMenu() {

    }

    private static int inputChoice() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        try {
            choice = Integer.parseInt(scanner.nextLine());
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Nhập sai lựa chọn. Mời bạn nhập lại");
        } catch (Exception e) {
            System.out.println("Lỗi khác");
        }
        return 0;
    }

    private static int inputNumber() {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number < 0) {
            System.out.println("Bạn nhập sai định dạng");
            System.out.print("Vui lòng nhập lại: ");
            number = scanner.nextInt();
        }
        return number;
    }
}
