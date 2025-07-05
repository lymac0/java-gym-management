package MyPackage;

import java.util.Objects;

public class Kurs {
	private int kursId;
	private String kursAd;
	
	public Kurs(int kursId, String kursAd) {
		this.kursId = kursId;
		this.kursAd = kursAd;
	}
	
	public int getKursId() {
		return kursId;
	}

	public String getKursAd() {
		return kursAd;
	}
	public String toString() {
		return kursId +" "+kursAd+"\n";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Kurs other = (Kurs) obj;
		return Objects.equals(getKursAd().toLowerCase(), other.getKursAd().toLowerCase());
	    }
	 @Override
	 public int hashCode() {
		 return Objects.hash(getKursAd().toLowerCase());
	 }     
}
