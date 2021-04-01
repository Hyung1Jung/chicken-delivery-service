# chicken-delivery-service

소비자에게 치킨 배달 서비스를 제공하는 API 서버

## 사용 기술 및 환경

SpringBoot. Gradle, Jpa, java11, H2, MySql 그 외 추후 추가 예정

## 프로젝트 주요 관심사

* 이유와 근거가 명확한 기술의 사용

* 클린코드를 위한 꾸준한 코드 리팩토링

* 객체지향적 개념을 이해하고 이를 코드에 녹여내어 의미있는 설계를 지향

* 대용량 트래픽의 상황에서 지속적인 서버 성능 개선

## 전체 프로젝트 구조

- 추후 작성 예정

## WIKI

* [Wiki](https://github.com/thenaun-workspace/chicken-delivery-service/wiki)
* [Usecase](https://github.com/thenaun-workspace/chicken-delivery-service/wiki/USECASE-:-USER)

## 기술적 issue 해결 과정

- 추후 작성 예정

## 서버 컨벤션
- [코드 컨벤션](https://naver.github.io/hackday-conventions-java/)
- [API 디자인](https://docs.microsoft.com/ko-kr/azure/architecture/best-practices/api-design)

## 브랜치 관리 전략

&nbsp;&nbsp;&nbsp;&nbsp; Git-Flow 를 이용하여 브랜치를 관리하였습니다.

<p align="center">
  <img src="https://user-images.githubusercontent.com/54772162/101170794-45d27180-3682-11eb-8c42-6f4bf8ec73c9.PNG?raw=true" alt="Sublime's custom image"/>
</p>

✔️ master : 배포시 사용할 브랜치. 초기 시행착오에 의하여 몇몇 기능이 merge 되어 있으나, 원래 사용 용도는 완벽히 배포가 가능한 상태에만 merge가 되어야만 합니다.        
✔️ develop : 다음 버전을 개발하는 브랜치, 완전히 배포가 가능하다고 생각되면 master 브랜치에 merge 합니다.    
✔️ feature : 기능을 개발하는 브랜치    
✔️ release : 배포를 준비할 때 사용할 브랜치    
✔️ hotfix : 배포 후에 발생한 버그를 수정 하는 브랜치


**[참고 및 출처]**

* [우아한형제들 기술블로그](https://woowabros.github.io/experience/2017/10/30/baemin-mobile-git-branch-strategy.html)
* [git-flow cheatsheet](https://danielkummer.github.io/git-flow-cheatsheet/index.ko_KR.html)
