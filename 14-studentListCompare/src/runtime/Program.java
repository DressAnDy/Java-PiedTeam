/*
Mình có thể so sánh object bằng cách nào ?
== : so sánh về mặt địa chỉ của object
.equalsTo(): boolean
.compareTo(): int
Wrapper Class và String

    Sinh viên()

Nếu mà đối tượng cần so sánh là sinh viên thì điều này sẽ khó hơn rất nhiều
vì sinh viên được mô tả = rất nhiều thuộc tính , khi mình nói về việc so sánh 
thì mình nên chọn 1 thuộc tính để làm tiêu chuẩn

vậy thì nếu như là wrapper class và String thì cứ thông thả dùng equalsTo() và 
compareTo() , nhưng nếu phải so sánh 2 đối tượng phức tạp thì phải quy về String
hoặc premitve


cơ chế của Sort
2 cách sắp xếp
    - compareble : tính đố kị
    - comparetor: anh trọng tài




*/
package runtime;

import data.StudentV1;
import data.StudentV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Program {
    public static void main(String[] args) {
        //sortV1(); //call
        sortV2(); //call
    }
    
    public static void sortV1(){
        //tạo ra danh sách sinh viên
        ArrayList<StudentV1> stduList = new ArrayList<>();
        stduList.add(new StudentV1("SE001","Lê","An",8.2));
        stduList.add(new StudentV1("SE002","Nguyễn","Bình",7));
        stduList.add(new StudentV1("SE003","Lý","Cường",9));
        stduList.add(new StudentV1("SE004","Trần","Dũng",5));
        stduList.add(new StudentV1("SE005","Võ","Em",9.9));
        /*
            ta có hàm SortV1(): mình sẽ sort danh sách sinh viên bình thường
        thông qua việc sử dụng comparator, vì StudentV1 sẽ tạo ra các sinh viên
        không có tính đố kị , nên mình sẽ tạo ra 1 anh trọng tài giúp mình so 
        sánh , từ đó đưa ra kết quá sắp xếp
        - comparator là gì ?
            - về mặt hiểu: comparator là 1 người đúng ra xem xét 2 đối tượng 
            đựa trên 1 tiêu chí nào đó , từ đó cho kết quả 1(lớn) và - 1(bé)
            - về mặt lý thuyết: comparator là một interface có 1 method duy nhất
                cụ thể comapare(t1 , t2), tức là ảnh bik mình phải so sánh t1
                và t2 là 2 đối tượng bất kì , nhưng ko bik làm sao , cần mình
                implement cách so sánh
        - sau khi mình tạo dc anh trọng tài , thì mình sẽ bỏ anh trọng tài vào
        studList của mình , ảnh sẽ tự so sánh và sort thành công
            - thông qua collections.sort()
        */
        Comparator ordById = new Comparator<StudentV1>() {
            @Override
            public int compare(StudentV1 t1, StudentV1 t2) {
                //generic
               if(t1.getId().compareTo(t2.getId()) > 0){
                   return 1; //nói rằng t1 lớn hơn t2
               }
               return -1; // nói rằng t1 bé hơn t2
            }
        };
        //Collections là 1 class chưa rất nhiều methods giúp xứ lý danh sách
        // nhưng những danh sách đó phải thuộc Collection thì mới dc xài
        //ArrayList là 1 thằng thuộc Collection 
        Collections.sort(stduList , ordById);
        //in ra xem
        for (StudentV1 item : stduList) {
            item.showInfor();
        }
    }

    public static void sortV2(){
        ArrayList<StudentV2> stduList = new ArrayList<>();
        stduList.add(new StudentV2("SE001","Lê","An",8.2));
        stduList.add(new StudentV2("SE002","Nguyễn","Bình",7));
        stduList.add(new StudentV2("SE003","Lý","Cường",9));
        stduList.add(new StudentV2("SE004","Trần","Dũng",5));
        stduList.add(new StudentV2("SE005","Võ","Em",9.9));

    //lần này stuList chừa toàn StudentV2 là 1 đám sv có tính đố kỵ
    //và chúng nó ko cần tới trọng tài
        Collections.sort(stduList);
        
    }
}
