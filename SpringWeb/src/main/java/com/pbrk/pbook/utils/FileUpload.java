package com.pbrk.pbook.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.http.Part;

public class FileUpload {	
	
	public StringBuilder FileInsert(Collection<Part> parts, String realPath) throws IOException {
		
		StringBuilder builder = new StringBuilder();
		
		for(Part p : parts) {
			if(!p.getName().equals("file")) continue;
			if(p.getSize() == 0) continue;
			
//			Part filePart = request.getPart("file");
			Part filePart = p;
			String fileName = filePart.getSubmittedFileName();
			builder.append(fileName);
			builder.append(",");
						
			InputStream fis = filePart.getInputStream();
			
			//String realPath = request.getServletContext().getRealPath("/upload");
			//System.out.println(realPath);
			
			File path = new File(realPath);
			if(!path.exists())
				path.mkdir();
			
			// mkdir : getRealPath("/upload")
			// mkdirs : getRealPath("/member/upload"); 부모 경로까지 만들어줌			

			String filePath = realPath + File.separator + fileName;
			FileOutputStream fos = new FileOutputStream(filePath);
			
			byte[] buf = new byte[1024];
			int size = 0;
			while((size = fis.read(buf)) != -1) {
				fos.write(buf, 0, size);
			}

			fos.close();
			fis.close();
		}
		
		if(builder.length() != 0)
			builder.delete(builder.length()-1, builder.length());
		
		
		return builder;
	}
}

