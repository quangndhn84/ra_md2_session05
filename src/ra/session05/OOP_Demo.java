package ra.session05;

import java.util.Scanner;

public class OOP_Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Syntax: ClassName objectName = new Constructor(Arguments)
        //1. Khởi tạo đối tượng sinh viên 1 mà không khởi tạo thông tin gì
        Student student1 = new Student();
        //2. Khởi tạo đối tượng sinh viên 2 với mã sinh viên và tên sinh viên
        Student student2 = new Student("SV002", "Nguyễn Văn B");
        //3. Khởi tạo đối tượng sinh viên 3 với tất cả thông tin
        Student student3 = new Student("SV003", "Nguyễn Văn C", 22, true, "Đà Nẵng");
        //4. Nhập thông tin cho sinh viên 1
        student1.inputData(scanner);
        //5. Nhập thông tin cho sinh viên 2: tuổi, giới tính, địa chỉ
        System.out.println("Nhập vào tuổi sinh viên 2:");
        student2.setAge(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhập vào giới tính sinh viên 2:");
        student2.setSex(Boolean.parseBoolean(scanner.nextLine()));
        System.out.println("Nhập vào địa chỉ sinh viên 2:");
        student2.setAddress(scanner.nextLine());
        //6. Tính tuổi trung bình của các sinh viên
        int avgAge = (student1.getAge() + student2.getAge() + student3.getAge()) / 3;
        System.out.println("Tuổi trung bình: "+avgAge);
        //7. Cho sinh viên 1 chào thầy Quang
        student1.hello("Thầy Quang");
        System.out.println("THÔNG TIN CÁC ĐỐI TƯỢNG SINH VIÊN:");
        System.out.println("THÔNG TIN SINH VIÊN 1:");
        student1.displayData();
        System.out.println("THÔNG TIN SINH VIÊN 2:");
        student2.displayData();
        System.out.println("THÔNG TIN SINH VIÊN 3:");
        student3.displayData();
    }
}
