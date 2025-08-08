package Studen_mana;

import java.sql.Date;



public class Student  {
    private int Ma_Thi_Sinh;
    private String Ho_Ten;
    private Tinh_Thanh Tinh_Thanh;
    private Date Ngay_Sinh;
    private boolean Gioi_Tinh;
    private float Diem_Thi_Mon1;
    private float Diem_Thi_Mon2;
    private float Diem_Thi_Mon3;

    public Student(int ma_Thi_Sinh, String ho_Ten, Tinh_Thanh tinh_Thanh, Date ngay_Sinh, boolean gioi_Tinh,
            float diem_Thi_Mon1, float diem_Thi_Mon2, float diem_Thi_Mon3) {
        this.Ma_Thi_Sinh = ma_Thi_Sinh;
        this.Ho_Ten = ho_Ten;
        this.Tinh_Thanh = tinh_Thanh;
        this.Ngay_Sinh = ngay_Sinh;
        this.Gioi_Tinh = gioi_Tinh;
        this.Diem_Thi_Mon1 = diem_Thi_Mon1;
        this.Diem_Thi_Mon2 = diem_Thi_Mon2;
        this.Diem_Thi_Mon3 = diem_Thi_Mon3;
    }

  
    public int getMa_Thi_Sinh() {
        return Ma_Thi_Sinh;
    }

    public void setMa_Thi_Sinh(int ma_Thi_Sinh) {
        this.Ma_Thi_Sinh = ma_Thi_Sinh;
    }

    public String getHo_Ten() {
        return Ho_Ten;
    }

    public void setHo_Ten(String ho_Ten) {
        this.Ho_Ten = ho_Ten;
    }

    public Tinh_Thanh getTinh_Thanh() {
        return Tinh_Thanh;
    }

    public void setTinh_Thanh(Tinh_Thanh tinh_Thanh) {
        this.Tinh_Thanh = tinh_Thanh;
    }

    public Date getNgay_Sinh() {
        return Ngay_Sinh;
    }

    public void setNgay_Sinh(Date ngay_Sinh) {
        this.Ngay_Sinh = ngay_Sinh;
    }

    public boolean isGioi_Tinh() {
        return Gioi_Tinh;
    }

    public void setGioi_Tinh(boolean gioi_Tinh) {
        this.Gioi_Tinh = gioi_Tinh;
    }

    public float getDiem_Thi_Mon1() {
        return Diem_Thi_Mon1;
    }

    public void setDiem_Thi_Mon1(float diem_Thi_Mon1) {
        this.Diem_Thi_Mon1 = diem_Thi_Mon1;
    }

    public float getDiem_Thi_Mon2() {
        return Diem_Thi_Mon2;
    }

    public void setDiem_Thi_Mon2(float diem_Thi_Mon2) {
        this.Diem_Thi_Mon2 = diem_Thi_Mon2;
    }

    public float getDiem_Thi_Mon3() {
        return Diem_Thi_Mon3;
    }

    public void setDiem_Thi_Mon3(float diem_Thi_Mon3) {
        this.Diem_Thi_Mon3 = diem_Thi_Mon3;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Ma_Thi_Sinh=" + Ma_Thi_Sinh +
                ", Ho_Ten='" + Ho_Ten + '\'' +
                ", Tinh_Thanh=" + Tinh_Thanh +
                ", Ngay_Sinh=" + Ngay_Sinh +
                ", Gioi_Tinh=" + Gioi_Tinh +    
                ", Diem_Thi_Mon1=" + Diem_Thi_Mon1 +
                ", Diem_Thi_Mon2=" + Diem_Thi_Mon2 +
                ", Diem_Thi_Mon3=" + Diem_Thi_Mon3 +
                '}';
    }


  

}