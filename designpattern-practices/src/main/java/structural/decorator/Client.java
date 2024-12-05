package structural.decorator;

public class Client {

	public static void main(String[] args) {
		System.out.println(new ConcreteComponent("Hello World").operation());
		System.out.println(new ParentheseDecorator(new ConcreteComponent("Hello World")).operation());
		
		System.out.println(new BraceDecorator(new ConcreteComponent("Hello world")).operation());
		System.out.println(new BraceDecorator(new ParentheseDecorator(new ConcreteComponent("Hello World"))).operation());

	}

}
