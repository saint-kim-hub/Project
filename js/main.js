//메뉴바의 상단 고정에 관한 제이쿼리
$( document ).ready( function() {
    var jbOffset = $( '.jbMenu' ).offset();
$( window ).scroll( function() {
    if ( $( document ).scrollTop() > jbOffset.top ) {
        $( '.jbMenu' ).addClass( 'jbFixed' );
        }
    else {
        $( '.jbMenu' ).removeClass( 'jbFixed' );
        }
    });
} );
//팝업창 동작에 관한 제이쿼리
$(document).ready(function(){
    $("#contents").click(function(){
        $("#popup").fadeIn();
    });
    $(".exit").click(function(){
        $("#popup").fadeOut();
    });
});
//새글쓰기 팝업창에 텍스트 입력시 글자수 표시에 관한 제이쿼리
$(function() {
      $('#Txt').keyup(function (e){
          var Txt = $(this).val();
          $('#counter').html(Txt.length + '/300');
      });
      $('#Txt').keyup();
});
//setinterval을 이용한 실시간 시계
setInterval(function(){
    var timer = new Date();
    var h = timer.getHours();
    var m = timer.getMinutes();
    var s = timer.getSeconds();
    document.getElementById('clock').innerHTML = h + ":" + m + ":" + s;
},1000);