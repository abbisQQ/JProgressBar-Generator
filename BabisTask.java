public class BabisTask implements Runnable{

	@Override
	public void run() {
		System.out.println("Started");
		int i=0;
		while(i<9999) {
      //what a lame task indeed
			i++;
		}
		TaskProgressBar.TaskDone=true;
		System.out.println(TaskProgressBar.TaskDone);
		
	}

}
