// 웹소켓 연결 생성
var socket = new WebSocket("ws://localhost:8080/ws/chat");

// 연결이 열릴 때 실행할 함수 설정
socket.onopen = function(e) {
  console.log("Connection established");
};
// 메시지를 수신할 때 실행할 함수 설정
socket.onmessage = function(event) {
  console.log(`Data received from server: ${event.data}`);
  // chat 텍스트 영역에 메시지 추가
  $('#chat').val(function(i, currentContent) {
    return currentContent + '\n' + event.data;
  });
};

// 메시지 전송 함수
function sendMessage(type, roomId, sender, message) {
  var data = {
    type: type,
    roomId: roomId,
    sender: sender,
    message: message
  };
  socket.send(JSON.stringify(data)); // JSON 객체를 문자열로 변환하여 전송
}
var main = {
    init : function () {
        var _this = this;
        $('#btn-send').on('click', function () {
            _this.send();
        });
    },
    send : function () {
        var message = $('#sendmsg').val();
        var type = "TALK"; // 메시지 타입
        var roomId = "2962a455-f7eb-4231-82aa-d3ea9697a7c1"; // 방 ID
        var sender = "hyerim"; // 보낸 사람 설정
        sendMessage(type, roomId, sender, message); // 메시지 전송
        $('#chat').val(function(i, currentContent) {
            return currentContent + '\n' + sender +':'+ message;
        });
        $('#sendmsg').val('');
      }
};

main.init();