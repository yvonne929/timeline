$(() => {
    $("#timelineForm").on("submit", function() {
	    // 驗證表單輸入欄位填寫及格式
		return verifyFormInput();
    });
    
})