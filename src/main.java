
public class main {
	
	//A CEVAP
	public static String reverseWord(String word) { //kelimeyi tersine çevirmek için fonksiyon
		String tempWord = "";
		for(int i = word.length()-1; i >= 0 ; i--) { //karakterleri tersten yazdýrma
			tempWord += word.charAt(i);
		}
		return tempWord;
	}
	
	
	//B CEVAP
	public static String reverseaA(String word) {
		String tempWord = "";
		int aFind = 0;
		for(int i = 0; i < word.length(); i++) {
			
			if(word.charAt(i) == 'a' && i != 0) { // ilk harf her zaman ayný olduðundan atlanýr.
				aFind++; // a bulundu
				if(aFind == 2) { // 2 ci A bulunduysa harfi büyültme.
					tempWord += Character.toUpperCase(word.charAt(i));					
					aFind = 0; //tekrardan A larýn sayýlmasý için sýfýrlama
				}else { //ikinci A bulunmadýysa normal.
					tempWord += word.charAt(i);
				}
			} else { // a bulunamadý ve index sýfýra eþit ise normal
				tempWord += word.charAt(i);
			}
		}
		return tempWord;
	}
	
	//C CEVAP
	public static boolean findParenthesis(String word) {
		boolean status = false;
		
		int endIndex = word.length()-1; //sondan daralma index tutumu
		for(int i = 0; i < word.length(); i++) { //baþtan daralma
			
			if(word.charAt(i) == '(') { //baþtan açýlmýþ parantez
				status = false;
				for(int e = endIndex; e >= 0 ; e--) { //sondan daralma
					if(word.charAt(e) == ')') { //sondan kapanmýþ parantez.
						endIndex = e-1; //bulunan indeksten geri gittiðimizden e-1
						status = true; // son durum		
						
						break;
					}
				}
			}
			
		}
		
		if(status) { //baþtan daralma ile sondan daralma doðru ise tam tersini uygulayacaðýz.
			int startIndex = 0; //baþtan daralma indeks tutumu
			for(int i = word.length()-1; i >= 0 ; i--) { //sondan daralma
				
				if(word.charAt(i) == ')') {  //sondan parantez açýlmýþ mý?
					status = false;
					for(int e = startIndex; e < word.length(); e++) { //baþtan daralma
						if(word.charAt(e) == '(') { // baþtan parantez kapanmýþ mý
							startIndex = e+1; //bulunan indeksten ileri gittiðimizden e+1
							status = true; // son durum
							break;
						}
					}
				}
				
			}
		}
		
		return status;
		
	}
	
	
	public static void main(String[] args) {
		aAnswer();
		bAnswer();
		cAnswer();
	}
	
	public static void aAnswer() { //A CEVAP		
		String text = "Hello World";
		String reverseWord = "";
		String[] words = text.split(" "); //kelimeleri boþluktan dilimleme
		for (String word : words) { // tüm kelimeleri tersten yazdýrýp yeni kelimeyi oluþturma
			reverseWord += reverseWord(word)+ " "; //tersine çevrilmiþ kelimeleri birleþtirme.
		}
		reverseWord = reverseWord.trim(); //trim ile baþ ve sondaki boþluklarý silme.		
		System.out.println(reverseWord);
	}
	
	public static void bAnswer() { //B CEVAP
		String text = "aeaa azAa";
		String reverseWord = "";
		String[] words = text.split(" "); //kelimeleri boþluktan dilimleme
		for (String word : words) { // tüm kelimelerin içinde aa bulma ilk harf a olsa dahi es geçilir.
			reverseWord += reverseaA(word)+ " ";
		}
		reverseWord = reverseWord.trim(); //trim ile baþ ve sondaki boþluklarý silme.		
		System.out.println(reverseWord);
	}

	public static void cAnswer() { //C CEVAP
		String text = "((a+b) / (d-c)) * e"; // (((a)) (a+b)
		boolean status = findParenthesis(text);
		System.out.println(status);
	}
	
}
