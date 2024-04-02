package com.xl.fan.aop;

import java.lang.annotation.*;

@Target(ElementType.METHOD) //修饰的对象范围，这里是用于方法上
@Retention(RetentionPolicy.RUNTIME) //保留的时间长短。这里是运行是保存
//@Documented 描述javadoc
//@Inherited 描述被标注的类型是被继承的
public @interface ZhuJie {
}
