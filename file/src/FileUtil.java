
/**
 * 1�����java�ǲ�֧�ֶ��ı��ļ��Ĵ���ģ�Ϊ���ֲ����ȱ����������Reader��Writer������ 
���java�ǲ�֧�ֶ��ı��ļ��Ĵ���ģ�Ϊ���ֲ����ȱ����������Reader��Writer�����࣬�������඼�ǳ����࣬Writer�� write(char[] ch,int off,int
length)��flush()��close()����Ϊ���󷽷���Reader��read(char[] ch,int off,int length)��close()�����ǳ��󷽷�������Ӧ�÷ֱ�ʵ�����ǡ�
���������Ƕ�д�ı��ļ���ʱ�򣬲���Reader�Ƿǳ�����ģ�����FileReader��InputStreamReader��BufferedReader����������Ҫ������InputStreamReader��
�����ֽ�ת��Ϊ�ַ���������
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
	 * ֻ���ֽ�
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
	 * ֻ���ֽڴ���
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
	 * ����ַ�����˫�ֽ�
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
	 * ����ַ�����˫�ֽ�
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
			dos.writeUTF("����abcdenfjdkaslf12321");
			dos.writeBytes("abcbytes");
			dos.writeChars("��ð�chars");
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
	 * ���ֽ���������ַ���,
	 * InputStreamReader���췽����InputStreamReader(InputStream in)
	 * BufferedReader���췽����BufferedReader(Reader reader)
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
	 * ��д���д����������ֽ���
	 * OutputStreamWriter���췽����OutputStreamWriter(OutputStream out)
	 * BufferedWriter���췽����BufferedWriter(Writer writer)
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
