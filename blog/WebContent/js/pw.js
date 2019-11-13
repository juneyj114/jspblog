function validateCheck(){
    const password = document.querySelector('#password').value;
    const passwordCheck = document.querySelector('#passwordCheck').value;
    const addr = document.querySelector('#roadFullAddr').value;
    console.log(password);
    if(addr == ""){
    	console.log('주소 미입력')
    	return false;
    }
    if(password === passwordCheck){
        console.log('비밀번호 일치')
        return true;
    } else {
        console.log('비밀번호 불일치')
        return false;
    }
}