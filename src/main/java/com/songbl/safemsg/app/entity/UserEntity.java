
package com.songbl.safemsg.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户
 *
 * https://zhuanlan.zhihu.com/p/32779910
 *	 lombok：龙目岛：减少一些get、set、toString等方法的编写
 *	 	直接在实体类上引入注解就可以
 * @Data：注解在类上，提供类所有属性的get和set方法，此外还提供了equals、hashCode、toString方法、默认的构造方法
 * @Setter：注解在属性上，为单个属性提供set方法；注解在类上，为该类所有的属性提供set方法。还有一个默认的构造方法
 * @Getter: 同上
 * @Log4j：注解在类上，为类提供一个名为log的log4j日志对象，提供默认的构造方法；可以直接用这个log.info在想要的地方打印日志
 * @AllArgsConstructor：为类提供一个全参的构造方法，加了这个注解后，类中不提供默认构造方法了
 * @NoArgsConstructor：注解在 类 上；为类提供一个无参的构造方法
 * @EqualsAndHashCode：注解在 类 上, 可以生成 equals、canEqual、hashCode 方法
 * @NonNull：注解在 属性 上，会自动产生一个关于此参数的非空检查，如果参数为空，则抛出一个空指针异常，也会有一个默认的无参构造方法
 * @Cleanup：这个注解用在 变量 前面，可以保证此变量代表的资源会被自动关闭，默认是调用资源的 close() 方法，
 * 		如果该资源有其它关闭方法，可使用 @Cleanup(“methodName”) 来指定要调用的方法，也会生成默认的构造方法
 * @ToString：这个注解用在 类 上，可以生成所有参数的 toString 方法，还会生成默认的构造方法
 * @RequiredArgsConstructor：这个注解用在 类 上，使用类中所有带有 @NonNull 注解的或者带有 final 修饰的成员变量生成对应的构造方法
 * @Value：这个注解用在 类 上，会生成含   （所有参数 ）  的构造方法，get 方法，此外还提供了equals、hashCode、toString 方法
 * @SneakyThrows： 这个注解用在 方法 上，可以将方法中的代码用 try-catch 语句包裹起来，捕获异常并在 catch 中用 Lombok.sneakyThrow(e) 把异常抛出，
 * 		可以使用 @SneakyThrows(Exception.class) 的形式指定抛出哪种异常，也会生成默认的构造方法
 *
 *
 *
 *
 *
 *
 */
@Data
@TableName("tb_user")
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	@TableId
	private int userId;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 性别
	 */
	private int gender ;

   private String priKey ;

   private String pubKey ;


}
