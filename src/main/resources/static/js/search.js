$(() => {
	$("#searchForm").on("submit", function() {
		// 驗證表單輸入欄位填寫及格式
        return verifyFormInput();
    });

	// Description: 驗證表單輸入欄位填寫及格式
	function verifyFormInput() {
        // 檢查帳號
		var verifyIc = isValidIc($("#ic").val());
		if(!verifyIc.valid) {
            alert(verifyIc.message);
            $("#ic").focus();
            return false;
		}
	}
})