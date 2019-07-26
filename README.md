# MVVMDatabinding
디자인 패턴을 사용하여, 테스트 적용범위를 높이고 코드의 재사용성을 향상시켜 유지보수 비용을 줄이기 위함

## MVVM이란?
MVVM은 Model-View-ViewModel의 약자로서,
Model은 UI에 표시될 데이터와 비즈니스 로직을 담당하고, View는 UI를 의미하며, ViewModel은 이벤트 처리나 Model과의 인터랙션을 담당한다.

### Databinding 추가
데이턴 바인딩은 데이터를 xml 상에 바로 연동시키는 작업을 말한다.

```build.gradle
dataBinding {
enabled = true
```
Kotlin으로 작업시, 바인딩 에러가 발생할 수 있다.
그 경우 build.gradle 상단에

```build.gradle
apply plugin: 'kotlin-kapt'
```

### AAC 적용
AAC(Android Architecture Component)에서 제공하는 LiveData, ViewModel, Room, Paging 등을 적용하였다.
안드로이드 개발을 하다보면 Activity나 Fragment의 복잡한 lifecycle 때문에 데이터 상태관리의 어려움을 느끼게 되지만 AAC ViewModel을 사용할 경우, 
lifecycle의 영향을 받지 않고 ViewModel이 가진 데이터를 안전하게 관리가 가능하다.

1. LifeCycle
- Activity나 Fragment의 생명주기를 감지하고 이에 따른 작업을 수행 할 수 있게 도와준다.

2. LiveData
- 식별 가능한 데이터 홀더이다. 
앱의 다른 구성요소에서는 이 홀더를 사용하여 상호 간에 명시적이고 엄격한 종속성 경로를 만들지 않고도 개체 변경사항을 모니터링 할 수 있다.

3. Room
- 개체 매핑 라이브러리로, 최소한의 상용구 코드로 로컬 데이터 지속성을 제공한다. 
Room에서는 원본 SOL 테이블과 쿼리로 작동하는 일부 기본 구현 세부정보를 추출한다.

4. ViewModel
- Activity나 Fragment 같은 특정 UI 구성요소에 대한 데이터를 제공하고 모델과 커뮤니케이션하기 위한 데이터 처리 비지니스 로직을 포함한다.


### Koin 사용하여 의존성 주입
Java에서는 의존성 주입으로 Dagger2를 많이 사용한다. 
물론 코틀린에서도 사용 가능하지만, 더 가볍게 의존성 주입이 가능한 DI 프레임워크인 Koin을 사용하였다.
아래와 같이 single 함수를 사용해 싱글톤 객체 생성이 가능하며,
이렇게 생성한 모듈을 Application에서 startKoin을 통해 활성화 시켜주면 된다.

```kotlin
val roomModule = module {
    single { AddressDatabase.getInstance(androidApplication()) }
    single(createOnStart = false)  { get<AddressDatabase>().getAddressDao() }
}
.
.
.
startKoin(this, listOf(viewModule))
```
