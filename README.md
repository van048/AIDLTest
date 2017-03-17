# AIDLTest
自定义接口交互

这种实现方式和AIDL非常类似

自定义一个接口，Server端用一个类继承自Binder并实现该接口，覆写了其中的方法。Client端通过ServiceConnection获取到该类的对象，从而能够使用该获取接口定义的方法，最终实现实时交互。

适用於同进程中通信，不能进行跨进程通信
