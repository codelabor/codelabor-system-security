3.0.0
	Anyframe 의존성 제거

2.0.0
	web 패키지 리팩토링
	spring 3.x 관련 모듈 제거
	jcl > slf4j

2.0.1
	Selective Filter에 toLowerCase() 제거

2.0.2
	SessionValidationFilter 추가
	XXXSessionIdValidXXX 관련 모듈 deprecated

4.0.0
	org.codelabor.example 패키지 제거
	apache commons lang 업그레이드
	org.codelabor.system.login 모듈 제거
	deprecated 된 XXXSessionIdValidXXX 관련 모듈 제거

4.0.1
	codelabor-system-web 업그레이드 (4.0.3)
	DomainAwareAuthenticationSuccessHandler 이관 받음
	LogbackMappedDiagnosticContextFilter 추상화하여 sniffer로 이관
	SecurityContextLogbackMappedDiagnosticContextFilter 로 구체화