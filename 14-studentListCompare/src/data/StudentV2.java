/*
Student V1: là 1 cái khuôn đúc ra sinh viên bình thường , có ganh đua
đố kỵ
nó cũng chỉ là interface có duy nhất một method là compareTo()
sinh viên bth , tham gia vào hội "Những người thích đố kỵ: thì sẽ dc thừa hưởng
1 ý chí "Thích so sánh bản thân với người khác" (compareTo)
*/
package data;

public class StudentV2 implements Comparable<StudentV2>{
    //props
    private String id;
    private String fName;
    private String lName;
    private double score;

    //constructor
    public StudentV2(String id, String fName, String lName, double score) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.score = score;
    }
    //getter

    public String getId() {
        return id;
    }
    
    //show
    public void showInfor(){
        String str = String.format("%-15s|%-20s|%-20s|%5.2f",
                                    id , fName , lName , score);
        System.out.println(str);
    }

    @Override
    public int compareTo(StudentV2 that) {
        if(this.getId().compareTo(that.getId()) > 0){
            return 1;
        }
        return -1;
    }
}
