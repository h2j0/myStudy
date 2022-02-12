// 화면이 켜질 때 
window.onload = function () {
    let jsonData = localStorage.getItem('data')
    const noZzim = document.querySelector("#no-zzim")
    const yesZzim = document.querySelector("#yes-zzim")

    let noZzimMent = document.createElement("div");
    noZzimMent.innerHTML = `<div>&nbsp;&nbsp;아직 찜한 영화가 없네요&#128549</div>`;
    noZzim.appendChild(noZzimMent);

    if (jsonData === null) {
        noZzimMent.style = "display:block"; // 찜 목록이 없으면 찜 영화 없다는 noZzimMent div 보여주고

    } else {
        noZzimMent.style = "display:None"; // 있다면 노찜을 숨기고
        // 로컬에서 가져온 데이터를 보여준다 (조회)
        let tmpData = []
        tmpData = JSON.parse(jsonData); //배열

        let zzimListString = ''
        for (let i = 0; i < tmpData.length; i++) {
            // let zzimlist = document.createAttribute("li");
            zzimListString += `<li class="zzim-title"> ${tmpData[i]["title"]} \n </li>`;

            // zzimListString += `<div> ${tmpData[i]["genre"]}</div>`;
            // zzimListString += `<div> ${tmpData[i]["director"]}</div>`;
            // zzimListString += `<div> ${tmpData[i]["runningtime"]}</div>`;
            // li.innerText = (tmpData[i]["genre"]);
            // li.innerText = (tmpData[i]["director"]);
            // li.innerText = (tmpData[i]["runningtime"])
        }
        yesZzim.innerHTML = zzimListString;


    }

}
// 찜 버튼 누를 때
let zzims = document.querySelectorAll(".zzim");
let data = [];
zzims.forEach((zzim) => {
    zzim.addEventListener("click", function (event) {
        console.log(event.path[1].children[0].innerText);
        const totData = event.path[1].children[0].innerText;
        data = totData.split("\n")

        // 제이슨으로 만들기
        const movieData = {
            title: data[0],
            genre: data[1],
            director: data[2],
            runningtime: data[3],
        }

        let jsonData = localStorage.getItem('data');
        if (jsonData === null) {
            jsonData = [movieData];
        } else {
            jsonData = JSON.parse(jsonData)
            jsonData.push(movieData);
        }
        localStorage.setItem('data', JSON.stringify(jsonData));
        
    })
})
