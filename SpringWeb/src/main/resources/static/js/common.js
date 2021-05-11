// 공백확인 함수
function checkExistData(value, dataName) {
    if (value == "") {
        alert(dataName + "을 입력해주세요!");
        return false;
    }
    return true;
}    

// 유효성 확인 함수
function checkEffectiveness(value, type, name) {
	var regExp;
	
	// 체크 리스트
	if (type == "all") {
		regExp = /^[a-zA-z0-9]{4,12}$/;
	} else if(type == "int") {
		if(name == "groupCd")
			regExp = /^[0-9]{1,4}$/;
		else if (name == "codeCd")
			regExp = /^[0-9]{1,3}$/;
	} else if(type == "string")
		if(name == "singleLine")
			regExp = /^[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]{1,100}$/;
	
	   			
		
	// 체크 함수
	if (!regExp.test(value))
		return false;
	  		
	
	return true;
}