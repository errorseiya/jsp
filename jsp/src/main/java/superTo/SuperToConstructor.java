package superTo;

public class SuperToConstructor {

	public static void main(String[] args){
	    SubClass s = new SubClass();
	  }
}

class SuperClass {	//親クラス
	
	public SuperClass() {
	    System.out.println("引数なしコンストラクタ");
	}
	
	public SuperClass(String s) {
	    System.out.println("引数ありコンストラクタ：" + s);
	}
}
	 
class SubClass extends SuperClass {	//継承クラス
	public SubClass() {
	    super("スーパークラスへ送りたい文字列");
	    //super() とすることで、継承したクラス内で親クラスの引数有りのコンストラクタを呼び出せる
	    /*
	        superを使って、サブクラスからスーパークラスのコンストラクタを呼び出すことが可能です。

			自動的に呼び出されるのは「引数のないコンストラクタ」なので、
			引数のあるコンストラクタを呼び出すには「super」を使う必要があります。
	     
	     */
	  }

}



/* 以下だとerrorになる

コンストラクタとは、クラスがインスタンス化されるときに一度だけ呼び出されるメソッドです。

コンストラクタは継承されないので、使うときには注意が必要

    class SuperClass {
	  public SuperClass() {
	    System.out.println("SuperClassのコンストラクタ");
	  }
	}
	
	 
	public class SubClass extends SuperClass{
	  public SubClass() {
	    SuperClass();
	  }
	}
*/