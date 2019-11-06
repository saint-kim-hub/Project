<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>단문 메모장</title>
    <link rel="stylesheet" href="./css/main.css">
    <link rel="stylesheet" href="./css/pop.css">
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="./js/main.js"></script>
    <link rel="shortcut icon" href="./common/img/favicon.ico">
    <style>
        @import url('https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean');
        html { 
        background: url(./common/img/bgi.png) no-repeat center center fixed;
        -webkit-background-size: cover;-moz-background-size: cover;-o-background-size: cover;
        background-size: cover;
        scroll-behavior: smooth;
        }
        body { margin: 0; padding: 0;
            font-family: 'Jua', sans-serif;}
        textarea:focus {outline: none;}
        @media screen and (max-width: 500px){
            .jbTitle{
                float: left;
                height: 60px; width: 420px;
            }
            .jbMenu{
                float:left;
                width: 420px;
            }
            section div{
                width: 420px;
            }
            .pageUP{
                margin-left: 350px;
                margin-top: 650px;
            }
            footer{
                width: 420px;
            }
            #popup{
                margin-top: 60px;
            }
            #popmenu {
                width: 95%;
                height: 60%;
            }
            .add{
                left: 35%;
            }
            .exit{
                left: 65%;
            }
            textarea{
                width:365px;
                font-size: 24px;
            }
            #counter{
                margin-left: 180px;
                margin-top: -5px;
            }
        }
    </style>
</head>
<body>
    <!--header 영역-->
    <header class="jbTitle">
        <p><img src="./common/img/logo.png"></p>
    </header>
    <!--메뉴바-->
      <div class="jbMenu">
        <ul>
            <li><a href="#">HOME</a></li>
            <div id="clock" class="Clock"> CLOCK </div>
            <li id="contents"><a>새글쓰기</a></li>
        </ul>
    </div>
    <!--새글쓰기 팝업창-->
    <div id="popup">
        <div id="popmenu">
            <form action="fileSave.jsp">
	            <div class="join_row">
	                <label for="yy_id">메모글쓰기</label>
	                <div class="int">
	                    <textarea id="Txt" name="Txt" placeholder="메모를 입력하세요." maxlength="299"></textarea>
	                    <span id="counter">###</span>
	                </div>
	                </label>
	            </div>
	            <button type="submit" class="add">저장</button>
	            <div class="exit">닫기</div>
            </form>
        </div>
    </div>
    <!--페이지업 버튼-->
    <div class="pageUP">
      <a href="#"><img src="./common/img/PU.png"></a>
    </div>
    <!--section 영역-->
    <section>
        <div><img src="./common/img/T01.png"></div>
        <div><img src="./common/img/T02.png"></div>
    </section>
    <!--footer 영역-->
    <footer>
        <div>제작자 : </div>
    </footer>
</body>
</html>