package odev3;
import java.util.Scanner;

public class odev3 {
	
	//private static Scanner clavier =new Scanner(System.in);
	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		 String[] konular = { "güvenlik ","Siyasi ", "Sağlık Hizmetleri", "Eğitim", "Ekonomi"};
	        
	       
	        int[][] puanlar = new int[5][10];
	        
	       
	        String baskaKullanici;
	        do {
	            System.out.println("Aşağıdaki konuları 1 (en az önemli) ile 10 (en önemli) arasında puanlayın:");
	            for (int i = 0; i < konular.length; i++) {
	                System.out.print(konular[i] + " sorunlar: ");
	                int puan = scanner.nextInt();
	                
	                
	                if (puan >= 1 && puan <= 10) {
	                    puanlar[i][puan - 1]++;
	                } else {
	                    System.out.println("Geçersiz puan. Lütfen 1 ile 10 arasında bir sayı girin.");
	                    i--; 
	                }
	            }
	            System.out.print("Başka bir kullanıcı oylama yapmak ister mi? (evetse evet yazıp devam edin yoksa hayır yazın): ");
	            baskaKullanici = scanner.next();
	        } while (baskaKullanici.equalsIgnoreCase("evet"));
	        
	        
	        System.out.printf("%-20s", "Konu");
	        for (int i = 1; i <= 10; i++) {
	            System.out.printf("%4d", i);
	        }
	        System.out.println("   Ort");

	        int enYuksekPuan = 0;
	        int enDusukPuan = Integer.MAX_VALUE;
	        String enYuksekKonu = "";
	        String enDusukKonu = "";

	        for (int i = 0; i < konular.length; i++) {
	            System.out.printf("%-20s", konular[i]);
	            int toplam = 0;
	            int sayac = 0;
	            for (int j = 0; j < 10; j++) {
	                System.out.printf("%4d", puanlar[i][j]);
	                toplam += puanlar[i][j] * (j + 1);
	                sayac += puanlar[i][j];
	            }
	            
	            double ortalama = (sayac == 0) ? 0 : (double) toplam / sayac;
	           System.out.printf("%7.2f%n", ortalama);
	            
	            
	            if (toplam > enYuksekPuan) {
	                enYuksekPuan = toplam;
	                enYuksekKonu = konular[i];
	            }
	            if (toplam < enDusukPuan) {
	                enDusukPuan = toplam;
	                enDusukKonu = konular[i];
	            }
	        }

	        System.out.println("\nToplamda en yüksek puanı alan konu: " + enYuksekKonu + " (" + enYuksekPuan + ")");
	        System.out.println("Toplamda en düşük puanı alan konu: " + enDusukKonu + " (" + enDusukPuan + ")");
	        
	        scanner.close();
	    }
		
	
}
	