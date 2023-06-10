### :small_orange_diamond: 📢JSP : MVC2 게시판 만들기

<br><br>

### :small_orange_diamond: 📆 프로젝트 기간

2023.06.04. ~ 2023.06.10

| 기간                | 설명                                                         |
| ------------------- | ------------------------------------------------------------|
| 6.04(일)| 컨트롤러 서블릿/MemberVO,DAO/회원정보출력창 작성                           |
| 6.05(월)| 회원 정보 추가, 수정, 삭제 기능 구현                                       |
| 6.06(화) ~ 6.07(수)| 게시판 글 목록 보기 구현 수정                                   |
| 6.08(목)|     게시물 글 쓰기, 상세보기 구현                            |
| 6.09(금)| 게시물 수정 기능 구현                                                    |
| 6.10(토)| 게시물 삭제, 답글 쓰기, 게시판 페이징 기능 구현 / 완성 |

<br><br>

### :small_orange_diamond: 📍개발 환경

<img src="https://www.eclipse.org/downloads/images/javaee.png" width="60" height="60">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="https://cdn-icons-png.flaticon.com/512/5968/5968282.png" width="100" height="100">&nbsp;&nbsp;&nbsp;<img src="https://cdn.icon-icons.com/icons2/2699/PNG/512/mariadb_logo_icon_168996.png" width="150" height="100">

<br><br>

### :small_orange_diamond: 🥁구현 기능 목록
* 게시판 기능
  - 게시글 쓰기
     + 글제목, 글내용, 이미지파일 첨부 작성
  - 게시글 상세 조회
    + 글번호, 작성자 아이디, 제목, 내용, 등록일자
  - 게시글 리스트
    + 글번호, 작성자, 제목, 작성일
  - 게시글 내용 수정 기능
  - 게시글 삭제 기능
  - 게시글에 답글 기능 
  
<br><br>
***
### :small_orange_diamond: 🎯구현 결과
#### 0) 시작/메인화면
![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/Main.0/%EB%A9%94%EC%9D%B8.jpg)
***

#### 1) 글 쓰기


![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/write.1/%EC%83%88%20%EA%B8%80%20%EC%93%B0%EA%B8%B0%20%EA%B8%B0%EB%8A%A5.jpg)

#### 1-1) 글 쓰기 alert
![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/write.1/%EC%83%88%20%EA%B8%80%20%EC%93%B0%EA%B8%B0%20%EA%B8%B0%EB%8A%A52.jpg)

#### 1-2) 글이 추가된 모습
![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/write.1/%EC%83%88%20%EA%B8%80%20%EC%93%B0%EA%B8%B0%20%EA%B8%B0%EB%8A%A53.jpg)

<br><br>
***
#### 2) 게시글 상세보기



![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/View.2/%EA%B8%80%20%EC%83%81%EC%84%B8%20%EB%B3%B4%EA%B8%B0%20%EA%B8%B0%EB%8A%A5.jpg)

<br><br>
***
#### 3) 게시글 수정


![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/Mod.3/%EC%88%98%EC%A0%95%EA%B3%BC%EC%A0%95.jpg)

#### 3-1) 게시글 수정 alert

![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/Mod.3/%EC%88%98%EC%A0%95%EA%B3%BC%EC%A0%952.jpg)

<br><br>
***
#### 4) 게시글 삭제

- 상세보기에서 삭제하기를 누르면 게시글이 삭제가 되는 기능

![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/View.2/%EA%B8%80%20%EC%83%81%EC%84%B8%20%EB%B3%B4%EA%B8%B0%20%EA%B8%B0%EB%8A%A5.jpg)

#### 4-1) 게시글 삭제 alert

![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/delete.4/%EC%82%AD%EC%A0%9C%EA%B3%BC%EC%A0%951.jpg)

<br><br>
***
#### 5) 답글 

- 상세보기에서 답글쓰기를 누르면 답글을 쓸 수 있는 화면으로 전환되는 기능

![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/reply.5/%EB%8B%B5%EA%B8%80%EB%B0%98%EC%98%81.jpg)

#### 5-1) 답글 alert
- 답글 반영하기를 누르면

![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/reply.5/%EB%8B%B5%EA%B8%80%EB%B0%98%EC%98%812.jpg)

<br><br>
***


#### 6) 페이징 기능



![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/paging.6/%ED%8E%98%EC%9D%B4%EC%A7%80%20%EA%B8%B0%EB%8A%A5%20%EC%84%A4%EB%AA%85.jpg)

#### 6-1) 최대 페이지 늘리기
![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/paging.6/articlesMapput%EA%B0%92%20%EB%B3%80%EA%B2%BD%ED%95%98%EC%97%AC%20%ED%8E%98%EC%9D%B4%EC%A7%80%20%EB%8A%98%EB%A6%AC%EA%B8%B0%20Code.jpg)

#### 6-2) 최대 페이지 늘리기 확인
![image](https://raw.githubusercontent.com/byeongseokim/JSP-MVC-model2-Project/ee2994c25d1a667760f4c8037bc2ee7b3ee05bda/Images/paging.6/articlesMapput%EA%B0%92%20%EB%B3%80%EA%B2%BD%ED%95%98%EC%97%AC%20%ED%8E%98%EC%9D%B4%EC%A7%80%20%EB%8A%98%EB%A6%AC%EA%B8%B0.jpg)

<br><br>
***
### :small_orange_diamond: 힘들었던 점 & 마무리

#### 1. 컨트롤러 서블릿/MemberVO,DAO/회원정보출력창 작성
MariaDB를 연결하고 다음을 진행하려고 하니까 제대로 연결이 되지 않아 힘들었다.

#### 2.회원 정보 수정 및 삭제 기능 구현
회원 정보 수정 및 삭제 페이지가 열리지 않아 힘들었다.

#### 3.게시판 글 목록 보기 구현
대소문자 오타가 있었는데 하루 종일 못 찾아서 힘들었지만, 결국 찾았고 작동이 되니까 행복했다.

#### 4.게시판 글쓰기,상세보기 구현
오타나 특별한 에러가 없었기에 힘들진 않았고,  mvc2를 점점 알아가는 느낌이 들었다.

#### 5.게시물 수정 기능 구현
수정하는 기능을 안 넣어놓고 실행이 안 돼서 오타만 찾다 보니 시간을 많이 날렸었다.

#### 6.글 삭제, 답글 쓰기, 페이징 기능 구현
주말이라 시간이 많아 다 할 수 있었다.
중간에 페이지가 제대로 안 나와 힘들었지만 금방 해결할 수 있었다.
추가로 페이지에 최대 페이지를 늘리고, 현재 위치에 있는 페이지 버튼을 크게 하여 가독성을 높였으며 또한 처음으로 가는 버튼까지 추가하여 페이지 이동을 많이 하여도 금방 첫 페이지로 올 수 있도록 기능을 넣어 보았다.

#### 7.끝으로
이번에 프로젝트를 하면서 오타가 많이 난다는 걸 깨달았고, 처음으로 MariaDB를 연동하여 사용해 보았는데, 질의문이쿼리문이 내가 알던 Oracle과는 달라서 변경해서 적용하는 것이 조금 힘들었고, 오히려 에러가 많이 나서 공부가 더 많이 되었던 거 같다.
이것으로 짧은 개인 프로젝트를 마치며 다음에는 이 게시판을 좀 더 업그레이드를 해보고 싶다.
***
