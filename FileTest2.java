import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import org.ofbiz.base.util.FileUtil;
public class FileTest2 {
	public static void main(String[] args) throws IOException {
		//File file = new File("hot-deploy\\alc\\data\\alcfile");
		String filename="alc2.json";
		String path="hot-deploy\\alc\\data\\alcfile";
		File file = getFile(path,filename);
		File file3 = getFile("framework/images/webapp/images/album-images/datas/888/ddd/","datas.json");
		System.out.println(file3.toPath());//framework\images\webapp\images\album-images\datas\888\ddd\datas.json
		Files.write(file3.toPath(), Files.readAllBytes(file.toPath()));
		System.out.println(file);
		System.out.println("*******");
		file3.renameTo(new File("d:\\aaa12345.json"));
	//	Album album = new Album("XM","测试专辑","方大同","c://abum.jpg");
       // JSONObject json = JSONObject.fromObject(album);
        //将获取到的json数据存入指定的文件中
       // JSON json = org.ofbiz.base.lang.JSON.from(album);
       /* FileOutputStream out=new FileOutputStream(file);
        out.write(json.toString().getBytes());*/
        //out.close();
        //解析读取json数据
        System.out.println(readByBufferedReader(file));
        System.out.println(readByFileInputStream(file));
        String uploadPah="framework/images/webapp/images/album-images/albums/";
        //File dir = new File(uploadPah);
		
        File dir2 = FileUtil.getFile(uploadPah);
        if(!dir2.exists()){
			dir2.mkdirs();
		}
        System.out.println(dir2.getAbsolutePath());
        uploadPah="images/aaa/ccc";
        File file2 = FileUtil.getFile(uploadPah);
        if(!file2.exists()){
        	file2.mkdirs();
		}
        //dddd:E:\eclipseSpace\\ultimate-E-commerce0720/\images/\aaa/\ccc
        System.out.println("dddd:"+file2.getAbsolutePath());
	}
    public static String  readByBufferedReader(File file) throws IOException{
    	BufferedReader bReader = new BufferedReader(new FileReader(file));
    	StringBuffer sb= new StringBuffer("");
    	String str = null; 
        while((str=bReader.readLine())!=null){
        	sb.append(str);
        }
        bReader.close();
        return sb+"";
    }
    public static String readByFileInputStream(File file) throws IOException{
   	 FileInputStream in = new FileInputStream(file);
        int available = in.available();
        byte[] cbuf=new byte[available];
        in.read(cbuf, 0, available);
        String result=new String(cbuf);
        in.close();
       return result;
   }
	public static File getFile(String path, String filename) throws IOException {
		File directory = new File(path);
		File confile = null;
		if (!directory.exists()) {
			//创建多级folder
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
}
