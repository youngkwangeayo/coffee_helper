# coffee_helper

<h5>1인프로젝트<h5>


<ul>
  <li> <h3>프로젝트 소개</h3> </li>
      <ul>
        <li>
            <p>
               에스프레소 추출을 사용자입력, 또는 소프트웨어 자동추출 하여 추출상태 정보를 알수있고 추출상태의 시각화, 피드백을 해줍니다.<br>
                 추출한 커피와 피드백정보를 기록 관리 할수있습니다. 
            </p> 
         </li>
         <li><h4>프로젝트준비를하면서 신경쓴점</h4></li> 
            <ul>
                <li>한가지 기능처리를 위해 각 수행별로 메소드를 분리해놓아서 중복코드가 적고 코드가 깔끔하고 변경사항이있어도 관리에 용이다합니다.</li> 
            </ul>     
         <li><h4>커피헬퍼의 장점</h4></li> 
        <ul>
         <li>계속 추출을 해보지않아도 예상결과도 알수있어 낭비되는 재료를 아낄수있다.</li>
         <li>추출정보에대해 시각화로 보기 편하고 오락성도 갖추고있다.</li>  
         <li>본인 추출의 무엇이 잘못된지 알수있게 피드백을 해준다.</li>
          <li>본인 커피추출 정보와 피드백을 관리 할수있어 기록에 용이하다.</li>
          <li>자동추출 소프트웨어의 알고리즘 처리로 터무니없는 가상추출이 없다</li>   
          <li>관리자 모드에서 좋은추출정보의 기준을 수정 가능하다</li>
         </ul> 
      </ul>
   <li> <h4> 프로젝트 정보 </h4> </li>
     <ul>
       <li> SpringBoot Maven </li>
          <li> <h4> Backend </h4></li>
              <ul>
                 <li>Java</li>
                 <li>Spring Security</li>
                 <li>Mybatis</li>
                 <li>OAuth2</li>
                 <li>RestApi</li>
              </ul>
          <li> <h4> Frontend </h4></li>
              <ul>
                 <li>HTML</li>
                 <li>CSS</li>
                 <li>JavaScript</li>
                 <li>ThymeLeaf</li>
                 <li>BootStrap</li>
                 <li>Chart.js</li>
                 <li>AJax</li>
              </ul>    
          <li> <h4> Database </h4></li>
            <ul>
               <li>MySQL</li>
            </ul>
          <li> <h4> server </h4></li>
            <ul>
              <li>TomCat</li>
           </ul>
    </ul>
</ul>
<hr>
<ul>
  <li>
    <h3>ERD<h3>
  </li>
      <img width="501" alt="커피헬퍼 erd" src="https://user-images.githubusercontent.com/120706327/230838929-5aa0b7c8-4903-41ef-a617-d0a0b2f9bef7.png">
      <p> 세로선 우측은 확장성을 위해 넣어두었습니다. </p>
      <ul>
        <li><h4>테이블 소개</h4></li>
          <ul>
            <li>extract_equalse_info</li>
              <ul>
                <li>추출의 비교를 위한 테이블 중 하나입니다. 각각의 퀄럼에 good,over,row 가 저장되어있습니다.</li>
              </ul>
              <li>extract_ment</li>
              <ul>
                <li>추출의 피드백을위해 피드백멘트들이 저장되어있는 테이블입니다. 각추출의 결과를 알기위해 extract_equalse_info 테이블이랑 연관관계가 잡혀있습니다. </li>
              </ul>
              <li>extract</li>
              <ul>
                <li>
                커피 추출 정보를 저장하는 테이블 입니다. 커피의 상태를 알기위해 extract_equalse_info테이블이랑 연관관계가 잡혀있고 어떤 유저의 추출인지 알기위해
                user 테이블과도 연관관계가 잡혀있습니다.
                </li>
              </ul>
              <li>extract_save_ment</li>
              <ul>
                <li>추출의 결과,하나의추출에 다양한 피드백멘트를 저장 하기 위한 테이블입니다. extract_ment와 extract 테이블이 연관관계로 잡혀있습니다.</li>
              </ul>
              <li>best_condition_default</li>
              <ul>
                <li>각조건별로 몇이상 넘어가면 오버되는 수치인지 몇이상 넘어가면 낮은수치인지가 저장되어있어 좋은 추출정보를 알기위해 쓰이는 테이블입니다.</li>
              </ul>
              <li>setting_condition</li>
              <ul>
                <li>best_condition_default 같은 역활이지만 운영자가 셋팅값을 커스텀 해서 적용하기 위한 테이블입니다.</li>
              </ul>
                <li>choice_setting</li>
              <ul>
                <li>관리자가 기본저장된 셋팅값으로 적용해서 사용할것인지 커스텀셋팅값을 적용할것인지 사용,선택을 위한 테이블입니다.</li>
              </ul>
               <li>user</li>
              <ul>
                <li>user의 정보를 담고있는 테이블 입니다.</li>
              </ul>
          </ul>
      </ul>
