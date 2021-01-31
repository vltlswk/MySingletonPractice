# MySingletonPractice

## 생성자가 없는 싱글톤

생성자가 없는 싱글톤은 단지 object를 사용해서 만들기만 하면 된다.

object MySingletonClass {
}

이러면 인스턴스를 생성할 때 동일한 하나의 인스턴스를 사용할 수 있다.

## 생성자가 잇는 싱글톤

tip. 코틀린에서 object는 생성자를 가질 수 없다. 그러므로 생성자가 필요한 싱글톤을 구현하려면 class로 구현 후 companion object를 통해 싱글톤을 구현한다.

이때 생성자가 있으면 생성자를 privateConstructor로 만들어주고 fun getInstance(생성자)로 만들어주고 반환을 클래스 이름으로 해준다.
여기서는 MySQLOpenHelperSingleton에서 구현되고 있다.

@Volite를 사용해서 캐시 충돌이 없게 만들고

synchronized로 락을 건다
스레드는 synchronized 메소드에 들어가기 위해 lock을 얻고 메소드가 끝이나면 lock을 반환한다. 어떠한 스레드가 lock을 얻어 synchronized 메소드를 사용중이면 다른 메소드는 lock이 없으므로 synchronized에 접근할 수 없고, 다른 스레드가 lock을 반환 할 때까지 기다려야 한다.

https://m.blog.naver.com/PostView.nhn?blogId=nanyounan&logNo=221308678276&proxyReferer=https:%2F%2Fwww.google.com%2F
