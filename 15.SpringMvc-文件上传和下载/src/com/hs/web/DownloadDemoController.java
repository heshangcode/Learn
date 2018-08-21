package com.hs.web;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 文件下载操作
 */
@Controller
public class DownloadDemoController {
	/**
	 * 文件下载，使用流的方法
	 *
	 * @param newFileName
	 * @param fileName
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/download")
	public ResponseEntity<byte[]> test02(String newFileName, String fileName, HttpServletRequest request) throws IOException {
		//获取服务端的绝对路径
		String path = request.getServletContext().getRealPath("/upload/");

		HttpHeaders headers = new HttpHeaders();
		//设置相应的内容为流
		headers.setContentType(MediaType.TEXT_EVENT_STREAM);
		//设置下载的名称--和中文乱码的问题
		headers.setContentDispositionFormData("attachment",
				new String(fileName.getBytes("UTF-8"), "ISO8859-1")
				);
		//找到文件
		File file = new File(path + File.separator + newFileName);
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),/*将文件转换为byte数组*/
				headers,
				HttpStatus.CREATED);

	}
}
