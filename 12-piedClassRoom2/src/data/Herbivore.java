package data;
/*
Herbivore
có thể cho Herbivore tham gia hội StudyEnthusiasts không ? 
nếu cho Herbivore tham gia vào thì gây ảnh hưởng đến logic nên không
code thì dc nhưng ko làm , vì như vậy thì ai lại chửi ngu như bò =))

*/
public abstract class Herbivore {
    //pror
    protected String name;
    protected int yob;
    protected double weight;
    //constructor
    public Herbivore(String name, int yob, double weight) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
    }
    //method

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getWeight() {
        return weight;
    }
    
    //showInfor: tạo ra chuỗi đẹp, in ra chuỗi đẹp đó
    //ai gọi showInfor: thì có dùng dc chuỗi đẹp đó ko ? ko
    //vạn vật bắt đầu từ object

    //Hàm toString là hàm của object -> dùng @Override để độ lại hàm này để sử
    //dụng ( cách này ngon hơn)
    //Có tạo ra chuỗi đẹp nhưng không in ra mà do mình tùy ý sử dụng
    //sử dụng sout 1 cái h1 mà ko cần phải .toString
    @Override
    public String toString() {
        String str = String.format("|%-20s|%-10s|%4d|%6.2f",
                                    "Herbivore", name , yob , weight);
        return str;
    }
    
    //method study: con vật đó học và trả ra điểm số (double)
    //mỗi một herbivore thì sẽ có một mức độ tiếp thu kiến thức khác nhau
    //vì chúng học bằng các cách khác nhau
    //vd: Ngựa vừa học vừa hú hí
    // con khỉ là học kiểu bắt chước (mimic)
    
    public abstract double study();
    
    //vì chúng học khác nhau nên khi hiển thị kết quả học tập thì kết quả học
    //tập cũng có phần khác nhau
    
    public abstract void showLearningOutcomes();
    
}
