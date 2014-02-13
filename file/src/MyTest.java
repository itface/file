import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;





/**
 * @author WangRongtao
 *
 */
/**
 * @author WangRongtao
 *
 */
public class MyTest {

	public final static void main(String[] args){
		FileUtil util = new FileUtil();
		String file = "c:\\≤‚ ‘.doc";
		util.newFile(file);
		util.bufferOutputStream(file);
		util.bufferInputStream(file);
	}
}
