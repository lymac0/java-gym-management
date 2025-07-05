# 🏋️ Spor Merkezi Otomasyonu – Java Console App

Bu proje, Java programlama dili ile geliştirilen bir **spor merkezi yönetim otomasyonudur**. Kursiyerler, kurslar ve ödemeler gibi temel operasyonları metin tabanlı menü üzerinden yönetmenizi sağlar. Dosya tabanlı veri saklama mantığı kullanılarak kalıcı veri işlemleri gerçekleştirilir.

---

## ✨ Özellikler

- 📂 **Dosya Tabanlı Veri Yönetimi**  
  `kursiyer.txt` ve `kurs.txt` üzerinden veri okuma/yazma

- 👥 **Kursiyer Yönetimi**  
  Kursiyer ekle/sil/ara/listele/ayrıntılı görüntüle

- 🏆 **Kurs Yönetimi**  
  Kurs ekle/sil/ara/listele

- 💳 **Ücret Hesaplama**  
  Kurs sayısına göre kampanyalı borç hesaplama  
  (2. kurs %20, 3. kurs %25, 3+ kurs %10 indirim)

- 🧱 **Nesne Yönelimli Yapı (OOP)**  
  - Kapsülleme (Encapsulation)  
  - Arayüz (Interface)  
  - ArrayList ile dinamik veri yönetimi  
  - Sınıf ayrımı: `Kursiyer`, `Kurs`, `Hesaplama`, `Anasayfa`

---

## 🧾 Kullanım

1. `kurs.txt` ve `kursiyer.txt` dosyalarını proje dizinine ekleyin.  
2. `Anasayfa.java` içindeki `main` metodunu çalıştırın.  
3. Açılan menüden işlemlerinizi gerçekleştirin.

### Örnek Menü:

1 – Kurs Ekle
2 – Kurs Listele
3 – Kurs Ara
...
10 – Kursiyerin Ödeyeceği Tutarı Hesapla
11 – Çıkış


---

## 📁 Sınıf Yapısı

| Sınıf          | Açıklama |
|----------------|----------|
| `Kurs.java`        | Kurs bilgileri (ID ve ad) |
| `Kursiyer.java`    | Kursiyer bilgileri ve aldığı kurslar |
| `Hesaplama.java`   | Arayüz – `BorcHesapla()` metodu |
| `Anasayfa.java`    | Ana kontrol yapısı ve menü sistemi |

---

## 🔧 Gereksinimler

- Java 11+
- Komut satırı veya IDE (NetBeans, IntelliJ, Eclipse vs.)

---

## 💡 Öğrenilenler

- Java'da dosya işlemleri (File I/O)  
- ArrayList ile nesne yönetimi  
- Sınıf yapıları ve arayüz kullanımı  
- Kullanıcı etkileşimli menü tasarımı  
- Nesne yönelimli programlama ilkeleri

---

## 📌 Not

Bu proje, [Nesneye Yönelik Programlama (NYP)] dersi kapsamında geliştirilmiştir.  
Özgünlük ve anlaşılabilirlik ön planda tutulmuştur.

---
