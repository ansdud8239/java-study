package prob2;

public class SmartPhone extends MusicPhone {

	public void execute ( String function ) {
	      if (function.equals("앱") ) {
	    	  app();
	          return;
	      }
	      
	      super.execute( function );
	}

	@Override
	protected void playMusic() {
		System.out.println("다운로드해서 음악재생");
	}
	private void app(){
		System.out.println( "앱실행" );
	}

}
