package exs;

public class excecoes {

	    public static void main(String[] args) {
	        try {
	            String s = null;
	            System.out.println(s.length()); // Isso gerará NullPointerException
	        } catch (NullPointerException e) {
	            System.out.println("Uma exceção de NullPointerException foi capturada.");
	        }
	    }
}
