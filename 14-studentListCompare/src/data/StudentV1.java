/*
Student V1: là 1 cái khuôn đúc ra sinh viên bình thường , ko có ganh đua
đố kỵ
*/
package data;

public class StudentV1 {
    //props
    private String id;
    private String fName;
    private String lName;
    private double score;

    //constructor
    public StudentV1(String id, String fName, String lName, double score) {
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
}
