package ra.excercise;

import java.util.Scanner;

public class TH1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[100];
        //Chỉ số phần tử chưa chứa giá trị đầu tiên trong mảng
        int currentIndex = 0;
        do {
            System.out.println("****************MENU********************");
            System.out.println("1. Nhập giá trị cho n phần tử");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương trong mảng");
            System.out.println("4. In ra chỉ số các phần tử có giá trị bằng k");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố");
            System.out.println("7. Sắp xếp mảng theo yêu cầu");
            System.out.println("8. Nhập giá trị m và chèn vào mảng sắp xếp giảm dần");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào số phần tử cần nhập dữ liệu:");
                    int numberOfInput = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < numberOfInput; i++) {
                        System.out.printf("numbers[%d]=", currentIndex);
                        numbers[currentIndex] = Integer.parseInt(scanner.nextLine());
                        currentIndex++;
                    }
                    break;
                case 2:
                    System.out.println("Giá trị các phần tử trong mảng:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("%d\t", numbers[i]);
                    }
                    System.out.printf("\n");
                    break;
                case 3:
                    int sumNumbers = 0;
                    int cntElement = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numbers[i] > 0) {
                            sumNumbers += numbers[i];
                            cntElement++;
                        }
                    }
//                    System.out.println("Trung bình cộng các phần tử dương trong mảng là: "+(float)sumNumbers/(float)cntElement);
                    System.out.printf("Trung bình cộng các phần tử dương trong mảng là: %f\n", (float) sumNumbers / (float) cntElement);
                    break;
                case 4:
                    System.out.println("Nhập vào giá trị cần tìm:");
                    int searchValue = Integer.parseInt(scanner.nextLine());
                    System.out.printf("Chỉ số các phần tử có giá trị bằng %d là:\n", searchValue);
                    for (int i = 0; i < currentIndex; i++) {
                        if (numbers[i] == searchValue) {
                            System.out.printf("%d\t", i);
                        }
                    }
                    System.out.printf("\n");
                    break;
                case 5:
                    //Selection sort - Bubble soft - Insertion sort
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (numbers[i] < numbers[j]) {
                                //Đổi chỗ 2 phần tử
                                int temp = numbers[i];
                                numbers[i] = numbers[j];
                                numbers[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp xong mảng giảm dần");
                    break;
                case 6:
                    int cntPrime = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        //Kiểm tra numbers[i] có phải số nguyên tố hay không
                        boolean isPrime = true;
                        if (numbers[i] == 1) {
                            isPrime = false;
                        }
                        if (numbers[i] >= 2) {
                            for (int j = 2; j <= Math.sqrt(numbers[i]); j++) {
                                if (numbers[i] % j == 0) {
                                    isPrime = false;
                                }
                            }
                        }
                        if (isPrime) {
                            cntPrime++;
                        }
                    }
                    System.out.printf("Có %d phần tử là số nguyên tố trong mảng\n", cntPrime);
                    break;
                case 7:
                    //1. Copy các phần tử chẵn chia hết cho 3 ra mảng numbers1 và sắp xếp tăng dần
                    //-Đếm các phần tử chẵn chia hết cho 3
                    int cntEvent = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numbers[i] % 2 == 0 && numbers[i] % 3 == 0) {
                            cntEvent++;
                        }
                    }
                    //-Khởi tạo mảng gồm các phần tử chẵn chia hết cho 3
                    int[] numbers1 = new int[cntEvent];
                    //-Copy sang
                    int index1 = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numbers[i] % 2 == 0 && numbers[i] % 3 == 0) {
                            numbers1[index1] = numbers[i];
                            index1++;
                        }
                    }
                    //-Sắp xếp mảng tăng dần
                    for (int i = 0; i < numbers1.length - 1; i++) {
                        for (int j = i + 1; j < numbers1.length; j++) {
                            if (numbers1[i] > numbers1[j]) {
                                int temp1 = numbers1[i];
                                numbers1[i] = numbers1[j];
                                numbers1[j] = temp1;
                            }
                        }
                    }
                    //2. Copy các phần tử không chia hết cho 3 ra mảng numbers2 và sắp xếp tăng dần
                    int cntNotDiv3 = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numbers[i] % 3 != 0) {
                            cntNotDiv3++;
                        }
                    }
                    //-Khởi tạo mảng gồm các phần không chia hết cho 3
                    int[] numbers2 = new int[cntNotDiv3];
                    //-Copy sang
                    int index2 = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numbers[i] % 3 != 0) {
                            numbers2[index2] = numbers[i];
                            index2++;
                        }
                    }
                    //-Sắp xếp mảng tăng dần
                    for (int i = 0; i < numbers2.length - 1; i++) {
                        for (int j = i + 1; j < numbers2.length; j++) {
                            if (numbers2[i] > numbers2[j]) {
                                int temp2 = numbers2[i];
                                numbers2[i] = numbers2[j];
                                numbers2[j] = temp2;
                            }
                        }
                    }
                    //3. Copy các phần tủ lẻ chia hết cho 3 ra mảng numbers3 và sắp xếp giảm dần
                    //-Đếm các phần tử lẻ chia hết cho 3
                    int cntOdd = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numbers[i] % 2 != 0 && numbers[i] % 3 == 0) {
                            cntOdd++;
                        }
                    }
                    //-Khởi tạo mảng gồm các phần tử lẻ chia hết cho 3
                    int[] numbers3 = new int[cntOdd];
                    //-Copy sang
                    int index3 = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        if (numbers[i] % 2 != 0 && numbers[i] % 3 == 0) {
                            numbers3[index3] = numbers[i];
                            index3++;
                        }
                    }
                    //-Sắp xếp mảng giảm dần
                    for (int i = 0; i < numbers3.length - 1; i++) {
                        for (int j = i + 1; j < numbers3.length; j++) {
                            if (numbers3[i] < numbers3[j]) {
                                int temp3 = numbers3[i];
                                numbers3[i] = numbers3[j];
                                numbers3[j] = temp3;
                            }
                        }
                    }
                    //4. Copy các phần tử từ numbers1,numbers2,numbers3 đè vào mảng numbers
                    int index = 0;
                    //copyt numbers1 sang numbers
                    for (int i = 0; i < numbers1.length; i++) {
                        numbers[index] = numbers1[i];
                        index++;
                    }
                    //copy number2 sang numbers
                    for (int i = 0; i < numbers2.length; i++) {
                        numbers[index] = numbers2[i];
                        index++;
                    }
                    //copy number3 sang numbers
                    for (int i = 0; i < numbers3.length; i++) {
                        numbers[index] = numbers3[i];
                        index++;
                    }
                    break;
                case 8:
                    //1. Sắp xếp mảng giảm dần
                    for (int i = 0; i < currentIndex - 1; i++) {
                        for (int j = i + 1; j < currentIndex; j++) {
                            if (numbers[i] < numbers[j]) {
                                int temp = numbers[i];
                                numbers[i] = numbers[j];
                                numbers[j] = temp;
                            }
                        }
                    }
                    //2. Nhập giá trị cần chèn
                    System.out.println("Nhập giá trị cần chèn vào mảng:");
                    int insertValue = Integer.parseInt(scanner.nextLine());
                    //3. Tìm vị trí cần chèn
                    int i;
                    for (i = 0; i < currentIndex; i++) {
                        if (numbers[i] < insertValue) {
                            break;
                        }
                    }
                    //4. Thực hiện chèn
                    //--Copy các phần tử ra sau
                    for (int j = currentIndex - 1; j >= i; j--) {
                        numbers[j + 1] = numbers[j];
                    }
                    //--Thực hiện chèn
                    numbers[i] = insertValue;
                    //--Tăng currentIndex
                    currentIndex++;
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1-9");
            }
        } while (true);
    }
}
