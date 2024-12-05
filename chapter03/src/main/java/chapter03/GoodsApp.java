package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		
//		goods.name = "nikon";
//		goods.price = 4000000;
//		goods.countSold = 10;
//		goods.countStock = 20;
		
		goods.setName("nikon");
		goods.setPrice(4000000);
		goods.setCountSold(10);
		goods.setCountStock(20);
		
//		System.out.println(
//				"상품이름: " + goods.name + 
//				", 가격: " + goods.price +
//				", 판매량: " + goods.countSold +
//				", 재고 개수: " + goods.countStock);
		
//		System.out.println(
//				"상품이름: " + goods.getName() + 
//				", 가격: " + goods.getPrice() +
//				", 판매량: " + goods.getCountSold() +
//				", 재고 개수: " + goods.getCountStock());
		
		goods.printInfo();
		
		// 정보 은닉(객체의 상태를 보호)
		goods.setPrice(-1000);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		// static 변수(클래스 변수)
		System.out.println(Goods.countOfGoods);
		
		goods.setPrice(40000);
		System.out.println(goods.calcDiscountPrice(0.5f));
		
	}

}
