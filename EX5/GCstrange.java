
import java.util.LinkedList;
import java.util.List;

public class GCstrange {

    static List<GCstrange> dump = new LinkedList<>();    
    static final int COUNT = 1000000;
	static int gcCalls = 0;

    public static void main(String [] args) throws InterruptedException{

		GCstrange tmp = null;
		int oldSize = dump.size();

		for (int i = 1; i < COUNT; i++){
			
			if (oldSize != dump.size())
				gcCalls += 1; 
			
			tmp = new GCstrange();
		}

		System.out.println("The GC has been called: " + gcCalls + " times.");
	}

    public GCstrange(){
    }

    protected void finalize(){
		dump.add(this);
    }
}
    