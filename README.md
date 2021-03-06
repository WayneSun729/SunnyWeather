# SunnyWeather
该项目采用了MVVM架构。

<img src="https://github.com/WayneSun729/SunnyWeather/blob/master/images/WeatherActivity.jpg" width="750" />

我们可以将程序分为了若干层。

绿色部分表示的是UI控制层，这部分就是我们平时写的Activity和Fragment。

蓝色部分表示的是ViewModel层，ViewModel用于持有和UI元素相关的数据，以保证这些数据在屏幕旋转时不会丢失，以及负责和仓库之间进行通讯。

黄色部分表示的是仓库层，仓库层要做的工作是自主判断接口请求的数据应该是从数据库中读取还是从网络中获取，并将数据返回给调用方。如果是从网络中获取的话还要将这些数据存入到数据库当中，以避免下次重复从网络中获取。简而言之，仓库的工作就是在本地和网络数据之间做一个分配和调度的工作，调用方不管你的数据是从何而来的，我只是要从你仓库这里获取数据而已，而仓库则要自主分配如何更好更快地将数据提供给调用方。

接下来灰色部分表示是的本地数据层。

最后红色部分表示的是网络数据层，这里使用了Retrofit从web服务接口获取数据。

另外，图中所有的箭头都是单向的，比方说WeatherActivity指向了WeatherViewModel，表示WeatherActivity持有WeatherViewModel的引用，但是反过来WeatherViewModel不能持有WeatherActivity的引用。其他的几层也是一样的道理，一个箭头就表示持有一个引用。
（好莱坞原则）

还有，引用不能跨层持有，就比方说UI控制层不能持有仓库层的引用，每一层的组件都只能和它的相邻层交互。

项目运行截图如下：
<img src="https://github.com/WayneSun729/SunnyWeather/blob/master/images/%E9%A1%B9%E7%9B%AE%E6%88%AA%E5%9B%BE.png" width="750" />

接下来可以改进的方向：
1.提供更完整的天气信息
2.允许选择多个城市
3.增加后台更新天气功能
4.适配黑色模式
