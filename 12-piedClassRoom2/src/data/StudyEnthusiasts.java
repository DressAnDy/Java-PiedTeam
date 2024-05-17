/*
StudyEnthusiasts: hội những người đam mê học tập

Nếu bác thợ săn học bình thường thì lúc nào bác cũng lăm le "Phò mã".
nhưng nếu bác tham gia vào hội StudyEnthusiasts thì bác sẽ thừa hưởng ý chí
từ hội nhòm này và học ko quan tâm tới cái gì cả

=> học quên ăn

Nếu như ngựa học bình thường thì lúc nào ngựa cũng hú hí , học ko ra gì
nhưng nếu ngựa tham gia vào hội StudyEnthusiasts thì ngựa sẽ thừa hưởng ý chí
từ hội nhóm này và học ko quan tâm tới đến cái gì cả 

=> học ko sợ súng , học ko quan tâm mạng sống

StudyEnthusiasts: là hội nhóm để lưu trữ ý chí ham học , bỏ lại tất cả ,
bất cứ ai đang bth mà tham gia hội này thì sẽ học khô máu , học sống chết
ai cũng có thể tham gia vào đây , chí cần mún là dc nhưng nhớ rằng nếu đã chọn 
join vào đây thì sẽ phải thừa hưởng ý chí học tập ko màng tất cả

dù ngựa và bác thợ săn khác nhau về mặt sinh học , ko có gì giống nhau về props
nhưng chỉ cần tham gia vào hội nhóm này thì chúng sẽ có cùng 1 đam mê học tập
và dc nằm cùng 1 danh sách , " những người học tới chết" 


interface: bản chất là 1 class chỉ quan tâm tới method , ko quan tâm tới props
mún tham gia vào , ko quan tâm tới gì cả , chỉ quan tâm tới method ( ý chí)
ở dây , họ chỉ quan tâm đến sự ham học , còn học như nào no care
*/
package data;
public interface StudyEnthusiasts {
    //ai cũng có thể tham gia vào câu lạc bộ này , nhưng nếu mún tham gia thì 
    //phải ham học
    //vào đây mới ham học
    
    //và vì thế ko quan tâm tới props -> không có props
    //nhưng cố tình tạo 1 props thì sao ?
    //thì nó sẽ trở thành đồ xài chung của clb
    //máy tính sẽ tự nhận diện khi khai props
    //static final
    public int FAN = 3;
    
    
    //tóm lại final == const(hằng số), lúc tạo ra phải có sẵn giá trị
    //mà trong interface , tất cả props đều là static final
    //=> ko có ngăn nào bỏ trống
    //=> ko cần phễu để rót giá trị vào ngăn
    //interface sẽ có 1 cái phễu mặc định ( phễu rỗng)
    
    //ko có props thì cũng ko có getter và setter
    
    //tất cả các method trong interface đều là abstract method
    //dù em có code chữ abstract hay ko thì cũng z à =)))
    
    //abstract method
    public double studyHard();
    
    public void showProfile();
    
    
   //kha khá giống abstract
}

//thực tế thì ko nên có 2 method trong 1 interface, chỉ nên có 1


