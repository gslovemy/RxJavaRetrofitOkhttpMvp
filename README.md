# RxJavaRetrofitOkhttpMvp
时下流行的RxJava+Retrofit+Okhttp+Mvp封装的一个demo,简单,易理解,深度解耦,方便迭代,总之就是爽.
 >    RxJava+Retrofit+okhttp+mvp,现在流行这一套框架的封装,想着想着就自己封装了一套,并-且我们的项目的里面也这样用,方便以后的功能的迭代开发,产品需求的更改,有什么不足的地方,欢迎issues,如果你觉得有借鉴的地方,欢迎star.               
 
- 	## MVP的概念 ##
     * M model(网络请求,数据处理)
     * V view(activity,fragment)
     * p presenter(核心逻辑)
     * 详情看,[https://github.com/gslovemy/MvpDemo](https://github.com/gslovemy/MvpDemo "MVP"),欢迎star
     
-	## RxJava ##
      > * RxJava 在 GitHub 主页上的自我介绍是 "a library for composing asynchronous and event-based programs using observable sequences for the Java VM"（一个在 Java VM 上使用可观测的序列来组成异步的、基于事件的程序的库）。这就是 RxJava ，概括得非常精准。其实， RxJava 的本质可以压缩为异步这一个词。说到根上，它就是一个实现异步操作的库，而别的定语都是基于这之上的。可以参考[http://gank.io/post/560e15be2dca930e00da1083#toc_1](http://gank.io/post/560e15be2dca930e00da1083#toc_1)
-	## Retrofit ##
      > * Retrofit与okhttp共同出自于Square公司，retrofit就是对okhttp做了一层封装。把网络请求都交给给了Okhttp，我们只需要通过简单的配置就能使用retrofit来进行网络请求了,Retrofit 除了提供了传统的 Callback 形式的 API，还有 RxJava 版本的 Observable 形式 API。可以参考[http://blog.csdn.net/bitian123/article/details/51899716](http://blog.csdn.net/bitian123/article/details/51899716)
   
-  ## okhttp ##
    > * 一个非常强大的网络请求库, 可以参考[http://blog.csdn.net/lmj623565791/article/details/47911083](http://blog.csdn.net/lmj623565791/article/details/47911083)

-  ## 效果图展示 ##
   >  * ![](http://i.imgur.com/ofIBTSO.gif)






-  ## 包结构如下 ##
 	- model : LoginModel
	- presenter：LoginPresenter
	- view：Activity，Fragment,etc.
	- base:BaseAcitivity,BasePresenter,etc.
	- mvp IView, IModel,IPresenter.
	- contract 契约类,接口定义.
	- unitls 工具栏.
	- http 网络请求的封装
	- exception 自定义异常
	- transformer 转换器(我自己这样理解)
	- url 链接地址的定义
	- subsciriber 订阅者(观察者)
-  ## Thanks ##
    hi大头鬼.  
    鸿洋

