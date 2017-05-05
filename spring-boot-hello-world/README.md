按照上面的实验，可以如下总结多环境的配置思路：

- application.properties中配置通用内容，并设置spring.profiles.active=dev，以开发环境为默认配置
- application-{profile}.properties中配置各个环境不同的内容
- 通过命令行方式去激活不同环境的配置(java -jar xxx.jar --spring.profiles.active=test)