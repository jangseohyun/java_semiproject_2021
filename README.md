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
    
![1](https://user-images.githubusercontent.com/48784292/143876453-ecf8e794-02b2-4d71-8e76-25f200bab000.png)
</br>
    
2. 회원가입
    
![2](https://user-images.githubusercontent.com/48784292/143876657-02e7f4bb-f2d4-4e39-864f-baabbeffb52c.png)
</br>
    
3. 로그인
    
![3](https://user-images.githubusercontent.com/48784292/143876615-fb1cb164-6ba6-434c-be00-0c91cf293c3a.png)
</br>
    
4. 당월, 익월 달력 출력
    
![4](https://user-images.githubusercontent.com/48784292/143876758-0454fa40-b160-4099-8f2c-87ee79d12af2.png)
</br>

    
5. 대여/반납 날짜 및 시간 입력
    
![5](https://user-images.githubusercontent.com/48784292/143876776-c7a84bd7-296d-4bd3-ac42-268358c98b74.png)
</br>
    
6. 대여 가능한 차량 목록 출력 및 차량 선택
    
![6](https://user-images.githubusercontent.com/48784292/143876786-fd6251a4-333d-4555-8940-60b8b08b992f.png)
</br>
    
7. 보험 옵션 선택 
    
![7](https://user-images.githubusercontent.com/48784292/143876795-0bc791b6-f41f-4d59-92b8-62d4cab208a8.png)
</br>
    
8. 총 결제 금액 계산 및 예약 내용 확인
    
![8](https://user-images.githubusercontent.com/48784292/143876800-583125d1-391a-4aa0-bbb2-c59cc981520c.png)
</br>
    
9. 쿠폰 적용 및 결제

![9](https://user-images.githubusercontent.com/48784292/143876849-bbe2af67-36e2-46c3-89ae-21fea5930e78.png)
</br>
    
10. 결제 방식 선택 및 결제
    
![10](https://user-images.githubusercontent.com/48784292/143876871-2e906dcf-9041-4491-9193-a16ad5f38b29.png)
</br>
    
11. 현금 결제 시 거스름 돈 출력
    
![11](https://user-images.githubusercontent.com/48784292/143876894-64441702-2d64-4124-b986-9a8430e67523.png)
</br>
    
12. 예약확인서 출력
    
![12](https://user-images.githubusercontent.com/48784292/143876897-096890df-e9dd-4920-bbe3-4dd879af183b.png)
</br>
    
13. 재로그인 시 예약 내역서 발급

![13](https://user-images.githubusercontent.com/48784292/143876900-9909b8e1-968e-4ec3-abd6-f291a11d3129.png)
</br>
    
14. 관리자 모드  
    
![14](https://user-images.githubusercontent.com/48784292/143876912-343d3603-c262-4ae7-8348-792cb23773c7.png)
</br>
