# springcloud-sleuth-zipkin
zipkin 2.x版本的集成

官网地址：https://zipkin.io/
service地址：地址:9411/zipkin

集成DEMO https://github.com/spring-cloud/spring-cloud-sleuth/blob/master/docs/src/main/asciidoc/features.adoc

外接mq集成文档https://github.com/spring-cloud/spring-cloud-sleuth/blob/master/docs/src/main/asciidoc/intro.adoc

坑点  
1.zipkin 2.x版本 只能从官网下载服务器
2.restTemplate必须bean注入，使用spring管理，不然traceId会每次都重新生成


1版本基础集成
2版本上kafak集成





