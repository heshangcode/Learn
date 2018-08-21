package com.hs.web;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * 文件上传操作
 */
@Controller
public class UploadDemoController {

	/**
	 * 单文件上传_标准写法
	 *
	 * @param title
	 * @param myfile
	 * @param request
	 * @return
	 */
	@PostMapping("/upload01")
	public ModelAndView test01(String title, MultipartFile myfile, HttpServletRequest request) throws IOException {
		ModelAndView mav = new ModelAndView();
//		System.out.println(title);
		//1.获取上传文件的名称
		String fileName = myfile.getOriginalFilename();
		mav.addObject("fileName", fileName);
		//2.判断文件名称是否有值,isEmpty是这个字符串的length=0为true
		if (!fileName.isEmpty()) {
			//3.获取服务器的绝对路径
			String path = request.getServletContext().getRealPath("/upload");
			//4.建立联系
			File folder = new File(path);
			//5.判断该文件是否存在，不存在则创建文件夹
			if (!folder.exists()) {
				folder.mkdirs();    //创建文件夹
			}
			//6,获取上传文件的后缀名称
			String ext = FilenameUtils.getExtension(fileName);
			//7.创建新的文件名称
			//String newFileName = UUID.randomUUID().toString() + "." + ext;
			//或者用时间戳创建名称
			String newFileName = new Date().getTime() + "_" + new Random().nextInt(100000) + "." + ext;
			mav.addObject("newFileName", newFileName);
//			System.out.println(newFileName);
			//8.文件上传，File.separator为斜线
			myfile.transferTo(new File(path + File.separator + newFileName));
		}
		mav.addObject("hs", "和尚");
		mav.setViewName("jsp/result");
		/*System.out.println("测试是否可以获取正常的数据:"+title);
		System.out.println("=====");
		System.out.println("文件的MIME类型 :"+myfile.getContentType());
		System.out.println("文件NAME属性对应的值 :"+myfile.getName());
		System.out.println("上传文件的名称 :"+myfile.getOriginalFilename());
		System.out.println("上传文件的大小 :"+myfile.getSize());*/
		return mav;
	}
}
