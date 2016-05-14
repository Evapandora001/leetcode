/**  
 * @Title: Test.java
 * @Prject: leetcode
 * @Package: datastructure
 * @Description: TODO
 * @author: Evapandora  
 * @date: 2016年5月3日 上午11:27:18
 */
package datastructure;

/**
 * @ClassName: Test
 * @Description: TODO
 * @author: Evapandora
 * @date: 2016年5月3日 上午11:27:18
 */

//这里使用了静态导入
import static java.lang.System.out;

public class VarArgsTest {
    public static void m1(String s, String... ss) {
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
    }

    public static void main(String[] args) {

        m1("");
        m1("aaa");
        m1("aaa", "bbb");
    }
}