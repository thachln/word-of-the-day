Nếu myworkspace.vn/java bị lỗi khi bấm nút bắt đầu thì trang tự load lại từ đầu thì phải xóa cache trình duyệt trước rồi truy cập lại
Lỗi code trong myworkspace:
  2.1 Dòng 1 có lỗi Package name 'Sum2Number' must match pattern '^[a-z]+(\.[a-z][a-z0-9]*)*$'.; severity = warning: đặt tên package không đúng yêu cầu.
   2.7 Dòng 25 có lỗi Method name 'Sum' must match pattern '^[a-z][a-z0-9][a-zA-Z0-9_]*$'.; severity = warning: đổi tên hàm thành chữ in thường: đặt tên hàm không đúng yêu cầu.
  2.2 Dòng 6 có lỗi Summary javadoc is missing.; severity = warning: thiếu ghi chú java doc, thiếu phần ghi chú java doc ở dòng 6
  
  2.3 Dòng 25 có lỗi Missing a Javadoc comment.; severity = warning: thiếu ghi chú java doc: thiếu 1 java doc ở dòng 25.
  2.4 Dòng 9 có lỗi Unused @param tag for '<s1>'.; severity = warning: @param đặt sai vị trí: @param trong phần ghi chú java doc đặt không đúng vị trí. 
  2.5 Dòng 10 có lỗi Unused @param tag for '<s2>'.; severity = warning: @param đặt sai vị trí: @param trong phần ghi chú java doc đặt không đúng vị trí. 
  2.8 Dòng 26 có lỗi Line contains a tab character.; severity = warning: dòng code ở dòng này có khoảng trắng, mấy dòng khác tương tự.
  2.12 Dòng 29 có lỗi Distance between variable 'maxLen' declaration and its first usage is 8, but allowed 3.  Consider making that variable final if you still need to store its value in advance (before method calls that might have side effects on the original value).; severity = warning: cách tốt nhất nên để biến ở dòng 29 làm biến final.
