package com.practicalexam;

import java.util.Scanner;

import com.practicalexam.student.TemplateQuestion;

/**
 *
 * @author FPT University - HCMC
 * Java OOP Practical Exam Template
 */

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Menu here (if needed)
    	TemplateQuestion hello = new TemplateQuestion();
        // Your code here
    	int choice = 0;
        do {
            
            // Menu here (if needed)
            System.out.println("1. Add them 1 sinh vien");
            System.out.println("2. Tim kiem sinh vien");
            System.out.println("3. Xoa sinh vien");
            System.out.println("4. Cap nhat thong tin sinh vien");
            System.out.println("5. Sap xep danh sach sinh vien theo diem");
            // Your code here
    		System.out.println("Nhap vao : ");
    		choice = scanner.nextInt();
          
            switch (choice) {
                case 1: {
                    hello.insert();
                    break;
                }
                case 2: {
                    hello.search();
                    break;
                }
                case 3: {
                    hello.remove();
                    break;
                }
                case 4: {
                    hello.update();
                    break;
                }
                case 5: {
                    hello.sort();
                    break;
                }
                
                // Other case here!!!
            }
        } while (choice >= 1 && choice <= 5);  // Modify the condition to exit the loop!!!
    }
    
}
