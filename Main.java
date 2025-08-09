package Studen_mana;

import java.io.File;
import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        File fileLuu = null;

        System.out.println("Chon file luu danh sach sinh vien:  ");
        String filePath = sc.nextLine();
        fileLuu = new File(filePath);

        ArrayStudent arrayStudent = new ArrayStudent(fileLuu);

        while (true) {
            int choice;
            choice = sc.nextInt();
            System.out.println(" =====================");
            System.out.println("1. Them thong tin sinh vien ");
            System.out.println("2. Hien thi danh sach sinh vien");
            System.out.println("3. Tim kiem sinh vien theo ma thi sinh");
            System.out.println("4. Tim kiem sinh vien theo tinh thanh");
            System.out.println("5.Chon 1 thi sinh de thuc hien chuc nang: Them , Xoa , Sua");
            System.out.println("6.Sap xep danh sach sinh vien theo ten");
            System.out.println("7.Sap xep danh sach sinh vien theo diem");
            System.out.println("8.Luu danh sach sinh vien vao file");
            System.out.println("9.Mo file luu danh sach sinh vien");
            System.out.println("10. Thoat");

            if (choice == 10) {
                System.out.println("Cam on ban da su dung chuong trinh!");
                break;

            }
            switch (choice) {
                case 1:
                    System.out.println("Nhap ma thi sinh: ");
                    int maThiSinh = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhap ho ten: ");
                    String hoTen = sc.nextLine();
                    System.out.println("Nhap tinh thanh: ");
                    Tinh_Thanh tinh_Thanh = Tinh_Thanh.valueOf(sc.nextLine().toUpperCase());
                    System.out.println("Nhap ngay sinh (yyyy-mm-dd): ");
                    Date ngaySinh = Date.valueOf(sc.nextLine());
                    System.out.println("Nhap gioi tinh (true/false): ");
                    boolean gioiTinh = sc.nextBoolean();
                    System.out.println("Nhap diem thi mon 1: ");
                    float diemThiMon1 = sc.nextFloat();
                    System.out.println("Nhap diem thi mon 2: ");
                    float diemThiMon2 = sc.nextFloat();
                    System.out.println("Nhap diem thi mon 3: ");
                    float diemThiMon3 = sc.nextFloat();
                    Student student = new Student(maThiSinh, hoTen, tinh_Thanh, ngaySinh, gioiTinh, diemThiMon1,
                            diemThiMon2, diemThiMon3);
                    arrayStudent.themSinhVien(student);
                    break;
                case 2:
                    arrayStudent.hienThiDanhSachSinhVien();
                    break;
                case 3:
                    System.out.println("Nhap ma thi sinh can tim: ");
                    int maTimKiem = sc.nextInt();
                    arrayStudent.timKiemSinhVienTheoMa(maTimKiem);
                    break;
                case 4:
                    System.out.println("Nhap tinh thanh can tim: ");
                    Tinh_Thanh tinhThanhTimKiem = Tinh_Thanh.valueOf(sc.nextLine().toUpperCase());
                    arrayStudent.timKiemSinhVienTheoTinhThanh(tinhThanhTimKiem);
                    break;
                case 5:
                    System.out.println("====================");

                    System.out.println("Chon ma thi sinh de thuc hien chuc nang: ");
                    int maThiSinhChon = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Chon chuc nang: ");
                    System.out.println("1. Sua thong tin");
                    System.out.println("2. Xoa thong tin");

                    int chucNang = sc.nextInt();
                    sc.nextLine();

                    arrayStudent.run1(maThiSinhChon, chucNang);
                    break;
                case 6:
                    arrayStudent.sapxeptheoHovaTenSinhVien();
                    System.out.println("Danh sach sinh vien da duoc sap xep theo ho va ten.");
                    break;
                case 7:
                    arrayStudent.sapxeptheoDiem();
                    break;
                case 8:
                    arrayStudent.luuDanhSachSinhVienVaoFile();

                    break;
                case 9:
                    System.out.println("Chon File de Mo File luu danh sach sinh vien: ");

                    File fileMo = null;

                    while (fileMo == null) {
                        try {
                            String filePathMo = sc.nextLine();
                            fileMo = new File(filePathMo);
                        } catch (Exception e) {
                            System.out.println("Đường dẫn file không hợp lệ. Vui lòng nhập lại.");
                        }
                    }
                    arrayStudent.moFileLuuDanhSachSinhVien(fileMo);
                    break;
                default:
                    break;
            }
        }
        sc.close();

    }
}
