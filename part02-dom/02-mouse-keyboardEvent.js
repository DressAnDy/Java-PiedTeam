let btnAdd = document.querySelector("#btn-add");
btnAdd.addEventListener("click", (event) => {
    console.log(event);
    // return ra element vừa dính sự kiện
    // thực hiện ước mơ
    let inputNode = document.querySelector("#name");
    let newItem = document.createElement("li");
    newItem.className = "card mb-3 p-2";
    newItem.innerHTML = `<p>${inputNode.value}</p>`
    let list = document.querySelector("#list");
    list.appendChild(newItem);
    inputNode.value = "";
});

//mouseover
//mouseout
//dbclick

// keyboard event
let inputNode = document.querySelector("#name");
inputNode.addEventListener("change", (event)=>{
    console.log(inputNode.value);
});

// nhấn thì chưa nhân nhưng nhấn vào xong thả ra thì mới bắt đầu nhận
// event , thông tin của sự kiện
// keydown | keypress | keyup | input | change

//dùng cookie | localStorage : lưu trữ bên phía client
localStorage.setItem("name", "Điệp 10 ring");
// chỉ lưu được chuỗi và số mà thôi , nếu muốn lưu object hay mảng thì phải chuyển thành chuỗi dạng json
const profile = {
    name: "Điệp đẹp trai",
    age: 25,
};

console.log(profile);
let str = JSON.stringify(profile);
console.log(str);

localStorage.setItem("profile", str);

// lấy giá trị từ localStorage ra xài
let data = localStorage.getItem("profile");
let obj = JSON.parse(data);
console.log(obj);

// ôn bootstrap
// function
// bài part2