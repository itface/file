
/**
 * 1、最初java是不支持对文本文件的处理的，为了弥补这个缺憾而引入了Reader和Writer两个类 
最初java是不支持对文本文件的处理的，为了弥补这个缺憾而引入了Reader和Writer两个类，这两个类都是抽象类，Writer中 write(char[] ch,int off,int
length)，flush()和close()方法为抽象方法，Reader中read(char[] ch,int off,int length)和close()方法是抽象方法。子类应该分别实现他们。
　　当我们读写文本文件的时候，采用Reader是非常方便的，比如FileReader，InputStreamReader和BufferedReader。其中最重要的类是InputStreamReader，
它是字节转换为字符的桥梁。
 * @author WangRongtao
 *
 */

public class FileUtil {

	public void newFile(String filename){
		File file = new File(filename);
		if(file.exists()){
			file.delete();
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.err);
			}
		}
	}
	
	public void randomAccessFile(String filename, String content) {
		try {
			RandomAccessFile arf = new RandomAccessFile(filename, "rw");
			arf.write(content.getBytes());
			arf.close();
			RandomAccessFile arf2 = new RandomAccessFile(filename, "r");
			arf2.seek(0);
			byte[] b = new byte[content.length() * 2];
			arf2.read(b);
			System.out.println(new String(b));
			arf2.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 只对字节
	 * @param filename
	 * @param content
	 */
	public void fileOutputStream(String filename,String content){
		File file = new File(filename);
		try {
			FileOutputStream os = new FileOutputStream(file);
			byte[] b= content.getBytes();
			os.write(b);
			os.flush();
			os.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 只对字节处理
	 * @param filename
	 */
	public void fileInputStream(String filename){
		File file = new File(filename);
		try {
			FileInputStream in = new FileInputStream(file);
			int length = in.available();
			byte[] b = new byte[length];
			in.read(b);
			in.close();
			System.out.println(new String(b));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 针对字符处理，双字节
	 * @param filename
	 * @param content
	 */
	public void fileWriter(String filename,String content){
		File file = new File(filename);
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(content);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 针对字符处理，双字节
	 * @param filename
	 */
	public void fileReader(String filename){
		File file = new File(filename);
		try {
			FileReader fr = new FileReader(file);
			char[] c = new char[1024];
			int length = fr.read(c);
			System.out.println(new String(c,0,length));
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bufferOutputStream(String filename){
		File file = new File(filename);
		try {
			FileOutputStream os = new FileOutputStream(file);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			DataOutputStream dos = new DataOutputStream(bos);
			dos.writeUTF("纠结abcdenfjdkaslf12321");
			dos.writeBytes("abcbytes");
			dos.writeChars("你好啊chars");
			dos.flush();
			dos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bufferInputStream(String filename){
		File file = new File(filename);
		try {
			FileInputStream is = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(is);
			DataInputStream dis = new DataInputStream(bis);
			System.out.println(dis.readUTF());
			byte[] c = new byte[1024];
			int length = dis.read(c);
			System.out.println(new String(c,0,length));
			dis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 将字节流解码成字符流,
	 * InputStreamReader构造方法：InputStreamReader(InputStream in)
	 * BufferedReader构造方法：BufferedReader(Reader reader)
	 */
	public void inputStreamReader(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String str = "";
			while((str=reader.readLine())!=null){
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 将写入的写符流解码成字节流
	 * OutputStreamWriter构造方法：OutputStreamWriter(OutputStream out)
	 * BufferedWriter构造方法：BufferedWriter(Writer writer)
	 */
	public void outputStreamWrite(){
		try {
			BufferedWriter write = new BufferedWriter(new OutputStreamWriter(System.out));
			String str = "";
			write.write("abc");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void bufferedReader(){
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ming.txt")));
		String data = null;
		while((data = br.readLine())!=null)
		{
		System.out.println(data); 
		}
	}
	public void bufferedWriter(){
		FileWriter fw = new FileWriter("hello.txt");  
		String s = "hello world";  
		fw.write(s,0,s.length());  
		fw.flush();  
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("hello2.txt"));  
		osw.write(s,0,s.length());  
		osw.flush();  
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("hello3.txt")),true);  
		pw.println(s);  
	}
}
