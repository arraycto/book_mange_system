# book_mange_system
2020-07-05 图书管理系统（书店），用的是Spring Boot + Mybatis + HTML + Ajax + HTML
# 功能
## 管理员管理端
- 权限鉴定：对每个接口都设置访问权限，只有拥有对应权限的用户才能访问该接口。
- 管理员信息管理：超级管理员（这是一个特殊账号由开发人员手动加入数据库）可以新增普通管理员、禁用普通管理员账号、重置普通管理员密码等。
- 会员信息管理：管理员可以对会员信息进行新增，查找，禁用、充值等功能。
- 图书借阅记录：管理员录入会员的图书借阅记录。
- 图书信息管理：管理员可以对图书信息进行增删查改。
- 图书借阅信息管理：管理员对图书或者会员的图书借阅记录进行搜索查看用来分析书店里最受欢迎的图书或者会员对图种类喜爱的分布情况。
- 支付功能：为了模拟会员充值过程在查阅多方资料后决定接入支付宝沙盒（支付宝沙盒功能是专门用来做开发测试的和正式使用差别不大）
## 客户访问端
- 书店首页：包括图书查询、图书位置查询、图书推荐等功能模块
- 会员借阅记录查询：输入会员号查询对应借阅记录
- 会员信誉值查询：输入会员号查询对应信誉值
