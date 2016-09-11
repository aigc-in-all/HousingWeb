### 项目介绍

这是一个JavaWeb练手项目，不具有实际意义。

断断续续学Web开发有段时间了，期间都是写写Demo，知识点很零碎。所以就想找个项目练练手，把之前所学的东西用用。

这个项目主要是通过抓取[58](http://www.58.com)上面的房源信息存储到本地，然后通过Web端展示出来。Web框架使用SpringMVC，数据库使用MySQL。

城市及省份信息来自：http://www.58.com/changecity.aspx

房源信息来自：http://sz.58.com/pinpaigongyu/

涉及到的知识点有：
* Python抓取网页数据
* MySQL数据库
* JavaWeb
* CSS
* JavaScript

下面是截图：
![](/screenshot/1.png)

![](/screenshot/2.png)

![](/screenshot/3.png)

### 使用方式

1. 创建表
  [SQL脚本](/env/db.sql)
  
2. 抓取房源数据保存到MySQL
  [city.py](/env/city.py)
  [house.py](/env/house.py)
  
  ```
  python city.py
  python house.py
  ```

3. 运行Web项目

### TODO

1. 支持分类搜索
2. 在地图上展示、路径规划

> 数据来自[58同城](http://sz.58.com/pinpaigongyu/)，禁止作为商业用途。
