package com.xworkz.rto.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.xworkz.rto.dto.UserDL;
import com.xworkz.rto.service.RtoDLService;
import com.xworkz.rto.service.RtoUserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class FileUploadController {

	@Autowired
	private RtoUserService userService;

	@Autowired
	RtoDLService dlService;

	@PostMapping("/upload")
	public String uploadFile(@RequestParam MultipartFile file, @RequestParam String dlApplicationNumber, Model model) {
		log.info("upload method in controller");
		UserDL dl = dlService.searchByDLAplication(dlApplicationNumber);
		model.addAttribute("m", dlApplicationNumber);
		System.err.println(dlApplicationNumber);
		System.out.println("Upload File Running ");
		if (file.isEmpty()) {
			model.addAttribute("message", "Please select a file to upload");
			return "index";
		}
		try {

			String fileContentType = file.getContentType();
			dl.setFileContentType(fileContentType);

			String filename = file.getOriginalFilename();
			dl.setFilename(filename);

			System.out.println("File Name is   : " + filename + "   content type is    " + fileContentType);
			byte[] bytes = file.getBytes();
			Path path = Paths.get("D://filesave//" + file.getOriginalFilename());
			Files.write(path, bytes);
			dlService.updateId(dl);
			model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
			model.addAttribute("message", "dl is successfully completed");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "uploadFiles";
	}

	@GetMapping("/download")
	public void downloadFile(HttpServletResponse response, @RequestParam String fileName) throws FileNotFoundException {
		log.info("download method in controller");
		response.setContentType("image/jpeg");
		File file = new File("D://filesave//" + fileName);
		try {
			InputStream buffer = new BufferedInputStream(new FileInputStream(file));
			ServletOutputStream out = response.getOutputStream();
			IOUtils.copy(buffer, out);
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("dlcard")
	public String dlCard(Model model, @RequestParam String DLapplicationNumber) {
		UserDL userDL = dlService.searchByDLAplication(DLapplicationNumber);
		if (userDL.getDLapplicationNumber().equals(DLapplicationNumber)) {
			System.out.println("running dlCard================");
			System.out.println(userDL);
			model.addAttribute("image", userDL.getFilename());
			System.out.println("=========================" + userDL.getFilename());
			model.addAttribute("userDL", userDL);
			return "DL-card";
		} else {
			model.addAttribute("invalid", "invalid DLapplication Number !!!! ");
			return "fileDownload";

		}
		// return "fileDownload";

	}

	@RequestMapping("pdf")
	public void pdfConvert(Document document, PdfWriter pdfWriter, Model model) throws FileNotFoundException {
		String path = "D://filesave//dlregister.pdf ";

		String paraText = "welcome to Garden City,IT hub ---Bengalurus";
		Paragraph paragraph = new Paragraph(paraText);

		pdfWriter = new PdfWriter(path);

		PdfDocument pdfDocument = new PdfDocument(pdfWriter);
		pdfDocument.addNewPage();

		document = new Document(pdfDocument);
		document.add(paragraph);
		model.addAttribute("pdfConvert", document.add(paragraph));
		document.close();

		System.out.println("hello");

		System.out.println("paragraph download successfully");

	}
}