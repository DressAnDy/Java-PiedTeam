//tính khải duyệt , trạng thái có khả năng được duyệt
/*
List: String ordered
Ko xóa phần tử chung
Collection: mảng đặc biệt , cần thằng khác implement
Khác nhau giữa collection và collections
Collection là một cái túi đặc biệt , có những mảng đặc biệt
ArrayS
Collections: là 1 class chứa rất nhiều method hỗ trợ cho Collection

Set: xóa bị trùng

Collection
    - List: giống mảng bình thường , đưa vào như vào thì lưu trự như z (co giãn)
            có thứ tự ,
    - Queue: mảng có cấu trúc như nhàng đợi (Firt In First Out) Or ( First In Last Out)
            + tùy vào và có thể ko giống về thứ tự
    - Set: Xóa duplicate , thứ tự ko ổn định
    - Deque: 
    - Map: thực thể 
Framework: khuôn , có cấu trúc sẵn , phải đổ giá trị để chạy được
           


*/
package runtime;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.scene.layout.Priority;

public class Program {

    public static void main(String[] args) {
        //playWithArrayList();
        playWithQueue(); //call
    }
    
    public static void playWithArrayList(){ //build
        /*
        ArrayList: mảng đặc biệt và là class triển khai (implement) của interface list
            ArrayList rất giống Array primitive (mảng nguyên thủy) , nhưng Array primitive
            ko co giãn được và sinh bao nhiu chỉ xài bấy nhiêu
            còn ArrayList là mảng động , co giãn được , 
        */
        
        //tạo thử mảng cùi
        int arrPrimitive[] = new int[10]; //thiếu 10 là bug ngay
        //tạo ra mảng cùi có 10pt , mún thêm cũng ko được , mà xài ít hơn cũng ko được
        
        //arrPrimitive thì sẽ lưu dc gì ?  primitive datatype , object datatype
        //                                 Warpper class | String
        
        //tạo thử ArrayList 
        //ArrayList: lại là 1 mảng có khả năng co giản , nhưng nó chỉ chơi với 
        //object
        ArrayList<Integer> arrIntList = new ArrayList<>();
        //các collection bao gồm ArrayList thì ko chơi với primitive datatype
        //nên phải dùng Wrapper Class tương ứng
        //ngoài ra ta có thể khai bao thế này cũng được
        List<Integer> arrIntListV2 = new ArrayList<>(); //khai cha new con
        //khai cha new con
        //các method của arrayList
        // .add(value): thêm 1 value vào trong list
        arrIntList.add(new Integer(3)); //vì mình lưu Integer không phải int
        arrIntList.add(new Integer(2));
        arrIntList.add(4); //có auto-unboxing
        
        System.out.println(arrIntList); //[3,2,4] //arrInList.toString();
        
        //.clear(): xóa hết các pt trong mảng
        arrIntList.clear(); //xóa sạch
        System.out.println(arrIntList); 
        //xài cái này là xóa sạch
        
        //.add(index , value): nhét value vào vị trí index
        arrIntList.add(0 , 3);
        arrIntList.add(1 , 5);
        arrIntList.add(2 , 4);
        arrIntList.add(1 , 4);
        //3 , 5 , 4 -> 3 , 4 , 5 , 4
        System.out.println(arrIntList);

        arrIntListV2.add(9);
        arrIntListV2.add(12);
        
        //.addAll(intdex , list) thêm list vào index
        arrIntList.addAll(2, arrIntListV2); 
        //arrInList [3,4,9,12,5,4] 
        System.out.println(arrIntList);
        
        //giả xử , anh cần phải truy xuất mảng bằng mảng cùi , rồi
        //sau đó muốn quay lại xài mảng ArrayList để có thể co giản thì làm sao
        Integer arrDemo[] = {3,5,7};
        //giờ mình phải chuyển mảng cùi thành mảng xịn
        //Arrays: là class chứa method hỗ trợ cho Array
        //Arrays.asList(ds): biến array thành List
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arrDemo));
       //arrList là phiên bản ArrayList của arrDemo
       //arrList sẽ co giản được , những truy xuất sẽ bị chậm
       //biến từ List về lại array primitive được ko ( có )
       //.toArray();
       //biến từ List thành arrayPrimitive
       //1. tạo mảng cùi trc
       Integer numList[] = new Integer[arrList.size()];
       //dùng size của mảng xin để tạo array Primitive vì nó cần kích thước lúc khởi tạo
       //lúc khởi tạo
       //2.nạp giá trị từ mảng xin vào arrayPrimitive
       arrList.toArray(numList); //numList được nạp giá trị từ arrList
       
        System.out.println(numList); //mảng cùi chưa dc Override .toString
        //để hiện thị đẹp , nếu muốn đẹp thì phải for 0 --> size - 1;s
        
        //.get() ( cái này của list và chỉ có nó mới có method này)
        //lấy ra 'xem' pt ở trị ví index trong list
        //arrList[3,5,7] 
        System.out.println(arrList.get(1)); //được 5 vì nó nằm ở index 1
        //.set(index , value): 'gán' | thay thế giá trị ở vị trí index = value
        //mún đổi số 5 thành số 9
        arrList.set(1, 9);
        //arrList[ 3, 9 , 7]
        
        //thử thách: swap 3 và 7 trong mảng đi , chỉ dùng get và set
        Integer tmp = arrList.get(0);
        arrList.set(0 , arrList.get(2));
        arrList.set(2 , tmp);
        //vậy là arrList sẽ là [7,9,3]
        
        //iterable: tính khả lọc , tính khả duyệt (interface)
        //iterator: method của interface //là 1 object có khả năng định nghĩa dc
        //trình tự và giá trị có thể trả ra cho lần gọi tiếp theo
        //mô tả những gì diễn ra trong fore
        //khi mà mình mún fore thằng arrList , anh sẽ tạo ra iterator từ arrList
        //arrList
        Iterator<Integer> it = arrList.iterator(); //kêu arrList cung cap71
        //1 iterator để anh duyệt
        //it là iterator của arrList và fore sẽ dùng it để duyệt thay vì dùng
        //for từ 0 đến size - 1
        System.out.println(it.hasNext()); //còn true | hết false
        System.out.println(it.next()); //lấy ra pt tiếp theo 7 
        System.out.println(it.next()); //lấy ra pt tiếp theo 9 
        System.out.println(it.next()); //lấy ra pt tiếp theo 3 
        //System.out.println(it.next());
        
        //.remove(index): xóa pt nằm ở vị trí index trong list
        //arrList[7,9,3] muốn xóa số 9
        arrList.remove(1); //xóa 9 vì 9 nằm ở vị trí 1
        //arrList[7,3] 
       
        //.removeAll(list): xóa hết các phần tử trong list
        arrList.add(5);
        arrList.add(9);
        arrList.add(2);
        arrList.add(12);
        
        //arrList[7,3,5,9,2,12]
        //arrIntListV2[9,12]
        
        arrList.removeAll(arrIntListV2); //trong arrList xóa các pt thuộc
        //arrIntListV2 | xóa hết 9 và 12
        System.out.println(arrList); //[7,3,5,2]
        
        //.size(): lấy kích thước 
        //.clone(): tạo 1 list mới có cùng pt và cùng size với bản gốc
        
        ArrayList<Integer> demoClone = (ArrayList)arrList.clone(); 
        //clone là shallow copy - copy nông , copy chưa cắt hết dây tơ rễ má
        //deep copy: cắt hết dây mơ rễ má ( phải tự làm )
        
        //.contain(key): tìm key trong danh sách ( return boolean)
        //.notfifyCapacity(): thông tin , giới hạn lưu trữ
        //.isEmpty(): có trống hay ko (boolean)
        //.indexOf(key): tìm key ở vị trí nào
        //.trimToSize(): thu nhỏ đến kích thước thật   
    }
    
    public static void playWithQueue(){
        Queue<Integer> numList = new LinkedList<>();
        //lai giữ queue và list
        //khai cha neu con
        //.add(value): nhét phần tử vào tail của danh sách (true) | illegal exception
        numList.add(3); //không có add theo dạng .add(index , value) nếu xài là
        //chen hàng
        //.offer(): nhét pt vào tail của danh sách (true|false)
        numList.offer(1);
        numList.offer(5);
        numList.offer(4);
        //numList: head[ 3 , 1 , 5 , 4 ] tail
        //vẫn giữ dc thứ tự truyền vào vì linkedList thuộc list
        //hàng đợi thì ko có get(index) => ko dc phép lấy ra 1 phần tử bất kì 
        //trong hàng
        
        //.element(): lấy ra 'xem' pt đầu tiên ở head (thuộc về collection) - 
        //lấy ra dc thì dc pt còn ds ko còn ai thì sẽ bị nullPointer exception
        numList.element();
        numList.element();
        
        //.peek(): nhìn trộm, cũng là lấy ra xem như thằng kia head(pt|null)
        
       //.remove(): xóa phần tử ở vị trí head và return pt đã xóa => mình lấy ra
       //dc để xử lý (pt | nullPointer exception)
       numList.remove(); //xóa số 3 và ném số 3 ra ngoài cho mình xử lý [1,5,4]
       numList.remove(); //xóa số 1 và ném số 1 ra ngoài cho mình xử lý [5,4]
       
       //.poll(): lấy pt đầu tiên của head ra khỏi dành sách để xứ lý ( pt | null)
       numList.poll(); //lấy ra 5 khỏi danh sách [4]
        System.out.println(numList);
        
        //nhét thêm
        numList.offer(5);
        numList.offer(1);
        numList.offer(2);
        //numList [4,5,1,2]
        
        //thường thì khi dùng queue ko quan tâm bên trong chứa gì cả
        //không quan tâm số lượng bao nhiêu
        //chỉ quan tâm thằng tiếp theo còn hay không. k thì kết thúc
        
        while(true){
            Integer tmp = numList.poll(); //lấy thằng đầu hàng của numList
            if(tmp == null) break; //thoát nếu ko còn ai trong danh sách
            //do something
            System.out.println("Ahihi " + tmp + " là đứa bị xử tiếp theo");
        }
        
        //numList sẽ là [] ( rút ra hết r nên ko còn gì) - rỗng
        
        //PRIORITY QUEUE ( hàng đợi ưu tiên )
        Queue<Integer> numListV2 = new PriorityQueue<>();
        
        numListV2.offer(3);
        numListV2.offer(1);
        numListV2.offer(5);
        numListV2.offer(9);
        numListV2.offer(2);
        
        //root lun sẽ bé nhất
        
        //rút poll()
        numListV2.poll(); //1
        numListV2.poll(); //2
        numListV2.poll(); //3
        numListV2.poll(); //5
        numListV2.poll(); //9
        System.out.println(numListV2);
        
        //ArrayDeque //mạnh quá nên tự neft , buộc phải giảm hàm
        Deque<Integer> numDeque = new ArrayDeque<>();
        //front(first) .. rear(last)
        //.add()| .offer(): ko nhét vào tail , nhét vào rear
        //.addLast() | .offerLast()
        
        //.addFisrt() | .offerFirst(): nhét vào front ( mặt trước)
        
        //nhìn
        //.element() | .peek() | .elementFirst | peekFrist() ( dùng peek là chủ yếu)
        // nhìn ở front
        
        //.elementLast() | .peekLast(): nhìn ở rear
        
        
        //lấy ra
        //.remove() | .poll() | .removeFirst() | .pollFirst() lấy ở front
        //.removeLast() | .pollLast() : lấy ở rear
        
        //muốn dùng arrayDeque để mô tả 1 queue FIFO ( vào tail ra head)
        //front(first) rear(last)
        //thêm: .offerLast()
        //nhìn: .peekFirst()
        //lấy: .pollFirst()
        
        //LIFO
        //thêm: .offerLast()
        //nhìn: .peekLast()
        //lấy: .pollLast()
        
    }
}