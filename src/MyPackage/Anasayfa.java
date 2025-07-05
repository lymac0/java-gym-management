package MyPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Anasayfa {
    static Scanner scan = new Scanner(System.in);
    
	public static void main(String[] args) throws IOException {
		ArrayList<Kurs> Kurslar = new ArrayList<Kurs>();
		File my_file = new File("kurs.txt");
		if(my_file.exists()!=true)
		{
			System.out.println("Kurs dosyası bulunamadı...");
		}

		FileReader fr = new FileReader(my_file);
		BufferedReader br = new BufferedReader(fr);
		

		String okunan;
		String[] okunandizi;
 	
		while((okunan = br.readLine()) != null){
			okunandizi = okunan.split("\\+");
			Kurslar.add(new Kurs(Integer.parseInt(okunandizi[0]),okunandizi[1]));	
		}
		br.close();
		
		ArrayList<Kursiyer> Kursiyerler = new ArrayList<>();
		File my_file2 = new File("kursiyer.txt");
		
        try (BufferedReader br2 = new BufferedReader(new FileReader(my_file2))) {
            String satir;
            Kursiyer kursiyer = null;
            while ((satir = br2.readLine()) != null) {
                if (satir.startsWith("*")) {
                    String[] kursiyerBilgileri = satir.substring(1).split("\\+");
                    int kursiyerId = Integer.parseInt(kursiyerBilgileri[0]);
                    String kursiyerAdSoyad = kursiyerBilgileri[1];
                    int kursiyerYas = Integer.parseInt(kursiyerBilgileri[2]);

                    kursiyer = new Kursiyer(kursiyerId, kursiyerAdSoyad, kursiyerYas);
                    Kursiyerler.add(kursiyer);
                } else if (satir.startsWith("%") && kursiyer != null) {
                    String[] kursBilgileri = satir.substring(1).split("\\+");
                    int kursId = Integer.parseInt(kursBilgileri[0]);
                    String kursAd = kursBilgileri[1];
                    Kurs kurs = new Kurs(kursId, kursAd);
                    kursiyer.kursEkle(kurs);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	    boolean kontrol = true;
	    
	    while(kontrol)
	    {
	    	 try {
		    	System.out.println("1- Kurs Ekle\n"
						+ "2- Kurs Listele\n"
						+ "3- Kurs Ara\n"
						+ "4- Kurs Sil\n"
						+ "5- Kursiyer Ekle\n"
						+ "6- Kursiyer Ara\n"
						+ "7- Kursiyer Sil\n"
						+ "8- Kursiyer Listele\n"
						+ "9- Kursiyerleri Ayrıntılı Listele\n"
						+ "10- Kursiyerin Ödeyeceği Tutarı Hesapla\n"
						+ "11- Çıkış");
		    	int secim = scan.nextInt();
				scan.nextLine();
				switch(secim) {
				case 1:
					KursEkle(Kurslar);
					break;
				case 2:
					KursListele(Kurslar);
					break;
				case 3:
					KursAra(Kurslar);
					break;
				case 4:
					KursSil(Kurslar,Kursiyerler);
					break;
				case 5:
					KursiyerEkle(Kurslar, Kursiyerler);
					break;
				case 6:
					KursiyerAra(Kursiyerler);
					break;
				case 7:
					KursiyerSil(Kursiyerler);
					break;
				case 8:
					KursiyerListele(Kursiyerler);
					break;
				case 9:
					KursiyerAyrintiliListele(Kursiyerler);
					break;
				case 10:
					KursiyerListele(Kursiyerler);
					System.out.print("Borcunu öğrenmek istediğiniz kursiyerin ID'sini giriniz:");
					int kursiyerId = scan.nextInt();
					KursiyerinOdeyecegiTutarHesapla(Kursiyerler,kursiyerId);
					break;
				case 11:
					Cikis(Kursiyerler, Kurslar);
					kontrol = false;
					break;
				default:
					System.out.println("Hatalı tuşlama...");
					break;
				}
	    	 }
				 catch (InputMismatchException e) {
	                System.out.println("Hatalı giriş! Lütfen bir sayı giriniz.");
	                scan.nextLine();
				 }	
	    }
	}
		
	private static void KursEkle(ArrayList<Kurs> Kurslar) {
		System.out.println("Eklemek istediğiniz kurs bilgileri:");
		System.out.print("ID:");
		int KursID = scan.nextInt();
		scan.nextLine();
		
		boolean idVarMi = false;
		for(Kurs k:Kurslar) {
			if(k.getKursId() == KursID) {
				idVarMi = true;
				break;				
			}
		}
		if(idVarMi) {
	        System.out.println("Hata: Bu ID ile zaten bir kurs kaydı bulunmakta...");
		}
		else {
		System.out.print("Ad:");
		String KursAd = scan.nextLine();
		Kurslar.add(new Kurs(KursID, KursAd));
        System.out.println("Kurs başarıyla eklendi.");
		}
	}
	private static void KursListele(ArrayList<Kurs> Kurslar) {
		System.out.println("Kurs Id   Kurs Adı");
		for(Kurs k:Kurslar) {
			System.out.println(k.getKursId()+"      "+k.getKursAd());
		}
	}
	private static void KursAra(ArrayList<Kurs> Kurslar) {
		System.out.println("Aranacak kursun adı: ");
		boolean kursVarMi = false;
		String KursAd = scan.nextLine();
		for(Kurs k:Kurslar) {
			if(KursAd.toLowerCase().equals(k.getKursAd().toLowerCase())) {
				kursVarMi = true;
				System.out.println("---Kurs Bulundu---");
				System.out.println("Kurs Adı: "+k.getKursAd()+"\nKurs ID: "+k.getKursId());
			}
		}
		if(kursVarMi==false) {
			 System.out.println("Kurs bulunamadı...");
		}
	}
	private static void KursSil(ArrayList<Kurs> Kurslar, ArrayList<Kursiyer> Kursiyerler) {
	    KursListele(Kurslar);
	    System.out.println("Silinecek kursun adı: ");
	    String KursAd = scan.nextLine();
	    boolean kursAl = false;
	    boolean kursBulundu = false;

	    Iterator<Kurs> iterator = Kurslar.iterator();
	    while (iterator.hasNext()) {
	        Kurs k = iterator.next();
	        if (KursAd.toLowerCase().equals(k.getKursAd().toLowerCase())) {
	            kursBulundu = true;
	            List<String> kursiyerBilgileri = new ArrayList<>();

	            for (Kursiyer ks : Kursiyerler) {
	                if (ks.getAlinanKurslar().contains(k)) {
	                    kursAl = true;
	                    kursiyerBilgileri.add(ks.getKursiyerId()+" "+ks.getKursiyerAdSoyad() + " " + ks.getKursiyerYas());
	                }
	            }
	            if (kursAl) {
	                System.out.println("Silmek istenilen kurs alınıyor. Kursu alan kursiyerler: ");
	                for (String bilgi : kursiyerBilgileri) {
	                    System.out.println(bilgi);
	                }
	                System.out.println("Silmek istenilen kurs alındığından dolayı silme işlemi gerçekleştirilemedi.");
	            } else {
	                iterator.remove();
	                System.out.println("Kurs başarıyla silindi...");
	            }
	        }
	    }
	    if (!kursBulundu) {
	        System.out.println("Belirtilen isimde bir kurs bulunamadı. Lütfen doğru bir kurs adı girin.");
	    }
	}
	private static void KursiyerEkle(ArrayList<Kurs> Kurslar, ArrayList<Kursiyer> Kursiyerler) {
		System.out.println("--Eklenecek Kursiyerin Bilgileri--");
		System.out.print("ID: ");
		int ID = scan.nextInt();
		scan.nextLine();
	    boolean idVarMi = Kursiyerler.stream().anyMatch(k -> k.getKursiyerId() == ID);
		if(idVarMi) {
	        System.out.println("Hata: Bu ID ile zaten bir kursiyer kaydı bulunmakta...");
		}
		else {
			System.out.print("Ad Soyad:");
	        String AdSoyad = scan.nextLine();
	        System.out.print("Yaş:");
	        int Yas = scan.nextInt();
	        scan.nextLine();
	        Kursiyer kursiyer = new Kursiyer(ID, AdSoyad, Yas);
	        KursListele(Kurslar);
	        System.out.println("Kursiyerin aldığı kurslar:");
	        boolean kursEkle = true;
	        while (kursEkle) {
	            System.out.print("Eklemek istediğiniz kursun ismini girin (boş satır toplamayı bitirir): ");
	            String kursAD = scan.nextLine();

	            if (kursAD.isEmpty()) {
	                kursEkle = false;
	            } else {
	                Kurs eklenecekKurs = Kurslar.stream().filter(k -> k.getKursAd().equalsIgnoreCase(kursAD)).findFirst().orElse(null);
	                if (eklenecekKurs != null) {
	                    kursiyer.kursEkle(eklenecekKurs);
	                    System.out.println("Kurs başarıyla eklendi.");
	                } else {
	                    System.out.println("Hata: Belirtilen isimde bir kurs bulunamadı.");
	                }
	            }
	        }
	        Kursiyerler.add(kursiyer);
	        System.out.println("Kursiyer başarıyla eklendi.");
		}
	}
	private static void KursiyerAra(ArrayList<Kursiyer> Kursiyerler) {
		System.out.println("Aranacak kursiyerin ad-soyadını girin:");
	    String arananAdSoyad = scan.nextLine();
	    
	    Kursiyer bulunanKursiyer = Kursiyerler.stream()
	            .filter(k -> k.getKursiyerAdSoyad().equalsIgnoreCase(arananAdSoyad))
	            .findFirst()
	            .orElse(null);

	    if (bulunanKursiyer != null) {
	        System.out.println("---Kursiyer Bulundu---");
	        System.out.println("Kursiyer ID: " + bulunanKursiyer.getKursiyerId());
	        System.out.println("Ad Soyad: " + bulunanKursiyer.getKursiyerAdSoyad());
	        System.out.println("Yaş: " + bulunanKursiyer.getKursiyerYas());
	        System.out.println("Aldığı Kurslar: ");
	        for(int i=0;i<bulunanKursiyer.getAlinanKurslar().size();i++) {
		        System.out.println(bulunanKursiyer.getAlinanKurslar().get(i).getKursId()+" "+bulunanKursiyer.getAlinanKurslar().get(i).getKursAd());
	        }
	    } else {
	        System.out.println("Kursiyer bulunamadı...");
	    }
	}
	private static void KursiyerSil(ArrayList<Kursiyer> Kursiyerler) {
		KursiyerListele(Kursiyerler);
		System.out.println("Silinmek istenen kursiyer ID'si");
		int ID = scan.nextInt();

	    Kursiyer kursiyer = Kursiyerler.stream()
	            .filter(k -> k.getKursiyerId() == ID)
	            .findFirst()
	            .orElse(null);
	    if (kursiyer != null) {
	        Kursiyerler.remove(kursiyer);
	        System.out.println("Kursiyer başarıyla silindi.");
	    } else {
	        System.out.println("Belirtilen ID ile kursiyer bulunamadı...");
	    }
	    scan.nextLine();
	}
	private static void KursiyerListele(ArrayList<Kursiyer> Kursiyerler) {
		System.out.println("Tüm Kursiyerler");
	    for (Kursiyer kyer : Kursiyerler) {
	        System.out.println(kyer.getKursiyerId()+" "+kyer.getKursiyerAdSoyad()+" "+kyer.getKursiyerYas());
	    }
	}
	private static void KursiyerAyrintiliListele(ArrayList<Kursiyer> Kursiyerler) {
		System.out.println("Tüm Kursiyerler ve Aldıkları Kurslar");
	    for (Kursiyer kyer : Kursiyerler) {
	        System.out.println(kyer.getKursiyerId()+" "+kyer.getKursiyerAdSoyad()+" "+kyer.getKursiyerYas());
	        for(int i=0;i<kyer.getAlinanKurslar().size();i++) {
		        System.out.println("   "+kyer.getAlinanKurslar().get(i).getKursId()+" "+kyer.getAlinanKurslar().get(i).getKursAd());
	        }
	    }
	}
	private static void KursiyerinOdeyecegiTutarHesapla(ArrayList<Kursiyer> Kursiyerler,int kursiyerId) {
		Kursiyer kursiyer = Kursiyerler.stream()
	            .filter(k -> k.getKursiyerId() == kursiyerId)
	            .findFirst()
	            .orElse(null);
		int alinanKursSayisi = kursiyer.getAlinanKurslar().size();
       
		System.out.println("Aylık ödenecek toplam tutar: "+ kursiyer.BorcHesapla());
		System.out.println("Uygulanan Kampanya: ");
		switch(alinanKursSayisi) {
		case 0:
			
		case 1:
			System.out.println("Yok");
			break;
		case 2:
			System.out.println("Kampanya 1: Bu kampanya 2 kurs alan kursiyerler içindir.\nBu kursiyerlere ikinci kurs %20 indirimlidir.");
			break;
		case 3:
			System.out.println("Kampanya 2: Bu kampanya 3 kurs alan kursiyerler içindir.\nBu kursiyerlere 3. kurs %25 indirimlidir.");
			break;
		default:
			System.out.println("Kampanya 3: Bu kampanya 3 kurs üstü alan kursiyerler içindir.\nBu kursiyerlere her kurs %10 indirimlidir.");
			break;
		}
	}
	private static void Cikis(ArrayList<Kursiyer> Kursiyerler, ArrayList<Kurs> Kurslar) {
		File my_file2 = new File("kursiyer.txt");
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(my_file2))) {
	        for (Kursiyer kursiyer : Kursiyerler) {
	            writer.write("*" + kursiyer.getKursiyerId() + "+" + kursiyer.getKursiyerAdSoyad() + "+" + kursiyer.getKursiyerYas());
	            writer.newLine();

	            for (Kurs alinanKurs : kursiyer.getAlinanKurslar()) {
	                writer.write("%" + alinanKurs.getKursId() + "+" + alinanKurs.getKursAd());
	                writer.newLine();
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    File my_file = new File("kurs.txt");
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(my_file))) {
	        for (Kurs kurs : Kurslar) {
	            writer.write(kurs.getKursId() + "+" + kurs.getKursAd());
	            writer.newLine();
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    System.out.println("Çıkış işlemi tamamlandı. Dosyalara yazıldı.");
	}

}
