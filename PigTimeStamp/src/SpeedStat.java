import java.io.IOException;
import java.util.*;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.DataBag;
import org.apache.pig.data.Tuple;



public class SpeedStat extends EvalFunc<String> {
	@Override
	public String exec(Tuple input) throws IOException {
		long mean = (long)input.get(0);
		int meanspeed = (int)mean;
		int count45 = 0;
		int countavg15 = 0;
		int countavg20 = 0;
		int countavg25 = 0;
		int countavg30 = 0;
		int countavg35 = 0;
		
		Object values = input.get(1);
		if (values instanceof DataBag) {
									
				Iterator<Tuple> it = ((DataBag) values).iterator();
				
				while (it.hasNext()) {
					// tuple: ticker,date,open
					Tuple t = it.next();
					// get the date and price of that tuple
					int speed = (int)t.get(2);
									
					if (speed<=45)
					{
						count45++;
					}
					if (speed<=meanspeed-15)
					{
						countavg15++;
					}
					if (speed<=meanspeed-20)
					{
						countavg20++;
					}
					if (speed<=meanspeed-25)
					{
						countavg25++;
					}
					if (speed<=meanspeed-30)
					{
						countavg30++;
					}
					if (speed<=meanspeed-35)
					{
						countavg35++;
					}
					
				}
				
				String speedstat = Integer.toString(meanspeed)+"	"+Integer.toString(count45)+"	"
				+Integer.toString(countavg15)+"	"+Integer.toString(countavg20)
						+"	"+Integer.toString(countavg25)+"	"+Integer.toString(countavg30)
						+"	"+Integer.toString(countavg35);
					
				return speedstat;
			
		}
		
		return null;
	}
	}
