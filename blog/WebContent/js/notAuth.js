
function init() {
    alert('인증을 하지 못하였습니다.');
    location.href="/blog/user/login.jsp";
}

function btn() {
    const mainUl = document.querySelector("#mainUl");
	console.log(mainUl);
	const id = "<c:out value='${sessionScope.user.id}'/>";
	console.log(id);
    const li = document.createElement("li");
    li.innerText = "Text";
    mainUl.appendChild(li);

}

init();