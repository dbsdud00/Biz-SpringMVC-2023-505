# Spring Project 시작하기
- Spring Legacy Project > Spring MVC Project 를 생성
- Base-package 3단계 package 로 작성 : com.callor.hello
- views/home.jsp 삭제 후 다시 작성
- home.jsp 에 보여줄 메시지 추가
- Run As > Run On Server 를 실행하여 서비스 Start

## 생성한 프로젝트 설정 변경
- Templete 으로 생성한 Spring Project 는 오래된 벼전의 설정이 되어 있다.
- 새로운 version 으로 다시 리모델링 하기
- pom.xml 에 설정된 값들을 변경하기


## pom.xml 의 설정 값들 
### Property
- 개발과 관련된 용어 중 변수, 속성, Var, varriable, attribute , Property 등은 모두 같은 용어이다.
- templete
- 대부분 오래된 버전이다.
```XML
	<properties>
		<java-version>1.6</java-version>
		<org.springframework-version>3.1.1.RELEASE</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.6.6</org.slf4j-version>
	</properties>
```

```XML
	<properties>
		<java-version>11</java-version>
		<org.springframework-version>5.2.24.RELEASE</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.7.36</org.slf4j-version>
	</properties>
```

### Dependency
- maven project 에서 3rd party LIB 를 설정하는 부분

### plugin
- Spring Project 의 근간인 maven project 가 사용할 여러가지 도구 설정
- plugin 중에서 maven-compiler-plugin 의 설정을 변경
- 이 plugin 은 Java 소스코드를 컴파일하고 실행하는 보조 도구이다.
- 이 plugin 은 작성하고 있는 project 를 컴파일하고 실행하는 java 버전을 설정해주어야 한다
- 여기 source 와 target 이 값으로 설정되어 있는데 위에서 설정한 property 로 변경해 준다.
```XML
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.5.1</version>
                <configuration>
                    <source>${java-version}</source>
                    <target>${java-version}</target>
                    <compilerArgument>-Xlint:all</compilerArgument>
                    <showWarnings>true</showWarnings>
                    <showDeprecation>true</showDeprecation>
                </configuration>
            </plugin>
```
