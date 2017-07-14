package home.starks;

public class SalesRep {
	String email;
	String salesRep;
	String salesRole;
	
	public void set(int point, String value){
		switch (point) {
		case 0: email = value;break;
		case 1: salesRep = value;break;
		case 2: salesRole = value;break;
		}
	}	
	public String get(int point){
		String results = null;
		switch (point) {
		case 0: results = email; break;
		case 1: results = salesRep; break;
		case 2: results = salesRole; break;
		}
	return(results);
	}
	

}
