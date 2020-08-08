
package com.aks.woorimtech.cmm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		String apiKey = request.getHeader("apiKey")== null ? "" : request.getHeader("apiKey");
		
		//3. 권한 확인
		String urlExtension = request.getRequestURI();
		
		
		if("".equals(urlExtension)) {  //초기 페이지
			return true;
		}
		else if(skipUrlCheck(urlExtension)) {  //권한 체크 예외처리
		
			//DB에서 관리하도록 설정함
			
		} else if(urlExtension.indexOf(".do") > -1) { // 화면호출인 경우 세션체크 후 권한체크
			
			if(urlExtension.indexOf("test") > -1) {
				return false;
			}else {
				return true;
			}
			
			
		} else if(urlExtension.indexOf("svc") > -1) { // 서비스호출인 경우 세션체크
			
			//01. 세션 확인
			String sessionId = request.getParameter("sessionId")== null ? "" : request.getParameter("sessionId");
			
			//02. 세션이 없을 경우 API Key 확인
			if(!checkApiKey(apiKey)) {
				throw new Exception("Invalid authentication key");
			}
			
			
			
			return true;
		}
		
		return false;
	}
	
	public boolean skipUrlCheck(String urlExtension) {
		
		boolean skipFlag = false;
		
		return skipFlag;
	}

	private boolean checkApiKey(String apiKey) {
		
		/*추후 DB에서 관리하는 방법으로 설계함.*/
		if("kim123!@#!".equals(apiKey)) {
			return true;	
			
		}else {
			return false;
			
		}
		
	}
	
	
}