</ul>  
<hr>    
<ul>
  <li><h3>JobList</h3></li>
  <li><img width="1113" alt="커피헬퍼잡리스트3" src="https://user-images.githubusercontent.com/120706327/231062405-f413457c-c487-4601-a7a0-024e016d3cca.png"></li>
</ul>
<hr>   
<ul>
  <li><h3>기능 설명</h3></li>
    <ul>
        <li>
          <h4>메인페이지</h4>
          <img width="1275" alt="커피헬퍼메인페이지" src="https://user-images.githubusercontent.com/120706327/231067033-41ab8510-f5de-4142-be71-63ac59ecb8e7.png">
          <br>
          <hr>
        </li>
        <li>
          <h4>커피헬퍼의 메인기능<h4>
          <img alt="메인기능 JonList" src="https://user-images.githubusercontent.com/120706327/231065638-41c53d47-167e-42aa-92d8-8bf3ba793295.png">
            <br>
            <hr>
       </li>
       <li>
        <h4>추출시 차트의 변화</h4>
         <img alt="추출시 차트의변화" src="https://user-images.githubusercontent.com/120706327/231069019-4175f55b-94c1-4a0f-9b56-a3e847a640a1.png">
        <br>
         <hr>
       </li>  
       <li>
        <h4>차트에 대한 설명</h4>
         <img alt="차트설명" src="https://user-images.githubusercontent.com/120706327/231076543-4aced39f-902c-4665-a336-6e501918fe10.png">
        <br>
         <hr>
       </li>
       <li>     
        <h4>본인 커피 추출 기록 관리</h4>
         <img alt="본인 커피 추출 기록 관리" src="https://user-images.githubusercontent.com/120706327/231086497-a5bab9b4-fffa-4a65-84da-0b332fd7f7ba.png">
        <br>
         <hr>
       </li>
       <li>     
        <h4>인증과 인가</h4>
         <img alt="인증과 인가" src="https://user-images.githubusercontent.com/120706327/231095536-334f17ad-4acb-450f-8a6b-d4afb0ac4121.png">
        <br>
         <hr>
       </li>      
       <li>     
        <h4>인증</h4>
         <img alt="인증" src="https://user-images.githubusercontent.com/120706327/231324857-832c1391-f3a4-4f8b-94c1-af5ca0a11f5d.png">
        <br>
         <hr>
       </li>         
       <hr>
        <li>     
          <h4>관리자 메인 페이지</h4>
           <img alt="본인 커피 추출 기록 관리" src="https://user-images.githubusercontent.com/120706327/231111068-ff2c7d21-9708-468c-a672-ebcc865903ec.png">
          <br>
          <hr>
       </li>  
        <li>     
          <h4>피드백멘트 입력페이지 (관리자 기능)</h4>
           <img alt="추출결과 조건에 맞는 피드백 멘트입력" src="https://user-images.githubusercontent.com/120706327/231321977-26f64c68-fef7-4bac-8faa-ca4c96e7f11e.png">
          <br>
          <hr>
       </li>
        <li>     
          <h4>추출별 옵션 셋팅 페이지 (관리자 기능)</h4>
           <img alt="추출결과 조건에 맞는 피드백 멘트입력" src="https://user-images.githubusercontent.com/120706327/231322375-f33c5b41-ec83-4979-b58c-64afcd62f20e.png">
          <br>
          <hr>
       </li>
    </ul>
</ul>    


