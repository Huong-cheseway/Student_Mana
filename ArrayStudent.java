package Studen_mana;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayStudent {
    private ArrayList<Student> danhSachSinhVien;
    private File fileLuu;

    public ArrayStudent(File fileLuu) {
        this.danhSachSinhVien = new ArrayList<>();
        this.fileLuu = fileLuu;
    }

    public void themSinhVien(Student student) {
        this.danhSachSinhVien.add(student);
    }

    public void hienThiDanhSachSinhVien() {
        for (Student student : danhSachSinhVien) {
            System.out.println("Ma Thi Sinh: " + student.getMa_Thi_Sinh());
            System.out.println("Ho Ten: " + student.getHo_Ten());
            System.out.println("Tinh Thanh: " + student.getTinh_Thanh());
            System.out.println("Ngay Sinh: " + student.getNgay_Sinh());
            System.out.println("Gioi Tinh: " + (student.isGioi_Tinh() ? "Nam" : "Nu"));
            System.out.println("Diem Thi Mon 1: " + student.getDiem_Thi_Mon1());
            System.out.println("Diem Thi Mon 2: " + student.getDiem_Thi_Mon2());
            System.out.println("Diem Thi Mon 3: " + student.getDiem_Thi_Mon3());
            System.out.println("-------------------------");
        }
    }

    public void timKiemSinhVienTheoMa(int maThiSinh) {
        for (Student student : danhSachSinhVien) {
            if (student.getMa_Thi_Sinh() == maThiSinh) {
                System.out.println("Found: " + student.toString());
                return;
            }

            System.out.println("/n /n /n");
        }
        System.out.println("Khong tim thay sinh vien voi ma thi sinh: " + maThiSinh);
    }

    public void timKiemSinhVienTheoTinhThanh(Tinh_Thanh tinhThanh) {
        boolean found = false;
        for (Student student : danhSachSinhVien) {
            if (student.getTinh_Thanh() == tinhThanh) {
                System.out.println("Found: " + student.toString());
                found = true;
            }
            System.out.println("/n /n /n");
        }
        if (!found) {
            System.out.println("Khong tim thay sinh vien o tinh thanh: " + tinhThanh);
        }
    }

    public void run1(int maThiSinhChon, int chucNang) {
        Scanner sc = new Scanner(System.in);

        if (chucNang == 1) {
            for (Student student : danhSachSinhVien) {
                if (student.getMa_Thi_Sinh() == maThiSinhChon) {
                    System.out.println("Nhap ma thi sinh moi: ");
                    int maThiSinhMoi = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhap ho ten moi: ");
                    String hoTenMoi = sc.nextLine();
                    System.out.println("Nhap tinh thanh moi: ");
                    Tinh_Thanh tinhThanhMoi = Tinh_Thanh.valueOf(sc.nextLine().toUpperCase());
                    System.out.println("Nhap ngay sinh moi (yyyy-mm-dd): ");
                    Date ngaySinhMoi = Date.valueOf(sc.nextLine());
                    System.out.println("Nhap gioi tinh moi (true/false): ");
                    boolean gioiTinhMoi = sc.nextBoolean();
                    System.out.println("Nhap diem thi mon 1 moi: ");
                    float diemThiMon1Moi = sc.nextFloat();
                    System.out.println("Nhap diem thi mon 2 moi: ");
                    float diemThiMon2Moi = sc.nextFloat();
                    System.out.println("Nhap diem thi mon 3 moi: ");
                    float diemThiMon3Moi = sc.nextFloat();

                    student.setMa_Thi_Sinh(maThiSinhMoi);
                    student.setHo_Ten(hoTenMoi);
                    student.setTinh_Thanh(tinhThanhMoi);
                    student.setNgay_Sinh(ngaySinhMoi);
                    student.setGioi_Tinh(gioiTinhMoi);
                    student.setDiem_Thi_Mon1(diemThiMon1Moi);
                    student.setDiem_Thi_Mon2(diemThiMon2Moi);
                    student.setDiem_Thi_Mon3(diemThiMon3Moi);

                    System.out.println("Cap nhat thong tin sinh vien thanh cong!");
                } else {
                    System.out.println("Khong tim thay sinh vien voi ma thi sinh: " + maThiSinhChon);
                }
            }
        } else if (chucNang == 2) {
            for (int i = 0; i < danhSachSinhVien.size(); i++) {
                if (danhSachSinhVien.get(i).getMa_Thi_Sinh() == maThiSinhChon) {
                    danhSachSinhVien.remove(i);
                    System.out.println("Xoa thong tin sinh vien thanh cong!");
                    return;
                }
            }
            System.out.println("Khong tim thay sinh vien voi ma thi sinh: " + maThiSinhChon);
        }
        sc.close();

    }

    public void sapxeptheoHovaTenSinhVien() {
        this.danhSachSinhVien.sort((st1, st2) -> {
            return st1.getHo_Ten().compareTo(st2.getHo_Ten());
        });
    }

    public void sapxeptheoDiem() {

        this.danhSachSinhVien.sort((st1, st2) -> {
            return (int) st1.getDiem_Thi_Mon1() - (int) st2.getDiem_Thi_Mon1();
        });
    }

    public void luuDanhSachSinhVienVaoFile() {
        try {
            OutputStream op = new FileOutputStream(this.fileLuu);
            ObjectOutputStream oos = new ObjectOutputStream(op);

            for (Student student : danhSachSinhVien) {
                oos.writeObject(student);
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void moFileLuuDanhSachSinhVien(File fileMo) {
        try {
            InputStream ip = new FileInputStream(fileMo);
            ObjectInputStream ois = new ObjectInputStream(ip);

            while (true) {
                try {
                    Student student = (Student) ois.readObject();
                    this.danhSachSinhVien.add(student);
                } catch (Exception e) {
                    break;
                }
            }
            ois.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
