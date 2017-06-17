import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

public class loop {

	public static void main(String[] args) throws IOException, ExecutionException {
		metadata m = new metadata("never","named","this");
		metadata newm = new metadata();
		boolean samename;
		while(true) {
			try {
				ExecutorService executor = Executors.newSingleThreadExecutor();
		        Future<metadata> future = executor.submit(new scrape());
		        try {
		            future.get(15, TimeUnit.SECONDS);
		            newm = future.get();
		            samename=m.compare(newm);
		        } catch (TimeoutException e) {
		            future.cancel(true);
		            samename=true;
		        }
				if (samename == false) {
					m = newm;
					changestuff(m);
				}
				TimeUnit.SECONDS.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void changestuff(final metadata m) {
		new Thread("rt") {
			public void run() {
				String fmdisplay = fmname.getName(m);
				try {
					telenet.send(fmdisplay, "rt");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					telenet.send(fmdisplay, "ps");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
		new Thread("web") {
			public void run() {
				try {
					tcp.send(m);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
class scrape implements Callable<metadata>{
	@Override
    public metadata call() throws Exception {
		return webscraper.getname();
    }
}