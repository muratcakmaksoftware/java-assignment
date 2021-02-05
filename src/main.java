
public class main {
	
	//A CEVAP
	public static String reverseWord(String word) { //kelimeyi tersine �evirmek i�in fonksiyon
		String tempWord = "";
		for(int i = word.length()-1; i >= 0 ; i--) { //karakterleri tersten yazd�rma
			tempWord += word.charAt(i);
		}
		return tempWord;
	}
	
	
	//B CEVAP
	public static String reverseaA(String word) {
		String tempWord = "";
		int aFind = 0;
		for(int i = 0; i < word.length(); i++) {
			
			if(word.charAt(i) == 'a' && i != 0) { // ilk harf her zaman ayn� oldu�undan atlan�r.
				aFind++; // a bulundu
				if(aFind == 2) { // 2 ci A bulunduysa harfi b�y�ltme.
					tempWord += Character.toUpperCase(word.charAt(i));					
					aFind = 0; //tekrardan A lar�n say�lmas� i�in s�f�rlama
				}else { //ikinci A bulunmad�ysa normal.
					tempWord += word.charAt(i);
				}
			} else { // a bulunamad� ve index s�f�ra e�it ise normal
				tempWord += word.charAt(i);
			}
		}
		return tempWord;
	}
	
	//C CEVAP
	public static boolean findParenthesis(String word) {
		boolean status = false;
		
		int endIndex = word.length()-1; //sondan daralma index tutumu
		for(int i = 0; i < word.length(); i++) { //ba�tan daralma
			
			if(word.charAt(i) == '(') { //ba�tan a��lm�� parantez
				status = false;
				for(int e = endIndex; e >= 0 ; e--) { //sondan daralma
					if(word.charAt(e) == ')') { //sondan kapanm�� parantez.
						endIndex = e-1; //bulunan indeksten geri gitti�imizden e-1
						status = true; // son durum		
						
						break;
					}
				}
			}
			
		}
		
		if(status) { //ba�tan daralma ile sondan daralma do�ru ise tam tersini uygulayaca��z.
			int startIndex = 0; //ba�tan daralma indeks tutumu
			for(int i = word.length()-1; i >= 0 ; i--) { //sondan daralma
				
				if(word.charAt(i) == ')') {  //sondan parantez a��lm�� m�?
					status = false;
					for(int e = startIndex; e < word.length(); e++) { //ba�tan daralma
						if(word.charAt(e) == '(') { // ba�tan parantez kapanm�� m�
							startIndex = e+1; //bulunan indeksten ileri gitti�imizden e+1
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
		String[] words = text.split(" "); //kelimeleri bo�luktan dilimleme
		for (String word : words) { // t�m kelimeleri tersten yazd�r�p yeni kelimeyi olu�turma
			reverseWord += reverseWord(word)+ " "; //tersine �evrilmi� kelimeleri birle�tirme.
		}
		reverseWord = reverseWord.trim(); //trim ile ba� ve sondaki bo�luklar� silme.		
		System.out.println(reverseWord);
	}
	
	public static void bAnswer() { //B CEVAP
		String text = "aeaa azAa";
		String reverseWord = "";
		String[] words = text.split(" "); //kelimeleri bo�luktan dilimleme
		for (String word : words) { // t�m kelimelerin i�inde aa bulma ilk harf a olsa dahi es ge�ilir.
			reverseWord += reverseaA(word)+ " ";
		}
		reverseWord = reverseWord.trim(); //trim ile ba� ve sondaki bo�luklar� silme.		
		System.out.println(reverseWord);
	}

	public static void cAnswer() { //C CEVAP
		String text = "((a+b) / (d-c)) * e"; // (((a)) (a+b)
		boolean status = findParenthesis(text);
		System.out.println(status);
	}
	
}
