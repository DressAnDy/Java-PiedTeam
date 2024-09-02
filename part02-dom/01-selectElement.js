// DOM: document object model
// liên kết DOM | móc 1 biến vào 1 đối tượng trong DOM
//nếu muốn dom 1 đối tượng thì có 2 cách
// node: là 1 object có chu trình sống
// được tạo ra , hiển thị , update , delete
// life cycle of node
let inputNode = document.getElementById("name") //truyền vào giá trị id
inputNode = document.querySelector("#name"); //truyền vào seletor css 
console.log(inputNode);

// querySelector: cho phép query tìm kiếm phần tử dựa trên selector css
// chỉ cung cấp 1 phần tử (id), dù class hay id thì vẫn thu về 1 phần tử duy nhất
// điều này tốt

// vậy thì nếu mà mình cần lấy về 1 mảng các thẻ card thì sao
// let cardList = document.getElementsByClassName("card"); //HTMLCollection

let cardList = document.querySelectorAll(".card"); //NodeList
console.log(cardList);




cardList.forEach((item) =>{
    console.log(item);
})

//HTMLCollection giống mảng nhưng thiếu cá method cần thiết để xứ lý pt
//NodeList giống mảng nhưng đầy đủ đơn 1 tý
//Mún múp thì biến thành mảng

//
let firstCard = document.querySelector(".card");
console.log(firstCard);

//
console.log(firstCard.childNodes); //NodeList(5) [text, h2, text, p, text]

//
console.log(firstCard.children); //HTMLCollection(2) [h2, p] //danh sách các phần tử con

//
console.log(firstCard.classList); //DOMTokenList(3) ['card', 'p-2', 'mb-3', value: 'card p-2 mb-3']
//đem về mảng của cái class đó
//thêm thuộc tính mà mình không biết có hay chưa
//
console.log(firstCard.className);
//thêm 1 sll rất lớn các thuộc tính thì dùng

console.log(firstCard.parentElement);
console.log(firstCard.nextElementSibling); //tìm 1 thằng giống a nhưng ở dưới a   
console.log(firstCard.firstChild); //text
console.log(firstCard.firstElementChild); //h2

//tạo mới 1 element
let newCard = document.createElement("div");
// newCard.classList.add("card", "mb-3", "p-2"); //không ngon
newCard.className = "card mb-3 p-2";
newCard.innerHTML = `
    <h2>Tao được tạo bằng js</h2>
    <p>Tao là 1 node fakee</p>
`;

let cardGroup = document.querySelector(".card-group");
cardGroup.appendChild(newCard);
cardGroup.replaceChild(newCard, cardGroup.children[1]);

//thêm attribute vào node
firstCard.setAttribute("ahihi", "1");
console.log(firstCard.getAttribute("ahihi"));
// không thể querySelector vối DOM ảo
firstCard.removeAttribute("ahihi");