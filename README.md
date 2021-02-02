生产环境打包命令
mvn clean package -Ppro -Dmaven.test.skip=ture
测试环境直接打包就可
mvn clean package -Pdev -Dmaven.test.skip=ture