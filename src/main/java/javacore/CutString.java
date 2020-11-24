package javacore;

public class CutString {
	public static void main(String[] args) {
		String src="https://demo.nopcommerce.com/images/thumbs/0000020_build-your-own-computer_100.jpeg";
		String[] SRC= src.split("_");
		String srcNew= SRC[0];
		System.out.println(srcNew);
	}

}
