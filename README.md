# 1. 프로젝트 개요

</br>

<b>4조 테슬라사조🚘 :</b> 이하림(조장), 박나현, 선혜연, 이새롬, 장서현 

</br>

* <b>프로젝트명:</b> 뚜또렌터카 (Ddu-ddo Car Rental Service)
* <b>진행 기간:</b> 2021.03.10(수) ~ 2021.03.23(화)
* <b>전체 주제:</b> 자판기(Vending Machine)
* <b>선정 주제:</b> 렌터카 자판기
* <b>제출 항목:</b> 기획안, 회의록, 결과물, 발표 및 보고자료(후기 포함)
* <b>세부 내용:</b> https://plmaq11.notion.site/de4d0486906d4093a3d2b67dd3ce6140

</br></br>

# 2. 프로젝트 목표

</br>

- 클래스 개념~자바 기초 과목을 통틀어 공부한 내용을 모두 적용시킬 수 있도록 구성한다.
- 자판기의 핵심 기능 기획 및 구현한다.
- 자바를 응용하여 프로그램을 구현할 수 있다.
- 여러 클래스 간의 연결과 객체 활용을 익힌다.
- API 도큐먼트를 적극 활용하여 수업 시간에 다루지 않은 새로운 기능을 구현한다. 

</br></br>

# 3. 구현 기능 및 구현 방법

</br>

1. 각 클래스들을 하나의 클래스(Start)에 객체화 하여 ‘뒤로 가기’ 구현.
2. ‘Thread sleep(ms)’을 활용하여 3초 지연 효과 추가.
3. Calendar 클래스를 활용하여 현재 날짜/시간 호출. 이를 활용하여 달력 출력.
4. Vector 자료구조를 활용하여 보유한 차량 중 대여 가능한 차랑만 리스트로 출력.
5. 객체화와 Vector 자료구조를 활용하여 예약된 차량을 다음 실행 시 가능한 차량 목록에서 제거.
6. Date 클래스와 HashMap 자료구조를 활용하여 로그인 시점에 조건에 맞는 쿠폰 자동 발급. Array 정렬 기능을 활용하여 가장 할인율이 높은 쿠폰을 자동으로 적용시켜 총 금액 계산.
7. Vector 자료구조를 활용하여 예약정보를 저장하고 사용자 요청 시 예약 확인서 출력.

</br></br>

# 4. 작성 파일

</br>

|파일명|참여자(참여도 순)|
|:---|:---|
|Main|<b>하림</b>|
|Start|<b>서현</b>, 하림|
|Join|<b>서현</b>, 하림, 새롬, 혜연|
|Login|<b>서현</b>, 하림, 새롬|
|DateTime|<b>서현</b>, 하림, 나현, 새롬|
|Car|<b>나현</b>, 혜연, 서현, 하림|
|Insurance|<b>혜연</b>, 나현, 하림|
|CheckSelection|<b>새롬</b>, 하림|
|Payment|<b>하림</b>, 서현|
|Inquiry|<b>하림</b>, 새롬|
|User|<b>서현</b>, 하림|
|UserData|<b>하림</b>, 서현|
|Card|<b>하림</b>, 새롬, 나현|
|DriversLicense|<b>서현</b>|
|Reservation|<b>서현</b>, 하림|
|ReservationData|<b>서현</b>, 하림|

</br></br>

# 5. 실행 화면

</br>

1. 시작 화면
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c4447a81-aebb-4b40-8444-ec622891201f/1.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/c4447a81-aebb-4b40-8444-ec622891201f/1.png)
    
2. 회원가입
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b7786bd2-ebfc-4dc9-a8c0-1d40c0a22b59/2.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b7786bd2-ebfc-4dc9-a8c0-1d40c0a22b59/2.png)
    
3. 로그인
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a9a2d2ca-a734-4cc1-9765-8a5216a69ec5/3.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a9a2d2ca-a734-4cc1-9765-8a5216a69ec5/3.png)
    
4. 당월, 익월 달력 출력
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6259ddc0-1538-4d95-8e58-3396fafad7bc/4.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6259ddc0-1538-4d95-8e58-3396fafad7bc/4.png)
    
5. 대여/반납 날짜 및 시간 입력
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6e5ef757-c05c-4502-9d76-6669475dd200/5.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/6e5ef757-c05c-4502-9d76-6669475dd200/5.png)
    
6. 대여 가능한 차량 목록 출력 및 차량 선택
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e6369c7e-db15-4630-ac50-c87e5fc6c3e0/6.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/e6369c7e-db15-4630-ac50-c87e5fc6c3e0/6.png)
    
7. 보험 옵션 선택 
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/548b6301-bca0-4a97-bd60-1cc42c8b8bb3/7.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/548b6301-bca0-4a97-bd60-1cc42c8b8bb3/7.png)
    
8. 총 결제 금액 계산 및 예약 내용 확인
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4d542d15-196a-41c5-9647-9f9c14633a71/8.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4d542d15-196a-41c5-9647-9f9c14633a71/8.png)
    
9. 쿠폰 적용 및 결제
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/94253b55-d5cc-4879-8998-e2d09141d31d/9.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/94253b55-d5cc-4879-8998-e2d09141d31d/9.png)
    
10. 결제 방식 선택 및 결제
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4c08278d-0e6a-4e47-b4ed-df36a9aa4696/10.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/4c08278d-0e6a-4e47-b4ed-df36a9aa4696/10.png)
    
11. 현금 결제 시 거스름 돈 출력
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2716a32e-446d-419e-8fc3-371622e9655c/11.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2716a32e-446d-419e-8fc3-371622e9655c/11.png)
    
12. 예약확인서 출력
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7779e1a3-02fb-4f8b-837b-10948d631c11/12.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7779e1a3-02fb-4f8b-837b-10948d631c11/12.png)
    
13. 재로그인 시 예약 내역서 발급
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/971d962e-b6f3-4382-a927-a3f242362d57/13.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/971d962e-b6f3-4382-a927-a3f242362d57/13.png)
    
14. 관리자 모드  
    
    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/eea286bf-f4ce-498a-8807-a8824eedc02b/14.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/eea286bf-f4ce-498a-8807-a8824eedc02b/14.png)
