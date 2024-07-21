package com.WCLProject.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class WeddingChocieDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	// 데이터베이스 연결
	public void connect() {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu3.smhrd.com:1524:xe";
			String user = "Insa5_SpringA_hacksim_3";
			String password = "aishcool3";
			
			conn = DriverManager.getConnection(url, user, password);
			
			if (conn == null) {
				System.out.println("DB연결 실패...");
			} else {
				System.out.println("DB연결 성공!");
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	
	// 데이터베이스 연결 종료
	public void close() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입_기업 기능
	public int vendorMemberJoin(WCLMember_Vendor vendor) {
	    int cnt = 0;
	    connect(); 

	    String sql = "INSERT INTO VENDOR (VENDOR_ID, VENDOR_PW, VENDOR_NAME, VENDOR_TEL, VENDOR_EMAIL, VENDOR_ADDRESS, VENDOR_LICENSE, VENDOR_CATEGORY, VENDOR_LICENSE_IMAGE, VENDOR_LOGO_IMAGE, VENDOR_INTRO, VENDOR_SITE_URL, VENDOR_JOIN) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try {
	        pst = conn.prepareStatement(sql);
	        pst.setString(1, vendor.getId());
	        pst.setString(2, vendor.getPw());
	        pst.setString(3, vendor.getName());
	        pst.setString(4, vendor.getTel());
	        pst.setString(5, vendor.getEmail());
	        pst.setString(6, vendor.getAddress());
	        pst.setString(7, vendor.getLicense());
	        pst.setString(8, vendor.getCategory());
	        pst.setString(9, vendor.getLicense_image());
	        pst.setString(10, vendor.getLogo_image());            
	        pst.setString(11, vendor.getIntro());
	        pst.setString(12, vendor.getSite_url());
	        pst.setTimestamp(13, new Timestamp(System.currentTimeMillis())); 
	        
	        cnt = pst.executeUpdate();
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close(); 
	    }

	    return cnt;
	}

	
	
	
}