package com.alc.common.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.ofbiz.base.util.FileUtil;
import org.ofbiz.base.util.UtilGenerics;

public class FileUtils {
	/**
	 * 创建文件和文件夹
	 * @param path
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static File getFile(String path, String filename) throws IOException {
		File directory = new File(path);
		File confile = null;
		if (!directory.exists()) {
			if (directory.mkdirs()) {
				confile = new File(directory, filename);
				confile.createNewFile();
			}
		} else {
			confile = new File(directory, filename);
			if (!confile.exists()) {
				confile.createNewFile();

			}
		}
		return confile;
	}
	/**
	 * 上传图片
	 * @param request
	 * @param uploadPah
	 * @param filename
	 * @return
	 */
	public static String addImage(HttpServletRequest request, String uploadPah,
			String filename) {
		File dir = FileUtil.getFile(uploadPah);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		List<FileItem> lst = null;
		ServletFileUpload dfu = new ServletFileUpload(new DiskFileItemFactory(
				10240, dir));
		try {
			lst = UtilGenerics.checkList(dfu.parseRequest(request));
		} catch (FileUploadException e4) {
			return "error";
		}
		FileItem fi = null;
		//String fileName = "";
		for (int i = 0; i < lst.size(); i++) {
			fi = lst.get(i);
			try {
				fi.write(new File(dir, filename));
				fi.delete();
			} catch (Exception e) {
				return "error";
			}
		}
		return "success";
	}
	public static boolean deleteFile(String sPath) {  
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}  
    /** 
     * 删除目录（文件夹）以及目录下的文件 
     * @param   sPath 被删除目录的文件路径 
     * @return  目录删除成功返回true，否则返回false 
     */  
    public static boolean deleteDirectory(String sPath) {  
        //如果sPath不以文件分隔符结尾，自动添加文件分隔符  
        if (!sPath.endsWith(File.separator)) {  
            sPath = sPath + File.separator;  
        }  
        File dirFile = new File(sPath);  
        //如果dir对应的文件不存在，或者不是一个目录，则退出  
        if (!dirFile.exists() || !dirFile.isDirectory()) {  
            return false;  
        }  
        Boolean flag = true;  
        //删除文件夹下的所有文件(包括子目录)  
        File[] files = dirFile.listFiles();  
        for (int i = 0; i < files.length; i++) {  
            //删除子文件  
            if (files[i].isFile()) {  
                flag = deleteFile(files[i].getAbsolutePath());  
                if (!flag) break;  
            } //删除子目录  
            else {  
                flag = deleteDirectory(files[i].getAbsolutePath());  
                if (!flag) break;  
            }  
        }  
        if (!flag) return false;  
        //删除当前目录  
        if (dirFile.delete()) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
}