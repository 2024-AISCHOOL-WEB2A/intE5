package com.WCLProject.model.Service;


import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.WCLProject.model.DAO.MemberDAO;
import com.WCLProject.model.DTO.VendorMemberDTO;

@WebServlet("/JoinService_Vendor")
public class JoinService_Vendor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("vendor_id");
		String pw = request.getParameter("vendor_pw");
		String name = request.getParameter("vendor_name");
		String tel = request.getParameter("vendor_tel");
		String email = request.getParameter("vendor_email");
		String address = request.getParameter("vendor_address");
		String detailAddress = request.getParameter("vendor_detailAddress");
		String extraAddress = request.getParameter("vendor_extraAddress");
		String license = request.getParameter("vendor_license");
		String category = request.getParameter("vendor_category");
		String license_image = request.getParameter("vendor_license_image");
		String logo_image = request.getParameter("vendor_logo_image");
		String intro = request.getParameter("vendor_intro");
		String site_url = request.getParameter("vendor_site_url");
		
		String fullAddress = address;
        if (detailAddress != null && !detailAddress.isEmpty()) {
            fullAddress += ", " + detailAddress;
        }
        if (extraAddress != null && !extraAddress.isEmpty()) {
            fullAddress += ", " + extraAddress;
        }
        
		/*
		 * // 파일 경로를 얻기 위한 AJAX 요청 (이 부분은 클라이언트 측에서 처리해야 함) // 서버 측에서는 클라이언트로부터 파일 경로를
		 * 받아야 함. String vendorLicenseFilePath = (String)
		 * request.getAttribute("vendorLicenseFilePath"); String vendorLogoFilePath =
		 * (String) request.getAttribute("vendorLogoFilePath");
		 */
        
		VendorMemberDTO vendor = new VendorMemberDTO(id, pw, name, tel, email, fullAddress, license, category, license_image, logo_image, intro, site_url);
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.vendorMemberJoin(vendor);
		
		if (cnt > 0) {
			System.out.println("회원가입 성공");
			response.sendRedirect("signupSucess.jsp");
		} else {
			System.out.println("회원가입 실패");
			response.sendRedirect("sinup_vendor.jsp");
		}
	}

}
