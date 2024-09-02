let btnList = document.querySelectorAll(".navtab-btn");
let contentList = document.querySelectorAll(".tab-content-item");
btnList.forEach((btn) =>{
    // duyệt qua từng nút
    // nút nào cũng chờ dc click
    btn.addEventListener("click", (event)=>{
        // cứ có hành động click thì chạy callBackFunction
        // nếu như có 1 nút bị nhấn thì
        // duyệt danh sách các nút và xóa actived
        // 
        btnList.forEach((_btn)=>{
            _btn.classList.remove("actived");
            // không có thì thôi , có thì xóa liền
            // 
        });
        event.target.classList.add("actived");
        // target: hành động vừa làm
        
        // xóa actived của các content (giống nút)
        contentList.forEach((content)=>{
            content.classList.remove("actived");
        })

        // lấy id của thằng vừa bị bấm
        let id = event.target.id;
        let contentChecked = document.querySelector(`
                .tab-content-item[data-id="${id}"]
            `);
        contentChecked.classList.add("actived");
    });
});