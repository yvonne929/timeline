package com.example.demo.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*過濾器的作用是檢查用戶是否已經登錄，
如果已經登錄，則重定向到 "/information" 頁面
；如果未登錄，則允許請求繼續通過過濾器鏈。
這種過濾器通常用於實現登錄驗證，確保只有已經登錄的用戶才能訪問某些頁面或資源。 */
public class UserFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		
		if(session.getAttribute("member") != null) res.sendRedirect("/search");
		else chain.doFilter(request, response);
	}

}
