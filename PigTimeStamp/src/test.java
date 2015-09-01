
public class test {

	public void main() {
	
	String timestamp = "2013-03-17 00:43:54";
	String date = timestamp.split(" ")[0];
	String time = timestamp.split(" ")[1];
	String ts = date.split("-")[0]+date.split("-")[1]+date.split("-")[2]
			+ time.split(":")[0] + time.split(":")[1] + time.split(":")[2];
	int TimeStamp = Integer.parseInt(ts);
	System.out.println(TimeStamp);
	}
	
}
