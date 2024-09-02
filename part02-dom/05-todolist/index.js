document.querySelector("form").addEventListener("submit", (event)=>{
    event.preventDefault(); //chặn sự kiện reset trang khi submit
    const name = document.querySelector("#name").value;
    // tạo ra đối tượng item
    const item = {
        id: new Date().toISOString(),
        name: name.trim(), //trim để xóa khảng cách thừa
    };
    // hiển thị object item lên UI
    addItemToUI(item);
    //lưu trữ item lên localStorage
    addItemToLs(item);

});

// mặc dù nó ở phía trên nhưng những gì được gọi trong hàm thì vần là callbackFunc nên nó 
// chỉ chạy khi được gọi, nên trước khi có sự kiện submit thì nó các hàm ngoài đã chạy xong
// nên vẫn chạy bth


//addItemToUI hàm nhận vào item và hiển thị lên UI

const addItemToUI = (item) =>{
    const newCard = document.createElement("div");
    newCard.className = "card d-flex flex-row justify-content-between align-items-center p-2 mb-3";
    newCard.innerHTML = `
        <span>${item.name}</span>
        <button data-id= "${item.id}" class="btn btn-danger btn-sm btn-remove">Remove</button>
    `;
    document.querySelector(".list").appendChild(newCard);
    // dùng innerHTML: nội dung có html trong đó
    // outerHTML: dùng để thay thế toàn bộ thẻ div
    // textContent: dùng để chỉ thêm chữ
};
// lấy danh sách các item từ ls về
const getList = () =>{
    return JSON.parse(localStorage.getItem("list")) || []; //|| tìm true , 
    // với dòng JSON nếu tìm được cái chuỗi thì ép kiểu về mảng không thì trả null và || tìm thằng
    // dk 2 (1 mảng rỗng => true) nên sẽ xuất ra chuỗi rỗng
};

const addItemToLs = (item) =>{
    const {name , id} = item;
    const list = getList(); //lấy danh sách về
    list.push(item); //nhét item vào danh sách
    //lưu list đã nhét lên lại localStorage 
    localStorage.setItem("list", JSON.stringify(list));
};

// hàm render tất cả item lên UI mỗi khi vào trang
const init = () =>{
    let list = getList();
    list.forEach((item) => {
        addItemToUI(item);
    });
};

init();

// vì là DOM ảo nên ko thể DOM vào được
document.querySelector(".list").addEventListener("click" , (event) =>{
    if(event.target.classList.contains("btn-remove")){
        const idRemove = event.target.dataset.id; //lấy id cần remove từ data-id của nút và xóa nó
        const nameItem = event.target.previousElementSibling.textContent;
        const isConfirmed = confirm(`Bạn có chắc là muốn xóa item: ${nameItem} không ?`);
    if(isConfirmed){
        //xóa trên UI trước
        event.target.parentElement.remove();
        //xóa trên ls
        const idRemove = event.target.dataset.id; //lấy id cần remove từ data0id của nút xóa
        removeItemFromLS(idRemove)
        };
    }
});

// hàm nhận vào id từ button remove đã nhấn , dùng id đó tìm và xóa item trong localStorage
const removeItemFromLS = (idRemove) =>{
    let list = getList();
    list = list.filter((item) => item.id != idRemove);
    localStorage.setItem("list", JSON.stringify(list))
}


document.querySelector("#btn-remove-all").addEventListener("click", (event) =>{
    const isConfirmed = confirm(`Bạn có muốn xóa hết item không ?`)
    if(isConfirmed){
        document.querySelector(".list").innerHTML = "";
        localStorage.removeItem("list");
    };
});

// chúc năng filter
document.querySelector("#filter").addEventListener("keyup", (event) =>{
    let inputValue = event.target.value;
    let list = getList();

    list = list.filter((item) => item.name.includes(inputValue));
    // xóa các item trong list để render list vừa lọc
    document.querySelector(".list").innerHTML = "";
    list.forEach((item) => {
        addItemToUI(item);
    });
});

