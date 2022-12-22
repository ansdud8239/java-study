package prob02;

public class Book {
	
	private int bookNo;
	private String title;
	private String author;
	private int stateCode;


	public Book(int bookNo,String title,String author) {
		
		this.bookNo = bookNo;
		this.title = title;
		this.author = author;
		this.stateCode = 1;
	}


	public void rent() {
		stateCode = 0;
		System.out.println(title+"이(가) 대여 됐습니다");
		
	}
	public void print() {
	// 책 제목:풀하우스, 작가:원수연, 대여 유무:재고있음
		System.out.println(
				"책 제목:"+title+", "+
				"작가:"+author+", "+
				"대여 유무:"+(stateCode==1?"재고있음":"대여중"));
		
	}
}
