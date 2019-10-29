package com.myclass.api.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class ApiUploadController {

	@PostMapping("upload")
	public Object post(@RequestParam MultipartFile file, HttpServletRequest request) {

		try {
			// Lấy đường dẫn tuyệt đối của thư mục chứa file upload
			String folderPath = request.getServletContext().getRealPath("/upload/");
			// Sử dụng đối tượng File của java.io để kiểm tra thư mục
			File dir = new File(folderPath);
			System.out.println("Folder save image: " + folderPath);
			// Nếu chưa tồn tại thư mục upload thì tạo mới
			if (!dir.exists()) {
				dir.mkdir();
			}

			// Lấy ra tên file vừa gửi từ client lên
			String fileName = file.getOriginalFilename();

			// Sử dụng đối tượng File của java.io để lưu file
			File filePath = new File(folderPath + fileName);

			// Sử dụng phương thức transferTo của MultipartFile để lưu file xuống thư mục
			file.transferTo(filePath);

			return new ResponseEntity<String>("/upload/" + fileName, HttpStatus.OK);

		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
}
