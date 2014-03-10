import java.util.Vector;


public class ReturnList {
	Vector<Integer> idList;
	
	public ReturnList() {
		idList = new Vector<Integer>();
	}
	
	public int size() {
		return idList.size();
	}
	
	public int getReturnDVDId(int index) {
		return idList.get(index);
	}
	
	public void addReturnDVD(int DVDId) {
		idList.add(DVDId);
	}
}
