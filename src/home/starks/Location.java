package home.starks;

public class Location {
	String country;
	String region;
	
	public void set(int point, String value){
		switch (point) {
		case 0: country = value;break;
		case 1: region = value;break;
		}
	}	
	
	public String get(int point){
		String results = null;
		switch (point) {
		case 0: results = country; break;
		case 1: results = region; break;
		}
	return(results);
	}
	

}

