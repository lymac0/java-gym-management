package MyPackage;

import java.util.ArrayList;

public class Kursiyer implements Hesaplama{
	private int kursiyerId;
	private String kursiyerAdSoyad;
	private int kursiyerYas;
	private ArrayList<Kurs> alinanKurslar;

	public Kursiyer(int kursiyerId, String kursiyerAdSoyad, int kursiyerYas) {
		this.kursiyerId = kursiyerId;
		this.kursiyerAdSoyad = kursiyerAdSoyad;
		this.kursiyerYas = kursiyerYas;
		this.alinanKurslar = new ArrayList<>();
	}

	public int getKursiyerId() {
		return kursiyerId;
	}

	public void setKursiyerId(int kursiyerId) {
		this.kursiyerId = kursiyerId;
	}

	public String getKursiyerAdSoyad() {
		return kursiyerAdSoyad;
	}

	public void setKursiyerAdSoyad(String kursiyerAdSoyad) {
		this.kursiyerAdSoyad = kursiyerAdSoyad;
	}

	public int getKursiyerYas() {
		return kursiyerYas;
	}

	public void setKursiyerYas(int kursiyerYas) {
		this.kursiyerYas = kursiyerYas;
	}
	
	public ArrayList<Kurs> getAlinanKurslar() {
		return alinanKurslar;
	}

    public void kursEkle(Kurs kurs) {
    	if (kurs != null) {
            this.alinanKurslar.add(kurs);
        }
    }
    
	@Override
	public int BorcHesapla() {
        int alinanKursSayisi = getAlinanKurslar().size();
        int kursUcret = 2000;
        int borc;
        if(alinanKursSayisi == 1) {
        	return kursUcret;
        }
        if(alinanKursSayisi == 2) {
        	borc = (int) (kursUcret+(kursUcret*(0.8)));
        	return borc;
        }
        if(alinanKursSayisi == 3) {
        	borc = (int) (kursUcret+kursUcret+(kursUcret*(0.75)));
        	return borc;
        }
        if(alinanKursSayisi > 3) {
        	borc = (int) (kursUcret*alinanKursSayisi*(0.9));
        	return borc;        	
        }
		return 0;
       
	}
}
