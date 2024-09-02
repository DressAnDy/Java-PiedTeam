const VALUES = [
    {id: "scissors", value: "✌🏽"}, //index: 0
    {id: "rock", value: "✊🏽"}, //1
    {id: "paper", value: "🖐🏽"}, //2
];

// phân tích logic
// valuePlayer và valueComputer => "scissors" | "rock" | "paper"
// từ valuePlayer và valueComputer duyệt VALUES tìm dựa id nào giống
// indexPlayer và indexComputer
// khi nào thắng
// 0 2
// 1 0
// 2 1

//0 - 2 = -2
//1 - 0 = 1 indexPlayer - indexUser = 1 || -2 thì return 1
//2 - 1 = 1

//khi nào hòa indexPlayer - indexUser = 0 || thì hòa return 0

//còn lại là thua                                   return -1  

let i = 0;
const handleChange = () =>{
    let computer = document.querySelector("#computer");
    computer.textContent = VALUES[i].value;
    computer.setAttribute("data-id", VALUES[i].id);
    i = i === VALUES.length - 1 ? 0 : ++i;
};

let interval = setInterval(handleChange, 50);

// hàm compare: hàm so sánh giá trị
// thắng 1 hòa 0 thua -1
// 
const compare = (valuePlayer, valueComputer) =>{
    // tìm index của các value tương ứng
    let indexPlayer = VALUES.findIndex((item) => item.id == valuePlayer);
    let indexComputer = VALUES.findIndex((item) => item.id == valueComputer);
    let reuslt = indexPlayer - indexComputer;
    if([1, -2].includes(reuslt)) return 1;
    else if(reuslt == 0) return 0;
    else return -1;
}

let playerItem = document.querySelectorAll(".user");

playerItem.forEach((item) =>{
    item.addEventListener("click", (event) => {

    // dừng máy lại và lấy data-id
    clearInterval(interval);
    // lấy data-id của máy
    let computer = document.querySelector("#computer");
    let valueComputer = computer.dataset.id;
    let valuePlayer = event.target.id;

    let reuslt = compare(valuePlayer , valueComputer);
    console.log(reuslt);


    playerItem.forEach((_item) =>{
        _item.classList.remove("actived");
        _item.style.pointerEvents = "none";
    });

    // them actived cho nut vua nhan
    event.target.classList.add("actived");
    // kết luận in thông báo
    let alertDiv = document.createElement("div");
    alertDiv.classList.add("alert");
    let msg = "";
    if(reuslt == 1){
        msg = "Bạn Thắng";
        alertDiv.classList.add("alert-success");
    }else if(reuslt == 0){
        msg = "Bạn Hòa";
        alertDiv.classList.add("alert-warning");
    }else{
        msg = "Bạn Thua";
        alertDiv.classList.add("alert-dark");
    }
    alertDiv.textContent = msg;
    document.querySelector(".notification").appendChild(alertDiv);
    // hiện nút chơi lại
    document.querySelector("#play-again").classList.remove("d-none");
    });
});

document.querySelector(".btn-play-again").addEventListener("click", (event) =>{
    a
    clearInterval(interval);
    interval = setInterval(handleChange, 100);
    
    playerItem.forEach((item) =>{
        item.classList.remove("actived");
        item.style.pointerEvents = "";
    });
    document.querySelector(".notification").innerHTML = "";
    document.querySelector("#play-again").classList.add("d-none");
});