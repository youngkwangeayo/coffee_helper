# coffee_helper

<h5>1인프로젝트<h5>


<ul>
  <li> <h3>프로젝트 소개</h3> </li>
      <ul>
        <li>
            <p>
               에스프레소 추출을 사용자입력, 또는 소프트웨어 자동추출 하여 추출상태 정보를 알수있고 추출상태의 시각화, 피드백을 해줍니다.<br>
                 추출한 커피와 피드백정보를 기록 관리 할수있습니다. 
            </p><br>   
         </li>
         <li><h4>프로젝트준비를하면서 신경쓴점</h4></li> 
            <ul>
                <li>한가지 기능처리를 위해 각 수행별로 메소드를 분리해놓아서 중복코드가 적고 코드가 깔끔하고 변경사항이있어도 관리에 용이할수있습니다.</li> 
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
                 <li>oAuth2</li>
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
                 <li>Ajax</li>
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
  <li></li>
</ul>  


