本项目在重构旧项目的基础上，重新设计架构，拆分服务，为之后的拓展做好准备，不考虑性能旨在体验微服务项目规范开发，

开发规范参考《阿里巴巴Java开发手册-黄山版》

# 目前计划：

目前进度：

第二版旧网站网址: [菠菜的小窝 -> https:www.likebocai.com](https://www.likebocai.com)

预计新版网站主页： 菠菜的小窝

## 一、重构博客板块和朋友圈模块
模块名为 share 义为分享
朋友圈 + 博客 = 微型博客社交平台 ≈ 微博 ^v^

博客板块
TODO：

朋友圈模块
TODO:

## 二、重构时光邮箱板块

TODO:

## 三、门户主页

**将非模块强相关的页面接口放在门户网站主页**:

TODO: 

* 友情链接重构到门户主页
* 网站大事记重构到门户主页
* 关于重构到门户网站
* 全站搜索放门户/每个模块通用一个加上搜索模块的条件
* 添加账号申诉功能，使用activiti7来实现流程审批
* 角色权限管理: 超级管理员、管理员(版主)、用户

## 四、视频资源分享网站(依托腾讯云视频)

TODO: 

## 五、将所有模块的后台管理写在一个模块中，在本地或服务端启动

TODO:
