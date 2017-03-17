# AIDLTest
AIDL属于Android的IPC机制，常用于跨进程通信，主要实现原理**基于底层Binder机制**。

aidl文件的书写规范如下：
- Android支持String和CharSequence(以及Java的基本数据类型)；不需要导入
- **如果需要在aidl中使用其它aidl接口类型，需要import，即使是在相同包结构下**；
- Android允许传递**实现Parcelable接口的类，需要import**；
- Android支持集合接口类型List和Map，但是有一些限制，**元素必须是基本型或者前面三种情况**，不需要import集合接口类，但是需要对元素涉及到的类型import；
- **非基本数据类型，也不是String和CharSequence类型的，需要有方向指示，包括in、out和inout，in表示由客户端设置，out表示由服务端设置，inout是两者均可设置**。
