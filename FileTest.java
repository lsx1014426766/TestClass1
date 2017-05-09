import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.io.FileUtils;


public class FileTest {
	/**小结：
	 * File file = getFile(path,filename);
	 * 此file对象可转为多种形式: 只是换了一种身份
	 *  Path path = file.toPath();//framework\images\webapp\images\album-images\datas\888\ddd\datas.json
	 *  String s=file.toString();
	 *  URI uri=file.toUri();
	 *  
	 *  重命名，该操作=重命名+移动，原来位置的文件会消失，只保留了目的地的一份
	 *  如果想同时保留，需要执行此操作时使用temp（临时复制的一份）文件
	 *  问题：如果目的地已经存在同名文件，则此操作不被执行
	 *  file.renameTo(new File("d:\\aa.txt"));
	 *  
	 *  文件的写操作：参数一：Path对象（目的地），参数二：源数据的byte[]对象
	 *  Files.write(file3.toPath(), Files.readAllBytes(file.toPath()));
	 *  
	 *  删除包
	 *  1 org.apache.commons.io.FileUtils.deleteDirectory(file2);
	 *  自己写的
	 *  2 com.alc.common.util.FileUtils.deleteDirectory(folder);
	 */
	//指定路径，指定文件的创建
	//示例：File file3 = getFile("framework/images/webapp/images/album-images/datas/888/ddd/","datas.json");
	public static File getFile(String path, String filename) throws IOException {
		File directory = new File(path);
		File confile = null;
		if (!directory.exists()) {
			if (directory.mkdirs()) {//若多级目录不存在，调用mkdirs,则会一次创建多级目录
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
    public static String  readByBufR(File file) throws IOException{
    	BufferedReader bReader = new BufferedReader(new FileReader(file));
    	StringBuffer sb= new StringBuffer("");
    	String str = null; 
        while((str=bReader.readLine())!=null){
        	sb.append(str);
        }
        bReader.close();
        return sb+"";
    }
    //2种读操作
    public static String readByFis(File file) throws IOException{
   	 FileInputStream in = new FileInputStream(file);
        int available = in.available();
        byte[] cbuf=new byte[available];
        in.read(cbuf, 0, available);
        String result=new String(cbuf);
        in.close();
       return result;
   }
    public static void main(String[] args) throws IOException {
    	String prefix="framework"+File.separator+"images"+File.separator+"webapp"+File.separator+"images"+File.separator+"album-images"+File.separator+"datas";
    	String folder=prefix+File.separator+111+File.separator+222+File.separator;
    	File file = getFile(folder,"a.txt");
    	System.out.println(file.getAbsolutePath());
    	File file2=new File(folder);
    	System.out.println(file2.getAbsolutePath());//E:\eclipseSpace\\ultimate-E-commerce0720\framework\images\webapp\images\album-images\datas\111\222
    	System.out.println(file2.getParent());//framework\images\webapp\images\album-images\datas\111
    	System.out.println(file2.getPath());//framework\images\webapp\images\album-images\datas\111\222
    	File file3 = file2.getParentFile();
    	//文件夹下有文件，会删除失败，必须先把下面的内容删除，才可以删除
    	System.out.println(file3.delete());//false
    	//boolean b = com.alc.common.util.FileUtils.deleteDirectory(folder);
    	//System.out.println(b);
    	FileUtils.deleteDirectory(file2);
    	
    	
    	
    }
}
