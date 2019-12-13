package com.ssr.translationtest;

import com.ssr.translationtest.service.Observer;
import com.ssr.translationtest.service.impl.ObjectFor3D;
import com.ssr.translationtest.service.impl.Observer1;
import com.ssr.translationtest.service.impl.Observer2;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TranslationtestApplicationTests {

  @Test
  void contextLoads() {
    //模拟一个3D的服务号
    ObjectFor3D subjectFor3d = new ObjectFor3D();
    //客户1
    Observer observer1 = new Observer1(subjectFor3d);
    //客户2
    Observer observer2 = new Observer2(subjectFor3d);

    subjectFor3d.setMsg("20140420的3D号码是：127" );
    subjectFor3d.setMsg("20140421的3D号码是：333" );
  }
}
